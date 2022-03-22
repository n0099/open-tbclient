package c.a.p0.c0.f.g.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.t0;
import c.a.p0.c0.f.b.d.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends c.a.p0.c0.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.c0.f.b.d.b f13105f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13106g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.c0.f.b.b.c f13107h;
    public AlaInfoData i;
    public CustomMessageListener j;
    public Runnable k;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.c0.f.b.d.b.e
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null) {
                return;
            }
            c.a.p0.c0.f.e.a.c().f("c12909", this.a.f13099d.f13071e, 1, threadData.getId(), threadData.getFid(), threadData.getForum_name(), this.a.i);
        }

        @Override // c.a.p0.c0.f.b.d.b.e
        public void b(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null) {
                return;
            }
            c.a.p0.c0.f.e.a.c().f("c12910", this.a.f13099d.f13071e, 1, threadData.getId(), threadData.getFid(), threadData.getForum_name(), this.a.i);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13106g = false;
        this.j = new a(this, 2000994);
        this.k = new c(this);
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void b(c.a.p0.c0.f.g.c.a aVar) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            q();
            c.a.p0.c0.f.b.d.b bVar = this.f13105f;
            if (bVar != null) {
                bVar.n(this.f13107h);
            }
            c.a.p0.c0.f.b.b.c cVar = this.f13107h;
            if (cVar == null || (threadData = cVar.a) == null) {
                return;
            }
            this.i = threadData.getThreadAlaInfo();
            c.a.p0.c0.f.e.a.c().f("c12908", this.f13099d.f13071e, 1, this.f13107h.a.getId(), this.f13107h.a.getFid(), this.f13107h.a.getForum_name(), this.i);
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13105f.j() : (View) invokeV.objValue;
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13105f = new c.a.p0.c0.f.b.d.b(this.f13098c, true);
            MessageManager.getInstance().registerListener(this.j);
            this.f13105f.w(new b(this));
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public boolean f(c.a.p0.c0.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 1 != aVar.f13070d || ListUtils.isEmpty(aVar.f13069c) || aVar.f13069c.get(0) == null || aVar.f13069c.get(0).getThreadAlaInfo() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f13106g = z;
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            c.a.p0.c0.f.b.d.b bVar = this.f13105f;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f13105f.o();
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            c.a.d.f.m.e.a().removeCallbacks(this.k);
            c.a.p0.c0.f.b.d.b bVar = this.f13105f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f13106g) {
            return;
        }
        if (t0.a(1)) {
            c.a.d.f.m.e.a().removeCallbacks(this.k);
            c.a.d.f.m.e.a().postDelayed(this.k, 1000L);
            return;
        }
        c.a.p0.c0.f.b.d.b bVar = this.f13105f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // c.a.p0.c0.f.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.c0.f.b.d.b bVar = this.f13105f;
            if (bVar != null) {
                bVar.r();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.p0.c0.f.b.b.c cVar = new c.a.p0.c0.f.b.b.c();
            this.f13107h = cVar;
            cVar.a = this.f13099d.f13069c.get(0);
        }
    }

    public final void r() {
        c.a.p0.c0.f.b.b.c cVar;
        ThreadData threadData;
        c.a.p0.c0.f.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.f13107h) == null || (threadData = cVar.a) == null || threadData.getThreadAlaInfo() == null || (bVar = this.f13105f) == null) {
            return;
        }
        bVar.x(this.f13107h.a.getThreadAlaInfo().hls_url);
    }
}
