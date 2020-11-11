package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class i {
    private f egC;
    private com.baidu.swan.menu.viewpager.b egq;
    private int egw;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean egx = true;
    private int egy = 0;
    private int egz = -1;
    public int egA = 0;
    private long egB = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.egw = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.egw = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int bat() {
        return this.egA;
    }

    public void mH(int i) {
        this.egA = i;
    }

    public long bau() {
        return this.egB;
    }

    public void cK(long j) {
        this.egB = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void mI(int i) {
        this.egw = i;
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
        if (this.egw <= 0) {
            return null;
        }
        return context.getResources().getString(this.egw);
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

    public int bav() {
        return this.egy;
    }

    public boolean isVisible() {
        return this.egx;
    }

    public int getTitleColor() {
        return this.egz == -1 ? g.a.aiapp_menu_item_text : this.egz;
    }

    public void a(f fVar) {
        this.egC = fVar;
    }

    public f baw() {
        return this.egC;
    }

    public com.baidu.swan.menu.viewpager.b bax() {
        return this.egq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.egw, iVar.mIconResId, iVar.mEnable);
    }
}
