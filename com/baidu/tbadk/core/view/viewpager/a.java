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
    public int ccI;
    public RelativeLayout ccM;
    public TextView ccN;
    public IndicatorView ccO;
    public View ccP;
    public BdBaseViewPager ccQ;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ccI = 3;
        this.title = null;
        this.ccN = null;
        this.ccO = null;
        this.ccP = null;
        this.ccQ = null;
        this.ccM = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.ccN = (TextView) view.findViewById(R.id.more_textview);
        this.ccO = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.ccP = view.findViewById(R.id.bottom_divider_line);
        this.ccQ = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
