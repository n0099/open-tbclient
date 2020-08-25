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
/* loaded from: classes2.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a eyl;
    private b eyn;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.eyl = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.eyl);
        this.eyn = new b(context, this.eyl.eys, this.eyl.eyq, this.eyl.eyp, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(aVar.eyr, R.color.cp_bg_line_c);
            ap.setViewTextColor(aVar.eyp, R.color.cp_cont_d, 1);
            ap.setBackgroundColor(aVar.eyp, R.color.cp_bg_line_d);
            aVar.eyp.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eyq.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.eyq.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.eyl.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.eyl.eys;
    }

    public IndicatorView getIndicatorView() {
        return this.eyl.eyq;
    }

    public TextView getMoreView() {
        return this.eyl.eyp;
    }

    public a getViewHolder() {
        return this.eyl;
    }

    public void setMaxScrollCountLimit(int i) {
        this.eyn.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eyn.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.eyn.iE(z);
    }

    public void setDatas(List<q> list) {
        this.eyn.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.eyn.setAutoScrollIntervalTime(j);
    }
}
