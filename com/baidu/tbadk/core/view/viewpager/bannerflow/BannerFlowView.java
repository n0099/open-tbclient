package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.o0.r.l0.u.a;
import c.a.o0.r.l0.u.b;
import c.a.o0.r.l0.u.d.b;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class BannerFlowView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPager a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f30326b;

    /* renamed from: c  reason: collision with root package name */
    public a f30327c;

    /* renamed from: d  reason: collision with root package name */
    public b f30328d;

    /* renamed from: e  reason: collision with root package name */
    public View f30329e;

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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30326b.setSelector(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0806eb));
            this.f30326b.setDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0806ea));
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = new ViewPager(context);
            IndicatorView indicatorView = new IndicatorView(context);
            this.f30326b = indicatorView;
            indicatorView.setSpacing(0);
            a();
            this.f30327c = new a(context, this.a, this.f30326b, null);
            this.f30328d = new b(context, c.a.o0.r.l0.u.d.a.a);
            this.f30327c.j(5000L);
            this.f30327c.i(context, this.f30328d);
            addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            layoutParams.setMargins(0, 0, n.f(context, R.dimen.obfuscated_res_0x7f0701d5), n.f(context, R.dimen.obfuscated_res_0x7f0701be));
            addView(this.f30326b, layoutParams);
            View view = new View(context);
            this.f30329e = view;
            view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10043));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, n.f(context, R.dimen.obfuscated_res_0x7f070198));
            layoutParams2.gravity = 80;
            addView(this.f30329e, layoutParams2);
        }
    }

    public void setData(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.removeAllViews();
            this.f30327c.k(list);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f30327c.n(i);
        }
    }

    public void setOnItemClickListener(b.a<c.a.o0.r.l0.u.d.a, b.a> aVar) {
        c.a.o0.r.l0.u.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || (bVar = this.f30328d) == null) {
            return;
        }
        bVar.e(aVar);
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
}
