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
    private static volatile int cLA = -1;
    private static volatile int doS = -1;
    private static final boolean doW = c.hasLollipop();
    private static volatile b doX;
    @Nullable
    private ActivityManager doT;
    private List<ActivityManager.AppTask> doU;
    @Nullable
    private ArrayList<Integer> doV;
    private final SparseIntArray doY = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> doZ = new SparseArray<>();

    private b() {
        Application asf = com.baidu.swan.apps.t.a.asf();
        if (asf != null) {
            this.doT = (ActivityManager) asf.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aHF() {
        if (doX == null) {
            synchronized (b.class) {
                if (doX == null) {
                    doX = new b();
                }
            }
        }
        return doX;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ap.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aHI();
                if (aVar != null && "1202000800000000".equals(aVar.auj())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.oX("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.doV = swanTaskDeadEvent.axH();
                        SparseArray<SwanTaskDeadEvent> axI = swanTaskDeadEvent.axI();
                        if (axI != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= axI.size()) {
                                    break;
                                }
                                int keyAt = axI.keyAt(i3);
                                SwanTaskDeadEvent valueAt = axI.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.doZ.put(keyAt, valueAt);
                                    b.this.doY.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.l(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.doV);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.l(aVar.getAppId(), -1, i);
                }
                b.this.doV = b.this.aHK();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.doV);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aHK = aHK();
        if (!g(this.doV, aHK)) {
            aHI();
            l(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aHK + ", mLaunchTaskList=" + this.doV + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.doV = aHK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).fK(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.doV != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.doY.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.doV.remove(Integer.valueOf(i2));
                    this.doY.delete(string.hashCode());
                    this.doZ.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.doV.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.doV.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.doV.size()) {
                        break;
                    } else if (this.doV.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.doV.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.doZ.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.doY.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.doZ.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.doV);
            }
        }
    }

    public static boolean aHG() {
        if (cLA == -1) {
            synchronized (b.class) {
                if (cLA == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aAf().getBoolean("swan_page_stack_optimize", false)) {
                        cLA = 1;
                        return true;
                    }
                    cLA = (doW && com.baidu.swan.apps.t.a.asi().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cLA == 1;
    }

    public static boolean aHH() {
        if (doS == -1) {
            doS = com.baidu.swan.apps.t.a.asi().getSwitch("swan_move_task_optimize", 1);
        }
        return doS == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.doT != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.doT.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.doZ.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.doZ.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().oJ(swanTaskDeadEvent.getAppId())).oO(swanTaskDeadEvent.axG())).oM("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> axH = swanTaskDeadEvent.axH();
                            if (axH != null && !axH.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = axH.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.doZ.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.aoP().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.doZ.size());
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

    public synchronized boolean gu(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.doV;
        if (z) {
            arrayList = aHK();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.doT != null) {
            this.doU = null;
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

    public void aHI() {
        this.doZ.clear();
        this.doY.clear();
    }

    private boolean B(int i, boolean z) {
        if (doW) {
            List<ActivityManager.AppTask> list = this.doU;
            if ((!z || list == null) && this.doT != null) {
                list = this.doT.getAppTasks();
                if (z) {
                    this.doU = list;
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

    public boolean kR(int i) {
        if (aHG() && doW && this.doT != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.doT.getAppTasks()) {
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

    public int aHJ() {
        if (!doW || this.doT == null) {
            return -1;
        }
        try {
            return a(this.doT.getAppTasks().get(0));
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
    public ArrayList<Integer> aHK() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (doW && this.doT != null && (size = (appTasks = this.doT.getAppTasks()).size()) >= 2) {
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
        if (aHG()) {
            aHF().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aHG()) {
            b aHF = aHF();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aHF.doV != null && aHF.doV.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aHF.doY.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aHF.doZ.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f abs;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c akh;
        if (aHG() && swanAppActivity != null && (abs = swanAppActivity.abs()) != null && (eVar = (com.baidu.swan.apps.core.d.e) abs.q(com.baidu.swan.apps.core.d.e.class)) != null && (akh = eVar.akh()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.abB(), swanAppActivity.getTaskId(), akh.getPage() + "?" + akh.getParams(), this.doV));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).fK(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.abB() + ", " + swanAppActivity.getTaskId());
            }
        }
    }

    private boolean g(List<Integer> list, List<Integer> list2) {
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
