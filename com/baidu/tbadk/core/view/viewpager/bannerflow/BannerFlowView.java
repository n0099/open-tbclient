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
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private ViewPager eAS;
    private b eAT;
    private com.baidu.tbadk.core.view.viewpager.b eAv;
    private IndicatorView eAy;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        dK(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dK(context);
    }

    private void dK(Context context) {
        this.eAS = new ViewPager(context);
        this.eAy = new IndicatorView(context);
        this.eAy.setSpacing(0);
        bmQ();
        this.eAv = new com.baidu.tbadk.core.view.viewpager.b(context, this.eAS, this.eAy, null);
        this.eAT = new b(context, a.eAR);
        this.eAv.setAutoScrollIntervalTime(5000L);
        this.eAv.a(context, this.eAT);
        addView(this.eAS, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.eAy, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ap.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.eAv.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.eAS.removeAllViews();
        this.eAv.setDatas(list);
    }

    private void bmQ() {
        this.eAy.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.eAy.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.eAT != null) {
            this.eAT.setOnItemClickListener(aVar);
        }
    }
}
