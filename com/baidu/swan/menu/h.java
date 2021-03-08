package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.f;
/* loaded from: classes4.dex */
public class h {
    private com.baidu.swan.menu.viewpager.b eul;
    private int eur;
    private boolean eus = true;
    private int eut = 0;
    private int euu = -1;
    public int euv = 0;
    private long euw = 0;
    private e eux;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public h(int i, int i2, int i3, boolean z) {
        this.eur = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.eur = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int bbJ() {
        return this.euv;
    }

    public void lI(int i) {
        this.euv = i;
    }

    public long bbK() {
        return this.euw;
    }

    public void dq(long j) {
        this.euw = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void lJ(int i) {
        this.eur = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String eC(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.eur <= 0) {
            return null;
        }
        return context.getResources().getString(this.eur);
    }

    public Drawable eD(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int bbL() {
        return this.eut;
    }

    public boolean isVisible() {
        return this.eus;
    }

    public int getTitleColor() {
        return this.euu == -1 ? f.a.aiapp_menu_item_text : this.euu;
    }

    public void a(e eVar) {
        this.eux = eVar;
    }

    public e bbM() {
        return this.eux;
    }

    public com.baidu.swan.menu.viewpager.b bbN() {
        return this.eul;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h e(h hVar) {
        if (hVar == null) {
            return null;
        }
        return new h(hVar.mId, hVar.eur, hVar.mIconResId, hVar.mEnable);
    }
}
