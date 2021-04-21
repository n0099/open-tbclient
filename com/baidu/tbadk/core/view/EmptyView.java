package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class EmptyView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f13031e;

    /* renamed from: f  reason: collision with root package name */
    public int f13032f;

    public EmptyView(Context context) {
        super(context);
        this.f13031e = 0;
        this.f13032f = 0;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.f13032f;
        if (i3 == 0) {
            setMeasuredDimension(i & 1073741823, this.f13031e);
        } else if (this.f13031e == 0) {
            setMeasuredDimension(i3, i2 & 1073741823);
        }
    }

    public void setHeightDip(int i) {
        this.f13031e = l.e(getContext(), i);
    }

    public void setHeightPx(int i) {
        this.f13031e = i;
    }

    public void setWidthDip(int i) {
        this.f13032f = l.e(getContext(), i);
    }

    public void setWidthPx(int i) {
        this.f13032f = i;
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13031e = 0;
        this.f13032f = 0;
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13031e = 0;
        this.f13032f = 0;
    }
}
