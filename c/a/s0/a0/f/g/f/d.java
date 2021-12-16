package c.a.s0.a0.f.g.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.u0;
import c.a.r0.s.r.d2;
import c.a.s0.a0.f.b.d.b;
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
public class d extends c.a.s0.a0.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.a0.f.b.d.b f14509f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14510g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.a0.f.b.b.c f14511h;

    /* renamed from: i  reason: collision with root package name */
    public AlaInfoData f14512i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f14513j;

    /* renamed from: k  reason: collision with root package name */
    public Runnable f14514k;

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
    public class b implements b.f {
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

        @Override // c.a.s0.a0.f.b.d.b.f
        public void a(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null) {
                return;
            }
            c.a.s0.a0.f.e.a.c().f("c12909", this.a.f14502d.f14465e, 1, d2Var.g0(), d2Var.U(), d2Var.a0(), this.a.f14512i);
        }

        @Override // c.a.s0.a0.f.b.d.b.f
        public void b(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
                return;
            }
            c.a.s0.a0.f.e.a.c().f("c12910", this.a.f14502d.f14465e, 1, d2Var.g0(), d2Var.U(), d2Var.a0(), this.a.f14512i);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14515e;

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
            this.f14515e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14515e.r();
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
        this.f14510g = false;
        this.f14513j = new a(this, 2000994);
        this.f14514k = new c(this);
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void b(c.a.s0.a0.f.g.c.a aVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            q();
            c.a.s0.a0.f.b.d.b bVar = this.f14509f;
            if (bVar != null) {
                bVar.n(this.f14511h);
            }
            c.a.s0.a0.f.b.b.c cVar = this.f14511h;
            if (cVar == null || (d2Var = cVar.a) == null) {
                return;
            }
            this.f14512i = d2Var.o1();
            c.a.s0.a0.f.e.a.c().f("c12908", this.f14502d.f14465e, 1, this.f14511h.a.g0(), this.f14511h.a.U(), this.f14511h.a.a0(), this.f14512i);
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14509f.j() : (View) invokeV.objValue;
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14509f = new c.a.s0.a0.f.b.d.b(this.f14501c, true);
            MessageManager.getInstance().registerListener(this.f14513j);
            this.f14509f.w(new b(this));
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public boolean f(c.a.s0.a0.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 1 != aVar.f14464d || ListUtils.isEmpty(aVar.f14463c) || aVar.f14463c.get(0) == null || aVar.f14463c.get(0).o1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f14510g = z;
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            c.a.s0.a0.f.b.d.b bVar = this.f14509f;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f14509f.o();
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f14513j);
            c.a.d.f.m.e.a().removeCallbacks(this.f14514k);
            c.a.s0.a0.f.b.d.b bVar = this.f14509f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f14510g) {
            return;
        }
        if (u0.a(1)) {
            c.a.d.f.m.e.a().removeCallbacks(this.f14514k);
            c.a.d.f.m.e.a().postDelayed(this.f14514k, 1000L);
            return;
        }
        c.a.s0.a0.f.b.d.b bVar = this.f14509f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.s0.a0.f.b.d.b bVar = this.f14509f;
            if (bVar != null) {
                bVar.r();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.f14514k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.s0.a0.f.b.b.c cVar = new c.a.s0.a0.f.b.b.c();
            this.f14511h = cVar;
            cVar.a = this.f14502d.f14463c.get(0);
        }
    }

    public final void r() {
        c.a.s0.a0.f.b.b.c cVar;
        d2 d2Var;
        c.a.s0.a0.f.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.f14511h) == null || (d2Var = cVar.a) == null || d2Var.o1() == null || (bVar = this.f14509f) == null) {
            return;
        }
        bVar.x(this.f14511h.a.o1().hls_url);
    }
}
