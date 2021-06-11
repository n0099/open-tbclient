package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import d.a.l0.a.k;
import d.a.l0.a.w1.k.a;
import d.a.l0.a.w1.k.b;
/* loaded from: classes3.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements a, b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f11100f = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.w1.i.b f11101e;

    public SPSwitchPanelLinearLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f11101e = new d.a.l0.a.w1.i.b(this);
    }

    @Override // d.a.l0.a.w1.k.a
    public void handleHide() {
        this.f11101e.handleHide();
    }

    @Override // d.a.l0.a.w1.k.a
    public void handleShow() {
        super.setVisibility(0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (f11100f) {
            Log.d("SPSwitchPanel", "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i3));
        }
        int[] c2 = this.f11101e.c(i2, i3);
        if (f11100f) {
            Log.d("SPSwitchPanel", "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(c2[1]));
        }
        super.onMeasure(c2[0], c2[1]);
    }

    @Override // d.a.l0.a.w1.k.b
    public void onSoftInputShowing(boolean z) {
        this.f11101e.e(z);
    }

    @Override // d.a.l0.a.w1.k.b
    public void refreshHeight(int i2) {
        this.f11101e.d(i2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (this.f11101e.a(i2)) {
            return;
        }
        super.setVisibility(i2);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
