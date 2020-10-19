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
    public int ajp;
    public RelativeLayout eMD;
    public TextView eME;
    public IndicatorView eMF;
    public View eMG;
    public BdBaseViewPager eMH;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.ajp = 3;
        this.title = null;
        this.eME = null;
        this.eMF = null;
        this.eMG = null;
        this.eMH = null;
        this.eMD = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.eME = (TextView) view.findViewById(R.id.more_textview);
        this.eMF = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.eMG = view.findViewById(R.id.bottom_divider_line);
        this.eMH = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
