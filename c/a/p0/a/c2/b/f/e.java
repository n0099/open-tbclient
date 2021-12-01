package c.a.p0.a.c2.b.f;

import android.annotation.SuppressLint;
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
import c.a.p0.a.h;
import c.a.p0.a.k;
import c.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
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
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f4561b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f4562c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f4563d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f4564e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f4565f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f4566g;

    /* renamed from: h  reason: collision with root package name */
    public int f4567h;

    /* renamed from: i  reason: collision with root package name */
    public int f4568i;

    /* renamed from: j  reason: collision with root package name */
    public c f4569j;

    /* renamed from: k  reason: collision with root package name */
    public int f4570k;
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
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-699284104, "Lc/a/p0/a/c2/b/f/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-699284104, "Lc/a/p0/a/c2/b/f/e$a;");
                    return;
                }
            }
            int[] iArr = new int[ToastTemplate.values().length];
            a = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ToastTemplate.T4.ordinal()] = 4;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(298713365, "Lc/a/p0/a/c2/b/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(298713365, "Lc/a/p0/a/c2/b/f/e;");
                return;
            }
        }
        u = k.a;
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
        this.f4570k = 2;
        this.o = ToastRightAreaStyle.JUMP;
        this.r = ToastLocation.MIDDLE;
        this.s = ToastTemplate.T1;
        this.t = false;
        this.a = context;
        this.f4567h = 2;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c.a.p0.a.c2.b.f.a.d();
            f.h();
        }
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? n0.t() + ((int) context.getResources().getDimension(c.a.p0.a.d.aiapps_normal_base_action_bar_height)) : invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.p0.a.c2.b.f.a.e() || f.k() : invokeV.booleanValue;
    }

    public static e e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? new e(context) : (e) invokeL.objValue;
    }

    public static e f(@NonNull Context context, @StringRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i2)) == null) {
            e eVar = new e(context);
            eVar.f4561b = context.getText(i2);
            return eVar;
        }
        return (e) invokeLI.objValue;
    }

    public static e g(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, charSequence)) == null) {
            e eVar = new e(context);
            eVar.f4561b = charSequence;
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.a;
                if (context instanceof Activity) {
                    f.m((Activity) context, this.f4561b, this.f4567h, this.m);
                    return;
                }
            }
            c.a.p0.a.c2.b.f.a.i(this.a, this.f4561b, this.f4567h, this.m);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C(false);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.a;
                if (context instanceof Activity) {
                    f.n((Activity) context, this.f4561b, this.f4564e, this.n, this.f4567h, this.m);
                    return;
                }
            }
            c.a.p0.a.c2.b.f.a.j(this.a, this.f4561b, this.f4564e, this.n, this.f4567h, this.m);
        }
    }

    @Deprecated
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            E(false);
        }
    }

    @Deprecated
    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && b()) {
            a();
            if (z) {
                y(this.a, this.f4562c);
            } else if (this.a instanceof Activity) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (1 == this.f4570k) {
                    this.o = ToastRightAreaStyle.JUMP;
                } else {
                    this.o = ToastRightAreaStyle.BUTTON;
                }
                if (TextUtils.isEmpty(this.f4563d)) {
                    f.o((Activity) this.a, null, null, null, this.f4561b, null, this.f4567h, this.r, this.f4569j, this.m);
                    return;
                }
                CharSequence charSequence = this.f4562c;
                CharSequence charSequence2 = this.f4561b;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f4561b)) {
                    charSequence = this.f4561b;
                    charSequence2 = "";
                }
                f.p((Activity) this.a, this.f4566g, null, null, charSequence, charSequence2, this.f4563d, this.o, this.f4567h, false, this.f4569j);
            } else {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    c.a.p0.a.c2.b.f.a.f(bVar2);
                    this.l = null;
                }
                y(this.a, this.f4562c);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && b()) {
            a();
            c.a.p0.a.c2.b.f.a.h(this.a, this.f4561b, this.f4567h, false, this.f4568i, this.m);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            H(false);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && b()) {
            a();
            if (!z && (this.a instanceof Activity)) {
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
                f.o((Activity) this.a, null, null, null, this.f4561b, null, this.f4567h, this.r, this.f4569j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                c.a.p0.a.c2.b.f.a.f(bVar2);
                this.l = null;
            }
            y(this.a, this.f4561b);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            J(false);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.a;
                if (context instanceof Activity) {
                    f.o((Activity) context, null, null, null, this.f4561b, null, this.f4567h, ToastLocation.BOTTOM, this.f4569j, this.m);
                    return;
                }
            }
            y(this.a, this.f4561b);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.a == null) {
                if (u) {
                    throw new IllegalArgumentException("UniversalToast mContext is null!!!");
                }
                return false;
            } else if (this.f4561b == null) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this : (e) invokeI.objValue;
    }

    public e i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this : (e) invokeI.objValue;
    }

    @Deprecated
    public e j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f4570k = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e k(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
            this.f4563d = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.f4567h = Math.max(i2, 1);
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e m(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            Context context = this.a;
            if (context != null && context.getResources() != null) {
                this.f4564e = this.a.getResources().getDrawable(i2);
            }
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e n(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            this.f4564e = drawable;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e o(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            this.f4566g = uri;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e p(ToastLocation toastLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, toastLocation)) == null) {
            this.r = toastLocation;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e q(@NonNull int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.f4568i = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e r(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
            this.f4561b = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e s(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public e t(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, charSequence)) == null) {
            this.f4562c = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e u(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, cVar)) == null) {
            this.f4569j = cVar;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.a != null && (!TextUtils.isEmpty(this.f4561b) || !TextUtils.isEmpty(this.f4562c))) {
                a();
                if (this.a instanceof Activity) {
                    int i2 = a.a[this.s.ordinal()];
                    if (i2 == 2) {
                        if (TextUtils.isEmpty(this.f4561b)) {
                            return;
                        }
                        f.o((Activity) this.a, this.f4566g, this.f4565f, this.n, this.f4561b, this.q, this.f4567h, this.r, this.f4569j, this.m);
                        return;
                    } else if (i2 == 3) {
                        if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.f4561b)) {
                            f.o((Activity) this.a, this.f4566g, this.f4565f, this.n, this.f4561b, this.q, this.f4567h, this.r, this.f4569j, this.m);
                            return;
                        } else if (TextUtils.isEmpty(this.f4562c)) {
                            return;
                        } else {
                            f.p((Activity) this.a, this.f4566g, this.f4565f, this.n, this.f4562c, this.p, this.q, this.o, this.f4567h, this.t, this.f4569j);
                            return;
                        }
                    } else if (i2 != 4) {
                        if (TextUtils.isEmpty(this.f4561b)) {
                            return;
                        }
                        f.o((Activity) this.a, null, null, null, this.f4561b, null, this.f4567h, this.r, null, this.m);
                        return;
                    } else if (TextUtils.isEmpty(this.f4561b)) {
                        return;
                    } else {
                        f.n((Activity) this.a, this.f4561b, this.f4564e, this.n, this.f4567h, this.m);
                        return;
                    }
                } else if (a.a[this.s.ordinal()] != 4) {
                    y(this.a, TextUtils.isEmpty(this.f4561b) ? this.f4562c : this.f4561b);
                    return;
                } else if (TextUtils.isEmpty(this.f4561b)) {
                    return;
                } else {
                    c.a.p0.a.c2.b.f.a.j(this.a, this.f4561b, this.f4564e, this.n, this.f4567h, this.m);
                    return;
                }
            }
            d.h("has no mToastText or mTitleText");
        }
    }

    @Deprecated
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            x(false, false);
        }
    }

    @Deprecated
    public void x(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && b()) {
            a();
            if (!z && (this.a instanceof Activity)) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (TextUtils.isEmpty(this.f4563d)) {
                    this.f4563d = c.a.p0.a.c1.a.c().getResources().getText(h.aiapps_check_action_text);
                }
                f.o((Activity) this.a, null, null, null, this.f4561b, this.f4563d, this.f4567h, ToastLocation.BOTTOM, this.f4569j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                c.a.p0.a.c2.b.f.a.f(bVar2);
                this.l = null;
            }
            y(this.a, this.f4561b);
        }
    }

    public final void y(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, context, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        c.a.p0.a.c2.b.f.a.k(context, null, null, null, charSequence, null, this.f4567h, this.r, null, this.m);
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            A(false);
        }
    }
}
