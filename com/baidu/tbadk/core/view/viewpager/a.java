package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a extends q.a {
    public int aIf;
    public RelativeLayout aIj;
    public TextView aIk;
    public IndicatorView aIl;
    public View aIm;
    public BdBaseViewPager aIn;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aIf = 3;
        this.title = null;
        this.aIk = null;
        this.aIl = null;
        this.aIm = null;
        this.aIn = null;
        this.aIj = (RelativeLayout) view.findViewById(e.g.top_area);
        this.title = (TextView) view.findViewById(e.g.theme_title);
        this.aIk = (TextView) view.findViewById(e.g.more_textview);
        this.aIl = (IndicatorView) view.findViewById(e.g.tab_indicator);
        this.aIm = view.findViewById(e.g.bottom_divider_line);
        this.aIn = (BdBaseViewPager) view.findViewById(e.g.bd_base_view_pager);
    }
}
