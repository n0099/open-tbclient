package c.a.t0.d1.r1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.s0.a.x;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.h1;
import c.a.t0.d1.i1;
import c.a.t0.d1.y2.h;
import c.a.t0.w3.i;
import c.a.t0.w3.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.dialog.RoundRelativeLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes7.dex */
public class f implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16810e;

    /* renamed from: f  reason: collision with root package name */
    public View f16811f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16812g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16813h;

    /* renamed from: i  reason: collision with root package name */
    public RoundLinearLayout f16814i;

    /* renamed from: j  reason: collision with root package name */
    public RoundRelativeLayout f16815j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f16816k;
    public c.a.s0.s.s.a l;
    public i m;
    public ForumData n;
    public View o;
    public LinearLayout p;
    public TBLottieAnimationView q;
    public x r;
    public x.b s;
    public View.OnClickListener t;

    /* loaded from: classes7.dex */
    public class a implements x.b {
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

        @Override // c.a.s0.a.x.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f16817e;

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
            this.f16817e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f16817e.f16813h) {
                    if (this.f16817e.l == null || !this.f16817e.l.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.f16817e.l.dismiss();
                    if (this.f16817e.r != null) {
                        this.f16817e.r.c();
                    }
                } else if (view == this.f16817e.f16812g || view == this.f16817e.p) {
                    this.f16817e.g();
                }
            }
        }
    }

    public f(TbPageContext tbPageContext) {
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
        this.s = new a(this);
        this.t = new b(this);
        this.f16810e = tbPageContext;
    }

    public final void g() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVar = this.m) == null || StringUtils.isNull(iVar.n())) {
            return;
        }
        if (!c.a.s0.g1.l.b.a(this.f16810e.getPageActivity(), this.m.g())) {
            h.b(this.f16810e, this.m.i(), this.m.n(), this.m.h());
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
        httpMessage.addParam("id", this.m.b());
        MessageManager.getInstance().sendMessage(httpMessage);
        this.l.dismiss();
        x xVar = this.r;
        if (xVar != null) {
            xVar.c();
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 11;
        if (this.m.getType() != 1) {
            if (this.m.getType() == 2) {
                i2 = 12;
            } else if (this.m.getType() == 3) {
                i2 = 13;
            } else if (this.m.getType() == 4) {
                i2 = 22;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", this.m.b());
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param("obj_locate", 3);
        ForumData forumData = this.n;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.n.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.n.getSecond_class());
        }
        if (this.m.getType() == 1) {
            statisticItem.param("tid", this.m.k());
            statisticItem.param("thread_type", this.m.l());
        }
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.m.j(), 1));
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x xVar = new x(this.f16810e.getPageActivity().getBaseContext(), this.s);
            this.r = xVar;
            xVar.k(1.5d);
            this.r.j(2.5d);
            this.r.f();
            View inflate = LayoutInflater.from(this.f16810e.getPageActivity()).inflate(g1.frs_shark_dialog_ad_layout, (ViewGroup) null);
            this.f16811f = inflate;
            this.f16816k = (TextView) inflate.findViewById(f1.fun_ad_lable_icon_layout);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f16811f.findViewById(f1.round_layout);
            this.f16815j = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.o = this.f16811f.findViewById(f1.mask_layer);
            LinearLayout linearLayout = (LinearLayout) this.f16811f.findViewById(f1.shark_layout);
            this.p = linearLayout;
            linearLayout.setOnClickListener(this.t);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f16811f.findViewById(f1.lottie_shark_view);
            this.q = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(h1.frs_ad_shark);
            this.q.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.f16811f.findViewById(f1.frs_ad_img);
            this.f16812g = tbImageView;
            tbImageView.setOnClickListener(this.t);
            this.f16812g.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16812g.getLayoutParams();
            int k2 = n.k(this.f16810e.getPageActivity()) - (this.f16810e.getResources().getDimensionPixelSize(d1.tbds133) * 2);
            layoutParams.width = k2;
            layoutParams.height = (int) (k2 * 1.3333333333333333d);
            this.f16812g.setLayoutParams(layoutParams);
            this.o.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f16811f.findViewById(f1.frs_ad_close);
            this.f16813h = textView;
            textView.setOnClickListener(this.t);
            i iVar = this.m;
            if (iVar != null) {
                this.f16812g.startLoad(iVar.d(), 10, false);
            }
            new c.a.t0.d1.t1.a(this.f16815j, this.q).g();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f16810e.getPageActivity()).inflate(g1.frs_dialog_ad_layout, (ViewGroup) null);
            this.f16811f = inflate;
            this.f16816k = (TextView) inflate.findViewById(f1.fun_ad_lable_icon_layout);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.f16811f.findViewById(f1.round_layout);
            this.f16814i = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f16811f.findViewById(f1.frs_ad_img);
            this.f16812g = tbImageView;
            tbImageView.setOnClickListener(this.t);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16812g.getLayoutParams();
            int k2 = n.k(this.f16810e.getPageActivity()) - (this.f16810e.getResources().getDimensionPixelSize(d1.tbds44) * 2);
            layoutParams.width = k2;
            layoutParams.height = (int) (k2 * 1.3306452f);
            this.f16812g.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f16811f.findViewById(f1.frs_ad_close);
            this.f16813h = textView;
            textView.setOnClickListener(this.t);
            i iVar = this.m;
            if (iVar != null) {
                this.f16812g.startLoad(iVar.d(), 10, false);
            }
        }
    }

    public boolean j(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mVar)) == null) {
            if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
                return false;
            }
            this.n = mVar.getForum();
            this.m = mVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
            long l = c.a.s0.s.g0.b.j().l(str, 0L);
            if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
                c.a.s0.s.g0.b.j().w(str, System.currentTimeMillis());
                k();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i iVar = this.m;
            if (iVar != null && iVar.o()) {
                h();
            } else {
                i();
            }
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f16810e.getPageActivity());
            this.l = aVar;
            aVar.setCancelable(true);
            this.l.setCanceledOnTouchOutside(true);
            this.l.create(this.f16810e).show();
            View decorView = this.l.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.l.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.l.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.f16811f);
            }
            i iVar2 = this.m;
            if (iVar2 != null && iVar2.e()) {
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f16816k);
                d2.n(i1.J_X01);
                d2.f(c1.CAM_X0602);
                c.a.s0.s.u.c.d(this.f16816k).v(c1.CAM_X0617);
                this.f16816k.setVisibility(0);
            } else {
                this.f16816k.setVisibility(8);
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 11;
            if (this.m.getType() != 1) {
                if (this.m.getType() == 2) {
                    i2 = 12;
                } else if (this.m.getType() == 3) {
                    i2 = 13;
                } else if (this.m.getType() == 4) {
                    i2 = 22;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.m.b());
            ForumData forumData = this.n;
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.n.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.n.getSecond_class());
            }
            if (this.m.getType() == 1) {
                statisticItem.param("tid", this.m.k());
                statisticItem.param("thread_type", this.m.l());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.m.j(), 0));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) || (textView = this.f16816k) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, c1.CAM_X0615, 1);
    }
}
