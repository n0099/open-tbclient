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
import d.a.j0.r.f0.r.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f12630e;

    /* renamed from: f  reason: collision with root package name */
    public a f12631f;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12633b, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12636e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12634c, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12634c, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.f12634c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.f12635d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.f12635d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        this.f12630e = bdBaseViewPagerContainerHolder;
        a(bdBaseViewPagerContainerHolder);
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f12630e;
        this.f12631f = new a(context, bdBaseViewPagerContainerHolder2.f12637f, bdBaseViewPagerContainerHolder2.f12635d, bdBaseViewPagerContainerHolder2.f12634c, 4, false, true);
    }

    public IndicatorView getIndicatorView() {
        return this.f12630e.f12635d;
    }

    public TextView getMoreView() {
        return this.f12630e.f12634c;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f12630e.a();
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.f12630e;
    }

    public BdBaseViewPager getViewPager() {
        return this.f12630e.f12637f;
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f12631f.j(j);
    }

    public void setDatas(List<n> list) {
        this.f12631f.k(list);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.f12631f.l(z);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.f12631f.m(z);
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f12631f.n(i2);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, this, true);
    }
}
