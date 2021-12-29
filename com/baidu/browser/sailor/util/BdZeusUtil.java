package com.baidu.browser.sailor.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.core.INoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public final class BdZeusUtil implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-887296377, "Lcom/baidu/browser/sailor/util/BdZeusUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-887296377, "Lcom/baidu/browser/sailor/util/BdZeusUtil;");
        }
    }

    public BdZeusUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void appendUrlParam(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, sb, str, str2) == null) || sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("&");
    }

    public static String checkEmulator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "unKnown" : (String) invokeV.objValue;
    }

    public static String dealWithEmulatorResult(float f2, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), list})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static void deleteCookieFile(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, context) == null) || context == null || context.getApplicationContext() == null) {
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, file)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return deleteFile(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean forceNoZeus() {
        InterceptResult invokeV;
        boolean forceNoZeus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (BdZeusUtil.class) {
                forceNoZeus = WebKitFactory.forceNoZeus();
            }
            return forceNoZeus;
        }
        return invokeV.booleanValue;
    }

    public static String formatdetailTime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j2)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            return calendar.get(1) + "-" + (calendar.get(2) + 1) + "-" + calendar.get(5) + " " + calendar.get(11) + ":" + calendar.get(12) + ":" + calendar.get(13);
        }
        return (String) invokeJ.objValue;
    }

    public static String getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static PackageInfo getPackageInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static String getTnNumbersFromApk(Context context) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65548, null, context)) != null) {
            return (String) invokeL.objValue;
        }
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
                    } catch (Exception unused) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return trim;
                } catch (Exception unused3) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return DEFAULT_TNNUMBER;
                        } catch (Exception unused5) {
                            return DEFAULT_TNNUMBER;
                        }
                    }
                    return DEFAULT_TNNUMBER;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Exception unused9) {
            inputStream = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
    }

    public static boolean guessIsMobileSiteByUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean isWebkitLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? WebKitFactory.getCurEngine() == 1 : invokeV.booleanValue;
    }

    public static synchronized boolean isZeusSupported() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (BdZeusUtil.class) {
                if (!sZeusSupportedLoaded) {
                    sZeusSupportedLoaded = WebKitFactory.isZeusSupported();
                }
                z = sZeusSupported;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static void printKernellog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            String str2 = TAG;
            Log.i(str2, "printKernelLog: " + formatdetailTime(System.currentTimeMillis()) + " " + str + "\r\n");
        }
    }

    public static String processUrl(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, context)) == null) {
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
        return (String) invokeLL.objValue;
    }
}
