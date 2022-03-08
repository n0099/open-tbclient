package c.a.r0.a0.f.g.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.t0;
import c.a.q0.r.r.e2;
import c.a.r0.a0.f.b.d.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends c.a.r0.a0.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a0.f.b.d.b f14476f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14477g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.a0.f.b.b.c f14478h;

    /* renamed from: i  reason: collision with root package name */
    public AlaInfoData f14479i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f14480j;
    public Runnable k;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.r0.a0.f.b.d.b.e
        public void a(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) || e2Var == null) {
                return;
            }
            c.a.r0.a0.f.e.a.c().f("c12909", this.a.f14469d.f14433e, 1, e2Var.h0(), e2Var.U(), e2Var.b0(), this.a.f14479i);
        }

        @Override // c.a.r0.a0.f.b.d.b.e
        public void b(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || e2Var == null) {
                return;
            }
            c.a.r0.a0.f.e.a.c().f("c12910", this.a.f14469d.f14433e, 1, e2Var.h0(), e2Var.U(), e2Var.b0(), this.a.f14479i);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14481e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14481e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14481e.r();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14477g = false;
        this.f14480j = new a(this, 2000994);
        this.k = new c(this);
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void b(c.a.r0.a0.f.g.c.a aVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            q();
            c.a.r0.a0.f.b.d.b bVar = this.f14476f;
            if (bVar != null) {
                bVar.n(this.f14478h);
            }
            c.a.r0.a0.f.b.b.c cVar = this.f14478h;
            if (cVar == null || (e2Var = cVar.a) == null) {
                return;
            }
            this.f14479i = e2Var.p1();
            c.a.r0.a0.f.e.a.c().f("c12908", this.f14469d.f14433e, 1, this.f14478h.a.h0(), this.f14478h.a.U(), this.f14478h.a.b0(), this.f14479i);
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14476f.j() : (View) invokeV.objValue;
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14476f = new c.a.r0.a0.f.b.d.b(this.f14468c, true);
            MessageManager.getInstance().registerListener(this.f14480j);
            this.f14476f.w(new b(this));
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public boolean f(c.a.r0.a0.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 1 != aVar.f14432d || ListUtils.isEmpty(aVar.f14431c) || aVar.f14431c.get(0) == null || aVar.f14431c.get(0).p1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f14477g = z;
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            c.a.r0.a0.f.b.d.b bVar = this.f14476f;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f14476f.o();
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f14480j);
            c.a.d.f.m.e.a().removeCallbacks(this.k);
            c.a.r0.a0.f.b.d.b bVar = this.f14476f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f14477g) {
            return;
        }
        if (t0.a(1)) {
            c.a.d.f.m.e.a().removeCallbacks(this.k);
            c.a.d.f.m.e.a().postDelayed(this.k, 1000L);
            return;
        }
        c.a.r0.a0.f.b.d.b bVar = this.f14476f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.a0.f.b.d.b bVar = this.f14476f;
            if (bVar != null) {
                bVar.r();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.r0.a0.f.b.b.c cVar = new c.a.r0.a0.f.b.b.c();
            this.f14478h = cVar;
            cVar.a = this.f14469d.f14431c.get(0);
        }
    }

    public final void r() {
        c.a.r0.a0.f.b.b.c cVar;
        e2 e2Var;
        c.a.r0.a0.f.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.f14478h) == null || (e2Var = cVar.a) == null || e2Var.p1() == null || (bVar = this.f14476f) == null) {
            return;
        }
        bVar.x(this.f14478h.a.p1().hls_url);
    }
}
