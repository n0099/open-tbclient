package c.a.p0.f1.i1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.p0.a4.i;
import c.a.p0.f1.r2.k;
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
    public i f14084b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f14085c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f14086d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14087e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f14088f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14089g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f14090h;
    public TextView i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f14084b == null || StringUtils.isNull(this.a.f14084b.n())) {
                return;
            }
            if (!c.a.o0.e1.l.b.a(this.a.a, this.a.f14084b.g())) {
                k.b((TbPageContext) j.a(this.a.a), this.a.f14084b.i(), this.a.f14084b.n(), this.a.f14084b.h());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.a.f14084b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i = 6;
            if (this.a.f14084b.getType() != 1) {
                if (this.a.f14084b.getType() == 2) {
                    i = 7;
                } else if (this.a.f14084b.getType() == 3) {
                    i = 8;
                } else if (this.a.f14084b.getType() == 4) {
                    i = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", this.a.f14084b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.a.f14085c != null) {
                statisticItem.param("fid", this.a.f14085c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.a.f14085c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.a.f14085c.getSecond_class());
            }
            if (this.a.f14084b.getType() == 1) {
                statisticItem.param("tid", this.a.f14084b.k());
                statisticItem.param("thread_type", this.a.f14084b.l());
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.f14084b.j(), 1));
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f14085c = forumData;
        this.f14084b = iVar;
        this.f14087e.setText(iVar.m());
        if (iVar.getType() == 3) {
            this.f14089g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0738, Integer.valueOf(this.f14084b.f())));
        } else if (iVar.getType() == 1) {
            this.f14089g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f073a, Integer.valueOf(this.f14084b.f())));
        } else if (iVar.getType() == 2) {
            this.f14089g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0736, Integer.valueOf(this.f14084b.f())));
        } else if (iVar.getType() == 4) {
            this.f14089g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0737, Integer.valueOf(this.f14084b.f())));
        }
        this.f14088f.J(this.f14084b.c(), 10, false);
        i iVar2 = this.f14084b;
        if (iVar2 != null && iVar2.e()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        FrsAdCommentScrollView frsAdCommentScrollView = this.f14090h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f14084b.a());
        }
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f14084b.j(), 0));
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14086d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0356, (ViewGroup) null);
            this.f14086d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.a.getResources().getDimension(R.dimen.tbds20));
            this.f14087e = (TextView) this.f14086d.findViewById(R.id.obfuscated_res_0x7f090be9);
            this.f14089g = (TextView) this.f14086d.findViewById(R.id.obfuscated_res_0x7f090bee);
            TbImageView tbImageView = (TbImageView) this.f14086d.findViewById(R.id.obfuscated_res_0x7f090be7);
            this.f14088f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f14090h = (FrsAdCommentScrollView) this.f14086d.findViewById(R.id.obfuscated_res_0x7f090093);
            TextView textView = (TextView) this.f14086d.findViewById(R.id.obfuscated_res_0x7f090be8);
            this.i = textView;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(textView);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0602);
            c.a.o0.r.v.c.d(this.i).v(R.color.CAM_X0617);
            this.f14086d.setOnClickListener(new a(this));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f14088f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f14090h) == null) {
            return;
        }
        frsAdCommentScrollView.o();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f14090h) == null) {
            return;
        }
        frsAdCommentScrollView.p(z);
    }
}
