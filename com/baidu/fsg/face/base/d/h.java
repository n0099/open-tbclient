package com.baidu.fsg.face.base.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Random;
import java.util.UUID;
import org.apache.http.conn.util.InetAddressUtils;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39744a = "armeabi";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39745b = "armeabi-v7a";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39746c = "x86";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39747d = "arm64-v8a";

    /* renamed from: e  reason: collision with root package name */
    public static final int f39748e = 480;

    /* renamed from: f  reason: collision with root package name */
    public static final int f39749f = 480;

    /* renamed from: g  reason: collision with root package name */
    public static final int f39750g = 192;

    /* renamed from: h  reason: collision with root package name */
    public static final int f39751h = 480;

    /* renamed from: i  reason: collision with root package name */
    public static final int f39752i = 620;

    /* renamed from: j  reason: collision with root package name */
    public static final int f39753j = 728;
    public static final int k = 750;
    public static final int l = 1335;
    public static final String m = "SapiBiometricUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(int[] iArr, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, iArr, bitmap) == null) {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Paint paint = new Paint();
            paint.setStrokeWidth(4.0f);
            paint.setColor(-16711936);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3.0f);
            paint.setColor(-16711936);
            for (int i2 = 0; i2 < iArr.length / 2; i2++) {
                int i3 = i2 << 1;
                canvas.drawCircle(iArr[i3], iArr[i3 + 1], 2.0f, paint);
            }
            Rect b2 = b(iArr);
            canvas.drawRect(b2, paint);
            Point point = new Point();
            point.set(b2.centerX(), b2.centerY());
            paint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawCircle(point.x, point.y, 5.0f, paint);
            canvas.drawRect(a(new int[]{bitmap.getWidth(), bitmap.getHeight()}), paint);
            Point point2 = new Point();
            point2.set(bitmap.getWidth() / 2, (bitmap.getHeight() * 728) / 1335);
            paint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawCircle(point2.x, point2.y, 5.0f, paint);
            int width = ((bitmap.getWidth() * 480) / 750) / 2;
            int i4 = point2.x;
            int i5 = point2.y;
            canvas.drawRect(i4 - width, i5 - width, i4 + width, i5 + width, paint);
            int width2 = ((bitmap.getWidth() * 192) / 750) / 2;
            int i6 = point2.x;
            int i7 = point2.y;
            canvas.drawRect(i6 - width2, i7 - width2, i6 + width2, i7 + width2, paint);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, str, str2)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(int[] iArr, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, iArr, bitmap)) == null) {
            if (bitmap != null) {
                Rect b2 = b(iArr);
                return a(bitmap).contains(b2.centerX(), b2.centerY());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, iArr, iArr2)) == null) {
            if (iArr2 != null && iArr2.length == 2) {
                Rect b2 = b(iArr);
                if (b2.right - b2.left < (iArr2[0] * 192) / 750) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                return DeviceId.getDeviceID(context);
            } catch (Throwable unused) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                return "123456789" + MD5Util.toMd5(String.valueOf(random.nextInt(100)).getBytes(), false);
            }
        }
        return (String) invokeL.objValue;
    }

    public static NetworkInfo f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e2) {
                String str = " getActiveNetworkInfo NullPointerException--- \n" + e2.getMessage();
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean g(Context context) {
        NetworkInfo networkInfo;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                networkInfo = f(context);
            } catch (NullPointerException e2) {
                String str = " getActiveNetworkInfo NullPointerException--- \n" + e2.getMessage();
                networkInfo = null;
            }
            return networkInfo != null && networkInfo.getType() == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, iArr, iArr2)) == null) {
            if (iArr2 != null && iArr2.length == 2) {
                Rect b2 = b(iArr);
                if (b2.right - b2.left > (iArr2[0] * 480) / 750) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int d(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65561, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            String uuid = UUID.randomUUID().toString();
            return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
        }
        return (String) invokeV.objValue;
    }

    public static Rect b(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, iArr)) == null) {
            Point point = new Point();
            Point point2 = new Point();
            if (iArr.length > 2) {
                point.x = iArr[0];
                point.y = iArr[1];
                point2.x = iArr[0];
                point2.y = iArr[1];
            }
            for (int i2 = 0; i2 < iArr.length / 2; i2++) {
                int i3 = i2 << 1;
                float f2 = iArr[i3];
                float f3 = iArr[i3 + 1];
                if (f2 < point.x) {
                    point.x = (int) f2;
                }
                if (f3 < point.y) {
                    point.y = (int) f3;
                }
                if (f2 > point2.x) {
                    point2.x = (int) f2;
                }
                if (f3 > point2.y) {
                    point2.y = (int) f3;
                }
            }
            return new Rect(point.x, point.y, point2.x, point2.y);
        }
        return (Rect) invokeL.objValue;
    }

    public static int c(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65556, null, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    public static String c() {
        String hostAddress;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0 && InetAddressUtils.isIPv4Address(hostAddress)) {
                            return hostAddress;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                d.a(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable th) {
                d.a(th);
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static Rect a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap)) == null) {
            int width = ((bitmap.getWidth() * 480) / 750) / 2;
            Point point = new Point();
            point.set(bitmap.getWidth() / 2, (bitmap.getHeight() * 728) / 1335);
            int i2 = point.x;
            int i3 = point.y;
            return new Rect(i2 - width, i3 - width, i2 + width, i3 + width);
        }
        return (Rect) invokeL.objValue;
    }

    public static int b(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65549, null, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "-1" : (String) invokeV.objValue;
    }

    public static void b(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, bitmap) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    File file = new File(externalStorageDirectory.getAbsolutePath() + "/awe");
                    file.mkdirs();
                    File file2 = new File(file, String.format("%d.jpg", Long.valueOf(System.currentTimeMillis())));
                    if (file2.exists()) {
                        file2.delete();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static Rect a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iArr)) == null) {
            if (iArr != null && iArr.length == 2) {
                int i2 = ((iArr[0] * 480) / 750) / 2;
                int i3 = ((iArr[1] * 620) / 1335) / 2;
                Point point = new Point();
                point.set(iArr[0] / 2, (iArr[1] * 728) / 1335);
                int i4 = point.x;
                int i5 = point.y;
                return new Rect(i4 - i2, i5 - i3, i4 + i2, i5 + i3);
            }
            return new Rect(0, 0, 0, 0);
        }
        return (Rect) invokeL.objValue;
    }

    public static boolean a(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, iArr, iArr2)) == null) {
            if (iArr2 == null || iArr2.length != 2) {
                return false;
            }
            Rect b2 = b(iArr);
            Rect a2 = a(iArr2);
            return a2.bottom > b2.bottom && a2.top < b2.top;
        }
        return invokeLL.booleanValue;
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 > i3 || i5 > i2) {
                int round = Math.round(i4 / i3);
                int round2 = Math.round(i5 / i2);
                return round < round2 ? round : round2;
            }
            return 1;
        }
        return invokeLII.intValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
            } catch (Throwable th) {
                d.a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, context)) == null) {
            return str + "-" + d(context) + "-Android-sapi_bio-" + com.baidu.fsg.face.base.c.f39715a;
        }
        return (String) invokeLL.objValue;
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "-1" : (String) invokeV.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                return packageInfo.signatures.length > 0 ? MD5Util.toMd5(packageInfo.signatures[0].toByteArray(), false) : "";
            } catch (Throwable th) {
                d.a(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static double a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) ? new BigDecimal(Double.toString(i2)).divide(new BigDecimal(Double.toString(i3)), 10, 4).doubleValue() : invokeII.doubleValue;
    }
}
