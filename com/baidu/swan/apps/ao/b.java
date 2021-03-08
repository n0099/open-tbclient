package com.baidu.swan.apps.ao;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
/* loaded from: classes8.dex */
public class b {
    private static volatile b dQe;
    @Nullable
    private ActivityManager dQa;
    private List<ActivityManager.AppTask> dQb;
    @Nullable
    private ArrayList<Integer> dQc;
    private final SparseIntArray dQf = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dQg = new SparseArray<>();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int diY = -1;
    private static volatile int dPZ = -1;
    private static final boolean dQd = c.hasLollipop();

    private b() {
        Application awZ = com.baidu.swan.apps.t.a.awZ();
        if (awZ != null) {
            this.dQa = (ActivityManager) awZ.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aNs() {
        if (dQe == null) {
            synchronized (b.class) {
                if (dQe == null) {
                    dQe = new b();
                }
            }
        }
        return dQe;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ao.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aNv();
                if (aVar != null && "1202000800000000".equals(aVar.azd())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.pm("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dQc = swanTaskDeadEvent.aCC();
                        SparseArray<SwanTaskDeadEvent> aCD = swanTaskDeadEvent.aCD();
                        if (aCD != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= aCD.size()) {
                                    break;
                                }
                                int keyAt = aCD.keyAt(i3);
                                SwanTaskDeadEvent valueAt = aCD.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dQg.put(keyAt, valueAt);
                                    b.this.dQf.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.n(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dQc);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.n(aVar.getAppId(), -1, i);
                }
                b.this.dQc = b.this.aNx();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dQc);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aNx = aNx();
        if (!j(this.dQc, aNx)) {
            aNv();
            n(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aNx + ", mLaunchTaskList=" + this.dQc + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dQc = aNx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).gF(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dQc != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dQf.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dQc.remove(Integer.valueOf(i2));
                    this.dQf.delete(string.hashCode());
                    this.dQg.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dQc.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dQc.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dQc.size()) {
                        break;
                    } else if (this.dQc.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dQc.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dQg.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dQf.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dQg.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dQc);
            }
        }
    }

    public static boolean aNt() {
        if (diY == -1) {
            synchronized (b.class) {
                if (diY == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aEX().getBoolean("swan_page_stack_optimize", false)) {
                        diY = 1;
                        return true;
                    }
                    diY = (dQd && com.baidu.swan.apps.t.a.axc().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return diY == 1;
    }

    public static boolean aNu() {
        if (dPZ == -1) {
            dPZ = com.baidu.swan.apps.t.a.axc().getSwitch("swan_move_task_optimize", 1);
        }
        return dPZ == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dQa != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dQa.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dQg.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dQg.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().oY(swanTaskDeadEvent.getAppId())).pd(swanTaskDeadEvent.aCB())).pb("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aCC = swanTaskDeadEvent.aCC();
                            if (aCC != null && !aCC.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aCC.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dQg.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.b(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.atL().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dQg.size());
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

    public synchronized boolean hy(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dQc;
        if (z) {
            arrayList = aNx();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dQa != null) {
            this.dQb = null;
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

    public void aNv() {
        this.dQg.clear();
        this.dQf.clear();
    }

    private boolean B(int i, boolean z) {
        if (dQd) {
            List<ActivityManager.AppTask> list = this.dQb;
            if ((!z || list == null) && this.dQa != null) {
                list = this.dQa.getAppTasks();
                if (z) {
                    this.dQb = list;
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

    public boolean kj(int i) {
        if (aNt() && dQd && this.dQa != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dQa.getAppTasks()) {
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

    public int aNw() {
        if (!dQd || this.dQa == null) {
            return -1;
        }
        try {
            return a(this.dQa.getAppTasks().get(0));
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
    public ArrayList<Integer> aNx() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dQd && this.dQa != null && (size = (appTasks = this.dQa.getAppTasks()).size()) >= 2) {
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
        if (aNt()) {
            aNs().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aNt()) {
            b aNs = aNs();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aNs.dQc != null && aNs.dQc.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aNs.dQf.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aNs.dQg.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f aga;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c aoZ;
        if (aNt() && swanAppActivity != null && (aga = swanAppActivity.aga()) != null && (eVar = (com.baidu.swan.apps.core.d.e) aga.j(com.baidu.swan.apps.core.d.e.class)) != null && (aoZ = eVar.aoZ()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.agj(), swanAppActivity.getTaskId(), aoZ.getPage() + "?" + aoZ.getParams(), this.dQc));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).gF(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.agj() + ", " + swanAppActivity.getTaskId());
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
