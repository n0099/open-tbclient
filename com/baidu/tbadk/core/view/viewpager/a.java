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
    public int bUK;
    public RelativeLayout bUO;
    public TextView bUP;
    public IndicatorView bUQ;
    public View bUR;
    public BdBaseViewPager bUS;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.bUK = 3;
        this.title = null;
        this.bUP = null;
        this.bUQ = null;
        this.bUR = null;
        this.bUS = null;
        this.bUO = (RelativeLayout) view.findViewById(d.g.top_area);
        this.title = (TextView) view.findViewById(d.g.theme_title);
        this.bUP = (TextView) view.findViewById(d.g.more_textview);
        this.bUQ = (IndicatorView) view.findViewById(d.g.tab_indicator);
        this.bUR = view.findViewById(d.g.bottom_divider_line);
        this.bUS = (BdBaseViewPager) view.findViewById(d.g.bd_base_view_pager);
    }
}
