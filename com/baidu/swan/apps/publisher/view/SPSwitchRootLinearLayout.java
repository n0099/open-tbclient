package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import d.a.m0.a.w1.i.c;
/* loaded from: classes3.dex */
public class SPSwitchRootLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f11184e;

    public SPSwitchRootLinearLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f11184e = new c(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        this.f11184e.b(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
