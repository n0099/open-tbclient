package com.baidu.crabsdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.crabsdk.a.b;
import com.baidu.crabsdk.a.c;
import com.baidu.crabsdk.b.d;
import com.baidu.crabsdk.b.g;
import com.baidu.crabsdk.b.i;
import com.baidu.crabsdk.b.m;
import com.baidu.crabsdk.b.n;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.b.p;
import com.baidu.crabsdk.b.t;
import com.baidu.crabsdk.b.u;
import com.baidu.crabsdk.sender.NativeCrashHandler;
import com.baidu.crabsdk.sender.f;
import com.baidu.crabsdk.sender.h;
import com.baidu.crabsdk.sender.k;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
/* loaded from: classes8.dex */
public class CrabSDK {
    public static final int ANR_CLOSE = 0;
    public static final int ANR_OBSERVER_LOGCAT = 1;
    public static final int ANR_OBSERVER_PROC_STATE = 2;
    private static Application T;
    public static String NDK_VERSION = "-1";
    public static String FILE_PATH = "/sdcard";
    public static int CURRENT_PID = 0;
    public static String CURRENT_PNAME = "";
    private static boolean U = false;

    public static void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        d.dispatchTouchEvent(motionEvent, activity);
    }

    public static void closeAnrHandler() {
        a.I = 0;
    }

    public static void disableBlockCatch() {
        if (b.su() == null) {
            com.baidu.crabsdk.c.a.w("Block Monitor has never been enabled!");
            return;
        }
        b.su().stop();
        c.U(T);
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
        if (h.sV()) {
            b.S(T).start();
            c.U(T);
            c.start();
        }
    }

    public static void enableBlockCatch(int i, boolean z) {
        a.s = z;
        enableBlockCatch(i);
    }

    public static HashMap<String, String> getUsersCustomKV() {
        return t.sH();
    }

    public static void init(Application application, String str) {
        init(application, str, null);
    }

    public static void init(Application application, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && ((str2.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str2.startsWith("http://")) && str2.endsWith("/"))) {
            com.baidu.crabsdk.c.a.de("Change upload domain: " + str2);
            a.O = str2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.crabsdk.c.a.w("crab init begin: " + currentTimeMillis);
        a.d = str;
        if (application == null) {
            com.baidu.crabsdk.c.a.w("crab init error caused by applcation null value");
            return;
        }
        T = application;
        FILE_PATH = application.getFilesDir().getAbsolutePath();
        com.baidu.crabsdk.c.a.v("FILE_PATH IS : " + FILE_PATH);
        initData(T, str);
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
        com.baidu.crabsdk.b.h.e(application);
        n.e(application);
        p.e(application);
        g.e(application);
        i.A();
        m.e(application);
        t.e(application);
        o.e(application);
        com.baidu.crabsdk.b.a.a(application);
    }

    private static void initCrashSwitch(Application application) {
        h.e(application);
    }

    private static void initData(Application application, String str) {
        boolean z;
        int myPid = Process.myPid();
        CURRENT_PID = myPid;
        com.baidu.crabsdk.c.a.de("CrabSDK.init from " + T.getPackageName() + " with pid " + myPid);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            com.baidu.crabsdk.c.a.de("getRunningAppProcesses error!!");
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
                    U = true;
                    com.baidu.crabsdk.c.a.de("Main process " + next.processName + ".");
                } else {
                    U = false;
                    com.baidu.crabsdk.c.a.de("Sub process " + next.processName + ".");
                }
                CURRENT_PNAME = next.processName;
                z = true;
            }
        }
        if (z) {
            initCrashSwitch(application);
            initCollector(application);
            f.sP().e(application);
            initAnrCollector(application, str);
        }
    }

    private static void initNativeHandler() {
        NativeCrashHandler.r(T).aj();
        k.j(T);
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

    public static void openNativeCrashHandler(ArrayList<String> arrayList) {
        if (arrayList != null) {
            a.M = arrayList;
        }
        openNativeCrashHandler();
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
            Thread sA = com.baidu.crabsdk.b.c.sA();
            if (sA == null) {
                initAnrCollector(T, a.d);
                com.baidu.crabsdk.c.a.v("ANR watch thread is null, init anrCollector again");
            } else if (a.I == 0) {
                a.I = i;
                new Thread(sA).start();
            } else {
                com.baidu.crabsdk.c.a.df("ANR watch thread is running");
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("resumeAnrWatchThread->Exception", e);
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
            com.baidu.crabsdk.a.a.W = i;
            return;
        }
        com.baidu.crabsdk.c.a.w("You Are Strongly Recommended To Set Threshold Not Less Than 1000ms!!");
        com.baidu.crabsdk.a.a.W = 1000;
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

    public static void setCuid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.b.h.akr = str;
    }

    public static void setDebugAnrExpUrl(String str) {
        a.S = str;
    }

    public static void setDebugCrashUrl(String str) {
        a.R = str;
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

    public static void setIsOnline(boolean z) {
        a.E = z;
    }

    public static void setLogcatLineCount(int i) {
        if (i > 1000) {
            com.baidu.crabsdk.c.a.df("强烈建议logcat最大行数小于1000！");
            a.h = 1000;
        } else {
            a.h = i;
        }
        if (NativeCrashHandler.ai() != null) {
            NativeCrashHandler.ai().b(a.h);
        }
    }

    public static void setOnAnrCrashListener(OnAnrCrashListener onAnrCrashListener) {
        a.P = onAnrCrashListener;
    }

    public static void setOnCrashExceedListener(OnCrashExceedListener onCrashExceedListener) {
        a.Q = onCrashExceedListener;
    }

    public static void setSendPrivacyInformation(boolean z) {
        a.q = z;
    }

    public static void setUid(String str) {
        t.d(str);
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
        t.setUserName(str);
    }

    public static void setUsersCustomKV(String str, String str2) {
        t.sH().put(str, str2);
    }

    public static void setUsersCustomKV(HashMap<String, String> hashMap) {
        t.a(hashMap);
    }

    public static void stopUploadLogs(Future future) {
        try {
            com.baidu.crabsdk.c.a.df("Stop uploading logs task...");
            if (future != null) {
                future.cancel(true);
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("Stop upload task error!", e);
        }
    }

    public static void uploadApplife(boolean z) {
        a.N = z;
        n.F();
        k.m(T);
    }

    public static void uploadCrash(Throwable th) {
        if (T == null || th == null) {
            return;
        }
        k.b(T, th);
    }

    public static void uploadException(Throwable th) {
        if (th == null || T == null) {
            return;
        }
        k.a(T, th);
    }

    public static Future uploadLogs(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3) {
        if (str == null || onUploadFilesCallback == null) {
            com.baidu.crabsdk.c.a.w("Filepath or callback is null!");
            return null;
        }
        if (str3 == null) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.crabsdk.b.h.akr = str2;
        }
        return k.b(str.trim(), onUploadFilesCallback, "", "", str3);
    }

    private static void uploadRecord(Application application) {
        if (!h.sR() || a.D) {
            return;
        }
        k.a(true, (Context) application);
    }

    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        u.urlRecordEvent(motionEvent, activity);
    }
}
