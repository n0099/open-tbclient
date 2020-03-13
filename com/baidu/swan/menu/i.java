package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b cza;
    private int czg;
    private f czl;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean mIsVisible = true;
    private int czh = 0;
    private int czi = -1;
    public int czj = 0;
    private long czk = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.czg = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.czg = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int asP() {
        return this.czj;
    }

    public void iu(int i) {
        this.czj = i;
    }

    public long asQ() {
        return this.czk;
    }

    public void bf(long j) {
        this.czk = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void iv(int i) {
        this.czg = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dA(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.czg <= 0) {
            return null;
        }
        return context.getResources().getString(this.czg);
    }

    public Drawable dB(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int asR() {
        return this.czh;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public int getTitleColor() {
        return this.czi == -1 ? g.a.aiapp_menu_item_text : this.czi;
    }

    public void a(f fVar) {
        this.czl = fVar;
    }

    public f asS() {
        return this.czl;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.cza = bVar;
    }

    public com.baidu.swan.menu.viewpager.b asT() {
        return this.cza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.czg, iVar.mIconResId, iVar.mEnable);
    }
}
