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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class CrabSDK {
    public static final int ANR_CLOSE = 0;
    public static final int ANR_OBSERVER_LOGCAT = 1;
    public static final int ANR_OBSERVER_PROC_STATE = 2;
    public static int CURRENT_PID = 0;
    public static String CURRENT_PNAME = "";
    public static String FILE_PATH = "/sdcard";
    public static String NDK_VERSION = "-1";
    public static Application T = null;
    public static boolean U = false;

    public static void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        d.c(motionEvent, activity);
    }

    public static void closeAnrHandler() {
        a.I = 0;
    }

    public static void disableBlockCatch() {
        if (b.c() == null) {
            com.baidu.crabsdk.c.a.d("Block Monitor has never been enabled!");
            return;
        }
        b.c().e();
        c.b(T);
        c.f();
    }

    @Deprecated
    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        d.c(motionEvent, activity);
    }

    public static void doActivityStart(Activity activity) {
        com.baidu.crabsdk.b.a.e(activity);
    }

    public static void doActivityStop(Activity activity) {
        com.baidu.crabsdk.b.a.f(activity);
    }

    public static void enableBlockCatch(int i2) {
        if (Build.VERSION.SDK_INT < 16) {
            com.baidu.crabsdk.c.a.d("ERROR! BlockCatch only can be enabled when SDK_INT >= 16");
            return;
        }
        setUploadLimitOfBlockInOneday(i2);
        if (h.i()) {
            b.a(T).d();
            c.b(T);
            c.e();
        }
    }

    public static void enableBlockCatch(int i2, boolean z) {
        a.s = z;
        enableBlockCatch(i2);
    }

    public static HashMap<String, String> getUsersCustomKV() {
        return t.b();
    }

    public static void init(Application application, String str) {
        init(application, str, null);
    }

    public static void init(Application application, String str, String str2) {
        long currentTimeMillis;
        String str3;
        if (!TextUtils.isEmpty(str2) && ((str2.startsWith("https://") || str2.startsWith("http://")) && str2.endsWith("/"))) {
            com.baidu.crabsdk.c.a.b("Change upload domain: " + str2);
            a.O = str2;
        }
        com.baidu.crabsdk.c.a.d("crab init begin: " + System.currentTimeMillis());
        a.f4782d = str;
        if (application == null) {
            str3 = "crab init error caused by applcation null value";
        } else {
            T = application;
            FILE_PATH = application.getFilesDir().getAbsolutePath();
            com.baidu.crabsdk.c.a.c("FILE_PATH IS : " + FILE_PATH);
            initData(T, str);
            long currentTimeMillis2 = System.currentTimeMillis();
            a.J = false;
            str3 = "crab init end: " + currentTimeMillis2 + ", cost: " + (currentTimeMillis2 - currentTimeMillis) + "ms";
        }
        com.baidu.crabsdk.c.a.d(str3);
    }

    public static void initAnrCollector(Application application, String str) {
        int i2;
        a.f4782d = str;
        initCollector(application);
        initCrashSwitch(application);
        if (!a.D && (i2 = a.I) != 0) {
            com.baidu.crabsdk.b.c.a(application, i2);
        }
        uploadRecord(application);
    }

    public static void initCollector(Application application) {
        com.baidu.crabsdk.b.h.b(application);
        n.d(application);
        p.e(application);
        g.a(application);
        i.a();
        m.c(application);
        t.f(application);
        o.c(application);
        com.baidu.crabsdk.b.a.b(application);
    }

    public static void initCrashSwitch(Application application) {
        h.q(application);
    }

    public static void initData(Application application, String str) {
        boolean z;
        StringBuilder sb;
        int myPid = Process.myPid();
        CURRENT_PID = myPid;
        com.baidu.crabsdk.c.a.b("CrabSDK.init from " + T.getPackageName() + " with pid " + myPid);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            com.baidu.crabsdk.c.a.b("getRunningAppProcesses error!!");
            return;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                if (next.processName.equals(application.getPackageName())) {
                    U = true;
                    sb = new StringBuilder("Main process ");
                } else {
                    U = false;
                    sb = new StringBuilder("Sub process ");
                }
                sb.append(next.processName);
                sb.append(".");
                com.baidu.crabsdk.c.a.b(sb.toString());
                CURRENT_PNAME = next.processName;
            }
        }
        if (z) {
            initCrashSwitch(application);
            initCollector(application);
            f.a().c(application);
            initAnrCollector(application, str);
        }
    }

    public static void initNativeHandler() {
        NativeCrashHandler.r(T).aj();
        k.h(T);
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

    public static void resumeAnrWatchThread(int i2) {
        try {
            Thread b2 = com.baidu.crabsdk.b.c.b();
            if (b2 == null) {
                initAnrCollector(T, a.f4782d);
                com.baidu.crabsdk.c.a.c("ANR watch thread is null, init anrCollector again");
            } else if (a.I != 0) {
                com.baidu.crabsdk.c.a.e("ANR watch thread is running");
            } else {
                a.I = i2;
                new Thread(b2).start();
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("resumeAnrWatchThread->Exception", e2);
        }
    }

    public static void setAnrObserverType(int i2) {
        if (i2 == 1 || i2 == 2) {
            a.I = i2;
        } else {
            a.I = 0;
        }
    }

    public static void setAppVersionName(String str) {
        a.o = str;
    }

    public static void setBehaviorRecordLimit(int i2) {
        a.f4784f = i2;
    }

    public static void setBlockThreshold(int i2) {
        if (i2 >= 1000) {
            com.baidu.crabsdk.a.a.f4788g = i2;
            return;
        }
        com.baidu.crabsdk.c.a.d("You Are Strongly Recommended To Set Threshold Not Less Than 1000ms!!");
        com.baidu.crabsdk.a.a.f4788g = 1000;
    }

    public static void setChannel(String str) {
        if (str == null || str.length() == 0) {
            a.f4780b = "alpha";
        } else {
            a.f4780b = str;
        }
    }

    public static void setCollectScreenshot(boolean z) {
        a.m = z;
    }

    public static void setConstantSameCrashExceedLimit(int i2) {
        a.z = i2;
    }

    public static void setCuid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.b.h.f4832a = str;
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
        a.f4779a = str;
    }

    public static void setEnableLog(boolean z) {
        a.F = z;
    }

    public static void setIsOnline(boolean z) {
        a.E = z;
    }

    public static void setLogcatLineCount(int i2) {
        if (i2 > 1000) {
            com.baidu.crabsdk.c.a.e("强烈建议logcat最大行数小于1000！");
            a.f4786h = 1000;
        } else {
            a.f4786h = i2;
        }
        if (NativeCrashHandler.ai() != null) {
            NativeCrashHandler.ai().b(a.f4786h);
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
        t.e(str);
    }

    public static void setUploadCrashOnlyWifi(boolean z) {
        a.r = z;
    }

    public static void setUploadImmediately(boolean z) {
        a.p = z;
    }

    public static void setUploadLimitOfAnrInOneday(int i2) {
        a.v = i2;
    }

    public static void setUploadLimitOfBlockInOneday(int i2) {
        a.w = i2;
    }

    public static void setUploadLimitOfCrashInOneday(int i2) {
        a.u = i2;
    }

    public static void setUploadLimitOfSameCrashInOneday(int i2) {
        a.t = i2;
    }

    public static void setUrlRecordLimit(int i2) {
        a.f4785g = i2;
    }

    public static void setUserName(String str) {
        t.h(str);
    }

    public static void setUsersCustomKV(String str, String str2) {
        t.b().put(str, str2);
    }

    public static void setUsersCustomKV(HashMap<String, String> hashMap) {
        t.d(hashMap);
    }

    public static void stopUploadLogs(Future future) {
        try {
            com.baidu.crabsdk.c.a.e("Stop uploading logs task...");
            if (future != null) {
                future.cancel(true);
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("Stop upload task error!", e2);
        }
    }

    public static void uploadApplife(boolean z) {
        a.N = z;
        n.a();
        k.k(T);
    }

    public static void uploadCrash(Throwable th) {
        Application application = T;
        if (application == null || th == null) {
            return;
        }
        k.e(application, th);
    }

    public static void uploadException(Throwable th) {
        Application application;
        if (th == null || (application = T) == null) {
            return;
        }
        k.a(application, th);
    }

    public static Future uploadLogs(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3) {
        if (str == null || onUploadFilesCallback == null) {
            com.baidu.crabsdk.c.a.d("Filepath or callback is null!");
            return null;
        }
        if (str3 == null) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.crabsdk.b.h.f4832a = str2;
        }
        return k.d(str.trim(), onUploadFilesCallback, "", "", str3);
    }

    public static void uploadRecord(Application application) {
        if (!h.a() || a.D) {
            return;
        }
        k.b(true, application);
    }

    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        u.d(motionEvent, activity);
    }
}
