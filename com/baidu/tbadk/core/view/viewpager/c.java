package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
/* loaded from: classes.dex */
public abstract class c<T extends q, V extends BdBaseViewPagerAdapter.a> {
    protected BdUniqueId Vx;
    protected a<T, V> fak;
    protected Context mContext;

    /* loaded from: classes.dex */
    public interface a<T extends q, V extends BdBaseViewPagerAdapter.a> {
        void c(V v, T t);
    }

    public abstract V E(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Vx = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.Vx;
    }

    public void b(V v, T t) {
    }

    public void setOnItemClickListener(a<T, V> aVar) {
        this.fak = aVar;
    }

    public a<T, V> btd() {
        return this.fak;
    }
}
