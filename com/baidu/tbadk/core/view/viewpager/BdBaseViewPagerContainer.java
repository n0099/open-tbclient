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
    private a eMB;
    private b eMC;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.eMB = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.eMB);
        this.eMC = new b(context, this.eMB.eMH, this.eMB.eMF, this.eMB.eME, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(aVar.eMG, R.color.cp_bg_line_c);
            ap.setViewTextColor(aVar.eME, R.color.cp_cont_d, 1);
            ap.setBackgroundColor(aVar.eME, R.color.cp_bg_line_d);
            aVar.eME.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eMF.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.eMF.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.eMB.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.eMB.eMH;
    }

    public IndicatorView getIndicatorView() {
        return this.eMB.eMF;
    }

    public TextView getMoreView() {
        return this.eMB.eME;
    }

    public a getViewHolder() {
        return this.eMB;
    }

    public void setMaxScrollCountLimit(int i) {
        this.eMC.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eMC.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.eMC.ja(z);
    }

    public void setDatas(List<q> list) {
        this.eMC.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.eMC.setAutoScrollIntervalTime(j);
    }
}
