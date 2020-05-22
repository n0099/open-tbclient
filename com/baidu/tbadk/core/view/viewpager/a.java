package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends aa.a {
    public int agt;
    public RelativeLayout dZg;
    public TextView dZh;
    public IndicatorView dZi;
    public View dZj;
    public BdBaseViewPager dZk;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.agt = 3;
        this.title = null;
        this.dZh = null;
        this.dZi = null;
        this.dZj = null;
        this.dZk = null;
        this.dZg = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dZh = (TextView) view.findViewById(R.id.more_textview);
        this.dZi = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dZj = view.findViewById(R.id.bottom_divider_line);
        this.dZk = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
