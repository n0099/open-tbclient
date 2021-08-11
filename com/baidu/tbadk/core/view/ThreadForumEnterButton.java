package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.o0.s.q.c2;
import c.a.o0.s.u.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_CARD = 0;
    public static final int FROM_PB_FIRST_FLOOR = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int DEFAULT_FROM;

    /* renamed from: e  reason: collision with root package name */
    public c2 f47587e;

    /* renamed from: f  reason: collision with root package name */
    public Context f47588f;

    /* renamed from: g  reason: collision with root package name */
    public View f47589g;

    /* renamed from: h  reason: collision with root package name */
    public int f47590h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47591i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47592j;
    public Drawable k;
    public View.OnClickListener l;
    public int m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2000072427, "Lcom/baidu/tbadk/core/view/ThreadForumEnterButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2000072427, "Lcom/baidu/tbadk/core/view/ThreadForumEnterButton;");
                return;
            }
        }
        l.k(TbadkCoreApplication.getInst());
        l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.DEFAULT_FROM = 0;
        this.f47590h = 0;
        this.f47591i = false;
        this.m = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f47588f = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
            this.f47589g = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
            this.f47592j = textView;
            textView.setCompoundDrawablePadding(l.g(this.f47588f, R.dimen.M_W_X002));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47592j.setCompoundDrawables(this.k, null, null, null);
        }
    }

    public void bindData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var) == null) {
            this.f47587e = c2Var;
            if (c2Var != null) {
                String Z = c2Var.Z();
                if (StringUtils.isNull(Z)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                b();
                TextView textView = this.f47592j;
                textView.setText(StringHelper.cutForumNameWithSuffix(Z, 14, "...") + this.f47588f.getString(R.string.forum));
                this.f47592j.setVisibility(0);
                if (YYLiveUtil.isLiveRoom(Z)) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                onChangeSkinType();
                return;
            }
            setVisibility(8);
        }
    }

    public void isFromVideoTabPbFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f47591i = z;
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f47587e == null || this.m == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.m = skinType;
        if (this.f47591i) {
            c d2 = c.d(this.f47592j);
            d2.y(R.string.F_X01);
            d2.x(R.dimen.T_X09);
            d2.t(R.color.CAM_X0304);
            d2.e(R.string.A_X07);
            d2.n(R.string.J_X01);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0304);
        } else {
            c d3 = c.d(this.f47592j);
            d3.y(R.string.F_X01);
            d3.x(R.dimen.T_X09);
            d3.t(R.color.CAM_X0304);
            d3.e(R.string.A_X07);
            d3.n(R.string.J_X01);
            d3.l(R.dimen.L_X02);
            d3.k(R.color.CAM_X0304);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba12, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
        this.k = pureDrawable;
        if (pureDrawable != null) {
            int g2 = l.g(this.f47588f, R.dimen.T_X09);
            this.k.setBounds(0, 0, g2, g2);
        }
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (this.f47587e.getType() == c2.M3) {
                Context context = this.f47588f;
                BdToast.i(context, context.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            } else if (StringUtils.isNull(this.f47587e.Z())) {
            } else {
                view.setTag(this.f47587e);
                if (this.f47590h == 0) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f47588f).createNormalCfg(this.f47587e.Z(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    createNormalCfg.setCallFrom(14);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                }
                c2 c2Var = this.f47587e;
                if (c2Var != null && YYLiveUtil.isLiveRoom(c2Var.Z())) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_CLICK);
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                View.OnClickListener onClickListener = this.l;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f47590h = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.DEFAULT_FROM = 0;
        this.f47590h = 0;
        this.f47591i = false;
        this.m = 3;
        a(context);
    }

    public void bindData(c2 c2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, c2Var, i2) == null) {
            this.f47587e = c2Var;
            if (c2Var != null && i2 > 0) {
                int paddingLeft = this.f47592j.getPaddingLeft();
                String Z = c2Var.Z();
                if (StringUtils.isNull(Z)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                b();
                float measureText = (i2 - (paddingLeft * 2)) - this.f47592j.getPaint().measureText(getResources().getString(R.string.forum));
                this.f47592j.setText(((Object) TextUtils.ellipsize(Z, this.f47592j.getPaint(), measureText, TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
                this.f47592j.setVisibility(0);
                if (YYLiveUtil.isLiveRoom(c2Var.Z())) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                onChangeSkinType();
                return;
            }
            setVisibility(8);
        }
    }
}
