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
    public int ceL;
    public RelativeLayout ceP;
    public TextView ceQ;
    public IndicatorView ceR;
    public View ceS;
    public BdBaseViewPager ceT;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ceL = 3;
        this.title = null;
        this.ceQ = null;
        this.ceR = null;
        this.ceS = null;
        this.ceT = null;
        this.ceP = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.ceQ = (TextView) view.findViewById(R.id.more_textview);
        this.ceR = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.ceS = view.findViewById(R.id.bottom_divider_line);
        this.ceT = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
