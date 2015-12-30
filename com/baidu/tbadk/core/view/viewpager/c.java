package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends x.a {
    public int ahf;
    public RelativeLayout ahj;
    public TextView ahk;
    public TextView ahl;
    public IndicatorView ahm;
    public View ahn;
    public BdBaseViewPager aho;

    public c(View view, Context context) {
        super(view);
        this.ahf = 3;
        this.ahk = null;
        this.ahl = null;
        this.ahm = null;
        this.ahn = null;
        this.aho = null;
        this.ahj = (RelativeLayout) view.findViewById(n.g.top_area);
        this.ahk = (TextView) view.findViewById(n.g.theme_title);
        this.ahl = (TextView) view.findViewById(n.g.more_textview);
        this.ahm = (IndicatorView) view.findViewById(n.g.tab_indicator);
        this.ahn = view.findViewById(n.g.bottom_divider_line);
        this.aho = (BdBaseViewPager) view.findViewById(n.g.bd_base_view_pager);
    }
}
