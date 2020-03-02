package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b cyZ;
    private int czf;
    private f czk;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean mIsVisible = true;
    private int czg = 0;
    private int czh = -1;
    public int czi = 0;
    private long czj = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.czf = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.czf = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int asP() {
        return this.czi;
    }

    public void iu(int i) {
        this.czi = i;
    }

    public long asQ() {
        return this.czj;
    }

    public void bf(long j) {
        this.czj = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void iv(int i) {
        this.czf = i;
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
        if (this.czf <= 0) {
            return null;
        }
        return context.getResources().getString(this.czf);
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
        return this.czg;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public int getTitleColor() {
        return this.czh == -1 ? g.a.aiapp_menu_item_text : this.czh;
    }

    public void a(f fVar) {
        this.czk = fVar;
    }

    public f asS() {
        return this.czk;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.cyZ = bVar;
    }

    public com.baidu.swan.menu.viewpager.b asT() {
        return this.cyZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.czf, iVar.mIconResId, iVar.mEnable);
    }
}
