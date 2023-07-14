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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.d85;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData a;
    public Context b;
    public View c;
    public int d;
    public boolean e;
    public TextView f;
    public Drawable g;
    public View.OnClickListener h;
    public int i;

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
        yi.l(TbadkCoreApplication.getInst());
        yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = false;
        this.i = 3;
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.b = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
            this.c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
            this.f = textView;
            textView.setCompoundDrawablePadding(yi.g(this.b, R.dimen.M_W_X002));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = false;
        this.i = 3;
        c(context);
    }

    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            this.a = threadData;
            if (threadData != null) {
                String forum_name = threadData.getForum_name();
                if (StringUtils.isNull(forum_name)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                f();
                TextView textView = this.f;
                textView.setText(StringHelper.cutForumNameWithSuffix(forum_name, 14, "...") + this.b.getString(R.string.obfuscated_res_0x7f0f0773));
                this.f.setVisibility(0);
                if (YYLiveUtil.isLiveRoom(forum_name)) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                e();
                return;
            }
            setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (this.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                Context context = this.b;
                BdToast b = BdToast.b(context, context.getString(R.string.video_is_checking));
                b.g(BdToast.ToastIcon.FAILURE);
                b.q();
            } else if (StringUtils.isNull(this.a.getForum_name())) {
            } else {
                view2.setTag(this.a);
                if (this.d == 0) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.b).createNormalCfg(this.a.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    createNormalCfg.setCallFrom(14);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                }
                ThreadData threadData = this.a;
                if (threadData != null && YYLiveUtil.isLiveRoom(threadData.getForum_name())) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_CLICK);
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                View.OnClickListener onClickListener = this.h;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    public void b(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData, i) == null) {
            this.a = threadData;
            if (threadData != null && i > 0) {
                int paddingLeft = this.f.getPaddingLeft();
                String forum_name = threadData.getForum_name();
                if (StringUtils.isNull(forum_name)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                f();
                float measureText = (i - (paddingLeft * 2)) - this.f.getPaint().measureText(getResources().getString(R.string.obfuscated_res_0x7f0f0773));
                this.f.setText(((Object) TextUtils.ellipsize(forum_name, this.f.getPaint(), measureText, TextUtils.TruncateAt.END)) + getResources().getString(R.string.obfuscated_res_0x7f0f0773));
                this.f.setVisibility(0);
                if (YYLiveUtil.isLiveRoom(threadData.getForum_name())) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                e();
                return;
            }
            setVisibility(8);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.e = z;
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
        }
    }

    public void e() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null || this.i == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.i = skinType;
        if (this.e) {
            d85 d = d85.d(this.f);
            d.D(R.string.F_X01);
            d.C(R.dimen.T_X09);
            d.x(R.color.CAM_X0304);
            d.e(R.string.A_X07);
            d.o(R.string.J_X01);
            d.m(R.dimen.L_X01);
            d.l(R.color.CAM_X0304);
        } else {
            d85 d2 = d85.d(this.f);
            d2.D(R.string.F_X01);
            d2.C(R.dimen.T_X09);
            d2.x(R.color.CAM_X0304);
            d2.e(R.string.A_X07);
            d2.o(R.string.J_X01);
            d2.m(R.dimen.L_X02);
            d2.l(R.color.CAM_X0304);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba12, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
        this.g = pureDrawable;
        if (pureDrawable != null) {
            int g = yi.g(this.b, R.dimen.T_X09);
            this.g.setBounds(0, 0, g, g);
        }
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.setCompoundDrawables(this.g, null, null, null);
        }
    }
}
