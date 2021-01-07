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
    private static volatile b dRl;
    @Nullable
    private ActivityManager dRh;
    private List<ActivityManager.AppTask> dRi;
    @Nullable
    private ArrayList<Integer> dRj;
    private final SparseIntArray dRm = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dRn = new SparseArray<>();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int djY = -1;
    private static volatile int dRg = -1;
    private static final boolean dRk = c.hasLollipop();

    private b() {
        Application aAs = com.baidu.swan.apps.t.a.aAs();
        if (aAs != null) {
            this.dRh = (ActivityManager) aAs.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aQQ() {
        if (dRl == null) {
            synchronized (b.class) {
                if (dRl == null) {
                    dRl = new b();
                }
            }
        }
        return dRl;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ao.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aQT();
                if (aVar != null && "1202000800000000".equals(aVar.aCw())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.pY("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dRj = swanTaskDeadEvent.aFW();
                        SparseArray<SwanTaskDeadEvent> aFX = swanTaskDeadEvent.aFX();
                        if (aFX != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= aFX.size()) {
                                    break;
                                }
                                int keyAt = aFX.keyAt(i3);
                                SwanTaskDeadEvent valueAt = aFX.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dRn.put(keyAt, valueAt);
                                    b.this.dRm.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.n(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dRj);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.n(aVar.getAppId(), -1, i);
                }
                b.this.dRj = b.this.aQV();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dRj);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aQV = aQV();
        if (!l(this.dRj, aQV)) {
            aQT();
            n(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aQV + ", mLaunchTaskList=" + this.dRj + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dRj = aQV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aIY().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).gH(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dRj != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dRm.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dRj.remove(Integer.valueOf(i2));
                    this.dRm.delete(string.hashCode());
                    this.dRn.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dRj.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dRj.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dRj.size()) {
                        break;
                    } else if (this.dRj.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dRj.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dRn.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dRm.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dRn.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dRj);
            }
        }
    }

    public static boolean aQR() {
        if (djY == -1) {
            synchronized (b.class) {
                if (djY == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aIt().getBoolean("swan_page_stack_optimize", false)) {
                        djY = 1;
                        return true;
                    }
                    djY = (dRk && com.baidu.swan.apps.t.a.aAv().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return djY == 1;
    }

    public static boolean aQS() {
        if (dRg == -1) {
            dRg = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_move_task_optimize", 1);
        }
        return dRg == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dRh != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dRh.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dRn.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dRn.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().pK(swanTaskDeadEvent.getAppId())).pP(swanTaskDeadEvent.aFV())).pN("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aFW = swanTaskDeadEvent.aFW();
                            if (aFW != null && !aFW.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aFW.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dRn.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.c(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.axe().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dRn.size());
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

    public synchronized boolean hA(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dRj;
        if (z) {
            arrayList = aQV();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dRh != null) {
            this.dRi = null;
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

    public void aQT() {
        this.dRn.clear();
        this.dRm.clear();
    }

    private boolean B(int i, boolean z) {
        if (dRk) {
            List<ActivityManager.AppTask> list = this.dRi;
            if ((!z || list == null) && this.dRh != null) {
                list = this.dRh.getAppTasks();
                if (z) {
                    this.dRi = list;
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

    public boolean lL(int i) {
        if (aQR() && dRk && this.dRh != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dRh.getAppTasks()) {
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

    public int aQU() {
        if (!dRk || this.dRh == null) {
            return -1;
        }
        try {
            return a(this.dRh.getAppTasks().get(0));
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
    public ArrayList<Integer> aQV() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dRk && this.dRh != null && (size = (appTasks = this.dRh.getAppTasks()).size()) >= 2) {
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
        if (aQR()) {
            aQQ().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aQR()) {
            b aQQ = aQQ();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aQQ.dRj != null && aQQ.dRj.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aQQ.dRm.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aQQ.dRn.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f ajt;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c asu;
        if (aQR() && swanAppActivity != null && (ajt = swanAppActivity.ajt()) != null && (eVar = (com.baidu.swan.apps.core.d.e) ajt.j(com.baidu.swan.apps.core.d.e.class)) != null && (asu = eVar.asu()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.ajC(), swanAppActivity.getTaskId(), asu.getPage() + "?" + asu.getParams(), this.dRj));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aIY().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).gH(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.ajC() + ", " + swanAppActivity.getTaskId());
            }
        }
    }

    private boolean l(List<Integer> list, List<Integer> list2) {
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
