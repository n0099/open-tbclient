package com.baidu.swan.apps.ap;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanRelayActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.model.SwanTaskDeadEvent;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.u.c.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int cTW = -1;
    private static volatile int dxs = -1;
    private static final boolean dxw = c.hasLollipop();
    private static volatile b dxx;
    @Nullable
    private ActivityManager dxt;
    private List<ActivityManager.AppTask> dxu;
    @Nullable
    private ArrayList<Integer> dxv;
    private final SparseIntArray dxy = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dxz = new SparseArray<>();

    private b() {
        Application aua = com.baidu.swan.apps.t.a.aua();
        if (aua != null) {
            this.dxt = (ActivityManager) aua.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aJz() {
        if (dxx == null) {
            synchronized (b.class) {
                if (dxx == null) {
                    dxx = new b();
                }
            }
        }
        return dxx;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ap.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aJC();
                if (aVar != null && "1202000800000000".equals(aVar.awd())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.pq("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dxv = swanTaskDeadEvent.azB();
                        SparseArray<SwanTaskDeadEvent> azC = swanTaskDeadEvent.azC();
                        if (azC != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= azC.size()) {
                                    break;
                                }
                                int keyAt = azC.keyAt(i3);
                                SwanTaskDeadEvent valueAt = azC.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dxz.put(keyAt, valueAt);
                                    b.this.dxy.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.m(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dxv);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.m(aVar.getAppId(), -1, i);
                }
                b.this.dxv = b.this.aJE();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dxv);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aJE = aJE();
        if (!i(this.dxv, aJE)) {
            aJC();
            m(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aJE + ", mLaunchTaskList=" + this.dxv + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dxv = aJE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).fX(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dxv != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dxy.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dxv.remove(Integer.valueOf(i2));
                    this.dxy.delete(string.hashCode());
                    this.dxz.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dxv.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dxv.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dxv.size()) {
                        break;
                    } else if (this.dxv.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dxv.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dxz.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dxy.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dxz.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dxv);
            }
        }
    }

    public static boolean aJA() {
        if (cTW == -1) {
            synchronized (b.class) {
                if (cTW == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aBZ().getBoolean("swan_page_stack_optimize", false)) {
                        cTW = 1;
                        return true;
                    }
                    cTW = (dxw && com.baidu.swan.apps.t.a.aud().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cTW == 1;
    }

    public static boolean aJB() {
        if (dxs == -1) {
            dxs = com.baidu.swan.apps.t.a.aud().getSwitch("swan_move_task_optimize", 1);
        }
        return dxs == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dxt != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dxt.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dxz.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dxz.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().pc(swanTaskDeadEvent.getAppId())).ph(swanTaskDeadEvent.azA())).pf("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> azB = swanTaskDeadEvent.azB();
                            if (azB != null && !azB.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = azB.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dxz.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.aqK().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dxz.size());
                    }
                    z3 = false;
                }
            }
        }
        z3 = false;
        return z3;
    }

    public boolean b(@NonNull Context context, int i, boolean z) {
        try {
            Intent intent = new Intent(context, SwanRelayActivity.class);
            intent.putExtra("key_task_id", i);
            intent.setFlags(268435456);
            PendingIntent.getActivity(context, 0, intent, 134217728).send();
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanActivityTaskManager", "moveTaskToFrontByActivity", e);
            }
            return c(i, z, false);
        }
    }

    public synchronized boolean gH(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dxv;
        if (z) {
            arrayList = aJE();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dxt != null) {
            this.dxu = null;
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                if (c(it.next().intValue(), true, true)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    public void aJC() {
        this.dxz.clear();
        this.dxy.clear();
    }

    private boolean B(int i, boolean z) {
        if (dxw) {
            List<ActivityManager.AppTask> list = this.dxu;
            if ((!z || list == null) && this.dxt != null) {
                list = this.dxt.getAppTasks();
                if (z) {
                    this.dxu = list;
                }
            }
            if (list != null) {
                for (ActivityManager.AppTask appTask : list) {
                    if (i == a(appTask)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean lc(int i) {
        if (aJA() && dxw && this.dxt != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dxt.getAppTasks()) {
                if (i2 > 0 && a(appTask) == i) {
                    appTask.finishAndRemoveTask();
                    return true;
                }
                i2++;
            }
            return false;
        }
        return false;
    }

    public int aJD() {
        if (!dxw || this.dxt == null) {
            return -1;
        }
        try {
            return a(this.dxt.getAppTasks().get(0));
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanActivityTaskManager", "getTopTaskId", e);
            }
            return -1;
        }
    }

    @RequiresApi(api = 21)
    private int a(ActivityManager.AppTask appTask) {
        if (appTask != null) {
            try {
                ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                if (taskInfo != null) {
                    return taskInfo.id;
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanActivityTaskManager", "getTaskId", e);
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ArrayList<Integer> aJE() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dxw && this.dxt != null && (size = (appTasks = this.dxt.getAppTasks()).size()) >= 2) {
            ArrayList<Integer> arrayList = new ArrayList<>(size - 1);
            for (int i = 1; i < size; i++) {
                int a2 = a(appTasks.get(i));
                if (a2 != -1) {
                    arrayList.add(Integer.valueOf(a2));
                }
            }
            return arrayList;
        }
        return null;
    }

    public static void O(@NonNull Message message) {
        if (aJA()) {
            aJz().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aJA()) {
            b aJz = aJz();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aJz.dxv != null && aJz.dxv.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aJz.dxy.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aJz.dxz.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f adm;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c amb;
        if (aJA() && swanAppActivity != null && (adm = swanAppActivity.adm()) != null && (eVar = (com.baidu.swan.apps.core.d.e) adm.q(com.baidu.swan.apps.core.d.e.class)) != null && (amb = eVar.amb()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.adv(), swanAppActivity.getTaskId(), amb.getPage() + "?" + amb.getParams(), this.dxv));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).fX(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.adv() + ", " + swanAppActivity.getTaskId());
            }
        }
    }

    private boolean i(List<Integer> list, List<Integer> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(String.valueOf(list.get(i)), String.valueOf(list2.get(i)))) {
                return false;
            }
        }
        return true;
    }
}
