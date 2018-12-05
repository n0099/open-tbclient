package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
/* loaded from: classes.dex */
public abstract class c<T extends h, V extends BdBaseViewPagerAdapter.a> {
    protected a<T, V> aLY;
    protected Context mContext;
    protected BdUniqueId mType;

    /* loaded from: classes.dex */
    public interface a<T extends h, V extends BdBaseViewPagerAdapter.a> {
        void c(V v, T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    public abstract V f(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.mType = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.mType;
    }

    public void b(V v, T t) {
    }

    public void setOnItemClickListener(a<T, V> aVar) {
        this.aLY = aVar;
    }

    public a<T, V> FF() {
        return this.aLY;
    }
}
