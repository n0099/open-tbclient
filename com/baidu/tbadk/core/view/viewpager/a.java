package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends ad.a {
    public int aho;
    public RelativeLayout eob;
    public TextView eoc;
    public IndicatorView eod;
    public View eoe;
    public BdBaseViewPager eog;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aho = 3;
        this.title = null;
        this.eoc = null;
        this.eod = null;
        this.eoe = null;
        this.eog = null;
        this.eob = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.eoc = (TextView) view.findViewById(R.id.more_textview);
        this.eod = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.eoe = view.findViewById(R.id.bottom_divider_line);
        this.eog = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
