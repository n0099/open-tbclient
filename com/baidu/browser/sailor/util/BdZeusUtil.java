package com.baidu.browser.sailor.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class BdZeusUtil implements INoProGuard {
    public static final String ARCH_ARM = "armv";
    public static final int ARCH_ARM_INT = 7;
    public static final String DEFAULT_TNNUMBER = "1200a";
    public static final String KERNEL_PATH = "/baidu/flyflow/";
    public static final String OS_ARCH = "os.arch";
    public static final String TAG = "BdZeusUtil";
    public static final String TIME_SEPERATOR = "-";
    public static final String URL_KEY_APP_FROM = "from";
    public static final String URL_KEY_APP_VERSION = "appversion";
    public static final String URL_KEY_BLINK_VER = "zeus_ver";
    public static final String URL_KEY_CUID = "cuid";
    public static final String URL_KEY_MACHINE = "dev";
    public static final String URL_KEY_SDK_APP = "app";
    public static final String URL_KEY_ZEUS_SDK = "sdk";
    public static final int sTotalEmulatorCheckReasons = 6;
    public static boolean sZeusSupported = true;
    public static boolean sZeusSupportedLoaded;

    public static void appendUrlParam(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("&");
    }

    public static String checkEmulator() {
        return "unKnown";
    }

    public static String dealWithEmulatorResult(float f2, List<Integer> list) {
        float f3 = (f2 / 6.0f) * 100.0f;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", f2 > 0.0f ? "true" : "false");
            jSONObject.put("probability", f3 + "%");
            jSONObject.put("hitreasons", list);
            return jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "unKnown";
        }
    }

    public static void deleteCookieFile(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        String parent = context.getApplicationContext().getDatabasePath(BitmapPoolType.DUMMY).getParent();
        File file = new File(parent + "/webviewCookiesChromium.db");
        if (!file.exists() || file.delete()) {
            return;
        }
        Log.v("CookieManager", "----in file delete failed");
    }

    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(file);
        while (stack.size() > 0) {
            try {
                File file2 = (File) stack.pop();
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        File[] listFiles = file2.listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            stack.push(file2);
                            for (File file3 : listFiles) {
                                stack.push(file3);
                            }
                        } else if (!file2.delete()) {
                            return false;
                        }
                    } else if (!file2.delete()) {
                        return false;
                    }
                }
            } catch (Exception unused) {
                Log.e(TAG, "Delete zeus file error.");
                return false;
            }
        }
        return true;
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return deleteFile(new File(str));
    }

    public static synchronized boolean forceNoZeus() {
        boolean forceNoZeus;
        synchronized (BdZeusUtil.class) {
            forceNoZeus = WebKitFactory.forceNoZeus();
        }
        return forceNoZeus;
    }

    public static String formatdetailTime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1) + "-" + (calendar.get(2) + 1) + "-" + calendar.get(5) + " " + calendar.get(11) + ":" + calendar.get(12) + ":" + calendar.get(13);
    }

    public static String getDeviceInfo() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.replace("_", "-"));
        stringBuffer.append("_");
        stringBuffer.append(str2);
        stringBuffer.append("_");
        stringBuffer.append(i2);
        stringBuffer.append("_");
        stringBuffer.append(str3.replace("_", "-"));
        return stringBuffer.toString().replace(" ", "-");
    }

    public static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getTnNumbersFromApk(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = context.getResources().openRawResource(context.getResources().getIdentifier("tnconfig", "raw", context.getPackageName()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception unused) {
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
                th = th2;
            }
        } catch (Exception unused2) {
            inputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String trim = new String(byteArrayOutputStream.toByteArray()).trim();
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused4) {
                }
            }
            return trim;
        } catch (Exception unused5) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused6) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return DEFAULT_TNNUMBER;
                } catch (Exception unused7) {
                    return DEFAULT_TNNUMBER;
                }
            }
            return DEFAULT_TNNUMBER;
        } catch (Throwable th4) {
            th = th4;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused8) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused9) {
                }
            }
            throw th;
        }
    }

    public static boolean guessIsMobileSiteByUrl(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null || host.length() <= 0 || (!host.startsWith("m.") && !host.startsWith("3g.") && !host.startsWith("wap.") && !host.startsWith("waps.") && !host.startsWith("mobile.") && host.indexOf(".m.") == -1 && host.indexOf(".3g.") == -1 && host.indexOf(".wap.") == -1 && host.indexOf(".waps.") == -1 && host.indexOf(".mobile.") == -1)) {
            String path = parse.getPath();
            if (path == null || path.length() <= 0) {
                return false;
            }
            return (path.indexOf("/mobile/") == -1 && path.indexOf("/wap/") == -1 && path.indexOf("/3g/") == -1) ? false : true;
        }
        return true;
    }

    public static boolean isWebkitLoaded() {
        return WebKitFactory.getCurEngine() == 1;
    }

    public static synchronized boolean isZeusSupported() {
        boolean z;
        synchronized (BdZeusUtil.class) {
            if (!sZeusSupportedLoaded) {
                sZeusSupportedLoaded = WebKitFactory.isZeusSupported();
            }
            z = sZeusSupported;
        }
        return z;
    }

    public static void printKernellog(String str) {
        String str2 = TAG;
        Log.i(str2, "printKernelLog: " + formatdetailTime(System.currentTimeMillis()) + " " + str + Part.CRLF);
    }

    public static String processUrl(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        String zeusVersionByUpdate = WebKitVersionBlink.getZeusVersionByUpdate();
        String sdkVersionName = WebKitFactory.getSdkVersionName();
        Log.w("sdk in=".concat(String.valueOf(zeusVersionByUpdate)));
        Log.w("sdk out=".concat(String.valueOf(sdkVersionName)));
        appendUrlParam(sb, "zeus_ver", zeusVersionByUpdate);
        sb.append("&");
        if (!TextUtils.isEmpty(sdkVersionName)) {
            appendUrlParam(sb, "sdk", sdkVersionName);
        }
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            appendUrlParam(sb, "app", packageName);
        }
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo != null) {
            String str2 = packageInfo.versionName;
            if (!TextUtils.isEmpty(str2)) {
                appendUrlParam(sb, "appversion", str2);
            }
        }
        String tnNumbersFromApk = getTnNumbersFromApk(context);
        if (!TextUtils.isEmpty(tnNumbersFromApk)) {
            sb.append("from");
            sb.append("=");
            sb.append(tnNumbersFromApk);
        }
        return sb.toString();
    }
}
