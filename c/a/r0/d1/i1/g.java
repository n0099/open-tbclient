package c.a.r0.d1.i1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.r0.d1.r2.k;
import c.a.r0.y3.i;
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
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public i f15655b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f15656c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f15657d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15658e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15659f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15660g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f15661h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15662i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15663e;

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
            this.f15663e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15663e.f15655b == null || StringUtils.isNull(this.f15663e.f15655b.n())) {
                return;
            }
            if (!c.a.q0.e1.l.b.a(this.f15663e.a, this.f15663e.f15655b.g())) {
                k.b((TbPageContext) j.a(this.f15663e.a), this.f15663e.f15655b.i(), this.f15663e.f15655b.n(), this.f15663e.f15655b.h());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f15663e.f15655b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f15663e.f15655b.getType() != 1) {
                if (this.f15663e.f15655b.getType() == 2) {
                    i2 = 7;
                } else if (this.f15663e.f15655b.getType() == 3) {
                    i2 = 8;
                } else if (this.f15663e.f15655b.getType() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f15663e.f15655b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f15663e.f15656c != null) {
                statisticItem.param("fid", this.f15663e.f15656c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f15663e.f15656c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f15663e.f15656c.getSecond_class());
            }
            if (this.f15663e.f15655b.getType() == 1) {
                statisticItem.param("tid", this.f15663e.f15655b.k());
                statisticItem.param("thread_type", this.f15663e.f15655b.l());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f15663e.f15655b.j(), 1));
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
        this.a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f15656c = forumData;
        this.f15655b = iVar;
        this.f15658e.setText(iVar.m());
        if (iVar.getType() == 3) {
            this.f15660g.setText(this.a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f15655b.f())));
        } else if (iVar.getType() == 1) {
            this.f15660g.setText(this.a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f15655b.f())));
        } else if (iVar.getType() == 2) {
            this.f15660g.setText(this.a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f15655b.f())));
        } else if (iVar.getType() == 4) {
            this.f15660g.setText(this.a.getString(R.string.frs_top_ad_call_app_num, Integer.valueOf(this.f15655b.f())));
        }
        this.f15659f.startLoad(this.f15655b.c(), 10, false);
        i iVar2 = this.f15655b;
        if (iVar2 != null && iVar2.e()) {
            this.f15662i.setVisibility(0);
        } else {
            this.f15662i.setVisibility(8);
        }
        FrsAdCommentScrollView frsAdCommentScrollView = this.f15661h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.bindData(this.f15655b.a());
        }
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f15655b.j(), 0));
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15657d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f15657d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.a.getResources().getDimension(R.dimen.tbds20));
            this.f15658e = (TextView) this.f15657d.findViewById(R.id.frs_top_ad_title);
            this.f15660g = (TextView) this.f15657d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f15657d.findViewById(R.id.frs_top_ad_img);
            this.f15659f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f15661h = (FrsAdCommentScrollView) this.f15657d.findViewById(R.id.ad_comment_scroll_view);
            TextView textView = (TextView) this.f15657d.findViewById(R.id.frs_top_ad_lable_layout);
            this.f15662i = textView;
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(textView);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0602);
            c.a.q0.r.v.c.d(this.f15662i).v(R.color.CAM_X0617);
            this.f15657d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15659f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f15661h) == null) {
            return;
        }
        frsAdCommentScrollView.onDestroy();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f15661h) == null) {
            return;
        }
        frsAdCommentScrollView.onPrimary(z);
    }
}
