package com.baidu.swan.apps.aq;

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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int cRC = -1;
    private static volatile int cRD = -1;
    private static final boolean cRH = c.hasLollipop();
    private static volatile b cRI;
    @Nullable
    private ActivityManager cRE;
    private List<ActivityManager.AppTask> cRF;
    @Nullable
    private ArrayList<Integer> cRG;
    private final SparseIntArray cRJ = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> cRK = new SparseArray<>();

    private b() {
        Application ahj = com.baidu.swan.apps.t.a.ahj();
        if (ahj != null) {
            this.cRE = (ActivityManager) ahj.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b awd() {
        if (cRI == null) {
            synchronized (b.class) {
                if (cRI == null) {
                    cRI = new b();
                }
            }
        }
        return cRI;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.aq.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.awg();
                if (aVar != null && "1202000800000000".equals(aVar.ajg())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.lS("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.cRG = swanTaskDeadEvent.amr();
                        SparseArray<SwanTaskDeadEvent> ams = swanTaskDeadEvent.ams();
                        if (ams != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= ams.size()) {
                                    break;
                                }
                                int keyAt = ams.keyAt(i3);
                                SwanTaskDeadEvent valueAt = ams.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.cRK.put(keyAt, valueAt);
                                    b.this.cRJ.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.l(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.cRG);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.l(aVar.getAppId(), -1, i);
                }
                b.this.cRG = b.this.awh();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.cRG);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> awh = awh();
        if (!f(this.cRG, awh)) {
            awg();
            l(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + awh + ", mLaunchTaskList=" + this.cRG + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.cRG = awh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(123, bundle).eW(true));
    }

    private void X(@Nullable Bundle bundle) {
        if (bundle != null && this.cRG != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.cRJ.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.cRG.remove(Integer.valueOf(i2));
                    this.cRJ.delete(string.hashCode());
                    this.cRK.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.cRG.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.cRG.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.cRG.size()) {
                        break;
                    } else if (this.cRG.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.cRG.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.cRK.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.cRJ.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.cRK.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.cRG);
            }
        }
    }

    public static boolean awe() {
        if (cRC == -1) {
            synchronized (b.class) {
                if (cRC == -1) {
                    if (DEBUG && com.baidu.swan.apps.ae.a.a.aoO().getBoolean("swan_page_stack_optimize", false)) {
                        cRC = 1;
                        return true;
                    }
                    cRC = (cRH && com.baidu.swan.apps.t.a.ahm().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cRC == 1;
    }

    public static boolean awf() {
        if (cRD == -1) {
            cRD = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_move_task_optimize", 0);
        }
        return cRD == 1;
    }

    @AnyThread
    public synchronized boolean x(int i, boolean z) {
        boolean z2;
        if (i > -1) {
            if (this.cRE != null) {
                if (y(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.cRE.moveTaskToFront(i, 2);
                        z2 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.cRK.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.cRK.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().lE(swanTaskDeadEvent.getAppId())).lJ(swanTaskDeadEvent.amq())).lH("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> amr = swanTaskDeadEvent.amr();
                            if (amr != null && !amr.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = amr.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.cRK.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.aeL().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z2 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.cRK.size());
                    }
                    z2 = false;
                }
            }
        }
        z2 = false;
        return z2;
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
            return x(i, z);
        }
    }

    public synchronized boolean fG(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.cRG;
        if (z) {
            arrayList = awh();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.cRE != null) {
            this.cRF = null;
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                if (x(it.next().intValue(), true)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    public void awg() {
        this.cRK.clear();
        this.cRJ.clear();
    }

    private boolean y(int i, boolean z) {
        if (cRH) {
            List<ActivityManager.AppTask> list = this.cRF;
            if ((!z || list == null) && this.cRE != null) {
                list = this.cRE.getAppTasks();
                if (z) {
                    this.cRF = list;
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

    public boolean ib(int i) {
        if (awe() && cRH && this.cRE != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.cRE.getAppTasks()) {
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
    public ArrayList<Integer> awh() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (cRH && this.cRE != null && (size = (appTasks = this.cRE.getAppTasks()).size()) >= 2) {
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

    public static void N(@NonNull Message message) {
        if (awe()) {
            awd().X((Bundle) message.obj);
        }
    }

    public static void O(@NonNull Message message) {
        if (awe()) {
            b awd = awd();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (awd.cRG != null && awd.cRG.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        awd.cRJ.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        awd.cRK.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f Sc;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c aaC;
        if (awe() && swanAppActivity != null && (Sc = swanAppActivity.Sc()) != null && (eVar = (com.baidu.swan.apps.core.d.e) Sc.q(com.baidu.swan.apps.core.d.e.class)) != null && (aaC = eVar.aaC()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.Sl(), swanAppActivity.getTaskId(), aaC.getPage() + "?" + aaC.getParams(), this.cRG));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(124, bundle).eW(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.Sl() + ", " + swanAppActivity.getTaskId());
            }
        }
    }

    private boolean f(List<Integer> list, List<Integer> list2) {
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
