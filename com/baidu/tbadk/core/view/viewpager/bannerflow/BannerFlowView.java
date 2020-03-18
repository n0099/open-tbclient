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
    private com.baidu.tbadk.core.view.viewpager.b dkQ;
    private IndicatorView dkT;
    private ViewPager dln;
    private b dlo;
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
        this.dln = new ViewPager(context);
        this.dkT = new IndicatorView(context);
        this.dkT.setSpacing(0);
        aIM();
        this.dkQ = new com.baidu.tbadk.core.view.viewpager.b(context, this.dln, this.dkT, null);
        this.dlo = new b(context, a.dlm);
        this.dkQ.setAutoScrollIntervalTime(5000L);
        this.dkQ.a(context, this.dlo);
        addView(this.dln, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.dkT, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(am.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.dkQ.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.dln.removeAllViews();
        this.dkQ.setDatas(list);
    }

    private void aIM() {
        this.dkT.setSelector(am.getDrawable(R.drawable.icon_diandian_white_s));
        this.dkT.setDrawable(am.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.dlo != null) {
            this.dlo.setOnItemClickListener(aVar);
        }
    }
}
