package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.viewpager.b;
import com.baidu.tbadk.core.view.viewpager.bannerflow.b;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannerFlowView extends FrameLayout {
    private com.baidu.tbadk.core.view.viewpager.a foL;
    private IndicatorView foO;
    private ViewPager fpi;
    private b fpj;
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
        this.fpi = new ViewPager(context);
        this.foO = new IndicatorView(context);
        this.foO.setSpacing(0);
        bvD();
        this.foL = new com.baidu.tbadk.core.view.viewpager.a(context, this.fpi, this.foO, null);
        this.fpj = new b(context, a.fph);
        this.foL.setAutoScrollIntervalTime(5000L);
        this.foL.a(context, this.fpj);
        addView(this.fpi, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.ds20), l.getDimens(context, R.dimen.ds16));
        addView(this.foO, layoutParams);
        this.mBottomLine = new View(context);
        this.mBottomLine.setBackgroundColor(ap.getColor(R.color.common_color_10043));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(context, R.dimen.ds1));
        layoutParams2.gravity = 80;
        addView(this.mBottomLine, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.foL.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.fpi.removeAllViews();
        this.foL.setDatas(list);
    }

    private void bvD() {
        this.foO.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.foO.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<a, b.a> aVar) {
        if (this.fpj != null) {
            this.fpj.setOnItemClickListener(aVar);
        }
    }
}
