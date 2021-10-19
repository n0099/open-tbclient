package c.a.r0.o0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.q.q1;
import c.a.r0.k3.g0;
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
    public TbPageContext<?> f23094a;

    /* renamed from: b  reason: collision with root package name */
    public View f23095b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f23096c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23097d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23098e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23099f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23100g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f23101h;

    /* renamed from: i  reason: collision with root package name */
    public String f23102i;

    /* renamed from: j  reason: collision with root package name */
    public String f23103j;
    public q1 k;
    public LikeModel l;
    public g0 m;
    public boolean n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23104e;

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
            this.f23104e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23104e.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23105e;

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
            this.f23105e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_CONCERN);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.f23105e.k.o());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.f23105e.k.w() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.f23105e.k.w()) {
                    this.f23105e.i();
                } else {
                    this.f23105e.h();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f23106a;

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
            this.f23106a = fVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f23106a.l.getErrorCode() == 22) {
                    l.M(this.f23106a.f23094a.getPageActivity(), this.f23106a.f23094a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f23106a.l.getErrorCode() != 0) {
                        l.M(this.f23106a.f23094a.getPageActivity(), this.f23106a.l.getErrorString());
                        return;
                    }
                    this.f23106a.n(true);
                    l.M(this.f23106a.f23094a.getPageActivity(), this.f23106a.f23094a.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements g0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f23107a;

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
            this.f23107a = fVar;
        }

        @Override // c.a.r0.k3.g0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.r0.k3.g0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.f23107a.n(false);
                l.M(this.f23107a.f23094a.getPageActivity(), this.f23107a.f23094a.getString(R.string.un_attention_success));
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
        this.f23094a = tbPageContext;
        this.f23102i = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f23103j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f23095b = inflate;
        this.f23096c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f23097d = (TextView) this.f23095b.findViewById(R.id.bar_name);
        this.f23098e = (TextView) this.f23095b.findViewById(R.id.desc);
        this.f23099f = (TextView) this.f23095b.findViewById(R.id.follow_text);
        this.f23100g = (TextView) this.f23095b.findViewById(R.id.tiezi_text);
        this.f23101h = (TBSpecificationBtn) this.f23095b.findViewById(R.id.forum_like_button);
        this.f23095b.setOnClickListener(new a(this));
        this.f23101h.setOnClickListener(new b(this));
    }

    public void g(q1 q1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, q1Var) == null) || q1Var == null) {
            return;
        }
        this.k = q1Var;
        this.f23096c.setShowOval(true);
        this.f23096c.setShowOuterBorder(false);
        this.f23096c.setShowInnerBorder(true);
        this.f23096c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f23096c.setStrokeColorResId(R.color.CAM_X0401);
        this.f23096c.startLoad(q1Var.k(), 10, false);
        String p = q1Var.p();
        if (k.isEmpty(p)) {
            p = "";
        }
        this.f23097d.setText(p);
        this.f23099f.setText(this.f23102i + " " + StringHelper.numFormatOverWanWithoutDecimals(q1Var.q()));
        this.f23100g.setText(this.f23103j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) q1Var.t()));
        String recomReason = q1Var.getRecomReason();
        if (k.isEmpty(recomReason)) {
            if (this.f23098e.getVisibility() != 8) {
                this.f23098e.setVisibility(8);
                if (this.f23097d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f23097d.getLayoutParams()).topMargin = l.g(this.f23094a.getPageActivity(), R.dimen.tbds47);
                    this.f23097d.requestLayout();
                }
            }
        } else {
            if (this.f23098e.getVisibility() != 0) {
                this.f23098e.setVisibility(0);
                if (this.f23097d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f23097d.getLayoutParams()).topMargin = l.g(this.f23094a.getPageActivity(), R.dimen.tbds24);
                    this.f23097d.requestLayout();
                }
            }
            this.f23098e.setText(recomReason);
        }
        n(this.k.w());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f23094a.getPageActivity(), this.f23094a.getString(R.string.neterror));
                return;
            }
            q1 q1Var = this.k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f23094a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.l == null) {
                this.l = new LikeModel(this.f23094a);
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
                UtilHelper.showToast(this.f23094a.getPageActivity(), this.f23094a.getString(R.string.neterror));
                return;
            }
            q1 q1Var = this.k;
            if (q1Var == null || StringUtils.isNull(q1Var.p()) || this.k.o() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f23094a.getPageActivity())) {
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
        q1 q1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (q1Var = this.k) == null) {
            return;
        }
        String p = q1Var.p();
        if (k.isForumName(p)) {
            this.f23094a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f23094a.getPageActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23095b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f23097d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f23099f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f23100g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f23098e, R.color.CAM_X0109);
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
                c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f23101h.setConfig(bVar);
                this.f23101h.setText(this.f23102i);
            } else {
                c.a.q0.s.f0.n.b bVar2 = new c.a.q0.s.f0.n.b();
                bVar2.s(R.color.CAM_X0109);
                this.f23101h.setConfig(bVar2);
                this.f23101h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            }
            this.k.y(z);
        }
    }
}
