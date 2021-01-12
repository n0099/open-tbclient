package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.f;
/* loaded from: classes5.dex */
public class h {
    private com.baidu.swan.menu.viewpager.b eqC;
    private int eqI;
    private boolean eqJ = true;
    private int eqK = 0;
    private int eqL = -1;
    public int eqM = 0;
    private long eqN = 0;
    private e eqO;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public h(int i, int i2, int i3, boolean z) {
        this.eqI = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.eqI = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int bbu() {
        return this.eqM;
    }

    public void lE(int i) {
        this.eqM = i;
    }

    public long bbv() {
        return this.eqN;
    }

    public void dk(long j) {
        this.eqN = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void lF(int i) {
        this.eqI = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String eE(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.eqI <= 0) {
            return null;
        }
        return context.getResources().getString(this.eqI);
    }

    public Drawable eF(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int bbw() {
        return this.eqK;
    }

    public boolean isVisible() {
        return this.eqJ;
    }

    public int getTitleColor() {
        return this.eqL == -1 ? f.a.aiapp_menu_item_text : this.eqL;
    }

    public void a(e eVar) {
        this.eqO = eVar;
    }

    public e bbx() {
        return this.eqO;
    }

    public com.baidu.swan.menu.viewpager.b bby() {
        return this.eqC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h e(h hVar) {
        if (hVar == null) {
            return null;
        }
        return new h(hVar.mId, hVar.eqI, hVar.mIconResId, hVar.mEnable);
    }
}
