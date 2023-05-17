package com.baidu.pass.ecommerce.common.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public int position;
    public T t;

    public BaseRecyclerViewHolder(@NonNull View view2) {
        super(view2);
    }

    public void bindData2View(int i, T t) {
        this.position = i;
        this.t = t;
    }
}
