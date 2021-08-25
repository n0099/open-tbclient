package c.a.q0.v.d.b.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.e;
import c.a.p0.b1.r0;
import c.a.p0.s.q.c2;
import c.a.q0.v.d.b.b.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f25032a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.v.d.b.d.b f25033b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25034c;

    /* renamed from: d  reason: collision with root package name */
    public c f25035d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f25036e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f25037f;

    /* renamed from: c.a.q0.v.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1167a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25038a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1167a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f25038a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f25038a.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25039e;

        public b(a aVar) {
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
                    return;
                }
            }
            this.f25039e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25039e.i();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25032a = null;
        this.f25034c = false;
        this.f25036e = new C1167a(this, 2000994);
        this.f25037f = new b(this);
        this.f25032a = tbPageContext;
        this.f25033b = new c.a.q0.v.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f25036e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25034c) {
            return;
        }
        if (r0.a(1)) {
            e.a().removeCallbacks(this.f25037f);
            e.a().postDelayed(this.f25037f, 1000L);
            return;
        }
        c.a.q0.v.d.b.d.b bVar = this.f25033b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25035d : (c) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25033b.j() : (View) invokeV.objValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f25034c = z;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null || cVar.f25015a == null) {
            return;
        }
        this.f25035d = cVar;
        c.a.q0.v.d.b.d.b bVar = this.f25033b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i2 = cVar.f25016b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f25015a.q1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f25033b.o();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f25036e);
            e.a().removeCallbacks(this.f25037f);
            c.a.q0.v.d.b.d.b bVar = this.f25033b;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    public final void i() {
        c cVar;
        c2 c2Var;
        c.a.q0.v.d.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.f25035d) == null || (c2Var = cVar.f25015a) == null || c2Var.j1() == null || (bVar = this.f25033b) == null) {
            return;
        }
        bVar.x(this.f25035d.f25015a.j1().hls_url);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.v.d.b.d.b bVar = this.f25033b;
            if (bVar != null) {
                bVar.r();
            }
            e.a().removeCallbacks(this.f25037f);
        }
    }
}
