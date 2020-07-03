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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile int cOg = -1;
    private static final boolean cOk = b.hasLollipop();
    private static volatile a cOl;
    @Nullable
    private ActivityManager cOh;
    private List<ActivityManager.AppTask> cOi;
    @Nullable
    private ArrayList<Integer> cOj;
    private final SparseIntArray cOm = new SparseIntArray();
    private final SparseArray<SwanTaskDeadEvent> cOn = new SparseArray<>();

    private a() {
        Application afX = com.baidu.swan.apps.u.a.afX();
        if (afX != null) {
            this.cOh = (ActivityManager) afX.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }

    public static a auc() {
        if (cOl == null) {
            synchronized (a.class) {
                if (cOl == null) {
                    cOl = new a();
                }
            }
        }
        return cOl;
    }

    public void a(@Nullable final b.a aVar, final int i) {
        n.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.aq.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aue();
                if (aVar != null && "1202000800000000".equals(aVar.ahQ())) {
                    SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) aVar.lr("key_stack_info");
                    if (swanTaskDeadEvent != null) {
                        a.this.cOj = swanTaskDeadEvent.ala();
                        SparseArray<SwanTaskDeadEvent> alb = swanTaskDeadEvent.alb();
                        if (alb != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= alb.size()) {
                                    break;
                                }
                                int keyAt = alb.keyAt(i3);
                                SwanTaskDeadEvent valueAt = alb.valueAt(i3);
                                if (valueAt != null && valueAt.getAppId() != null) {
                                    a.this.cOn.put(keyAt, valueAt);
                                    a.this.cOm.put(valueAt.getAppId().hashCode(), keyAt);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        a.this.l(null, swanTaskDeadEvent.getTaskId(), i);
                    }
                    if (a.DEBUG) {
                        Log.d("SwanActivityTaskManager", "stack back: " + a.this.cOj);
                        return;
                    }
                    return;
                }
                if (aVar != null) {
                    a.this.l(aVar.getAppId(), -1, i);
                }
                a.this.cOj = a.this.auf();
                if (a.DEBUG) {
                    Log.d("SwanActivityTaskManager", "getLaunchTask=" + a.this.cOj);
                }
            }
        }, "getLaunchTask");
    }

    public void b(@Nullable Intent intent, int i) {
        ArrayList<Integer> auf = auf();
        if (!f(this.cOj, auf)) {
            aue();
            l(null, -1, i);
        }
        if (DEBUG) {
            Log.d("SwanActivityTaskManager", "onNewIntent: " + i + ", newTaskList=" + auf + ", mLaunchTaskList=" + this.cOj + ", flag=" + (intent != null ? intent.getFlags() : -1));
        }
        this.cOj = auf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_task_id", i2);
        bundle.putInt("key_task_id_old", i);
        bundle.putString("app_id", str);
        com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(123, bundle).eN(true));
    }

    private void W(@Nullable Bundle bundle) {
        if (bundle != null && this.cOj != null) {
            String string = bundle.getString("app_id");
            int i = bundle.getInt("key_task_id", -1);
            if (!TextUtils.isEmpty(string)) {
                int i2 = this.cOm.get(string.hashCode(), -1);
                if (i2 > -1) {
                    this.cOj.remove(Integer.valueOf(i2));
                    this.cOm.delete(string.hashCode());
                    this.cOn.remove(i2);
                    if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "removeTaskFromCache: " + string + ", oldTask=" + i2);
                    }
                }
                this.cOj.remove(Integer.valueOf(i));
                return;
            }
            int i3 = bundle.getInt("key_task_id_old", -1);
            if (i3 == -1) {
                this.cOj.remove(Integer.valueOf(i));
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.cOj.size()) {
                        break;
                    } else if (this.cOj.get(i5).intValue() != i3) {
                        i4 = i5 + 1;
                    } else {
                        this.cOj.set(i5, Integer.valueOf(i));
                        break;
                    }
                }
                SwanTaskDeadEvent swanTaskDeadEvent = this.cOn.get(i3);
                if (swanTaskDeadEvent != null) {
                    if (swanTaskDeadEvent.getAppId() != null) {
                        this.cOm.delete(swanTaskDeadEvent.getAppId().hashCode());
                    }
                    this.cOn.remove(i3);
                }
            }
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "removeTaskFromCache nowTask=" + i + ", old=" + i3 + ", " + this.cOj);
            }
        }
    }

    public static boolean aud() {
        if (cOg == -1) {
            synchronized (a.class) {
                if (cOg == -1) {
                    if (DEBUG && com.baidu.swan.apps.af.a.a.anf().getBoolean("swan_page_stack_optimize", false)) {
                        cOg = 1;
                        return true;
                    }
                    cOg = (cOk && com.baidu.swan.apps.u.a.aga().getSwitch("swan_page_stack_optimize", true)) ? 1 : 0;
                }
            }
        }
        return cOg == 1;
    }

    public synchronized boolean y(int i, boolean z) {
        boolean z2;
        if (i > -1) {
            if (this.cOh != null) {
                if (z(i, z)) {
                    if (DEBUG) {
                        Log.i("SwanActivityTaskManager", "moveTaskToFront:" + i);
                    }
                    try {
                        this.cOh.moveTaskToFront(i, 2);
                        z2 = true;
                    } catch (Exception e) {
                        com.baidu.swan.apps.console.c.e("SwanActivityTaskManager", "moveTaskToFront", e);
                    }
                } else {
                    if (this.cOn.indexOfKey(i) >= 0) {
                        SwanTaskDeadEvent swanTaskDeadEvent = this.cOn.get(i);
                        if (swanTaskDeadEvent != null) {
                            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().le(swanTaskDeadEvent.getAppId())).lj(swanTaskDeadEvent.akZ())).lh("1202000800000000");
                            Bundle bundle = new Bundle();
                            ArrayList<Integer> ala = swanTaskDeadEvent.ala();
                            if (ala != null && !ala.isEmpty()) {
                                SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
                                Iterator<Integer> it = ala.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    SwanTaskDeadEvent swanTaskDeadEvent2 = this.cOn.get(next.intValue(), null);
                                    if (swanTaskDeadEvent2 != null) {
                                        sparseArray.put(next.intValue(), swanTaskDeadEvent2);
                                    }
                                }
                                swanTaskDeadEvent.a(sparseArray);
                            }
                            bundle.putParcelable("key_stack_info", swanTaskDeadEvent);
                            SwanLauncher.adE().a(aVar, bundle);
                            if (DEBUG) {
                                Log.i("SwanActivityTaskManager", "launch dead app:" + swanTaskDeadEvent.getAppId());
                            }
                            z2 = true;
                        }
                    } else if (DEBUG) {
                        Log.d("SwanActivityTaskManager", "Not Found taskId:" + i + " cacheSize:" + this.cOn.size());
                    }
                    z2 = false;
                }
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean fx(boolean z) {
        boolean z2;
        ArrayList<Integer> arrayList = this.cOj;
        if (z) {
            arrayList = auf();
        }
        if (arrayList != null && !arrayList.isEmpty() && this.cOh != null) {
            this.cOi = null;
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                if (y(it.next().intValue(), true)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    public void aue() {
        this.cOn.clear();
        this.cOm.clear();
    }

    private boolean z(int i, boolean z) {
        if (cOk) {
            List<ActivityManager.AppTask> list = this.cOi;
            if ((!z || list == null) && this.cOh != null) {
                list = this.cOh.getAppTasks();
                if (z) {
                    this.cOi = list;
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

    public boolean hS(int i) {
        if (aud() && cOk && this.cOh != null) {
            int i2 = 0;
            for (ActivityManager.AppTask appTask : this.cOh.getAppTasks()) {
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
    public ArrayList<Integer> auf() {
        List<ActivityManager.AppTask> appTasks;
        int size;
        if (cOk && this.cOh != null && (size = (appTasks = this.cOh.getAppTasks()).size()) >= 2) {
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
        if (aud()) {
            auc().W((Bundle) message.obj);
        }
    }

    public static void O(@NonNull Message message) {
        if (aud()) {
            a auc = auc();
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
                SwanTaskDeadEvent swanTaskDeadEvent = (SwanTaskDeadEvent) bundle.getParcelable("key_stack_info");
                if (swanTaskDeadEvent != null && !TextUtils.isEmpty(swanTaskDeadEvent.getAppId())) {
                    if (ProcessUtils.isMainProcess() || (auc.cOj != null && auc.cOj.contains(Integer.valueOf(swanTaskDeadEvent.getTaskId())))) {
                        auc.cOm.put(swanTaskDeadEvent.getAppId().hashCode(), swanTaskDeadEvent.getTaskId());
                        auc.cOn.put(swanTaskDeadEvent.getTaskId(), swanTaskDeadEvent);
                    }
                }
            }
        }
    }

    public void k(@Nullable SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.e RN;
        com.baidu.swan.apps.core.d.d dVar;
        com.baidu.swan.apps.model.c Zz;
        if (aud() && swanAppActivity != null && (RN = swanAppActivity.RN()) != null && (dVar = (com.baidu.swan.apps.core.d.d) RN.q(com.baidu.swan.apps.core.d.d.class)) != null && (Zz = dVar.Zz()) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_stack_info", new SwanTaskDeadEvent(swanAppActivity.RW(), swanAppActivity.getTaskId(), Zz.getPage() + "?" + Zz.getParams(), this.cOj));
            bundle.setClassLoader(SwanTaskDeadEvent.class.getClassLoader());
            com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(124, bundle).eN(true));
            if (DEBUG) {
                Log.d("SwanActivityTaskManager", "notify dead " + swanAppActivity.RW() + ", " + swanAppActivity.getTaskId());
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
