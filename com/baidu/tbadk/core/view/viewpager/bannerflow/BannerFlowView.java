package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b bUP;
    private IndicatorView bUS;
    private ViewPager bVn;
    private b bVo;
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
        this.bVn = new ViewPager(context);
        this.bUS = new IndicatorView(context);
        this.bUS.setSpacing(0);
        afq();
        this.bUP = new com.baidu.tbadk.core.view.viewpager.b(context, this.bVn, this.bUS, null);
        this.bVo = new b(context, a.bVm);
        this.bUP.setAutoScrollIntervalTime(5000L);
        this.bUP.a(context, this.bVo);
        addView(this.bVn, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.h(context, d.e.ds20), l.h(context, d.e.ds16));
        addView(this.bUS, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(d.C0277d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.h(context, d.e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUP.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.bVn.removeAllViews();
        this.bUP.setDatas(list);
    }

    private void afq() {
        this.bUS.setSelector(al.getDrawable(d.f.icon_diandian_white_s));
        this.bUS.setDrawable(al.getDrawable(d.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.bVo != null) {
            this.bVo.setOnItemClickListener(aVar);
        }
    }
}
