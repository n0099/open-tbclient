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
    public int bUN;
    public RelativeLayout bUR;
    public TextView bUS;
    public IndicatorView bUT;
    public View bUU;
    public BdBaseViewPager bUV;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.bUN = 3;
        this.title = null;
        this.bUS = null;
        this.bUT = null;
        this.bUU = null;
        this.bUV = null;
        this.bUR = (RelativeLayout) view.findViewById(d.g.top_area);
        this.title = (TextView) view.findViewById(d.g.theme_title);
        this.bUS = (TextView) view.findViewById(d.g.more_textview);
        this.bUT = (IndicatorView) view.findViewById(d.g.tab_indicator);
        this.bUU = view.findViewById(d.g.bottom_divider_line);
        this.bUV = (BdBaseViewPager) view.findViewById(d.g.bd_base_view_pager);
    }
}
