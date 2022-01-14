package c.a.r0.a.y0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.k;
import c.a.r0.a.y0.d;
import c.a.r0.a.y0.e.e.b;
import c.a.r0.a.z2.n0;
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
public class c implements c.a.r0.a.y0.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f9593j;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f9594b;

    /* renamed from: c  reason: collision with root package name */
    public String f9595c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.h0.g.f f9596d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f9597e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.y0.e.e.b f9598f;

    /* renamed from: g  reason: collision with root package name */
    public f f9599g;

    /* renamed from: h  reason: collision with root package name */
    public int f9600h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f9601i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9603f;

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
            this.f9603f = cVar;
            this.f9602e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9603f.E0(this.f9602e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9604e;

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
            this.f9604e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9604e.w0();
            }
        }
    }

    /* renamed from: c.a.r0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0619c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9605e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f9606f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f9607g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f9608h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f9609i;

        public RunnableC0619c(c cVar, int i2, int i3, int i4, int i5) {
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
            this.f9609i = cVar;
            this.f9605e = i2;
            this.f9606f = i3;
            this.f9607g = i4;
            this.f9608h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9609i.C0(this.f9605e, this.f9606f, this.f9607g, this.f9608h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9610e;

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
            this.f9610e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9610e.B0();
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

        @Override // c.a.r0.a.y0.e.e.b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e("onKeyboardHide", null);
                if (this.a.f9599g != null) {
                    this.a.f9599g.a();
                }
            }
        }

        @Override // c.a.r0.a.y0.e.e.b.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                e("onKeyboardShow", "height: " + i2);
                if (this.a.f9599g != null) {
                    this.a.f9599g.b(i2);
                }
            }
        }

        @Override // c.a.r0.a.y0.e.e.b.e
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                e("onInput", "inputText: " + str);
                if (this.a.f9599g != null) {
                    this.a.f9599g.c(str);
                }
            }
        }

        @Override // c.a.r0.a.y0.e.e.b.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                e("onDeletePressed", null);
                if (this.a.f9599g != null) {
                    this.a.f9599g.d();
                }
            }
        }

        public final void e(String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && c.f9593j) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-747332031, "Lc/a/r0/a/y0/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-747332031, "Lc/a/r0/a/y0/e/c;");
                return;
            }
        }
        f9593j = k.a;
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
        this.f9601i = new e(this);
        if (invoker != null) {
            this.f9595c = (String) invoker.get("id");
        }
        this.a = c.a.r0.a.c1.a.c();
        this.f9594b = str;
        this.f9597e = new Handler(this.a.getMainLooper());
        this.f9596d = u0();
    }

    @Override // c.a.r0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.r0.a.d2.e.L() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public void A0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f9597e.post(new a(this, i2));
        }
    }

    public final void B0() {
        c.a.r0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fVar = this.f9596d) == null || this.f9600h == 0) {
            return;
        }
        this.f9600h = 0;
        if (fVar.r3().getScrollY() > 0) {
            this.f9596d.r3().setScrollY(0);
        }
    }

    public final void C0(int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || this.f9596d == null) {
            return;
        }
        c.a.r0.a.p.e.c i7 = c.a.r0.a.g1.f.U().i();
        if (this.f9600h == i4 || i7 == null) {
            return;
        }
        this.f9600h = i4;
        int height = ((this.f9596d.r3().getHeight() - i2) - i3) + i7.getWebViewScrollY() + n0.k(this.a);
        if (i5 > height) {
            i5 = height;
        }
        int i8 = height - i4;
        int scrollY = this.f9596d.r3().getScrollY();
        if (i8 < 0) {
            i6 = i5 - i8;
        } else {
            if (i5 > i8) {
                scrollY = i5 - i8;
            }
            i6 = scrollY;
        }
        this.f9596d.r3().setScrollY(i6);
    }

    public void D0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f9599g = fVar;
        }
    }

    public final void E0(int i2) {
        Activity v0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (v0 = v0()) == null) {
            return;
        }
        c.a.r0.a.y0.e.e.b bVar = new c.a.r0.a.y0.e.e.b(v0, i2, this.f9601i);
        this.f9598f = bVar;
        bVar.e();
    }

    @Override // c.a.r0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9594b : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.y0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f9595c : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Nullable
    public final c.a.r0.a.h0.g.f u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            g V = c.a.r0.a.g1.f.U().V();
            if (V == null) {
                return null;
            }
            int k = V.k();
            for (int i2 = 0; i2 < k; i2++) {
                c.a.r0.a.h0.g.d j2 = V.j(i2);
                if (j2 instanceof c.a.r0.a.h0.g.f) {
                    c.a.r0.a.h0.g.f fVar = (c.a.r0.a.h0.g.f) j2;
                    if (TextUtils.equals(fVar.n3(), this.f9594b)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (c.a.r0.a.h0.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            if (L == null) {
                return null;
            }
            return L.getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public final void w0() {
        c.a.r0.a.y0.e.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f9598f) == null) {
            return;
        }
        bVar.dismiss();
        this.f9598f = null;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f9597e.post(new b(this));
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f9597e.post(new d(this));
        }
    }

    public void z0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i2, i3, i4, i5) == null) {
            this.f9597e.post(new RunnableC0619c(this, i2, i3, i4, i5));
        }
    }
}
