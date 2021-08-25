package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.p0.s.f0.u.a;
import c.a.p0.s.f0.u.b;
import c.a.p0.s.f0.u.d.b;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class BannerFlowView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f47925e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f47926f;

    /* renamed from: g  reason: collision with root package name */
    public a f47927g;

    /* renamed from: h  reason: collision with root package name */
    public b f47928h;

    /* renamed from: i  reason: collision with root package name */
    public View f47929i;

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
            this.f47926f.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
            this.f47926f.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f47925e = new ViewPager(context);
            IndicatorView indicatorView = new IndicatorView(context);
            this.f47926f = indicatorView;
            indicatorView.setSpacing(0);
            a();
            this.f47927g = new a(context, this.f47925e, this.f47926f, null);
            this.f47928h = new b(context, c.a.p0.s.f0.u.d.a.f13998e);
            this.f47927g.m(5000L);
            this.f47927g.k(context, this.f47928h);
            addView(this.f47925e, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
            addView(this.f47926f, layoutParams);
            View view = new View(context);
            this.f47929i = view;
            view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10043));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
            layoutParams2.gravity = 80;
            addView(this.f47929i, layoutParams2);
        }
    }

    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f47927g.i();
        }
    }

    public void onSkinTypeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            a();
            this.f47927g.j(i2);
        }
    }

    public void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f47925e.removeAllViews();
            this.f47927g.n(list);
        }
    }

    public void setMaxScrollCountLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f47927g.q(i2);
        }
    }

    public void setOnItemClickListener(b.a<c.a.p0.s.f0.u.d.a, b.a> aVar) {
        c.a.p0.s.f0.u.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || (bVar = this.f47928h) == null) {
            return;
        }
        bVar.g(aVar);
    }

    public void startAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f47927g.r();
        }
    }

    public void stopAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f47927g.s();
        }
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
