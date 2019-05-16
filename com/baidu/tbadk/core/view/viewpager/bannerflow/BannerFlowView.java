package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b ccL;
    private IndicatorView ccO;
    private ViewPager cdj;
    private b cdk;
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
        this.cdj = new ViewPager(context);
        this.ccO = new IndicatorView(context);
        this.ccO.setSpacing(0);
        akp();
        this.ccL = new com.baidu.tbadk.core.view.viewpager.b(context, this.cdj, this.ccO, null);
        this.cdk = new b(context, a.cdi);
        this.ccL.setAutoScrollIntervalTime(5000L);
        this.ccL.a(context, this.cdk);
        addView(this.cdj, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
        addView(this.ccO, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.ccL.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.cdj.removeAllViews();
        this.ccL.setDatas(list);
    }

    private void akp() {
        this.ccO.setSelector(al.getDrawable(R.drawable.icon_diandian_white_s));
        this.ccO.setDrawable(al.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.cdk != null) {
            this.cdk.setOnItemClickListener(aVar);
        }
    }
}
