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
    private a dKJ;
    private b dKK;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.dKJ = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.dKJ);
        this.dKK = new b(context, this.dKJ.dKP, this.dKJ.dKN, this.dKJ.dKM, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.dKO, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.dKM, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.dKM, R.color.cp_bg_line_d);
            aVar.dKM.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dKN.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.dKN.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.dKJ.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.dKJ.dKP;
    }

    public IndicatorView getIndicatorView() {
        return this.dKJ.dKN;
    }

    public TextView getMoreView() {
        return this.dKJ.dKM;
    }

    public a getViewHolder() {
        return this.dKJ;
    }

    public void setMaxScrollCountLimit(int i) {
        this.dKK.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dKK.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.dKK.gV(z);
    }

    public void setDatas(List<m> list) {
        this.dKK.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.dKK.setAutoScrollIntervalTime(j);
    }
}
