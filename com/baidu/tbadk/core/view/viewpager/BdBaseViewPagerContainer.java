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
    private a eZU;
    private b eZV;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.eZU = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.eZU);
        this.eZV = new b(context, this.eZU.faa, this.eZU.eZY, this.eZU.eZX, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(aVar.title, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(aVar.eZZ, R.color.CAM_X0204);
            ap.setViewTextColor(aVar.eZX, R.color.CAM_X0109, 1);
            ap.setBackgroundColor(aVar.eZX, R.color.CAM_X0201);
            aVar.eZX.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eZY.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.eZY.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.eZU.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.eZU.faa;
    }

    public IndicatorView getIndicatorView() {
        return this.eZU.eZY;
    }

    public TextView getMoreView() {
        return this.eZU.eZX;
    }

    public a getViewHolder() {
        return this.eZU;
    }

    public void setMaxScrollCountLimit(int i) {
        this.eZV.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eZV.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.eZV.jx(z);
    }

    public void setDatas(List<q> list) {
        this.eZV.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.eZV.setAutoScrollIntervalTime(j);
    }
}
