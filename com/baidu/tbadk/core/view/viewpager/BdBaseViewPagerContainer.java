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
import d.a.n0.r.f0.r.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f12682e;

    /* renamed from: f  reason: collision with root package name */
    public a f12683f;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12685b, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12688e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12686c, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12686c, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.f12686c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.f12687d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.f12687d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        this.f12682e = bdBaseViewPagerContainerHolder;
        a(bdBaseViewPagerContainerHolder);
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f12682e;
        this.f12683f = new a(context, bdBaseViewPagerContainerHolder2.f12689f, bdBaseViewPagerContainerHolder2.f12687d, bdBaseViewPagerContainerHolder2.f12686c, 4, false, true);
    }

    public IndicatorView getIndicatorView() {
        return this.f12682e.f12687d;
    }

    public TextView getMoreView() {
        return this.f12682e.f12686c;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f12682e.a();
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.f12682e;
    }

    public BdBaseViewPager getViewPager() {
        return this.f12682e.f12689f;
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f12683f.j(j);
    }

    public void setDatas(List<n> list) {
        this.f12683f.k(list);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.f12683f.l(z);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.f12683f.m(z);
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f12683f.n(i2);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, this, true);
    }
}
