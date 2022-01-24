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
    public c.a.j.h.b.h.a f3938b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.j.h.b.f.b f3939c;

    /* renamed from: d  reason: collision with root package name */
    public String f3940d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.j.h.b.i.b f3941e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.j.h.b.i.a f3942f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<Context> f3943g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.h.b.d.b f3944h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f3945i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.j.h.b.e.a f3946j;
    public c.a.j.h.b.g.a k;

    /* renamed from: c.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0169a implements c.a.j.h.b.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0169a(a aVar) {
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
        public boolean f3947b;

        /* renamed from: c  reason: collision with root package name */
        public String f3948c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.j.h.b.i.b f3949d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.j.h.b.i.a f3950e;

        /* renamed from: f  reason: collision with root package name */
        public c.a.j.h.b.h.a f3951f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.j.h.b.d.b f3952g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.j.h.b.f.b f3953h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.j.h.b.e.a f3954i;

        /* renamed from: j  reason: collision with root package name */
        public c.a.j.h.b.g.a f3955j;

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
            this.f3947b = false;
            this.f3948c = "";
            this.f3949d = null;
            this.f3950e = null;
            this.f3951f = null;
            this.f3952g = null;
            this.f3953h = null;
            this.f3954i = null;
            this.f3955j = null;
            this.a = context;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = new a(this.a);
                aVar.a = this.f3947b;
                if (TextUtils.isEmpty(this.f3948c)) {
                    aVar.f3940d = this.f3948c;
                }
                c.a.j.h.b.h.a aVar2 = this.f3951f;
                if (aVar2 != null) {
                    aVar.f3938b = aVar2;
                }
                c.a.j.h.b.i.b bVar = this.f3949d;
                if (bVar != null) {
                    aVar.f3941e = bVar;
                }
                c.a.j.h.b.i.a aVar3 = this.f3950e;
                if (aVar3 != null) {
                    aVar.f3942f = aVar3;
                }
                c.a.j.h.b.e.a aVar4 = this.f3954i;
                if (aVar4 != null) {
                    aVar.f3946j = aVar4;
                }
                c.a.j.h.b.d.b bVar2 = this.f3952g;
                if (bVar2 != null) {
                    aVar.f3944h = bVar2;
                }
                c.a.j.h.b.f.b bVar3 = this.f3953h;
                if (bVar3 != null) {
                    aVar.f3939c = bVar3;
                }
                c.a.j.h.b.g.a aVar5 = this.f3955j;
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
                this.f3947b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b c(c.a.j.h.b.i.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f3950e = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(c.a.j.h.b.e.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f3954i = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(c.a.j.h.b.f.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.f3953h = bVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(c.a.j.h.b.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                this.f3951f = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b g(c.a.j.h.b.i.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                this.f3949d = bVar;
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
        this.f3938b = new C0169a(this);
        this.f3939c = new c.a.j.j.f.a();
        this.f3940d = "";
        this.f3944h = c.a.j.h.b.d.b.c();
        this.f3946j = new c.a.j.j.c.a();
        this.k = new c.a.j.j.h.b();
        this.f3945i = context.getApplicationContext();
        this.f3943g = new WeakReference<>(context);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3945i : (Context) invokeV.objValue;
    }

    public c.a.j.h.b.g.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (c.a.j.h.b.g.a) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3940d : (String) invokeV.objValue;
    }

    public c.a.j.h.b.i.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3942f : (c.a.j.h.b.i.a) invokeV.objValue;
    }

    public c.a.j.h.b.e.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3946j : (c.a.j.h.b.e.a) invokeV.objValue;
    }

    public c.a.j.h.b.f.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3939c : (c.a.j.h.b.f.b) invokeV.objValue;
    }

    public WeakReference<Context> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3943g : (WeakReference) invokeV.objValue;
    }

    public c.a.j.h.b.h.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3938b : (c.a.j.h.b.h.a) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "1.7.14" : (String) invokeV.objValue;
    }

    public c.a.j.h.b.d.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3944h : (c.a.j.h.b.d.b) invokeV.objValue;
    }

    public c.a.j.h.b.i.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3941e : (c.a.j.h.b.i.b) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
