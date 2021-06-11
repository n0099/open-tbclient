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
import d.a.c.k.e.n;
import d.a.m0.r.f0.r.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f12600e;

    /* renamed from: f  reason: collision with root package name */
    public a f12601f;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12603b, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12606e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12604c, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12604c, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.f12604c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.f12605d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.f12605d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        this.f12600e = bdBaseViewPagerContainerHolder;
        a(bdBaseViewPagerContainerHolder);
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f12600e;
        this.f12601f = new a(context, bdBaseViewPagerContainerHolder2.f12607f, bdBaseViewPagerContainerHolder2.f12605d, bdBaseViewPagerContainerHolder2.f12604c, 4, false, true);
    }

    public IndicatorView getIndicatorView() {
        return this.f12600e.f12605d;
    }

    public TextView getMoreView() {
        return this.f12600e.f12604c;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f12600e.a();
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.f12600e;
    }

    public BdBaseViewPager getViewPager() {
        return this.f12600e.f12607f;
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f12601f.j(j);
    }

    public void setDatas(List<n> list) {
        this.f12601f.k(list);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.f12601f.l(z);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.f12601f.m(z);
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f12601f.n(i2);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, this, true);
    }
}
