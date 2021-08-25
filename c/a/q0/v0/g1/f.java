package c.a.q0.v0.g1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.i3.e0;
import c.a.q0.i3.i;
import c.a.q0.i3.m;
import c.a.q0.v0.m2.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
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
    public TbPageContext f26108a;

    /* renamed from: b  reason: collision with root package name */
    public View f26109b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f26110c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26111d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f26112e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.s.s.a f26113f;

    /* renamed from: g  reason: collision with root package name */
    public i f26114g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f26115h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f26116i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26117e;

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
            this.f26117e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f26117e.f26111d) {
                    if (this.f26117e.f26113f == null || !this.f26117e.f26113f.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.f26117e.f26113f.dismiss();
                } else if (view != this.f26117e.f26110c || this.f26117e.f26114g == null || StringUtils.isNull(this.f26117e.f26114g.l())) {
                } else {
                    h.b(this.f26117e.f26108a, this.f26117e.f26114g.f(), this.f26117e.f26114g.l());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", this.f26117e.f26114g.b());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    this.f26117e.f26113f.dismiss();
                    StatisticItem statisticItem = new StatisticItem("common_click");
                    statisticItem.param("page_type", "a006");
                    statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                    int i2 = 11;
                    if (this.f26117e.f26114g.k() != 1) {
                        if (this.f26117e.f26114g.k() == 2) {
                            i2 = 12;
                        } else if (this.f26117e.f26114g.k() == 3) {
                            i2 = 13;
                        }
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                    statisticItem.param("obj_id", this.f26117e.f26114g.b());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                    statisticItem.param("obj_locate", 3);
                    if (this.f26117e.f26115h != null) {
                        statisticItem.param("fid", this.f26117e.f26115h.getId());
                        statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26117e.f26115h.getFirst_class());
                        statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26117e.f26115h.getSecond_class());
                    }
                    if (this.f26117e.f26114g.k() == 1) {
                        statisticItem.param("tid", this.f26117e.f26114g.h());
                        statisticItem.param("thread_type", this.f26117e.f26114g.i());
                    }
                    TiebaStatic.log(statisticItem);
                    e0.a((String) ListUtils.getItem(this.f26117e.f26114g.g(), 1));
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
        this.f26116i = new a(this);
        this.f26108a = tbPageContext;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f26108a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
            this.f26109b = inflate;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
            this.f26112e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f26109b.findViewById(R.id.frs_ad_img);
            this.f26110c = tbImageView;
            tbImageView.setOnClickListener(this.f26116i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26110c.getLayoutParams();
            int k = l.k(this.f26108a.getPageActivity()) - (this.f26108a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.f26110c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f26109b.findViewById(R.id.frs_ad_close);
            this.f26111d = textView;
            textView.setOnClickListener(this.f26116i);
            i iVar = this.f26114g;
            if (iVar != null) {
                this.f26110c.startLoad(iVar.d(), 10, false);
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
            this.f26115h = mVar.getForum();
            this.f26114g = mVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
            long l = c.a.p0.s.d0.b.j().l(str, 0L);
            if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
                c.a.p0.s.d0.b.j().w(str, System.currentTimeMillis());
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
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f26108a.getPageActivity());
            this.f26113f = aVar;
            aVar.setCancelable(true);
            this.f26113f.setCanceledOnTouchOutside(true);
            this.f26113f.create(this.f26108a).show();
            View decorView = this.f26113f.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.f26113f.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.f26113f.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.f26109b);
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 11;
            if (this.f26114g.k() != 1) {
                if (this.f26114g.k() == 2) {
                    i2 = 12;
                } else if (this.f26114g.k() == 3) {
                    i2 = 13;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f26114g.b());
            ForumData forumData = this.f26115h;
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f26115h.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f26115h.getSecond_class());
            }
            if (this.f26114g.k() == 1) {
                statisticItem.param("tid", this.f26114g.h());
                statisticItem.param("thread_type", this.f26114g.i());
            }
            TiebaStatic.log(statisticItem);
            e0.a((String) ListUtils.getItem(this.f26114g.g(), 0));
        }
    }
}
