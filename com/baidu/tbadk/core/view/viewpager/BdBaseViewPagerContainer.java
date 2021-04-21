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
import d.b.i0.r.f0.r.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f13328e;

    /* renamed from: f  reason: collision with root package name */
    public a f13329f;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f13331b, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f13334e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f13332c, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f13332c, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.f13332c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.f13333d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.f13333d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        this.f13328e = bdBaseViewPagerContainerHolder;
        a(bdBaseViewPagerContainerHolder);
        BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f13328e;
        this.f13329f = new a(context, bdBaseViewPagerContainerHolder2.f13335f, bdBaseViewPagerContainerHolder2.f13333d, bdBaseViewPagerContainerHolder2.f13332c, 4, false, true);
    }

    public IndicatorView getIndicatorView() {
        return this.f13328e.f13333d;
    }

    public TextView getMoreView() {
        return this.f13328e.f13332c;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f13328e.a();
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.f13328e;
    }

    public BdBaseViewPager getViewPager() {
        return this.f13328e.f13335f;
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f13329f.j(j);
    }

    public void setDatas(List<n> list) {
        this.f13329f.k(list);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.f13329f.l(z);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.f13329f.m(z);
    }

    public void setMaxScrollCountLimit(int i) {
        this.f13329f.n(i);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, this, true);
    }
}
