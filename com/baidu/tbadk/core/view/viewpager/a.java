package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends v.a {
    public int csX;
    public RelativeLayout ctb;
    public TextView ctc;
    public IndicatorView ctd;
    public View cte;
    public BdBaseViewPager ctf;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.csX = 3;
        this.title = null;
        this.ctc = null;
        this.ctd = null;
        this.cte = null;
        this.ctf = null;
        this.ctb = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.ctc = (TextView) view.findViewById(R.id.more_textview);
        this.ctd = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.cte = view.findViewById(R.id.bottom_divider_line);
        this.ctf = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
