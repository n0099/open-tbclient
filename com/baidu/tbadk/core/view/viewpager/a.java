package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends af.a {
    public int aiB;
    public RelativeLayout eyo;
    public TextView eyp;
    public IndicatorView eyq;
    public View eyr;
    public BdBaseViewPager eys;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.aiB = 3;
        this.title = null;
        this.eyp = null;
        this.eyq = null;
        this.eyr = null;
        this.eys = null;
        this.eyo = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.eyp = (TextView) view.findViewById(R.id.more_textview);
        this.eyq = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.eyr = view.findViewById(R.id.bottom_divider_line);
        this.eys = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
