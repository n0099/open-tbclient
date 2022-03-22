package c.a.p0.f1.i1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.o0.a.x;
import c.a.p0.a4.i;
import c.a.p0.f1.r2.k;
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
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f14077b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f14078c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14079d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f14080e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f14081f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14082g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r.t.a f14083h;
    public i i;
    public ForumData j;
    public View k;
    public LinearLayout l;
    public TBLottieAnimationView m;
    public x n;
    public x.b o;
    public View.OnClickListener p;

    /* loaded from: classes2.dex */
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

        @Override // c.a.o0.a.x.b
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
                if (view == this.a.f14079d) {
                    if (this.a.f14083h == null || !this.a.f14083h.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.a.f14083h.dismiss();
                    if (this.a.n != null) {
                        this.a.n.c();
                    }
                } else if (view == this.a.f14078c || view == this.a.l) {
                    this.a.g();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.a = tbPageContext;
    }

    public final void g() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVar = this.i) == null || StringUtils.isNull(iVar.n())) {
            return;
        }
        if (!c.a.o0.e1.l.b.a(this.a.getPageActivity(), this.i.g())) {
            k.b(this.a, this.i.i(), this.i.n(), this.i.h());
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
        httpMessage.addParam("id", this.i.b());
        MessageManager.getInstance().sendMessage(httpMessage);
        this.f14083h.dismiss();
        x xVar = this.n;
        if (xVar != null) {
            xVar.c();
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i = 11;
        if (this.i.getType() != 1) {
            if (this.i.getType() == 2) {
                i = 12;
            } else if (this.i.getType() == 3) {
                i = 13;
            } else if (this.i.getType() == 4) {
                i = 22;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
        statisticItem.param("obj_id", this.i.b());
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param("obj_locate", 3);
        ForumData forumData = this.j;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.j.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.j.getSecond_class());
        }
        if (this.i.getType() == 1) {
            statisticItem.param("tid", this.i.k());
            statisticItem.param("thread_type", this.i.l());
        }
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.i.j(), 1));
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x xVar = new x(this.a.getPageActivity().getBaseContext(), this.o);
            this.n = xVar;
            xVar.k(1.5d);
            this.n.j(2.5d);
            this.n.f();
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0351, (ViewGroup) null);
            this.f14077b = inflate;
            this.f14082g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c18);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f14077b.findViewById(R.id.obfuscated_res_0x7f091af9);
            this.f14081f = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.k = this.f14077b.findViewById(R.id.obfuscated_res_0x7f0913b1);
            LinearLayout linearLayout = (LinearLayout) this.f14077b.findViewById(R.id.obfuscated_res_0x7f091ceb);
            this.l = linearLayout;
            linearLayout.setOnClickListener(this.p);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f14077b.findViewById(R.id.obfuscated_res_0x7f09134e);
            this.m = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.obfuscated_res_0x7f11000f);
            this.m.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.f14077b.findViewById(R.id.obfuscated_res_0x7f090abf);
            this.f14078c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            this.f14078c.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14078c.getLayoutParams();
            int k = n.k(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds133) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3333333333333333d);
            this.f14078c.setLayoutParams(layoutParams);
            this.k.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f14077b.findViewById(R.id.obfuscated_res_0x7f090abd);
            this.f14079d = textView;
            textView.setOnClickListener(this.p);
            i iVar = this.i;
            if (iVar != null) {
                this.f14078c.J(iVar.d(), 10, false);
            }
            new c.a.p0.f1.k1.a(this.f14081f, this.m).g();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d030b, (ViewGroup) null);
            this.f14077b = inflate;
            this.f14082g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c18);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.f14077b.findViewById(R.id.obfuscated_res_0x7f091af9);
            this.f14080e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f14077b.findViewById(R.id.obfuscated_res_0x7f090abf);
            this.f14078c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14078c.getLayoutParams();
            int k = n.k(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.f14078c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f14077b.findViewById(R.id.obfuscated_res_0x7f090abd);
            this.f14079d = textView;
            textView.setOnClickListener(this.p);
            i iVar = this.i;
            if (iVar != null) {
                this.f14078c.J(iVar.d(), 10, false);
            }
        }
    }

    public boolean j(c.a.p0.a4.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nVar)) == null) {
            if (nVar == null || nVar.getForum() == null || nVar.getBusinessPromot() == null) {
                return false;
            }
            this.j = nVar.getForum();
            this.i = nVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + nVar.getForum().getId();
            long m = c.a.o0.r.j0.b.k().m(str, 0L);
            if (m < 0 || !TimeHelper.isSameDay(new Date(m), new Date(System.currentTimeMillis()))) {
                c.a.o0.r.j0.b.k().x(str, System.currentTimeMillis());
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
            i iVar = this.i;
            if (iVar != null && iVar.o()) {
                h();
            } else {
                i();
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
            this.f14083h = aVar;
            aVar.setCancelable(true);
            this.f14083h.setCanceledOnTouchOutside(true);
            this.f14083h.create(this.a).show();
            View decorView = this.f14083h.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.f14083h.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.f14083h.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.f14077b);
            }
            i iVar2 = this.i;
            if (iVar2 != null && iVar2.e()) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f14082g);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0602);
                c.a.o0.r.v.c.d(this.f14082g).v(R.color.CAM_X0617);
                this.f14082g.setVisibility(0);
            } else {
                this.f14082g.setVisibility(8);
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i = 11;
            if (this.i.getType() != 1) {
                if (this.i.getType() == 2) {
                    i = 12;
                } else if (this.i.getType() == 3) {
                    i = 13;
                } else if (this.i.getType() == 4) {
                    i = 22;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", this.i.b());
            ForumData forumData = this.j;
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.j.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.j.getSecond_class());
            }
            if (this.i.getType() == 1) {
                statisticItem.param("tid", this.i.k());
                statisticItem.param("thread_type", this.i.l());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.i.j(), 0));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) || (textView = this.f14082g) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, R.color.CAM_X0615, 1);
    }
}
