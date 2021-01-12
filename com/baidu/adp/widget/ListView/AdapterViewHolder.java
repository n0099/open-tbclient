package com.baidu.adp.widget.ListView;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes.dex */
public class AdapterViewHolder<T extends View> extends TypeAdapter.ViewHolder {
    protected T Wu;

    public AdapterViewHolder(T t) {
        super(t);
        this.Wu = t;
    }

    public T qt() {
        return this.Wu;
    }
}
