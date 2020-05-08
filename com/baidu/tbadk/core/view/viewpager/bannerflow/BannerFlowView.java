package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b dKO;
    private IndicatorView dKR;
    private ViewPager dLl;
    private b dLm;
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
        this.dLl = new ViewPager(context);
        this.dKR = new IndicatorView(context);
        this.dKR.setSpacing(0);
        aRf();
        this.dKO = new com.baidu.tbadk.core.view.viewpager.b(context, this.dLl, this.dKR, null);
        this.dLm = new b(context, a.dLk);
        this.dKO.setAutoScrollIntervalTime(5000L);
        this.dKO.a(context, this.dLm);
        addView(this.dLl, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.dKR, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.dKO.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.dLl.removeAllViews();
        this.dKO.setDatas(list);
    }

    private void aRf() {
        this.dKR.setSelector(am.getDrawable(R.drawable.icon_diandian_white_s));
        this.dKR.setDrawable(am.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.dLm != null) {
            this.dLm.setOnItemClickListener(aVar);
        }
    }
}
