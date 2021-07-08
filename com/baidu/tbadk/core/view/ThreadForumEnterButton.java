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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.r.u.c;
/* loaded from: classes3.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b2 f12564e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12565f;

    /* renamed from: g  reason: collision with root package name */
    public View f12566g;

    /* renamed from: h  reason: collision with root package name */
    public int f12567h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12568i;
    public Drawable j;
    public View.OnClickListener k;
    public int l;

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
        this.f12567h = 0;
        this.l = 3;
        c(context);
    }

    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
            this.f12564e = b2Var;
            if (b2Var != null) {
                String W = b2Var.W();
                if (StringUtils.isNull(W)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                e();
                TextView textView = this.f12568i;
                textView.setText(StringHelper.cutForumNameWithSuffix(W, 14, StringHelper.STRING_MORE) + this.f12565f.getString(R.string.forum));
                this.f12568i.setVisibility(0);
                d();
                return;
            }
            setVisibility(8);
        }
    }

    public void b(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var, i2) == null) {
            this.f12564e = b2Var;
            if (b2Var != null && i2 > 0) {
                int paddingLeft = this.f12568i.getPaddingLeft();
                String W = b2Var.W();
                if (StringUtils.isNull(W)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                e();
                float measureText = (i2 - (paddingLeft * 2)) - this.f12568i.getPaint().measureText(getResources().getString(R.string.forum));
                this.f12568i.setText(((Object) TextUtils.ellipsize(W, this.f12568i.getPaint(), measureText, TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
                this.f12568i.setVisibility(0);
                d();
                return;
            }
            setVisibility(8);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f12565f = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
            this.f12566g = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
            this.f12568i = textView;
            textView.setCompoundDrawablePadding(l.g(this.f12565f, R.dimen.M_W_X002));
        }
    }

    public void d() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f12564e == null || this.l == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.l = skinType;
        c d2 = c.d(this.f12568i);
        d2.y(R.string.F_X01);
        d2.x(R.dimen.T_X09);
        d2.t(R.color.CAM_X0304);
        d2.e(R.string.A_X07);
        d2.n(R.string.J_X01);
        d2.l(R.dimen.L_X02);
        d2.k(R.color.CAM_X0304);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba12, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
        this.j = pureDrawable;
        if (pureDrawable != null) {
            int g2 = l.g(this.f12565f, R.dimen.T_X09);
            this.j.setBounds(0, 0, g2, g2);
        }
        e();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12568i.setCompoundDrawables(this.j, null, null, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (this.f12564e.getType() == b2.E3) {
                Context context = this.f12565f;
                BdToast.i(context, context.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            } else if (StringUtils.isNull(this.f12564e.W())) {
            } else {
                view.setTag(this.f12564e);
                if (this.f12567h == 0) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f12565f).createNormalCfg(this.f12564e.W(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    createNormalCfg.setCallFrom(14);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                }
                View.OnClickListener onClickListener = this.k;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f12567h = i2;
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
        this.f12567h = 0;
        this.l = 3;
        c(context);
    }
}
