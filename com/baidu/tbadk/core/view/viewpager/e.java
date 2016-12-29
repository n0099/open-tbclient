package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.core.view.viewpager.a.C0036a;
/* loaded from: classes.dex */
public abstract class e<T extends v, V extends a.C0036a> {
    protected BdUniqueId AT;
    protected a<T, V> air;
    protected Context mContext;

    /* loaded from: classes.dex */
    public interface a<T extends v, V extends a.C0036a> {
        void c(V v, T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup, V v, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(int i, V v, T t);

    public abstract V c(ViewGroup viewGroup);

    protected e(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.AT = bdUniqueId;
    }

    public BdUniqueId getType() {
        return this.AT;
    }

    public void b(V v, T t) {
    }

    public void setOnItemClickListener(a<T, V> aVar) {
        this.air = aVar;
    }

    public a<T, V> wO() {
        return this.air;
    }
}
