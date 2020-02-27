package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b cyY;
    private int cze;
    private f czj;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean mIsVisible = true;
    private int czf = 0;
    private int czg = -1;
    public int czh = 0;
    private long czi = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.cze = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.cze = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int asN() {
        return this.czh;
    }

    public void iu(int i) {
        this.czh = i;
    }

    public long asO() {
        return this.czi;
    }

    public void bf(long j) {
        this.czi = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void iv(int i) {
        this.cze = i;
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
        if (this.cze <= 0) {
            return null;
        }
        return context.getResources().getString(this.cze);
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

    public int asP() {
        return this.czf;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public int getTitleColor() {
        return this.czg == -1 ? g.a.aiapp_menu_item_text : this.czg;
    }

    public void a(f fVar) {
        this.czj = fVar;
    }

    public f asQ() {
        return this.czj;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.cyY = bVar;
    }

    public com.baidu.swan.menu.viewpager.b asR() {
        return this.cyY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.cze, iVar.mIconResId, iVar.mEnable);
    }
}
