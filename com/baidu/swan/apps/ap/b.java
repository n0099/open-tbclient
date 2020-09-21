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
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int czv = -1;
    private static volatile int dcJ = -1;
    private static final boolean dcN = c.hasLollipop();
    private static volatile b dcO;
    @Nullable
    private ActivityManager dcK;
    private List<ActivityManager.AppTask> dcL;
    @Nullable
    private ArrayList<Integer> dcM;
    private final SparseIntArray dcP = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dcQ = new SparseArray<>();

    private b() {
        Application apu = com.baidu.swan.apps.t.a.apu();
        if (apu != null) {
            this.dcK = (ActivityManager) apu.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aEW() {
        if (dcO == null) {
            synchronized (b.class) {
                if (dcO == null) {
                    dcO = new b();
                }
            }
        }
        return dcO;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ap.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aEZ();
                if (aVar != null && "1202000800000000".equals(aVar.arx())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.ok("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dcM = swanTaskDeadEvent.auW();
                        SparseArray<SwanTaskDeadEvent> auX = swanTaskDeadEvent.auX();
                        if (auX != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= auX.size()) {
                                    break;
                                }
                                int keyAt = auX.keyAt(i3);
                                SwanTaskDeadEvent valueAt = auX.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dcQ.put(keyAt, valueAt);
                                    b.this.dcP.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.l(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dcM);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.l(aVar.getAppId(), -1, i);
                }
                b.this.dcM = b.this.aFb();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dcM);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aFb = aFb();
        if (!g(this.dcM, aFb)) {
            aEZ();
            l(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aFb + ", mLaunchTaskList=" + this.dcM + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dcM = aFb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).fo(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dcM != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dcP.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dcM.remove(Integer.valueOf(i2));
                    this.dcP.delete(string.hashCode());
                    this.dcQ.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dcM.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dcM.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dcM.size()) {
                        break;
                    } else if (this.dcM.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dcM.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dcQ.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dcP.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dcQ.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dcM);
            }
        }
    }

    public static boolean aEX() {
        if (czv == -1) {
            synchronized (b.class) {
                if (czv == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.axu().getBoolean("swan_page_stack_optimize", false)) {
                        czv = 1;
                        return true;
                    }
                    czv = (dcN && com.baidu.swan.apps.t.a.apx().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return czv == 1;
    }

    public static boolean aEY() {
        if (dcJ == -1) {
            dcJ = com.baidu.swan.apps.t.a.apx().getSwitch("swan_move_task_optimize", 1);
        }
        return dcJ == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dcK != null) {
                if (z(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dcK.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dcQ.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dcQ.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().nV(swanTaskDeadEvent.getAppId())).oa(swanTaskDeadEvent.auV())).nY("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> auW = swanTaskDeadEvent.auW();
                            if (auW != null && !auW.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = auW.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dcQ.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.ame().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dcQ.size());
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

    public synchronized boolean fY(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dcM;
        if (z) {
            arrayList = aFb();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dcK != null) {
            this.dcL = null;
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

    public void aEZ() {
        this.dcQ.clear();
        this.dcP.clear();
    }

    private boolean z(int i, boolean z) {
        if (dcN) {
            List<ActivityManager.AppTask> list = this.dcL;
            if ((!z || list == null) && this.dcK != null) {
                list = this.dcK.getAppTasks();
                if (z) {
                    this.dcL = list;
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

    public boolean ku(int i) {
        if (aEX() && dcN && this.dcK != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dcK.getAppTasks()) {
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

    public int aFa() {
        if (!dcN || this.dcK == null) {
            return -1;
        }
        try {
            return a(this.dcK.getAppTasks().get(0));
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
    public ArrayList<Integer> aFb() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dcN && this.dcK != null && (size = (appTasks = this.dcK.getAppTasks()).size()) >= 2) {
            ArrayList<Integer> arrayList = new ArrayList<>(size - 1);
            for (int i = 1; i < size; i++) {
                int a = a(appTasks.get(i));
                if (a != -1) {
                    arrayList.add(Integer.valueOf(a));
                }
            }
            return arrayList;
        }
        return null;
    }

    public static void O(@NonNull Message message) {
        if (aEX()) {
            aEW().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aEX()) {
            b aEW = aEW();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aEW.dcM != null && aEW.dcM.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aEW.dcP.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aEW.dcQ.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f YG;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c ahw;
        if (aEX() && swanAppActivity != null && (YG = swanAppActivity.YG()) != null && (eVar = (com.baidu.swan.apps.core.d.e) YG.q(com.baidu.swan.apps.core.d.e.class)) != null && (ahw = eVar.ahw()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.YP(), swanAppActivity.getTaskId(), ahw.getPage() + "?" + ahw.getParams(), this.dcM));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).fo(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.YP() + ", " + swanAppActivity.getTaskId());
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
