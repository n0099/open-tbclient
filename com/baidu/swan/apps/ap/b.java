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
/* loaded from: classes25.dex */
public class b {
    private static volatile b dIG;
    @Nullable
    private ActivityManager dIC;
    private List<ActivityManager.AppTask> dID;
    @Nullable
    private ArrayList<Integer> dIE;
    private final SparseIntArray dIH = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dII = new SparseArray<>();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int dfe = -1;
    private static volatile int dIB = -1;
    private static final boolean dIF = c.hasLollipop();

    private b() {
        Application aza = com.baidu.swan.apps.t.a.aza();
        if (aza != null) {
            this.dIC = (ActivityManager) aza.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aOy() {
        if (dIG == null) {
            synchronized (b.class) {
                if (dIG == null) {
                    dIG = new b();
                }
            }
        }
        return dIG;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ap.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aOB();
                if (aVar != null && "1202000800000000".equals(aVar.aBe())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.qf("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dIE = swanTaskDeadEvent.aEC();
                        SparseArray<SwanTaskDeadEvent> aED = swanTaskDeadEvent.aED();
                        if (aED != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= aED.size()) {
                                    break;
                                }
                                int keyAt = aED.keyAt(i3);
                                SwanTaskDeadEvent valueAt = aED.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dII.put(keyAt, valueAt);
                                    b.this.dIH.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.n(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dIE);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.n(aVar.getAppId(), -1, i);
                }
                b.this.dIE = b.this.aOD();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dIE);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aOD = aOD();
        if (!j(this.dIE, aOD)) {
            aOB();
            n(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aOD + ", mLaunchTaskList=" + this.dIE + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dIE = aOD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).gy(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dIE != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dIH.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dIE.remove(Integer.valueOf(i2));
                    this.dIH.delete(string.hashCode());
                    this.dII.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dIE.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dIE.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dIE.size()) {
                        break;
                    } else if (this.dIE.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dIE.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dII.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dIH.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dII.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dIE);
            }
        }
    }

    public static boolean aOz() {
        if (dfe == -1) {
            synchronized (b.class) {
                if (dfe == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aGZ().getBoolean("swan_page_stack_optimize", false)) {
                        dfe = 1;
                        return true;
                    }
                    dfe = (dIF && com.baidu.swan.apps.t.a.azd().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return dfe == 1;
    }

    public static boolean aOA() {
        if (dIB == -1) {
            dIB = com.baidu.swan.apps.t.a.azd().getSwitch("swan_move_task_optimize", 1);
        }
        return dIB == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dIC != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dIC.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dII.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dII.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().pR(swanTaskDeadEvent.getAppId())).pW(swanTaskDeadEvent.aEB())).pU("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aEC = swanTaskDeadEvent.aEC();
                            if (aEC != null && !aEC.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aEC.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dII.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.avL().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dII.size());
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

    public synchronized boolean hi(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dIE;
        if (z) {
            arrayList = aOD();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dIC != null) {
            this.dID = null;
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

    public void aOB() {
        this.dII.clear();
        this.dIH.clear();
    }

    private boolean B(int i, boolean z) {
        if (dIF) {
            List<ActivityManager.AppTask> list = this.dID;
            if ((!z || list == null) && this.dIC != null) {
                list = this.dIC.getAppTasks();
                if (z) {
                    this.dID = list;
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

    public boolean lG(int i) {
        if (aOz() && dIF && this.dIC != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dIC.getAppTasks()) {
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

    public int aOC() {
        if (!dIF || this.dIC == null) {
            return -1;
        }
        try {
            return a(this.dIC.getAppTasks().get(0));
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
    public ArrayList<Integer> aOD() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dIF && this.dIC != null && (size = (appTasks = this.dIC.getAppTasks()).size()) >= 2) {
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
        if (aOz()) {
            aOy().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aOz()) {
            b aOy = aOy();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aOy.dIE != null && aOy.dIE.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aOy.dIH.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aOy.dII.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f aim;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c arb;
        if (aOz() && swanAppActivity != null && (aim = swanAppActivity.aim()) != null && (eVar = (com.baidu.swan.apps.core.d.e) aim.q(com.baidu.swan.apps.core.d.e.class)) != null && (arb = eVar.arb()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.aiv(), swanAppActivity.getTaskId(), arb.getPage() + "?" + arb.getParams(), this.dIE));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).gy(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.aiv() + ", " + swanAppActivity.getTaskId());
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
