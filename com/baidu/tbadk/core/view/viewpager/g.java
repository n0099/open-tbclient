package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.core.view.viewpager.a.C0043a;
/* loaded from: classes.dex */
public abstract class g<T extends u, V extends a.C0043a> {
    protected BdUniqueId Ht;
    protected a<T, V> ahz;
    protected Context mContext;

    /* loaded from: classes.dex */
    public interface a<T extends u, V extends a.C0043a> {
        void c(V v, T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(int i, V v, T t);

    public abstract V c(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Ht = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.Ht;
    }

    public void b(V v, T t) {
    }

    public void a(a<T, V> aVar) {
        this.ahz = aVar;
    }

    public a<T, V> we() {
        return this.ahz;
    }
}
