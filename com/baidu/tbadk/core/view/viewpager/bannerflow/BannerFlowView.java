package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.b eoa;
    private IndicatorView eod;
    private ViewPager eoy;
    private b eoz;
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
        this.eoy = new ViewPager(context);
        this.eod = new IndicatorView(context);
        this.eod.setSpacing(0);
        bdq();
        this.eoa = new com.baidu.tbadk.core.view.viewpager.b(context, this.eoy, this.eod, null);
        this.eoz = new b(context, a.eox);
        this.eoa.setAutoScrollIntervalTime(5000L);
        this.eoa.a(context, this.eoz);
        addView(this.eoy, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.eod, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ao.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.eoa.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.eoy.removeAllViews();
        this.eoa.setDatas(list);
    }

    private void bdq() {
        this.eod.setSelector(ao.getDrawable(R.drawable.icon_diandian_white_s));
        this.eod.setDrawable(ao.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.eoz != null) {
            this.eoz.setOnItemClickListener(aVar);
        }
    }
}
