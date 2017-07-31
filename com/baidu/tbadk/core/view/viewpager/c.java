package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.view.viewpager.b;
import com.baidu.tbadk.core.view.viewpager.b.a;
/* loaded from: classes.dex */
public abstract class c<T extends f, V extends b.a> {
    protected a<T, V> aqn;
    protected Context mContext;
    protected BdUniqueId mType;

    /* loaded from: classes.dex */
    public interface a<T extends f, V extends b.a> {
        void c(V v, T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    public abstract V b(ViewGroup viewGroup);

    protected c(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.mType = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.mType;
    }

    public void b(V v, T t) {
    }

    public void setOnItemClickListener(a<T, V> aVar) {
        this.aqn = aVar;
    }

    public a<T, V> xt() {
        return this.aqn;
    }
}
