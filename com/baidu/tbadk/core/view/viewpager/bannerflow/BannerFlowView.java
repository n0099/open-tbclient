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
    private com.baidu.tbadk.core.view.viewpager.b faN;
    private IndicatorView faQ;
    private ViewPager fbk;
    private b fbl;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        dQ(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dQ(context);
    }

    private void dQ(Context context) {
        this.fbk = new ViewPager(context);
        this.faQ = new IndicatorView(context);
        this.faQ.setSpacing(0);
        btT();
        this.faN = new com.baidu.tbadk.core.view.viewpager.b(context, this.fbk, this.faQ, null);
        this.fbl = new b(context, a.fbj);
        this.faN.setAutoScrollIntervalTime(5000L);
        this.faN.a(context, this.fbl);
        addView(this.fbk, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.faQ, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ap.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.faN.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.fbk.removeAllViews();
        this.faN.setDatas(list);
    }

    private void btT() {
        this.faQ.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.faQ.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.fbl != null) {
            this.fbl.setOnItemClickListener(aVar);
        }
    }
}
