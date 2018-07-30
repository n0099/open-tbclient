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
    private ViewPager aAj;
    private b aAk;
    private com.baidu.tbadk.core.view.viewpager.b azL;
    private IndicatorView azO;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        aX(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    private void aX(Context context) {
        this.aAj = new ViewPager(context);
        this.azO = new IndicatorView(context);
        this.azO.setSpacing(0);
        Bj();
        this.azL = new com.baidu.tbadk.core.view.viewpager.b(context, this.aAj, this.azO, null);
        this.aAk = new b(context, a.aAi);
        this.azL.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.azL.a(context, this.aAk);
        addView(this.aAj, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.f(context, d.e.ds20), l.f(context, d.e.ds16));
        addView(this.azO, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(d.C0140d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.f(context, d.e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.azL.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aAj.removeAllViews();
        this.azL.setDatas(list);
    }

    private void Bj() {
        this.azO.setSelector(am.getDrawable(d.f.icon_diandian_white_s));
        this.azO.setDrawable(am.getDrawable(d.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aAk != null) {
            this.aAk.setOnItemClickListener(aVar);
        }
    }
}
