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
import b.a.e.f.p.l;
import b.a.q0.s.q.d2;
import b.a.q0.s.u.c;
import b.a.r0.x0.w2.e;
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
/* loaded from: classes8.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_CARD = 0;
    public static final int FROM_FRS_OTHER_TAB = 2;
    public static final int FROM_PB_FIRST_FLOOR = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int DEFAULT_FROM;

    /* renamed from: e  reason: collision with root package name */
    public d2 f46269e;

    /* renamed from: f  reason: collision with root package name */
    public Context f46270f;

    /* renamed from: g  reason: collision with root package name */
    public View f46271g;

    /* renamed from: h  reason: collision with root package name */
    public int f46272h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46273i;
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
        this.DEFAULT_FROM = 0;
        this.f46272h = 0;
        this.l = 3;
        c(context);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f46272h;
            if (i2 == 2) {
                b("c13966", 1);
            } else if (i2 == 1) {
                b("c13966", 2);
            }
        }
    }

    public final void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            TiebaStatic.log(new StatisticItem(str).param("obj_locate", i2).param("fid", this.f46269e.T()).param("fname", this.f46269e.Z()).param("tid", this.f46269e.t1()));
        }
    }

    public void bindData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            this.f46269e = d2Var;
            if (d2Var != null) {
                String string = getResources().getString(R.string.frs_goods_tip_content);
                if (StringUtils.isNull(string)) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                d();
                this.f46273i.setText(string);
                this.f46273i.setVisibility(0);
                onChangeSkinType();
                a();
                return;
            }
            setVisibility(8);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f46270f = context;
            setOnClickListener(this);
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
            this.f46271g = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
            this.f46273i = textView;
            c d2 = c.d(textView);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0305);
            d2.e(R.string.A_X07);
            d2.n(R.string.J_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0305);
            this.f46273i.setCompoundDrawablePadding(l.g(this.f46270f, R.dimen.M_W_X002));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f46273i.setCompoundDrawables(this.j, null, null, null);
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f46269e == null || this.l == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.l = skinType;
        int color = SkinManager.getColor(R.color.CAM_X0305);
        SkinManager.setViewTextColorWithClickState(this.f46273i, color);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.j = pureDrawable;
        if (pureDrawable != null) {
            this.j.setBounds(0, 0, l.g(this.f46270f, R.dimen.T_X09), l.g(this.f46270f, R.dimen.T_X09));
        }
        d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || StringUtils.isNull(this.f46269e.Z())) {
            return;
        }
        view.setTag(this.f46269e);
        int i2 = this.f46272h;
        if (i2 == 0) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f46270f).createNormalCfg(this.f46269e.Z(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        } else if (i2 == 1) {
            b("c13967", 2);
            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f46270f).createNormalCfg(this.f46269e.Z(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg2.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
        } else if (i2 == 2) {
            b("c13967", 1);
            e eVar = new e();
            eVar.f28055e = 3;
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
            this.f46272h = i2;
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
        this.DEFAULT_FROM = 0;
        this.f46272h = 0;
        this.l = 3;
        c(context);
    }
}
