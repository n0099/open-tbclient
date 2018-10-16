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
    private ViewPager aHQ;
    private b aHR;
    private com.baidu.tbadk.core.view.viewpager.b aHs;
    private IndicatorView aHv;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        bJ(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bJ(context);
    }

    private void bJ(Context context) {
        this.aHQ = new ViewPager(context);
        this.aHv = new IndicatorView(context);
        this.aHv.setSpacing(0);
        Ex();
        this.aHs = new com.baidu.tbadk.core.view.viewpager.b(context, this.aHQ, this.aHv, null);
        this.aHR = new b(context, a.aHP);
        this.aHs.setAutoScrollIntervalTime(5000L);
        this.aHs.a(context, this.aHR);
        addView(this.aHQ, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.h(context, e.C0175e.ds20), l.h(context, e.C0175e.ds16));
        addView(this.aHv, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(e.d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.h(context, e.C0175e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.aHs.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aHQ.removeAllViews();
        this.aHs.setDatas(list);
    }

    private void Ex() {
        this.aHv.setSelector(al.getDrawable(e.f.icon_diandian_white_s));
        this.aHv.setDrawable(al.getDrawable(e.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aHR != null) {
            this.aHR.setOnItemClickListener(aVar);
        }
    }
}
