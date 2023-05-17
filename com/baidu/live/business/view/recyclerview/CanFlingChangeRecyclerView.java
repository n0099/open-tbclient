package com.baidu.live.business.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class CanFlingChangeRecyclerView extends RecyclerView {
    public CanFlingChangeRecyclerView(Context context) {
        super(context);
    }

    public CanFlingChangeRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        return super.fling(i, i2 * 1);
    }

    public CanFlingChangeRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
