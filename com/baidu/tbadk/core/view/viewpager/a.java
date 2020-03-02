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
    public int Ni;
    public RelativeLayout dkr;
    public TextView dks;
    public IndicatorView dkt;
    public View dku;
    public BdBaseViewPager dkv;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.Ni = 3;
        this.title = null;
        this.dks = null;
        this.dkt = null;
        this.dku = null;
        this.dkv = null;
        this.dkr = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dks = (TextView) view.findViewById(R.id.more_textview);
        this.dkt = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dku = view.findViewById(R.id.bottom_divider_line);
        this.dkv = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
