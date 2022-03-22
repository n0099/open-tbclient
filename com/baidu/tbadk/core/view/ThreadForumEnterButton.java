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
import c.a.o0.r.v.c;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData a;

    /* renamed from: b  reason: collision with root package name */
    public Context f30129b;

    /* renamed from: c  reason: collision with root package name */
    public View f30130c;

    /* renamed from: d  reason: collision with root package name */
    public int f30131d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30132e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f30133f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f30134g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f30135h;
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
        n.k(TbadkCoreApplication.getInst());
        n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
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
        this.f30131d = 0;
        this.f30132e = false;
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
                TextView textView = this.f30133f;
                textView.setText(StringHelper.cutForumNameWithSuffix(forum_name, 14, StringHelper.STRING_MORE) + this.f30129b.getString(R.string.obfuscated_res_0x7f0f063c));
                this.f30133f.setVisibility(0);
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

    public void b(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData, i) == null) {
            this.a = threadData;
            if (threadData != null && i > 0) {
                int paddingLeft = this.f30133f.getPaddingLeft();
                String forum_name = threadData.getForum_name();
                if (StringUtils.isNull(forum_name)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                f();
                float measureText = (i - (paddingLeft * 2)) - this.f30133f.getPaint().measureText(getResources().getString(R.string.obfuscated_res_0x7f0f063c));
                this.f30133f.setText(((Object) TextUtils.ellipsize(forum_name, this.f30133f.getPaint(), measureText, TextUtils.TruncateAt.END)) + getResources().getString(R.string.obfuscated_res_0x7f0f063c));
                this.f30133f.setVisibility(0);
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

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f30129b = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d019b, (ViewGroup) this, true);
            this.f30130c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a68);
            this.f30133f = textView;
            textView.setCompoundDrawablePadding(n.f(this.f30129b, R.dimen.M_W_X002));
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f30132e = z;
        }
    }

    public void e() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null || this.i == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.i = skinType;
        if (this.f30132e) {
            c d2 = c.d(this.f30133f);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0304);
            d2.e(R.string.A_X07);
            d2.n(R.string.J_X01);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0304);
        } else {
            c d3 = c.d(this.f30133f);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0304);
            d3.e(R.string.A_X07);
            d3.n(R.string.J_X01);
            d3.l(R.dimen.L_X02);
            d3.k(R.color.CAM_X0304);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808db, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f30134g = pureDrawable;
        if (pureDrawable != null) {
            int f2 = n.f(this.f30129b, R.dimen.T_X09);
            this.f30134g.setBounds(0, 0, f2, f2);
        }
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f30133f.setCompoundDrawables(this.f30134g, null, null, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (this.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                Context context = this.f30129b;
                BdToast.i(context, context.getString(R.string.obfuscated_res_0x7f0f14d0), R.drawable.obfuscated_res_0x7f08099f, true).q();
            } else if (StringUtils.isNull(this.a.getForum_name())) {
            } else {
                view.setTag(this.a);
                if (this.f30131d == 0) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f30129b).createNormalCfg(this.a.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    createNormalCfg.setCallFrom(14);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                }
                ThreadData threadData = this.a;
                if (threadData != null && YYLiveUtil.isLiveRoom(threadData.getForum_name())) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_CLICK);
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                View.OnClickListener onClickListener = this.f30135h;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f30135h = onClickListener;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f30131d = i;
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
        this.f30131d = 0;
        this.f30132e = false;
        this.i = 3;
        c(context);
    }
}
