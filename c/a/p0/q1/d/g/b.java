package c.a.p0.q1.d.g;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.a4.i0;
import c.a.p0.q1.d.f.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public d f17213d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17214e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f17215f;

    /* renamed from: g  reason: collision with root package name */
    public i0 f17216g;

    /* renamed from: h  reason: collision with root package name */
    public C1292b f17217h;
    public c.a.o0.r.l0.n.b i;
    public c.a.o0.r.l0.n.b j;
    public TbPageContext<?> k;
    public byte l;
    public TextView m;
    public BarImageView[] n;
    public TextView[] o;
    public TextView[] p;
    public TextView[] q;
    public TextView[] r;
    public TextView[] s;
    public FollowUserButton[] t;
    public final int[] u;
    public final int[] v;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.q1.d.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1292b extends e implements i0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d.a a;

        /* renamed from: b  reason: collision with root package name */
        public FollowUserButton f17218b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f17219c;

        public C1292b(b bVar) {
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
            this.f17219c = bVar;
        }

        @Override // c.a.p0.a4.i0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.f17219c.f17214e = false;
            }
        }

        @Override // c.a.p0.a4.i0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f17219c.f17214e = false;
                this.f17219c.o(this.f17218b, false);
                this.a.n(false);
            }
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.f17219c.f17214e = false;
                if (this.f17219c.f17215f.getErrorCode() == 22) {
                    n.N(this.f17219c.k.getPageActivity(), this.f17219c.k.getString(R.string.obfuscated_res_0x7f0f0802));
                } else if (obj == null) {
                } else {
                    if (this.f17219c.f17215f.getErrorCode() != 0) {
                        n.N(this.f17219c.k.getPageActivity(), this.f17219c.f17215f.getErrorString());
                        return;
                    }
                    this.f17219c.o(this.f17218b, true);
                    this.a.n(true);
                }
            }
        }

        public void d(FollowUserButton followUserButton, d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, followUserButton, aVar) == null) {
                this.a = aVar;
                this.f17218b = followUserButton;
            }
        }

        public /* synthetic */ C1292b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17214e = false;
        this.i = new c.a.o0.r.l0.n.b();
        this.j = new c.a.o0.r.l0.n.b();
        this.n = new BarImageView[3];
        this.o = new TextView[3];
        this.p = new TextView[3];
        this.q = new TextView[3];
        this.r = new TextView[3];
        this.s = new TextView[3];
        this.t = new FollowUserButton[3];
        this.u = new int[]{R.id.obfuscated_res_0x7f0919f3, R.id.obfuscated_res_0x7f0919f4, R.id.obfuscated_res_0x7f0919f5};
        this.v = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.k = tbPageContext;
        this.l = b2;
        k(view);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void c(c.a.d.o.e.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof d)) {
            d dVar = (d) nVar;
            this.f17213d = dVar;
            this.m.setText(dVar.a);
            for (int i = 0; i < 3; i++) {
                this.n[i].J(this.f17213d.f17205d[i].b(), 10, false);
                this.p[i].setText(this.f17213d.f17205d[i].e());
                this.s[i].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3e, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f17213d.f17205d[i].f())}));
                this.r[i].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3c, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f17213d.f17205d[i].a())}));
                this.t[i].setTag(Integer.valueOf(i));
                o(this.t[i], this.f17213d.f17205d[i].m());
                this.o[i].setVisibility(this.f17213d.f17203b ? 0 : 8);
                ((LinearLayout.LayoutParams) this.p[i].getLayoutParams()).leftMargin = n.f(this.k.getPageActivity(), this.f17213d.f17203b ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.f17213d.f17205d[i].k())) {
                    this.q[i].setText(this.f17213d.f17205d[i].k());
                } else if (!StringUtils.isNull(this.f17213d.f17205d[i].i()) && UbsABTestHelper.isRecommendBarHotText()) {
                    this.q[i].setText(this.f17213d.f17205d[i].i());
                } else {
                    this.q[i].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3d));
                }
            }
        }
    }

    public final void h(d.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, followUserButton) == null) || this.f17214e) {
            return;
        }
        if (!n.C()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0c15));
        } else if (aVar == null || StringUtils.isNull(aVar.e()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.f17217h == null) {
                this.f17217h = new C1292b(this, null);
            }
            if (this.f17215f == null) {
                LikeModel likeModel = new LikeModel(this.k);
                this.f17215f = likeModel;
                likeModel.setLoadDataCallBack(this.f17217h);
            }
            this.f17217h.d(followUserButton, aVar);
            if (m.isForumName(aVar.e())) {
                this.f17214e = true;
                this.f17215f.L();
                this.f17215f.P(aVar.e(), String.valueOf(aVar.g()));
            }
        }
    }

    public final void i(d.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, followUserButton) == null) || this.f17214e) {
            return;
        }
        if (!n.C()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0c15));
        } else if (aVar == null || StringUtils.isNull(aVar.e()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.f17217h == null) {
                this.f17217h = new C1292b(this, null);
            }
            if (this.f17216g == null) {
                i0 i0Var = new i0();
                this.f17216g = i0Var;
                i0Var.b(this.f17217h);
            }
            this.f17217h.d(followUserButton, aVar);
            this.f17214e = true;
            this.f17216g.c(aVar.e(), aVar.g());
        }
    }

    public d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17213d : (d) invokeV.objValue;
    }

    public final void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919f6);
            this.i.t(R.color.CAM_X0109);
            this.i.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.r(R.color.CAM_X0304);
            this.j.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            int i = 0;
            while (i < 3) {
                View findViewById = view.findViewById(this.u[i]);
                findViewById.setTag(Integer.valueOf(i));
                findViewById.setOnClickListener(this);
                this.n[i] = (BarImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f0919f2);
                this.o[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0919fc);
                this.p[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0919f8);
                this.q[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0919f1);
                this.r[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0919ef);
                this.s[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0919fa);
                this.t[i] = (FollowUserButton) findViewById.findViewById(R.id.obfuscated_res_0x7f0919ee);
                this.t[i].setOnClickListener(this);
                int i2 = i + 1;
                this.o[i].setText(String.valueOf(i2));
                this.n[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.n[i].setShowInnerBorder(true);
                this.n[i].setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.n[i].setShowOval(true);
                this.n[i].setPlaceHolder(2);
                this.n[i].setShowOuterBorder(false);
                this.n[i].setStrokeColorResId(R.color.CAM_X0401);
                i = i2;
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.o[i2].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.o[i2], (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.v[i2]).cornerRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.o[i2]);
            }
            this.t[i2].r(i);
            SkinManager.setViewTextColor(this.p[i2], (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s[i2], (int) R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.m.setVisibility(z ? 0 : 8);
        }
    }

    public void n(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.f17213d == null) {
            return;
        }
        if (z) {
            o(this.t[i], true);
            this.f17213d.f17205d[i].n(true);
            return;
        }
        o(this.t[i], false);
        this.f17213d.f17205d[i].n(false);
    }

    public final void o(FollowUserButton followUserButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, followUserButton, z) == null) || followUserButton == null) {
            return;
        }
        followUserButton.setConfig(z ? this.i : this.j);
        followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.obfuscated_res_0x7f0f0627 : R.string.obfuscated_res_0x7f0f029b));
        followUserButton.r(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || this.f17213d == null || view == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        d.a aVar = this.f17213d.f17205d[intValue];
        if (view instanceof TBSpecificationBtn) {
            if (aVar.m()) {
                i(aVar, this.t[intValue]);
                return;
            }
            h(aVar, this.t[intValue]);
            StatisticItem param = new StatisticItem("c13644").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
            if (!StringUtils.isNull(this.f17213d.a)) {
                param = param.param("obj_name", this.f17213d.a);
            }
            TiebaStatic.log(param);
        } else if (id == R.id.obfuscated_res_0x7f0919f3 || id == R.id.obfuscated_res_0x7f0919f4 || id == R.id.obfuscated_res_0x7f0919f5) {
            FrsActivityConfig callFrom = new FrsActivityConfig(this.k.getPageActivity()).createNormalCfg(aVar.e(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
            if (UbsABTestHelper.isRecommendBarHotText()) {
                Intent intent = callFrom.getIntent();
                if (aVar.j() != 0 && intent != null) {
                    intent.putExtra("transition_type", 0);
                    intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.j());
                }
            }
            this.k.sendMessage(new CustomMessage(2003000, callFrom));
            StatisticItem param2 = new StatisticItem("c13988").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
            if (!StringUtils.isNull(this.f17213d.a)) {
                param2 = param2.param("obj_name", this.f17213d.a);
            }
            TiebaStatic.log(param2);
        }
    }
}
