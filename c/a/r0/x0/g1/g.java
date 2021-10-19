package c.a.r0.x0.g1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.r0.k3.i;
import c.a.r0.x0.n2.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad.FrsAdCommentScrollView;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26947a;

    /* renamed from: b  reason: collision with root package name */
    public i f26948b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f26949c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f26950d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26951e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f26952f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26953g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f26954h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26955i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26956e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26956e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26956e.f26948b == null || StringUtils.isNull(this.f26956e.f26948b.n())) {
                return;
            }
            h.b((TbPageContext) j.a(this.f26956e.f26947a), this.f26956e.f26948b.h(), this.f26956e.f26948b.n(), this.f26956e.f26948b.g());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f26956e.f26948b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f26956e.f26948b.m() != 1) {
                if (this.f26956e.f26948b.m() == 2) {
                    i2 = 7;
                } else if (this.f26956e.f26948b.m() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f26956e.f26948b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f26956e.f26949c != null) {
                statisticItem.param("fid", this.f26956e.f26949c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26956e.f26949c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26956e.f26949c.getSecond_class());
            }
            if (this.f26956e.f26948b.m() == 1) {
                statisticItem.param("tid", this.f26956e.f26948b.j());
                statisticItem.param("thread_type", this.f26956e.f26948b.k());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f26956e.f26948b.i(), 1));
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26947a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f26949c = forumData;
        this.f26948b = iVar;
        this.f26951e.setText(iVar.l());
        if (iVar.m() == 3) {
            this.f26953g.setText(this.f26947a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f26948b.f())));
        } else if (iVar.m() == 1) {
            this.f26953g.setText(this.f26947a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f26948b.f())));
        } else if (iVar.m() == 2) {
            this.f26953g.setText(this.f26947a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f26948b.f())));
        }
        this.f26952f.startLoad(this.f26948b.c(), 10, false);
        i iVar2 = this.f26948b;
        if (iVar2 != null && iVar2.e()) {
            this.f26955i.setVisibility(0);
        } else {
            this.f26955i.setVisibility(8);
        }
        FrsAdCommentScrollView frsAdCommentScrollView = this.f26954h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.bindData(this.f26948b.a());
        }
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f26948b.i(), 0));
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26950d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f26947a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f26950d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f26947a.getResources().getDimension(R.dimen.tbds20));
            this.f26951e = (TextView) this.f26950d.findViewById(R.id.frs_top_ad_title);
            this.f26953g = (TextView) this.f26950d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f26950d.findViewById(R.id.frs_top_ad_img);
            this.f26952f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f26954h = (FrsAdCommentScrollView) this.f26950d.findViewById(R.id.ad_comment_scroll_view);
            TextView textView = (TextView) this.f26950d.findViewById(R.id.frs_top_ad_lable_layout);
            this.f26955i = textView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0602);
            c.a.q0.s.u.c.d(this.f26955i).v(R.color.CAM_X0617);
            this.f26950d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f26952f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f26954h) == null) {
            return;
        }
        frsAdCommentScrollView.onDestroy();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f26954h) == null) {
            return;
        }
        frsAdCommentScrollView.onPrimary(z);
    }
}
