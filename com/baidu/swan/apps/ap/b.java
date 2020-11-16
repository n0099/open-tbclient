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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int cYf = -1;
    private static volatile int dBD = -1;
    private static final boolean dBH = c.hasLollipop();
    private static volatile b dBI;
    @Nullable
    private ActivityManager dBE;
    private List<ActivityManager.AppTask> dBF;
    @Nullable
    private ArrayList<Integer> dBG;
    private final SparseIntArray dBJ = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> dBK = new SparseArray<>();

    private b() {
        Application avS = com.baidu.swan.apps.t.a.avS();
        if (avS != null) {
            this.dBE = (ActivityManager) avS.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aLr() {
        if (dBI == null) {
            synchronized (b.class) {
                if (dBI == null) {
                    dBI = new b();
                }
            }
        }
        return dBI;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ap.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aLu();
                if (aVar != null && "1202000800000000".equals(aVar.axV())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.py("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.dBG = swanTaskDeadEvent.aBt();
                        SparseArray<SwanTaskDeadEvent> aBu = swanTaskDeadEvent.aBu();
                        if (aBu != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= aBu.size()) {
                                    break;
                                }
                                int keyAt = aBu.keyAt(i3);
                                SwanTaskDeadEvent valueAt = aBu.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.dBK.put(keyAt, valueAt);
                                    b.this.dBJ.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.m(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.dBG);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.m(aVar.getAppId(), -1, i);
                }
                b.this.dBG = b.this.aLw();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.dBG);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aLw = aLw();
        if (!j(this.dBG, aLw)) {
            aLu();
            m(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aLw + ", mLaunchTaskList=" + this.dBG + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.dBG = aLw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).gj(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.dBG != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.dBJ.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.dBG.remove(Integer.valueOf(i2));
                    this.dBJ.delete(string.hashCode());
                    this.dBK.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.dBG.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.dBG.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.dBG.size()) {
                        break;
                    } else if (this.dBG.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.dBG.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.dBK.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.dBJ.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.dBK.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.dBG);
            }
        }
    }

    public static boolean aLs() {
        if (cYf == -1) {
            synchronized (b.class) {
                if (cYf == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.aDR().getBoolean("swan_page_stack_optimize", false)) {
                        cYf = 1;
                        return true;
                    }
                    cYf = (dBH && com.baidu.swan.apps.t.a.avV().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cYf == 1;
    }

    public static boolean aLt() {
        if (dBD == -1) {
            dBD = com.baidu.swan.apps.t.a.avV().getSwitch("swan_move_task_optimize", 1);
        }
        return dBD == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.dBE != null) {
                if (B(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.dBE.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.dBK.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.dBK.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().pk(swanTaskDeadEvent.getAppId())).pp(swanTaskDeadEvent.aBs())).pn("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aBt = swanTaskDeadEvent.aBt();
                            if (aBt != null && !aBt.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aBt.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.dBK.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.asD().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.dBK.size());
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

    public synchronized boolean gT(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.dBG;
        if (z) {
            arrayList = aLw();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.dBE != null) {
            this.dBF = null;
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

    public void aLu() {
        this.dBK.clear();
        this.dBJ.clear();
    }

    private boolean B(int i, boolean z) {
        if (dBH) {
            List<ActivityManager.AppTask> list = this.dBF;
            if ((!z || list == null) && this.dBE != null) {
                list = this.dBE.getAppTasks();
                if (z) {
                    this.dBF = list;
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

    public boolean li(int i) {
        if (aLs() && dBH && this.dBE != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.dBE.getAppTasks()) {
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

    public int aLv() {
        if (!dBH || this.dBE == null) {
            return -1;
        }
        try {
            return a(this.dBE.getAppTasks().get(0));
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
    public ArrayList<Integer> aLw() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (dBH && this.dBE != null && (size = (appTasks = this.dBE.getAppTasks()).size()) >= 2) {
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
        if (aLs()) {
            aLr().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aLs()) {
            b aLr = aLr();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aLr.dBG != null && aLr.dBG.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aLr.dBJ.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aLr.dBK.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afe;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c anT;
        if (aLs() && swanAppActivity != null && (afe = swanAppActivity.afe()) != null && (eVar = (com.baidu.swan.apps.core.d.e) afe.q(com.baidu.swan.apps.core.d.e.class)) != null && (anT = eVar.anT()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.afn(), swanAppActivity.getTaskId(), anT.getPage() + "?" + anT.getParams(), this.dBG));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).gj(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.afn() + ", " + swanAppActivity.getTaskId());
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
