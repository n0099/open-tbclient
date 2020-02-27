package com.baidu.crabsdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.view.MotionEvent;
import com.baidu.crabsdk.a.b;
import com.baidu.crabsdk.a.c;
import com.baidu.crabsdk.b.d;
import com.baidu.crabsdk.b.g;
import com.baidu.crabsdk.b.i;
import com.baidu.crabsdk.b.l;
import com.baidu.crabsdk.b.m;
import com.baidu.crabsdk.b.n;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.b.s;
import com.baidu.crabsdk.b.t;
import com.baidu.crabsdk.sender.NativeCrashHandler;
import com.baidu.crabsdk.sender.f;
import com.baidu.crabsdk.sender.h;
import com.baidu.crabsdk.sender.k;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class CrabSDK {
    public static final int ANR_CLOSE = 0;
    public static final int ANR_OBSERVER_LOGCAT = 1;
    public static final int ANR_OBSERVER_PROC_STATE = 2;
    private static Application R;
    public static String NDK_VERSION = "-1";
    public static String FILE_PATH = "/sdcard";
    public static int CURRENT_PID = 0;
    public static String CURRENT_PNAME = "";
    private static boolean S = false;

    public static void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        d.dispatchTouchEvent(motionEvent, activity);
    }

    public static void closeAnrHandler() {
        a.I = 0;
    }

    public static void disableBlockCatch() {
        if (b.oa() == null) {
            com.baidu.crabsdk.c.a.w("Block Monitor has never been enabled!");
            return;
        }
        b.oa().stop();
        c.as(R);
        c.stop();
    }

    @Deprecated
    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        d.dispatchTouchEvent(motionEvent, activity);
    }

    public static void doActivityStart(Activity activity) {
        com.baidu.crabsdk.b.a.doActivityStart(activity);
    }

    public static void doActivityStop(Activity activity) {
        com.baidu.crabsdk.b.a.doActivityStop(activity);
    }

    public static void enableBlockCatch(int i) {
        if (Build.VERSION.SDK_INT < 16) {
            com.baidu.crabsdk.c.a.w("ERROR! BlockCatch only can be enabled when SDK_INT >= 16");
            return;
        }
        setUploadLimitOfBlockInOneday(i);
        if (h.ow()) {
            b.aq(R).start();
            c.as(R);
            c.start();
        }
    }

    public static void enableBlockCatch(int i, boolean z) {
        a.s = z;
        enableBlockCatch(i);
    }

    public static HashMap<String, String> getUsersCustomKV() {
        return s.ok();
    }

    public static void init(Application application, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.crabsdk.c.a.w("crab init begin: " + currentTimeMillis);
        a.d = str;
        if (application == null) {
            com.baidu.crabsdk.c.a.w("crab init error caused by applcation null value");
            return;
        }
        R = application;
        FILE_PATH = application.getFilesDir().getAbsolutePath();
        com.baidu.crabsdk.c.a.v("FILE_PATH IS : " + FILE_PATH);
        initData(R, str);
        long currentTimeMillis2 = System.currentTimeMillis();
        a.J = false;
        com.baidu.crabsdk.c.a.w("crab init end: " + currentTimeMillis2 + ", cost: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
    }

    public static void initAnrCollector(Application application, String str) {
        a.d = str;
        initCollector(application);
        initCrashSwitch(application);
        if (!a.D && a.I != 0) {
            com.baidu.crabsdk.b.c.a(application, a.I);
        }
        uploadRecord(application);
    }

    public static void initCollector(Application application) {
        m.e(application);
        o.e(application);
        g.e(application);
        i.w();
        l.e(application);
        s.e(application);
        n.e(application);
        com.baidu.crabsdk.b.a.a(application);
    }

    private static void initCrashSwitch(Application application) {
        h.e(application);
    }

    private static void initData(Application application, String str) {
        boolean z;
        int myPid = Process.myPid();
        CURRENT_PID = myPid;
        com.baidu.crabsdk.c.a.cj("CrabSDK.init from " + R.getPackageName() + " with pid " + myPid);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            com.baidu.crabsdk.c.a.cj("getRunningAppProcesses error!!");
            return;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                if (next.processName.equals(application.getPackageName())) {
                    S = true;
                    com.baidu.crabsdk.c.a.cj("Main process " + next.processName + ".");
                } else {
                    S = false;
                    com.baidu.crabsdk.c.a.cj("Sub process " + next.processName + ".");
                }
                CURRENT_PNAME = next.processName;
                z = true;
            }
        }
        if (z) {
            initCrashSwitch(application);
            initCollector(application);
            f.oq().e(application);
            initAnrCollector(application, str);
        }
    }

    private static void initNativeHandler() {
        NativeCrashHandler.s(R).ae();
        k.k(R);
    }

    @Deprecated
    public static void onPause(Context context) {
    }

    @Deprecated
    public static void onResume(Context context) {
    }

    public static void openNativeCrashHandler() {
        a.L = false;
        initNativeHandler();
    }

    public static void openNativeCrashHandlerWithSysCatched() {
        a.L = true;
        initNativeHandler();
    }

    public static void pauseAnrWatchThread() {
        closeAnrHandler();
    }

    public static void resumeAnrWatchThread(int i) {
        try {
            Thread oh = com.baidu.crabsdk.b.c.oh();
            if (oh == null) {
                initAnrCollector(R, a.d);
                com.baidu.crabsdk.c.a.v("ANR watch thread is null, init anrCollector again");
            } else if (a.I == 0) {
                a.I = i;
                new Thread(oh).start();
            } else {
                com.baidu.crabsdk.c.a.cl("ANR watch thread is running");
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("resumeAnrWatchThread->Exception", e);
        }
    }

    public static void setAnrObserverType(int i) {
        if (i == 1 || i == 2) {
            a.I = i;
        } else {
            a.I = 0;
        }
    }

    public static void setAppVersionName(String str) {
        a.o = str;
    }

    public static void setBehaviorRecordLimit(int i) {
        a.f = i;
    }

    public static void setBlockThreshold(int i) {
        if (i >= 1000) {
            com.baidu.crabsdk.a.a.U = i;
            return;
        }
        com.baidu.crabsdk.c.a.w("You Are Strongly Recommended To Set Threshold Not Less Than 1000ms!!");
        com.baidu.crabsdk.a.a.U = 1000;
    }

    public static void setChannel(String str) {
        if (str == null || str.length() == 0) {
            a.b = "alpha";
        } else {
            a.b = str;
        }
    }

    public static void setCollectScreenshot(boolean z) {
        a.m = z;
    }

    public static void setConstantSameCrashExceedLimit(int i) {
        a.z = i;
    }

    public static void setDebugAnrExpUrl(String str) {
        a.Q = str;
    }

    public static void setDebugCrashUrl(String str) {
        a.P = str;
    }

    public static void setDebugMode(boolean z) {
        a.n = z;
    }

    public static void setDeveloperName(String str) {
        a.a = str;
    }

    public static void setEnableLog(boolean z) {
        a.F = z;
    }

    public static void setImeiCatched(boolean z) {
        a.K = z;
    }

    public static void setIsOnline(boolean z) {
        a.E = z;
    }

    public static void setLogcatLineCount(int i) {
        if (i > 1000) {
            com.baidu.crabsdk.c.a.cl("强烈建议logcat最大行数小于1000！");
            a.h = 1000;
        } else {
            a.h = i;
        }
        if (NativeCrashHandler.ad() != null) {
            NativeCrashHandler.ad().b(a.h);
        }
    }

    public static void setOnAnrCrashListener(OnAnrCrashListener onAnrCrashListener) {
        a.N = onAnrCrashListener;
    }

    public static void setOnCrashExceedListener(OnCrashExceedListener onCrashExceedListener) {
        a.O = onCrashExceedListener;
    }

    public static void setSendPrivacyInformation(boolean z) {
        a.q = z;
    }

    public static void setUid(String str) {
        s.c(str);
    }

    public static void setUploadCrashOnlyWifi(boolean z) {
        a.r = z;
    }

    public static void setUploadImmediately(boolean z) {
        a.p = z;
    }

    public static void setUploadLimitOfAnrInOneday(int i) {
        a.v = i;
    }

    private static void setUploadLimitOfBlockInOneday(int i) {
        a.w = i;
    }

    public static void setUploadLimitOfCrashInOneday(int i) {
        a.u = i;
    }

    public static void setUploadLimitOfSameCrashInOneday(int i) {
        a.t = i;
    }

    public static void setUrlRecordLimit(int i) {
        a.g = i;
    }

    public static void setUserName(String str) {
        s.setUserName(str);
    }

    public static void setUsersCustomKV(String str, String str2) {
        s.ok().put(str, str2);
    }

    public static void setUsersCustomKV(HashMap<String, String> hashMap) {
        s.a(hashMap);
    }

    public static void uploadApplife(boolean z) {
        a.M = z;
        m.B();
        k.n(R);
    }

    public static void uploadCrash(Throwable th) {
        if (R == null || th == null) {
            return;
        }
        k.c(R, th);
    }

    public static void uploadException(Throwable th) {
        if (th == null || R == null) {
            return;
        }
        k.a(R, th);
    }

    private static void uploadRecord(Application application) {
        if (!h.os() || a.D) {
            return;
        }
        k.a(true, (Context) application);
    }

    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        t.urlRecordEvent(motionEvent, activity);
    }
}
