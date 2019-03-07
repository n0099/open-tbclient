package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends v.a {
    public int bUJ;
    public RelativeLayout bUN;
    public TextView bUO;
    public IndicatorView bUP;
    public View bUQ;
    public BdBaseViewPager bUR;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.bUJ = 3;
        this.title = null;
        this.bUO = null;
        this.bUP = null;
        this.bUQ = null;
        this.bUR = null;
        this.bUN = (RelativeLayout) view.findViewById(d.g.top_area);
        this.title = (TextView) view.findViewById(d.g.theme_title);
        this.bUO = (TextView) view.findViewById(d.g.more_textview);
        this.bUP = (IndicatorView) view.findViewById(d.g.tab_indicator);
        this.bUQ = view.findViewById(d.g.bottom_divider_line);
        this.bUR = (BdBaseViewPager) view.findViewById(d.g.bd_base_view_pager);
    }
}
