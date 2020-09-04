package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends af.a {
    public int aiD;
    public RelativeLayout eys;
    public TextView eyt;
    public IndicatorView eyu;
    public View eyv;
    public BdBaseViewPager eyw;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aiD = 3;
        this.title = null;
        this.eyt = null;
        this.eyu = null;
        this.eyv = null;
        this.eyw = null;
        this.eys = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.eyt = (TextView) view.findViewById(R.id.more_textview);
        this.eyu = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.eyv = view.findViewById(R.id.bottom_divider_line);
        this.eyw = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
