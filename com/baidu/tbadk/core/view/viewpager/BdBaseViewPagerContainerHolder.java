package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainerHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public RelativeLayout fmu;
    public TextView fmv;
    public IndicatorView fmw;
    public View fmx;
    public BdBaseViewPager fmy;
    public TextView title;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.akf = 3;
        this.title = null;
        this.fmv = null;
        this.fmw = null;
        this.fmx = null;
        this.fmy = null;
        this.fmu = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.fmv = (TextView) view.findViewById(R.id.more_textview);
        this.fmw = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.fmx = view.findViewById(R.id.bottom_divider_line);
        this.fmy = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
