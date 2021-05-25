package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.m0.r.f0.r.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f12538e;

    /* renamed from: f  reason: collision with root package name */
    public a f12539f;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12541b, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12544e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12542c, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12542c, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.f12542c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.f12543d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.f12543d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        this.f12538e = bdBaseViewPagerContainerHolder;
        a(bdBaseViewPagerContainerHolder);
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f12538e;
        this.f12539f = new a(context, bdBaseViewPagerContainerHolder2.f12545f, bdBaseViewPagerContainerHolder2.f12543d, bdBaseViewPagerContainerHolder2.f12542c, 4, false, true);
    }

    public IndicatorView getIndicatorView() {
        return this.f12538e.f12543d;
    }

    public TextView getMoreView() {
        return this.f12538e.f12542c;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f12538e.a();
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.f12538e;
    }

    public BdBaseViewPager getViewPager() {
        return this.f12538e.f12545f;
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f12539f.j(j);
    }

    public void setDatas(List<n> list) {
        this.f12539f.k(list);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.f12539f.l(z);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.f12539f.m(z);
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f12539f.n(i2);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, this, true);
    }
}
