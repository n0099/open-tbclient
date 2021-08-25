package c.a.o0.a.z1.b.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.h;
import c.a.o0.a.k;
import c.a.o0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.swan.apps.res.widget.toast.ToastTemplate;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10033a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f10034b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f10035c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f10036d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f10037e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f10038f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f10039g;

    /* renamed from: h  reason: collision with root package name */
    public int f10040h;

    /* renamed from: i  reason: collision with root package name */
    public int f10041i;

    /* renamed from: j  reason: collision with root package name */
    public c f10042j;
    public int k;
    public b l;
    public boolean m;
    public View n;
    public ToastRightAreaStyle o;
    public CharSequence p;
    public CharSequence q;
    public ToastLocation r;
    public ToastTemplate s;
    public boolean t;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10043a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1627555281, "Lc/a/o0/a/z1/b/f/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1627555281, "Lc/a/o0/a/z1/b/f/e$a;");
                    return;
                }
            }
            int[] iArr = new int[ToastTemplate.values().length];
            f10043a = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10043a[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10043a[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10043a[ToastTemplate.T4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(439681966, "Lc/a/o0/a/z1/b/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(439681966, "Lc/a/o0/a/z1/b/f/e;");
                return;
            }
        }
        u = k.f7049a;
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 2;
        this.o = ToastRightAreaStyle.JUMP;
        this.r = ToastLocation.MIDDLE;
        this.s = ToastTemplate.T1;
        this.t = false;
        this.f10033a = context;
        this.f10040h = 2;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c.a.o0.a.z1.b.f.a.d();
            f.h();
        }
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? n0.u() + ((int) context.getResources().getDimension(c.a.o0.a.d.aiapps_normal_base_action_bar_height)) : invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.o0.a.z1.b.f.a.e() || f.k() : invokeV.booleanValue;
    }

    public static e e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? new e(context) : (e) invokeL.objValue;
    }

    public static e f(@NonNull Context context, @StringRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, context, i2)) == null) {
            e eVar = new e(context);
            eVar.f10034b = context.getText(i2);
            return eVar;
        }
        return (e) invokeLI.objValue;
    }

    public static e g(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, charSequence)) == null) {
            e eVar = new e(context);
            eVar.f10034b = charSequence;
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(false);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.f10033a;
                if (context instanceof Activity) {
                    f.n((Activity) context, this.f10034b, this.f10037e, this.n, this.f10040h, this.m);
                    return;
                }
            }
            c.a.o0.a.z1.b.f.a.j(this.f10033a, this.f10034b, this.f10037e, this.n, this.f10040h, this.m);
        }
    }

    @Deprecated
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D(false);
        }
    }

    @Deprecated
    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && b()) {
            a();
            if (z) {
                x(this.f10033a, this.f10035c);
            } else if (this.f10033a instanceof Activity) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (1 == this.k) {
                    this.o = ToastRightAreaStyle.JUMP;
                } else {
                    this.o = ToastRightAreaStyle.BUTTON;
                }
                if (TextUtils.isEmpty(this.f10036d)) {
                    f.o((Activity) this.f10033a, null, null, null, this.f10034b, null, this.f10040h, this.r, this.f10042j, this.m);
                    return;
                }
                CharSequence charSequence = this.f10035c;
                CharSequence charSequence2 = this.f10034b;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f10034b)) {
                    charSequence = this.f10034b;
                    charSequence2 = "";
                }
                f.p((Activity) this.f10033a, this.f10039g, null, null, charSequence, charSequence2, this.f10036d, this.o, this.f10040h, false, this.f10042j);
            } else {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    c.a.o0.a.z1.b.f.a.f(bVar2);
                    this.l = null;
                }
                x(this.f10033a, this.f10035c);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            a();
            c.a.o0.a.z1.b.f.a.h(this.f10033a, this.f10034b, this.f10040h, false, this.f10041i, this.m);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            G(false);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && b()) {
            a();
            if (!z && (this.f10033a instanceof Activity)) {
                if (u) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("给View set 的mOnDismissListener是不是空?");
                    sb.append(this.l == null);
                    sb.toString();
                }
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                f.o((Activity) this.f10033a, null, null, null, this.f10034b, null, this.f10040h, this.r, this.f10042j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                c.a.o0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f10033a, this.f10034b);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            I(false);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.f10033a;
                if (context instanceof Activity) {
                    f.o((Activity) context, null, null, null, this.f10034b, null, this.f10040h, ToastLocation.BOTTOM, this.f10042j, this.m);
                    return;
                }
            }
            x(this.f10033a, this.f10034b);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f10033a == null) {
                if (u) {
                    throw new IllegalArgumentException("UniversalToast mContext is null!!!");
                }
                return false;
            } else if (this.f10034b == null) {
                if (u) {
                    throw new IllegalArgumentException("UniversalToast toast text is null!!!");
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public e h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this : (e) invokeI.objValue;
    }

    public e i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this : (e) invokeI.objValue;
    }

    @Deprecated
    public e j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.k = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e k(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
            this.f10036d = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f10040h = Math.max(i2, 1);
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e m(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            Context context = this.f10033a;
            if (context != null && context.getResources() != null) {
                this.f10037e = this.f10033a.getResources().getDrawable(i2);
            }
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e n(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
            this.f10037e = drawable;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e o(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, uri)) == null) {
            this.f10039g = uri;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e p(@NonNull int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.f10041i = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e q(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, charSequence)) == null) {
            this.f10034b = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public e s(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
            this.f10035c = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e t(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, cVar)) == null) {
            this.f10042j = cVar;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f10033a != null && (!TextUtils.isEmpty(this.f10034b) || !TextUtils.isEmpty(this.f10035c))) {
                a();
                if (this.f10033a instanceof Activity) {
                    int i2 = a.f10043a[this.s.ordinal()];
                    if (i2 == 2) {
                        if (TextUtils.isEmpty(this.f10034b)) {
                            return;
                        }
                        f.o((Activity) this.f10033a, this.f10039g, this.f10038f, this.n, this.f10034b, this.q, this.f10040h, this.r, this.f10042j, this.m);
                        return;
                    } else if (i2 == 3) {
                        if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.f10034b)) {
                            f.o((Activity) this.f10033a, this.f10039g, this.f10038f, this.n, this.f10034b, this.q, this.f10040h, this.r, this.f10042j, this.m);
                            return;
                        } else if (TextUtils.isEmpty(this.f10035c)) {
                            return;
                        } else {
                            f.p((Activity) this.f10033a, this.f10039g, this.f10038f, this.n, this.f10035c, this.p, this.q, this.o, this.f10040h, this.t, this.f10042j);
                            return;
                        }
                    } else if (i2 != 4) {
                        if (TextUtils.isEmpty(this.f10034b)) {
                            return;
                        }
                        f.o((Activity) this.f10033a, null, null, null, this.f10034b, null, this.f10040h, this.r, null, this.m);
                        return;
                    } else if (TextUtils.isEmpty(this.f10034b)) {
                        return;
                    } else {
                        f.n((Activity) this.f10033a, this.f10034b, this.f10037e, this.n, this.f10040h, this.m);
                        return;
                    }
                } else if (a.f10043a[this.s.ordinal()] != 4) {
                    x(this.f10033a, TextUtils.isEmpty(this.f10034b) ? this.f10035c : this.f10034b);
                    return;
                } else if (TextUtils.isEmpty(this.f10034b)) {
                    return;
                } else {
                    c.a.o0.a.z1.b.f.a.j(this.f10033a, this.f10034b, this.f10037e, this.n, this.f10040h, this.m);
                    return;
                }
            }
            d.h("has no mToastText or mTitleText");
        }
    }

    @Deprecated
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            w(false, false);
        }
    }

    @Deprecated
    public void w(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && b()) {
            a();
            if (!z && (this.f10033a instanceof Activity)) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (TextUtils.isEmpty(this.f10036d)) {
                    this.f10036d = c.a.o0.a.c1.a.b().getResources().getText(h.aiapps_check_action_text);
                }
                f.o((Activity) this.f10033a, null, null, null, this.f10034b, this.f10036d, this.f10040h, ToastLocation.BOTTOM, this.f10042j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                c.a.o0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f10033a, this.f10034b);
        }
    }

    public final void x(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, context, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        c.a.o0.a.z1.b.f.a.k(context, null, null, null, charSequence, null, this.f10040h, this.r, null, this.m);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            z(false);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.f10033a;
                if (context instanceof Activity) {
                    f.m((Activity) context, this.f10034b, this.f10040h, this.m);
                    return;
                }
            }
            c.a.o0.a.z1.b.f.a.i(this.f10033a, this.f10034b, this.f10040h, this.m);
        }
    }
}
