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
    public int aiX;
    public BdBaseViewPager eAA;
    public RelativeLayout eAw;
    public TextView eAx;
    public IndicatorView eAy;
    public View eAz;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aiX = 3;
        this.title = null;
        this.eAx = null;
        this.eAy = null;
        this.eAz = null;
        this.eAA = null;
        this.eAw = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.eAx = (TextView) view.findViewById(R.id.more_textview);
        this.eAy = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.eAz = view.findViewById(R.id.bottom_divider_line);
        this.eAA = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
