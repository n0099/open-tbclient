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
import d.a.c.j.e.n;
import d.a.j0.r.f0.r.a;
import d.a.j0.r.f0.r.b;
import d.a.j0.r.f0.r.d.b;
import java.util.List;
/* loaded from: classes3.dex */
public class BannerFlowView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f12638e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12639f;

    /* renamed from: g  reason: collision with root package name */
    public a f12640g;

    /* renamed from: h  reason: collision with root package name */
    public b f12641h;

    /* renamed from: i  reason: collision with root package name */
    public View f12642i;

    public BannerFlowView(Context context) {
        super(context);
        b(context);
    }

    public final void a() {
        this.f12639f.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
        this.f12639f.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public final void b(Context context) {
        this.f12638e = new ViewPager(context);
        IndicatorView indicatorView = new IndicatorView(context);
        this.f12639f = indicatorView;
        indicatorView.setSpacing(0);
        a();
        this.f12640g = new a(context, this.f12638e, this.f12639f, null);
        this.f12641h = new b(context, d.a.j0.r.f0.r.d.a.f49773e);
        this.f12640g.j(5000L);
        this.f12640g.i(context, this.f12641h);
        addView(this.f12638e, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
        addView(this.f12639f, layoutParams);
        View view = new View(context);
        this.f12642i = view;
        view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.f12642i, layoutParams2);
    }

    public void setData(List<n> list) {
        this.f12638e.removeAllViews();
        this.f12640g.k(list);
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f12640g.n(i2);
    }

    public void setOnItemClickListener(b.a<d.a.j0.r.f0.r.d.a, b.a> aVar) {
        d.a.j0.r.f0.r.d.b bVar = this.f12641h;
        if (bVar != null) {
            bVar.f(aVar);
        }
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }
}
