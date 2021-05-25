package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import d.a.c.e.p.l;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes3.dex */
public class EmptyView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f12207e;

    /* renamed from: f  reason: collision with root package name */
    public int f12208f;

    public EmptyView(Context context) {
        super(context);
        this.f12207e = 0;
        this.f12208f = 0;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.f12208f;
        if (i4 == 0) {
            setMeasuredDimension(i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK, this.f12207e);
        } else if (this.f12207e == 0) {
            setMeasuredDimension(i4, i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        }
    }

    public void setHeightDip(int i2) {
        this.f12207e = l.e(getContext(), i2);
    }

    public void setHeightPx(int i2) {
        this.f12207e = i2;
    }

    public void setWidthDip(int i2) {
        this.f12208f = l.e(getContext(), i2);
    }

    public void setWidthPx(int i2) {
        this.f12208f = i2;
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12207e = 0;
        this.f12208f = 0;
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12207e = 0;
        this.f12208f = 0;
    }
}
