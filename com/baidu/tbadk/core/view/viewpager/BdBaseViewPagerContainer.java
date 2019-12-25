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
    private a dfW;
    private b dfX;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.dfW = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.dfW);
        this.dfX = new b(context, this.dfW.dgc, this.dfW.dga, this.dfW.dfZ, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.dgb, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.dfZ, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.dfZ, R.color.cp_bg_line_d);
            aVar.dfZ.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dga.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.dga.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.dfW.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.dfW.dgc;
    }

    public IndicatorView getIndicatorView() {
        return this.dfW.dga;
    }

    public TextView getMoreView() {
        return this.dfW.dfZ;
    }

    public a getViewHolder() {
        return this.dfW;
    }

    public void setMaxScrollCountLimit(int i) {
        this.dfX.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dfX.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.dfX.fK(z);
    }

    public void setDatas(List<m> list) {
        this.dfX.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.dfX.setAutoScrollIntervalTime(j);
    }
}
