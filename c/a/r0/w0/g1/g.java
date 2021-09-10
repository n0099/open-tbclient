package c.a.r0.w0.g1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.r0.j3.e0;
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
    public Context f26753a;

    /* renamed from: b  reason: collision with root package name */
    public i f26754b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f26755c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f26756d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26757e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f26758f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26759g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f26760h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26761e;

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
            this.f26761e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26761e.f26754b == null || StringUtils.isNull(this.f26761e.f26754b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(this.f26761e.f26753a), this.f26761e.f26754b.f(), this.f26761e.f26754b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f26761e.f26754b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f26761e.f26754b.k() != 1) {
                if (this.f26761e.f26754b.k() == 2) {
                    i2 = 7;
                } else if (this.f26761e.f26754b.k() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f26761e.f26754b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f26761e.f26755c != null) {
                statisticItem.param("fid", this.f26761e.f26755c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26761e.f26755c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26761e.f26755c.getSecond_class());
            }
            if (this.f26761e.f26754b.k() == 1) {
                statisticItem.param("tid", this.f26761e.f26754b.h());
                statisticItem.param("thread_type", this.f26761e.f26754b.i());
            }
            TiebaStatic.log(statisticItem);
            e0.a((String) ListUtils.getItem(this.f26761e.f26754b.g(), 1));
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
        this.f26753a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f26755c = forumData;
        this.f26754b = iVar;
        this.f26757e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f26759g.setText(this.f26753a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f26754b.e())));
        } else if (iVar.k() == 1) {
            this.f26759g.setText(this.f26753a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f26754b.e())));
        } else if (iVar.k() == 2) {
            this.f26759g.setText(this.f26753a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f26754b.e())));
        }
        this.f26758f.startLoad(this.f26754b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f26760h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.bindData(this.f26754b.a());
        }
        e0.a((String) ListUtils.getItem(this.f26754b.g(), 0));
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26756d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f26753a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f26756d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f26753a.getResources().getDimension(R.dimen.tbds20));
            this.f26757e = (TextView) this.f26756d.findViewById(R.id.frs_top_ad_title);
            this.f26759g = (TextView) this.f26756d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f26756d.findViewById(R.id.frs_top_ad_img);
            this.f26758f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f26760h = (FrsAdCommentScrollView) this.f26756d.findViewById(R.id.ad_comment_scroll_view);
            this.f26756d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f26758f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f26760h) == null) {
            return;
        }
        frsAdCommentScrollView.onDestroy();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f26760h) == null) {
            return;
        }
        frsAdCommentScrollView.onPrimary(z);
    }
}
