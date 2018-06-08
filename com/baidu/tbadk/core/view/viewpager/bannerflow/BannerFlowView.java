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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b aza;
    private IndicatorView azd;
    private ViewPager azy;
    private b azz;
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
        this.azy = new ViewPager(context);
        this.azd = new IndicatorView(context);
        this.azd.setSpacing(0);
        Ba();
        this.aza = new com.baidu.tbadk.core.view.viewpager.b(context, this.azy, this.azd, null);
        this.azz = new b(context, a.azx);
        this.aza.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.aza.a(context, this.azz);
        addView(this.azy, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.e(context, d.e.ds20), l.e(context, d.e.ds16));
        addView(this.azd, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(d.C0141d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.e(context, d.e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.aza.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.azy.removeAllViews();
        this.aza.setDatas(list);
    }

    private void Ba() {
        this.azd.setSelector(al.getDrawable(d.f.icon_diandian_white_s));
        this.azd.setDrawable(al.getDrawable(d.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.azz != null) {
            this.azz.setOnItemClickListener(aVar);
        }
    }
}
