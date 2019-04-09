package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class k {
    public boolean Pa;
    public int bkT;
    private int bkU = 0;
    public f bkV;
    public int mIconResId;
    public int mId;

    public k(int i, int i2, int i3, boolean z) {
        this.bkT = -1;
        this.mIconResId = -1;
        this.Pa = true;
        this.mId = i;
        this.bkT = i2;
        this.mIconResId = i3;
        this.Pa = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.bkT = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        this.bkV = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.Pa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f Rf() {
        return this.bkV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTitle(Context context) {
        if (this.bkT <= 0) {
            return null;
        }
        return context.getResources().getString(this.bkT);
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
        return this.bkU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k d(k kVar) {
        if (kVar == null) {
            return null;
        }
        return new k(kVar.mId, kVar.bkT, kVar.mIconResId, kVar.Pa);
    }
}
