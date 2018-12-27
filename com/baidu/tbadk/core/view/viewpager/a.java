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
    public int aLH;
    public RelativeLayout aLL;
    public TextView aLM;
    public IndicatorView aLN;
    public View aLO;
    public BdBaseViewPager aLP;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aLH = 3;
        this.title = null;
        this.aLM = null;
        this.aLN = null;
        this.aLO = null;
        this.aLP = null;
        this.aLL = (RelativeLayout) view.findViewById(e.g.top_area);
        this.title = (TextView) view.findViewById(e.g.theme_title);
        this.aLM = (TextView) view.findViewById(e.g.more_textview);
        this.aLN = (IndicatorView) view.findViewById(e.g.tab_indicator);
        this.aLO = view.findViewById(e.g.bottom_divider_line);
        this.aLP = (BdBaseViewPager) view.findViewById(e.g.bd_base_view_pager);
    }
}
