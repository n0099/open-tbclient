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
    private ViewPager dkN;
    private b dkO;
    private com.baidu.tbadk.core.view.viewpager.b dkq;
    private IndicatorView dkt;
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
        this.dkN = new ViewPager(context);
        this.dkt = new IndicatorView(context);
        this.dkt.setSpacing(0);
        aIH();
        this.dkq = new com.baidu.tbadk.core.view.viewpager.b(context, this.dkN, this.dkt, null);
        this.dkO = new b(context, a.dkM);
        this.dkq.setAutoScrollIntervalTime(5000L);
        this.dkq.a(context, this.dkO);
        addView(this.dkN, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.dkt, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.dkq.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.dkN.removeAllViews();
        this.dkq.setDatas(list);
    }

    private void aIH() {
        this.dkt.setSelector(am.getDrawable(R.drawable.icon_diandian_white_s));
        this.dkt.setDrawable(am.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.dkO != null) {
            this.dkO.setOnItemClickListener(aVar);
        }
    }
}
