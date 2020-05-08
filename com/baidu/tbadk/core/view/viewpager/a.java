package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends y.a {
    public int afW;
    public RelativeLayout dKP;
    public TextView dKQ;
    public IndicatorView dKR;
    public View dKS;
    public BdBaseViewPager dKT;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.afW = 3;
        this.title = null;
        this.dKQ = null;
        this.dKR = null;
        this.dKS = null;
        this.dKT = null;
        this.dKP = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dKQ = (TextView) view.findViewById(R.id.more_textview);
        this.dKR = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dKS = view.findViewById(R.id.bottom_divider_line);
        this.dKT = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
