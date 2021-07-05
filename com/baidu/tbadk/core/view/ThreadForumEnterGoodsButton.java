package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.r.u.c;
import d.a.s0.u0.k2.e;
/* loaded from: classes4.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b2 f12557e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12558f;

    /* renamed from: g  reason: collision with root package name */
    public View f12559g;

    /* renamed from: h  reason: collision with root package name */
    public int f12560h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12561i;
    public Drawable j;
    public View.OnClickListener k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12560h = 0;
        this.l = 3;
        d(context);
    }

    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
            this.f12557e = b2Var;
            if (b2Var != null) {
                String string = getResources().getString(R.string.frs_goods_tip_content);
                if (StringUtils.isNull(string)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                f();
                this.f12561i.setText(string);
                this.f12561i.setVisibility(0);
                e();
                b();
                return;
            }
            setVisibility(8);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f12560h;
            if (i2 == 2) {
                c("c13966", 1);
            } else if (i2 == 1) {
                c("c13966", 2);
            }
        }
    }

    public final void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            TiebaStatic.log(new StatisticItem(str).param("obj_locate", i2).param("fid", this.f12557e.Q()).param("fname", this.f12557e.W()).param("tid", this.f12557e.n1()));
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f12558f = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
            this.f12559g = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
            this.f12561i = textView;
            c d2 = c.d(textView);
            d2.y(R.string.F_X01);
            d2.x(R.dimen.T_X09);
            d2.t(R.color.CAM_X0305);
            d2.e(R.string.A_X07);
            d2.n(R.string.J_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0305);
            this.f12561i.setCompoundDrawablePadding(l.g(this.f12558f, R.dimen.M_W_X002));
        }
    }

    public void e() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f12557e == null || this.l == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.l = skinType;
        int color = SkinManager.getColor(R.color.CAM_X0305);
        SkinManager.setViewTextColorWithClickState(this.f12561i, color);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.j = pureDrawable;
        if (pureDrawable != null) {
            this.j.setBounds(0, 0, l.g(this.f12558f, R.dimen.T_X09), l.g(this.f12558f, R.dimen.T_X09));
        }
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12561i.setCompoundDrawables(this.j, null, null, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || StringUtils.isNull(this.f12557e.W())) {
            return;
        }
        view.setTag(this.f12557e);
        int i2 = this.f12560h;
        if (i2 == 0) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f12558f).createNormalCfg(this.f12557e.W(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        } else if (i2 == 1) {
            c("c13967", 2);
            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f12558f).createNormalCfg(this.f12557e.W(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg2.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
        } else if (i2 == 2) {
            c("c13967", 1);
            e eVar = new e();
            eVar.f66235e = 3;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
        }
        View.OnClickListener onClickListener = this.k;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f12560h = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterGoodsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12560h = 0;
        this.l = 3;
        d(context);
    }
}
