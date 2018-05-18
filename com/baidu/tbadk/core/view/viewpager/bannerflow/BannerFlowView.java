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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b aqT;
    private IndicatorView aqW;
    private ViewPager ars;
    private b art;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        aM(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aM(context);
    }

    private void aM(Context context) {
        this.ars = new ViewPager(context);
        this.aqW = new IndicatorView(context);
        this.aqW.setSpacing(0);
        xz();
        this.aqT = new com.baidu.tbadk.core.view.viewpager.b(context, this.ars, this.aqW, null);
        this.art = new b(context, a.arr);
        this.aqT.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.aqT.a(context, this.art);
        addView(this.ars, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.e(context, d.e.ds20), l.e(context, d.e.ds16));
        addView(this.aqW, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ak.getColor(d.C0126d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.e(context, d.e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.aqT.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.ars.removeAllViews();
        this.aqT.setDatas(list);
    }

    private void xz() {
        this.aqW.setSelector(ak.getDrawable(d.f.icon_diandian_white_s));
        this.aqW.setDrawable(ak.getDrawable(d.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.art != null) {
            this.art.setOnItemClickListener(aVar);
        }
    }
}
