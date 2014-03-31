package com.baidu.batsdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import com.baidu.batsdk.b.b;
import com.baidu.batsdk.b.e;
import com.baidu.batsdk.b.f;
import com.baidu.batsdk.b.g;
import com.baidu.batsdk.f.d;
import com.baidu.batsdk.ui.BatsdkService;
import com.baidu.batsdk.ui.FeedbackActivity;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class BatSDK {
    private static Application a;
    private static SharedPreferences.OnSharedPreferenceChangeListener b;
    private static ActivityManager c;

    public static void init(Application application) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (application == null) {
            com.baidu.batsdk.f.a.d("BatSDK.init application is null.");
        } else if (a != null) {
            com.baidu.batsdk.f.a.c("BatSDK#init called more than once.");
        } else {
            a = application;
            int myPid = Process.myPid();
            com.baidu.batsdk.f.a.b("BatSDK.init from " + a.getPackageName() + " with pid " + myPid);
            c = (ActivityManager) a.getSystemService("activity");
            Iterator<ActivityManager.RunningAppProcessInfo> it = c.getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    if (next.processName.equals(a.getPackageName())) {
                        com.baidu.batsdk.f.a.a("Main process " + next.processName + ", do init.");
                        z = true;
                    } else {
                        com.baidu.batsdk.f.a.a("Sub process " + next.processName + ", NOT init.");
                        return;
                    }
                }
            }
            if (!z) {
                com.baidu.batsdk.f.a.c("Unknown process, NOT init.");
                return;
            }
            com.baidu.batsdk.f.a.b("With BatConfig " + b.a(a.class));
            com.baidu.batsdk.f.a.a(a);
            d.a(a);
            b.c(a);
            e.a(a);
            com.baidu.batsdk.e.b.b(a);
            f.a(a);
            g.a(a);
            com.baidu.batsdk.b.a.a(a);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a);
            b = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.baidu.batsdk.BatSDK.1
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    com.baidu.batsdk.f.a.a("onSharedPreferenceChanged key[" + str + "].");
                }
            };
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(b);
            if (a.a) {
                new com.baidu.batsdk.c.a(a);
            }
            Intent intent = new Intent(a, BatsdkService.class);
            intent.putExtra("action", "startOfAll");
            a.startService(intent);
            com.baidu.batsdk.f.a.b("BatSDK.init over, taken: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static boolean saveFeedbackRecord(String str, String str2) {
        if (str == null || "" == str || str.length() == 0) {
            return false;
        }
        if (str2 != null && str2.length() > 0) {
            g.a(str2);
        }
        Map<String, Object> l = b.l(a);
        l.put("content", str);
        l.put("uname", str2);
        b.b(a, b.a(l));
        com.baidu.batsdk.a.d.b = System.currentTimeMillis();
        com.baidu.batsdk.a.a.a();
        return true;
    }

    public static void showFeedbackActivity() {
        b.a(a, "信息收集中...", 0);
        Map<String, Object> l = b.l(a);
        Intent intent = new Intent(a, FeedbackActivity.class);
        b.a(l, intent);
        intent.addFlags(268435456);
        a.startActivity(intent);
    }

    public static void doActivityStart(Activity activity) {
        if (activity == null) {
            com.baidu.batsdk.f.a.d("doActivityStart activity is null.");
        } else {
            com.baidu.batsdk.b.a.a(activity);
        }
    }

    public static void doActivityStop(Activity activity) {
        if (activity == null) {
            com.baidu.batsdk.f.a.d("doActivityStop activity is null.");
        } else {
            com.baidu.batsdk.b.a.b(activity);
        }
    }

    public static void switchFeedback(boolean z) {
        a.b = z;
    }

    public static void switchCrash(boolean z) {
        a.a = z;
    }

    public static void switchSync(boolean z) {
        a.c = z;
    }

    public static void setExpireAtTime(long j) {
        a.e = j;
    }

    public static void setExpireAfterPeriod(long j) {
        a.d = j;
    }

    public static void setExpireUpdateUrl(String str) {
        a.f = str;
    }

    public static void setIfNeedExpireReminder(boolean z) {
        a.g = z;
    }

    public static void setSyncInterval(long j) {
        if (j > 0) {
            a.h = j;
        }
    }

    public static void setCleanInterval(long j) {
        if (j > 0) {
            a.i = j;
        }
    }

    public static void setDebug(boolean z) {
        a.j = z;
    }

    public static void setDeveloperName(String str) {
        a.k = str;
    }

    public static void setChannel(String str) {
        a.l = str;
    }

    public static void setAppKey(String str) {
        a.m = str;
    }

    public static void setProductKey(String str) {
        a.m = str;
    }

    public static void setMaxActivityQueue(int i) {
        if (i > 0) {
            a.n = i;
        }
    }

    public static void setLogcatOnlyMyapp(boolean z) {
        a.p = z;
    }

    public static void setLogcatTailCount(int i) {
        if (i > 0) {
            a.o = i;
        }
    }

    public static void setDropboxMaxBytes(int i) {
        if (i > 0) {
            a.q = i;
        }
    }

    public static void setPicCompressQuality(int i) {
        if (i > 0) {
            a.r = i;
        }
    }

    public static void setToastCrashText(String str) {
        if (str != null) {
            a.s = str;
        }
    }

    public static void setLogLevel(int i) {
        if (i > 0 && i < 5) {
            a.t = i;
        }
    }

    public static void setUploadInterval(int i) {
        if (i > 0) {
            a.v = i;
        }
    }

    public static void setUploadWhenMobile(boolean z) {
        a.w = z;
    }

    public static void setUploadConfirmWhenMobile(boolean z) {
        a.x = z;
    }

    public static void setMinMobileUploadIntervel(long j) {
        if (j > 0) {
            a.y = j;
        }
    }

    public static void setUploadConnectionTimeout(int i) {
        if (i > 0) {
            a.z = i;
        }
    }

    public static void setUploadRetryTimes(int i) {
        if (i > 0) {
            a.A = i;
        }
    }

    public static void setIfNeedCompress(boolean z) {
        a.B = z;
    }

    public static void collectScreenshot(boolean z) {
        a.C = z;
    }

    public static void collectNetworkInfo(boolean z) {
        a.E = z;
    }

    public static void collectLogcat(boolean z) {
        a.F = z;
    }

    public static void collectDropbox(boolean z) {
        a.G = z;
    }

    public static void collectDeviceInfo(boolean z) {
        a.H = z;
    }

    public static void collectAppCurConfig(boolean z) {
        a.I = z;
    }

    public static void collectSystemSetting(boolean z) {
        a.J = z;
    }

    public static void collectSecureSetting(boolean z) {
        a.K = z;
    }

    public static void collectGlobalSetting(boolean z) {
        a.L = z;
    }

    public static void collectScreenInfo(boolean z) {
        a.M = z;
    }

    public static void collectDefaultSharedPref(boolean z) {
        a.N = z;
    }

    public static void collectAllThreadStacks(boolean z) {
        a.O = z;
    }

    public static void collectInternalStorageInfo(boolean z) {
        a.P = z;
    }

    public static void collectCPUStat(boolean z) {
        a.Q = z;
    }

    public static void collectMyAppCPUStat(boolean z) {
        a.R = z;
    }

    public static void collectMemInfo(boolean z) {
        a.S = z;
    }

    public static void collectAllProcessInfo(boolean z) {
        a.T = z;
    }

    public static void collectInstalledPackages(boolean z) {
        a.U = z;
    }
}
