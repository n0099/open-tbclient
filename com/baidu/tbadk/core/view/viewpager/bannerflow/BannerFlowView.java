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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.f0.t.a;
import d.a.r0.r.f0.t.b;
import d.a.r0.r.f0.t.d.b;
import java.util.List;
/* loaded from: classes4.dex */
public class BannerFlowView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f12772e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12773f;

    /* renamed from: g  reason: collision with root package name */
    public a f12774g;

    /* renamed from: h  reason: collision with root package name */
    public b f12775h;

    /* renamed from: i  reason: collision with root package name */
    public View f12776i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerFlowView(Context context) {
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
        b(context);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12773f.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
            this.f12773f.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f12772e = new ViewPager(context);
            IndicatorView indicatorView = new IndicatorView(context);
            this.f12773f = indicatorView;
            indicatorView.setSpacing(0);
            a();
            this.f12774g = new a(context, this.f12772e, this.f12773f, null);
            this.f12775h = new b(context, d.a.r0.r.f0.t.d.a.f55737e);
            this.f12774g.j(5000L);
            this.f12774g.i(context, this.f12775h);
            addView(this.f12772e, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
            addView(this.f12773f, layoutParams);
            View view = new View(context);
            this.f12776i = view;
            view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10043));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
            layoutParams2.gravity = 80;
            addView(this.f12776i, layoutParams2);
        }
    }

    public void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f12772e.removeAllViews();
            this.f12774g.k(list);
        }
    }

    public void setMaxScrollCountLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f12774g.n(i2);
        }
    }

    public void setOnItemClickListener(b.a<d.a.r0.r.f0.t.d.a, b.a> aVar) {
        d.a.r0.r.f0.t.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || (bVar = this.f12775h) == null) {
            return;
        }
        bVar.f(aVar);
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
        b(context);
    }
}
