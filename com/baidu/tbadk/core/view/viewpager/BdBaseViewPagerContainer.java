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
import d.a.i0.r.f0.r.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f13294e;

    /* renamed from: f  reason: collision with root package name */
    public a f13295f;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f13297b, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f13300e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f13298c, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f13298c, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.f13298c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.f13299d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.f13299d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        this.f13294e = bdBaseViewPagerContainerHolder;
        a(bdBaseViewPagerContainerHolder);
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f13294e;
        this.f13295f = new a(context, bdBaseViewPagerContainerHolder2.f13301f, bdBaseViewPagerContainerHolder2.f13299d, bdBaseViewPagerContainerHolder2.f13298c, 4, false, true);
    }

    public IndicatorView getIndicatorView() {
        return this.f13294e.f13299d;
    }

    public TextView getMoreView() {
        return this.f13294e.f13298c;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f13294e.a();
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.f13294e;
    }

    public BdBaseViewPager getViewPager() {
        return this.f13294e.f13301f;
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f13295f.j(j);
    }

    public void setDatas(List<n> list) {
        this.f13295f.k(list);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.f13295f.l(z);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.f13295f.m(z);
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f13295f.n(i2);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, this, true);
    }
}
