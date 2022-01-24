package c.a.t0.e1.r2;

import c.a.t0.x3.x;
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
/* loaded from: classes7.dex */
public class b extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f16786h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.d.a.e f16787i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.d.a.e f16788j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                this.a.b((x) customResponsedMessage.getData());
            }
        }
    }

    /* renamed from: c.a.t0.e1.r2.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1064b extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1064b(b bVar) {
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

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Boolean)) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                    return;
                }
                this.a.f16841b.refresh();
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
        this.f16786h = new a(this, 2001266);
        this.f16787i = new C1064b(this);
        this.f16788j = new c(this);
        frsFragment.registerListener(this.f16786h);
    }

    public final void b(x xVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, xVar) == null) || xVar == null) {
            return;
        }
        FrsViewData frsViewData = this.f16841b.getFrsViewData();
        if (this.f16844e == null || this.f16843d == null || this.a == null || frsViewData == null || frsViewData.getForum() == null || xVar.g() == null) {
            return;
        }
        boolean z = xVar.m() == 1;
        if (xVar.g().equals(frsViewData.getForum().getId())) {
            frsViewData.getForum().setLike(xVar.m());
            if (!StringUtils.isNULL(xVar.h())) {
                frsViewData.getForum().setLevelName(xVar.h());
            }
            if (xVar.l() >= 0) {
                frsViewData.getForum().setUser_level(xVar.l());
            }
            if (z) {
                this.f16843d.Y(frsViewData, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f16841b.getForumName());
                return;
            }
            c.a.t0.x3.e.i().n(this.f16841b.getForumName(), false);
            frsViewData.getForum().setLike(0);
            this.f16843d.b0();
            TbadkCoreApplication.getInst().delLikeForum(this.f16841b.getForumName());
            return;
        }
        if (xVar.m() == 1) {
            frsViewData.deleteLikeFeedForum(xVar.g());
            this.f16843d.L(frsViewData);
            this.f16842c.d(frsViewData, this.f16844e.R());
        }
        if (frsViewData.getForum().getBannerListData() != null) {
            frsViewData.getForum().getBannerListData().setFeedForumLiked(xVar.g(), xVar.m());
        }
        this.a.G0();
    }
}
