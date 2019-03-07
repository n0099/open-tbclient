package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class k {
    public boolean OZ;
    public int bkO;
    private int bkP = 0;
    public f bkQ;
    public int mIconResId;
    public int mId;

    public k(int i, int i2, int i3, boolean z) {
        this.bkO = -1;
        this.mIconResId = -1;
        this.OZ = true;
        this.mId = i;
        this.bkO = i2;
        this.mIconResId = i3;
        this.OZ = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.bkO = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        this.bkQ = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.OZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f Rh() {
        return this.bkQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTitle(Context context) {
        if (this.bkO <= 0) {
            return null;
        }
        return context.getResources().getString(this.bkO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable cy(Context context) {
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Ri() {
        return this.bkP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k d(k kVar) {
        if (kVar == null) {
            return null;
        }
        return new k(kVar.mId, kVar.bkO, kVar.mIconResId, kVar.OZ);
    }
}
