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
    private ViewPager fmQ;
    private b fmR;
    private com.baidu.tbadk.core.view.viewpager.a fmt;
    private IndicatorView fmw;
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
        this.fmQ = new ViewPager(context);
        this.fmw = new IndicatorView(context);
        this.fmw.setSpacing(0);
        bvj();
        this.fmt = new com.baidu.tbadk.core.view.viewpager.a(context, this.fmQ, this.fmw, null);
        this.fmR = new b(context, a.fmP);
        this.fmt.setAutoScrollIntervalTime(5000L);
        this.fmt.a(context, this.fmR);
        addView(this.fmQ, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.fmw, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ao.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.fmt.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.fmQ.removeAllViews();
        this.fmt.setDatas(list);
    }

    private void bvj() {
        this.fmw.setSelector(ao.getDrawable(R.drawable.icon_diandian_white_s));
        this.fmw.setDrawable(ao.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<a, b.a> aVar) {
        if (this.fmR != null) {
            this.fmR.setOnItemClickListener(aVar);
        }
    }
}
