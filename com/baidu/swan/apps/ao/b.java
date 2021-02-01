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
/* loaded from: classes9.dex */
public class b {
    private static volatile b dOD;
    private List<ActivityManager.AppTask> dOA;
    @Nullable
    private ArrayList<Integer> dOB;
    private final SparseIntArray dOE = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dOF = new SparseArray<>();
    @Nullable
    private ActivityManager dOz;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int dhu = -1;
    private static volatile int dOy = -1;
    private static final boolean dOC = c.hasLollipop();

    private b() {
        Application awW = com.baidu.swan.apps.t.a.awW();
        if (awW != null) {
            this.dOz = (ActivityManager) awW.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aNp() {
        if (dOD == null) {
            synchronized (b.class) {
                if (dOD == null) {
                    dOD = new b();
                }
            }
        }
        return dOD;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ao.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aNs();
                if (aVar != null && "1202000800000000".equals(aVar.aza())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.pf("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dOB = swanTaskDeadEvent.aCz();
                        SparseArray<SwanTaskDeadEvent> aCA = swanTaskDeadEvent.aCA();
                        if (aCA != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= aCA.size()) {
                                    break;
                                }
                                int keyAt = aCA.keyAt(i3);
                                SwanTaskDeadEvent valueAt = aCA.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dOF.put(keyAt, valueAt);
                                    b.this.dOE.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.n(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dOB);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.n(aVar.getAppId(), -1, i);
                }
                b.this.dOB = b.this.aNu();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dOB);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aNu = aNu();
        if (!k(this.dOB, aNu)) {
            aNs();
            n(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aNu + ", mLaunchTaskList=" + this.dOB + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dOB = aNu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).gF(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dOB != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dOE.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dOB.remove(Integer.valueOf(i2));
                    this.dOE.delete(string.hashCode());
                    this.dOF.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dOB.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dOB.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dOB.size()) {
                        break;
                    } else if (this.dOB.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dOB.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dOF.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dOE.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dOF.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dOB);
            }
        }
    }

    public static boolean aNq() {
        if (dhu == -1) {
            synchronized (b.class) {
                if (dhu == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aEU().getBoolean("swan_page_stack_optimize", false)) {
                        dhu = 1;
                        return true;
                    }
                    dhu = (dOC && com.baidu.swan.apps.t.a.awZ().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return dhu == 1;
    }

    public static boolean aNr() {
        if (dOy == -1) {
            dOy = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_move_task_optimize", 1);
        }
        return dOy == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dOz != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dOz.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dOF.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dOF.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().oR(swanTaskDeadEvent.getAppId())).oW(swanTaskDeadEvent.aCy())).oU("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aCz = swanTaskDeadEvent.aCz();
                            if (aCz != null && !aCz.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aCz.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dOF.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.c(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.atI().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dOF.size());
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
        ArrayList<Integer> arrayList = this.dOB;
        if (z) {
            arrayList = aNu();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dOz != null) {
            this.dOA = null;
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

    public void aNs() {
        this.dOF.clear();
        this.dOE.clear();
    }

    private boolean B(int i, boolean z) {
        if (dOC) {
            List<ActivityManager.AppTask> list = this.dOA;
            if ((!z || list == null) && this.dOz != null) {
                list = this.dOz.getAppTasks();
                if (z) {
                    this.dOA = list;
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

    public boolean ki(int i) {
        if (aNq() && dOC && this.dOz != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dOz.getAppTasks()) {
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

    public int aNt() {
        if (!dOC || this.dOz == null) {
            return -1;
        }
        try {
            return a(this.dOz.getAppTasks().get(0));
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
    public ArrayList<Integer> aNu() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dOC && this.dOz != null && (size = (appTasks = this.dOz.getAppTasks()).size()) >= 2) {
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
        if (aNq()) {
            aNp().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aNq()) {
            b aNp = aNp();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aNp.dOB != null && aNp.dOB.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aNp.dOE.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aNp.dOF.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afX;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c aoW;
        if (aNq() && swanAppActivity != null && (afX = swanAppActivity.afX()) != null && (eVar = (com.baidu.swan.apps.core.d.e) afX.j(com.baidu.swan.apps.core.d.e.class)) != null && (aoW = eVar.aoW()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.agg(), swanAppActivity.getTaskId(), aoW.getPage() + "?" + aoW.getParams(), this.dOB));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).gF(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.agg() + ", " + swanAppActivity.getTaskId());
            }
        }
    }

    private boolean k(List<Integer> list, List<Integer> list2) {
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
