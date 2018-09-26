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
    public int aCJ;
    public RelativeLayout aCN;
    public TextView aCO;
    public IndicatorView aCP;
    public View aCQ;
    public BdBaseViewPager aCR;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aCJ = 3;
        this.title = null;
        this.aCO = null;
        this.aCP = null;
        this.aCQ = null;
        this.aCR = null;
        this.aCN = (RelativeLayout) view.findViewById(e.g.top_area);
        this.title = (TextView) view.findViewById(e.g.theme_title);
        this.aCO = (TextView) view.findViewById(e.g.more_textview);
        this.aCP = (IndicatorView) view.findViewById(e.g.tab_indicator);
        this.aCQ = view.findViewById(e.g.bottom_divider_line);
        this.aCR = (BdBaseViewPager) view.findViewById(e.g.bd_base_view_pager);
    }
}
