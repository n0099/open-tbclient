package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private ViewPager dZC;
    private b dZD;
    private com.baidu.tbadk.core.view.viewpager.b dZf;
    private IndicatorView dZi;
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
        this.dZC = new ViewPager(context);
        this.dZi = new IndicatorView(context);
        this.dZi.setSpacing(0);
        aXn();
        this.dZf = new com.baidu.tbadk.core.view.viewpager.b(context, this.dZC, this.dZi, null);
        this.dZD = new b(context, a.dZB);
        this.dZf.setAutoScrollIntervalTime(5000L);
        this.dZf.a(context, this.dZD);
        addView(this.dZC, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.dZi, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.dZf.setMaxScrollCountLimit(i);
    }

    public void setData(List<o> list) {
        this.dZC.removeAllViews();
        this.dZf.setDatas(list);
    }

    private void aXn() {
        this.dZi.setSelector(am.getDrawable(R.drawable.icon_diandian_white_s));
        this.dZi.setDrawable(am.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.dZD != null) {
            this.dZD.setOnItemClickListener(aVar);
        }
    }
}
