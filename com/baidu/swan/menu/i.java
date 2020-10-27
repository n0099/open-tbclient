package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class i {
    private int eaE;
    private boolean eaF = true;
    private int eaG = 0;
    private int eaH = -1;
    public int eaI = 0;
    private long eaJ = 0;
    private f eaK;
    private com.baidu.swan.menu.viewpager.b eay;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.eaE = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.eaE = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aXT() {
        return this.eaI;
    }

    public void mx(int i) {
        this.eaI = i;
    }

    public long aXU() {
        return this.eaJ;
    }

    public void co(long j) {
        this.eaJ = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void my(int i) {
        this.eaE = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dG(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.eaE <= 0) {
            return null;
        }
        return context.getResources().getString(this.eaE);
    }

    public Drawable dH(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aXV() {
        return this.eaG;
    }

    public boolean isVisible() {
        return this.eaF;
    }

    public int getTitleColor() {
        return this.eaH == -1 ? g.a.aiapp_menu_item_text : this.eaH;
    }

    public void a(f fVar) {
        this.eaK = fVar;
    }

    public f aXW() {
        return this.eaK;
    }

    public com.baidu.swan.menu.viewpager.b aXX() {
        return this.eay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.eaE, iVar.mIconResId, iVar.mEnable);
    }
}
