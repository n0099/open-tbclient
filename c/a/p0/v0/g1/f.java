package c.a.p0.v0.g1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.i3.i;
import c.a.p0.i3.m;
import c.a.p0.v0.n2.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
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
    public TbPageContext f25772a;

    /* renamed from: b  reason: collision with root package name */
    public View f25773b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f25774c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25775d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f25776e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.s.s.a f25777f;

    /* renamed from: g  reason: collision with root package name */
    public i f25778g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f25779h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25780i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f25781e;

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
            this.f25781e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f25781e.f25775d) {
                    if (this.f25781e.f25777f == null || !this.f25781e.f25777f.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.f25781e.f25777f.dismiss();
                } else if (view != this.f25781e.f25774c || this.f25781e.f25778g == null || StringUtils.isNull(this.f25781e.f25778g.l())) {
                } else {
                    h.b(this.f25781e.f25772a, this.f25781e.f25778g.f(), this.f25781e.f25778g.l());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", this.f25781e.f25778g.b());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    this.f25781e.f25777f.dismiss();
                    StatisticItem statisticItem = new StatisticItem("common_click");
                    statisticItem.param("page_type", "a006");
                    statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                    int i2 = 11;
                    if (this.f25781e.f25778g.k() != 1) {
                        if (this.f25781e.f25778g.k() == 2) {
                            i2 = 12;
                        } else if (this.f25781e.f25778g.k() == 3) {
                            i2 = 13;
                        }
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                    statisticItem.param("obj_id", this.f25781e.f25778g.b());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                    statisticItem.param("obj_locate", 3);
                    if (this.f25781e.f25779h != null) {
                        statisticItem.param("fid", this.f25781e.f25779h.getId());
                        statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f25781e.f25779h.getFirst_class());
                        statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f25781e.f25779h.getSecond_class());
                    }
                    if (this.f25781e.f25778g.k() == 1) {
                        statisticItem.param("tid", this.f25781e.f25778g.h());
                        statisticItem.param("thread_type", this.f25781e.f25778g.i());
                    }
                    TiebaStatic.log(statisticItem);
                    c.a.p0.v0.l2.a.a(this.f25781e.f25778g.g());
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
        this.f25780i = new a(this);
        this.f25772a = tbPageContext;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f25772a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
            this.f25773b = inflate;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
            this.f25776e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f25773b.findViewById(R.id.frs_ad_img);
            this.f25774c = tbImageView;
            tbImageView.setOnClickListener(this.f25780i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25774c.getLayoutParams();
            int k = l.k(this.f25772a.getPageActivity()) - (this.f25772a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.f25774c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f25773b.findViewById(R.id.frs_ad_close);
            this.f25775d = textView;
            textView.setOnClickListener(this.f25780i);
            i iVar = this.f25778g;
            if (iVar != null) {
                this.f25774c.startLoad(iVar.d(), 10, false);
            }
        }
    }

    public boolean h(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar)) == null) {
            if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
                return false;
            }
            this.f25779h = mVar.getForum();
            this.f25778g = mVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
            long l = c.a.o0.s.d0.b.j().l(str, 0L);
            if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
                c.a.o0.s.d0.b.j().w(str, System.currentTimeMillis());
                i();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f25772a.getPageActivity());
            this.f25777f = aVar;
            aVar.setCancelable(true);
            this.f25777f.setCanceledOnTouchOutside(true);
            this.f25777f.create(this.f25772a).show();
            View decorView = this.f25777f.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.f25777f.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.f25777f.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.f25773b);
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 11;
            if (this.f25778g.k() != 1) {
                if (this.f25778g.k() == 2) {
                    i2 = 12;
                } else if (this.f25778g.k() == 3) {
                    i2 = 13;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f25778g.b());
            ForumData forumData = this.f25779h;
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f25779h.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f25779h.getSecond_class());
            }
            if (this.f25778g.k() == 1) {
                statisticItem.param("tid", this.f25778g.h());
                statisticItem.param("thread_type", this.f25778g.i());
            }
            TiebaStatic.log(statisticItem);
            c.a.p0.v0.l2.a.b(this.f25778g.g());
        }
    }
}
