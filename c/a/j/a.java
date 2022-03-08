package c.a.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.j.h.b.h.a f3575b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.j.h.b.f.b f3576c;

    /* renamed from: d  reason: collision with root package name */
    public String f3577d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.j.h.b.i.b f3578e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.j.h.b.i.a f3579f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<Context> f3580g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.h.b.d.b f3581h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f3582i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.j.h.b.e.a f3583j;
    public c.a.j.h.b.g.a k;

    /* renamed from: c.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0153a implements c.a.j.h.b.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0153a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.j.h.b.h.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3584b;

        /* renamed from: c  reason: collision with root package name */
        public String f3585c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.j.h.b.i.b f3586d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.j.h.b.i.a f3587e;

        /* renamed from: f  reason: collision with root package name */
        public c.a.j.h.b.h.a f3588f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.j.h.b.d.b f3589g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.j.h.b.f.b f3590h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.j.h.b.e.a f3591i;

        /* renamed from: j  reason: collision with root package name */
        public c.a.j.h.b.g.a f3592j;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3584b = false;
            this.f3585c = "";
            this.f3586d = null;
            this.f3587e = null;
            this.f3588f = null;
            this.f3589g = null;
            this.f3590h = null;
            this.f3591i = null;
            this.f3592j = null;
            this.a = context;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = new a(this.a);
                aVar.a = this.f3584b;
                if (TextUtils.isEmpty(this.f3585c)) {
                    aVar.f3577d = this.f3585c;
                }
                c.a.j.h.b.h.a aVar2 = this.f3588f;
                if (aVar2 != null) {
                    aVar.f3575b = aVar2;
                }
                c.a.j.h.b.i.b bVar = this.f3586d;
                if (bVar != null) {
                    aVar.f3578e = bVar;
                }
                c.a.j.h.b.i.a aVar3 = this.f3587e;
                if (aVar3 != null) {
                    aVar.f3579f = aVar3;
                }
                c.a.j.h.b.e.a aVar4 = this.f3591i;
                if (aVar4 != null) {
                    aVar.f3583j = aVar4;
                }
                c.a.j.h.b.d.b bVar2 = this.f3589g;
                if (bVar2 != null) {
                    aVar.f3581h = bVar2;
                }
                c.a.j.h.b.f.b bVar3 = this.f3590h;
                if (bVar3 != null) {
                    aVar.f3576c = bVar3;
                }
                c.a.j.h.b.g.a aVar5 = this.f3592j;
                if (aVar5 != null) {
                    aVar.k = aVar5;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public b b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f3584b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b c(c.a.j.h.b.i.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f3587e = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(c.a.j.h.b.e.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f3591i = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(c.a.j.h.b.f.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.f3590h = bVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(c.a.j.h.b.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                this.f3588f = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b g(c.a.j.h.b.i.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                this.f3586d = bVar;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f3575b = new C0153a(this);
        this.f3576c = new c.a.j.j.f.a();
        this.f3577d = "";
        this.f3581h = c.a.j.h.b.d.b.c();
        this.f3583j = new c.a.j.j.c.a();
        this.k = new c.a.j.j.h.b();
        this.f3582i = context.getApplicationContext();
        this.f3580g = new WeakReference<>(context);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3582i : (Context) invokeV.objValue;
    }

    public c.a.j.h.b.g.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (c.a.j.h.b.g.a) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3577d : (String) invokeV.objValue;
    }

    public c.a.j.h.b.i.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3579f : (c.a.j.h.b.i.a) invokeV.objValue;
    }

    public c.a.j.h.b.e.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3583j : (c.a.j.h.b.e.a) invokeV.objValue;
    }

    public c.a.j.h.b.f.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3576c : (c.a.j.h.b.f.b) invokeV.objValue;
    }

    public WeakReference<Context> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3580g : (WeakReference) invokeV.objValue;
    }

    public c.a.j.h.b.h.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3575b : (c.a.j.h.b.h.a) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "1.7.14" : (String) invokeV.objValue;
    }

    public c.a.j.h.b.d.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3581h : (c.a.j.h.b.d.b) invokeV.objValue;
    }

    public c.a.j.h.b.i.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3578e : (c.a.j.h.b.i.b) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
