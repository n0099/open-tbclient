package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b cYn;
    private int cYt;
    private boolean cYu = true;
    private int cYv = 0;
    private int cYw = -1;
    public int cYx = 0;
    private long cYy = 0;
    private f cYz;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.cYt = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.cYt = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aBc() {
        return this.cYx;
    }

    public void iB(int i) {
        this.cYx = i;
    }

    public long aBd() {
        return this.cYy;
    }

    public void bK(long j) {
        this.cYy = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void iC(int i) {
        this.cYt = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String db(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.cYt <= 0) {
            return null;
        }
        return context.getResources().getString(this.cYt);
    }

    public Drawable dc(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aBe() {
        return this.cYv;
    }

    public boolean isVisible() {
        return this.cYu;
    }

    public int getTitleColor() {
        return this.cYw == -1 ? g.a.aiapp_menu_item_text : this.cYw;
    }

    public void a(f fVar) {
        this.cYz = fVar;
    }

    public f aBf() {
        return this.cYz;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.cYn = bVar;
    }

    public com.baidu.swan.menu.viewpager.b aBg() {
        return this.cYn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.cYt, iVar.mIconResId, iVar.mEnable);
    }
}
