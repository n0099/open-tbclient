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
    public int cdS;
    public RelativeLayout cdW;
    public TextView cdX;
    public IndicatorView cdY;
    public View cdZ;
    public BdBaseViewPager cea;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.cdS = 3;
        this.title = null;
        this.cdX = null;
        this.cdY = null;
        this.cdZ = null;
        this.cea = null;
        this.cdW = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.cdX = (TextView) view.findViewById(R.id.more_textview);
        this.cdY = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.cdZ = view.findViewById(R.id.bottom_divider_line);
        this.cea = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
