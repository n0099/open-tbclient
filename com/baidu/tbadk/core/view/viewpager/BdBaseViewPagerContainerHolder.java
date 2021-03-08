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
    public int aln;
    public RelativeLayout fqm;
    public TextView fqn;
    public IndicatorView fqo;
    public View fqp;
    public BdBaseViewPager fqq;
    public TextView title;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.aln = 3;
        this.title = null;
        this.fqn = null;
        this.fqo = null;
        this.fqp = null;
        this.fqq = null;
        this.fqm = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.fqn = (TextView) view.findViewById(R.id.more_textview);
        this.fqo = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.fqp = view.findViewById(R.id.bottom_divider_line);
        this.fqq = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
