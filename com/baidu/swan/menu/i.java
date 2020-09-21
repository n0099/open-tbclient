package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes23.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b dGb;
    private int dGh;
    private boolean dGi = true;
    private int dGj = 0;
    private int dGk = -1;
    public int dGl = 0;
    private long dGm = 0;
    private f dGn;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.dGh = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.dGh = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aTr() {
        return this.dGl;
    }

    public void lP(int i) {
        this.dGl = i;
    }

    public long aTs() {
        return this.dGm;
    }

    public void ce(long j) {
        this.dGm = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void lQ(int i) {
        this.dGh = i;
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
        if (this.dGh <= 0) {
            return null;
        }
        return context.getResources().getString(this.dGh);
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

    public int aTt() {
        return this.dGj;
    }

    public boolean isVisible() {
        return this.dGi;
    }

    public int getTitleColor() {
        return this.dGk == -1 ? g.a.aiapp_menu_item_text : this.dGk;
    }

    public void a(f fVar) {
        this.dGn = fVar;
    }

    public f aTu() {
        return this.dGn;
    }

    public com.baidu.swan.menu.viewpager.b aTv() {
        return this.dGb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.dGh, iVar.mIconResId, iVar.mEnable);
    }
}
