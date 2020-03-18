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
    public int Nj;
    public RelativeLayout dkR;
    public TextView dkS;
    public IndicatorView dkT;
    public View dkU;
    public BdBaseViewPager dkV;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.Nj = 3;
        this.title = null;
        this.dkS = null;
        this.dkT = null;
        this.dkU = null;
        this.dkV = null;
        this.dkR = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dkS = (TextView) view.findViewById(R.id.more_textview);
        this.dkT = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dkU = view.findViewById(R.id.bottom_divider_line);
        this.dkV = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
