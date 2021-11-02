package b.a.r0.o0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.q.q1;
import b.a.r0.l3.h0;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f21957a;

    /* renamed from: b  reason: collision with root package name */
    public View f21958b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f21959c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21960d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21961e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21962f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21963g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f21964h;

    /* renamed from: i  reason: collision with root package name */
    public String f21965i;
    public String j;
    public q1 k;
    public LikeModel l;
    public h0 m;
    public boolean n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f21966e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21966e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21966e.j();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f21967e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21967e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_CONCERN);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.f21967e.k.o());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.f21967e.k.w() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.f21967e.k.w()) {
                    this.f21967e.i();
                } else {
                    this.f21967e.h();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f21968a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21968a = fVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f21968a.l.getErrorCode() == 22) {
                    l.M(this.f21968a.f21957a.getPageActivity(), this.f21968a.f21957a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f21968a.l.getErrorCode() != 0) {
                        l.M(this.f21968a.f21957a.getPageActivity(), this.f21968a.l.getErrorString());
                        return;
                    }
                    this.f21968a.n(true);
                    l.M(this.f21968a.f21957a.getPageActivity(), this.f21968a.f21957a.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f21969a;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21969a = fVar;
        }

        @Override // b.a.r0.l3.h0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // b.a.r0.l3.h0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f21969a.n(false);
                l.M(this.f21969a.f21957a.getPageActivity(), this.f21969a.f21957a.getString(R.string.un_attention_success));
            }
        }
    }

    public f(TbPageContext<?> tbPageContext) {
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
        this.f21957a = tbPageContext;
        this.f21965i = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f21958b = inflate;
        this.f21959c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f21960d = (TextView) this.f21958b.findViewById(R.id.bar_name);
        this.f21961e = (TextView) this.f21958b.findViewById(R.id.desc);
        this.f21962f = (TextView) this.f21958b.findViewById(R.id.follow_text);
        this.f21963g = (TextView) this.f21958b.findViewById(R.id.tiezi_text);
        this.f21964h = (TBSpecificationBtn) this.f21958b.findViewById(R.id.forum_like_button);
        this.f21958b.setOnClickListener(new a(this));
        this.f21964h.setOnClickListener(new b(this));
    }

    public void g(q1 q1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, q1Var) == null) || q1Var == null) {
            return;
        }
        this.k = q1Var;
        this.f21959c.setShowOval(true);
        this.f21959c.setShowOuterBorder(false);
        this.f21959c.setShowInnerBorder(true);
        this.f21959c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f21959c.setStrokeColorResId(R.color.CAM_X0401);
        this.f21959c.startLoad(q1Var.k(), 10, false);
        String p = q1Var.p();
        if (k.isEmpty(p)) {
            p = "";
        }
        this.f21960d.setText(p);
        this.f21962f.setText(this.f21965i + " " + StringHelper.numFormatOverWanWithoutDecimals(q1Var.q()));
        this.f21963g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) q1Var.t()));
        String recomReason = q1Var.getRecomReason();
        if (k.isEmpty(recomReason)) {
            if (this.f21961e.getVisibility() != 8) {
                this.f21961e.setVisibility(8);
                if (this.f21960d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f21960d.getLayoutParams()).topMargin = l.g(this.f21957a.getPageActivity(), R.dimen.tbds47);
                    this.f21960d.requestLayout();
                }
            }
        } else {
            if (this.f21961e.getVisibility() != 0) {
                this.f21961e.setVisibility(0);
                if (this.f21960d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f21960d.getLayoutParams()).topMargin = l.g(this.f21957a.getPageActivity(), R.dimen.tbds24);
                    this.f21960d.requestLayout();
                }
            }
            this.f21961e.setText(recomReason);
        }
        n(this.k.w());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f21957a.getPageActivity(), this.f21957a.getString(R.string.neterror));
                return;
            }
            q1 q1Var = this.k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f21957a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.l == null) {
                this.l = new LikeModel(this.f21957a);
            }
            this.l.setLoadDataCallBack(new c(this));
            if (k.isForumName(this.k.p())) {
                this.l.I();
                this.l.L(this.k.p(), String.valueOf(this.k.o()));
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f21957a.getPageActivity(), this.f21957a.getString(R.string.neterror));
                return;
            }
            q1 q1Var = this.k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f21957a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.m == null) {
                this.m = new h0();
            }
            this.m.b(new d(this));
            this.m.c(this.k.p(), this.k.o());
        }
    }

    public final void j() {
        q1 q1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (q1Var = this.k) == null) {
            return;
        }
        String p = q1Var.p();
        if (k.isForumName(p)) {
            this.f21957a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f21957a.getPageActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_FORUM_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k.o());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", this.n ? 4 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21958b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f21960d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f21962f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f21963g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f21961e, R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f21964h.setConfig(bVar);
                this.f21964h.setText(this.f21965i);
            } else {
                b.a.q0.s.g0.n.b bVar2 = new b.a.q0.s.g0.n.b();
                bVar2.s(R.color.CAM_X0109);
                this.f21964h.setConfig(bVar2);
                this.f21964h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            }
            this.k.y(z);
        }
    }
}
