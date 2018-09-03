package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class a extends q.a {
    public int azF;
    public RelativeLayout azJ;
    public TextView azK;
    public IndicatorView azL;
    public View azM;
    public BdBaseViewPager azN;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.azF = 3;
        this.title = null;
        this.azK = null;
        this.azL = null;
        this.azM = null;
        this.azN = null;
        this.azJ = (RelativeLayout) view.findViewById(f.g.top_area);
        this.title = (TextView) view.findViewById(f.g.theme_title);
        this.azK = (TextView) view.findViewById(f.g.more_textview);
        this.azL = (IndicatorView) view.findViewById(f.g.tab_indicator);
        this.azM = view.findViewById(f.g.bottom_divider_line);
        this.azN = (BdBaseViewPager) view.findViewById(f.g.bd_base_view_pager);
    }
}
