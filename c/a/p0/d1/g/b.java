package c.a.p0.d1.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.a4.i0;
import c.a.p0.h0.b0;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tieba.forumSquare.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.p0.h0.b<c.a.p0.d1.f.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public BarImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TBSpecificationBtn o;
    public String p;
    public String q;
    public c.a.p0.d1.f.a r;
    public LikeModel s;
    public i0 t;
    public boolean u;

    /* loaded from: classes2.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.u = false;
                if (this.a.s.getErrorCode() == 22) {
                    n.N(this.a.f15304b.getPageActivity(), this.a.f15304b.getString(R.string.obfuscated_res_0x7f0f0802));
                } else if (obj == null) {
                } else {
                    if (this.a.s.getErrorCode() != 0) {
                        n.N(this.a.f15304b.getPageActivity(), this.a.s.getErrorString());
                    } else {
                        this.a.x(true);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.p0.d1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1030b implements i0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1030b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.a4.i0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.u = false;
            }
        }

        @Override // c.a.p0.a4.i0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.u = false;
                this.a.x(false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.p = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0668);
        this.q = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f066c);
        View k = k();
        this.i = k;
        this.j = (BarImageView) k.findViewById(R.id.obfuscated_res_0x7f09030e);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09031c);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090777);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0913e5);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0918cc);
        this.o = (TBSpecificationBtn) k.findViewById(R.id.obfuscated_res_0x7f090a5a);
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d079b : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.o.k();
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.r == null) {
            return;
        }
        if (this.i == view) {
            v();
            b0<T> b0Var = this.f15307e;
            if (b0Var != 0) {
                b0Var.a(view, this.r);
            }
        } else if (this.o == view) {
            if (this.f15304b.getPageActivity() instanceof ForumSquareActivity) {
                String i = ((ForumSquareActivity) this.f15304b.getPageActivity()).getDelegate().i();
                if (!"推荐".equals(i)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, i);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.r.a);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.r.q() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.r.q()) {
                u();
            } else {
                t();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.u) {
            return;
        }
        if (!n.C()) {
            UtilHelper.showToast(this.f15304b.getPageActivity(), this.f15304b.getString(R.string.obfuscated_res_0x7f0f0c15));
            return;
        }
        c.a.p0.d1.f.a aVar = this.r;
        if (aVar == null || StringUtils.isNull(aVar.i()) || this.r.g() <= 0 || !ViewHelper.checkUpIsLogin(this.f15304b.getPageActivity())) {
            return;
        }
        if (this.s == null) {
            LikeModel likeModel = new LikeModel(this.f15304b);
            this.s = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (m.isForumName(this.r.i())) {
            this.u = true;
            this.s.L();
            this.s.P(this.r.i(), String.valueOf(this.r.g()));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.u) {
            return;
        }
        if (!n.C()) {
            UtilHelper.showToast(this.f15304b.getPageActivity(), this.f15304b.getString(R.string.obfuscated_res_0x7f0f0c15));
            return;
        }
        c.a.p0.d1.f.a aVar = this.r;
        if (aVar == null || StringUtils.isNull(aVar.i()) || this.r.g() <= 0 || !ViewHelper.checkUpIsLogin(this.f15304b.getPageActivity())) {
            return;
        }
        if (this.t == null) {
            i0 i0Var = new i0();
            this.t = i0Var;
            i0Var.b(new C1030b(this));
        }
        this.u = true;
        this.t.c(this.r.i(), this.r.g());
    }

    public final void v() {
        c.a.p0.d1.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.r) == null) {
            return;
        }
        String i = aVar.i();
        if (m.isForumName(i)) {
            this.f15304b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15304b.getPageActivity()).createNormalCfg(i, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: w */
    public void l(c.a.p0.d1.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null) {
            return;
        }
        this.r = aVar;
        this.j.setShowOval(true);
        this.j.setShowOuterBorder(false);
        this.j.setShowInnerBorder(true);
        this.j.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.j.setStrokeColorResId(R.color.CAM_X0401);
        this.j.J(aVar.e(), 10, false);
        String i = aVar.i();
        if (m.isEmpty(i)) {
            i = "";
        }
        this.k.setText(i);
        this.m.setText(this.p + " " + StringHelper.numberUniformFormatExtra(aVar.k()));
        this.n.setText(this.q + " " + StringHelper.numberUniformFormatExtra((long) aVar.m()));
        y(aVar.getRecomReason());
        x(this.r.q());
        this.i.setOnClickListener(this);
        this.o.setOnClickListener(this);
        m(this.f15304b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (!z) {
                c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.o.setConfig(bVar);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0651));
            } else {
                c.a.o0.r.l0.n.b bVar2 = new c.a.o0.r.l0.n.b();
                bVar2.t(R.color.CAM_X0109);
                this.o.setConfig(bVar2);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0664));
            }
            this.r.s(z);
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (m.isEmpty(str)) {
                if (this.l.getVisibility() != 8) {
                    this.l.setVisibility(8);
                    if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = n.f(this.f15304b.getPageActivity(), R.dimen.tbds47);
                        this.k.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.l.getVisibility() != 0) {
                this.l.setVisibility(0);
                if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = n.f(this.f15304b.getPageActivity(), R.dimen.tbds24);
                    this.k.requestLayout();
                }
            }
            this.l.setText(str);
        }
    }
}
