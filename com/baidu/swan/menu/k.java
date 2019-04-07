package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class k {
    public boolean Pa;
    public int bkS;
    private int bkT = 0;
    public f bkU;
    public int mIconResId;
    public int mId;

    public k(int i, int i2, int i3, boolean z) {
        this.bkS = -1;
        this.mIconResId = -1;
        this.Pa = true;
        this.mId = i;
        this.bkS = i2;
        this.mIconResId = i3;
        this.Pa = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.bkS = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        this.bkU = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.Pa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f Rf() {
        return this.bkU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTitle(Context context) {
        if (this.bkS <= 0) {
            return null;
        }
        return context.getResources().getString(this.bkS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable cy(Context context) {
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Rg() {
        return this.bkT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k d(k kVar) {
        if (kVar == null) {
            return null;
        }
        return new k(kVar.mId, kVar.bkS, kVar.mIconResId, kVar.Pa);
    }
}
