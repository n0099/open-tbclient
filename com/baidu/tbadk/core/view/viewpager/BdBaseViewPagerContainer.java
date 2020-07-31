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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a enZ;
    private b eoa;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.enZ = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.enZ);
        this.eoa = new b(context, this.enZ.eog, this.enZ.eod, this.enZ.eoc, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ao.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            ao.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            ao.setBackgroundColor(aVar.eoe, R.color.cp_bg_line_c);
            ao.setViewTextColor(aVar.eoc, R.color.cp_cont_d, 1);
            ao.setBackgroundColor(aVar.eoc, R.color.cp_bg_line_d);
            aVar.eoc.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eod.setSelector(ao.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.eod.setDrawable(ao.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.enZ.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.enZ.eog;
    }

    public IndicatorView getIndicatorView() {
        return this.enZ.eod;
    }

    public TextView getMoreView() {
        return this.enZ.eoc;
    }

    public a getViewHolder() {
        return this.enZ;
    }

    public void setMaxScrollCountLimit(int i) {
        this.eoa.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eoa.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.eoa.ig(z);
    }

    public void setDatas(List<q> list) {
        this.eoa.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.eoa.setAutoScrollIntervalTime(j);
    }
}
