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
    public int akW;
    public RelativeLayout fre;
    public TextView frf;
    public IndicatorView frg;
    public View frh;
    public BdBaseViewPager fri;
    public TextView title;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.akW = 3;
        this.title = null;
        this.frf = null;
        this.frg = null;
        this.frh = null;
        this.fri = null;
        this.fre = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.frf = (TextView) view.findViewById(R.id.more_textview);
        this.frg = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.frh = view.findViewById(R.id.bottom_divider_line);
        this.fri = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
