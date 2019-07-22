package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class j {
    public boolean MX;
    public int brI;
    private int brJ = 0;
    public e brK;
    public int mIconResId;
    public int mId;

    public j(int i, int i2, int i3, boolean z) {
        this.brI = -1;
        this.mIconResId = -1;
        this.MX = true;
        this.mId = i;
        this.brI = i2;
        this.mIconResId = i3;
        this.MX = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.brI = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e eVar) {
        this.brK = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.MX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e VK() {
        return this.brK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String cb(Context context) {
        if (this.brI <= 0) {
            return null;
        }
        return context.getResources().getString(this.brI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable cc(Context context) {
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int VL() {
        return this.brJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j d(j jVar) {
        if (jVar == null) {
            return null;
        }
        return new j(jVar.mId, jVar.brI, jVar.mIconResId, jVar.MX);
    }
}
