package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends q.a {
    public int azI;
    public RelativeLayout azM;
    public TextView azN;
    public IndicatorView azO;
    public View azP;
    public BdBaseViewPager azQ;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.azI = 3;
        this.title = null;
        this.azN = null;
        this.azO = null;
        this.azP = null;
        this.azQ = null;
        this.azM = (RelativeLayout) view.findViewById(d.g.top_area);
        this.title = (TextView) view.findViewById(d.g.theme_title);
        this.azN = (TextView) view.findViewById(d.g.more_textview);
        this.azO = (IndicatorView) view.findViewById(d.g.tab_indicator);
        this.azP = view.findViewById(d.g.bottom_divider_line);
        this.azQ = (BdBaseViewPager) view.findViewById(d.g.bd_base_view_pager);
    }
}
