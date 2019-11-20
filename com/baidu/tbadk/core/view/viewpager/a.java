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
    public int csg;
    public RelativeLayout csk;
    public TextView csl;
    public IndicatorView csm;
    public View csn;
    public BdBaseViewPager cso;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.csg = 3;
        this.title = null;
        this.csl = null;
        this.csm = null;
        this.csn = null;
        this.cso = null;
        this.csk = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.csl = (TextView) view.findViewById(R.id.more_textview);
        this.csm = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.csn = view.findViewById(R.id.bottom_divider_line);
        this.cso = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
