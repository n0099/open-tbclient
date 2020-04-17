package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
/* loaded from: classes.dex */
public abstract class c<T extends m, V extends BdBaseViewPagerAdapter.a> {
    protected BdUniqueId Tv;
    protected a<T, V> dKZ;
    protected Context mContext;

    /* loaded from: classes.dex */
    public interface a<T extends m, V extends BdBaseViewPagerAdapter.a> {
        void c(V v, T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    public abstract V u(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Tv = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.Tv;
    }

    public void b(V v, T t) {
    }

    public void setOnItemClickListener(a<T, V> aVar) {
        this.dKZ = aVar;
    }

    public a<T, V> aRc() {
        return this.dKZ;
    }
}
