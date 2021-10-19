package com.baidu.fsg.face.base.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f39927a = -1728053248;

    /* renamed from: b  reason: collision with root package name */
    public static String f39928b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final a f39929c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39930d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39931e;

    /* renamed from: f  reason: collision with root package name */
    public View f39932f;

    /* renamed from: g  reason: collision with root package name */
    public View f39933g;

    /* renamed from: com.baidu.fsg.face.base.d.j$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final String f39934a = "status_bar_height";

        /* renamed from: b  reason: collision with root package name */
        public static final String f39935b = "navigation_bar_height";

        /* renamed from: c  reason: collision with root package name */
        public static final String f39936c = "navigation_bar_height_landscape";

        /* renamed from: d  reason: collision with root package name */
        public static final String f39937d = "navigation_bar_width";

        /* renamed from: e  reason: collision with root package name */
        public static final String f39938e = "config_showNavigationBar";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f39939f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f39940g;

        /* renamed from: h  reason: collision with root package name */
        public final int f39941h;

        /* renamed from: i  reason: collision with root package name */
        public final int f39942i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f39943j;
        public final float k;

        public /* synthetic */ a(Activity activity, boolean z, boolean z2, AnonymousClass1 anonymousClass1) {
            this(activity, z, z2);
        }

        @TargetApi(14)
        private int a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                    return 0;
                }
                return a(resources, this.f39943j ? "navigation_bar_height" : "navigation_bar_height_landscape");
            }
            return invokeL.intValue;
        }

        @TargetApi(14)
        private int b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                    return 0;
                }
                return a(resources, "navigation_bar_width");
            }
            return invokeL.intValue;
        }

        @TargetApi(14)
        private boolean c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context)) == null) {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
                if (identifier != 0) {
                    boolean z = resources.getBoolean(identifier);
                    if ("1".equals(j.f39928b)) {
                        return false;
                    }
                    if ("0".equals(j.f39928b)) {
                        return true;
                    }
                    return z;
                }
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return invokeL.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39939f : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39940g : invokeV.booleanValue;
        }

        public a(Activity activity, boolean z, boolean z2) {
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
            this.f39943j = resources.getConfiguration().orientation == 1;
            this.k = a(activity);
            this.f39939f = a(resources, "status_bar_height");
            this.f39941h = a((Context) activity);
            this.f39942i = b(activity);
            this.f39940g = this.f39941h > 0;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39942i : invokeV.intValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39941h : invokeV.intValue;
        }

        private int a(Resources resources, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, resources, str)) == null) {
                int identifier = resources.getIdentifier(str, "dimen", "android");
                if (identifier > 0) {
                    return resources.getDimensionPixelSize(identifier);
                }
                return 0;
            }
            return invokeLL.intValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k >= 600.0f || this.f39943j : invokeV.booleanValue;
        }

        @SuppressLint({"NewApi"})
        private float a(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, activity)) == null) {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-365275413, "Lcom/baidu/fsg/face/base/d/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-365275413, "Lcom/baidu/fsg/face/base/d/j;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f39928b = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f39928b = null;
            }
        }
    }

    @TargetApi(19)
    public j(Activity activity) {
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
                this.f39930d = obtainStyledAttributes.getBoolean(0, false);
                this.f39931e = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f39930d = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f39931e = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        a aVar = new a(activity, this.f39930d, this.f39931e, null);
        this.f39929c = aVar;
        if (!aVar.e()) {
            this.f39931e = false;
        }
        if (this.f39930d) {
            a(activity, viewGroup);
        }
        if (this.f39931e) {
            b(activity, viewGroup);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.f39930d) {
            this.f39932f.setVisibility(z ? 0 : 8);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.f39931e) {
            this.f39933g.setVisibility(z ? 0 : 8);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && this.f39930d) {
            this.f39932f.setBackgroundColor(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f39931e) {
            this.f39933g.setBackgroundColor(i2);
        }
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39929c : (a) invokeV.objValue;
    }

    private void a(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, viewGroup) == null) {
            this.f39932f = new View(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f39929c.d());
            layoutParams.gravity = 48;
            if (this.f39931e && !this.f39929c.c()) {
                layoutParams.rightMargin = this.f39929c.b();
            }
            this.f39932f.setLayoutParams(layoutParams);
            this.f39932f.setBackgroundColor(-1728053248);
            this.f39932f.setVisibility(8);
            viewGroup.addView(this.f39932f);
        }
    }

    private void b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, viewGroup) == null) {
            this.f39933g = new View(context);
            if (this.f39929c.c()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.f39929c.a());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.f39929c.b(), -1);
                layoutParams.gravity = 5;
            }
            this.f39933g.setLayoutParams(layoutParams);
            this.f39933g.setBackgroundColor(-1728053248);
            this.f39933g.setVisibility(8);
            viewGroup.addView(this.f39933g);
        }
    }
}
