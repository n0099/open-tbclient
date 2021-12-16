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
    public c.a.j.h.b.h.a f3429b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.j.h.b.f.b f3430c;

    /* renamed from: d  reason: collision with root package name */
    public String f3431d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.j.h.b.i.b f3432e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.j.h.b.i.a f3433f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<Context> f3434g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.h.b.d.b f3435h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f3436i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.j.h.b.e.a f3437j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.j.h.b.g.a f3438k;

    /* renamed from: c.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130a implements c.a.j.h.b.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0130a(a aVar) {
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
        public boolean f3439b;

        /* renamed from: c  reason: collision with root package name */
        public String f3440c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.j.h.b.i.b f3441d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.j.h.b.i.a f3442e;

        /* renamed from: f  reason: collision with root package name */
        public c.a.j.h.b.h.a f3443f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.j.h.b.d.b f3444g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.j.h.b.f.b f3445h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.j.h.b.e.a f3446i;

        /* renamed from: j  reason: collision with root package name */
        public c.a.j.h.b.g.a f3447j;

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
            this.f3439b = false;
            this.f3440c = "";
            this.f3441d = null;
            this.f3442e = null;
            this.f3443f = null;
            this.f3444g = null;
            this.f3445h = null;
            this.f3446i = null;
            this.f3447j = null;
            this.a = context;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = new a(this.a);
                aVar.a = this.f3439b;
                if (TextUtils.isEmpty(this.f3440c)) {
                    aVar.f3431d = this.f3440c;
                }
                c.a.j.h.b.h.a aVar2 = this.f3443f;
                if (aVar2 != null) {
                    aVar.f3429b = aVar2;
                }
                c.a.j.h.b.i.b bVar = this.f3441d;
                if (bVar != null) {
                    aVar.f3432e = bVar;
                }
                c.a.j.h.b.i.a aVar3 = this.f3442e;
                if (aVar3 != null) {
                    aVar.f3433f = aVar3;
                }
                c.a.j.h.b.e.a aVar4 = this.f3446i;
                if (aVar4 != null) {
                    aVar.f3437j = aVar4;
                }
                c.a.j.h.b.d.b bVar2 = this.f3444g;
                if (bVar2 != null) {
                    aVar.f3435h = bVar2;
                }
                c.a.j.h.b.f.b bVar3 = this.f3445h;
                if (bVar3 != null) {
                    aVar.f3430c = bVar3;
                }
                c.a.j.h.b.g.a aVar5 = this.f3447j;
                if (aVar5 != null) {
                    aVar.f3438k = aVar5;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public b b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f3439b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b c(c.a.j.h.b.i.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f3442e = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(c.a.j.h.b.e.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f3446i = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(c.a.j.h.b.f.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.f3445h = bVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(c.a.j.h.b.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                this.f3443f = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b g(c.a.j.h.b.i.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                this.f3441d = bVar;
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
        this.f3429b = new C0130a(this);
        this.f3430c = new c.a.j.j.f.a();
        this.f3431d = "";
        this.f3435h = c.a.j.h.b.d.b.c();
        this.f3437j = new c.a.j.j.c.a();
        this.f3438k = new c.a.j.j.h.b();
        this.f3436i = context.getApplicationContext();
        this.f3434g = new WeakReference<>(context);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3436i : (Context) invokeV.objValue;
    }

    public c.a.j.h.b.g.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3438k : (c.a.j.h.b.g.a) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3431d : (String) invokeV.objValue;
    }

    public c.a.j.h.b.i.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3433f : (c.a.j.h.b.i.a) invokeV.objValue;
    }

    public c.a.j.h.b.e.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3437j : (c.a.j.h.b.e.a) invokeV.objValue;
    }

    public c.a.j.h.b.f.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3430c : (c.a.j.h.b.f.b) invokeV.objValue;
    }

    public WeakReference<Context> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3434g : (WeakReference) invokeV.objValue;
    }

    public c.a.j.h.b.h.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3429b : (c.a.j.h.b.h.a) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "1.7.14" : (String) invokeV.objValue;
    }

    public c.a.j.h.b.d.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3435h : (c.a.j.h.b.d.b) invokeV.objValue;
    }

    public c.a.j.h.b.i.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3432e : (c.a.j.h.b.i.b) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
