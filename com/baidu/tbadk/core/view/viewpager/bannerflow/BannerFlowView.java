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
    private ViewPager fhP;
    private b fhQ;
    private com.baidu.tbadk.core.view.viewpager.b fhs;
    private IndicatorView fhv;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        ev(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ev(context);
    }

    private void ev(Context context) {
        this.fhP = new ViewPager(context);
        this.fhv = new IndicatorView(context);
        this.fhv.setSpacing(0);
        bwJ();
        this.fhs = new com.baidu.tbadk.core.view.viewpager.b(context, this.fhP, this.fhv, null);
        this.fhQ = new b(context, a.fhO);
        this.fhs.setAutoScrollIntervalTime(5000L);
        this.fhs.a(context, this.fhQ);
        addView(this.fhP, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.fhv, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ap.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.fhs.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.fhP.removeAllViews();
        this.fhs.setDatas(list);
    }

    private void bwJ() {
        this.fhv.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.fhv.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.fhQ != null) {
            this.fhQ.setOnItemClickListener(aVar);
        }
    }
}
