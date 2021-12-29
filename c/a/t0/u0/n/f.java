package c.a.t0.u0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.q.q1;
import c.a.t0.w3.h0;
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
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f24978b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f24979c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24980d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24981e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24982f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24983g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f24984h;

    /* renamed from: i  reason: collision with root package name */
    public String f24985i;

    /* renamed from: j  reason: collision with root package name */
    public String f24986j;

    /* renamed from: k  reason: collision with root package name */
    public q1 f24987k;
    public LikeModel l;
    public h0 m;
    public boolean n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f24988e;

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
            this.f24988e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24988e.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f24989e;

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
            this.f24989e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_CONCERN);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.f24989e.f24987k.o());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.f24989e.f24987k.w() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.f24989e.f24987k.w()) {
                    this.f24989e.i();
                } else {
                    this.f24989e.h();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

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
            this.a = fVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.l.getErrorCode() == 22) {
                    n.M(this.a.a.getPageActivity(), this.a.a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.l.getErrorCode() != 0) {
                        n.M(this.a.a.getPageActivity(), this.a.l.getErrorString());
                        return;
                    }
                    this.a.n(true);
                    n.M(this.a.a.getPageActivity(), this.a.a.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

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
            this.a = fVar;
        }

        @Override // c.a.t0.w3.h0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.t0.w3.h0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.a.n(false);
                n.M(this.a.a.getPageActivity(), this.a.a.getString(R.string.un_attention_success));
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
        this.a = tbPageContext;
        this.f24985i = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f24986j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f24978b = inflate;
        this.f24979c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f24980d = (TextView) this.f24978b.findViewById(R.id.bar_name);
        this.f24981e = (TextView) this.f24978b.findViewById(R.id.desc);
        this.f24982f = (TextView) this.f24978b.findViewById(R.id.follow_text);
        this.f24983g = (TextView) this.f24978b.findViewById(R.id.tiezi_text);
        this.f24984h = (TBSpecificationBtn) this.f24978b.findViewById(R.id.forum_like_button);
        this.f24978b.setOnClickListener(new a(this));
        this.f24984h.setOnClickListener(new b(this));
    }

    public void g(q1 q1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, q1Var) == null) || q1Var == null) {
            return;
        }
        this.f24987k = q1Var;
        this.f24979c.setShowOval(true);
        this.f24979c.setShowOuterBorder(false);
        this.f24979c.setShowInnerBorder(true);
        this.f24979c.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f24979c.setStrokeColorResId(R.color.CAM_X0401);
        this.f24979c.startLoad(q1Var.k(), 10, false);
        String p = q1Var.p();
        if (m.isEmpty(p)) {
            p = "";
        }
        this.f24980d.setText(p);
        this.f24982f.setText(this.f24985i + " " + StringHelper.numFormatOverWanWithoutDecimals(q1Var.q()));
        this.f24983g.setText(this.f24986j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) q1Var.t()));
        String recomReason = q1Var.getRecomReason();
        if (m.isEmpty(recomReason)) {
            if (this.f24981e.getVisibility() != 8) {
                this.f24981e.setVisibility(8);
                if (this.f24980d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f24980d.getLayoutParams()).topMargin = n.f(this.a.getPageActivity(), R.dimen.tbds47);
                    this.f24980d.requestLayout();
                }
            }
        } else {
            if (this.f24981e.getVisibility() != 0) {
                this.f24981e.setVisibility(0);
                if (this.f24980d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f24980d.getLayoutParams()).topMargin = n.f(this.a.getPageActivity(), R.dimen.tbds24);
                    this.f24980d.requestLayout();
                }
            }
            this.f24981e.setText(recomReason);
        }
        n(this.f24987k.w());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!n.C()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.neterror));
                return;
            }
            q1 q1Var = this.f24987k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.f24987k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.l == null) {
                this.l = new LikeModel(this.a);
            }
            this.l.setLoadDataCallBack(new c(this));
            if (m.isForumName(this.f24987k.p())) {
                this.l.I();
                this.l.L(this.f24987k.p(), String.valueOf(this.f24987k.o()));
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!n.C()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.neterror));
                return;
            }
            q1 q1Var = this.f24987k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.f24987k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.m == null) {
                this.m = new h0();
            }
            this.m.b(new d(this));
            this.m.c(this.f24987k.p(), this.f24987k.o());
        }
    }

    public final void j() {
        q1 q1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (q1Var = this.f24987k) == null) {
            return;
        }
        String p = q1Var.p();
        if (m.isForumName(p)) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_FORUM_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.f24987k.o());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", this.n ? 4 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f24978b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f24980d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f24982f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f24983g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f24981e, R.color.CAM_X0109);
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
                c.a.s0.s.i0.n.b bVar = new c.a.s0.s.i0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f24984h.setConfig(bVar);
                this.f24984h.setText(this.f24985i);
            } else {
                c.a.s0.s.i0.n.b bVar2 = new c.a.s0.s.i0.n.b();
                bVar2.s(R.color.CAM_X0109);
                this.f24984h.setConfig(bVar2);
                this.f24984h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            }
            this.f24987k.y(z);
        }
    }
}
