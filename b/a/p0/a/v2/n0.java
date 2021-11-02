package b.a.p0.a.v2;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.f1.e.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8620a;

    /* renamed from: b  reason: collision with root package name */
    public static DisplayMetrics f8621b;

    /* renamed from: c  reason: collision with root package name */
    public static final DisplayMetrics f8622c;

    /* renamed from: d  reason: collision with root package name */
    public static final float f8623d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1485471652, "Lb/a/p0/a/v2/n0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1485471652, "Lb/a/p0/a/v2/n0;");
                return;
            }
        }
        f8620a = b.a.p0.a.k.f6397a;
        DisplayMetrics displayMetrics = b.a.p0.a.c1.a.b().getResources().getDisplayMetrics();
        f8622c = displayMetrics;
        f8623d = displayMetrics.density;
    }

    @UiThread
    public static Bitmap A(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            AbsoluteLayout B = T.B(T.C());
            if (B == null || B.getWidth() <= 0 || B.getHeight() <= 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap((int) (B.getWidth() * f2), (int) (B.getHeight() * f3), Bitmap.Config.ARGB_4444);
            createBitmap.eraseColor(-1);
            B.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static void B(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, context) == null) && f8621b == null) {
            Application b2 = b.a.p0.a.c1.a.b();
            if (b2 != null) {
                context = b2;
            }
            if (context == null) {
                return;
            }
            f8621b = context.getResources().getDisplayMetrics();
        }
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ActivityManager activityManager = (ActivityManager) b.a.p0.a.c1.a.b().getSystemService("activity");
            if (activityManager == null) {
                return false;
            }
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean D(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj instanceof String) {
                String valueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(valueOf) && valueOf.startsWith("#")) {
                    return valueOf.length() == 7 || valueOf.length() == 9;
                }
                return false;
            }
            return obj instanceof Integer;
        }
        return invokeL.booleanValue;
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode() : invokeL.booleanValue;
    }

    public static boolean F(@NonNull b.a.p0.a.a2.n.g gVar, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, gVar, context)) == null) ? b.a.p0.a.w2.d.b.f8845i && (TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM) || !f0.h(context)) : invokeLL.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b.a.p0.a.c1.a.b().getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
    }

    public static boolean H(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, activity)) == null) {
            if (activity == null) {
                return false;
            }
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
        }
        return invokeL.booleanValue;
    }

    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? b.a.p0.a.c1.a.b().getResources().getConfiguration().orientation == 1 : invokeV.booleanValue;
    }

    public static void J(BdBaseImageView bdBaseImageView, TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, bdBaseImageView, textView, str) == null) {
            if ("0".equals(str)) {
                bdBaseImageView.setVisibility(8);
                textView.setVisibility(8);
            } else if ("1".equals(String.valueOf(str))) {
                bdBaseImageView.setVisibility(0);
                textView.setVisibility(0);
                textView.setText(b.a.p0.a.h.aiapps_history_aiapp_tag);
            } else if ("2".equals(String.valueOf(str))) {
                bdBaseImageView.setVisibility(0);
                textView.setVisibility(0);
                textView.setText(b.a.p0.a.h.aiapps_history_aiapp_tag_trial);
            } else if ("3".equals(String.valueOf(str))) {
                bdBaseImageView.setVisibility(0);
                textView.setVisibility(0);
                textView.setText(b.a.p0.a.h.aiapps_history_aiapp_tag_experience);
            }
        }
    }

    public static int K(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65547, null, context, f2)) == null) ? (int) (f2 / l(context)) : invokeLF.intValue;
    }

    public static int L(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65548, null, f2)) == null) ? K(b.a.p0.a.c1.a.b(), f2) : invokeF.intValue;
    }

    public static float M(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65549, null, f2)) == null) ? f2 / l(b.a.p0.a.c1.a.b()) : invokeF.floatValue;
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, activity) == null) && activity != null && b.a.p0.a.w2.d.b.f8845i) {
            new b.a.p0.a.w2.d.b(activity).n(-1, false, true, true);
        }
    }

    public static void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, activity) == null) && activity != null && b.a.p0.a.w2.d.b.f8845i) {
            new b.a.p0.a.w2.d.b(activity).n(-1, true, false, true);
        }
    }

    public static void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, activity) == null) && f.d(activity) && b.a.p0.t.e.d() && b.a.p0.t.e.e(activity)) {
            i(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(int i2, String str) {
        InterceptResult invokeIL;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65553, null, i2, str)) == null) {
            Context appContext = AppRuntime.getAppContext();
            try {
                i3 = u();
                try {
                    i4 = appContext.getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_normal_base_action_bar_height);
                    try {
                        i5 = appContext.getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_bottom_tab_height);
                        try {
                            i5 += appContext.getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_bottom_tab_shadow_height);
                        } catch (Resources.NotFoundException e2) {
                            e = e2;
                            if (f8620a) {
                                e.printStackTrace();
                            }
                            if (TextUtils.isEmpty(str)) {
                            }
                            if (!z) {
                            }
                            if (!z3) {
                            }
                            if (!z4) {
                            }
                            if (z2) {
                            }
                            if (f8620a) {
                            }
                            return Math.max(r9, 0);
                        }
                    } catch (Resources.NotFoundException e3) {
                        e = e3;
                        i5 = 0;
                        if (f8620a) {
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (!z) {
                        }
                        if (!z3) {
                        }
                        if (!z4) {
                        }
                        if (z2) {
                        }
                        if (f8620a) {
                        }
                        return Math.max(r9, 0);
                    }
                } catch (Resources.NotFoundException e4) {
                    e = e4;
                    i4 = 0;
                    i5 = 0;
                    if (f8620a) {
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z4) {
                    }
                    if (z2) {
                    }
                    if (f8620a) {
                    }
                    return Math.max(r9, 0);
                }
            } catch (Resources.NotFoundException e5) {
                e = e5;
                i3 = 0;
            }
            if (TextUtils.isEmpty(str)) {
                String b2 = b.a.p0.a.c2.f.p0.j.b(o0.f(str));
                SwanAppConfigData r = b.a.p0.a.g1.f.T().r();
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P == null) {
                    return i2;
                }
                b.a K = P.K();
                b.a.p0.a.a2.n.g d2 = b.a.p0.a.g1.f.T().d(b2, r, e.C0109e.i(K.G(), K.s1()).getPath() + File.separator);
                if (b.a.p0.a.a2.n.g.f(d2)) {
                    z3 = true;
                    z4 = F(d2, appContext);
                } else {
                    z3 = false;
                    z4 = false;
                }
                z = q0.E(b2);
                z2 = d2.f4009f;
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            int i6 = !z ? i2 - i5 : i2;
            if (!z3) {
                i6 -= i4;
            }
            if (!z4) {
                i6 -= i3;
            }
            if (z2) {
                i6 -= (int) (h(50.0f) + 0.5f);
            }
            if (f8620a) {
                String str2 = "screenHeight:" + i2 + ",notchHeight:" + f0.e(appContext) + ",navHeight:" + g0.c() + ",preGuessWebViewHeight:" + i6 + ",pageUrl:" + str + ",hasTab:" + z + ",bottomBarHeight:" + i5 + ",isTransparentBar:" + z3 + ",actionBarHeight:" + i4 + ",isOccupyStatusBar:" + z4 + ",statusBarHeight:" + i3 + ",canPullToRefresh:" + z2;
            }
            return Math.max(i6, 0);
        }
        return invokeIL.intValue;
    }

    public static Pair<Integer, Integer> e(String str) {
        InterceptResult invokeL;
        Pair<Integer, Integer> x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            long currentTimeMillis = f8620a ? System.currentTimeMillis() : 0L;
            if (b.a.p0.a.a2.d.g().x() == null) {
                x = (Pair) b.a.p0.a.f1.c.b.c().b("screenSize");
                if (x == null) {
                    x = g0.b();
                }
            } else {
                x = b.a.p0.a.g1.f.T().x();
            }
            int intValue = ((Integer) x.first).intValue();
            int d2 = d(((Integer) x.second).intValue(), str);
            if (f8620a) {
                String str2 = "preGuessWebViewSize cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms";
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(d2));
        }
        return (Pair) invokeL.objValue;
    }

    public static int f(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65555, null, context, f2)) == null) ? (int) (f2 * l(context)) : invokeLF.intValue;
    }

    public static int g(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65556, null, f2)) == null) ? f(b.a.p0.a.c1.a.b(), f2) : invokeF.intValue;
    }

    public static float h(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65557, null, f2)) == null) ? f2 * l(b.a.p0.a.c1.a.b()) : invokeF.floatValue;
    }

    public static void i(Activity activity) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, null, activity) == null) && f.d(activity) && (frameLayout = (FrameLayout) activity.getWindow().getDecorView().getRootView().findViewById(b.a.p0.a.f.ai_apps_activity_root)) != null) {
            frameLayout.setBackgroundColor(activity.getResources().getColor(b.a.p0.a.c.aiapps_keyboard_divider_color));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b.a.p0.t.e.a(activity), -1);
            layoutParams.gravity = 17;
            ((FrameLayout) frameLayout.findViewById(b.a.p0.a.f.ai_apps_container)).setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
        }
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? b.a.p0.a.c1.a.b().getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_normal_base_action_bar_height) : invokeV.intValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        b.a.p0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            int i2 = 0;
            if (context == null || U == null || (m = U.m()) == null || !(m instanceof b.a.p0.a.h0.g.f) || !((b.a.p0.a.h0.g.f) m).T1()) {
                return 0;
            }
            try {
                i2 = context.getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_bottom_tab_height);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_bottom_tab_shadow_height);
                return dimensionPixelSize > 0 ? i2 + dimensionPixelSize : i2;
            } catch (Resources.NotFoundException e2) {
                if (f8620a) {
                    e2.printStackTrace();
                    return i2;
                }
                return i2;
            }
        }
        return invokeL.intValue;
    }

    public static float l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            B(b.a.p0.a.c1.a.b());
            DisplayMetrics displayMetrics = f8621b;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static int m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            B(b.a.p0.a.c1.a.b());
            DisplayMetrics displayMetrics = f8621b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            B(b.a.p0.a.c1.a.b());
            DisplayMetrics displayMetrics = f8621b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int o(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            B(b.a.p0.a.c1.a.b());
            DisplayMetrics displayMetrics = f8621b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static Bitmap p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? q(b.a.p0.a.g1.f.T().getActivity()) : (Bitmap) invokeV.objValue;
    }

    public static Bitmap q(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, activity)) == null) {
            if (activity == null) {
                return null;
            }
            View findViewById = activity.findViewById(16908290);
            Bitmap bitmap = null;
            for (int i2 = 1; i2 < 3; i2++) {
                try {
                    findViewById.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = findViewById.getDrawingCache();
                    if (drawingCache != null) {
                        bitmap = Bitmap.createScaledBitmap(drawingCache, drawingCache.getWidth() / i2, drawingCache.getHeight() / i2, false);
                    }
                    findViewById.setDrawingCacheEnabled(false);
                } catch (NullPointerException | OutOfMemoryError e2) {
                    if (f8620a) {
                        e2.printStackTrace();
                    }
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int r(Resources resources, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, resources, str)) == null) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            boolean hasPermanentMenuKey = ViewConfiguration.get(b.a.p0.a.c1.a.b()).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = b.a.p0.a.c1.a.b().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return invokeV.intValue;
    }

    public static int t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? !E(context) ? H((Activity) context) ? n(context) : o(context) : G() ? n(context) : o(context) : invokeL.intValue;
    }

    public static int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            int identifier = b.a.p0.a.c1.a.b().getResources().getIdentifier("status_bar_height", "dimen", "android");
            int i2 = 0;
            if (identifier > 0) {
                try {
                    i2 = b.a.p0.a.c1.a.b().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            return i2 == 0 ? (int) (f8623d * 25.0f) : i2;
        }
        return invokeV.intValue;
    }

    public static int v(Context context) {
        InterceptResult invokeL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            int n = n(context);
            int u = u();
            int k = k(context);
            try {
                i2 = context.getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_normal_base_action_bar_height);
            } catch (Resources.NotFoundException e2) {
                if (f8620a) {
                    e2.printStackTrace();
                }
                i2 = 0;
            }
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            b.a.p0.a.h0.g.f fVar = null;
            if (U != null) {
                b.a.p0.a.h0.g.d m = U.m();
                if (m instanceof b.a.p0.a.h0.g.f) {
                    fVar = (b.a.p0.a.h0.g.f) m;
                }
            }
            boolean z2 = true;
            if (fVar == null || !b.a.p0.a.a2.n.g.f(fVar.x1())) {
                z2 = false;
                z = false;
            } else {
                b.a.p0.a.w2.d.b z1 = fVar.z1();
                z2 = (z1 == null || !z1.i()) ? false : false;
                z = true;
            }
            int i3 = n - k;
            if (!z2) {
                i3 -= u;
            }
            if (!z) {
                i3 -= i2;
            }
            if (i3 > 0) {
                return i3;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int w(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, textView)) == null) {
            if (textView == null) {
                return 0;
            }
            Paint paint = new Paint();
            paint.setTextSize(textView.getTextSize());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            if (TextUtils.isEmpty(textView.getText())) {
                return 0;
            }
            return (int) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
        }
        return invokeL.intValue;
    }

    public static int x(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, textView)) == null) {
            if (textView == null) {
                return 0;
            }
            Paint paint = new Paint();
            paint.setTextSize(textView.getTextSize());
            if (TextUtils.isEmpty(textView.getText())) {
                return 0;
            }
            return (int) paint.measureText(textView.getText().toString());
        }
        return invokeL.intValue;
    }

    @UiThread
    public static Bitmap y(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65574, null, view, i2, i3)) == null) {
            if (view == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @UiThread
    public static Bitmap z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? A(1.0f, 1.0f) : (Bitmap) invokeV.objValue;
    }
}
