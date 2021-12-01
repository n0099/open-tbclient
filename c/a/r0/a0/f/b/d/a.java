package c.a.r0.a0.f.b.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.q0.d1.r0;
import c.a.q0.s.q.d2;
import c.a.r0.a0.f.b.b.c;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a0.f.b.d.b f13899b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13900c;

    /* renamed from: d  reason: collision with root package name */
    public c f13901d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f13902e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f13903f;

    /* renamed from: c.a.r0.a0.f.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0843a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0843a(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13904e;

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
            this.f13904e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13904e.i();
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
        this.a = null;
        this.f13900c = false;
        this.f13902e = new C0843a(this, 2000994);
        this.f13903f = new b(this);
        this.a = tbPageContext;
        this.f13899b = new c.a.r0.a0.f.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f13902e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13900c) {
            return;
        }
        if (r0.a(1)) {
            e.a().removeCallbacks(this.f13903f);
            e.a().postDelayed(this.f13903f, 1000L);
            return;
        }
        c.a.r0.a0.f.b.d.b bVar = this.f13899b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13901d : (c) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13899b.j() : (View) invokeV.objValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13900c = z;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null || cVar.a == null) {
            return;
        }
        this.f13901d = cVar;
        c.a.r0.a0.f.b.d.b bVar = this.f13899b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i2 = cVar.f13883b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.a.v1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f13899b.o();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f13902e);
            e.a().removeCallbacks(this.f13903f);
            c.a.r0.a0.f.b.d.b bVar = this.f13899b;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    public final void i() {
        c cVar;
        d2 d2Var;
        c.a.r0.a0.f.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.f13901d) == null || (d2Var = cVar.a) == null || d2Var.o1() == null || (bVar = this.f13899b) == null) {
            return;
        }
        bVar.x(this.f13901d.a.o1().hls_url);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.a0.f.b.d.b bVar = this.f13899b;
            if (bVar != null) {
                bVar.r();
            }
            e.a().removeCallbacks(this.f13903f);
        }
    }
}
