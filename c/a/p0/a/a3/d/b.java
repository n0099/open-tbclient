package c.a.p0.a.a3.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a3.d.a;
import c.a.p0.a.c;
import c.a.p0.a.f;
import c.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f4265i;

    /* renamed from: j  reason: collision with root package name */
    public static int f4266j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Activity a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f4267b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public View f4268c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public View f4269d;

    /* renamed from: e  reason: collision with root package name */
    public int f4270e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4271f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.a3.d.a f4272g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnSystemUiVisibilityChangeListener f4273h;

    /* loaded from: classes.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-744891702, "Lc/a/p0/a/a3/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-744891702, "Lc/a/p0/a/a3/d/b;");
                return;
            }
        }
        f4265i = j();
        f4266j = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            f4266j = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            f4266j = 2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i3 == 0) {
                return i2;
            }
            float f2 = 1.0f - (i3 / 255.0f);
            return ((int) (((i2 & 255) * f2) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f2) + 0.5d)) << 16) | (-16777216) | (((int) ((((i2 >> 8) & 255) * f2) + 0.5d)) << 8);
        }
        return invokeII.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    public final c.a.p0.a.a3.d.a b(int i2, int i3, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            a.b b2 = a.b.b();
            b2.i(z);
            b2.h(true);
            b2.g(false);
            b2.f(i3);
            b2.e(i2);
            b2.c(z2);
            b2.d(z3);
            return b2.a();
        }
        return (c.a.p0.a.a3.d.a) invokeCommon.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int f2 = f();
            this.f4272g = b(f2, g(f2), false, false, true);
        }
    }

    @NonNull
    public c.a.p0.a.a3.d.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f4272g == null) {
                c();
            }
            return this.f4272g;
        }
        return (c.a.p0.a.a3.d.a) invokeV.objValue;
    }

    @Nullable
    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f4269d : (View) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.a.getResources().getColor(c.aiapps_statusbar_immersion_bg);
            }
            return this.a.getResources().getColor(c.aiapps_statusbar_immersion_bg_below_lollipop);
        }
        return invokeV.intValue;
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return 0;
            }
            return a(i2, 45);
        }
        return invokeI.intValue;
    }

    public final View h(@NonNull c.a.p0.a.a3.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar.f4258g) {
                View view = this.f4269d;
                if (view != null) {
                    if (aVar.f4256e) {
                        return view;
                    }
                    this.f4267b.removeView(view);
                    this.f4269d = null;
                    return null;
                } else if (!aVar.f4256e) {
                    this.f4269d = null;
                    return null;
                } else {
                    int t = n0.t();
                    View view2 = new View(this.a);
                    view2.setTag("IMMERSION_VIEW");
                    view2.setId(f.immersion_custom_statusbar_view);
                    this.f4267b.addView(view2, new ViewGroup.LayoutParams(-1, t));
                    this.f4269d = view2;
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4271f : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f4272g = null;
            this.f4270e = 1;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(d());
        }
    }

    public void m(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            n(i2, z, true, z2);
        }
    }

    public void n(int i2, boolean z, boolean z2, boolean z3) {
        c.a.p0.a.a3.d.a b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && f4265i) {
            if (i2 == 1) {
                if (this.f4270e != 1) {
                    k();
                }
                this.f4270e = i2;
                b2 = d();
            } else {
                this.f4270e = i2;
                b2 = b(i2, g(i2), z3, z, z2);
                this.f4272g = b2;
            }
            this.f4271f = z;
            o(b2);
        }
    }

    public final void o(@NonNull c.a.p0.a.a3.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            if (f4266j == 2) {
                p(aVar);
            } else {
                r();
                s(aVar);
            }
            View view = this.f4268c;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                if (aVar.f4257f) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = n0.t();
                }
                this.f4268c.setLayoutParams(layoutParams);
            }
        }
    }

    public final void p(c.a.p0.a.a3.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            try {
                Window window = this.a.getWindow();
                window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, aVar.f4255d ? i2 | i3 : (~i2) & i3);
                window.setAttributes(attributes);
                int i4 = aVar.f4253b;
                if (i4 == 1) {
                    i4 = f();
                }
                View h2 = h(aVar);
                if (h2 != null) {
                    h2.setBackgroundColor(i4);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public final boolean q(Window window, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, window, z)) == null) {
            if (window != null) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                    if (z) {
                        method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                    } else {
                        method.invoke(window, 0, Integer.valueOf(i2));
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Window window = this.a.getWindow();
            window.clearFlags(1024);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                if (i2 >= 19) {
                    window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    return;
                }
                return;
            }
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            if (f4266j != 1) {
                return;
            }
            q(window, d().f4255d);
        }
    }

    @SuppressLint({"InlinedApi"})
    public final void s(c.a.p0.a.a3.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            Window window = this.a.getWindow();
            boolean z = aVar.f4254c;
            int i2 = aVar.f4255d ? 13312 : 5120;
            int i3 = !aVar.f4256e ? i2 & (-257) : i2 | 256;
            int i4 = aVar.f4253b;
            if (i4 == 1) {
                i4 = f();
            }
            window.getDecorView().setSystemUiVisibility(i3);
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(aVar.a);
            }
            View h2 = h(aVar);
            if (h2 != null) {
                h2.setBackgroundColor(i4);
            }
            if (this.f4273h == null) {
                this.f4273h = new a(this);
                window.getDecorView().setOnSystemUiVisibilityChangeListener(this.f4273h);
            }
        }
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f4270e = 1;
        this.a = activity;
        this.f4267b = viewGroup;
        this.f4268c = viewGroup.getChildAt(0);
    }
}
