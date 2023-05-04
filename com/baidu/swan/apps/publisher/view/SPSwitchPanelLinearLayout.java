package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.a63;
import com.baidu.tieba.ho1;
import com.baidu.tieba.q53;
import com.baidu.tieba.z53;
/* loaded from: classes3.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements z53, a63 {
    public static final boolean b = ho1.a;
    public q53 a;

    public final void a() {
        this.a = new q53(this);
    }

    @Override // com.baidu.tieba.z53
    public void handleHide() {
        this.a.handleHide();
    }

    @Override // com.baidu.tieba.z53
    public void handleShow() {
        super.setVisibility(0);
    }

    public SPSwitchPanelLinearLayout(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.a63
    public void onSoftInputShowing(boolean z) {
        this.a.e(z);
    }

    @Override // com.baidu.tieba.a63
    public void refreshHeight(int i) {
        this.a.d(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.a.a(i)) {
            return;
        }
        super.setVisibility(i);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (b) {
            Log.d("SPSwitchPanel", "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i2));
        }
        int[] c = this.a.c(i, i2);
        if (b) {
            Log.d("SPSwitchPanel", "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(c[1]));
        }
        super.onMeasure(c[0], c[1]);
    }
}
