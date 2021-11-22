package b.a.r0.w.f.g.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.r0;
import b.a.q0.s.q.d2;
import b.a.r0.w.f.b.d.b;
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
/* loaded from: classes5.dex */
public class d extends b.a.r0.w.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.w.f.b.d.b f26388f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26389g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.w.f.b.b.c f26390h;

    /* renamed from: i  reason: collision with root package name */
    public AlaInfoData f26391i;
    public CustomMessageListener j;
    public Runnable k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f26392a;

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
            this.f26392a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f26392a.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f26393a;

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
            this.f26393a = dVar;
        }

        @Override // b.a.r0.w.f.b.d.b.f
        public void a(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null) {
                return;
            }
            b.a.r0.w.f.e.a.c().f("c12909", this.f26393a.f26381d.f26336e, 1, d2Var.f0(), d2Var.T(), d2Var.Z(), this.f26393a.f26391i);
        }

        @Override // b.a.r0.w.f.b.d.b.f
        public void b(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
                return;
            }
            b.a.r0.w.f.e.a.c().f("c12910", this.f26393a.f26381d.f26336e, 1, d2Var.f0(), d2Var.T(), d2Var.Z(), this.f26393a.f26391i);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26394e;

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
            this.f26394e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26394e.r();
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
        this.f26389g = false;
        this.j = new a(this, 2000994);
        this.k = new c(this);
    }

    @Override // b.a.r0.w.f.g.f.a
    public void b(b.a.r0.w.f.g.c.a aVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            q();
            b.a.r0.w.f.b.d.b bVar = this.f26388f;
            if (bVar != null) {
                bVar.n(this.f26390h);
            }
            b.a.r0.w.f.b.b.c cVar = this.f26390h;
            if (cVar == null || (d2Var = cVar.f26056a) == null) {
                return;
            }
            this.f26391i = d2Var.m1();
            b.a.r0.w.f.e.a.c().f("c12908", this.f26381d.f26336e, 1, this.f26390h.f26056a.f0(), this.f26390h.f26056a.T(), this.f26390h.f26056a.Z(), this.f26391i);
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26388f.j() : (View) invokeV.objValue;
    }

    @Override // b.a.r0.w.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26388f = new b.a.r0.w.f.b.d.b(this.f26380c, true);
            MessageManager.getInstance().registerListener(this.j);
            this.f26388f.w(new b(this));
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public boolean f(b.a.r0.w.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 1 != aVar.f26335d || ListUtils.isEmpty(aVar.f26334c) || aVar.f26334c.get(0) == null || aVar.f26334c.get(0).m1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // b.a.r0.w.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f26389g = z;
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            b.a.r0.w.f.b.d.b bVar = this.f26388f;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f26388f.o();
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            b.a.e.f.m.e.a().removeCallbacks(this.k);
            b.a.r0.w.f.b.d.b bVar = this.f26388f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f26389g) {
            return;
        }
        if (r0.a(1)) {
            b.a.e.f.m.e.a().removeCallbacks(this.k);
            b.a.e.f.m.e.a().postDelayed(this.k, 1000L);
            return;
        }
        b.a.r0.w.f.b.d.b bVar = this.f26388f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.r0.w.f.b.d.b bVar = this.f26388f;
            if (bVar != null) {
                bVar.r();
            }
            b.a.e.f.m.e.a().removeCallbacks(this.k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b.a.r0.w.f.b.b.c cVar = new b.a.r0.w.f.b.b.c();
            this.f26390h = cVar;
            cVar.f26056a = this.f26381d.f26334c.get(0);
        }
    }

    public final void r() {
        b.a.r0.w.f.b.b.c cVar;
        d2 d2Var;
        b.a.r0.w.f.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.f26390h) == null || (d2Var = cVar.f26056a) == null || d2Var.m1() == null || (bVar = this.f26388f) == null) {
            return;
        }
        bVar.x(this.f26390h.f26056a.m1().hls_url);
    }
}
