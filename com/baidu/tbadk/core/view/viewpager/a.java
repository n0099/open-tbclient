package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends q.a {
    public int ayX;
    public RelativeLayout azb;
    public TextView azc;
    public IndicatorView azd;
    public View aze;
    public BdBaseViewPager azf;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ayX = 3;
        this.title = null;
        this.azc = null;
        this.azd = null;
        this.aze = null;
        this.azf = null;
        this.azb = (RelativeLayout) view.findViewById(d.g.top_area);
        this.title = (TextView) view.findViewById(d.g.theme_title);
        this.azc = (TextView) view.findViewById(d.g.more_textview);
        this.azd = (IndicatorView) view.findViewById(d.g.tab_indicator);
        this.aze = view.findViewById(d.g.bottom_divider_line);
        this.azf = (BdBaseViewPager) view.findViewById(d.g.bd_base_view_pager);
    }
}
