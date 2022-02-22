package c.a.d.f.p;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static float f2193b;

    /* renamed from: c  reason: collision with root package name */
    public static int f2194c;

    /* renamed from: d  reason: collision with root package name */
    public static int f2195d;

    /* renamed from: e  reason: collision with root package name */
    public static Toast f2196e;

    /* renamed from: f  reason: collision with root package name */
    public static c f2197f;

    /* renamed from: g  reason: collision with root package name */
    public static String f2198g;

    /* renamed from: h  reason: collision with root package name */
    public static Handler f2199h;

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f2200i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || n.f2196e == null) {
                return;
            }
            n.f2196e.cancel();
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f2201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f2202f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f2203g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f2204h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2205i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ View f2206j;

        public b(View view, int i2, int i3, int i4, int i5, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2201e = view;
            this.f2202f = i2;
            this.f2203g = i3;
            this.f2204h = i4;
            this.f2205i = i5;
            this.f2206j = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f2201e.getHitRect(rect);
                rect.right += this.f2202f;
                rect.left -= this.f2203g;
                rect.bottom += this.f2204h;
                rect.top -= this.f2205i;
                this.f2206j.setTouchDelegate(new TouchDelegate(rect, this.f2201e));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void createToastView();

        View getToastContentView();

        void setToastString(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502488826, "Lc/a/d/f/p/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502488826, "Lc/a/d/f/p/n;");
                return;
            }
        }
        f2199h = new Handler(Looper.getMainLooper());
        f2200i = new a();
    }

    public static boolean A(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 : invokeL.booleanValue;
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() && Looper.getMainLooper().getThread() == Thread.currentThread() : invokeV.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? l.z() : invokeV.booleanValue;
    }

    public static Rect D(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, paint, str)) == null) {
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            return rect;
        }
        return (Rect) invokeLL.objValue;
    }

    public static float E(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, paint, str)) == null) {
            if (paint == null || str == null) {
                return 0.0f;
            }
            return paint.measureText(str);
        }
        return invokeLL.floatValue;
    }

    public static double F(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Double.valueOf(d2)})) == null) ? (d2 * 3.141592653589793d) / 180.0d : invokeCommon.doubleValue;
    }

    public static void G(Context context) {
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            try {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null && (launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName())) != null) {
                        launchIntentForPackage.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 950731, launchIntentForPackage, 268435456));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                System.exit(0);
            }
        }
    }

    public static void H(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, cVar) == null) {
            f2197f = cVar;
        }
    }

    public static void I(Context context, String str, SpannableString spannableString, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65545, null, context, str, spannableString, i2) == null) || TextUtils.isEmpty(spannableString) || TextUtils.isEmpty(spannableString)) {
            return;
        }
        f2199h.removeCallbacks(f2200i);
        if (f2196e != null && Build.VERSION.SDK_INT < 28) {
            c cVar = f2197f;
            if (cVar != null) {
                cVar.createToastView();
            }
            if (!spannableString.equals(f2198g)) {
                c cVar2 = f2197f;
                if (cVar2 != null && cVar2.getToastContentView() != null) {
                    f2197f.setToastString(str);
                    f2196e.setView(f2197f.getToastContentView());
                } else {
                    f2196e.setText(spannableString);
                }
            }
            int d2 = d(BdBaseApplication.getInst().getApp(), 100.0f);
            if (BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation == 2) {
                d2 = 0;
            }
            if (i2 == 3500) {
                f2196e.setDuration(1);
            } else {
                f2196e.setDuration(0);
            }
            f2196e.setGravity(17, 0, d2);
        } else {
            Toast toast = f2196e;
            if (toast != null) {
                toast.cancel();
            }
            c cVar3 = f2197f;
            if (cVar3 != null) {
                cVar3.createToastView();
            }
            c cVar4 = f2197f;
            if (cVar4 != null && cVar4.getToastContentView() != null) {
                Toast toast2 = new Toast(BdBaseApplication.getInst().getApp());
                f2196e = toast2;
                x.a(toast2);
                if (i2 == 3500) {
                    f2196e.setDuration(1);
                } else {
                    f2196e.setDuration(0);
                }
                f2197f.setToastString(str);
                f2196e.setView(f2197f.getToastContentView());
            } else {
                if (i2 == 3500) {
                    Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), spannableString, 1);
                    f2196e = makeText;
                    x.a(makeText);
                } else {
                    Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), spannableString, 0);
                    f2196e = makeText2;
                    x.a(makeText2);
                }
                f2196e.setText(spannableString);
            }
            f2196e.setGravity(17, 0, d(BdBaseApplication.getInst().getApp(), 100.0f));
        }
        c cVar5 = f2197f;
        if (cVar5 != null && (cVar5.getToastContentView() instanceof TextView)) {
            ((TextView) f2197f.getToastContentView()).setText(spannableString);
        }
        f2198g = str;
        f2199h.postDelayed(f2200i, i2);
        f2196e.show();
    }

    public static void J(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, context, i2) == null) {
            K(context, context.getResources().getString(i2));
        }
    }

    public static void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, str) == null) {
            O(context, str, 3500);
        }
    }

    public static void L(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, view) == null) {
            try {
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void M(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, context, i2) == null) {
            N(context, context.getResources().getString(i2));
        }
    }

    public static void N(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            O(context, str, 2000);
        }
    }

    public static void O(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65551, null, context, str, i2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return;
        }
        f2199h.removeCallbacks(f2200i);
        if (f2196e != null && Build.VERSION.SDK_INT < 28) {
            c cVar = f2197f;
            if (cVar != null) {
                cVar.createToastView();
            }
            if (!str.equals(f2198g)) {
                c cVar2 = f2197f;
                if (cVar2 != null && cVar2.getToastContentView() != null) {
                    f2197f.setToastString(str);
                    f2196e.setView(f2197f.getToastContentView());
                } else {
                    f2196e.setText(str);
                }
            }
            int d2 = d(BdBaseApplication.getInst().getApp(), 100.0f);
            if (BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation == 2) {
                d2 = 0;
            }
            if (i2 == 3500) {
                f2196e.setDuration(1);
            } else {
                f2196e.setDuration(0);
            }
            f2196e.setGravity(17, 0, d2);
        } else {
            Toast toast = f2196e;
            if (toast != null) {
                toast.cancel();
            }
            c cVar3 = f2197f;
            if (cVar3 != null) {
                cVar3.createToastView();
            }
            c cVar4 = f2197f;
            if (cVar4 != null && cVar4.getToastContentView() != null) {
                Toast toast2 = new Toast(BdBaseApplication.getInst().getApp());
                f2196e = toast2;
                x.a(toast2);
                if (i2 == 3500) {
                    f2196e.setDuration(1);
                } else {
                    f2196e.setDuration(0);
                }
                f2197f.setToastString(str);
                f2196e.setView(f2197f.getToastContentView());
            } else {
                if (i2 == 3500) {
                    Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 1);
                    f2196e = makeText;
                    x.a(makeText);
                } else {
                    Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                    f2196e = makeText2;
                    x.a(makeText2);
                }
                f2196e.setText(str);
            }
            f2196e.setGravity(17, 0, d(BdBaseApplication.getInst().getApp(), 100.0f));
        }
        f2198g = str;
        f2199h.postDelayed(f2200i, i2);
        f2196e.show();
    }

    public static void b(Context context, View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int d2 = d(context, i2);
            int d3 = d(context, i3);
            int d4 = d(context, i4);
            int d5 = d(context, i5);
            View view2 = (View) view.getParent();
            view2.post(new b(view, d4, d2, d5, d3, view2));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, null) == null) && BdBaseApplication.getInst().isDebugMode()) {
            if (!B()) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i2 = 1; i2 < stackTrace.length; i2++) {
                    sb.append(stackTrace[i2].getClassName());
                    sb.append(".");
                    sb.append(stackTrace[i2].getMethodName());
                    sb.append("  lines = ");
                    sb.append(stackTrace[i2].getLineNumber());
                    sb.append(StringUtils.LF);
                }
                BdLog.e("can not be call not thread! trace = \n" + sb.toString());
                throw new Error("can not be call not thread! trace = " + sb.toString());
            }
        }
    }

    public static int d(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65555, null, context, f2)) == null) {
            if (!a) {
                x(context);
            }
            return (int) ((f2 * f2193b) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static Field e(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static int f(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, context, i2)) == null) ? context.getResources().getDimensionPixelSize(i2) : invokeLI.intValue;
    }

    public static double g(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
            double F = F(d2);
            double F2 = F(d4);
            return Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((F - F2) / 2.0d), 2.0d) + ((Math.cos(F) * Math.cos(F2)) * Math.pow(Math.sin((F(d3) - F(d5)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d;
        }
        return invokeCommon.doubleValue;
    }

    public static float h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (!a) {
                x(context);
            }
            return f2193b;
        }
        return invokeL.floatValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (!a) {
                x(context);
            }
            return f2195d;
        }
        return invokeL.intValue;
    }

    public static int j(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65561, null, context, z)) == null) {
            if (!a || z) {
                x(context);
            }
            return f2195d;
        }
        return invokeLZ.intValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            if (!a) {
                x(context);
            }
            return f2194c;
        }
        return invokeL.intValue;
    }

    public static int[] l(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65563, null, i2, i3, i4, i5)) == null) {
            if (i2 <= 0 || i3 <= 0 || i4 <= 0 || i5 <= 0) {
                return null;
            }
            int[] iArr = new int[2];
            if (i3 > i5) {
                i2 = (i2 * i5) / i3;
                i3 = i5;
            }
            if (i2 > i4) {
                i3 = (i3 * i4) / i2;
            } else {
                i4 = i2;
            }
            iArr[0] = i4;
            iArr[1] = i3;
            return iArr;
        }
        return (int[]) invokeIIII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String m() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65564;
            InterceptResult invokeV = interceptable.invokeV(65564, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    o.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    o.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                o.g(r2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            o.g(r2);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String n() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65565;
            InterceptResult invokeV = interceptable.invokeV(65565, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    o.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    o.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                o.g(r2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            o.g(r2);
            throw th;
        }
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        }
        return (String) invokeL.objValue;
    }

    public static int[] p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            int[] iArr = new int[2];
            if (context == null) {
                return iArr;
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static DisplayMetrics q(Activity activity) {
        InterceptResult invokeL;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, activity)) == null) {
            DisplayMetrics displayMetrics2 = null;
            try {
                displayMetrics = new DisplayMetrics();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics;
            } catch (Exception e3) {
                e = e3;
                displayMetrics2 = displayMetrics;
                BdLog.e(e.toString());
                return displayMetrics2;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int r(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, activity)) == null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            if (i2 == 0) {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    return i2;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return i2;
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return i2;
                } catch (InstantiationException e5) {
                    e5.printStackTrace();
                    return i2;
                } catch (NoSuchFieldException e6) {
                    e6.printStackTrace();
                    return i2;
                } catch (NumberFormatException e7) {
                    e7.printStackTrace();
                    return i2;
                } catch (SecurityException e8) {
                    e8.printStackTrace();
                    return i2;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String s(TextPaint textPaint, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65570, null, textPaint, str, i2)) == null) {
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i2, TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString();
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }

    public static int t(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += (int) Math.ceil(fArr[i3]);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static c u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? f2197f : (c) invokeV.objValue;
    }

    public static String v() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                if (BdBaseApplication.getInst() == null || (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0) {
                    return null;
                }
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                        return runningTaskInfo.topActivity.getClassName();
                    }
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void w(Context context, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65574, null, context, view) == null) || view == null) {
            return;
        }
        try {
            if (view.getWindowToken() == null) {
                return;
            }
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, null, context) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int orientation = windowManager.getDefaultDisplay().getOrientation();
            if (orientation != 1 && orientation != 3) {
                f2194c = displayMetrics.widthPixels;
                f2195d = displayMetrics.heightPixels;
            } else {
                f2194c = displayMetrics.heightPixels;
                f2195d = displayMetrics.widthPixels;
            }
            f2193b = displayMetrics.density;
            a = true;
        }
    }

    public static boolean y(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            try {
                String str = new String(bArr, 0, 16, "UTF-8");
                if (str.indexOf(com.baidu.wallet.base.audio.b.f50681e) == 0) {
                    return 8 == str.indexOf("WEBPVP8 ");
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme") && (o = o(str)) != null && o.length() >= 3) {
                int e2 = c.a.d.f.m.b.e(o(o.substring(0, 1)), 0);
                int e3 = c.a.d.f.m.b.e(o(o.substring(1, 2)), 0);
                if (e2 > 3 || (e2 == 3 && e3 >= 5)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
