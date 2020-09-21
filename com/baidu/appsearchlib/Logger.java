package com.baidu.appsearchlib;

import android.app.ActivityManager;
import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/* loaded from: classes14.dex */
public class Logger {
    static final String LOG_SERVER = "http://nsclick.baidu.com/v.gif";
    static final HashSet<Integer> LOG_TIMES = new HashSet<>();
    static final long ONE_SECOND = 1000;
    private static ActivityManager activityManager;
    private static Runnable checkThread;
    public static long lastCallTime;
    public static long lastStartTime;
    public static boolean looperDisabled;
    private static String packageName;
    static ExecutorService pool;

    static {
        LOG_TIMES.add(2);
        LOG_TIMES.add(6);
        LOG_TIMES.add(15);
        LOG_TIMES.add(30);
        LOG_TIMES.add(45);
        LOG_TIMES.add(60);
        pool = Executors.newFixedThreadPool(10);
        looperDisabled = false;
        lastCallTime = 0L;
        lastStartTime = 0L;
    }

    public static void onClientBoot(Context context) {
        if (lastStartTime < 1) {
            lastStartTime = Util.getTime();
            recordCustomAction(context, "appstart");
            checkOnForeground(context.getApplicationContext());
        }
    }

    public static void onCallUp() {
        lastCallTime = Util.getTime();
    }

    public static void onAlive(Context context) {
        if (lastCallTime < 1) {
            recordClientAction(context, Info.kBaiduClient_Alive_On_Noraml, Long.valueOf(Util.getTime() - lastStartTime));
        } else {
            recordClientAction(context, Info.kBaiduClient_Alive_On_Call, Long.valueOf(Util.getTime() - lastStartTime), Long.valueOf(Util.getTime() - lastCallTime));
        }
    }

    public static void onClientExit(Context context) {
        if (lastCallTime < 1) {
            recordClientAction(context, Info.kBaiduClient_Exit_On_Noraml, Long.valueOf(Util.getTime() - lastStartTime));
        } else {
            recordClientAction(context, Info.kBaiduClient_Exit_On_Call, Long.valueOf(Util.getTime() - lastStartTime), Long.valueOf(Util.getTime() - lastCallTime));
        }
        lastCallTime = 0L;
        lastStartTime = 0L;
    }

    public static void checkOnForeground(final Context context) {
        activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        packageName = context.getPackageName();
        if (checkThread == null) {
            checkThread = new Thread() { // from class: com.baidu.appsearchlib.Logger.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    int i = 0;
                    while (!Logger.looperDisabled) {
                        try {
                            Thread.sleep(1000L);
                            i++;
                            if (Logger.isAppOnForeground()) {
                                if (Logger.LOG_TIMES.contains(Integer.valueOf(i))) {
                                    Logger.onAlive(context);
                                }
                            } else {
                                Logger.onClientExit(context);
                                Logger.checkThread = null;
                                return;
                            }
                        } catch (Exception e) {
                            Logger.checkThread = null;
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            };
            pool.execute(checkThread);
        }
    }

    public static boolean isAppOnForeground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static void recordCustomAction(Context context, String str) {
        recordClientAction(context, "%s=%s", Info.kBaiduClientActionKey, str);
    }

    public static void recordClientAction(Context context, String str, Object... objArr) {
        recordAction(context, "&%s=%s&%s", Info.kBaiduActionType, Info.kBaiduClientActionKey, String.format(str, objArr));
    }

    public static void recordServerAction(Context context, String str, Object... objArr) {
        recordAction(context, "&%s=%s&%s", Info.kBaiduActionType, Info.kBaiduServerActionKey, String.format(str, objArr));
    }

    public static void recordAction(Context context, String str, Object... objArr) {
        reportWithString(context, String.format(str, objArr));
    }

    public static void reportWithString(Context context, String str) {
        String timeStr = Util.getTimeStr();
        String encode = encode(Util.getDeviceId(context));
        reportWithUrl(String.valueOf(String.valueOf(String.valueOf(String.format("%s?%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", LOG_SERVER, "pid", Info.kBaiduPIDValue, Info.kBaiduPJKey, Info.kBaiduPJValue, Info.kBaiduVersionKey, encode(Util.getCurrentVersion(context)), "t", timeStr, Info.kBaiduDevice, encode(Util.getPlatformCode()), Info.kBaiduOpenudid, encode, Info.kBaiduIOSVersion, encode(Util.getOSVersion()), Info.kBaiduModuleKey, Info.kBaiduBaseModule, Info.kBaiduAppIDKey, Info.APPID, Info.kBaiduSDKVersionKey, Info.SDK_VERSION, "vcode1", Md5Util.getMd5(String.valueOf(timeStr) + encode + Info.PASSWORD))) + str) + "&vcode2=") + Md5Util.getMd5(String.valueOf(timeStr) + encode + Info.PASSWORD + str));
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void reportWithUrl(final String str) {
        pool.execute(new Thread() { // from class: com.baidu.appsearchlib.Logger.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    new DefaultHttpClient().execute(new HttpGet(str));
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }
}
