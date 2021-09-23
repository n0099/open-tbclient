package c.a.r0.w0.g1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.r0.j3.i;
import c.a.r0.w0.n2.h;
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
    public Context f26772a;

    /* renamed from: b  reason: collision with root package name */
    public i f26773b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f26774c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f26775d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26776e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f26777f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26778g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f26779h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26780i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26781e;

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
            this.f26781e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26781e.f26773b == null || StringUtils.isNull(this.f26781e.f26773b.m())) {
                return;
            }
            h.b((TbPageContext) j.a(this.f26781e.f26772a), this.f26781e.f26773b.g(), this.f26781e.f26773b.m());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f26781e.f26773b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f26781e.f26773b.l() != 1) {
                if (this.f26781e.f26773b.l() == 2) {
                    i2 = 7;
                } else if (this.f26781e.f26773b.l() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f26781e.f26773b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f26781e.f26774c != null) {
                statisticItem.param("fid", this.f26781e.f26774c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26781e.f26774c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26781e.f26774c.getSecond_class());
            }
            if (this.f26781e.f26773b.l() == 1) {
                statisticItem.param("tid", this.f26781e.f26773b.i());
                statisticItem.param("thread_type", this.f26781e.f26773b.j());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f26781e.f26773b.h(), 1));
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
        this.f26772a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f26774c = forumData;
        this.f26773b = iVar;
        this.f26776e.setText(iVar.k());
        if (iVar.l() == 3) {
            this.f26778g.setText(this.f26772a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f26773b.f())));
        } else if (iVar.l() == 1) {
            this.f26778g.setText(this.f26772a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f26773b.f())));
        } else if (iVar.l() == 2) {
            this.f26778g.setText(this.f26772a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f26773b.f())));
        }
        this.f26777f.startLoad(this.f26773b.c(), 10, false);
        i iVar2 = this.f26773b;
        if (iVar2 != null && iVar2.e()) {
            this.f26780i.setVisibility(0);
        } else {
            this.f26780i.setVisibility(8);
        }
        FrsAdCommentScrollView frsAdCommentScrollView = this.f26779h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.bindData(this.f26773b.a());
        }
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f26773b.h(), 0));
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26775d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f26772a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f26775d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f26772a.getResources().getDimension(R.dimen.tbds20));
            this.f26776e = (TextView) this.f26775d.findViewById(R.id.frs_top_ad_title);
            this.f26778g = (TextView) this.f26775d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f26775d.findViewById(R.id.frs_top_ad_img);
            this.f26777f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f26779h = (FrsAdCommentScrollView) this.f26775d.findViewById(R.id.ad_comment_scroll_view);
            TextView textView = (TextView) this.f26775d.findViewById(R.id.frs_top_ad_lable_layout);
            this.f26780i = textView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0602);
            c.a.q0.s.u.c.d(this.f26780i).w(R.color.CAM_X0617);
            this.f26775d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f26777f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f26779h) == null) {
            return;
        }
        frsAdCommentScrollView.onDestroy();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f26779h) == null) {
            return;
        }
        frsAdCommentScrollView.onPrimary(z);
    }
}
