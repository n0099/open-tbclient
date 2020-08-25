package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b dDW;
    private int dEc;
    private boolean dEd = true;
    private int dEe = 0;
    private int dEf = -1;
    public int dEg = 0;
    private long dEh = 0;
    private f dEi;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.dEc = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.dEc = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aSF() {
        return this.dEg;
    }

    public void lE(int i) {
        this.dEg = i;
    }

    public long aSG() {
        return this.dEh;
    }

    public void cd(long j) {
        this.dEh = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void lF(int i) {
        this.dEc = i;
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
        if (this.dEc <= 0) {
            return null;
        }
        return context.getResources().getString(this.dEc);
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
        return this.dEe;
    }

    public boolean isVisible() {
        return this.dEd;
    }

    public int getTitleColor() {
        return this.dEf == -1 ? g.a.aiapp_menu_item_text : this.dEf;
    }

    public void a(f fVar) {
        this.dEi = fVar;
    }

    public f aSI() {
        return this.dEi;
    }

    public com.baidu.swan.menu.viewpager.b aSJ() {
        return this.dDW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.dEc, iVar.mIconResId, iVar.mEnable);
    }
}
