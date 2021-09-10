package c.a.r0.w0.g1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.a.x;
import c.a.r0.j3.e0;
import c.a.r0.j3.i;
import c.a.r0.j3.m;
import c.a.r0.w0.n2.h;
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
import com.baidu.tbadk.core.util.StatisticItem;
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
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26741a;

    /* renamed from: b  reason: collision with root package name */
    public View f26742b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f26743c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26744d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f26745e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f26746f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.s.a f26747g;

    /* renamed from: h  reason: collision with root package name */
    public i f26748h;

    /* renamed from: i  reason: collision with root package name */
    public ForumData f26749i;

    /* renamed from: j  reason: collision with root package name */
    public View f26750j;
    public LinearLayout k;
    public TBLottieAnimationView l;
    public x m;
    public x.b n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26751a;

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
            this.f26751a = fVar;
        }

        @Override // c.a.q0.a.x.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26751a.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26752e;

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
            this.f26752e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f26752e.f26744d) {
                    if (this.f26752e.f26747g == null || !this.f26752e.f26747g.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.f26752e.f26747g.dismiss();
                    if (this.f26752e.m != null) {
                        this.f26752e.m.c();
                    }
                } else if (view == this.f26752e.f26743c || view == this.f26752e.k) {
                    this.f26752e.g();
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
        this.n = new a(this);
        this.o = new b(this);
        this.f26741a = tbPageContext;
    }

    public final void g() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVar = this.f26748h) == null || StringUtils.isNull(iVar.l())) {
            return;
        }
        h.b(this.f26741a, this.f26748h.f(), this.f26748h.l());
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
        httpMessage.addParam("id", this.f26748h.b());
        MessageManager.getInstance().sendMessage(httpMessage);
        this.f26747g.dismiss();
        x xVar = this.m;
        if (xVar != null) {
            xVar.c();
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 11;
        if (this.f26748h.k() != 1) {
            if (this.f26748h.k() == 2) {
                i2 = 12;
            } else if (this.f26748h.k() == 3) {
                i2 = 13;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", this.f26748h.b());
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param("obj_locate", 3);
        ForumData forumData = this.f26749i;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26749i.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26749i.getSecond_class());
        }
        if (this.f26748h.k() == 1) {
            statisticItem.param("tid", this.f26748h.h());
            statisticItem.param("thread_type", this.f26748h.i());
        }
        TiebaStatic.log(statisticItem);
        e0.a((String) ListUtils.getItem(this.f26748h.g(), 1));
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x xVar = new x(this.f26741a.getPageActivity().getBaseContext(), this.n);
            this.m = xVar;
            xVar.k(1.5d);
            this.m.j(2.5d);
            this.m.f();
            View inflate = LayoutInflater.from(this.f26741a.getPageActivity()).inflate(R.layout.frs_shark_dialog_ad_layout, (ViewGroup) null);
            this.f26742b = inflate;
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) inflate.findViewById(R.id.round_layout);
            this.f26746f = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.f26750j = this.f26742b.findViewById(R.id.mask_layer);
            LinearLayout linearLayout = (LinearLayout) this.f26742b.findViewById(R.id.shark_layout);
            this.k = linearLayout;
            linearLayout.setOnClickListener(this.o);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f26742b.findViewById(R.id.lottie_shark_view);
            this.l = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.frs_ad_shark);
            this.l.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.f26742b.findViewById(R.id.frs_ad_img);
            this.f26743c = tbImageView;
            tbImageView.setOnClickListener(this.o);
            this.f26743c.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f26743c.getLayoutParams();
            int k = l.k(this.f26741a.getPageActivity()) - (this.f26741a.getResources().getDimensionPixelSize(R.dimen.tbds133) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3333333333333333d);
            this.f26743c.setLayoutParams(layoutParams);
            this.f26750j.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f26742b.findViewById(R.id.frs_ad_close);
            this.f26744d = textView;
            textView.setOnClickListener(this.o);
            i iVar = this.f26748h;
            if (iVar != null) {
                this.f26743c.startLoad(iVar.d(), 10, false);
            }
            new c.a.r0.w0.i1.a(this.f26746f, this.l).g();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f26741a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
            this.f26742b = inflate;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
            this.f26745e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f26742b.findViewById(R.id.frs_ad_img);
            this.f26743c = tbImageView;
            tbImageView.setOnClickListener(this.o);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26743c.getLayoutParams();
            int k = l.k(this.f26741a.getPageActivity()) - (this.f26741a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.f26743c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f26742b.findViewById(R.id.frs_ad_close);
            this.f26744d = textView;
            textView.setOnClickListener(this.o);
            i iVar = this.f26748h;
            if (iVar != null) {
                this.f26743c.startLoad(iVar.d(), 10, false);
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
            this.f26749i = mVar.getForum();
            this.f26748h = mVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
            long l = c.a.q0.s.d0.b.j().l(str, 0L);
            if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
                c.a.q0.s.d0.b.j().w(str, System.currentTimeMillis());
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
            i iVar = this.f26748h;
            if (iVar != null && iVar.m()) {
                h();
            } else {
                i();
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f26741a.getPageActivity());
            this.f26747g = aVar;
            aVar.setCancelable(true);
            this.f26747g.setCanceledOnTouchOutside(true);
            this.f26747g.create(this.f26741a).show();
            View decorView = this.f26747g.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.f26747g.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.f26747g.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.f26742b);
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 11;
            if (this.f26748h.k() != 1) {
                if (this.f26748h.k() == 2) {
                    i2 = 12;
                } else if (this.f26748h.k() == 3) {
                    i2 = 13;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f26748h.b());
            ForumData forumData = this.f26749i;
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26749i.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26749i.getSecond_class());
            }
            if (this.f26748h.k() == 1) {
                statisticItem.param("tid", this.f26748h.h());
                statisticItem.param("thread_type", this.f26748h.i());
            }
            TiebaStatic.log(statisticItem);
            e0.a((String) ListUtils.getItem(this.f26748h.g(), 0));
        }
    }
}
