package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.r.f0.r.a;
import d.a.n0.r.f0.r.b;
import d.a.n0.r.f0.r.d.b;
import java.util.List;
/* loaded from: classes3.dex */
public class BannerFlowView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f12690e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12691f;

    /* renamed from: g  reason: collision with root package name */
    public a f12692g;

    /* renamed from: h  reason: collision with root package name */
    public b f12693h;

    /* renamed from: i  reason: collision with root package name */
    public View f12694i;

    public BannerFlowView(Context context) {
        super(context);
        b(context);
    }

    public final void a() {
        this.f12691f.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
        this.f12691f.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public final void b(Context context) {
        this.f12690e = new ViewPager(context);
        IndicatorView indicatorView = new IndicatorView(context);
        this.f12691f = indicatorView;
        indicatorView.setSpacing(0);
        a();
        this.f12692g = new a(context, this.f12690e, this.f12691f, null);
        this.f12693h = new b(context, d.a.n0.r.f0.r.d.a.f53599e);
        this.f12692g.j(5000L);
        this.f12692g.i(context, this.f12693h);
        addView(this.f12690e, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
        addView(this.f12691f, layoutParams);
        View view = new View(context);
        this.f12694i = view;
        view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.f12694i, layoutParams2);
    }

    public void setData(List<n> list) {
        this.f12690e.removeAllViews();
        this.f12692g.k(list);
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f12692g.n(i2);
    }

    public void setOnItemClickListener(b.a<d.a.n0.r.f0.r.d.a, b.a> aVar) {
        d.a.n0.r.f0.r.d.b bVar = this.f12693h;
        if (bVar != null) {
            bVar.f(aVar);
        }
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }
}
