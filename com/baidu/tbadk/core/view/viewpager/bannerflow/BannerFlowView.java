package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private ViewPager aAg;
    private b aAh;
    private com.baidu.tbadk.core.view.viewpager.b azI;
    private IndicatorView azL;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        aW(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aW(context);
    }

    private void aW(Context context) {
        this.aAg = new ViewPager(context);
        this.azL = new IndicatorView(context);
        this.azL.setSpacing(0);
        Bg();
        this.azI = new com.baidu.tbadk.core.view.viewpager.b(context, this.aAg, this.azL, null);
        this.aAh = new b(context, a.aAf);
        this.azI.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.azI.a(context, this.aAh);
        addView(this.aAg, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.f(context, f.e.ds20), l.f(context, f.e.ds16));
        addView(this.azL, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(f.d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.f(context, f.e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.azI.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aAg.removeAllViews();
        this.azI.setDatas(list);
    }

    private void Bg() {
        this.azL.setSelector(am.getDrawable(f.C0146f.icon_diandian_white_s));
        this.azL.setDrawable(am.getDrawable(f.C0146f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aAh != null) {
            this.aAh.setOnItemClickListener(aVar);
        }
    }
}
