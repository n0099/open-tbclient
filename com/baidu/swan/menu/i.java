package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b dEa;
    private int dEg;
    private boolean dEh = true;
    private int dEi = 0;
    private int dEj = -1;
    public int dEk = 0;
    private long dEl = 0;
    private f dEm;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.dEg = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.dEg = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aSF() {
        return this.dEk;
    }

    public void lE(int i) {
        this.dEk = i;
    }

    public long aSG() {
        return this.dEl;
    }

    public void cd(long j) {
        this.dEl = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void lF(int i) {
        this.dEg = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dB(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.dEg <= 0) {
            return null;
        }
        return context.getResources().getString(this.dEg);
    }

    public Drawable dC(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aSH() {
        return this.dEi;
    }

    public boolean isVisible() {
        return this.dEh;
    }

    public int getTitleColor() {
        return this.dEj == -1 ? g.a.aiapp_menu_item_text : this.dEj;
    }

    public void a(f fVar) {
        this.dEm = fVar;
    }

    public f aSI() {
        return this.dEm;
    }

    public com.baidu.swan.menu.viewpager.b aSJ() {
        return this.dEa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.dEg, iVar.mIconResId, iVar.mEnable);
    }
}
