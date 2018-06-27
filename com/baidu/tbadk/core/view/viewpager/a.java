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
    public int azP;
    public RelativeLayout azT;
    public TextView azU;
    public IndicatorView azV;
    public View azW;
    public BdBaseViewPager azX;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.azP = 3;
        this.title = null;
        this.azU = null;
        this.azV = null;
        this.azW = null;
        this.azX = null;
        this.azT = (RelativeLayout) view.findViewById(d.g.top_area);
        this.title = (TextView) view.findViewById(d.g.theme_title);
        this.azU = (TextView) view.findViewById(d.g.more_textview);
        this.azV = (IndicatorView) view.findViewById(d.g.tab_indicator);
        this.azW = view.findViewById(d.g.bottom_divider_line);
        this.azX = (BdBaseViewPager) view.findViewById(d.g.bd_base_view_pager);
    }
}
