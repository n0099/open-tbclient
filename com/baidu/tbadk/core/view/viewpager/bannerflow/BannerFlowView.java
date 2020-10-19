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
    private com.baidu.tbadk.core.view.viewpager.b eMC;
    private IndicatorView eMF;
    private ViewPager eMZ;
    private b eNa;
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
        this.eMZ = new ViewPager(context);
        this.eMF = new IndicatorView(context);
        this.eMF.setSpacing(0);
        bpA();
        this.eMC = new com.baidu.tbadk.core.view.viewpager.b(context, this.eMZ, this.eMF, null);
        this.eNa = new b(context, a.eMY);
        this.eMC.setAutoScrollIntervalTime(5000L);
        this.eMC.a(context, this.eNa);
        addView(this.eMZ, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.eMF, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ap.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.eMC.setMaxScrollCountLimit(i);
    }

    public void setData(List<q> list) {
        this.eMZ.removeAllViews();
        this.eMC.setDatas(list);
    }

    private void bpA() {
        this.eMF.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.eMF.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<a, b.a> aVar) {
        if (this.eNa != null) {
            this.eNa.setOnItemClickListener(aVar);
        }
    }
}
