package com.baidu.pass.biometrics.base.utils;

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
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class SapiSystemBarTintManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final int f44031f = -1728053248;

    /* renamed from: g  reason: collision with root package name */
    public static String f44032g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SystemBarConfig f44033a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44034b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44035c;

    /* renamed from: d  reason: collision with root package name */
    public View f44036d;

    /* renamed from: e  reason: collision with root package name */
    public View f44037e;

    /* renamed from: com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class SystemBarConfig {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: g  reason: collision with root package name */
        public static final String f44038g = "status_bar_height";

        /* renamed from: h  reason: collision with root package name */
        public static final String f44039h = "navigation_bar_height";

        /* renamed from: i  reason: collision with root package name */
        public static final String f44040i = "navigation_bar_height_landscape";

        /* renamed from: j  reason: collision with root package name */
        public static final String f44041j = "navigation_bar_width";
        public static final String k = "config_showNavigationBar";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f44042a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44043b;

        /* renamed from: c  reason: collision with root package name */
        public final int f44044c;

        /* renamed from: d  reason: collision with root package name */
        public final int f44045d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f44046e;

        /* renamed from: f  reason: collision with root package name */
        public final float f44047f;

        public /* synthetic */ SystemBarConfig(Activity activity, boolean z, boolean z2, AnonymousClass1 anonymousClass1) {
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
                return a(resources, this.f44046e ? "navigation_bar_height" : "navigation_bar_height_landscape");
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
                    if ("1".equals(SapiSystemBarTintManager.f44032g)) {
                        return false;
                    }
                    if ("0".equals(SapiSystemBarTintManager.f44032g)) {
                        return true;
                    }
                    return z;
                }
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return invokeL.booleanValue;
        }

        public int getNavigationBarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44044c : invokeV.intValue;
        }

        public int getNavigationBarWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44045d : invokeV.intValue;
        }

        public int getStatusBarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44042a : invokeV.intValue;
        }

        public boolean hasNavigtionBar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44043b : invokeV.booleanValue;
        }

        public boolean isNavigationAtBottom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44047f >= 600.0f || this.f44046e : invokeV.booleanValue;
        }

        public SystemBarConfig(Activity activity, boolean z, boolean z2) {
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
            this.f44046e = resources.getConfiguration().orientation == 1;
            this.f44047f = a(activity);
            this.f44042a = a(resources, "status_bar_height");
            this.f44044c = a((Context) activity);
            this.f44045d = b(activity);
            this.f44043b = this.f44044c > 0;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1720231662, "Lcom/baidu/pass/biometrics/base/utils/SapiSystemBarTintManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1720231662, "Lcom/baidu/pass/biometrics/base/utils/SapiSystemBarTintManager;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f44032g = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f44032g = null;
            }
        }
    }

    @TargetApi(19)
    public SapiSystemBarTintManager(Activity activity) {
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
                this.f44034b = obtainStyledAttributes.getBoolean(0, false);
                this.f44035c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((attributes.flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0) {
                    this.f44034b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f44035c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.f44034b, this.f44035c, null);
        this.f44033a = systemBarConfig;
        if (!systemBarConfig.hasNavigtionBar()) {
            this.f44035c = false;
        }
        if (this.f44034b) {
            b(activity, viewGroup);
        }
        if (this.f44035c) {
            a(activity, viewGroup);
        }
    }

    private void b(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, viewGroup) == null) {
            this.f44036d = new View(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f44033a.getStatusBarHeight());
            layoutParams.gravity = 48;
            if (this.f44035c && !this.f44033a.isNavigationAtBottom()) {
                layoutParams.rightMargin = this.f44033a.getNavigationBarWidth();
            }
            this.f44036d.setLayoutParams(layoutParams);
            this.f44036d.setBackgroundColor(-1728053248);
            this.f44036d.setVisibility(8);
            viewGroup.addView(this.f44036d);
        }
    }

    public SystemBarConfig getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44033a : (SystemBarConfig) invokeV.objValue;
    }

    public void setNavigationBarTintColor(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && this.f44035c) {
            this.f44037e.setBackgroundColor(i2);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.f44035c) {
            this.f44037e.setVisibility(z ? 0 : 8);
        }
    }

    public void setStatusBarTintColor(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f44034b) {
            this.f44036d.setBackgroundColor(i2);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.f44034b) {
            this.f44036d.setVisibility(z ? 0 : 8);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, viewGroup) == null) {
            this.f44037e = new View(context);
            if (this.f44033a.isNavigationAtBottom()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.f44033a.getNavigationBarHeight());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.f44033a.getNavigationBarWidth(), -1);
                layoutParams.gravity = 5;
            }
            this.f44037e.setLayoutParams(layoutParams);
            this.f44037e.setBackgroundColor(-1728053248);
            this.f44037e.setVisibility(8);
            viewGroup.addView(this.f44037e);
        }
    }
}
