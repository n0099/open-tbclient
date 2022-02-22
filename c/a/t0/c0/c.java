package c.a.t0.c0;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f12664g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.f.k.a<String, c.a.d.o.d.a> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.f.k.a<String, c.a.d.o.d.a> f12665b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.f.k.a<String, Bitmap> f12666c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d.f.k.a<String, c.a.d.o.d.a> f12667d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.f.k.b<c.a.t0.f1.i.a.a> f12668e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.f1.i.c.b f12669f;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.f.k.a<String, c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.a
        /* renamed from: o */
        public void b(boolean z, String str, c.a.d.o.d.a aVar, c.a.d.o.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, aVar, aVar2}) == null) || aVar == null) {
                return;
            }
            aVar.x();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.d.f.k.a<String, c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.a
        /* renamed from: o */
        public void b(boolean z, String str, c.a.d.o.d.a aVar, c.a.d.o.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, aVar, aVar2}) == null) || aVar == null) {
                return;
            }
            BdLog.isDebugMode();
            aVar.x();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.a
        /* renamed from: p */
        public int m(String str, c.a.d.o.d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
                if (aVar != null) {
                    return aVar.B();
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* renamed from: c.a.t0.c0.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0848c extends c.a.d.f.k.a<String, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0848c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.a
        /* renamed from: o */
        public void b(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bitmap, bitmap2}) == null) || bitmap == null) {
                return;
            }
            bitmap.recycle();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(971689261, "Lc/a/t0/c0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(971689261, "Lc/a/t0/c0/c;");
                return;
            }
        }
        f12664g = new c();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f12665b = null;
        this.f12666c = null;
        this.f12667d = null;
        this.a = new a(this, 0);
        this.f12665b = new b(this, 0);
        this.f12666c = new C0848c(this, 0);
        this.f12667d = new c.a.d.f.k.a<>(Integer.MAX_VALUE);
    }

    public static c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f12664g : (c) invokeV.objValue;
    }

    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.f12666c.h(str, bitmap);
    }

    public void b(String str, c.a.d.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            c(str, aVar, false);
        }
    }

    public void c(String str, c.a.d.o.d.a aVar, boolean z) {
        c.a.d.f.k.a<String, c.a.d.o.d.a> aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, aVar, z) == null) || aVar == null || (aVar2 = this.a) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void d(String str, c.a.d.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            e(str, aVar, false);
        }
    }

    public void e(String str, c.a.d.o.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, str, aVar, z) == null) || aVar == null || this.f12665b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.f12665b.h(str, aVar);
    }

    public void f(String str, c.a.d.o.d.a aVar) {
        c.a.d.f.k.a<String, c.a.d.o.d.a> aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, aVar) == null) || aVar == null || (aVar2 = this.f12667d) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a.i(str);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f12665b.i(str);
        }
    }

    public boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f12665b.e(i2) : invokeI.booleanValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.f12666c.f(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public c.a.d.o.d.a l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.a.f(str) : (c.a.d.o.d.a) invokeL.objValue;
    }

    public c.a.d.o.d.a m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this.f12665b.f(str) : (c.a.d.o.d.a) invokeL.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f12665b.g() : invokeV.intValue;
    }

    public c.a.d.o.d.a o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.f12667d.f(str);
        }
        return (c.a.d.o.d.a) invokeL.objValue;
    }

    public c.a.d.f.k.b<c.a.t0.f1.i.a.a> p(int i2) {
        InterceptResult invokeI;
        c.a.t0.f1.i.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (this.f12668e != null && (bVar = this.f12669f) != null) {
                if (bVar.g() == i2) {
                    return this.f12668e;
                }
                this.f12669f.j(i2);
                this.f12668e.c();
            }
            if (this.f12669f == null) {
                this.f12669f = new c.a.t0.f1.i.c.b(i2);
            }
            if (this.f12668e == null) {
                this.f12668e = new c.a.d.f.k.b<>(this.f12669f, 6, 0);
            }
            return this.f12668e;
        }
        return (c.a.d.f.k.b) invokeI.objValue;
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            t(i2);
            u(i3);
            s(60);
        }
    }

    public void r() {
        c.a.d.f.k.b<c.a.t0.f1.i.a.a> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bVar = this.f12668e) == null) {
            return;
        }
        bVar.g(0);
        this.f12668e.f(0);
        this.f12668e.c();
        this.f12668e = null;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f12666c.k(i2);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.a.k(i2);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "pic:" + this.f12665b.toString() + "  photo:" + this.a.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f12665b.k(i2);
        }
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.f12665b.l() + "/" + this.f12665b.g() + "/" + this.f12665b.d() + "_" + this.a.l() + "/" + this.a.g() + "/" + this.a.d();
        }
        return (String) invokeV.objValue;
    }
}
