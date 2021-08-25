package c.a.q0.m0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.q.p1;
import c.a.q0.i3.g0;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f22326a;

    /* renamed from: b  reason: collision with root package name */
    public View f22327b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f22328c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22329d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22330e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22331f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22332g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f22333h;

    /* renamed from: i  reason: collision with root package name */
    public String f22334i;

    /* renamed from: j  reason: collision with root package name */
    public String f22335j;
    public p1 k;
    public LikeModel l;
    public g0 m;
    public boolean n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22336e;

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
            this.f22336e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22336e.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22337e;

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
            this.f22337e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_CONCERN);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.f22337e.k.o());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.f22337e.k.w() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.f22337e.k.w()) {
                    this.f22337e.i();
                } else {
                    this.f22337e.h();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f22338a;

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
            this.f22338a = fVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f22338a.l.getErrorCode() == 22) {
                    l.M(this.f22338a.f22326a.getPageActivity(), this.f22338a.f22326a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f22338a.l.getErrorCode() != 0) {
                        l.M(this.f22338a.f22326a.getPageActivity(), this.f22338a.l.getErrorString());
                        return;
                    }
                    this.f22338a.n(true);
                    l.M(this.f22338a.f22326a.getPageActivity(), this.f22338a.f22326a.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements g0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f22339a;

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
            this.f22339a = fVar;
        }

        @Override // c.a.q0.i3.g0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.q0.i3.g0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.f22339a.n(false);
                l.M(this.f22339a.f22326a.getPageActivity(), this.f22339a.f22326a.getString(R.string.un_attention_success));
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
        this.f22326a = tbPageContext;
        this.f22334i = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f22335j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f22327b = inflate;
        this.f22328c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f22329d = (TextView) this.f22327b.findViewById(R.id.bar_name);
        this.f22330e = (TextView) this.f22327b.findViewById(R.id.desc);
        this.f22331f = (TextView) this.f22327b.findViewById(R.id.follow_text);
        this.f22332g = (TextView) this.f22327b.findViewById(R.id.tiezi_text);
        this.f22333h = (TBSpecificationBtn) this.f22327b.findViewById(R.id.forum_like_button);
        this.f22327b.setOnClickListener(new a(this));
        this.f22333h.setOnClickListener(new b(this));
    }

    public void g(p1 p1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, p1Var) == null) || p1Var == null) {
            return;
        }
        this.k = p1Var;
        this.f22328c.setShowOval(true);
        this.f22328c.setShowOuterBorder(false);
        this.f22328c.setShowInnerBorder(true);
        this.f22328c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f22328c.setStrokeColorResId(R.color.CAM_X0401);
        this.f22328c.startLoad(p1Var.k(), 10, false);
        String p = p1Var.p();
        if (k.isEmpty(p)) {
            p = "";
        }
        this.f22329d.setText(p);
        this.f22331f.setText(this.f22334i + " " + StringHelper.numFormatOverWanWithoutDecimals(p1Var.q()));
        this.f22332g.setText(this.f22335j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) p1Var.t()));
        String recomReason = p1Var.getRecomReason();
        if (k.isEmpty(recomReason)) {
            if (this.f22330e.getVisibility() != 8) {
                this.f22330e.setVisibility(8);
                if (this.f22329d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f22329d.getLayoutParams()).topMargin = l.g(this.f22326a.getPageActivity(), R.dimen.tbds47);
                    this.f22329d.requestLayout();
                }
            }
        } else {
            if (this.f22330e.getVisibility() != 0) {
                this.f22330e.setVisibility(0);
                if (this.f22329d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f22329d.getLayoutParams()).topMargin = l.g(this.f22326a.getPageActivity(), R.dimen.tbds24);
                    this.f22329d.requestLayout();
                }
            }
            this.f22330e.setText(recomReason);
        }
        n(this.k.w());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f22326a.getPageActivity(), this.f22326a.getString(R.string.neterror));
                return;
            }
            p1 p1Var = this.k;
            if (p1Var == null || StringUtils.isNull(p1Var.p()) || this.k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f22326a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.l == null) {
                this.l = new LikeModel(this.f22326a);
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
                UtilHelper.showToast(this.f22326a.getPageActivity(), this.f22326a.getString(R.string.neterror));
                return;
            }
            p1 p1Var = this.k;
            if (p1Var == null || StringUtils.isNull(p1Var.p()) || this.k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f22326a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.m == null) {
                this.m = new g0();
            }
            this.m.b(new d(this));
            this.m.c(this.k.p(), this.k.o());
        }
    }

    public final void j() {
        p1 p1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (p1Var = this.k) == null) {
            return;
        }
        String p = p1Var.p();
        if (k.isForumName(p)) {
            this.f22326a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f22326a.getPageActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22327b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f22329d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f22331f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22332g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22330e, R.color.CAM_X0109);
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
                c.a.p0.s.f0.n.b bVar = new c.a.p0.s.f0.n.b();
                bVar.q(R.color.CAM_X0302);
                this.f22333h.setConfig(bVar);
                this.f22333h.setText(this.f22334i);
            } else {
                c.a.p0.s.f0.n.b bVar2 = new c.a.p0.s.f0.n.b();
                bVar2.r(R.color.CAM_X0109);
                this.f22333h.setConfig(bVar2);
                this.f22333h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            }
            this.k.y(z);
        }
    }
}
