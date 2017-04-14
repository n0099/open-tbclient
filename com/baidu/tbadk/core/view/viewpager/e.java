package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.core.view.viewpager.a.C0034a;
/* loaded from: classes.dex */
public abstract class e<T extends v, V extends a.C0034a> {
    protected a<T, V> ano;
    protected Context mContext;
    protected BdUniqueId mType;

    /* loaded from: classes.dex */
    public interface a<T extends v, V extends a.C0034a> {
        void c(V v, T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(int i, V v, T t);

    public abstract V b(ViewGroup viewGroup);

    protected e(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.mType = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.mType;
    }

    public void b(V v, T t) {
    }

    public void setOnItemClickListener(a<T, V> aVar) {
        this.ano = aVar;
    }

    public a<T, V> xB() {
        return this.ano;
    }
}
