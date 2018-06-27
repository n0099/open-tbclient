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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private ViewPager aAq;
    private b aAr;
    private com.baidu.tbadk.core.view.viewpager.b azS;
    private IndicatorView azV;
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
        this.aAq = new ViewPager(context);
        this.azV = new IndicatorView(context);
        this.azV.setSpacing(0);
        Bs();
        this.azS = new com.baidu.tbadk.core.view.viewpager.b(context, this.aAq, this.azV, null);
        this.aAr = new b(context, a.aAp);
        this.azS.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.azS.a(context, this.aAr);
        addView(this.aAq, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.e(context, d.e.ds20), l.e(context, d.e.ds16));
        addView(this.azV, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(d.C0142d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.e(context, d.e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.azS.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aAq.removeAllViews();
        this.azS.setDatas(list);
    }

    private void Bs() {
        this.azV.setSelector(am.getDrawable(d.f.icon_diandian_white_s));
        this.azV.setDrawable(am.getDrawable(d.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aAr != null) {
            this.aAr.setOnItemClickListener(aVar);
        }
    }
}
