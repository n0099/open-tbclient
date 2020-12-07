package com.baidu.browser.sailor.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.browser.core.INoProGuard;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class BdZeusUtil implements INoProGuard {
    private static final String ARCH_ARM = "armv";
    private static final int ARCH_ARM_INT = 7;
    private static final String DEFAULT_TNNUMBER = "1200a";
    public static final String KERNEL_PATH = "/baidu/flyflow/";
    private static final String OS_ARCH = "os.arch";
    private static final String TIME_SEPERATOR = "-";
    protected static final String URL_KEY_APP_FROM = "from";
    protected static final String URL_KEY_APP_VERSION = "appversion";
    protected static final String URL_KEY_BLINK_VER = "zeus_ver";
    protected static final String URL_KEY_CUID = "cuid";
    protected static final String URL_KEY_MACHINE = "dev";
    protected static final String URL_KEY_SDK_APP = "app";
    protected static final String URL_KEY_ZEUS_SDK = "sdk";
    private static final int sTotalEmulatorCheckReasons = 6;
    private static boolean sZeusSupportedLoaded;
    private static final String TAG = BdZeusUtil.class.getSimpleName();
    private static boolean sZeusSupported = true;

    private BdZeusUtil() {
    }

    private static void appendUrlParam(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append(ETAG.ITEM_SEPARATOR);
    }

    public static String checkEmulator() {
        return "unKnown";
    }

    private static String dealWithEmulatorResult(float f, List<Integer> list) {
        float f2 = 100.0f * (f / 6.0f);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", f > 0.0f ? "true" : "false");
            jSONObject.put("probability", f2 + "%");
            jSONObject.put("hitreasons", list);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "unKnown";
        }
    }

    public static void deleteCookieFile(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        File file = new File(context.getApplicationContext().getDatabasePath("dummy").getParent() + "/webviewCookiesChromium.db");
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
            } catch (Exception e) {
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

    private static String getDeviceInfo() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "-"));
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(str2);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(i);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(str3.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "-"));
        return stringBuffer.toString().replace(" ", "-");
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getTnNumbersFromApk(Context context) {
        InputStream inputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = context.getResources().openRawResource(context.getResources().getIdentifier("tnconfig", "raw", context.getPackageName()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
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
                    } catch (Exception e) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return trim;
                        } catch (Exception e2) {
                            return trim;
                        }
                    }
                    return trim;
                } catch (Exception e3) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    inputStream2 = inputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    return DEFAULT_TNNUMBER;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                inputStream2 = inputStream;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Exception e9) {
            inputStream2 = null;
        } catch (Throwable th4) {
            inputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static boolean guessIsMobileSiteByUrl(String str) {
        if (str != null && str.length() > 0) {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (host != null && host.length() > 0 && (host.startsWith("m.") || host.startsWith("3g.") || host.startsWith("wap.") || host.startsWith("waps.") || host.startsWith("mobile.") || host.indexOf(".m.") != -1 || host.indexOf(".3g.") != -1 || host.indexOf(".wap.") != -1 || host.indexOf(".waps.") != -1 || host.indexOf(".mobile.") != -1)) {
                return true;
            }
            String path = parse.getPath();
            if (path != null && path.length() > 0 && (path.indexOf("/mobile/") != -1 || path.indexOf("/wap/") != -1 || path.indexOf("/3g/") != -1)) {
                return true;
            }
        }
        return false;
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
        Log.i(TAG, "printKernelLog: " + formatdetailTime(System.currentTimeMillis()) + " " + str + "\r\n");
    }

    public static String processUrl(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        String zeusVersionByUpdate = WebKitVersionBlink.getZeusVersionByUpdate();
        String sdkVersionName = WebKitFactory.getSdkVersionName();
        Log.w("sdk in=" + zeusVersionByUpdate);
        Log.w("sdk out=" + sdkVersionName);
        appendUrlParam(sb, "zeus_ver", zeusVersionByUpdate);
        sb.append(ETAG.ITEM_SEPARATOR);
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
