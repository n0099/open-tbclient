package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b dSc;
    private int dSi;
    private boolean dSj = true;
    private int dSk = 0;
    private int dSl = -1;
    public int dSm = 0;
    private long dSn = 0;
    private f dSo;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.dSi = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.dSi = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aWa() {
        return this.dSm;
    }

    public void mm(int i) {
        this.dSm = i;
    }

    public long aWb() {
        return this.dSn;
    }

    public void cm(long j) {
        this.dSn = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void mn(int i) {
        this.dSi = i;
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
        if (this.dSi <= 0) {
            return null;
        }
        return context.getResources().getString(this.dSi);
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

    public int aWc() {
        return this.dSk;
    }

    public boolean isVisible() {
        return this.dSj;
    }

    public int getTitleColor() {
        return this.dSl == -1 ? g.a.aiapp_menu_item_text : this.dSl;
    }

    public void a(f fVar) {
        this.dSo = fVar;
    }

    public f aWd() {
        return this.dSo;
    }

    public com.baidu.swan.menu.viewpager.b aWe() {
        return this.dSc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.dSi, iVar.mIconResId, iVar.mEnable);
    }
}
