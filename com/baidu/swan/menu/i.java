package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes9.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b cuP;
    private int cuV;
    private f cva;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean mIsVisible = true;
    private int cuW = 0;
    private int cuX = -1;
    public int cuY = 0;
    private long cuZ = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.cuV = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.cuV = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aqg() {
        return this.cuY;
    }

    public void id(int i) {
        this.cuY = i;
    }

    public long aqh() {
        return this.cuZ;
    }

    public void aY(long j) {
        this.cuZ = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void ie(int i) {
        this.cuV = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dw(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.cuV <= 0) {
            return null;
        }
        return context.getResources().getString(this.cuV);
    }

    public Drawable dx(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aqi() {
        return this.cuW;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public int getTitleColor() {
        return this.cuX == -1 ? g.a.aiapp_menu_item_text : this.cuX;
    }

    public void a(f fVar) {
        this.cva = fVar;
    }

    public f aqj() {
        return this.cva;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.cuP = bVar;
    }

    public com.baidu.swan.menu.viewpager.b aqk() {
        return this.cuP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.cuV, iVar.mIconResId, iVar.mEnable);
    }
}
