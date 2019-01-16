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
    public int aMj;
    public RelativeLayout aMn;
    public TextView aMo;
    public IndicatorView aMp;
    public View aMq;
    public BdBaseViewPager aMr;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aMj = 3;
        this.title = null;
        this.aMo = null;
        this.aMp = null;
        this.aMq = null;
        this.aMr = null;
        this.aMn = (RelativeLayout) view.findViewById(e.g.top_area);
        this.title = (TextView) view.findViewById(e.g.theme_title);
        this.aMo = (TextView) view.findViewById(e.g.more_textview);
        this.aMp = (IndicatorView) view.findViewById(e.g.tab_indicator);
        this.aMq = view.findViewById(e.g.bottom_divider_line);
        this.aMr = (BdBaseViewPager) view.findViewById(e.g.bd_base_view_pager);
    }
}
