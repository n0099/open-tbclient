package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b czl;
    private int czr;
    private f czw;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean mIsVisible = true;
    private int czs = 0;
    private int czt = -1;
    public int czu = 0;
    private long czv = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.czr = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.czr = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int asS() {
        return this.czu;
    }

    public void iu(int i) {
        this.czu = i;
    }

    public long asT() {
        return this.czv;
    }

    public void bf(long j) {
        this.czv = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void iv(int i) {
        this.czr = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dz(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.czr <= 0) {
            return null;
        }
        return context.getResources().getString(this.czr);
    }

    public Drawable dA(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int asU() {
        return this.czs;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public int getTitleColor() {
        return this.czt == -1 ? g.a.aiapp_menu_item_text : this.czt;
    }

    public void a(f fVar) {
        this.czw = fVar;
    }

    public f asV() {
        return this.czw;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.czl = bVar;
    }

    public com.baidu.swan.menu.viewpager.b asW() {
        return this.czl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.czr, iVar.mIconResId, iVar.mEnable);
    }
}
