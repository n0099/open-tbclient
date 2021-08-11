package c.p.a.e.b.l;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.l;
import c.p.a.e.b.f.z;
import c.p.a.e.b.o.i;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.commons.lang3.text.FormattableUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35061a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static String f35062b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SparseArray<Boolean> f35063c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile SparseArray<List<l>> f35064d;

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f35065e;

    /* renamed from: f  reason: collision with root package name */
    public static Pattern f35066f;

    /* renamed from: g  reason: collision with root package name */
    public static Pattern f35067g;

    /* renamed from: h  reason: collision with root package name */
    public static ConnectivityManager f35068h;

    /* renamed from: i  reason: collision with root package name */
    public static Boolean f35069i;

    /* renamed from: j  reason: collision with root package name */
    public static Boolean f35070j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473329676, "Lc/p/a/e/b/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473329676, "Lc/p/a/e/b/l/f;");
                return;
            }
        }
        Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
        f35062b = null;
        f35063c = new SparseArray<>();
        f35064d = new SparseArray<>();
        f35065e = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f35066f = null;
        f35067g = null;
    }

    public static void A(IOException iOException, String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, iOException, str) == null) {
            if (str == null) {
                str = "";
            }
            String a0 = a0(iOException, str);
            if (!(iOException instanceof ConnectException)) {
                if (!(iOException instanceof UnknownHostException)) {
                    if (!(iOException instanceof NoRouteToHostException)) {
                        if (!(iOException instanceof UnknownServiceException)) {
                            if (!(iOException instanceof PortUnreachableException)) {
                                if (!(iOException instanceof SocketTimeoutException)) {
                                    if (!(iOException instanceof SocketException)) {
                                        if (!(iOException instanceof HttpRetryException)) {
                                            if (!(iOException instanceof ProtocolException)) {
                                                if (!(iOException instanceof MalformedURLException)) {
                                                    if (!(iOException instanceof FileNotFoundException)) {
                                                        if (!(iOException instanceof InterruptedIOException)) {
                                                            if (!(iOException instanceof UnsupportedEncodingException)) {
                                                                if (!(iOException instanceof EOFException)) {
                                                                    if (!(iOException instanceof StreamResetException)) {
                                                                        if (!(iOException instanceof SSLException)) {
                                                                            if (V0(iOException)) {
                                                                                throw new BaseException(1006, a0);
                                                                            }
                                                                            throw new BaseException(1023, a0);
                                                                        }
                                                                        throw new BaseException(1011, a0);
                                                                    }
                                                                    throw new BaseException(1067, a0);
                                                                }
                                                                throw new BaseException(1066, a0);
                                                            }
                                                            throw new BaseException(1065, a0);
                                                        }
                                                        throw new BaseException(1064, a0);
                                                    }
                                                    throw new BaseException(1063, a0);
                                                }
                                                throw new BaseException(1062, a0);
                                            }
                                            throw new BaseException((int) RevenueServerConst.GetChargeOrderStatusRequest, a0);
                                        }
                                        throw new BaseException((int) RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest, a0);
                                    }
                                    throw new BaseException(1059, a0);
                                }
                                throw new BaseException((int) SDKLogTypeConstants.STATE_MACHINE, a0);
                            }
                            throw new BaseException(1058, a0);
                        }
                        throw new BaseException(1057, a0);
                    }
                    throw new BaseException(1056, a0);
                }
                throw new BaseException(1055, a0);
            }
            throw new BaseException((int) SDKLogTypeConstants.LOCAL_THIRD_CLICK_MONITOR, a0);
        }
    }

    public static String A0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = f35062b;
            if (TextUtils.isEmpty(str)) {
                try {
                    int myPid = Process.myPid();
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager != null) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                            if (runningAppProcessInfo.pid == myPid) {
                                if (c.p.a.e.b.c.a.e()) {
                                    c.p.a.e.b.c.a.g("Process", "processName = " + runningAppProcessInfo.processName);
                                }
                                String str2 = runningAppProcessInfo.processName;
                                f35062b = str2;
                                return str2;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String X0 = X0();
                f35062b = X0;
                return X0;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void B(Throwable th, String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, th, str) == null) {
            String str2 = !TextUtils.isEmpty(str) ? str : "";
            if (!(th instanceof BaseException)) {
                if (!(th instanceof SSLHandshakeException)) {
                    if (!R(th)) {
                        if (!L0(th)) {
                            if (!P0(th)) {
                                if (!k0(th)) {
                                    if (!w0(th)) {
                                        if (!F0(th)) {
                                            if (th instanceof IOException) {
                                                o0(th, str);
                                                A((IOException) th, str);
                                                throw null;
                                            }
                                            throw new BaseException(1000, a0(th, str2));
                                        }
                                        throw new BaseException((int) SDKLogTypeConstants.LOCAL_THIRD_CLICK_MONITOR, a0(th, str2));
                                    }
                                    throw new BaseException((int) SDKLogTypeConstants.TYPE_LP_LOAD_URL, a0(th, str2));
                                }
                                throw new BaseException(1047, a0(th, str2));
                            }
                            throw new com.ss.android.socialbase.downloader.exception.b(1004, 416, a0(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, 412, a0(th, str2));
                    }
                    throw new BaseException((int) SDKLogTypeConstants.STATE_MACHINE, a0(th, str2));
                }
                throw new BaseException(1011, a0(th, str2));
            }
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        }
    }

    public static boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public static void C(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, downloadInfo) == null) {
            long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
            if (throttleNetSpeed > 0) {
                list.add(new com.ss.android.socialbase.downloader.model.c("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
            }
        }
    }

    public static boolean C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? i2 == 206 || i2 == 200 : invokeI.booleanValue;
    }

    public static void D(Cursor... cursorArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, cursorArr) == null) || cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static boolean D0(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, downloadInfo)) == null) {
            boolean z = false;
            if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
                c.p.a.e.b.c.a.g(f35061a, "dcache::last modify is emtpy, so just return cache");
            } else {
                String str = f35061a;
                c.p.a.e.b.c.a.g(str, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
                if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                    z = true;
                }
            }
            String str2 = f35061a;
            c.p.a.e.b.c.a.g(str2, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void E(Closeable... closeableArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, closeableArr) == null) || closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static boolean E0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return new File(str, str2).exists();
        }
        return invokeLL.booleanValue;
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            Boolean bool = f35069i;
            if (bool != null) {
                return bool.booleanValue();
            }
            String A0 = A0(c.p.a.e.b.g.e.n());
            if (A0 == null || !A0.contains(":")) {
                f35069i = Boolean.valueOf(A0 != null && A0.equals(c.p.a.e.b.g.e.n().getPackageName()));
            } else {
                f35069i = Boolean.FALSE;
            }
            return f35069i.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean F0(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String a1 = a1(th);
            return !TextUtils.isEmpty(a1) && a1.contains("Exception in connect");
        }
        return invokeL.booleanValue;
    }

    public static boolean G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) ? i2 == 0 || i2 == 2 : invokeI.booleanValue;
    }

    public static long G0(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return -1L;
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = c.p.a.e.b.g.e.M0().c(downloadInfo.getId());
            if (downloadInfo.getChunkCount() == 1) {
                return downloadInfo.getCurBytes();
            }
            if (c2 == null || c2.size() <= 1) {
                return 0L;
            }
            long z0 = z0(c2);
            if (z0 >= 0) {
                return z0;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static boolean H(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i2, str)) == null) {
            if (a.a(16777216)) {
                return i2 == 206 || i2 == 1;
            } else if (i2 >= 400) {
                return false;
            } else {
                return i2 == 206 || i2 == 1 || "bytes".equals(str);
            }
        }
        return invokeIL.booleanValue;
    }

    public static com.ss.android.socialbase.downloader.constants.f H0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) {
            com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.f75459a;
            if (i2 == com.ss.android.socialbase.downloader.constants.f.f75460b.ordinal()) {
                return com.ss.android.socialbase.downloader.constants.f.f75460b;
            }
            return i2 == com.ss.android.socialbase.downloader.constants.f.f75461c.ordinal() ? com.ss.android.socialbase.downloader.constants.f.f75461c : fVar;
        }
        return (com.ss.android.socialbase.downloader.constants.f) invokeI.objValue;
    }

    public static boolean I(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65553, null, i2, str, str2)) == null) ? i2 == -3 && !E0(str, str2) : invokeILL.booleanValue;
    }

    public static String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? h(c.p.a.e.b.g.a.H(c.p.a.e.b.g.e.n()).k(), true) : (String) invokeV.objValue;
    }

    public static boolean J(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) ? (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true : invokeLL.booleanValue;
    }

    public static String J0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(str.getBytes("UTF-8"));
                        return o(messageDigest.digest());
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean K(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, baseException)) == null) ? baseException != null && baseException.getErrorCode() == 1051 : invokeL.booleanValue;
    }

    public static String K0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String J0 = J0(str2);
            return (TextUtils.isEmpty(J0) || str.contains(J0)) ? str : new File(str, J0).getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean L(BaseException baseException, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, baseException, downloadInfo)) == null) {
            if (baseException == null) {
                return false;
            }
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
                return true;
            }
            return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean L0(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String a1 = a1(th);
            return !TextUtils.isEmpty(a1) && a1.contains("Precondition Failed");
        }
        return invokeL.booleanValue;
    }

    public static boolean M(DownloadInfo downloadInfo, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{downloadInfo, Boolean.valueOf(z), str})) == null) {
            if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                try {
                    if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                        if (v0(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                            return true;
                        }
                    }
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static long M0(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return 0L;
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = c.p.a.e.b.g.e.M0().c(downloadInfo.getId());
            int chunkCount = downloadInfo.getChunkCount();
            boolean z = chunkCount > 1;
            if (downloadInfo.isBreakpointAvailable()) {
                if (z) {
                    if (c2 == null || chunkCount != c2.size()) {
                        return 0L;
                    }
                    return W(c2);
                }
                return downloadInfo.getCurBytes();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static boolean N(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, file)) == null) {
            if (file == null) {
                return false;
            }
            try {
                if (file.exists() || file.mkdirs()) {
                    return file.isDirectory();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? h(c.p.a.e.b.g.a.H(c.p.a.e.b.g.e.n()).m(), false) : (String) invokeV.objValue;
    }

    public static boolean O(File file, File file2) throws BaseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, file, file2)) == null) ? P(file, file2, true) : invokeLL.booleanValue;
    }

    public static boolean O0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String A0 = A0(c.p.a.e.b.g.e.n());
            return A0 != null && A0.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean P(File file, File file2, boolean z) throws BaseException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65567, null, file, file2, z)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    String str = "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath();
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    c0(file, file2, z);
                    return true;
                }
                return false;
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                B(th, "CopyFile");
                throw null;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean P0(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String a1 = a1(th);
            return !TextUtils.isEmpty(a1) && a1.contains("Requested Range Not Satisfiable");
        }
        return invokeL.booleanValue;
    }

    public static boolean Q(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65569, null, obj, z)) == null) {
            try {
                return ((Boolean) obj).booleanValue();
            } catch (ClassCastException unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static File Q0() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                str = Environment.getExternalStorageState();
            } catch (Exception unused) {
                str = "";
            }
            if ("mounted".equals(str)) {
                return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static boolean R(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String a1 = a1(th);
            if (!(th instanceof SocketTimeoutException)) {
                if (TextUtils.isEmpty(a1)) {
                    return false;
                }
                if (!a1.contains("time out") && !a1.contains("Time-out")) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String R0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean S(List<com.ss.android.socialbase.downloader.model.c> list, List<com.ss.android.socialbase.downloader.model.c> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, list, list2)) == null) {
            if (list == list2) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            return new HashSet(list).equals(new HashSet(list2));
        }
        return invokeLL.booleanValue;
    }

    public static boolean S0(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, th)) == null) ? c.p.a.e.b.g.e.m().a(th) : invokeL.booleanValue;
    }

    public static int T(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65575, null, str, str2, str3)) == null) ? c.p.a.c.c.a(str3, new File(str, str2)) : invokeLLL.intValue;
    }

    public static boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            Context n = c.p.a.e.b.g.e.n();
            return (n == null || g0(n) || !r0(n)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static long U(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, iVar)) == null) {
            if (iVar == null) {
                return -1L;
            }
            String Y = Y(iVar, "Content-Range");
            if (TextUtils.isEmpty(Y)) {
                return -1L;
            }
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(Y);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                String str = f35061a;
                c.p.a.e.b.c.a.j(str, "parse content-length from content-range failed " + e2);
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static boolean U0(String str) {
        InterceptResult invokeL;
        Context n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (c.p.a.e.b.j.a.r().m("save_path_security") > 0 && (n = c.p.a.e.b.g.e.n()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
                if (!str.contains("Android/data/" + n.getPackageName())) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static long V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            String[] split = str.split("/");
            if (split.length >= 2) {
                try {
                    return Long.parseLong(split[1]);
                } catch (NumberFormatException unused) {
                    String str2 = f35061a;
                    c.p.a.e.b.c.a.j(str2, "parse instance length failed with " + str);
                }
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static boolean V0(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, th)) == null) {
            if (th == null) {
                return false;
            }
            if (th instanceof BaseException) {
                BaseException baseException = (BaseException) th;
                int errorCode = baseException.getErrorCode();
                if (errorCode == 1006) {
                    return true;
                }
                if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                    String message = baseException.getMessage();
                    return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
                }
                return false;
            } else if (th instanceof IOException) {
                String a1 = a1(th);
                return !TextUtils.isEmpty(a1) && a1.contains("ENOSPC");
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static long W(List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, list)) == null) {
            long j2 = 0;
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                j2 += bVar.o();
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static long W0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (matcher.find()) {
                try {
                    return Long.parseLong(matcher.group(1));
                } catch (Throwable th) {
                    th.printStackTrace();
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static String X(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65583, null, i2)) == null) {
            String str = "ttmd5 check code = " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR;
            if (i2 != 99) {
                switch (i2) {
                    case 0:
                        return str + "md5 match";
                    case 1:
                        return str + "md5 not match";
                    case 2:
                        return str + "md5 empty";
                    case 3:
                        return str + "ttmd5 version not support";
                    case 4:
                        return str + "ttmd5 tag parser error";
                    case 5:
                        return str + "file not exist";
                    case 6:
                        return str + "get file md5 error";
                    default:
                        return str;
                }
            }
            return str + "unknown error";
        }
        return (String) invokeI.objValue;
    }

    public static String X0() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (c.p.a.e.b.c.a.e()) {
                    c.p.a.e.b.c.a.g("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                E(bufferedReader);
                return sb2;
            } catch (Throwable unused2) {
                E(bufferedReader);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String Y(i iVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65585, null, iVar, str)) == null) {
            if (iVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            String a2 = iVar.a(str);
            if (c.p.a.e.b.j.a.r().q("fix_get_http_resp_head_ignore_case", true)) {
                if (TextUtils.isEmpty(a2)) {
                    a2 = iVar.a(str.toLowerCase());
                }
                return TextUtils.isEmpty(a2) ? iVar.a(str.toUpperCase()) : a2;
            }
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean Y0(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, th)) == null) {
            if (th instanceof BaseException) {
                int errorCode = ((BaseException) th).getErrorCode();
                return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String Z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65587, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return (String) invokeLL.objValue;
    }

    public static String Z0(String str) {
        InterceptResult invokeL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                if (f35066f == null) {
                    f35066f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
                }
                matcher = f35066f.matcher(str);
            } catch (Exception unused) {
            }
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (f35067g == null) {
                f35067g = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = f35067g.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static double a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65589, null, j2)) == null) ? j2 / 1048576.0d : invokeJ.doubleValue;
    }

    public static String a0(Throwable th, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65590, null, th, str)) == null) {
            if (str == null) {
                return a1(th);
            }
            return str + "-" + a1(th);
        }
        return (String) invokeLL.objValue;
    }

    public static String a1(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, th)) == null) {
            if (th == null) {
                return "";
            }
            try {
                return th.toString();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return "throwable getMsg error";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int b(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, file, str)) == null) ? c.p.a.c.c.a(str, file) : invokeLL.intValue;
    }

    public static void b0(DownloadInfo downloadInfo) {
        c.p.a.e.b.j.a d2;
        JSONObject u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65593, null, downloadInfo) == null) || downloadInfo == null || (u = (d2 = c.p.a.e.b.j.a.d(downloadInfo.getId())).u("download_dir")) == null) {
            return;
        }
        String optString = u.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            n0(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String l = l(title, d2);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(l);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            b1(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static boolean b1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, str)) == null) {
            String str2 = "deleteDirIfEmpty on thread: " + Thread.currentThread();
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                return file.isDirectory() && file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int c(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65595, null, obj, i2)) == null) {
            try {
                return ((Integer) obj).intValue();
            } catch (ClassCastException unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @TargetApi(19)
    public static void c0(File file, File file2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65596, null, file, file2, z) == null) {
            if (file2.exists() && file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is a directory");
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                FileChannel channel2 = fileOutputStream.getChannel();
                try {
                    long size = channel.size();
                    long j2 = 0;
                    while (j2 < size) {
                        long j3 = size - j2;
                        long transferFrom = channel2.transferFrom(channel, j2, j3 > 31457280 ? 31457280L : j3);
                        if (transferFrom == 0) {
                            break;
                        }
                        j2 += transferFrom;
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                    fileOutputStream.close();
                    if (channel != null) {
                        channel.close();
                    }
                    fileInputStream.close();
                    long length = file.length();
                    long length2 = file2.length();
                    if (length == length2) {
                        if (z) {
                            file2.setLastModified(file.lastModified());
                            return;
                        }
                        return;
                    }
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        }
    }

    public static long d(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, iVar)) == null) {
            if (iVar == null) {
                return -1L;
            }
            String Y = Y(iVar, "Content-Length");
            if (TextUtils.isEmpty(Y) && a.a(1)) {
                return U(iVar);
            }
            try {
                return Long.parseLong(Y);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static void d0(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65598, null, list, downloadInfo) == null) {
            long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
            if (ttnetProtectTimeout > 300) {
                list.add(new com.ss.android.socialbase.downloader.model.c("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
            }
        }
    }

    public static ConnectivityManager e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, context)) == null) {
            ConnectivityManager connectivityManager = f35068h;
            if (connectivityManager == null) {
                ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                f35068h = connectivityManager2;
                return connectivityManager2;
            }
            return connectivityManager;
        }
        return (ConnectivityManager) invokeL.objValue;
    }

    public static boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? !p0() && c.p.a.e.b.g.e.m0() && c.p.a.e.b.m.l.a(true).h() : invokeV.booleanValue;
    }

    public static c.p.a.e.b.n.c f(DownloadInfo downloadInfo, String str, String str2, int i2) throws BaseException {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65601, null, downloadInfo, str, str2, i2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str, str2);
                boolean z = false;
                if (file.exists() && file.isDirectory()) {
                    throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
                }
                if (!file.exists()) {
                    try {
                        File file2 = new File(str);
                        if (!file2.exists() || !file2.isDirectory()) {
                            if (!file2.exists()) {
                                if (!file2.mkdirs() && !file2.exists()) {
                                    if (c.p.a.e.b.j.a.f(downloadInfo).b("opt_mkdir_failed", 0) != 1) {
                                        throw new BaseException(1030, "download savePath directory can not created:" + str);
                                    }
                                    int i3 = 0;
                                    while (!z) {
                                        int i4 = i3 + 1;
                                        if (i3 >= 3) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(10L);
                                            z = file2.mkdirs();
                                            i3 = i4;
                                        } catch (InterruptedException unused) {
                                        }
                                    }
                                    if (!z) {
                                        if (y0(downloadInfo.getSavePath()) < 16384) {
                                            throw new BaseException(1006, "download savePath directory can not created:" + str);
                                        }
                                        throw new BaseException(1030, "download savePath directory can not created:" + str);
                                    }
                                }
                            } else {
                                file2.delete();
                                if (!file2.mkdirs() && !file2.exists()) {
                                    throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:path=" + str);
                                }
                                throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:" + str);
                            }
                        }
                        file.createNewFile();
                    } catch (IOException e2) {
                        throw new BaseException(1036, e2);
                    }
                }
                return new c.p.a.e.b.n.c(file, i2);
            }
            throw new BaseException(1021, new IOException("path must be not empty"));
        }
        return (c.p.a.e.b.n.c) invokeLLLI.objValue;
    }

    public static boolean f0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65602, null, j2)) == null) ? j2 == -1 : invokeJ.booleanValue;
    }

    public static String g(i iVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, iVar, str)) == null) {
            String Z0 = Z0(iVar.a("Content-Disposition"));
            return TextUtils.isEmpty(Z0) ? J0(str) : Z0;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean g0(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, context)) == null) {
            try {
                ConnectivityManager e2 = e(context);
                if (e2 != null && (activeNetworkInfo = e2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                    return 1 == activeNetworkInfo.getType();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String h(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65605, null, file, z)) == null) {
            Context n = c.p.a.e.b.g.e.n();
            if (N(file)) {
                return file.getAbsolutePath();
            }
            int i2 = n.getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                File externalFilesDir = n.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (N(externalFilesDir)) {
                    return externalFilesDir.getAbsolutePath();
                }
            } else {
                if (z) {
                    File Q0 = Q0();
                    if (N(Q0)) {
                        return Q0.getAbsolutePath();
                    }
                }
                File externalFilesDir2 = n.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (N(externalFilesDir2)) {
                    return externalFilesDir2.getAbsolutePath();
                }
            }
            return n.getFilesDir().getAbsolutePath();
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean h0(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, baseException)) == null) {
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.b) {
                com.ss.android.socialbase.downloader.exception.b bVar = (com.ss.android.socialbase.downloader.exception.b) baseException;
                if (bVar.a() == 412 || bVar.a() == 416) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String i(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65607, null, obj, str)) == null) {
            try {
                return (String) obj;
            } catch (ClassCastException unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean i0(BaseException baseException, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65608, null, baseException, downloadInfo)) == null) ? downloadInfo != null && downloadInfo.isOnlyWifi() && r0(c.p.a.e.b.g.e.n()) : invokeLL.booleanValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                try {
                    bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            try {
                return new String(bArr, "utf-8");
            } catch (Exception e3) {
                e3.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean j0(File file, File file2) throws BaseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65610, null, file, file2)) == null) {
            String str = "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath();
            boolean renameTo = file.renameTo(file2);
            if (!renameTo) {
                renameTo = O(file, file2);
                try {
                    String str2 = "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath();
                    file.delete();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return renameTo;
        }
        return invokeLL.booleanValue;
    }

    public static String k(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65611, null, str, i2)) == null) ? i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2) : (String) invokeLI.objValue;
    }

    public static boolean k0(Throwable th) {
        InterceptResult invokeL;
        com.ss.android.socialbase.downloader.exception.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String a1 = a1(th);
            if (!(th instanceof com.ss.android.socialbase.downloader.exception.b) || (((bVar = (com.ss.android.socialbase.downloader.exception.b) th) == null || bVar.a() != 403) && (TextUtils.isEmpty(a1) || !a1.contains("403")))) {
                return !TextUtils.isEmpty(a1) && a1.contains("Forbidden");
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String l(String str, c.p.a.e.b.j.a aVar) {
        InterceptResult invokeLL;
        JSONObject u;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65613, null, str, aVar)) == null) {
            if (aVar == null || (u = aVar.u("download_dir")) == null) {
                return "";
            }
            String optString = u.optString("dir_name");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains(FormattableUtils.SIMPLEST_FORMAT)) {
                format = optString + str;
            } else {
                try {
                    format = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            optString = format;
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return (String) invokeLL.objValue;
    }

    public static long l0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65614, null, j2)) == null) ? System.currentTimeMillis() - j2 : invokeJ.longValue;
    }

    public static String m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65615, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            return String.format("%s%s%s", str, File.separator, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String m0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return String.format("%s.tp", str);
        }
        return (String) invokeL.objValue;
    }

    public static String n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65617, null, str, str2, str3)) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                m = m(str2, str3);
            } else {
                m = m(str, str3);
            }
            if (TextUtils.isEmpty(m)) {
                return null;
            }
            return String.format("%s.tp", m);
        }
        return (String) invokeLLL.objValue;
    }

    public static void n0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65618, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = "deleteFile: " + str + "/" + str2;
            file.delete();
        }
    }

    public static String o(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, bArr)) == null) {
            if (bArr != null) {
                return p(bArr, 0, bArr.length);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static void o0(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.g {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65620, null, th, str) == null) {
            com.ss.android.socialbase.downloader.exception.g a2 = c.p.a.e.b.g.e.m().a(th, null);
            if (a2 == null) {
                a2 = c.p.a.e.b.g.e.m().a(th.getCause(), null);
            }
            if (a2 == null) {
                return;
            }
            throw new com.ss.android.socialbase.downloader.exception.g(a2.getErrorCode(), a0(a2, str)).a(a2.a());
        }
    }

    public static String p(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65621, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 >= 0 && i2 + i3 <= bArr.length) {
                    int i4 = i3 * 2;
                    char[] cArr = new char[i4];
                    int i5 = 0;
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = bArr[i6 + i2] & 255;
                        int i8 = i5 + 1;
                        char[] cArr2 = f35065e;
                        cArr[i5] = cArr2[i7 >> 4];
                        i5 = i8 + 1;
                        cArr[i8] = cArr2[i7 & 15];
                    }
                    return new String(cArr, 0, i4);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }

    public static boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) {
            Boolean bool = f35070j;
            if (bool != null) {
                return bool.booleanValue();
            }
            String A0 = A0(c.p.a.e.b.g.e.n());
            if (A0 != null) {
                if (A0.equals(c.p.a.e.b.g.e.n().getPackageName() + ":downloader")) {
                    f35070j = Boolean.TRUE;
                    return f35070j.booleanValue();
                }
            }
            f35070j = Boolean.FALSE;
            return f35070j.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static <K> HashMap<Integer, K> q(SparseArray<K> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65623, null, sparseArray)) == null) {
            if (sparseArray == null) {
                return null;
            }
            HashMap<Integer, K> hashMap = new HashMap<>();
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                hashMap.put(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static boolean q0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65624, null, i2)) == null) ? i2 == 200 || i2 == 201 || i2 == 0 : invokeI.booleanValue;
    }

    public static List<com.ss.android.socialbase.downloader.model.b> r(List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65625, null, list)) == null) {
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                if (bVar != null) {
                    if (bVar.d()) {
                        sparseArray.put(bVar.s(), bVar);
                        List<com.ss.android.socialbase.downloader.model.b> list2 = (List) sparseArray2.get(bVar.s());
                        if (list2 != null) {
                            for (com.ss.android.socialbase.downloader.model.b bVar2 : list2) {
                                bVar2.a(bVar);
                            }
                            bVar.a(list2);
                        }
                    } else {
                        com.ss.android.socialbase.downloader.model.b bVar3 = (com.ss.android.socialbase.downloader.model.b) sparseArray.get(bVar.b());
                        if (bVar3 != null) {
                            List<com.ss.android.socialbase.downloader.model.b> g2 = bVar3.g();
                            if (g2 == null) {
                                g2 = new ArrayList<>();
                                bVar3.a(g2);
                            }
                            bVar.a(bVar3);
                            g2.add(bVar);
                        } else {
                            List list3 = (List) sparseArray2.get(bVar.b());
                            if (list3 == null) {
                                list3 = new ArrayList();
                                sparseArray2.put(bVar.b(), list3);
                            }
                            list3.add(bVar);
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
            }
            return arrayList.isEmpty() ? list : arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean r0(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65626, null, context)) == null) {
            try {
                ConnectivityManager e2 = e(context);
                if (e2 == null || (activeNetworkInfo = e2.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static List<com.ss.android.socialbase.downloader.model.c> s(List<com.ss.android.socialbase.downloader.model.c> list, String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65627, null, new Object[]{list, str, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    if (cVar != null) {
                        arrayList.add(cVar);
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new com.ss.android.socialbase.downloader.model.c(Util.IF_MATCH, str));
            }
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("Accept-Encoding", "identity"));
            String format = j3 <= 0 ? String.format("bytes=%s-", String.valueOf(j2)) : String.format("bytes=%s-%s", String.valueOf(j2), String.valueOf(j3));
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("Range", format));
            String str2 = f35061a;
            c.p.a.e.b.c.a.g(str2, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + format);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static boolean s0(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65628, null, baseException)) == null) {
            if (baseException == null) {
                return false;
            }
            return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
        }
        return invokeL.booleanValue;
    }

    public static List<com.ss.android.socialbase.downloader.model.c> t(List<com.ss.android.socialbase.downloader.model.c> list, String str, com.ss.android.socialbase.downloader.model.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65629, null, list, str, bVar)) == null) ? s(list, str, bVar.m(), bVar.p()) : (List) invokeLLL.objValue;
    }

    public static boolean t0(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65630, null, downloadInfo)) == null) ? M(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5()) : invokeL.booleanValue;
    }

    public static void u(int i2, boolean z, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65631, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), baseException}) == null) {
            synchronized (f35063c) {
                List<l> list = f35064d.get(i2);
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            if (z) {
                                lVar.a();
                            } else {
                                lVar.a(baseException);
                            }
                        }
                    }
                }
                String str = f35061a;
                c.p.a.e.b.c.a.g(str, "handleTempSaveCallback id:" + i2);
                f35063c.remove(i2);
            }
        }
    }

    public static boolean u0(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65632, null, iVar)) == null) {
            if (iVar == null) {
                return false;
            }
            return a.a(8) ? "chunked".equals(iVar.a("Transfer-Encoding")) || d(iVar) == -1 : d(iVar) == -1;
        }
        return invokeL.booleanValue;
    }

    public static <K> void v(SparseArray<K> sparseArray, Map<Integer, K> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65633, null, sparseArray, map) == null) || map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean v0(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65634, null, str, str2, str3)) == null) ? G(T(str, str2, str3)) : invokeLLL.booleanValue;
    }

    public static void w(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65635, null, downloadInfo) == null) {
            z(downloadInfo, true);
        }
    }

    public static boolean w0(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65636, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String a1 = a1(th);
            return !TextUtils.isEmpty(a1) && a1.contains("network not available");
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void x(DownloadInfo downloadInfo, z zVar, l lVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65637, null, downloadInfo, zVar, lVar) == null) {
            c.p.a.e.b.c.a.g(f35061a, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
            try {
            } catch (Throwable th) {
                c.p.a.e.b.c.a.g(f35061a, "saveFileAsTargetName throwable " + th.getMessage());
                if (lVar == null) {
                }
            }
            synchronized (f35063c) {
                if (f35063c.get(downloadInfo.getId()) == Boolean.TRUE) {
                    c.p.a.e.b.c.a.g(f35061a, "has another same task is saving temp file");
                    if (lVar != null) {
                        List<l> list = f35064d.get(downloadInfo.getId());
                        if (list == null) {
                            list = new ArrayList<>();
                            f35064d.put(downloadInfo.getId(), list);
                        }
                        list.add(lVar);
                    }
                    return;
                }
                c.p.a.e.b.c.a.g(f35061a, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                f35063c.put(downloadInfo.getId(), Boolean.TRUE);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean U0 = U0(downloadInfo.getSavePath());
                if (file2.exists()) {
                    c.p.a.e.b.c.a.g(f35061a, "targetFile exist");
                    int b2 = b(file2, downloadInfo.getMd5());
                    if (G(b2)) {
                        c.p.a.e.b.c.a.g(f35061a, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(b2);
                        if (lVar != null) {
                            lVar.a();
                        }
                        u(downloadInfo.getId(), true, null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), X(b2)));
                            if (lVar != null) {
                                lVar.a(baseException2);
                            }
                            u(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (U0 && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + X(b2));
                                if (lVar != null) {
                                    lVar.a(baseException3);
                                }
                                u(downloadInfo.getId(), false, baseException3);
                            } else if (zVar != null) {
                                c.p.a.e.b.e.a.e(zVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                        if (z) {
                            return;
                        }
                        try {
                            int b3 = c.p.a.e.b.j.a.d(downloadInfo.getId()).b("download_finish_check_ttmd5", 2);
                            if (b3 > 0) {
                                int b4 = b(file, downloadInfo.getMd5());
                                downloadInfo.setTTMd5CheckStatus(b4);
                                if (b3 >= 2 && !G(b4)) {
                                    BaseException baseException4 = new BaseException(1034, X(b4));
                                    if (lVar != null) {
                                        lVar.a(baseException4);
                                    }
                                    u(downloadInfo.getId(), false, baseException4);
                                    z(downloadInfo, U0);
                                    return;
                                }
                            }
                            z2 = !j0(file, file2);
                            baseException = null;
                        } catch (BaseException e2) {
                            if (c.p.a.e.b.j.a.d(downloadInfo.getId()).l("fix_file_rename_failed")) {
                                baseException = e2;
                                z2 = true;
                            } else {
                                baseException = e2;
                                z2 = false;
                            }
                        }
                        if (z2) {
                            if (baseException == null) {
                                baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                            }
                            if (lVar != null) {
                                lVar.a(baseException);
                            }
                            u(downloadInfo.getId(), false, baseException);
                            return;
                        }
                        if (lVar != null) {
                            lVar.a();
                        }
                        u(downloadInfo.getId(), true, null);
                        return;
                    }
                    z = false;
                    if (z) {
                    }
                } else if (file.exists()) {
                    z = true;
                    if (z) {
                    }
                } else {
                    BaseException baseException5 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (lVar != null) {
                        lVar.a(baseException5);
                    }
                    u(downloadInfo.getId(), false, baseException5);
                    z = false;
                    if (z) {
                    }
                }
                c.p.a.e.b.c.a.g(f35061a, "saveFileAsTargetName throwable " + th.getMessage());
                if (lVar == null) {
                    lVar.a(new BaseException(1038, a0(th, "saveFileAsTargetName")));
                }
            }
        }
    }

    public static boolean x0(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65638, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b()) && "download-tc21-1-15".equals(cVar.a()) && "download-tc21-1-15".equals(cVar.b())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void y(DownloadInfo downloadInfo, String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65639, null, downloadInfo, str) == null) || downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        r0 = "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath();
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!O(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static long y0(String str) throws BaseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65640, null, str)) == null) {
            try {
                StatFs statFs = new StatFs(str);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (IllegalArgumentException e2) {
                throw new BaseException(1050, e2);
            } catch (Throwable th) {
                throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, th);
            }
        }
        return invokeL.longValue;
    }

    public static void z(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65641, null, downloadInfo, z) == null) || downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                n0(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        n0(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            b0(downloadInfo);
        }
        if (z) {
            String J0 = J0(downloadInfo.getUrl());
            if (TextUtils.isEmpty(J0) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(J0)) {
                return;
            }
            b1(downloadInfo.getSavePath());
        }
    }

    public static long z0(List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65642, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return -1L;
            }
            long j2 = -1;
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                if (bVar != null && (bVar.n() <= bVar.p() || bVar.p() == 0)) {
                    if (j2 == -1 || j2 > bVar.n()) {
                        j2 = bVar.n();
                    }
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }
}
