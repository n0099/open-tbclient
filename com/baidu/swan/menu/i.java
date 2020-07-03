package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes11.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b dob;
    private int doi;
    private boolean doj = true;
    private int dok = 0;
    private int dol = -1;
    public int dom = 0;
    private long don = 0;
    private f doo;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.doi = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.doi = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aGa() {
        return this.dom;
    }

    public void jf(int i) {
        this.dom = i;
    }

    public long aGb() {
        return this.don;
    }

    public void bI(long j) {
        this.don = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void jg(int i) {
        this.doi = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dr(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.doi <= 0) {
            return null;
        }
        return context.getResources().getString(this.doi);
    }

    public Drawable ds(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aGc() {
        return this.dok;
    }

    public boolean isVisible() {
        return this.doj;
    }

    public int getTitleColor() {
        return this.dol == -1 ? g.a.aiapp_menu_item_text : this.dol;
    }

    public void a(f fVar) {
        this.doo = fVar;
    }

    public f aGd() {
        return this.doo;
    }

    public void b(com.baidu.swan.menu.viewpager.b bVar) {
        this.dob = bVar;
    }

    public com.baidu.swan.menu.viewpager.b aGe() {
        return this.dob;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.doi, iVar.mIconResId, iVar.mEnable);
    }
}
