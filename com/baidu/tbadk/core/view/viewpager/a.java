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
    public int cdL;
    public RelativeLayout cdP;
    public TextView cdQ;
    public IndicatorView cdR;
    public View cdS;
    public BdBaseViewPager cdT;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.cdL = 3;
        this.title = null;
        this.cdQ = null;
        this.cdR = null;
        this.cdS = null;
        this.cdT = null;
        this.cdP = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.cdQ = (TextView) view.findViewById(R.id.more_textview);
        this.cdR = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.cdS = view.findViewById(R.id.bottom_divider_line);
        this.cdT = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
