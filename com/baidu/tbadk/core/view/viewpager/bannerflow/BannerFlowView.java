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
    private com.baidu.tbadk.core.view.viewpager.b cdO;
    private IndicatorView cdR;
    private ViewPager cem;
    private b cen;
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
        this.cem = new ViewPager(context);
        this.cdR = new IndicatorView(context);
        this.cdR.setSpacing(0);
        alu();
        this.cdO = new com.baidu.tbadk.core.view.viewpager.b(context, this.cem, this.cdR, null);
        this.cen = new b(context, a.cel);
        this.cdO.setAutoScrollIntervalTime(5000L);
        this.cdO.a(context, this.cen);
        addView(this.cem, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
        addView(this.cdR, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.cdO.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.cem.removeAllViews();
        this.cdO.setDatas(list);
    }

    private void alu() {
        this.cdR.setSelector(am.getDrawable(R.drawable.icon_diandian_white_s));
        this.cdR.setDrawable(am.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.cen != null) {
            this.cen.setOnItemClickListener(aVar);
        }
    }
}
