package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class BannerFlowView extends FrameLayout {
    private ViewPager eyK;
    private b eyL;
    private com.baidu.tbadk.core.view.viewpager.b eyn;
    private IndicatorView eyq;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        dL(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dL(context);
    }

    private void dL(Context context) {
        this.eyK = new ViewPager(context);
        this.eyq = new IndicatorView(context);
        this.eyq.setSpacing(0);
        blW();
        this.eyn = new com.baidu.tbadk.core.view.viewpager.b(context, this.eyK, this.eyq, null);
        this.eyL = new b(context, a.eyJ);
        this.eyn.setAutoScrollIntervalTime(5000L);
        this.eyn.a(context, this.eyL);
        addView(this.eyK, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.eyq, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ap.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.eyn.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.eyK.removeAllViews();
        this.eyn.setDatas(list);
    }

    private void blW() {
        this.eyq.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.eyq.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.eyL != null) {
            this.eyL.setOnItemClickListener(aVar);
        }
    }
}
