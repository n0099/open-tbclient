package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a extends q.a {
    public int aHp;
    public RelativeLayout aHt;
    public TextView aHu;
    public IndicatorView aHv;
    public View aHw;
    public BdBaseViewPager aHx;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aHp = 3;
        this.title = null;
        this.aHu = null;
        this.aHv = null;
        this.aHw = null;
        this.aHx = null;
        this.aHt = (RelativeLayout) view.findViewById(e.g.top_area);
        this.title = (TextView) view.findViewById(e.g.theme_title);
        this.aHu = (TextView) view.findViewById(e.g.more_textview);
        this.aHv = (IndicatorView) view.findViewById(e.g.tab_indicator);
        this.aHw = view.findViewById(e.g.bottom_divider_line);
        this.aHx = (BdBaseViewPager) view.findViewById(e.g.bd_base_view_pager);
    }
}
