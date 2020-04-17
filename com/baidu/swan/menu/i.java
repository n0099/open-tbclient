package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b cYi;
    private int cYo;
    private boolean cYp = true;
    private int cYq = 0;
    private int cYr = -1;
    public int cYs = 0;
    private long cYt = 0;
    private f cYu;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.cYo = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.cYo = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aBc() {
        return this.cYs;
    }

    public void iB(int i) {
        this.cYs = i;
    }

    public long aBd() {
        return this.cYt;
    }

    public void bK(long j) {
        this.cYt = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void iC(int i) {
        this.cYo = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dn(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.cYo <= 0) {
            return null;
        }
        return context.getResources().getString(this.cYo);
    }

    /* renamed from: do  reason: not valid java name */
    public Drawable m29do(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aBe() {
        return this.cYq;
    }

    public boolean isVisible() {
        return this.cYp;
    }

    public int getTitleColor() {
        return this.cYr == -1 ? g.a.aiapp_menu_item_text : this.cYr;
    }

    public void a(f fVar) {
        this.cYu = fVar;
    }

    public f aBf() {
        return this.cYu;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.cYi = bVar;
    }

    public com.baidu.swan.menu.viewpager.b aBg() {
        return this.cYi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.cYo, iVar.mIconResId, iVar.mEnable);
    }
}
