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
    public c.a.j.h.b.h.a f3857b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.j.h.b.f.b f3858c;

    /* renamed from: d  reason: collision with root package name */
    public String f3859d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.j.h.b.i.b f3860e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.j.h.b.i.a f3861f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<Context> f3862g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.h.b.d.b f3863h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f3864i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.j.h.b.e.a f3865j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.j.h.b.g.a f3866k;

    /* renamed from: c.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0151a implements c.a.j.h.b.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0151a(a aVar) {
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
        public boolean f3867b;

        /* renamed from: c  reason: collision with root package name */
        public String f3868c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.j.h.b.i.b f3869d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.j.h.b.i.a f3870e;

        /* renamed from: f  reason: collision with root package name */
        public c.a.j.h.b.h.a f3871f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.j.h.b.d.b f3872g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.j.h.b.f.b f3873h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.j.h.b.e.a f3874i;

        /* renamed from: j  reason: collision with root package name */
        public c.a.j.h.b.g.a f3875j;

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
            this.f3867b = false;
            this.f3868c = "";
            this.f3869d = null;
            this.f3870e = null;
            this.f3871f = null;
            this.f3872g = null;
            this.f3873h = null;
            this.f3874i = null;
            this.f3875j = null;
            this.a = context;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = new a(this.a);
                aVar.a = this.f3867b;
                if (TextUtils.isEmpty(this.f3868c)) {
                    aVar.f3859d = this.f3868c;
                }
                c.a.j.h.b.h.a aVar2 = this.f3871f;
                if (aVar2 != null) {
                    aVar.f3857b = aVar2;
                }
                c.a.j.h.b.i.b bVar = this.f3869d;
                if (bVar != null) {
                    aVar.f3860e = bVar;
                }
                c.a.j.h.b.i.a aVar3 = this.f3870e;
                if (aVar3 != null) {
                    aVar.f3861f = aVar3;
                }
                c.a.j.h.b.e.a aVar4 = this.f3874i;
                if (aVar4 != null) {
                    aVar.f3865j = aVar4;
                }
                c.a.j.h.b.d.b bVar2 = this.f3872g;
                if (bVar2 != null) {
                    aVar.f3863h = bVar2;
                }
                c.a.j.h.b.f.b bVar3 = this.f3873h;
                if (bVar3 != null) {
                    aVar.f3858c = bVar3;
                }
                c.a.j.h.b.g.a aVar5 = this.f3875j;
                if (aVar5 != null) {
                    aVar.f3866k = aVar5;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public b b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f3867b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b c(c.a.j.h.b.i.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f3870e = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(c.a.j.h.b.e.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f3874i = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(c.a.j.h.b.f.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.f3873h = bVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(c.a.j.h.b.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                this.f3871f = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b g(c.a.j.h.b.i.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                this.f3869d = bVar;
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
        this.f3857b = new C0151a(this);
        this.f3858c = new c.a.j.j.f.a();
        this.f3859d = "";
        this.f3863h = c.a.j.h.b.d.b.c();
        this.f3865j = new c.a.j.j.c.a();
        this.f3866k = new c.a.j.j.h.b();
        this.f3864i = context.getApplicationContext();
        this.f3862g = new WeakReference<>(context);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3864i : (Context) invokeV.objValue;
    }

    public c.a.j.h.b.g.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3866k : (c.a.j.h.b.g.a) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3859d : (String) invokeV.objValue;
    }

    public c.a.j.h.b.i.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3861f : (c.a.j.h.b.i.a) invokeV.objValue;
    }

    public c.a.j.h.b.e.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3865j : (c.a.j.h.b.e.a) invokeV.objValue;
    }

    public c.a.j.h.b.f.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3858c : (c.a.j.h.b.f.b) invokeV.objValue;
    }

    public WeakReference<Context> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3862g : (WeakReference) invokeV.objValue;
    }

    public c.a.j.h.b.h.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3857b : (c.a.j.h.b.h.a) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "1.7.14" : (String) invokeV.objValue;
    }

    public c.a.j.h.b.d.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3863h : (c.a.j.h.b.d.b) invokeV.objValue;
    }

    public c.a.j.h.b.i.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3860e : (c.a.j.h.b.i.b) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
