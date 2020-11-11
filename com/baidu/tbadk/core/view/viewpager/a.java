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
    public int ajq;
    public RelativeLayout faO;
    public TextView faP;
    public IndicatorView faQ;
    public View faR;
    public BdBaseViewPager faS;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ajq = 3;
        this.title = null;
        this.faP = null;
        this.faQ = null;
        this.faR = null;
        this.faS = null;
        this.faO = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.faP = (TextView) view.findViewById(R.id.more_textview);
        this.faQ = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.faR = view.findViewById(R.id.bottom_divider_line);
        this.faS = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
