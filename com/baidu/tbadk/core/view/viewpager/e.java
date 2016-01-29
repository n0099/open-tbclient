package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.core.view.viewpager.a.C0044a;
/* loaded from: classes.dex */
public abstract class e<T extends u, V extends a.C0044a> {
    protected BdUniqueId HF;
    protected a<T, V> aik;
    protected Context mContext;

    /* loaded from: classes.dex */
    public interface a<T extends u, V extends a.C0044a> {
        void c(V v, T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(int i, V v, T t);

    public abstract V d(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.HF = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.HF;
    }

    public void b(V v, T t) {
    }

    public void a(a<T, V> aVar) {
        this.aik = aVar;
    }

    public a<T, V> xs() {
        return this.aik;
    }
}
