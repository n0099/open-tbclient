package c.a.r0.u0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.r.r.q1;
import c.a.r0.y3.i0;
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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f22865b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f22866c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22867d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22868e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22869f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22870g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f22871h;

    /* renamed from: i  reason: collision with root package name */
    public String f22872i;

    /* renamed from: j  reason: collision with root package name */
    public String f22873j;
    public q1 k;
    public LikeModel l;
    public i0 m;
    public boolean n;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22874e;

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
            this.f22874e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22874e.j();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22875e;

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
            this.f22875e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_CONCERN);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.f22875e.k.o());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.f22875e.k.w() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.f22875e.k.w()) {
                    this.f22875e.i();
                } else {
                    this.f22875e.h();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                    n.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.l.getErrorCode() != 0) {
                        n.N(this.a.a.getPageActivity(), this.a.l.getErrorString());
                        return;
                    }
                    this.a.n(true);
                    n.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements i0.a {
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

        @Override // c.a.r0.y3.i0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.r0.y3.i0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.a.n(false);
                n.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.un_attention_success));
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
        this.f22872i = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f22873j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f22865b = inflate;
        this.f22866c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f22867d = (TextView) this.f22865b.findViewById(R.id.bar_name);
        this.f22868e = (TextView) this.f22865b.findViewById(R.id.desc);
        this.f22869f = (TextView) this.f22865b.findViewById(R.id.follow_text);
        this.f22870g = (TextView) this.f22865b.findViewById(R.id.tiezi_text);
        this.f22871h = (TBSpecificationBtn) this.f22865b.findViewById(R.id.forum_like_button);
        this.f22865b.setOnClickListener(new a(this));
        this.f22871h.setOnClickListener(new b(this));
    }

    public void g(q1 q1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, q1Var) == null) || q1Var == null) {
            return;
        }
        this.k = q1Var;
        this.f22866c.setShowOval(true);
        this.f22866c.setShowOuterBorder(false);
        this.f22866c.setShowInnerBorder(true);
        this.f22866c.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f22866c.setStrokeColorResId(R.color.CAM_X0401);
        this.f22866c.startLoad(q1Var.k(), 10, false);
        String p = q1Var.p();
        if (m.isEmpty(p)) {
            p = "";
        }
        this.f22867d.setText(p);
        this.f22869f.setText(this.f22872i + " " + StringHelper.numFormatOverWanWithoutDecimals(q1Var.q()));
        this.f22870g.setText(this.f22873j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) q1Var.t()));
        String recomReason = q1Var.getRecomReason();
        if (m.isEmpty(recomReason)) {
            if (this.f22868e.getVisibility() != 8) {
                this.f22868e.setVisibility(8);
                if (this.f22867d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f22867d.getLayoutParams()).topMargin = n.f(this.a.getPageActivity(), R.dimen.tbds47);
                    this.f22867d.requestLayout();
                }
            }
        } else {
            if (this.f22868e.getVisibility() != 0) {
                this.f22868e.setVisibility(0);
                if (this.f22867d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f22867d.getLayoutParams()).topMargin = n.f(this.a.getPageActivity(), R.dimen.tbds24);
                    this.f22867d.requestLayout();
                }
            }
            this.f22868e.setText(recomReason);
        }
        n(this.k.w());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!n.C()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.neterror));
                return;
            }
            q1 q1Var = this.k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.k.o() <= 0) {
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
            if (m.isForumName(this.k.p())) {
                this.l.J();
                this.l.N(this.k.p(), String.valueOf(this.k.o()));
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
            q1 q1Var = this.k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.m == null) {
                this.m = new i0();
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
        if (m.isForumName(p)) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22865b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f22867d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f22869f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22870g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22868e, (int) R.color.CAM_X0109);
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
                c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f22871h.setConfig(bVar);
                this.f22871h.setText(this.f22872i);
            } else {
                c.a.q0.r.l0.n.b bVar2 = new c.a.q0.r.l0.n.b();
                bVar2.t(R.color.CAM_X0109);
                this.f22871h.setConfig(bVar2);
                this.f22871h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            }
            this.k.y(z);
        }
    }
}
