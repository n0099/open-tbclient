package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tb5;
import com.baidu.tieba.ub5;
import com.baidu.tieba.wb5;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class BannerFlowView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPager a;
    public IndicatorView b;
    public tb5 c;
    public xb5 d;
    public View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerFlowView(Context context) {
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
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerFlowView(Context context, AttributeSet attributeSet) {
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
        b(context);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
            this.b.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = new ViewPager(context);
            IndicatorView indicatorView = new IndicatorView(context);
            this.b = indicatorView;
            indicatorView.setSpacing(0);
            a();
            this.c = new tb5(context, this.a, this.b, null);
            this.d = new xb5(context, wb5.a);
            this.c.j(5000L);
            this.c.i(context, this.d);
            addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            layoutParams.setMargins(0, 0, xi.g(context, R.dimen.obfuscated_res_0x7f0701d5), xi.g(context, R.dimen.obfuscated_res_0x7f0701be));
            addView(this.b, layoutParams);
            View view2 = new View(context);
            this.e = view2;
            view2.setBackgroundColor(SkinManager.getColor(R.color.common_color_10043));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, xi.g(context, R.dimen.obfuscated_res_0x7f070198));
            layoutParams2.gravity = 80;
            addView(this.e, layoutParams2);
        }
    }

    public void setData(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.removeAllViews();
            this.c.k(list);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.c.l(i);
        }
    }

    public void setOnItemClickListener(ub5.a<wb5, xb5.a> aVar) {
        xb5 xb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && (xb5Var = this.d) != null) {
            xb5Var.e(aVar);
        }
    }
}
