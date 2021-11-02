package b.a.r0.o0.k.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.e;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends b.a.r0.b0.b<b.a.r0.o0.k.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public RecommendForumItemView n;
    public RecommendForumItemView o;
    public int p;
    public LikeModel q;

    /* loaded from: classes5.dex */
    public class a implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21752a;

        public a(b bVar) {
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
            this.f21752a = bVar;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(b.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b bVar2 = this.f21752a;
                bVar2.w(bVar, bVar2.n);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(b.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f21752a.v(bVar);
            }
        }
    }

    /* renamed from: b.a.r0.o0.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1064b implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21753a;

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
                    return;
                }
            }
            this.f21753a = bVar;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(b.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b bVar2 = this.f21753a;
                bVar2.w(bVar, bVar2.o);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(b.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f21753a.v(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumItemView f21754a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21755b;

        public c(b bVar, RecommendForumItemView recommendForumItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, recommendForumItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21755b = bVar;
            this.f21754a = recommendForumItemView;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f21755b.q.getErrorCode() == 22) {
                    l.M(this.f21755b.m.getPageActivity(), this.f21755b.m.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f21755b.q.getErrorCode() != 0) {
                        l.M(this.f21755b.m.getPageActivity(), this.f21755b.q.getErrorString());
                        return;
                    }
                    if (this.f21754a == this.f21755b.n) {
                        this.f21755b.n.updateLikeState(true);
                    } else {
                        this.f21755b.o.updateLikeState(true);
                    }
                    l.M(this.f21755b.m.getPageActivity(), this.f21755b.m.getString(R.string.attention_success));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
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
        this.p = 3;
        this.m = tbPageContext;
        y();
        this.n.setForumItemClickListener(new a(this));
        this.o.setForumItemClickListener(new C1064b(this));
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.recommend_forum_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.p = i2;
            this.n.onChangeSkinType();
            this.o.onChangeSkinType();
            SkinManager.setBackgroundColor(i(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void v(b.a.r0.o0.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.m.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.m.getPageActivity()).createNormalCfg(bVar.f21731c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
            x(bVar, "2");
        }
    }

    public final void w(b.a.r0.o0.k.c.b bVar, RecommendForumItemView recommendForumItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, recommendForumItemView) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f14737f.getPageActivity(), this.f14737f.getString(R.string.neterror));
            } else if (bVar == null || StringUtils.isNull(bVar.f21731c) || bVar.f21730b <= 0) {
            } else {
                if (!ViewHelper.checkUpIsLogin(getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.q == null) {
                    this.q = new LikeModel(this.m);
                }
                this.q.setLoadDataCallBack(new c(this, recommendForumItemView));
                if (k.isForumName(bVar.f21731c)) {
                    this.q.L(bVar.f21731c, String.valueOf(bVar.f21730b));
                }
                x(bVar, "1");
            }
        }
    }

    public final void x(b.a.r0.o0.k.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, bVar, str) == null) || bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(bVar.f21736h));
        statisticItem.param("fid", bVar.f21730b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", str);
        TiebaStatic.log(statisticItem);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View i2 = i();
            this.n = (RecommendForumItemView) i2.findViewById(R.id.reommend_forum_one);
            this.o = (RecommendForumItemView) i2.findViewById(R.id.reommend_forum_two);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: z */
    public void j(b.a.r0.o0.k.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar == null) {
            return;
        }
        k(this.m, this.p);
        if (cVar.f21738e != null) {
            this.n.setVisibility(0);
            this.n.onBindData(cVar.f21738e);
        } else {
            this.n.setVisibility(4);
        }
        if (cVar.f21739f != null) {
            this.o.setVisibility(0);
            this.o.onBindData(cVar.f21739f);
            return;
        }
        this.o.setVisibility(4);
    }
}
