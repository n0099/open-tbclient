package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes9.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b dtX;
    private int dud;
    private boolean due = true;
    private int duf = 0;
    private int dug = -1;
    public int duh = 0;
    private long dui = 0;
    private f duj;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.dud = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.dud = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aJR() {
        return this.duh;
    }

    public void jw(int i) {
        this.duh = i;
    }

    public long aJS() {
        return this.dui;
    }

    public void bW(long j) {
        this.dui = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void jx(int i) {
        this.dud = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dv(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.dud <= 0) {
            return null;
        }
        return context.getResources().getString(this.dud);
    }

    public Drawable dw(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aJT() {
        return this.duf;
    }

    public boolean isVisible() {
        return this.due;
    }

    public int getTitleColor() {
        return this.dug == -1 ? g.a.aiapp_menu_item_text : this.dug;
    }

    public void a(f fVar) {
        this.duj = fVar;
    }

    public f aJU() {
        return this.duj;
    }

    public com.baidu.swan.menu.viewpager.b aJV() {
        return this.dtX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.dud, iVar.mIconResId, iVar.mEnable);
    }
}
