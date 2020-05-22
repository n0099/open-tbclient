package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a dZe;
    private b dZf;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.dZe = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.dZe);
        this.dZf = new b(context, this.dZe.dZk, this.dZe.dZi, this.dZe.dZh, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.dZj, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.dZh, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.dZh, R.color.cp_bg_line_d);
            aVar.dZh.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dZi.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.dZi.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.dZe.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.dZe.dZk;
    }

    public IndicatorView getIndicatorView() {
        return this.dZe.dZi;
    }

    public TextView getMoreView() {
        return this.dZe.dZh;
    }

    public a getViewHolder() {
        return this.dZe;
    }

    public void setMaxScrollCountLimit(int i) {
        this.dZf.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dZf.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.dZf.ht(z);
    }

    public void setDatas(List<o> list) {
        this.dZf.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.dZf.setAutoScrollIntervalTime(j);
    }
}
