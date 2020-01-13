package com.baidu.searchbox.suspensionwindow;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public abstract class FloatView {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dismiss();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void init();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isInited();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setGravity(int i, float f, float f2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setSize(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setView(View view);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateXY(float f, float f2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateX(float f) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateY(float f) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getX() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getY() {
        return 0.0f;
    }
}
