package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends x.a {
    public int afY;
    public RelativeLayout agc;
    public TextView agd;
    public TextView age;
    public IndicatorView agf;
    public View agg;
    public BdBaseViewPager agh;

    public c(View view, Context context) {
        super(view);
        this.afY = 3;
        this.agd = null;
        this.age = null;
        this.agf = null;
        this.agg = null;
        this.agh = null;
        this.agc = (RelativeLayout) view.findViewById(n.f.top_area);
        this.agd = (TextView) view.findViewById(n.f.theme_title);
        this.age = (TextView) view.findViewById(n.f.more_textview);
        this.agf = (IndicatorView) view.findViewById(n.f.tab_indicator);
        this.agg = view.findViewById(n.f.bottom_divider_line);
        this.agh = (BdBaseViewPager) view.findViewById(n.f.bd_base_view_pager);
    }
}
