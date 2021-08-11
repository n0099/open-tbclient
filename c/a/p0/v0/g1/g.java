package c.a.p0.v0.g1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.p0.i3.i;
import c.a.p0.v0.n2.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
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
    public Context f25782a;

    /* renamed from: b  reason: collision with root package name */
    public i f25783b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f25784c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f25785d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25786e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f25787f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25788g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f25789h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f25790e;

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
            this.f25790e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25790e.f25783b == null || StringUtils.isNull(this.f25790e.f25783b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(this.f25790e.f25782a), this.f25790e.f25783b.f(), this.f25790e.f25783b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f25790e.f25783b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f25790e.f25783b.k() != 1) {
                if (this.f25790e.f25783b.k() == 2) {
                    i2 = 7;
                } else if (this.f25790e.f25783b.k() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f25790e.f25783b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f25790e.f25784c != null) {
                statisticItem.param("fid", this.f25790e.f25784c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f25790e.f25784c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f25790e.f25784c.getSecond_class());
            }
            if (this.f25790e.f25783b.k() == 1) {
                statisticItem.param("tid", this.f25790e.f25783b.h());
                statisticItem.param("thread_type", this.f25790e.f25783b.i());
            }
            TiebaStatic.log(statisticItem);
            c.a.p0.v0.l2.a.a(this.f25790e.f25783b.g());
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
        this.f25782a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f25784c = forumData;
        this.f25783b = iVar;
        this.f25786e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f25788g.setText(this.f25782a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f25783b.e())));
        } else if (iVar.k() == 1) {
            this.f25788g.setText(this.f25782a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f25783b.e())));
        } else if (iVar.k() == 2) {
            this.f25788g.setText(this.f25782a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f25783b.e())));
        }
        this.f25787f.startLoad(this.f25783b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f25789h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.bindData(this.f25783b.a());
        }
        c.a.p0.v0.l2.a.b(this.f25783b.g());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25785d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f25782a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f25785d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f25782a.getResources().getDimension(R.dimen.tbds20));
            this.f25786e = (TextView) this.f25785d.findViewById(R.id.frs_top_ad_title);
            this.f25788g = (TextView) this.f25785d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f25785d.findViewById(R.id.frs_top_ad_img);
            this.f25787f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f25789h = (FrsAdCommentScrollView) this.f25785d.findViewById(R.id.ad_comment_scroll_view);
            this.f25785d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f25787f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f25789h) == null) {
            return;
        }
        frsAdCommentScrollView.onDestroy();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f25789h) == null) {
            return;
        }
        frsAdCommentScrollView.onPrimary(z);
    }
}
