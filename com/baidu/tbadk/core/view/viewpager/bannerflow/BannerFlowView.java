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
    private com.baidu.tbadk.core.view.viewpager.b aLK;
    private IndicatorView aLN;
    private ViewPager aMi;
    private b aMj;
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
        this.aMi = new ViewPager(context);
        this.aLN = new IndicatorView(context);
        this.aLN.setSpacing(0);
        FM();
        this.aLK = new com.baidu.tbadk.core.view.viewpager.b(context, this.aMi, this.aLN, null);
        this.aMj = new b(context, a.aMh);
        this.aLK.setAutoScrollIntervalTime(5000L);
        this.aLK.a(context, this.aMj);
        addView(this.aMi, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.h(context, e.C0210e.ds20), l.h(context, e.C0210e.ds16));
        addView(this.aLN, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(e.d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.h(context, e.C0210e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.aLK.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aMi.removeAllViews();
        this.aLK.setDatas(list);
    }

    private void FM() {
        this.aLN.setSelector(al.getDrawable(e.f.icon_diandian_white_s));
        this.aLN.setDrawable(al.getDrawable(e.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aMj != null) {
            this.aMj.setOnItemClickListener(aVar);
        }
    }
}
