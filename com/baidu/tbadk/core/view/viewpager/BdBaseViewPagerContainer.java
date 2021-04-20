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
import d.b.c.j.e.n;
import d.b.h0.r.f0.r.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f13320e;

    /* renamed from: f  reason: collision with root package name */
    public a f13321f;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f13323b, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f13326e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f13324c, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f13324c, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.f13324c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.f13325d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.f13325d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        this.f13320e = bdBaseViewPagerContainerHolder;
        a(bdBaseViewPagerContainerHolder);
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f13320e;
        this.f13321f = new a(context, bdBaseViewPagerContainerHolder2.f13327f, bdBaseViewPagerContainerHolder2.f13325d, bdBaseViewPagerContainerHolder2.f13324c, 4, false, true);
    }

    public IndicatorView getIndicatorView() {
        return this.f13320e.f13325d;
    }

    public TextView getMoreView() {
        return this.f13320e.f13324c;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f13320e.a();
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.f13320e;
    }

    public BdBaseViewPager getViewPager() {
        return this.f13320e.f13327f;
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f13321f.j(j);
    }

    public void setDatas(List<n> list) {
        this.f13321f.k(list);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.f13321f.l(z);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.f13321f.m(z);
    }

    public void setMaxScrollCountLimit(int i) {
        this.f13321f.n(i);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, this, true);
    }
}
