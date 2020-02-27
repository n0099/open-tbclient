package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SmsService;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class e {
    public static final String a = "e";
    private static final String b = "file:///android_asset/";

    @TargetApi(4)
    public static void a(Context context, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2, RequestSMSCallback requestSMSCallback) {
        try {
            SmsService.sendSms(context, str2, str, pendingIntent, pendingIntent2, requestSMSCallback);
        } catch (Throwable th) {
            requestSMSCallback.sendSmsResult(false);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        String str2 = "";
        HashMap hashMap = new HashMap();
        hashMap.put("r", 4);
        hashMap.put("w", 2);
        hashMap.put(Config.EVENT_HEAT_X, 1);
        hashMap.put(Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0);
        int i = 1;
        int i2 = 0;
        while (i < 10) {
            int i3 = i + 1;
            Integer num = (Integer) hashMap.get(str.substring(i, i3));
            if (num == null) {
                return null;
            }
            int intValue = num.intValue() + i2;
            if (i % 3 == 0) {
                str2 = str2 + intValue;
                intValue = 0;
            }
            i = i3;
            i2 = intValue;
        }
        if (str2.length() != 3) {
            return null;
        }
        return str2;
    }

    public static void a(Context context, Handler handler, RequestSMSCallback requestSMSCallback) {
        try {
            SmsService.registerReceiver(context, handler, requestSMSCallback);
        } catch (Throwable th) {
            requestSMSCallback.receiverResult(null);
        }
    }

    public static InputStream a(Context context, String str) {
        InputStream fileInputStream;
        try {
            if (str.startsWith(b)) {
                fileInputStream = context.getAssets().open(str.replace(b, ""));
            } else {
                fileInputStream = new FileInputStream(str);
            }
            return fileInputStream;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0123 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:? */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v11, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v15, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v22, resolved type: java.lang.Process */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0112: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:62:0x0112 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010f  */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, File file) {
        Process process;
        Process process2;
        Process process3;
        int i;
        String str;
        String str2 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                String packageName = context.getPackageName();
                Process process4 = null;
                while (!packageName.equals(file.getName())) {
                    try {
                        if (file.isDirectory()) {
                            process3 = runtime.exec("chmod 701 " + file);
                        } else {
                            process3 = runtime.exec("chmod 664 " + file);
                        }
                        try {
                            file = file.getParentFile();
                            process4 = process3;
                        } catch (Exception e) {
                            e = e;
                            Log.e(e);
                            if (process3 != 0) {
                                process3.destroy();
                            }
                            i = -1;
                            if (i == 0) {
                            }
                        }
                    } catch (Exception e2) {
                        str2 = process4;
                        e = e2;
                        process3 = str2;
                        Log.e(e);
                        if (process3 != 0) {
                        }
                        i = -1;
                        if (i == 0) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        process = process4;
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                }
                String b2 = b(a(context.getApplicationInfo().dataDir));
                if (TextUtils.isEmpty(b2)) {
                    str2 = "chmod 701 " + file;
                    str = "701";
                } else if (b2.substring(2, 3).equals("0")) {
                    str2 = "chmod " + b2.substring(0, 2) + "1 " + file;
                    str = b2;
                } else {
                    str = b2;
                }
                String str3 = a;
                Object[] objArr = new Object[5];
                objArr[0] = "chmodFile";
                objArr[1] = "command";
                objArr[2] = str2;
                objArr[3] = "originPer";
                objArr[4] = str;
                Log.e(str3, objArr);
                if (str2 != null) {
                    Process exec = runtime.exec(str2);
                    process3 = exec;
                    if (TextUtils.isEmpty(SapiContext.getInstance(context).getPackageDirExecutePer())) {
                        SapiContext.getInstance(context).setPackageDirExecutePer(str);
                        process3 = exec;
                    }
                } else {
                    process3 = process4;
                }
                i = process3 != 0 ? process3.waitFor() : -1;
                if (process3 != 0) {
                    process3.destroy();
                }
            } catch (Throwable th2) {
                th = th2;
                process = process2;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
        return i == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [35=5] */
    public static String a(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str2 = null;
        bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("ls -ld " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } catch (IOException e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            bufferedReader = null;
            process = null;
        } catch (Throwable th2) {
            th = th2;
            process = null;
        }
        try {
            str2 = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Exception e3) {
            }
            if (process != null) {
                process.destroy();
            }
        } catch (IOException e4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e6) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
        return str2;
    }
}
