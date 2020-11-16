package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends af.a {
    public int ajv;
    public RelativeLayout eZW;
    public TextView eZX;
    public IndicatorView eZY;
    public View eZZ;
    public BdBaseViewPager faa;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ajv = 3;
        this.title = null;
        this.eZX = null;
        this.eZY = null;
        this.eZZ = null;
        this.faa = null;
        this.eZW = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.eZX = (TextView) view.findViewById(R.id.more_textview);
        this.eZY = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.eZZ = view.findViewById(R.id.bottom_divider_line);
        this.faa = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
