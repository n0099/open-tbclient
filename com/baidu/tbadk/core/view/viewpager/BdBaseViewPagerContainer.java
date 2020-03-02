package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a dkp;
    private b dkq;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.dkp = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.dkp);
        this.dkq = new b(context, this.dkp.dkv, this.dkp.dkt, this.dkp.dks, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.dku, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.dks, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.dks, R.color.cp_bg_line_d);
            aVar.dks.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dkt.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.dkt.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.dkp.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.dkp.dkv;
    }

    public IndicatorView getIndicatorView() {
        return this.dkp.dkt;
    }

    public TextView getMoreView() {
        return this.dkp.dks;
    }

    public a getViewHolder() {
        return this.dkp;
    }

    public void setMaxScrollCountLimit(int i) {
        this.dkq.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dkq.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.dkq.fW(z);
    }

    public void setDatas(List<m> list) {
        this.dkq.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.dkq.setAutoScrollIntervalTime(j);
    }
}
