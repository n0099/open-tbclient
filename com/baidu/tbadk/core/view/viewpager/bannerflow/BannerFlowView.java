package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b cta;
    private IndicatorView ctd;
    private ViewPager cty;
    private b ctz;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        initView(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        this.cty = new ViewPager(context);
        this.ctd = new IndicatorView(context);
        this.ctd.setSpacing(0);
        aow();
        this.cta = new com.baidu.tbadk.core.view.viewpager.b(context, this.cty, this.ctd, null);
        this.ctz = new b(context, a.ctx);
        this.cta.setAutoScrollIntervalTime(5000L);
        this.cta.a(context, this.ctz);
        addView(this.cty, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.ctd, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.cta.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.cty.removeAllViews();
        this.cta.setDatas(list);
    }

    private void aow() {
        this.ctd.setSelector(am.getDrawable(R.drawable.icon_diandian_white_s));
        this.ctd.setDrawable(am.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.ctz != null) {
            this.ctz.setOnItemClickListener(aVar);
        }
    }
}
