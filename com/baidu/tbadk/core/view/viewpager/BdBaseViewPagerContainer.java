package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a eyq;
    private b eyr;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.eyq = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.eyq);
        this.eyr = new b(context, this.eyq.eyw, this.eyq.eyu, this.eyq.eyt, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(aVar.eyv, R.color.cp_bg_line_c);
            ap.setViewTextColor(aVar.eyt, R.color.cp_cont_d, 1);
            ap.setBackgroundColor(aVar.eyt, R.color.cp_bg_line_d);
            aVar.eyt.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eyu.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.eyu.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.eyq.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.eyq.eyw;
    }

    public IndicatorView getIndicatorView() {
        return this.eyq.eyu;
    }

    public TextView getMoreView() {
        return this.eyq.eyt;
    }

    public a getViewHolder() {
        return this.eyq;
    }

    public void setMaxScrollCountLimit(int i) {
        this.eyr.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eyr.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.eyr.iF(z);
    }

    public void setDatas(List<q> list) {
        this.eyr.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.eyr.setAutoScrollIntervalTime(j);
    }
}
