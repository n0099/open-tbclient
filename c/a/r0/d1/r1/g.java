package c.a.r0.d1.r1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import c.a.r0.d1.y2.h;
import c.a.r0.t3.i;
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
import com.baidu.tieba.frs.ad.FrsAdCommentScrollView;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public i f15913b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f15914c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f15915d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15916e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15917f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15918g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f15919h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15920i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15921e;

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
            this.f15921e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15921e.f15913b == null || StringUtils.isNull(this.f15921e.f15913b.n())) {
                return;
            }
            if (!c.a.q0.f1.l.b.a(this.f15921e.a, this.f15921e.f15913b.g())) {
                h.b((TbPageContext) j.a(this.f15921e.a), this.f15921e.f15913b.i(), this.f15921e.f15913b.n(), this.f15921e.f15913b.h());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f15921e.f15913b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f15921e.f15913b.getType() != 1) {
                if (this.f15921e.f15913b.getType() == 2) {
                    i2 = 7;
                } else if (this.f15921e.f15913b.getType() == 3) {
                    i2 = 8;
                } else if (this.f15921e.f15913b.getType() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f15921e.f15913b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f15921e.f15914c != null) {
                statisticItem.param("fid", this.f15921e.f15914c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f15921e.f15914c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f15921e.f15914c.getSecond_class());
            }
            if (this.f15921e.f15913b.getType() == 1) {
                statisticItem.param("tid", this.f15921e.f15913b.k());
                statisticItem.param("thread_type", this.f15921e.f15913b.l());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f15921e.f15913b.j(), 1));
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
        this.f15914c = forumData;
        this.f15913b = iVar;
        this.f15916e.setText(iVar.m());
        if (iVar.getType() == 3) {
            this.f15918g.setText(this.a.getString(i1.frs_top_ad_download_num, Integer.valueOf(this.f15913b.f())));
        } else if (iVar.getType() == 1) {
            this.f15918g.setText(this.a.getString(i1.frs_top_ad_person_num, Integer.valueOf(this.f15913b.f())));
        } else if (iVar.getType() == 2) {
            this.f15918g.setText(this.a.getString(i1.frs_top_ad_appointment_num, Integer.valueOf(this.f15913b.f())));
        } else if (iVar.getType() == 4) {
            this.f15918g.setText(this.a.getString(i1.frs_top_ad_call_app_num, Integer.valueOf(this.f15913b.f())));
        }
        this.f15917f.startLoad(this.f15913b.c(), 10, false);
        i iVar2 = this.f15913b;
        if (iVar2 != null && iVar2.e()) {
            this.f15920i.setVisibility(0);
        } else {
            this.f15920i.setVisibility(8);
        }
        FrsAdCommentScrollView frsAdCommentScrollView = this.f15919h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.bindData(this.f15913b.a());
        }
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f15913b.j(), 0));
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15915d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.a).inflate(g1.frs_top_ad_view, (ViewGroup) null);
            this.f15915d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.a.getResources().getDimension(d1.tbds20));
            this.f15916e = (TextView) this.f15915d.findViewById(f1.frs_top_ad_title);
            this.f15918g = (TextView) this.f15915d.findViewById(f1.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f15915d.findViewById(f1.frs_top_ad_img);
            this.f15917f = tbImageView;
            tbImageView.setDefaultBgResource(c1.white_alpha100);
            this.f15919h = (FrsAdCommentScrollView) this.f15915d.findViewById(f1.ad_comment_scroll_view);
            TextView textView = (TextView) this.f15915d.findViewById(f1.frs_top_ad_lable_layout);
            this.f15920i = textView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.n(i1.J_X01);
            d2.f(c1.CAM_X0602);
            c.a.q0.s.u.c.d(this.f15920i).v(c1.CAM_X0617);
            this.f15915d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15917f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f15919h) == null) {
            return;
        }
        frsAdCommentScrollView.onDestroy();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f15919h) == null) {
            return;
        }
        frsAdCommentScrollView.onPrimary(z);
    }
}
