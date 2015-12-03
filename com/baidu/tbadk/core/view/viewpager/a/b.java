package com.baidu.tbadk.core.view.viewpager.a;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.core.view.viewpager.a.c;
import com.baidu.tbadk.core.view.viewpager.d;
import com.baidu.tbadk.core.view.viewpager.g;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class b extends FrameLayout implements BdBaseViewPager.a {
    private View MF;
    private ViewPager agA;
    private c agB;
    private d agb;
    private IndicatorView agf;

    public b(Context context) {
        super(context);
        aj(context);
    }

    private void aj(Context context) {
        this.agA = new ViewPager(context);
        this.agf = new IndicatorView(context);
        this.agf.setSpacing(0);
        wz();
        this.agb = new d(context, this.agA, this.agf, null);
        this.agB = new c(context, a.agz);
        this.agb.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.agb.a(context, this.agB);
        addView(this.agA, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, k.d(context, n.d.ds20), k.d(context, n.d.ds16));
        addView(this.agf, layoutParams);
        this.MF = new View(context);
        this.MF.setBackgroundColor(as.getColor(n.c.black_alpha10));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, k.d(context, n.d.ds1));
        layoutParams2.gravity = 80;
        addView(this.MF, layoutParams2);
    }

    public void setMaxScrollCountLimit(int i) {
        this.agb.setMaxScrollCountLimit(i);
    }

    public void setData(List<u> list) {
        this.agA.removeAllViews();
        this.agb.setDatas(list);
    }

    private void wz() {
        this.agf.setSelector(as.getDrawable(n.e.icon_diandian_white_s));
        this.agf.setDrawable(as.getDrawable(n.e.icon_diandian_white_n));
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wp() {
        this.agb.wp();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wq() {
        this.agb.wq();
    }

    public void setOnItemClickListener(g.a<a, c.a> aVar) {
        if (this.agB != null) {
            this.agB.setOnItemClickListener(aVar);
        }
    }
}
