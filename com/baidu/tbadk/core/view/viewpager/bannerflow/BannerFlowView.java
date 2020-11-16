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
    private com.baidu.tbadk.core.view.viewpager.b eZV;
    private IndicatorView eZY;
    private ViewPager fas;
    private b fat;
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
        this.fas = new ViewPager(context);
        this.eZY = new IndicatorView(context);
        this.eZY.setSpacing(0);
        btj();
        this.eZV = new com.baidu.tbadk.core.view.viewpager.b(context, this.fas, this.eZY, null);
        this.fat = new b(context, a.far);
        this.eZV.setAutoScrollIntervalTime(5000L);
        this.eZV.a(context, this.fat);
        addView(this.fas, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.eZY, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ap.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.eZV.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.fas.removeAllViews();
        this.eZV.setDatas(list);
    }

    private void btj() {
        this.eZY.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.eZY.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.fat != null) {
            this.fat.setOnItemClickListener(aVar);
        }
    }
}
