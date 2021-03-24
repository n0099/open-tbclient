package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.f0.r.a;
import d.b.h0.r.f0.r.b;
import d.b.h0.r.f0.r.d.b;
import java.util.List;
/* loaded from: classes3.dex */
public class BannerFlowView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f13666e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f13667f;

    /* renamed from: g  reason: collision with root package name */
    public a f13668g;

    /* renamed from: h  reason: collision with root package name */
    public b f13669h;
    public View i;

    public BannerFlowView(Context context) {
        super(context);
        b(context);
    }

    public final void a() {
        this.f13667f.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
        this.f13667f.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public final void b(Context context) {
        this.f13666e = new ViewPager(context);
        IndicatorView indicatorView = new IndicatorView(context);
        this.f13667f = indicatorView;
        indicatorView.setSpacing(0);
        a();
        this.f13668g = new a(context, this.f13666e, this.f13667f, null);
        this.f13669h = new b(context, d.b.h0.r.f0.r.d.a.f50583e);
        this.f13668g.j(5000L);
        this.f13668g.i(context, this.f13669h);
        addView(this.f13666e, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
        addView(this.f13667f, layoutParams);
        View view = new View(context);
        this.i = view;
        view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.i, layoutParams2);
    }

    public void setData(List<n> list) {
        this.f13666e.removeAllViews();
        this.f13668g.k(list);
    }

    public void setMaxScrollCountLimit(int i) {
        this.f13668g.n(i);
    }

    public void setOnItemClickListener(b.a<d.b.h0.r.f0.r.d.a, b.a> aVar) {
        d.b.h0.r.f0.r.d.b bVar = this.f13669h;
        if (bVar != null) {
            bVar.f(aVar);
        }
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }
}
