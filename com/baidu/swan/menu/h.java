package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.f;
/* loaded from: classes6.dex */
public class h {
    private e evC;
    private com.baidu.swan.menu.viewpager.b evq;
    private int evw;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean evx = true;
    private int evy = 0;
    private int evz = -1;
    public int evA = 0;
    private long evB = 0;

    public h(int i, int i2, int i3, boolean z) {
        this.evw = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.evw = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int bfo() {
        return this.evA;
    }

    public void nk(int i) {
        this.evA = i;
    }

    public long bfp() {
        return this.evB;
    }

    public void dk(long j) {
        this.evB = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void nl(int i) {
        this.evw = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String eF(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.evw <= 0) {
            return null;
        }
        return context.getResources().getString(this.evw);
    }

    public Drawable eG(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int bfq() {
        return this.evy;
    }

    public boolean isVisible() {
        return this.evx;
    }

    public int getTitleColor() {
        return this.evz == -1 ? f.a.aiapp_menu_item_text : this.evz;
    }

    public void a(e eVar) {
        this.evC = eVar;
    }

    public e bfr() {
        return this.evC;
    }

    public com.baidu.swan.menu.viewpager.b bfs() {
        return this.evq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h e(h hVar) {
        if (hVar == null) {
            return null;
        }
        return new h(hVar.mId, hVar.evw, hVar.mIconResId, hVar.mEnable);
    }
}
