package b.a.r0.x0.q2;

import b.a.r0.m3.x;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f27685h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a.e.a.e f27686i;
    public final b.a.e.a.e j;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27687a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.f27687a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                this.f27687a.b((x) customResponsedMessage.getData());
            }
        }
    }

    /* renamed from: b.a.r0.x0.q2.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1356b extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1356b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Boolean)) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27688a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27688a = bVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                    return;
                }
                this.f27688a.f27762b.refresh();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27685h = new a(this, 2001266);
        this.f27686i = new C1356b(this);
        this.j = new c(this);
        frsFragment.registerListener(this.f27685h);
    }

    public final void b(x xVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, xVar) == null) || xVar == null) {
            return;
        }
        FrsViewData frsViewData = this.f27762b.getFrsViewData();
        if (this.f27765e == null || this.f27764d == null || this.f27761a == null || frsViewData == null || frsViewData.getForum() == null || xVar.g() == null) {
            return;
        }
        boolean z = xVar.l() == 1;
        if (xVar.g().equals(frsViewData.getForum().getId())) {
            frsViewData.getForum().setLike(xVar.l());
            if (!StringUtils.isNULL(xVar.h())) {
                frsViewData.getForum().setLevelName(xVar.h());
            }
            if (xVar.k() >= 0) {
                frsViewData.getForum().setUser_level(xVar.k());
            }
            if (z) {
                this.f27764d.f0(frsViewData, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f27762b.getForumName());
                return;
            }
            b.a.r0.m3.e.i().n(this.f27762b.getForumName(), false);
            frsViewData.getForum().setLike(0);
            this.f27764d.i0();
            TbadkCoreApplication.getInst().delLikeForum(this.f27762b.getForumName());
            return;
        }
        if (xVar.l() == 1) {
            frsViewData.deleteLikeFeedForum(xVar.g());
            this.f27764d.S(frsViewData);
            this.f27763c.d(frsViewData, this.f27765e.R());
        }
        if (frsViewData.getForum().getBannerListData() != null) {
            frsViewData.getForum().getBannerListData().setFeedForumLiked(xVar.g(), xVar.l());
        }
        this.f27761a.G0();
    }
}
