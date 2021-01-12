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
    private static volatile b dMz;
    private final SparseIntArray dMA = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dMB = new SparseArray<>();
    @Nullable
    private ActivityManager dMv;
    private List<ActivityManager.AppTask> dMw;
    @Nullable
    private ArrayList<Integer> dMx;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int dfj = -1;
    private static volatile int dMu = -1;
    private static final boolean dMy = c.hasLollipop();

    private b() {
        Application awy = com.baidu.swan.apps.t.a.awy();
        if (awy != null) {
            this.dMv = (ActivityManager) awy.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aMW() {
        if (dMz == null) {
            synchronized (b.class) {
                if (dMz == null) {
                    dMz = new b();
                }
            }
        }
        return dMz;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ao.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aMZ();
                if (aVar != null && "1202000800000000".equals(aVar.ayC())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.oN("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dMx = swanTaskDeadEvent.aCc();
                        SparseArray<SwanTaskDeadEvent> aCd = swanTaskDeadEvent.aCd();
                        if (aCd != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= aCd.size()) {
                                    break;
                                }
                                int keyAt = aCd.keyAt(i3);
                                SwanTaskDeadEvent valueAt = aCd.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dMB.put(keyAt, valueAt);
                                    b.this.dMA.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.n(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dMx);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.n(aVar.getAppId(), -1, i);
                }
                b.this.dMx = b.this.aNb();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dMx);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aNb = aNb();
        if (!l(this.dMx, aNb)) {
            aMZ();
            n(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aNb + ", mLaunchTaskList=" + this.dMx + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dMx = aNb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).gD(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dMx != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dMA.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dMx.remove(Integer.valueOf(i2));
                    this.dMA.delete(string.hashCode());
                    this.dMB.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dMx.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dMx.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dMx.size()) {
                        break;
                    } else if (this.dMx.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dMx.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dMB.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dMA.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dMB.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dMx);
            }
        }
    }

    public static boolean aMX() {
        if (dfj == -1) {
            synchronized (b.class) {
                if (dfj == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aEz().getBoolean("swan_page_stack_optimize", false)) {
                        dfj = 1;
                        return true;
                    }
                    dfj = (dMy && com.baidu.swan.apps.t.a.awB().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return dfj == 1;
    }

    public static boolean aMY() {
        if (dMu == -1) {
            dMu = com.baidu.swan.apps.t.a.awB().getSwitch("swan_move_task_optimize", 1);
        }
        return dMu == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dMv != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dMv.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dMB.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dMB.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().oz(swanTaskDeadEvent.getAppId())).oE(swanTaskDeadEvent.aCb())).oC("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aCc = swanTaskDeadEvent.aCc();
                            if (aCc != null && !aCc.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aCc.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dMB.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.c(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.atk().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dMB.size());
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

    public synchronized boolean hw(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dMx;
        if (z) {
            arrayList = aNb();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dMv != null) {
            this.dMw = null;
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

    public void aMZ() {
        this.dMB.clear();
        this.dMA.clear();
    }

    private boolean B(int i, boolean z) {
        if (dMy) {
            List<ActivityManager.AppTask> list = this.dMw;
            if ((!z || list == null) && this.dMv != null) {
                list = this.dMv.getAppTasks();
                if (z) {
                    this.dMw = list;
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

    public boolean kf(int i) {
        if (aMX() && dMy && this.dMv != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dMv.getAppTasks()) {
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

    public int aNa() {
        if (!dMy || this.dMv == null) {
            return -1;
        }
        try {
            return a(this.dMv.getAppTasks().get(0));
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
    public ArrayList<Integer> aNb() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dMy && this.dMv != null && (size = (appTasks = this.dMv.getAppTasks()).size()) >= 2) {
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
        if (aMX()) {
            aMW().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aMX()) {
            b aMW = aMW();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aMW.dMx != null && aMW.dMx.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aMW.dMA.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aMW.dMB.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afz;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c aoy;
        if (aMX() && swanAppActivity != null && (afz = swanAppActivity.afz()) != null && (eVar = (com.baidu.swan.apps.core.d.e) afz.j(com.baidu.swan.apps.core.d.e.class)) != null && (aoy = eVar.aoy()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.afI(), swanAppActivity.getTaskId(), aoy.getPage() + "?" + aoy.getParams(), this.dMx));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).gD(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.afI() + ", " + swanAppActivity.getTaskId());
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
