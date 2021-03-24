package com.baidu.adp.widget.ListView;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes.dex */
public class AdapterViewHolder<T extends View> extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public T f2288a;

    public AdapterViewHolder(T t) {
        super(t);
        this.f2288a = t;
    }

    public T b() {
        return this.f2288a;
    }
}
