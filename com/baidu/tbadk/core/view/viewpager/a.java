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
    public int bUM;
    public RelativeLayout bUQ;
    public TextView bUR;
    public IndicatorView bUS;
    public View bUT;
    public BdBaseViewPager bUU;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.bUM = 3;
        this.title = null;
        this.bUR = null;
        this.bUS = null;
        this.bUT = null;
        this.bUU = null;
        this.bUQ = (RelativeLayout) view.findViewById(d.g.top_area);
        this.title = (TextView) view.findViewById(d.g.theme_title);
        this.bUR = (TextView) view.findViewById(d.g.more_textview);
        this.bUS = (IndicatorView) view.findViewById(d.g.tab_indicator);
        this.bUT = view.findViewById(d.g.bottom_divider_line);
        this.bUU = (BdBaseViewPager) view.findViewById(d.g.bd_base_view_pager);
    }
}
