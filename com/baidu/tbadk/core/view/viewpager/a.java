package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends q.a {
    public int aqQ;
    public RelativeLayout aqU;
    public TextView aqV;
    public IndicatorView aqW;
    public View aqX;
    public BdBaseViewPager aqY;
    public TextView title;

    public a(View view2, Context context) {
        super(view2);
        this.aqQ = 3;
        this.title = null;
        this.aqV = null;
        this.aqW = null;
        this.aqX = null;
        this.aqY = null;
        this.aqU = (RelativeLayout) view2.findViewById(d.g.top_area);
        this.title = (TextView) view2.findViewById(d.g.theme_title);
        this.aqV = (TextView) view2.findViewById(d.g.more_textview);
        this.aqW = (IndicatorView) view2.findViewById(d.g.tab_indicator);
        this.aqX = view2.findViewById(d.g.bottom_divider_line);
        this.aqY = (BdBaseViewPager) view2.findViewById(d.g.bd_base_view_pager);
    }
}
