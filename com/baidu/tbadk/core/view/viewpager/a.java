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
    public int ccJ;
    public RelativeLayout ccN;
    public TextView ccO;
    public IndicatorView ccP;
    public View ccQ;
    public BdBaseViewPager ccR;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ccJ = 3;
        this.title = null;
        this.ccO = null;
        this.ccP = null;
        this.ccQ = null;
        this.ccR = null;
        this.ccN = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.ccO = (TextView) view.findViewById(R.id.more_textview);
        this.ccP = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.ccQ = view.findViewById(R.id.bottom_divider_line);
        this.ccR = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
