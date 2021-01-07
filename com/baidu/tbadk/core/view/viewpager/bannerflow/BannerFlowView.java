package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.viewpager.b;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private ViewPager frB;
    private b frC;
    private com.baidu.tbadk.core.view.viewpager.a frd;
    private IndicatorView frg;
    private View mBottomLine;

    public BannerFlowView(Context context) {
        super(context);
        eO(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        eO(context);
    }

    private void eO(Context context) {
        this.frB = new ViewPager(context);
        this.frg = new IndicatorView(context);
        this.frg.setSpacing(0);
        bzd();
        this.frd = new com.baidu.tbadk.core.view.viewpager.a(context, this.frB, this.frg, null);
        this.frC = new b(context, a.frA);
        this.frd.setAutoScrollIntervalTime(5000L);
        this.frd.a(context, this.frC);
        addView(this.frB, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.frg, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ao.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.frd.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.frB.removeAllViews();
        this.frd.setDatas(list);
    }

    private void bzd() {
        this.frg.setSelector(ao.getDrawable(R.drawable.icon_diandian_white_s));
        this.frg.setDrawable(ao.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<a, b.a> aVar) {
        if (this.frC != null) {
            this.frC.setOnItemClickListener(aVar);
        }
    }
}
