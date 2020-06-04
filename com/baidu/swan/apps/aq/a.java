package com.baidu.swan.apps.aq;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.model.SwanTaskDeadEvent;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.v.b.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cJB;
    private final SparseIntArray cJC = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> cJD = new SparseArray<>();
    @Nullable
    private ActivityManager cJx;
    private List<ActivityManager.AppTask> cJy;
    @Nullable
    private ArrayList<Integer> cJz;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int cJw = -1;
    private static final boolean cJA = b.hasLollipop();

    private a() {
        Application aeR = com.baidu.swan.apps.u.a.aeR();
        if (aeR != null) {
            this.cJx = (ActivityManager) aeR.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static a asW() {
        if (cJB == null) {
            synchronized (a.class) {
                if (cJB == null) {
                    cJB = new a();
                }
            }
        }
        return cJB;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        n.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.aq.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.asY();
                if (aVar != null && "1202000800000000".equals(aVar.agK())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.lj("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        a.this.cJz = swanTaskDeadEvent.ajU();
                        SparseArray<SwanTaskDeadEvent> ajV = swanTaskDeadEvent.ajV();
                        if (ajV != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= ajV.size()) {
                                    break;
                                }
                                int keyAt = ajV.keyAt(i3);
                                SwanTaskDeadEvent valueAt = ajV.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    a.this.cJD.put(keyAt, valueAt);
                                    a.this.cJC.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        a.this.l(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (a.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + a.this.cJz);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    a.this.l(aVar.getAppId(), -1, i);
                }
                a.this.cJz = a.this.asZ();
                if (a.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + a.this.cJz);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> asZ = asZ();
        if (!f(this.cJz, asZ)) {
            asY();
            l(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + asZ + ", mLaunchTaskList=" + this.cJz + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.cJz = asZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(123, bundle).eI(true));
    }

    private void W(@Nullable Bundle bundle) {
        if (bundle != null && this.cJz != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.cJC.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.cJz.remove(Integer.valueOf(i2));
                    this.cJC.delete(string.hashCode());
                    this.cJD.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.cJz.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.cJz.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.cJz.size()) {
                        break;
                    } else if (this.cJz.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.cJz.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.cJD.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.cJC.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.cJD.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.cJz);
            }
        }
    }

    public static boolean asX() {
        if (cJw == -1) {
            synchronized (a.class) {
                if (cJw == -1) {
                    if (DEBUG && com.baidu.swan.apps.af.a.a.alZ().getBoolean("swan_page_stack_optimize", false)) {
                        cJw = 1;
                        return true;
                    }
                    cJw = (cJA && com.baidu.swan.apps.u.a.aeU().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cJw == 1;
    }

    public synchronized boolean x(int i, boolean z) {
        boolean z2;
        if (i > -1) {
            if (this.cJx != null) {
                if (y(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.cJx.moveTaskToFront(i, 2);
                        z2 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.cJD.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.cJD.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().kW(swanTaskDeadEvent.getAppId())).lb(swanTaskDeadEvent.ajT())).kZ("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> ajU = swanTaskDeadEvent.ajU();
                            if (ajU != null && !ajU.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = ajU.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.cJD.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.acy().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z2 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.cJD.size());
                    }
                    z2 = false;
                }
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean fs(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.cJz;
        if (z) {
            arrayList = asZ();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.cJx != null) {
            this.cJy = null;
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

    public void asY() {
        this.cJD.clear();
        this.cJC.clear();
    }

    private boolean y(int i, boolean z) {
        if (cJA) {
            List<ActivityManager.AppTask> list = this.cJy;
            if ((!z || list == null) && this.cJx != null) {
                list = this.cJx.getAppTasks();
                if (z) {
                    this.cJy = list;
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

    public boolean hH(int i) {
        if (asX() && cJA && this.cJx != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.cJx.getAppTasks()) {
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
    public ArrayList<Integer> asZ() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (cJA && this.cJx != null && (size = (appTasks = this.cJx.getAppTasks()).size()) >= 2) {
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
        if (asX()) {
            asW().W((Bundle) message.obj);
        }
    }

    public static void O(@NonNull Message message) {
        if (asX()) {
            a asW = asW();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (asW.cJz != null && asW.cJz.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        asW.cJC.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        asW.cJD.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void k(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.e QH;
        com.baidu.swan.apps.core.d.d dVar;
        com.baidu.swan.apps.model.c Yt;
        if (asX() && swanAppActivity != null && (QH = swanAppActivity.QH()) != null && (dVar = (com.baidu.swan.apps.core.d.d) QH.q(com.baidu.swan.apps.core.d.d.class)) != null && (Yt = dVar.Yt()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.QQ(), swanAppActivity.getTaskId(), Yt.getPage() + "?" + Yt.getParams(), this.cJz));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(124, bundle).eI(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.QQ() + ", " + swanAppActivity.getTaskId());
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
