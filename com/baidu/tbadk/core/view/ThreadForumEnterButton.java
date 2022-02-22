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
import c.a.d.f.p.n;
import c.a.t0.s.r.e2;
import c.a.t0.s.v.c;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_CARD = 0;
    public static final int FROM_PB_FIRST_FLOOR = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int DEFAULT_FROM;

    /* renamed from: e  reason: collision with root package name */
    public e2 f40749e;

    /* renamed from: f  reason: collision with root package name */
    public Context f40750f;

    /* renamed from: g  reason: collision with root package name */
    public View f40751g;

    /* renamed from: h  reason: collision with root package name */
    public int f40752h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40753i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f40754j;
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
        n.k(TbadkCoreApplication.getInst());
        n.f(TbadkCoreApplication.getInst(), e.M_W_X005);
        n.f(TbadkCoreApplication.getInst(), e.M_W_X004);
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
        this.f40752h = 0;
        this.f40753i = false;
        this.m = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f40750f = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(h.card_home_page_forum_enter_button, (ViewGroup) this, true);
            this.f40751g = inflate;
            TextView textView = (TextView) inflate.findViewById(g.forum_name_text);
            this.f40754j = textView;
            textView.setCompoundDrawablePadding(n.f(this.f40750f, e.M_W_X002));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f40754j.setCompoundDrawables(this.k, null, null, null);
        }
    }

    public void bindData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            this.f40749e = e2Var;
            if (e2Var != null) {
                String b0 = e2Var.b0();
                if (StringUtils.isNull(b0)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                b();
                TextView textView = this.f40754j;
                textView.setText(StringHelper.cutForumNameWithSuffix(b0, 14, "...") + this.f40750f.getString(j.forum));
                this.f40754j.setVisibility(0);
                if (YYLiveUtil.isLiveRoom(b0)) {
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
            this.f40753i = z;
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f40749e == null || this.m == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.m = skinType;
        if (this.f40753i) {
            c d2 = c.d(this.f40754j);
            d2.A(j.F_X01);
            d2.z(e.T_X09);
            d2.v(d.CAM_X0304);
            d2.e(j.A_X07);
            d2.n(j.J_X01);
            d2.l(e.L_X01);
            d2.k(d.CAM_X0304);
        } else {
            c d3 = c.d(this.f40754j);
            d3.A(j.F_X01);
            d3.z(e.T_X09);
            d3.v(d.CAM_X0304);
            d3.e(j.A_X07);
            d3.n(j.J_X01);
            d3.l(e.L_X02);
            d3.k(d.CAM_X0304);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(f.icon_pure_ba12, SkinManager.getColor(d.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
        this.k = pureDrawable;
        if (pureDrawable != null) {
            int f2 = n.f(this.f40750f, e.T_X09);
            this.k.setBounds(0, 0, f2, f2);
        }
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (this.f40749e.getType() == e2.Z3) {
                Context context = this.f40750f;
                BdToast.i(context, context.getString(j.video_is_checking), f.icon_pure_toast_mistake40_svg, true).q();
            } else if (StringUtils.isNull(this.f40749e.b0())) {
            } else {
                view.setTag(this.f40749e);
                if (this.f40752h == 0) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f40750f).createNormalCfg(this.f40749e.b0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    createNormalCfg.setCallFrom(14);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                }
                e2 e2Var = this.f40749e;
                if (e2Var != null && YYLiveUtil.isLiveRoom(e2Var.b0())) {
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
            this.f40752h = i2;
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
        this.f40752h = 0;
        this.f40753i = false;
        this.m = 3;
        a(context);
    }

    public void bindData(e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, e2Var, i2) == null) {
            this.f40749e = e2Var;
            if (e2Var != null && i2 > 0) {
                int paddingLeft = this.f40754j.getPaddingLeft();
                String b0 = e2Var.b0();
                if (StringUtils.isNull(b0)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                b();
                float measureText = (i2 - (paddingLeft * 2)) - this.f40754j.getPaint().measureText(getResources().getString(j.forum));
                this.f40754j.setText(((Object) TextUtils.ellipsize(b0, this.f40754j.getPaint(), measureText, TextUtils.TruncateAt.END)) + getResources().getString(j.forum));
                this.f40754j.setVisibility(0);
                if (YYLiveUtil.isLiveRoom(e2Var.b0())) {
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
