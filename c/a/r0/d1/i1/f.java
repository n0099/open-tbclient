package c.a.r0.d1.i1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.q0.a.w;
import c.a.r0.d1.r2.k;
import c.a.r0.y3.i;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes2.dex */
public class f implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15648e;

    /* renamed from: f  reason: collision with root package name */
    public View f15649f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15650g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15651h;

    /* renamed from: i  reason: collision with root package name */
    public RoundLinearLayout f15652i;

    /* renamed from: j  reason: collision with root package name */
    public RoundRelativeLayout f15653j;
    public TextView k;
    public c.a.q0.r.t.a l;
    public i m;
    public ForumData n;
    public View o;
    public LinearLayout p;
    public TBLottieAnimationView q;
    public w r;
    public w.b s;
    public View.OnClickListener t;

    /* loaded from: classes2.dex */
    public class a implements w.b {
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

        @Override // c.a.q0.a.w.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f15654e;

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
            this.f15654e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15654e.f15651h) {
                    if (this.f15654e.l == null || !this.f15654e.l.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.f15654e.l.dismiss();
                    if (this.f15654e.r != null) {
                        this.f15654e.r.c();
                    }
                } else if (view == this.f15654e.f15650g || view == this.f15654e.p) {
                    this.f15654e.g();
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
        this.f15648e = tbPageContext;
    }

    public final void g() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVar = this.m) == null || StringUtils.isNull(iVar.n())) {
            return;
        }
        if (!c.a.q0.e1.l.b.a(this.f15648e.getPageActivity(), this.m.g())) {
            k.b(this.f15648e, this.m.i(), this.m.n(), this.m.h());
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
        httpMessage.addParam("id", this.m.b());
        MessageManager.getInstance().sendMessage(httpMessage);
        this.l.dismiss();
        w wVar = this.r;
        if (wVar != null) {
            wVar.c();
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
            w wVar = new w(this.f15648e.getPageActivity().getBaseContext(), this.s);
            this.r = wVar;
            wVar.k(1.5d);
            this.r.j(2.5d);
            this.r.f();
            View inflate = LayoutInflater.from(this.f15648e.getPageActivity()).inflate(R.layout.frs_shark_dialog_ad_layout, (ViewGroup) null);
            this.f15649f = inflate;
            this.k = (TextView) inflate.findViewById(R.id.fun_ad_lable_icon_layout);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f15649f.findViewById(R.id.round_layout);
            this.f15653j = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.o = this.f15649f.findViewById(R.id.mask_layer);
            LinearLayout linearLayout = (LinearLayout) this.f15649f.findViewById(R.id.shark_layout);
            this.p = linearLayout;
            linearLayout.setOnClickListener(this.t);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f15649f.findViewById(R.id.lottie_shark_view);
            this.q = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.frs_ad_shark);
            this.q.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.f15649f.findViewById(R.id.frs_ad_img);
            this.f15650g = tbImageView;
            tbImageView.setOnClickListener(this.t);
            this.f15650g.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15650g.getLayoutParams();
            int k = n.k(this.f15648e.getPageActivity()) - (this.f15648e.getResources().getDimensionPixelSize(R.dimen.tbds133) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3333333333333333d);
            this.f15650g.setLayoutParams(layoutParams);
            this.o.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f15649f.findViewById(R.id.frs_ad_close);
            this.f15651h = textView;
            textView.setOnClickListener(this.t);
            i iVar = this.m;
            if (iVar != null) {
                this.f15650g.startLoad(iVar.d(), 10, false);
            }
            new c.a.r0.d1.k1.a(this.f15653j, this.q).g();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f15648e.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
            this.f15649f = inflate;
            this.k = (TextView) inflate.findViewById(R.id.fun_ad_lable_icon_layout);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.f15649f.findViewById(R.id.round_layout);
            this.f15652i = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f15649f.findViewById(R.id.frs_ad_img);
            this.f15650g = tbImageView;
            tbImageView.setOnClickListener(this.t);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15650g.getLayoutParams();
            int k = n.k(this.f15648e.getPageActivity()) - (this.f15648e.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.f15650g.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f15649f.findViewById(R.id.frs_ad_close);
            this.f15651h = textView;
            textView.setOnClickListener(this.t);
            i iVar = this.m;
            if (iVar != null) {
                this.f15650g.startLoad(iVar.d(), 10, false);
            }
        }
    }

    public boolean j(c.a.r0.y3.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nVar)) == null) {
            if (nVar == null || nVar.getForum() == null || nVar.getBusinessPromot() == null) {
                return false;
            }
            this.n = nVar.getForum();
            this.m = nVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + nVar.getForum().getId();
            long m = c.a.q0.r.j0.b.k().m(str, 0L);
            if (m < 0 || !TimeHelper.isSameDay(new Date(m), new Date(System.currentTimeMillis()))) {
                c.a.q0.r.j0.b.k().x(str, System.currentTimeMillis());
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
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.f15648e.getPageActivity());
            this.l = aVar;
            aVar.setCancelable(true);
            this.l.setCanceledOnTouchOutside(true);
            this.l.create(this.f15648e).show();
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
                viewGroup.addView(this.f15649f);
            }
            i iVar2 = this.m;
            if (iVar2 != null && iVar2.e()) {
                c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.k);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0602);
                c.a.q0.r.v.c.d(this.k).v(R.color.CAM_X0617);
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
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
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) || (textView = this.k) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, R.color.CAM_X0615, 1);
    }
}
