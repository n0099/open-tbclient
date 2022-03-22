package c.a.p0.w0.p;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.n1;
import c.a.p0.a4.i0;
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
    public View f19636b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f19637c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19638d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19639e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19640f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19641g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f19642h;
    public String i;
    public String j;
    public n1 k;
    public LikeModel l;
    public i0 m;
    public boolean n;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c13644");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.a.k.k());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.a.k.s() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.a.k.s()) {
                    this.a.i();
                } else {
                    this.a.h();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    n.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0802));
                } else if (obj == null) {
                } else {
                    if (this.a.l.getErrorCode() != 0) {
                        n.N(this.a.a.getPageActivity(), this.a.l.getErrorString());
                        return;
                    }
                    this.a.n(true);
                    n.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f02ab));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.p0.a4.i0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // c.a.p0.a4.i0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.n(false);
                n.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f145f));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.i = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029b);
        this.j = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13a1);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d072a, (ViewGroup) null);
        this.f19636b = inflate;
        this.f19637c = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09030e);
        this.f19638d = (TextView) this.f19636b.findViewById(R.id.obfuscated_res_0x7f09031c);
        this.f19639e = (TextView) this.f19636b.findViewById(R.id.obfuscated_res_0x7f090777);
        this.f19640f = (TextView) this.f19636b.findViewById(R.id.obfuscated_res_0x7f090a01);
        this.f19641g = (TextView) this.f19636b.findViewById(R.id.obfuscated_res_0x7f091ffa);
        this.f19642h = (TBSpecificationBtn) this.f19636b.findViewById(R.id.obfuscated_res_0x7f090a5a);
        this.f19636b.setOnClickListener(new a(this));
        this.f19642h.setOnClickListener(new b(this));
    }

    public void g(n1 n1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, n1Var) == null) || n1Var == null) {
            return;
        }
        this.k = n1Var;
        this.f19637c.setShowOval(true);
        this.f19637c.setShowOuterBorder(false);
        this.f19637c.setShowInnerBorder(true);
        this.f19637c.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f19637c.setStrokeColorResId(R.color.CAM_X0401);
        this.f19637c.J(n1Var.i(), 10, false);
        String m = n1Var.m();
        if (m.isEmpty(m)) {
            m = "";
        }
        this.f19638d.setText(m);
        this.f19640f.setText(this.i + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.q()));
        this.f19641g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) n1Var.r()));
        String recomReason = n1Var.getRecomReason();
        if (m.isEmpty(recomReason)) {
            if (this.f19639e.getVisibility() != 8) {
                this.f19639e.setVisibility(8);
                if (this.f19638d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f19638d.getLayoutParams()).topMargin = n.f(this.a.getPageActivity(), R.dimen.tbds47);
                    this.f19638d.requestLayout();
                }
            }
        } else {
            if (this.f19639e.getVisibility() != 0) {
                this.f19639e.setVisibility(0);
                if (this.f19638d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f19638d.getLayoutParams()).topMargin = n.f(this.a.getPageActivity(), R.dimen.tbds24);
                    this.f19638d.requestLayout();
                }
            }
            this.f19639e.setText(recomReason);
        }
        n(this.k.s());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!n.C()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0c15));
                return;
            }
            n1 n1Var = this.k;
            if (n1Var == null || StringUtils.isNull(n1Var.m()) || this.k.k() <= 0) {
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
            if (m.isForumName(this.k.m())) {
                this.l.L();
                this.l.P(this.k.m(), String.valueOf(this.k.k()));
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!n.C()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0c15));
                return;
            }
            n1 n1Var = this.k;
            if (n1Var == null || StringUtils.isNull(n1Var.m()) || this.k.k() <= 0) {
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
            this.m.c(this.k.m(), this.k.k());
        }
    }

    public final void j() {
        n1 n1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (n1Var = this.k) == null) {
            return;
        }
        String m = n1Var.m();
        if (m.isForumName(m)) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(m, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            StatisticItem statisticItem = new StatisticItem("c13643");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k.k());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", this.n ? 4 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19636b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f19638d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19640f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f19641g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f19639e, (int) R.color.CAM_X0109);
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
                c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f19642h.setConfig(bVar);
                this.f19642h.setText(this.i);
            } else {
                c.a.o0.r.l0.n.b bVar2 = new c.a.o0.r.l0.n.b();
                bVar2.t(R.color.CAM_X0109);
                this.f19642h.setConfig(bVar2);
                this.f19642h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f68));
            }
            this.k.y(z);
        }
    }
}
