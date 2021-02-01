package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
/* loaded from: classes.dex */
public abstract class b<T extends n, V extends BdBaseViewPagerAdapter.a> {
    protected BdUniqueId Wm;
    protected a<T, V> fpa;
    protected Context mContext;

    /* loaded from: classes.dex */
    public interface a<T extends n, V extends BdBaseViewPagerAdapter.a> {
        void c(V v, T t);
    }

    public abstract V J(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Wm = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.Wm;
    }

    public void b(V v, T t) {
    }

    public void setOnItemClickListener(a<T, V> aVar) {
        this.fpa = aVar;
    }

    public a<T, V> bvx() {
        return this.fpa;
    }
}
