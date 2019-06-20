package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class j {
    public boolean MG;
    public int bqV;
    private int bqW = 0;
    public e bqX;
    public int mIconResId;
    public int mId;

    public j(int i, int i2, int i3, boolean z) {
        this.bqV = -1;
        this.mIconResId = -1;
        this.MG = true;
        this.mId = i;
        this.bqV = i2;
        this.mIconResId = i3;
        this.MG = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.bqV = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e eVar) {
        this.bqX = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.MG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e UR() {
        return this.bqX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTitle(Context context) {
        if (this.bqV <= 0) {
            return null;
        }
        return context.getResources().getString(this.bqV);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable cb(Context context) {
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int US() {
        return this.bqW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j d(j jVar) {
        if (jVar == null) {
            return null;
        }
        return new j(jVar.mId, jVar.bqV, jVar.mIconResId, jVar.MG);
    }
}
