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
    public int ajU;
    public RelativeLayout foM;
    public TextView foN;
    public IndicatorView foO;
    public View foP;
    public BdBaseViewPager foQ;
    public TextView title;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.ajU = 3;
        this.title = null;
        this.foN = null;
        this.foO = null;
        this.foP = null;
        this.foQ = null;
        this.foM = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.foN = (TextView) view.findViewById(R.id.more_textview);
        this.foO = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.foP = view.findViewById(R.id.bottom_divider_line);
        this.foQ = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
