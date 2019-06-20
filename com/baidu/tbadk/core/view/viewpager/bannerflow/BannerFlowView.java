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
    private com.baidu.tbadk.core.view.viewpager.b ccM;
    private IndicatorView ccP;
    private ViewPager cdk;
    private b cdl;
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
        this.cdk = new ViewPager(context);
        this.ccP = new IndicatorView(context);
        this.ccP.setSpacing(0);
        akp();
        this.ccM = new com.baidu.tbadk.core.view.viewpager.b(context, this.cdk, this.ccP, null);
        this.cdl = new b(context, a.cdj);
        this.ccM.setAutoScrollIntervalTime(5000L);
        this.ccM.a(context, this.cdl);
        addView(this.cdk, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
        addView(this.ccP, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.ccM.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.cdk.removeAllViews();
        this.ccM.setDatas(list);
    }

    private void akp() {
        this.ccP.setSelector(al.getDrawable(R.drawable.icon_diandian_white_s));
        this.ccP.setDrawable(al.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.cdl != null) {
            this.cdl.setOnItemClickListener(aVar);
        }
    }
}
