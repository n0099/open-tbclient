package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b ehP;
    private IndicatorView ehS;
    private ViewPager eim;
    private b ein;
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
        this.eim = new ViewPager(context);
        this.ehS = new IndicatorView(context);
        this.ehS.setSpacing(0);
        aZt();
        this.ehP = new com.baidu.tbadk.core.view.viewpager.b(context, this.eim, this.ehS, null);
        this.ein = new b(context, a.eil);
        this.ehP.setAutoScrollIntervalTime(5000L);
        this.ehP.a(context, this.ein);
        addView(this.eim, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.ehS, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(an.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.ehP.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.eim.removeAllViews();
        this.ehP.setDatas(list);
    }

    private void aZt() {
        this.ehS.setSelector(an.getDrawable(R.drawable.icon_diandian_white_s));
        this.ehS.setDrawable(an.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.ein != null) {
            this.ein.setOnItemClickListener(aVar);
        }
    }
}
