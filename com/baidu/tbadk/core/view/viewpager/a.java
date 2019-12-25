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
    public int MA;
    public RelativeLayout dfY;
    public TextView dfZ;
    public IndicatorView dga;
    public View dgb;
    public BdBaseViewPager dgc;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.MA = 3;
        this.title = null;
        this.dfZ = null;
        this.dga = null;
        this.dgb = null;
        this.dgc = null;
        this.dfY = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dfZ = (TextView) view.findViewById(R.id.more_textview);
        this.dga = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dgb = view.findViewById(R.id.bottom_divider_line);
        this.dgc = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
