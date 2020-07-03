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
    public int ahx;
    public RelativeLayout ehQ;
    public TextView ehR;
    public IndicatorView ehS;
    public View ehT;
    public BdBaseViewPager ehU;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ahx = 3;
        this.title = null;
        this.ehR = null;
        this.ehS = null;
        this.ehT = null;
        this.ehU = null;
        this.ehQ = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.ehR = (TextView) view.findViewById(R.id.more_textview);
        this.ehS = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.ehT = view.findViewById(R.id.bottom_divider_line);
        this.ehU = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
