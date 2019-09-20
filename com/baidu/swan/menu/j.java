package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class j {
    public boolean MX;
    public int bsg;
    private int bsh = 0;
    public e bsi;
    public int mIconResId;
    public int mId;

    public j(int i, int i2, int i3, boolean z) {
        this.bsg = -1;
        this.mIconResId = -1;
        this.MX = true;
        this.mId = i;
        this.bsg = i2;
        this.mIconResId = i3;
        this.MX = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.bsg = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e eVar) {
        this.bsi = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.MX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e VO() {
        return this.bsi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String cb(Context context) {
        if (this.bsg <= 0) {
            return null;
        }
        return context.getResources().getString(this.bsg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable cc(Context context) {
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int VP() {
        return this.bsh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j d(j jVar) {
        if (jVar == null) {
            return null;
        }
        return new j(jVar.mId, jVar.bsg, jVar.mIconResId, jVar.MX);
    }
}
