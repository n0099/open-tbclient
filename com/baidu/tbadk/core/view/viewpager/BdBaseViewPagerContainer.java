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
    private a fhr;
    private b fhs;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.fhr = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.fhr);
        this.fhs = new b(context, this.fhr.fhx, this.fhr.fhv, this.fhr.fhu, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(aVar.title, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(aVar.fhw, R.color.CAM_X0204);
            ap.setViewTextColor(aVar.fhu, R.color.CAM_X0109, 1);
            ap.setBackgroundColor(aVar.fhu, R.color.CAM_X0201);
            aVar.fhu.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.fhv.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.fhv.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.fhr.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.fhr.fhx;
    }

    public IndicatorView getIndicatorView() {
        return this.fhr.fhv;
    }

    public TextView getMoreView() {
        return this.fhr.fhu;
    }

    public a getViewHolder() {
        return this.fhr;
    }

    public void setMaxScrollCountLimit(int i) {
        this.fhs.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.fhs.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.fhs.jN(z);
    }

    public void setDatas(List<q> list) {
        this.fhs.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.fhs.setAutoScrollIntervalTime(j);
    }
}
