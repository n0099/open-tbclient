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
    private ViewPager csH;
    private b csI;
    private com.baidu.tbadk.core.view.viewpager.b csj;
    private IndicatorView csm;
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
        this.csH = new ViewPager(context);
        this.csm = new IndicatorView(context);
        this.csm.setSpacing(0);
        aou();
        this.csj = new com.baidu.tbadk.core.view.viewpager.b(context, this.csH, this.csm, null);
        this.csI = new b(context, a.csG);
        this.csj.setAutoScrollIntervalTime(5000L);
        this.csj.a(context, this.csI);
        addView(this.csH, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.csm, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.csj.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.csH.removeAllViews();
        this.csj.setDatas(list);
    }

    private void aou() {
        this.csm.setSelector(am.getDrawable(R.drawable.icon_diandian_white_s));
        this.csm.setDrawable(am.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.csI != null) {
            this.csI.setOnItemClickListener(aVar);
        }
    }
}
