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
    private static volatile int cZP = -1;
    private static volatile int dDk = -1;
    private static final boolean dDo = c.hasLollipop();
    private static volatile b dDp;
    @Nullable
    private ActivityManager dDl;
    private List<ActivityManager.AppTask> dDm;
    @Nullable
    private ArrayList<Integer> dDn;
    private final SparseIntArray dDq = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dDr = new SparseArray<>();

    private b() {
        Application awA = com.baidu.swan.apps.t.a.awA();
        if (awA != null) {
            this.dDl = (ActivityManager) awA.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aLZ() {
        if (dDp == null) {
            synchronized (b.class) {
                if (dDp == null) {
                    dDp = new b();
                }
            }
        }
        return dDp;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ap.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aMc();
                if (aVar != null && "1202000800000000".equals(aVar.ayD())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.pE("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dDn = swanTaskDeadEvent.aCb();
                        SparseArray<SwanTaskDeadEvent> aCc = swanTaskDeadEvent.aCc();
                        if (aCc != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= aCc.size()) {
                                    break;
                                }
                                int keyAt = aCc.keyAt(i3);
                                SwanTaskDeadEvent valueAt = aCc.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dDr.put(keyAt, valueAt);
                                    b.this.dDq.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.m(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dDn);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.m(aVar.getAppId(), -1, i);
                }
                b.this.dDn = b.this.aMe();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dDn);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aMe = aMe();
        if (!j(this.dDn, aMe)) {
            aMc();
            m(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aMe + ", mLaunchTaskList=" + this.dDn + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dDn = aMe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).gg(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dDn != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dDq.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dDn.remove(Integer.valueOf(i2));
                    this.dDq.delete(string.hashCode());
                    this.dDr.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dDn.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dDn.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dDn.size()) {
                        break;
                    } else if (this.dDn.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dDn.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dDr.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dDq.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dDr.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dDn);
            }
        }
    }

    public static boolean aMa() {
        if (cZP == -1) {
            synchronized (b.class) {
                if (cZP == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aEz().getBoolean("swan_page_stack_optimize", false)) {
                        cZP = 1;
                        return true;
                    }
                    cZP = (dDo && com.baidu.swan.apps.t.a.awD().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cZP == 1;
    }

    public static boolean aMb() {
        if (dDk == -1) {
            dDk = com.baidu.swan.apps.t.a.awD().getSwitch("swan_move_task_optimize", 1);
        }
        return dDk == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dDl != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dDl.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dDr.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dDr.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().pq(swanTaskDeadEvent.getAppId())).pv(swanTaskDeadEvent.aCa())).pt("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aCb = swanTaskDeadEvent.aCb();
                            if (aCb != null && !aCb.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aCb.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dDr.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.atl().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dDr.size());
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

    public synchronized boolean gQ(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dDn;
        if (z) {
            arrayList = aMe();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dDl != null) {
            this.dDm = null;
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

    public void aMc() {
        this.dDr.clear();
        this.dDq.clear();
    }

    private boolean B(int i, boolean z) {
        if (dDo) {
            List<ActivityManager.AppTask> list = this.dDm;
            if ((!z || list == null) && this.dDl != null) {
                list = this.dDl.getAppTasks();
                if (z) {
                    this.dDm = list;
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

    public boolean lm(int i) {
        if (aMa() && dDo && this.dDl != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dDl.getAppTasks()) {
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

    public int aMd() {
        if (!dDo || this.dDl == null) {
            return -1;
        }
        try {
            return a(this.dDl.getAppTasks().get(0));
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
    public ArrayList<Integer> aMe() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dDo && this.dDl != null && (size = (appTasks = this.dDl.getAppTasks()).size()) >= 2) {
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
        if (aMa()) {
            aLZ().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aMa()) {
            b aLZ = aLZ();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aLZ.dDn != null && aLZ.dDn.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aLZ.dDq.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aLZ.dDr.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afM;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c aoB;
        if (aMa() && swanAppActivity != null && (afM = swanAppActivity.afM()) != null && (eVar = (com.baidu.swan.apps.core.d.e) afM.q(com.baidu.swan.apps.core.d.e.class)) != null && (aoB = eVar.aoB()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.afV(), swanAppActivity.getTaskId(), aoB.getPage() + "?" + aoB.getParams(), this.dDn));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).gg(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.afV() + ", " + swanAppActivity.getTaskId());
            }
        }
    }

    private boolean j(List<Integer> list, List<Integer> list2) {
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
