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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int cxu = -1;
    private static volatile int daI = -1;
    private static final boolean daM = c.hasLollipop();
    private static volatile b daN;
    @Nullable
    private ActivityManager daJ;
    private List<ActivityManager.AppTask> daK;
    @Nullable
    private ArrayList<Integer> daL;
    private final SparseIntArray daO = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> daP = new SparseArray<>();

    private b() {
        Application aoJ = com.baidu.swan.apps.t.a.aoJ();
        if (aoJ != null) {
            this.daJ = (ActivityManager) aoJ.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static b aEm() {
        if (daN == null) {
            synchronized (b.class) {
                if (daN == null) {
                    daN = new b();
                }
            }
        }
        return daN;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.ap.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.aEp();
                if (aVar != null && "1202000800000000".equals(aVar.aqN())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.nQ("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        b.this.daL = swanTaskDeadEvent.aun();
                        SparseArray<SwanTaskDeadEvent> auo = swanTaskDeadEvent.auo();
                        if (auo != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= auo.size()) {
                                    break;
                                }
                                int keyAt = auo.keyAt(i3);
                                SwanTaskDeadEvent valueAt = auo.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    b.this.daP.put(keyAt, valueAt);
                                    b.this.daO.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        b.this.l(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + b.this.daL);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    b.this.l(aVar.getAppId(), -1, i);
                }
                b.this.daL = b.this.aEr();
                if (b.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + b.this.daL);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> aEr = aEr();
        if (!f(this.daL, aEr)) {
            aEp();
            l(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + aEr + ", mLaunchTaskList=" + this.daL + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.daL = aEr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY, bundle).fq(true));
    }

    private void V(@Nullable Bundle bundle) {
        if (bundle != null && this.daL != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.daO.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.daL.remove(Integer.valueOf(i2));
                    this.daO.delete(string.hashCode());
                    this.daP.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.daL.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.daL.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.daL.size()) {
                        break;
                    } else if (this.daL.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.daL.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.daP.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.daO.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.daP.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.daL);
            }
        }
    }

    public static boolean aEn() {
        if (cxu == -1) {
            synchronized (b.class) {
                if (cxu == -1) {
                    if (DEBUG && com.baidu.swan.apps.ad.a.a.awL().getBoolean("swan_page_stack_optimize", false)) {
                        cxu = 1;
                        return true;
                    }
                    cxu = (daM && com.baidu.swan.apps.t.a.aoM().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cxu == 1;
    }

    public static boolean aEo() {
        if (daI == -1) {
            daI = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_move_task_optimize", 1);
        }
        return daI == 1;
    }

    @AnyThread
    public synchronized boolean c(int i, boolean z, boolean z2) {
        boolean z3;
        if (i > -1) {
            if (this.daJ != null) {
                if (z(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.daJ.moveTaskToFront(i, 2, null);
                        z3 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.daP.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.daP.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().nC(swanTaskDeadEvent.getAppId())).nH(swanTaskDeadEvent.aum())).nF("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> aun = swanTaskDeadEvent.aun();
                            if (aun != null && !aun.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = aun.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.daP.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.alu().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z3 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.daP.size());
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

    public synchronized boolean ga(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.daL;
        if (z) {
            arrayList = aEr();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.daJ != null) {
            this.daK = null;
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

    public void aEp() {
        this.daP.clear();
        this.daO.clear();
    }

    private boolean z(int i, boolean z) {
        if (daM) {
            List<ActivityManager.AppTask> list = this.daK;
            if ((!z || list == null) && this.daJ != null) {
                list = this.daJ.getAppTasks();
                if (z) {
                    this.daK = list;
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
        if (aEn() && daM && this.daJ != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.daJ.getAppTasks()) {
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

    public int aEq() {
        if (!daM || this.daJ == null) {
            return -1;
        }
        try {
            return a(this.daJ.getAppTasks().get(0));
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
    public ArrayList<Integer> aEr() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (daM && this.daJ != null && (size = (appTasks = this.daJ.getAppTasks()).size()) >= 2) {
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
        if (aEn()) {
            aEm().V((Bundle) message.obj);
        }
    }

    public static void P(@NonNull Message message) {
        if (aEn()) {
            b aEm = aEm();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (aEm.daL != null && aEm.daL.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        aEm.daO.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        aEm.daP.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void l(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f XX;
        com.baidu.swan.apps.core.d.e eVar;
        com.baidu.swan.apps.model.c agM;
        if (aEn() && swanAppActivity != null && (XX = swanAppActivity.XX()) != null && (eVar = (com.baidu.swan.apps.core.d.e) XX.q(com.baidu.swan.apps.core.d.e.class)) != null && (agM = eVar.agM()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.Yg(), swanAppActivity.getTaskId(), agM.getPage() + "?" + agM.getParams(), this.daL));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, bundle).fq(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.Yg() + ", " + swanAppActivity.getTaskId());
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
