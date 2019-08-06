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
    private a cdU;
    private b cdV;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.cdU = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.cdU);
        this.cdV = new b(context, this.cdU.cea, this.cdU.cdY, this.cdU.cdX, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.l(aVar.getView(), R.color.cp_bg_line_d);
            am.f(aVar.title, R.color.cp_cont_c, 1);
            am.l(aVar.cdZ, R.color.cp_bg_line_b);
            am.f(aVar.cdX, R.color.cp_cont_d, 1);
            am.l(aVar.cdX, R.color.cp_bg_line_d);
            aVar.cdX.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.cdY.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.cdY.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.cdU.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.cdU.cea;
    }

    public IndicatorView getIndicatorView() {
        return this.cdU.cdY;
    }

    public TextView getMoreView() {
        return this.cdU.cdX;
    }

    public a getViewHolder() {
        return this.cdU;
    }

    public void setMaxScrollCountLimit(int i) {
        this.cdV.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.cdV.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.cdV.ey(z);
    }

    public void setDatas(List<m> list) {
        this.cdV.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.cdV.setAutoScrollIntervalTime(j);
    }
}
