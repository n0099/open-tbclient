package com.baidu.browser.sailor.util;

import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final String TAG = a.class.getSimpleName();
    private static boolean sZeusSupported = true;

    private a() {
    }

    private static String a(float f, List<Integer> list) {
        float f2 = 100.0f * (f / 6.0f);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", f > 0.0f ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
            jSONObject.put("probability", f2 + "%");
            jSONObject.put("hitreasons", list);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "unKnown";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void cD(String str) {
        FileOutputStream fileOutputStream;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getPath());
            sb.append("/baidu/flyflow/");
            new File(sb.toString()).mkdirs();
            sb.append("kernel.log");
            fileOutputStream = new FileOutputStream(sb.toString(), true);
            try {
                try {
                    fileOutputStream.write((s(System.currentTimeMillis()) + " " + str + SystemInfoUtil.LINE_END).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.i("soar", e.toString());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean qX() {
        return WebKitFactory.getCurEngine() == 1;
    }

    public static String qY() {
        int i;
        int i2;
        int i3;
        ArrayList arrayList = new ArrayList(6);
        try {
            String str = Build.BOARD;
            String str2 = Build.BOOTLOADER;
            String str3 = Build.BRAND;
            String str4 = Build.DEVICE;
            String str5 = Build.HARDWARE;
            String str6 = Build.MODEL;
            String str7 = Build.PRODUCT;
            if (str == "unknown" || str2 == "unknown" || str3 == "generic" || str4 == "generic" || str6 == "sdk" || str7 == "sdk" || str5 == "goldfish") {
                arrayList.add(1);
                i = 1;
            } else {
                i = 0;
            }
            String[] strArr = {"/dev/socket/qemud", "/dev/qemu_pipe"};
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    break;
                } else if (new File(strArr[i4]).exists()) {
                    arrayList.add(2);
                    i++;
                    break;
                } else {
                    i4++;
                }
            }
            File file = new File("/proc/tty/drivers");
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[(int) file.length()];
                try {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        fileInputStream.read(bArr);
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
                if (new String(bArr).indexOf("goldfish") != -1) {
                    arrayList.add(3);
                    i++;
                }
            }
            String[] strArr2 = {"15555215554", "15555215556", "15555215558", "15555215560", "15555215562", "15555215564", "15555215566", "15555215568", "15555215570", "15555215572", "15555215574", "15555215576", "15555215578", "15555215580", "15555215582", "15555215584"};
            TelephonyManager telephonyManager = (TelephonyManager) com.baidu.browser.sailor.a.qq().getAppContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            String line1Number = telephonyManager.getLine1Number();
            int i5 = 0;
            while (true) {
                if (i5 >= 16) {
                    break;
                } else if (strArr2[i5].equalsIgnoreCase(line1Number)) {
                    arrayList.add(4);
                    i++;
                    break;
                } else {
                    i5++;
                }
            }
            if (((TelephonyManager) com.baidu.browser.sailor.a.qq().getAppContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperatorName().toLowerCase().equals(HttpConstants.OS_TYPE_VALUE)) {
                arrayList.add(5);
                i2 = i + 1;
            } else {
                i2 = i;
            }
            if (telephonyManager != null) {
                String[] strArr3 = {Config.NULL_DEVICE_ID, "e21833235b6eef10", "012345678912345"};
                String deviceId = telephonyManager.getDeviceId();
                for (int i6 = 0; i6 < 3; i6++) {
                    if (strArr3[i6].equalsIgnoreCase(deviceId)) {
                        arrayList.add(6);
                        i3 = i2 + 1;
                        break;
                    }
                }
            }
            i3 = i2;
            return a(i3, arrayList);
        } catch (Exception e3) {
            Log.printStackTrace(e3);
            return "unKnown";
        }
    }

    public static String s(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (calendar.get(2) + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(5) + " " + calendar.get(11) + ":" + calendar.get(12) + ":" + calendar.get(13);
    }
}
