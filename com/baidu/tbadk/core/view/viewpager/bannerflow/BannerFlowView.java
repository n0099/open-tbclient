package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private ViewPager aIG;
    private b aIH;
    private com.baidu.tbadk.core.view.viewpager.b aIi;
    private IndicatorView aIl;
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
        this.aIG = new ViewPager(context);
        this.aIl = new IndicatorView(context);
        this.aIl.setSpacing(0);
        EH();
        this.aIi = new com.baidu.tbadk.core.view.viewpager.b(context, this.aIG, this.aIl, null);
        this.aIH = new b(context, a.aIF);
        this.aIi.setAutoScrollIntervalTime(5000L);
        this.aIi.a(context, this.aIH);
        addView(this.aIG, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.h(context, e.C0200e.ds20), l.h(context, e.C0200e.ds16));
        addView(this.aIl, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(e.d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.h(context, e.C0200e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.aIi.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aIG.removeAllViews();
        this.aIi.setDatas(list);
    }

    private void EH() {
        this.aIl.setSelector(al.getDrawable(e.f.icon_diandian_white_s));
        this.aIl.setDrawable(al.getDrawable(e.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aIH != null) {
            this.aIH.setOnItemClickListener(aVar);
        }
    }
}
