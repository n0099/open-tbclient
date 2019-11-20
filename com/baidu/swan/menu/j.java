package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class j {
    public int bKa;
    private int bKb = 0;
    public e bKc;
    public boolean mEnable;
    public int mIconResId;
    public int mId;

    public j(int i, int i2, int i3, boolean z) {
        this.bKa = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.bKa = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.bKa = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e eVar) {
        this.bKc = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.mEnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e aaB() {
        return this.bKc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String cb(Context context) {
        if (this.bKa <= 0) {
            return null;
        }
        return context.getResources().getString(this.bKa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable cc(Context context) {
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aaC() {
        return this.bKb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j d(j jVar) {
        if (jVar == null) {
            return null;
        }
        return new j(jVar.mId, jVar.bKa, jVar.mIconResId, jVar.mEnable);
    }
}
