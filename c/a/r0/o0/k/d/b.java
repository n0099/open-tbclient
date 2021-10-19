package c.a.r0.o0.k.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.e;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b extends c.a.r0.b0.b<c.a.r0.o0.k.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public RecommendForumItemView n;
    public RecommendForumItemView o;
    public int p;
    public LikeModel q;

    /* loaded from: classes3.dex */
    public class a implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22882a;

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
            this.f22882a = bVar;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(c.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b bVar2 = this.f22882a;
                bVar2.x(bVar, bVar2.n);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(c.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f22882a.w(bVar);
            }
        }
    }

    /* renamed from: c.a.r0.o0.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1067b implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22883a;

        public C1067b(b bVar) {
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
            this.f22883a = bVar;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(c.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b bVar2 = this.f22883a;
                bVar2.x(bVar, bVar2.o);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(c.a.r0.o0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f22883a.w(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumItemView f22884a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22885b;

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
            this.f22885b = bVar;
            this.f22884a = recommendForumItemView;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f22885b.q.getErrorCode() == 22) {
                    l.M(this.f22885b.m.getPageActivity(), this.f22885b.m.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f22885b.q.getErrorCode() != 0) {
                        l.M(this.f22885b.m.getPageActivity(), this.f22885b.q.getErrorString());
                        return;
                    }
                    if (this.f22884a == this.f22885b.n) {
                        this.f22885b.n.updateLikeState(true);
                    } else {
                        this.f22885b.o.updateLikeState(true);
                    }
                    l.M(this.f22885b.m.getPageActivity(), this.f22885b.m.getString(R.string.attention_success));
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
        z();
        this.n.setForumItemClickListener(new a(this));
        this.o.setForumItemClickListener(new C1067b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.b0.b
    /* renamed from: A */
    public void k(c.a.r0.o0.k.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        l(this.m, this.p);
        if (cVar.f22867e != null) {
            this.n.setVisibility(0);
            this.n.onBindData(cVar.f22867e);
        } else {
            this.n.setVisibility(4);
        }
        if (cVar.f22868f != null) {
            this.o.setVisibility(0);
            this.o.onBindData(cVar.f22868f);
            return;
        }
        this.o.setVisibility(4);
    }

    @Override // c.a.r0.b0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.recommend_forum_layout : invokeV.intValue;
    }

    @Override // c.a.r0.b0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.p = i2;
            this.n.onChangeSkinType();
            this.o.onChangeSkinType();
            SkinManager.setBackgroundColor(j(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    public final void w(c.a.r0.o0.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.m.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.m.getPageActivity()).createNormalCfg(bVar.f22860c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
            y(bVar, "2");
        }
    }

    public final void x(c.a.r0.o0.k.c.b bVar, RecommendForumItemView recommendForumItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bVar, recommendForumItemView) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f15708f.getPageActivity(), this.f15708f.getString(R.string.neterror));
            } else if (bVar == null || StringUtils.isNull(bVar.f22860c) || bVar.f22859b <= 0) {
            } else {
                if (!ViewHelper.checkUpIsLogin(d())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.q == null) {
                    this.q = new LikeModel(this.m);
                }
                this.q.setLoadDataCallBack(new c(this, recommendForumItemView));
                if (k.isForumName(bVar.f22860c)) {
                    this.q.L(bVar.f22860c, String.valueOf(bVar.f22859b));
                }
                y(bVar, "1");
            }
        }
    }

    public final void y(c.a.r0.o0.k.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, bVar, str) == null) || bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(bVar.f22865h));
        statisticItem.param("fid", bVar.f22859b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", str);
        TiebaStatic.log(statisticItem);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View j2 = j();
            this.n = (RecommendForumItemView) j2.findViewById(R.id.reommend_forum_one);
            this.o = (RecommendForumItemView) j2.findViewById(R.id.reommend_forum_two);
        }
    }
}
