package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import d.a.l0.a.w1.i.a;
import d.a.l0.a.w1.j.g;
import d.a.l0.a.w1.k.b;
/* loaded from: classes3.dex */
public class SPSwitchFSPanelLinearLayout extends LinearLayout implements b {

    /* renamed from: e  reason: collision with root package name */
    public a f11099e;

    public SPSwitchFSPanelLinearLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f11099e = new a(this);
    }

    @Override // d.a.l0.a.w1.k.b
    public void onSoftInputShowing(boolean z) {
        this.f11099e.a(z);
    }

    @Override // d.a.l0.a.w1.k.b
    public void refreshHeight(int i2) {
        g.g(this, i2);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
