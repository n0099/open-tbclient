package b.a.p0.a.z1.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
@SuppressLint({"ObsoleteSdkInt"})
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static String f9202f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b f9203a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9204b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9205c;

    /* renamed from: d  reason: collision with root package name */
    public View f9206d;

    /* renamed from: e  reason: collision with root package name */
    public View f9207e;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f9208a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9209b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9210c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9211d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f9212e;

        /* renamed from: f  reason: collision with root package name */
        public final float f9213f;

        public /* synthetic */ b(Activity activity, boolean z, boolean z2, a aVar) {
            this(activity, z, z2);
        }

        @TargetApi(14)
        public final int a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                if (Build.VERSION.SDK_INT >= 14) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(16843499, typedValue, true);
                    return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int b(Resources resources, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resources, str)) == null) {
                int identifier = resources.getIdentifier(str, "dimen", "android");
                if (identifier > 0) {
                    return resources.getDimensionPixelSize(identifier);
                }
                return 0;
            }
            return invokeLL.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9210c : invokeV.intValue;
        }

        @TargetApi(14)
        public final int d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                    return 0;
                }
                return b(resources, this.f9212e ? "navigation_bar_height" : "navigation_bar_height_landscape");
            }
            return invokeL.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f9211d : invokeV.intValue;
        }

        @TargetApi(14)
        public final int f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                    return 0;
                }
                return b(resources, "navigation_bar_width");
            }
            return invokeL.intValue;
        }

        @SuppressLint({"NewApi"})
        public final float g(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (Build.VERSION.SDK_INT >= 16) {
                    activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                }
                float f2 = displayMetrics.density;
                return Math.min(displayMetrics.widthPixels / f2, displayMetrics.heightPixels / f2);
            }
            return invokeL.floatValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f9208a : invokeV.intValue;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
                if (identifier != 0) {
                    boolean z = resources.getBoolean(identifier);
                    if ("1".equals(c.f9202f)) {
                        return false;
                    }
                    if ("0".equals(c.f9202f)) {
                        return true;
                    }
                    return z;
                }
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return invokeL.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f9209b : invokeV.booleanValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f9213f >= 600.0f || this.f9212e : invokeV.booleanValue;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Resources resources = activity.getResources();
            this.f9212e = resources.getConfiguration().orientation == 1;
            this.f9213f = g(activity);
            this.f9208a = b(resources, "status_bar_height");
            a(activity);
            this.f9210c = d(activity);
            this.f9211d = f(activity);
            this.f9209b = this.f9210c > 0;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(421050376, "Lb/a/p0/a/z1/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(421050376, "Lb/a/p0/a/z1/a/c;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f9202f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f9202f = null;
            }
        }
    }

    @TargetApi(19)
    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f9204b = obtainStyledAttributes.getBoolean(0, false);
                this.f9205c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f9204b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f9205c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f9204b, this.f9205c, null);
        this.f9203a = bVar;
        if (!bVar.j()) {
            this.f9205c = false;
        }
        if (this.f9204b) {
            d(activity, viewGroup);
        }
        if (this.f9205c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f9204b) {
            this.f9206d.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup) == null) {
            this.f9207e = new View(context);
            if (this.f9203a.k()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.f9203a.c());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.f9203a.e(), -1);
                layoutParams.gravity = 5;
            }
            this.f9207e.setLayoutParams(layoutParams);
            this.f9207e.setBackgroundColor(-1728053248);
            this.f9207e.setVisibility(8);
            viewGroup.addView(this.f9207e);
        }
    }

    public final void d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, viewGroup) == null) {
            this.f9206d = new View(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f9203a.h());
            layoutParams.gravity = 48;
            if (this.f9205c && !this.f9203a.k()) {
                layoutParams.rightMargin = this.f9203a.e();
            }
            this.f9206d.setLayoutParams(layoutParams);
            this.f9206d.setBackgroundColor(-1728053248);
            this.f9206d.setVisibility(8);
            viewGroup.addView(this.f9206d);
        }
    }
}
