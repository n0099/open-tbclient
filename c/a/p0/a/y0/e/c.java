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
import c.a.p0.a.v2.n0;
import c.a.p0.a.y0.d;
import c.a.p0.a.y0.e.e.b;
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
    public static final boolean f9736j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f9737a;

    /* renamed from: b  reason: collision with root package name */
    public String f9738b;

    /* renamed from: c  reason: collision with root package name */
    public String f9739c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.h0.g.f f9740d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f9741e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.y0.e.e.b f9742f;

    /* renamed from: g  reason: collision with root package name */
    public f f9743g;

    /* renamed from: h  reason: collision with root package name */
    public int f9744h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f9745i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9747f;

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
            this.f9747f = cVar;
            this.f9746e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9747f.D0(this.f9746e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9748e;

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
            this.f9748e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9748e.v0();
            }
        }
    }

    /* renamed from: c.a.p0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0460c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f9750f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f9751g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f9752h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f9753i;

        public RunnableC0460c(c cVar, int i2, int i3, int i4, int i5) {
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
            this.f9753i = cVar;
            this.f9749e = i2;
            this.f9750f = i3;
            this.f9751g = i4;
            this.f9752h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9753i.B0(this.f9749e, this.f9750f, this.f9751g, this.f9752h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9754e;

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
            this.f9754e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9754e.A0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9755a;

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
            this.f9755a = cVar;
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e("onKeyboardHide", null);
                if (this.f9755a.f9743g != null) {
                    this.f9755a.f9743g.a();
                }
            }
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                e("onKeyboardShow", "height: " + i2);
                if (this.f9755a.f9743g != null) {
                    this.f9755a.f9743g.b(i2);
                }
            }
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                e("onInput", "inputText: " + str);
                if (this.f9755a.f9743g != null) {
                    this.f9755a.f9743g.c(str);
                }
            }
        }

        @Override // c.a.p0.a.y0.e.e.b.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                e("onDeletePressed", null);
                if (this.f9755a.f9743g != null) {
                    this.f9755a.f9743g.d();
                }
            }
        }

        public final void e(String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && c.f9736j) {
                String str3 = ("【" + this.f9755a.j0() + "-" + this.f9755a.hashCode() + "】\t") + "【" + str + "】";
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
        f9736j = k.f7085a;
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
        this.f9745i = new e(this);
        if (invoker != null) {
            this.f9739c = (String) invoker.get("id");
        }
        this.f9737a = c.a.p0.a.c1.a.b();
        this.f9738b = str;
        this.f9741e = new Handler(this.f9737a.getMainLooper());
        this.f9740d = t0();
    }

    @Override // c.a.p0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.p0.a.a2.e.i() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public final void A0() {
        c.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fVar = this.f9740d) == null || this.f9744h == 0) {
            return;
        }
        this.f9744h = 0;
        if (fVar.i3().getScrollY() > 0) {
            this.f9740d.i3().setScrollY(0);
        }
    }

    public final void B0(int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) || this.f9740d == null) {
            return;
        }
        c.a.p0.a.p.e.c h2 = c.a.p0.a.g1.f.V().h();
        if (this.f9744h == i4 || h2 == null) {
            return;
        }
        this.f9744h = i4;
        int height = ((this.f9740d.i3().getHeight() - i2) - i3) + h2.getWebViewScrollY() + n0.k(this.f9737a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f9740d.i3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f9740d.i3().setScrollY(i6);
    }

    public void C0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f9743g = fVar;
        }
    }

    public final void D0(int i2) {
        Activity u0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (u0 = u0()) == null) {
            return;
        }
        c.a.p0.a.y0.e.e.b bVar = new c.a.p0.a.y0.e.e.b(u0, i2, this.f9745i);
        this.f9742f = bVar;
        bVar.e();
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9738b : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9739c : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Nullable
    public final c.a.p0.a.h0.g.f t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            g W = c.a.p0.a.g1.f.V().W();
            if (W == null) {
                return null;
            }
            int k = W.k();
            for (int i2 = 0; i2 < k; i2++) {
                c.a.p0.a.h0.g.d j2 = W.j(i2);
                if (j2 instanceof c.a.p0.a.h0.g.f) {
                    c.a.p0.a.h0.g.f fVar = (c.a.p0.a.h0.g.f) j2;
                    if (TextUtils.equals(fVar.e3(), this.f9738b)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (c.a.p0.a.h0.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
            if (i2 == null) {
                return null;
            }
            return i2.k();
        }
        return (Activity) invokeV.objValue;
    }

    public final void v0() {
        c.a.p0.a.y0.e.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f9742f) == null) {
            return;
        }
        bVar.dismiss();
        this.f9742f = null;
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f9741e.post(new b(this));
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f9741e.post(new d(this));
        }
    }

    public void y0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f9741e.post(new RunnableC0460c(this, i2, i3, i4, i5));
        }
    }

    public void z0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f9741e.post(new a(this, i2));
        }
    }
}
