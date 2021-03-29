package com.baidu.afd.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.i0.i1.o.l.e;
/* loaded from: classes.dex */
public class AdCardViewHolder<T extends e> extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public T f2480a;

    public AdCardViewHolder(T t) {
        super((View) t);
        this.f2480a = t;
    }

    public T b() {
        return this.f2480a;
    }
}
