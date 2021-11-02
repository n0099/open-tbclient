package b.a.r0.x0.q1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.r0.l3.i;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import b.a.r0.x0.x2.h;
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

    /* renamed from: a  reason: collision with root package name */
    public Context f26208a;

    /* renamed from: b  reason: collision with root package name */
    public i f26209b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f26210c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f26211d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26212e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f26213f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26214g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f26215h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26216i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26217e;

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
            this.f26217e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26217e.f26209b == null || StringUtils.isNull(this.f26217e.f26209b.n())) {
                return;
            }
            if (!b.a.q0.f1.l.b.a(this.f26217e.f26208a, this.f26217e.f26209b.g())) {
                h.b((TbPageContext) j.a(this.f26217e.f26208a), this.f26217e.f26209b.i(), this.f26217e.f26209b.n(), this.f26217e.f26209b.h());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f26217e.f26209b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f26217e.f26209b.getType() != 1) {
                if (this.f26217e.f26209b.getType() == 2) {
                    i2 = 7;
                } else if (this.f26217e.f26209b.getType() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f26217e.f26209b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f26217e.f26210c != null) {
                statisticItem.param("fid", this.f26217e.f26210c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26217e.f26210c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26217e.f26210c.getSecond_class());
            }
            if (this.f26217e.f26209b.getType() == 1) {
                statisticItem.param("tid", this.f26217e.f26209b.k());
                statisticItem.param("thread_type", this.f26217e.f26209b.l());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f26217e.f26209b.j(), 1));
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
        this.f26208a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f26210c = forumData;
        this.f26209b = iVar;
        this.f26212e.setText(iVar.m());
        if (iVar.getType() == 3) {
            this.f26214g.setText(this.f26208a.getString(h1.frs_top_ad_download_num, Integer.valueOf(this.f26209b.f())));
        } else if (iVar.getType() == 1) {
            this.f26214g.setText(this.f26208a.getString(h1.frs_top_ad_person_num, Integer.valueOf(this.f26209b.f())));
        } else if (iVar.getType() == 2) {
            this.f26214g.setText(this.f26208a.getString(h1.frs_top_ad_appointment_num, Integer.valueOf(this.f26209b.f())));
        }
        this.f26213f.startLoad(this.f26209b.c(), 10, false);
        i iVar2 = this.f26209b;
        if (iVar2 != null && iVar2.e()) {
            this.f26216i.setVisibility(0);
        } else {
            this.f26216i.setVisibility(8);
        }
        FrsAdCommentScrollView frsAdCommentScrollView = this.f26215h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.bindData(this.f26209b.a());
        }
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f26209b.j(), 0));
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26211d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f26208a).inflate(f1.frs_top_ad_view, (ViewGroup) null);
            this.f26211d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f26208a.getResources().getDimension(c1.tbds20));
            this.f26212e = (TextView) this.f26211d.findViewById(e1.frs_top_ad_title);
            this.f26214g = (TextView) this.f26211d.findViewById(e1.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f26211d.findViewById(e1.frs_top_ad_img);
            this.f26213f = tbImageView;
            tbImageView.setDefaultBgResource(b1.white_alpha100);
            this.f26215h = (FrsAdCommentScrollView) this.f26211d.findViewById(e1.ad_comment_scroll_view);
            TextView textView = (TextView) this.f26211d.findViewById(e1.frs_top_ad_lable_layout);
            this.f26216i = textView;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(textView);
            d2.n(h1.J_X01);
            d2.f(b1.CAM_X0602);
            b.a.q0.s.u.c.d(this.f26216i).v(b1.CAM_X0617);
            this.f26211d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f26213f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f26215h) == null) {
            return;
        }
        frsAdCommentScrollView.onDestroy();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f26215h) == null) {
            return;
        }
        frsAdCommentScrollView.onPrimary(z);
    }
}
