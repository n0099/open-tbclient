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
    public int MH;
    public RelativeLayout dgk;
    public TextView dgl;
    public IndicatorView dgm;
    public View dgn;
    public BdBaseViewPager dgo;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.MH = 3;
        this.title = null;
        this.dgl = null;
        this.dgm = null;
        this.dgn = null;
        this.dgo = null;
        this.dgk = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dgl = (TextView) view.findViewById(R.id.more_textview);
        this.dgm = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dgn = view.findViewById(R.id.bottom_divider_line);
        this.dgo = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
