package com.baidu.afd.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes.dex */
public class AdCardViewHolder<T extends e> extends TypeAdapter.ViewHolder {
    protected T aaG;

    public AdCardViewHolder(T t) {
        super((View) t);
        this.aaG = t;
    }

    public T qY() {
        return this.aaG;
    }
}
