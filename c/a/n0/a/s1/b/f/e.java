package c.a.n0.a.s1.b.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.swan.apps.res.widget.toast.ToastTemplate;
import com.baidu.tieba.R;
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
    public CharSequence f6305b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f6306c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f6307d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f6308e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f6309f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f6310g;

    /* renamed from: h  reason: collision with root package name */
    public int f6311h;
    public int i;
    public c j;
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
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1831847083, "Lc/a/n0/a/s1/b/f/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1831847083, "Lc/a/n0/a/s1/b/f/e$a;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712519944, "Lc/a/n0/a/s1/b/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712519944, "Lc/a/n0/a/s1/b/f/e;");
                return;
            }
        }
        u = c.a.n0.a.a.a;
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.a = context;
        this.f6311h = 2;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c.a.n0.a.s1.b.f.a.d();
            f.h();
        }
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? n0.t() + ((int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f07015b)) : invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.n0.a.s1.b.f.a.e() || f.k() : invokeV.booleanValue;
    }

    public static e e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? new e(context) : (e) invokeL.objValue;
    }

    public static e f(@NonNull Context context, @StringRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            e eVar = new e(context);
            eVar.f6305b = context.getText(i);
            return eVar;
        }
        return (e) invokeLI.objValue;
    }

    public static e g(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, charSequence)) == null) {
            e eVar = new e(context);
            eVar.f6305b = charSequence;
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
                    f.m((Activity) context, this.f6305b, this.f6311h, this.m);
                    return;
                }
            }
            c.a.n0.a.s1.b.f.a.i(this.a, this.f6305b, this.f6311h, this.m);
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
                    f.n((Activity) context, this.f6305b, this.f6308e, this.n, this.f6311h, this.m);
                    return;
                }
            }
            c.a.n0.a.s1.b.f.a.j(this.a, this.f6305b, this.f6308e, this.n, this.f6311h, this.m);
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
                y(this.a, this.f6306c);
            } else if (this.a instanceof Activity) {
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
                if (TextUtils.isEmpty(this.f6307d)) {
                    f.o((Activity) this.a, null, null, null, this.f6305b, null, this.f6311h, this.r, this.j, this.m);
                    return;
                }
                CharSequence charSequence = this.f6306c;
                CharSequence charSequence2 = this.f6305b;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f6305b)) {
                    charSequence = this.f6305b;
                    charSequence2 = "";
                }
                f.p((Activity) this.a, this.f6310g, null, null, charSequence, charSequence2, this.f6307d, this.o, this.f6311h, false, this.j);
            } else {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    c.a.n0.a.s1.b.f.a.f(bVar2);
                    this.l = null;
                }
                y(this.a, this.f6306c);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && b()) {
            a();
            c.a.n0.a.s1.b.f.a.h(this.a, this.f6305b, this.f6311h, false, this.i, this.m);
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
                    Log.w("UniversalToast", sb.toString());
                }
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                f.o((Activity) this.a, null, null, null, this.f6305b, null, this.f6311h, this.r, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                c.a.n0.a.s1.b.f.a.f(bVar2);
                this.l = null;
            }
            y(this.a, this.f6305b);
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
                    f.o((Activity) context, null, null, null, this.f6305b, null, this.f6311h, ToastLocation.BOTTOM, this.j, this.m);
                    return;
                }
            }
            y(this.a, this.f6305b);
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
            } else if (this.f6305b == null) {
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
    public e h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this : (e) invokeI.objValue;
    }

    public e i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this : (e) invokeI.objValue;
    }

    @Deprecated
    public e j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e k(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
            this.f6307d = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.f6311h = Math.max(i, 1);
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e m(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            Context context = this.a;
            if (context != null && context.getResources() != null) {
                this.f6308e = this.a.getResources().getDrawable(i);
            }
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e n(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            this.f6308e = drawable;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e o(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            this.f6310g = uri;
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

    public e q(@NonNull int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e r(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
            this.f6305b = charSequence;
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
            this.f6306c = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e u(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, cVar)) == null) {
            this.j = cVar;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.a != null && (!TextUtils.isEmpty(this.f6305b) || !TextUtils.isEmpty(this.f6306c))) {
                a();
                if (this.a instanceof Activity) {
                    int i = a.a[this.s.ordinal()];
                    if (i == 2) {
                        if (TextUtils.isEmpty(this.f6305b)) {
                            return;
                        }
                        f.o((Activity) this.a, this.f6310g, this.f6309f, this.n, this.f6305b, this.q, this.f6311h, this.r, this.j, this.m);
                        return;
                    } else if (i == 3) {
                        if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.f6305b)) {
                            f.o((Activity) this.a, this.f6310g, this.f6309f, this.n, this.f6305b, this.q, this.f6311h, this.r, this.j, this.m);
                            return;
                        } else if (TextUtils.isEmpty(this.f6306c)) {
                            return;
                        } else {
                            f.p((Activity) this.a, this.f6310g, this.f6309f, this.n, this.f6306c, this.p, this.q, this.o, this.f6311h, this.t, this.j);
                            return;
                        }
                    } else if (i != 4) {
                        if (TextUtils.isEmpty(this.f6305b)) {
                            return;
                        }
                        f.o((Activity) this.a, null, null, null, this.f6305b, null, this.f6311h, this.r, null, this.m);
                        return;
                    } else if (TextUtils.isEmpty(this.f6305b)) {
                        return;
                    } else {
                        f.n((Activity) this.a, this.f6305b, this.f6308e, this.n, this.f6311h, this.m);
                        return;
                    }
                } else if (a.a[this.s.ordinal()] != 4) {
                    y(this.a, TextUtils.isEmpty(this.f6305b) ? this.f6306c : this.f6305b);
                    return;
                } else if (TextUtils.isEmpty(this.f6305b)) {
                    return;
                } else {
                    c.a.n0.a.s1.b.f.a.j(this.a, this.f6305b, this.f6308e, this.n, this.f6311h, this.m);
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
                if (TextUtils.isEmpty(this.f6307d)) {
                    this.f6307d = c.a.n0.a.s0.a.c().getResources().getText(R.string.obfuscated_res_0x7f0f010b);
                }
                f.o((Activity) this.a, null, null, null, this.f6305b, this.f6307d, this.f6311h, ToastLocation.BOTTOM, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                c.a.n0.a.s1.b.f.a.f(bVar2);
                this.l = null;
            }
            y(this.a, this.f6305b);
        }
    }

    public final void y(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, context, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        c.a.n0.a.s1.b.f.a.k(context, null, null, null, charSequence, null, this.f6311h, this.r, null, this.m);
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            A(false);
        }
    }
}
