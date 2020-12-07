package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b elJ;
    private int elP;
    private boolean elQ = true;
    private int elR = 0;
    private int elS = -1;
    public int elT = 0;
    private long elU = 0;
    private f elV;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.elP = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.elP = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int bcR() {
        return this.elT;
    }

    public void nb(int i) {
        this.elT = i;
    }

    public long bcS() {
        return this.elU;
    }

    public void dj(long j) {
        this.elU = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void nc(int i) {
        this.elP = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String em(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.elP <= 0) {
            return null;
        }
        return context.getResources().getString(this.elP);
    }

    public Drawable en(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int bcT() {
        return this.elR;
    }

    public boolean isVisible() {
        return this.elQ;
    }

    public int getTitleColor() {
        return this.elS == -1 ? g.a.aiapp_menu_item_text : this.elS;
    }

    public void a(f fVar) {
        this.elV = fVar;
    }

    public f bcU() {
        return this.elV;
    }

    public com.baidu.swan.menu.viewpager.b bcV() {
        return this.elJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.elP, iVar.mIconResId, iVar.mEnable);
    }
}
