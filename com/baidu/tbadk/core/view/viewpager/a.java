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
    public int Ni;
    public RelativeLayout dkE;
    public TextView dkF;
    public IndicatorView dkG;
    public View dkH;
    public BdBaseViewPager dkI;
    public TextView title;

    public a(View view, Context context) {
        super(view);
        this.Ni = 3;
        this.title = null;
        this.dkF = null;
        this.dkG = null;
        this.dkH = null;
        this.dkI = null;
        this.dkE = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.dkF = (TextView) view.findViewById(R.id.more_textview);
        this.dkG = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.dkH = view.findViewById(R.id.bottom_divider_line);
        this.dkI = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
