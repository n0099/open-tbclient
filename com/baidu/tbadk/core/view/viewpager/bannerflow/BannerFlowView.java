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
    private ViewPager aMK;
    private b aML;
    private com.baidu.tbadk.core.view.viewpager.b aMm;
    private IndicatorView aMp;
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
        this.aMK = new ViewPager(context);
        this.aMp = new IndicatorView(context);
        this.aMp.setSpacing(0);
        FZ();
        this.aMm = new com.baidu.tbadk.core.view.viewpager.b(context, this.aMK, this.aMp, null);
        this.aML = new b(context, a.aMJ);
        this.aMm.setAutoScrollIntervalTime(5000L);
        this.aMm.a(context, this.aML);
        addView(this.aMK, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.h(context, e.C0210e.ds20), l.h(context, e.C0210e.ds16));
        addView(this.aMp, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(al.getColor(e.d.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.h(context, e.C0210e.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.aMm.setMaxScrollCountLimit(i);
    }

    public void setData(List<h> list) {
        this.aMK.removeAllViews();
        this.aMm.setDatas(list);
    }

    private void FZ() {
        this.aMp.setSelector(al.getDrawable(e.f.icon_diandian_white_s));
        this.aMp.setDrawable(al.getDrawable(e.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.aML != null) {
            this.aML.setOnItemClickListener(aVar);
        }
    }
}
