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
    private com.baidu.tbadk.core.view.viewpager.b aCM;
    private IndicatorView aCP;
    private ViewPager aDk;
    private b aDl;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        bB(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bB(context);
    }

    private void bB(Context context) {
        this.aDk = new ViewPager(context);
        this.aCP = new IndicatorView(context);
        this.aCP.setSpacing(0);
        Cs();
        this.aCM = new com.baidu.tbadk.core.view.viewpager.b(context, this.aDk, this.aCP, null);
        this.aDl = new b(context, a.aDj);
        this.aCM.setAutoScrollIntervalTime(5000L);
        this.aCM.a(context, this.aDl);
        addView(this.aDk, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.h(context, e.C0141e.ds20), l.h(context, e.C0141e.ds16));
        addView(this.aCP, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(e.d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.h(context, e.C0141e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.aCM.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aDk.removeAllViews();
        this.aCM.setDatas(list);
    }

    private void Cs() {
        this.aCP.setSelector(al.getDrawable(e.f.icon_diandian_white_s));
        this.aCP.setDrawable(al.getDrawable(e.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aDl != null) {
            this.aDl.setOnItemClickListener(aVar);
        }
    }
}
