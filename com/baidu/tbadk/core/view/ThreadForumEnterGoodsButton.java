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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.wu7;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData a;
    public Context b;
    public View c;
    public int d;
    public TextView e;
    public Drawable f;
    public View.OnClickListener g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.h = 3;
        d(context);
    }

    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            this.a = threadData;
            if (threadData != null) {
                String string = getResources().getString(R.string.frs_goods_tip_content);
                if (StringUtils.isNull(string)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                f();
                this.e.setText(string);
                this.e.setVisibility(0);
                e();
                b();
                return;
            }
            setVisibility(8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.h = 3;
        d(context);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.d;
            if (i == 2) {
                c("c13966", 1);
            } else if (i == 1) {
                c("c13966", 2);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.setCompoundDrawables(this.f, null, null, null);
        }
    }

    public final void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            TiebaStatic.log(new StatisticItem(str).param("obj_locate", i).param("fid", this.a.getFid()).param("fname", this.a.getForum_name()).param("tid", this.a.getTid()));
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.b = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
            this.c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
            this.e = textView;
            d85 d = d85.d(textView);
            d.D(R.string.F_X01);
            d.C(R.dimen.T_X09);
            d.x(R.color.CAM_X0305);
            d.e(R.string.A_X07);
            d.o(R.string.J_X01);
            d.m(R.dimen.L_X02);
            d.l(R.color.CAM_X0305);
            this.e.setCompoundDrawablePadding(yi.g(this.b, R.dimen.M_W_X002));
        }
    }

    public void e() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null || this.h == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.h = skinType;
        int color = SkinManager.getColor(R.color.CAM_X0305);
        SkinManager.setViewTextColorWithClickState(this.e, color);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f = pureDrawable;
        if (pureDrawable != null) {
            this.f.setBounds(0, 0, yi.g(this.b, R.dimen.T_X09), yi.g(this.b, R.dimen.T_X09));
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || StringUtils.isNull(this.a.getForum_name())) {
            return;
        }
        view2.setTag(this.a);
        int i = this.d;
        if (i == 0) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.b).createNormalCfg(this.a.getForum_name(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        } else if (i == 1) {
            c("c13967", 2);
            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.b).createNormalCfg(this.a.getForum_name(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg2.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
        } else if (i == 2) {
            c("c13967", 1);
            wu7 wu7Var = new wu7();
            wu7Var.e = 3;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, wu7Var));
        }
        View.OnClickListener onClickListener = this.g;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
        }
    }
}
