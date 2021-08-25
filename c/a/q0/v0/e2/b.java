package c.a.q0.v0.e2;

import c.a.q0.i3.w;
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
/* loaded from: classes4.dex */
public class b extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f25930h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.e.a.e f25931i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.e.a.e f25932j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25933a;

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
            this.f25933a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                this.f25933a.b((w) customResponsedMessage.getData());
            }
        }
    }

    /* renamed from: c.a.q0.v0.e2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1213b extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1213b(b bVar) {
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

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Boolean)) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25934a;

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
            this.f25934a = bVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                    return;
                }
                this.f25934a.f26011b.refresh();
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
        this.f25930h = new a(this, 2001266);
        this.f25931i = new C1213b(this);
        this.f25932j = new c(this);
        frsFragment.registerListener(this.f25930h);
    }

    public final void b(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, wVar) == null) || wVar == null) {
            return;
        }
        FrsViewData frsViewData = this.f26011b.getFrsViewData();
        if (this.f26014e == null || this.f26013d == null || this.f26010a == null || frsViewData == null || frsViewData.getForum() == null || wVar.g() == null) {
            return;
        }
        boolean z = wVar.l() == 1;
        if (wVar.g().equals(frsViewData.getForum().getId())) {
            frsViewData.getForum().setLike(wVar.l());
            if (!StringUtils.isNULL(wVar.h())) {
                frsViewData.getForum().setLevelName(wVar.h());
            }
            if (wVar.k() >= 0) {
                frsViewData.getForum().setUser_level(wVar.k());
            }
            if (z) {
                this.f26013d.f0(frsViewData, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f26011b.getForumName());
                return;
            }
            c.a.q0.i3.e.i().n(this.f26011b.getForumName(), false);
            frsViewData.getForum().setLike(0);
            this.f26013d.i0();
            TbadkCoreApplication.getInst().delLikeForum(this.f26011b.getForumName());
            return;
        }
        if (wVar.l() == 1) {
            frsViewData.deleteLikeFeedForum(wVar.g());
            this.f26013d.S(frsViewData);
            this.f26012c.d(frsViewData, this.f26014e.R());
        }
        if (frsViewData.getForum().getBannerListData() != null) {
            frsViewData.getForum().getBannerListData().setFeedForumLiked(wVar.g(), wVar.l());
        }
        this.f26010a.H0();
    }
}
