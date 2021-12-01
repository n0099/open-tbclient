package c.a.p0.a.y0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.k;
import c.a.p0.a.y0.d;
import c.a.p0.a.y0.e.e.b;
import c.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes.dex */
public class c implements c.a.p0.a.y0.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f8763j;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f8764b;

    /* renamed from: c  reason: collision with root package name */
    public String f8765c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.h0.g.f f8766d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f8767e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.y0.e.e.b f8768f;

    /* renamed from: g  reason: collision with root package name */
    public f f8769g;

    /* renamed from: h  reason: collision with root package name */
    public int f8770h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f8771i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8772e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8773f;

        public a(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8773f = cVar;
            this.f8772e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8773f.E0(this.f8772e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8774e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8774e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8774e.w0();
            }
        }
    }

    /* renamed from: c.a.p0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0526c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8775e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8776f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8777g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8778h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f8779i;

        public RunnableC0526c(c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8779i = cVar;
            this.f8775e = i2;
            this.f8776f = i3;
            this.f8777g = i4;
            this.f8778h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8779i.C0(this.f8775e, this.f8776f, this.f8777g, this.f8778h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8780e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8780e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8780e.B0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e("onKeyboardHide", null);
                if (this.a.f8769g != null) {
                    this.a.f8769g.a();
                }
            }
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                e("onKeyboardShow", "height: " + i2);
                if (this.a.f8769g != null) {
                    this.a.f8769g.b(i2);
                }
            }
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                e("onInput", "inputText: " + str);
                if (this.a.f8769g != null) {
                    this.a.f8769g.c(str);
                }
            }
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                e("onDeletePressed", null);
                if (this.a.f8769g != null) {
                    this.a.f8769g.d();
                }
            }
        }

        public final void e(String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && c.f8763j) {
                String str3 = ("【" + this.a.k0() + "-" + this.a.hashCode() + "】\t") + "【" + str + "】";
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                String str4 = str3 + str2;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1005497469, "Lc/a/p0/a/y0/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1005497469, "Lc/a/p0/a/y0/e/c;");
                return;
            }
        }
        f8763j = k.a;
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8771i = new e(this);
        if (invoker != null) {
            this.f8765c = (String) invoker.get("id");
        }
        this.a = c.a.p0.a.c1.a.c();
        this.f8764b = str;
        this.f8767e = new Handler(this.a.getMainLooper());
        this.f8766d = u0();
    }

    @Override // c.a.p0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.p0.a.d2.e.L() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public void A0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f8767e.post(new a(this, i2));
        }
    }

    public final void B0() {
        c.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fVar = this.f8766d) == null || this.f8770h == 0) {
            return;
        }
        this.f8770h = 0;
        if (fVar.y3().getScrollY() > 0) {
            this.f8766d.y3().setScrollY(0);
        }
    }

    public final void C0(int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || this.f8766d == null) {
            return;
        }
        c.a.p0.a.p.e.c h2 = c.a.p0.a.g1.f.U().h();
        if (this.f8770h == i4 || h2 == null) {
            return;
        }
        this.f8770h = i4;
        int height = ((this.f8766d.y3().getHeight() - i2) - i3) + h2.getWebViewScrollY() + n0.k(this.a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f8766d.y3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f8766d.y3().setScrollY(i6);
    }

    public void D0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f8769g = fVar;
        }
    }

    public final void E0(int i2) {
        Activity v0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (v0 = v0()) == null) {
            return;
        }
        c.a.p0.a.y0.e.e.b bVar = new c.a.p0.a.y0.e.e.b(v0, i2, this.f8771i);
        this.f8768f = bVar;
        bVar.e();
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8764b : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f8765c : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Nullable
    public final c.a.p0.a.h0.g.f u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            g V = c.a.p0.a.g1.f.U().V();
            if (V == null) {
                return null;
            }
            int k2 = V.k();
            for (int i2 = 0; i2 < k2; i2++) {
                c.a.p0.a.h0.g.d j2 = V.j(i2);
                if (j2 instanceof c.a.p0.a.h0.g.f) {
                    c.a.p0.a.h0.g.f fVar = (c.a.p0.a.h0.g.f) j2;
                    if (TextUtils.equals(fVar.u3(), this.f8764b)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (c.a.p0.a.h0.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
            if (L == null) {
                return null;
            }
            return L.getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public final void w0() {
        c.a.p0.a.y0.e.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f8768f) == null) {
            return;
        }
        bVar.dismiss();
        this.f8768f = null;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f8767e.post(new b(this));
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f8767e.post(new d(this));
        }
    }

    public void z0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i2, i3, i4, i5) == null) {
            this.f8767e.post(new RunnableC0526c(this, i2, i3, i4, i5));
        }
    }
}
