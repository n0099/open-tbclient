package c.a.p0.v.d.g.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.b1.r0;
import c.a.o0.s.q.c2;
import c.a.p0.v.d.b.d.b;
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
/* loaded from: classes3.dex */
public class d extends c.a.p0.v.d.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.v.d.b.d.b f25027f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25028g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.v.d.b.b.c f25029h;

    /* renamed from: i  reason: collision with root package name */
    public AlaInfoData f25030i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f25031j;
    public Runnable k;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25032a;

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
            this.f25032a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f25032a.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25033a;

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
            this.f25033a = dVar;
        }

        @Override // c.a.p0.v.d.b.d.b.f
        public void a(c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) || c2Var == null) {
                return;
            }
            c.a.p0.v.d.e.a.c().f("c12909", this.f25033a.f25020d.f24974e, 1, c2Var.f0(), c2Var.T(), c2Var.Z(), this.f25033a.f25030i);
        }

        @Override // c.a.p0.v.d.b.d.b.f
        public void b(c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) || c2Var == null) {
                return;
            }
            c.a.p0.v.d.e.a.c().f("c12910", this.f25033a.f25020d.f24974e, 1, c2Var.f0(), c2Var.T(), c2Var.Z(), this.f25033a.f25030i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25034e;

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
            this.f25034e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25034e.r();
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
        this.f25028g = false;
        this.f25031j = new a(this, 2000994);
        this.k = new c(this);
    }

    @Override // c.a.p0.v.d.g.f.a
    public void b(c.a.p0.v.d.g.c.a aVar) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            q();
            c.a.p0.v.d.b.d.b bVar = this.f25027f;
            if (bVar != null) {
                bVar.n(this.f25029h);
            }
            c.a.p0.v.d.b.b.c cVar = this.f25029h;
            if (cVar == null || (c2Var = cVar.f24682a) == null) {
                return;
            }
            this.f25030i = c2Var.j1();
            c.a.p0.v.d.e.a.c().f("c12908", this.f25020d.f24974e, 1, this.f25029h.f24682a.f0(), this.f25029h.f24682a.T(), this.f25029h.f24682a.Z(), this.f25030i);
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25027f.j() : (View) invokeV.objValue;
    }

    @Override // c.a.p0.v.d.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25027f = new c.a.p0.v.d.b.d.b(this.f25019c, true);
            MessageManager.getInstance().registerListener(this.f25031j);
            this.f25027f.w(new b(this));
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public boolean f(c.a.p0.v.d.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 1 != aVar.f24973d || ListUtils.isEmpty(aVar.f24972c) || aVar.f24972c.get(0) == null || aVar.f24972c.get(0).j1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.p0.v.d.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f25028g = z;
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            c.a.p0.v.d.b.d.b bVar = this.f25027f;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f25027f.o();
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f25031j);
            c.a.e.e.m.e.a().removeCallbacks(this.k);
            c.a.p0.v.d.b.d.b bVar = this.f25027f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f25028g) {
            return;
        }
        if (r0.a(1)) {
            c.a.e.e.m.e.a().removeCallbacks(this.k);
            c.a.e.e.m.e.a().postDelayed(this.k, 1000L);
            return;
        }
        c.a.p0.v.d.b.d.b bVar = this.f25027f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // c.a.p0.v.d.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.v.d.b.d.b bVar = this.f25027f;
            if (bVar != null) {
                bVar.r();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.p0.v.d.b.b.c cVar = new c.a.p0.v.d.b.b.c();
            this.f25029h = cVar;
            cVar.f24682a = this.f25020d.f24972c.get(0);
        }
    }

    public final void r() {
        c.a.p0.v.d.b.b.c cVar;
        c2 c2Var;
        c.a.p0.v.d.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.f25029h) == null || (c2Var = cVar.f24682a) == null || c2Var.j1() == null || (bVar = this.f25027f) == null) {
            return;
        }
        bVar.x(this.f25029h.f24682a.j1().hls_url);
    }
}
