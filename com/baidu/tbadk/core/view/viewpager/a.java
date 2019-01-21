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
    public int aMk;
    public RelativeLayout aMo;
    public TextView aMp;
    public IndicatorView aMq;
    public View aMr;
    public BdBaseViewPager aMs;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aMk = 3;
        this.title = null;
        this.aMp = null;
        this.aMq = null;
        this.aMr = null;
        this.aMs = null;
        this.aMo = (RelativeLayout) view.findViewById(e.g.top_area);
        this.title = (TextView) view.findViewById(e.g.theme_title);
        this.aMp = (TextView) view.findViewById(e.g.more_textview);
        this.aMq = (IndicatorView) view.findViewById(e.g.tab_indicator);
        this.aMr = view.findViewById(e.g.bottom_divider_line);
        this.aMs = (BdBaseViewPager) view.findViewById(e.g.bd_base_view_pager);
    }
}
