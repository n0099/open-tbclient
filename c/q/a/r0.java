package c.q.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.core.Info;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A(Context context, Info info) {
        InterceptResult invokeLL;
        File file;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, info)) == null) {
            try {
                String f2 = f(context, info.getOpen());
                file = new File(f2);
                if (file.exists()) {
                    try {
                        packageInfo = context.getPackageManager().getPackageArchiveInfo(f2, 1);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return false;
        }
        return invokeLL.booleanValue;
        packageInfo = null;
        if (packageInfo != null) {
            if (packageInfo.versionCode == info.getDl_vsc()) {
                return true;
            }
            if (info.getDl_vsc() == 0 && info.getDl_pkg().equals(packageInfo.packageName)) {
                return true;
            }
            y2 a = c3.a(context);
            a.j(new g3(info), packageInfo.packageName, packageInfo.versionCode, 1);
            a.m();
            file.delete();
            return false;
        }
        return false;
    }

    public static boolean B(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                return new File(e(context) + File.separator + "win" + File.separator + G(str)).exists();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static int C(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static String D(String str) {
        byte b2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes("UTF-8"));
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < digest.length; i2++) {
                    if (Integer.toHexString(digest[i2] & 255).length() == 1) {
                        stringBuffer.append("0");
                        b2 = digest[i2];
                    } else {
                        b2 = digest[i2];
                    }
                    stringBuffer.append(Integer.toHexString(b2 & 255));
                }
                return stringBuffer.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis() - m2.b(context);
            if (currentTimeMillis < 0) {
                m2.M(context);
            }
            if (currentTimeMillis > context.getSharedPreferences("_prefs", 0).getLong("bdtsi", 24L) * 3600000) {
                t2.b(new s2(context));
            }
        }
    }

    public static byte[] F(String str) {
        InterceptResult invokeL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URLDecoder.decode(str, "UTF-8")).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (-1 == read) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                        return byteArray;
                    } catch (Exception unused2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception unused5) {
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String G(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                if (str.length() > 250) {
                    str = str.substring(0, 250);
                }
                if (str.contains("/") && (split = str.split("/")) != null && split.length > 0) {
                    return split[split.length - 1];
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean H(Context context) {
        InterceptResult invokeL;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.isConnectedOrConnecting()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String I(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            File externalCacheDir = context.getExternalCacheDir();
            String absolutePath = externalCacheDir == null ? context.getCacheDir().getAbsolutePath() : externalCacheDir.getAbsolutePath();
            return absolutePath + File.separator + "adche";
        }
        return (String) invokeL.objValue;
    }

    public static boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? str == null || str.length() == 0 : invokeL.booleanValue;
    }

    public static void K(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        t2.b(new k3(optString));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static byte[] L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return new byte[0];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65548, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i2)) == null) ? (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLI.intValue;
    }

    public static int c(w1 w1Var, b6 b6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, w1Var, b6Var)) == null) {
            byte[] bArr = w1Var.f30504b;
            int i2 = w1Var.a;
            if (i2 == 200) {
                b6Var.a(new String(bArr, "UTF-8"));
                return b6Var.a;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static Intent d(Info info, Context context, String str) {
        InterceptResult invokeLLL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, info, context, str)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                try {
                    if (Build.VERSION.SDK_INT == 23) {
                        r("777", e(context) + "/win/");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                r("777", str);
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.setAction("android.intent.action.INSTALL_PACKAGE");
                    intent.setFlags(RouterCallback.CODE_ERROR);
                    fromFile = FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileProvider", new File(str));
                } else {
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    fromFile = Uri.fromFile(new File(str));
                }
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                return intent;
            } catch (Exception e3) {
                String str2 = "错误:" + e3.getMessage();
                e3.printStackTrace();
                if (info != null) {
                    y2 a = c3.a(context);
                    try {
                        a.f30529b = c3.d("wiin", new g3(info));
                        a.l("msg", c3.b(str));
                    } catch (JSONException unused) {
                    }
                    a.m();
                }
                return intent;
            }
        }
        return (Intent) invokeLLL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            return (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? context.getExternalCacheDir() : context.getCacheDir()).getPath();
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) {
            try {
                return e(context) + File.separator + "win" + File.separator + G(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("aTFob21lOGw=", 0);
            StringBuilder sb2 = new StringBuilder();
            for (byte b2 : decode) {
                sb2.append((char) b2);
            }
            sb.append(sb2.toString());
            sb.append("mloo0ks9");
            String sb3 = sb.toString();
            if (J(sb3) || J(str)) {
                str2 = "";
            } else {
                byte[] bytes = sb3.getBytes("utf-8");
                byte[] bArr = new byte[16];
                for (int i2 = 0; i2 < bytes.length && i2 < 16; i2++) {
                    bArr[i2] = bytes[i2];
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(1, secretKeySpec);
                str2 = Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 2);
            }
            if (TextUtils.isEmpty(str2)) {
                return str2;
            }
            return "KL_" + str2;
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65555, null, str, str2, i2)) == null) {
            if (i2 > 0) {
                try {
                    return str.replaceAll(str2, String.valueOf(i2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLLI.objValue;
    }

    public static String i(String str, String str2, boolean z, HashMap hashMap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{str, str2, Boolean.valueOf(z), hashMap})) == null) {
            try {
                String replaceAll = str.replaceAll("__TIMESTAMP__", String.valueOf(System.currentTimeMillis()));
                if (hashMap != null && hashMap.size() > 0) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        replaceAll = replaceAll.replaceAll((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                return z ? y(replaceAll, str2) : replaceAll;
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static HashMap j(HashMap hashMap, int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{hashMap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            hashMap.put("view_dx", Integer.valueOf(i2));
            hashMap.put("view_dy", Integer.valueOf(i3));
            hashMap.put("view_ux", Integer.valueOf(i4));
            hashMap.put("view_uy", Integer.valueOf(i5));
            hashMap.put("view_width", Integer.valueOf(i6));
            hashMap.put("view_height", Integer.valueOf(i7));
            return hashMap;
        }
        return (HashMap) invokeCommon.objValue;
    }

    public static HashMap k(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, map)) == null) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("Accept-Encoding", Collections.singletonList("application/gzip"));
            hashMap.put("Content-Encoding", Collections.singletonList("application/gzip"));
            hashMap.put("User-Agent", Collections.singletonList(d3.a));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void l(Context context, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, info) == null) {
            info.setLoad(p2.a(context, info.getLoad(), I(context), info.getMaterial(), new i2(context, info)));
        }
    }

    public static void m(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, webView) == null) {
            try {
                webView.setHorizontalScrollbarOverlay(false);
                webView.setHorizontalScrollBarEnabled(false);
                webView.setVerticalScrollbarOverlay(false);
                webView.setVerticalScrollBarEnabled(false);
                webView.setBackgroundColor(0);
                webView.setScrollBarStyle(0);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setBuiltInZoomControls(false);
                settings.setAppCacheEnabled(true);
                settings.setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());
                settings.setDatabaseEnabled(true);
                settings.setSupportZoom(false);
                settings.setDisplayZoomControls(false);
                settings.setCacheMode(-1);
                settings.setUseWideViewPort(false);
                settings.setLightTouchEnabled(false);
                settings.setLoadsImagesAutomatically(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setAllowFileAccess(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    settings.setAllowContentAccess(false);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    settings.setAllowFileAccessFromFileURLs(false);
                    settings.setAllowUniversalAccessFromFileURLs(false);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    settings.setMediaPlaybackRequiresUserGesture(false);
                }
                CookieManager cookieManager = CookieManager.getInstance();
                if (cookieManager != null) {
                    cookieManager.setAcceptCookie(true);
                    if (Build.VERSION.SDK_INT >= 21) {
                        cookieManager.setAcceptThirdPartyCookies(webView, true);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void n(Info info) {
        String vv_show_urls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, info) == null) {
            try {
                o(info, 100, "");
                if (info != null && !TextUtils.isEmpty(info.getImp_urls())) {
                    vv_show_urls = info.getImp_urls();
                } else if (info == null || TextUtils.isEmpty(info.getVv_show_urls())) {
                    return;
                } else {
                    vv_show_urls = info.getVv_show_urls();
                }
                K(vv_show_urls);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void o(Info info, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65562, null, info, i2, str) == null) || info == null) {
            return;
        }
        K(i((String) info.getEvents().get(i2, ""), str, info.isHo_c_sw(), null));
    }

    public static void p(Info info, String str) {
        String vv_click_urls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, info, str) == null) {
            try {
                o(info, 200, str);
                if (info != null && !TextUtils.isEmpty(info.getClick_urls())) {
                    vv_click_urls = info.getClick_urls();
                } else if (info == null || TextUtils.isEmpty(info.getVv_click_urls())) {
                    return;
                } else {
                    vv_click_urls = info.getVv_click_urls();
                }
                K(vv_click_urls);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void q(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, file) == null) {
            try {
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    for (File file2 : file.listFiles()) {
                        q(file2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, str, str2) == null) {
            try {
                Runtime.getRuntime().exec("chmod " + str + " " + str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void s(String str, Map map, q1 q1Var) {
        String message;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, null, str, map, q1Var) == null) {
            try {
                q1Var.a();
                w1 a = new t1(str, "GET", k(map)).a();
                b6 b6Var = new b6();
                int c2 = c(a, b6Var);
                if (c2 == 200) {
                    q1Var.a(b6Var);
                } else {
                    q1Var.a(c2, b6Var.f30293b);
                }
            } catch (JSONException e2) {
                message = e2.getMessage();
                i2 = 101;
                q1Var.a(i2, message);
            } catch (Exception e3) {
                message = e3.getMessage();
                i2 = 100;
                q1Var.a(i2, message);
            }
        }
    }

    public static void t(byte[] bArr, String str, a4 a4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65567, null, bArr, str, a4Var) == null) {
            new Thread(new x2(bArr, str, a4Var)).start();
        }
    }

    public static boolean u(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, strArr, str)) == null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static long v(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, file)) == null) {
            if (!file.exists()) {
                throw new IllegalArgumentException(file + " does not exist");
            } else if (!file.isDirectory()) {
                throw new IllegalArgumentException(file + " is not a directory");
            } else {
                long j2 = 0;
                for (File file2 : file.listFiles()) {
                    j2 = (file2.isDirectory() ? v(file2) : file2.length()) + j2;
                }
                return j2;
            }
        }
        return invokeL.longValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? context.getPackageName() : (String) invokeL.objValue;
    }

    public static String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("Y2wyaQ==", 2);
            StringBuilder sb2 = new StringBuilder();
            for (byte b2 : decode) {
                sb2.append((char) b2);
            }
            sb.append(sb2.toString());
            sb.append("4c6k");
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            byte[] decode2 = Base64.decode("YjJsbw==", 0);
            StringBuilder sb5 = new StringBuilder();
            for (byte b3 : decode2) {
                sb5.append((char) b3);
            }
            sb4.append(sb5.toString());
            sb4.append("o7my");
            l0 l0Var = new l0(sb3, sb4.toString());
            Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
            cipher.init(2, l0Var.f30368b, l0Var.a);
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
            }
            return new String(cipher.doFinal(bArr), "utf-8");
        }
        return (String) invokeL.objValue;
    }

    public static String y(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int intValue = ((Integer) jSONObject.get("view_width")).intValue();
                int intValue2 = ((Integer) jSONObject.get("view_height")).intValue();
                int intValue3 = ((Integer) jSONObject.get("view_dx")).intValue();
                int intValue4 = ((Integer) jSONObject.get("view_dy")).intValue();
                return h(h(h(h(h(h(str, "__WIDTH__", intValue), "__HEIGHT__", intValue2), "__DOWN_X__", intValue3), "__DOWN_Y__", intValue4), "__UP_X__", ((Integer) jSONObject.get("view_ux")).intValue()), "__UP_Y__", ((Integer) jSONObject.get("view_uy")).intValue());
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void z(Info info, Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65573, null, info, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent d2 = d(info, context, str);
            if (d2.getFlags() > 0) {
                y2 a = c3.a(context);
                try {
                    a.f30529b = c3.d("wist", new g3(info));
                    a.l("msg", c3.b(str));
                } catch (JSONException unused) {
                }
                a.m();
                context.startActivity(d2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
