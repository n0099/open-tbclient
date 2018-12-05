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
import com.baidu.crabsdk.b.e;
import com.baidu.crabsdk.b.g;
import com.baidu.crabsdk.b.h;
import com.baidu.crabsdk.b.i;
import com.baidu.crabsdk.b.l;
import com.baidu.crabsdk.b.m;
import com.baidu.crabsdk.b.n;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.b.q;
import com.baidu.crabsdk.b.r;
import com.baidu.crabsdk.b.s;
import com.baidu.crabsdk.b.t;
import com.baidu.crabsdk.sender.NativeCrashHandler;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CrabSDK {
    private static Application R;
    public static String NDK_VERSION = AiAppsAudioPlayer.ERROR_UNKNOWN;
    public static String FILE_PATH = "/sdcard";
    public static int CURRENT_PID = 0;
    private static boolean S = false;

    public static void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        d.dispatchTouchEvent(motionEvent, activity);
    }

    public static void callAfterNativeMethod() {
        try {
            NativeCrashHandler.ae().ag();
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cJ("callAfterNativeMethod error!");
        }
    }

    public static void callBeforeNativeMethod() {
        String str;
        try {
            Application application = R;
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null && stackTrace.length > 0) {
                for (int i = 0; i < stackTrace.length; i++) {
                    if (i >= 4) {
                        sb.append(stackTrace[i]).append("\n");
                    }
                }
            }
            com.baidu.crabsdk.c.a.cH("java堆栈信息是：\n" + sb.toString());
            JSONObject jSONObject = new JSONObject();
            try {
                str = q.L();
            } catch (Exception e) {
                str = "N/A";
                com.baidu.crabsdk.c.a.f("StorageCollector in callBeforeNativeMethod Error!!", e);
            }
            try {
                jSONObject.put("phoneTime", System.currentTimeMillis());
                jSONObject.put("memInfo", l.B());
                jSONObject.put("networkInfo", n.E().trim());
                jSONObject.put("uname", s.getUserName());
                jSONObject.put("uid", s.N());
                jSONObject.put("internalStorageInfo", str);
                jSONObject.put("usersCustom", s.P());
                jSONObject.put("batteryRate", g.w());
                if (stackTrace == null) {
                    jSONObject.put("javaLine", "N/A");
                } else if (stackTrace.length < 4) {
                    jSONObject.put("javaLine", stackTrace[stackTrace.length - 1]);
                } else {
                    jSONObject.put("javaLine", stackTrace[4]);
                }
                jSONObject.put("errorTrace", sb.toString());
                jSONObject.put("CUID", h.g(application));
                jSONObject.put("channel", a.b);
                jSONObject.put("myAppCPUStat", e.v());
                jSONObject.put("curPage", com.baidu.crabsdk.b.a.q());
                jSONObject.put("startupTime", com.baidu.crabsdk.b.a.rl());
                jSONObject.put("pageHistory", com.baidu.crabsdk.b.a.p());
                jSONObject.put("logcat", "");
                jSONObject.put("sysMemInfo", l.A());
                jSONObject.put("allThreadStacks", r.M());
            } catch (JSONException e2) {
                e2.printStackTrace();
                com.baidu.crabsdk.c.a.f("callBeforeNativeMethod JSON Format Error!!", e2);
            }
            try {
                NativeCrashHandler.ae().q(com.baidu.crabsdk.c.d.cM(jSONObject.toString()));
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.f("call native method nRequiredVarParams error!!", e3);
            }
        } catch (Exception e4) {
            com.baidu.crabsdk.c.a.f("callBeforeNativeMethod error!", e4);
        }
    }

    public static void closeAnrHandler() {
        a.I = false;
    }

    public static void disableBlockCatch() {
        if (b.rg() == null) {
            com.baidu.crabsdk.c.a.cJ("Block Monitor has never been enabled!");
            return;
        }
        b.rg().stop();
        c.bg(R);
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
            com.baidu.crabsdk.c.a.cJ("ERROR! BlockCatch only can be enabled when SDK_INT >= 16");
            return;
        }
        setUploadLimitOfBlockInOneday(i);
        if (com.baidu.crabsdk.sender.e.rA()) {
            b.be(R).start();
            c.bg(R);
            c.start();
        }
    }

    public static void enableBlockCatch(int i, boolean z) {
        a.s = z;
        enableBlockCatch(i);
    }

    public static HashMap<String, String> getUsersCustomKV() {
        return s.rp();
    }

    public static void init(Application application, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.crabsdk.c.a.cJ("crab init begin: " + currentTimeMillis);
        a.d = str;
        if (application == null) {
            com.baidu.crabsdk.c.a.cJ("crab init error caused by applcation null value");
            return;
        }
        R = application;
        FILE_PATH = application.getFilesDir().getAbsolutePath();
        com.baidu.crabsdk.c.a.cI("FILE_PATH IS : " + FILE_PATH);
        initData(R, str);
        long currentTimeMillis2 = System.currentTimeMillis();
        a.J = false;
        com.baidu.crabsdk.c.a.cJ("crab init end: " + currentTimeMillis2 + ", cost: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
    }

    public static void initAnrCollector(Application application, String str) {
        a.d = str;
        initCollector(application);
        initCrashSwitch(application);
        if (!a.D && a.I) {
            com.baidu.crabsdk.b.c.d(application);
        }
        uploadRecord(application);
    }

    public static void initCollector(Application application) {
        m.d(application);
        o.d(application);
        g.d(application);
        i.x();
        l.d(application);
        s.d(application);
        n.d(application);
        com.baidu.crabsdk.b.a.a(application);
    }

    private static void initCrashSwitch(Application application) {
        com.baidu.crabsdk.sender.e.d(application);
    }

    private static void initData(Application application, String str) {
        boolean z;
        int myPid = Process.myPid();
        CURRENT_PID = myPid;
        com.baidu.crabsdk.c.a.cG("CrabSDK.init from " + R.getPackageName() + " with pid " + myPid);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            com.baidu.crabsdk.c.a.cG("getRunningAppProcesses error!!");
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
                    com.baidu.crabsdk.c.a.cG("Main process " + next.processName + ".");
                    z = true;
                } else {
                    S = false;
                    com.baidu.crabsdk.c.a.cG("Sub process " + next.processName + ".");
                    z = true;
                }
            }
        }
        if (z) {
            initCrashSwitch(application);
            initCollector(application);
            com.baidu.crabsdk.sender.c.rv().d(application);
            initAnrCollector(application, str);
        }
    }

    private static void initNativeHandler() {
        NativeCrashHandler.s(R).af();
        com.baidu.crabsdk.sender.h.k(R);
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

    public static void resumeAnrWatchThread() {
        try {
            Thread rn = com.baidu.crabsdk.b.c.rn();
            if (rn == null) {
                initAnrCollector(R, a.d);
                com.baidu.crabsdk.c.a.cI("ANR watch thread is null, init anrCollector again");
            } else if (a.I) {
                com.baidu.crabsdk.c.a.v("ANR watch thread is running");
            } else {
                a.I = true;
                new Thread(rn).start();
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("resumeAnrWatchThread->Exception", e);
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
        com.baidu.crabsdk.c.a.cJ("You Are Strongly Recommended To Set Threshold Not Less Than 1000ms!!");
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
            com.baidu.crabsdk.c.a.v("强烈建议logcat最大行数小于1000！");
            a.h = 1000;
        } else {
            a.h = i;
        }
        if (NativeCrashHandler.ae() != null) {
            NativeCrashHandler.ae().b(a.h);
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
        s.d(str);
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
        HashMap<String, String> rp = s.rp();
        rp.put(str, str2);
        setUsersCustomKV(rp);
    }

    public static void setUsersCustomKV(HashMap<String, String> hashMap) {
        s.a(hashMap);
    }

    public static void uploadApplife(boolean z) {
        a.M = z;
        m.C();
        com.baidu.crabsdk.sender.h.n(R);
    }

    public static void uploadCrash(Throwable th) {
        if (R == null || th == null) {
            return;
        }
        com.baidu.crabsdk.sender.h.d(R, th);
    }

    public static void uploadException(Throwable th) {
        if (th == null || R == null) {
            return;
        }
        com.baidu.crabsdk.sender.h.a(R, th);
    }

    private static void uploadRecord(Application application) {
        if (!com.baidu.crabsdk.sender.e.rx() || a.D) {
            return;
        }
        com.baidu.crabsdk.sender.h.a(true, (Context) application);
    }

    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        t.urlRecordEvent(motionEvent, activity);
    }
}
