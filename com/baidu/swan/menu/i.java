package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private f djD;
    private com.baidu.swan.menu.viewpager.b djr;
    private int djx;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean djy = true;
    private int djz = 0;
    private int djA = -1;
    public int djB = 0;
    private long djC = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.djx = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.djx = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aEU() {
        return this.djB;
    }

    public void iS(int i) {
        this.djB = i;
    }

    public long aEV() {
        return this.djC;
    }

    public void bI(long j) {
        this.djC = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void iT(int i) {
        this.djx = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dq(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.djx <= 0) {
            return null;
        }
        return context.getResources().getString(this.djx);
    }

    public Drawable dr(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aEW() {
        return this.djz;
    }

    public boolean isVisible() {
        return this.djy;
    }

    public int getTitleColor() {
        return this.djA == -1 ? g.a.aiapp_menu_item_text : this.djA;
    }

    public void a(f fVar) {
        this.djD = fVar;
    }

    public f aEX() {
        return this.djD;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.djr = bVar;
    }

    public com.baidu.swan.menu.viewpager.b aEY() {
        return this.djr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.djx, iVar.mIconResId, iVar.mEnable);
    }
}
