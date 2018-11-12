package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SmsService;
import com.baidu.sapi2.base.debug.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
/* loaded from: classes.dex */
public class SapiCoreUtil {
    public static final String TAG = SapiCoreUtil.class.getSimpleName();
    private static final String a = "file:///android_asset/";

    public static boolean sendSms(String str, String str2) {
        return sendSms(str, str2, null, null);
    }

    @TargetApi(4)
    public static boolean sendSms(String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        try {
            return SmsService.sendSms(str2, str, pendingIntent, pendingIntent2);
        } catch (Throwable th) {
            return false;
        }
    }

    public static InputStream getCacheInputStream(Context context, String str) {
        InputStream fileInputStream;
        try {
            if (str.startsWith(a)) {
                fileInputStream = context.getAssets().open(str.replace(a, ""));
            } else {
                fileInputStream = new FileInputStream(str);
            }
            return fileInputStream;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean chmodFile(Context context, File file) {
        Process process;
        String str = 0;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                String packageName = context.getPackageName();
                process = null;
                while (!packageName.equals(file.getName())) {
                    try {
                        process = file.isDirectory() ? runtime.exec("chmod 701 " + file) : runtime.exec("chmod 664 " + file);
                        file = file.getParentFile();
                    } catch (Exception e) {
                        e = e;
                        Log.e(e);
                        if (process != null) {
                            process.destroy();
                        }
                        if (r0 != 0) {
                        }
                    }
                }
                String parseExecutePer = parseExecutePer(getExecResult(context.getApplicationInfo().dataDir));
                if (TextUtils.isEmpty(parseExecutePer)) {
                    parseExecutePer = "701";
                    str = "chmod 701 " + file;
                } else if (parseExecutePer.substring(2, 3).equals("0")) {
                    str = "chmod " + parseExecutePer.substring(0, 2) + "1 " + file;
                }
                Log.e(TAG, "chmodFile", "command", str, "originPer", parseExecutePer);
                if (str != 0) {
                    process = runtime.exec(str);
                    if (TextUtils.isEmpty(SapiContext.getInstance(context).getPackageDirExecutePer())) {
                        SapiContext.getInstance(context).setPackageDirExecutePer(parseExecutePer);
                    }
                }
                r0 = process != null ? process.waitFor() : -1;
                if (process != null) {
                    process.destroy();
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    str.destroy();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            process = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return r0 != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [154=4] */
    public static String getExecResult(String str) {
        Process process;
        Throwable th;
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            process = Runtime.getRuntime().exec("ls -ld " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                try {
                    str2 = bufferedReader.readLine();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                } catch (IOException e2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (IOException e6) {
            bufferedReader = null;
            process = null;
        } catch (Throwable th4) {
            process = null;
            th = th4;
            bufferedReader = null;
        }
        return str2;
    }

    public static String parseExecutePer(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        String str2 = "";
        HashMap hashMap = new HashMap();
        hashMap.put("r", 4);
        hashMap.put(Config.DEVICE_WIDTH, 2);
        hashMap.put(Config.EVENT_HEAT_X, 1);
        hashMap.put(Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0);
        int i = 1;
        int i2 = 0;
        while (i < 10) {
            Integer num = (Integer) hashMap.get(str.substring(i, i + 1));
            if (num == null) {
                return null;
            }
            int intValue = num.intValue() + i2;
            if (i % 3 == 0) {
                str2 = str2 + intValue;
                intValue = 0;
            }
            i++;
            i2 = intValue;
        }
        if (str2.length() != 3) {
            return null;
        }
        return str2;
    }
}
