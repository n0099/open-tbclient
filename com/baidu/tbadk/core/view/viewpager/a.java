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
    public int aku;
    public RelativeLayout fht;
    public TextView fhu;
    public IndicatorView fhv;
    public View fhw;
    public BdBaseViewPager fhx;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aku = 3;
        this.title = null;
        this.fhu = null;
        this.fhv = null;
        this.fhw = null;
        this.fhx = null;
        this.fht = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.fhu = (TextView) view.findViewById(R.id.more_textview);
        this.fhv = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.fhw = view.findViewById(R.id.bottom_divider_line);
        this.fhx = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
