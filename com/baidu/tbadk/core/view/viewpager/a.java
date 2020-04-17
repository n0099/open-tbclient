package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends y.a {
    public int afT;
    public RelativeLayout dKL;
    public TextView dKM;
    public IndicatorView dKN;
    public View dKO;
    public BdBaseViewPager dKP;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.afT = 3;
        this.title = null;
        this.dKM = null;
        this.dKN = null;
        this.dKO = null;
        this.dKP = null;
        this.dKL = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dKM = (TextView) view.findViewById(R.id.more_textview);
        this.dKN = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dKO = view.findViewById(R.id.bottom_divider_line);
        this.dKP = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
