package c.a.t0.a0.f.g.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.u0;
import c.a.s0.s.q.d2;
import c.a.t0.a0.f.b.d.b;
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
/* loaded from: classes6.dex */
public class d extends c.a.t0.a0.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.a0.f.b.d.b f15008f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15009g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.a0.f.b.b.c f15010h;

    /* renamed from: i  reason: collision with root package name */
    public AlaInfoData f15011i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f15012j;

    /* renamed from: k  reason: collision with root package name */
    public Runnable f15013k;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

        @Override // c.a.t0.a0.f.b.d.b.e
        public void a(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null) {
                return;
            }
            c.a.t0.a0.f.e.a.c().f("c12909", this.a.f15001d.f14964e, 1, d2Var.g0(), d2Var.U(), d2Var.a0(), this.a.f15011i);
        }

        @Override // c.a.t0.a0.f.b.d.b.e
        public void b(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
                return;
            }
            c.a.t0.a0.f.e.a.c().f("c12910", this.a.f15001d.f14964e, 1, d2Var.g0(), d2Var.U(), d2Var.a0(), this.a.f15011i);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15014e;

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
            this.f15014e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15014e.r();
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
        this.f15009g = false;
        this.f15012j = new a(this, 2000994);
        this.f15013k = new c(this);
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void b(c.a.t0.a0.f.g.c.a aVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            q();
            c.a.t0.a0.f.b.d.b bVar = this.f15008f;
            if (bVar != null) {
                bVar.n(this.f15010h);
            }
            c.a.t0.a0.f.b.b.c cVar = this.f15010h;
            if (cVar == null || (d2Var = cVar.a) == null) {
                return;
            }
            this.f15011i = d2Var.o1();
            c.a.t0.a0.f.e.a.c().f("c12908", this.f15001d.f14964e, 1, this.f15010h.a.g0(), this.f15010h.a.U(), this.f15010h.a.a0(), this.f15011i);
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15008f.j() : (View) invokeV.objValue;
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15008f = new c.a.t0.a0.f.b.d.b(this.f15000c, true);
            MessageManager.getInstance().registerListener(this.f15012j);
            this.f15008f.w(new b(this));
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public boolean f(c.a.t0.a0.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 1 != aVar.f14963d || ListUtils.isEmpty(aVar.f14962c) || aVar.f14962c.get(0) == null || aVar.f14962c.get(0).o1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f15009g = z;
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            c.a.t0.a0.f.b.d.b bVar = this.f15008f;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f15008f.o();
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f15012j);
            c.a.d.f.m.e.a().removeCallbacks(this.f15013k);
            c.a.t0.a0.f.b.d.b bVar = this.f15008f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f15009g) {
            return;
        }
        if (u0.a(1)) {
            c.a.d.f.m.e.a().removeCallbacks(this.f15013k);
            c.a.d.f.m.e.a().postDelayed(this.f15013k, 1000L);
            return;
        }
        c.a.t0.a0.f.b.d.b bVar = this.f15008f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // c.a.t0.a0.f.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.t0.a0.f.b.d.b bVar = this.f15008f;
            if (bVar != null) {
                bVar.r();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.f15013k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.t0.a0.f.b.b.c cVar = new c.a.t0.a0.f.b.b.c();
            this.f15010h = cVar;
            cVar.a = this.f15001d.f14962c.get(0);
        }
    }

    public final void r() {
        c.a.t0.a0.f.b.b.c cVar;
        d2 d2Var;
        c.a.t0.a0.f.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.f15010h) == null || (d2Var = cVar.a) == null || d2Var.o1() == null || (bVar = this.f15008f) == null) {
            return;
        }
        bVar.x(this.f15010h.a.o1().hls_url);
    }
}
