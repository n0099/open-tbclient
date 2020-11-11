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
    private a faM;
    private b faN;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.faM = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.faM);
        this.faN = new b(context, this.faM.faS, this.faM.faQ, this.faM.faP, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(aVar.faR, R.color.cp_bg_line_c);
            ap.setViewTextColor(aVar.faP, R.color.cp_cont_d, 1);
            ap.setBackgroundColor(aVar.faP, R.color.cp_bg_line_d);
            aVar.faP.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.faQ.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.faQ.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.faM.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.faM.faS;
    }

    public IndicatorView getIndicatorView() {
        return this.faM.faQ;
    }

    public TextView getMoreView() {
        return this.faM.faP;
    }

    public a getViewHolder() {
        return this.faM;
    }

    public void setMaxScrollCountLimit(int i) {
        this.faN.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.faN.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.faN.jw(z);
    }

    public void setDatas(List<q> list) {
        this.faN.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.faN.setAutoScrollIntervalTime(j);
    }
}
