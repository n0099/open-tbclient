package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes10.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b cva;
    private int cvg;
    private f cvl;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;
    private boolean mIsVisible = true;
    private int cvh = 0;
    private int cvi = -1;
    public int cvj = 0;
    private long cvk = 0;

    public i(int i, int i2, int i3, boolean z) {
        this.cvg = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.cvg = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aqz() {
        return this.cvj;
    }

    public void id(int i) {
        this.cvj = i;
    }

    public long aqA() {
        return this.cvk;
    }

    public void bb(long j) {
        this.cvk = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void ie(int i) {
        this.cvg = i;
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
        if (this.cvg <= 0) {
            return null;
        }
        return context.getResources().getString(this.cvg);
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

    public int aqB() {
        return this.cvh;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public int getTitleColor() {
        return this.cvi == -1 ? g.a.aiapp_menu_item_text : this.cvi;
    }

    public void a(f fVar) {
        this.cvl = fVar;
    }

    public f aqC() {
        return this.cvl;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.cva = bVar;
    }

    public com.baidu.swan.menu.viewpager.b aqD() {
        return this.cva;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.cvg, iVar.mIconResId, iVar.mEnable);
    }
}
