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
    public int aLF;
    public RelativeLayout aLJ;
    public TextView aLK;
    public IndicatorView aLL;
    public View aLM;
    public BdBaseViewPager aLN;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aLF = 3;
        this.title = null;
        this.aLK = null;
        this.aLL = null;
        this.aLM = null;
        this.aLN = null;
        this.aLJ = (RelativeLayout) view.findViewById(e.g.top_area);
        this.title = (TextView) view.findViewById(e.g.theme_title);
        this.aLK = (TextView) view.findViewById(e.g.more_textview);
        this.aLL = (IndicatorView) view.findViewById(e.g.tab_indicator);
        this.aLM = view.findViewById(e.g.bottom_divider_line);
        this.aLN = (BdBaseViewPager) view.findViewById(e.g.bd_base_view_pager);
    }
}
