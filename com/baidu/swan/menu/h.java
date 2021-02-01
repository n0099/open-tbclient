package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.f;
/* loaded from: classes5.dex */
public class h {
    private com.baidu.swan.menu.viewpager.b esJ;
    private int esP;
    private boolean esQ = true;
    private int esR = 0;
    private int esS = -1;
    public int esT = 0;
    private long esU = 0;
    private e esV;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public h(int i, int i2, int i3, boolean z) {
        this.esP = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.esP = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int bbH() {
        return this.esT;
    }

    public void lH(int i) {
        this.esT = i;
    }

    public long bbI() {
        return this.esU;
    }

    public void dq(long j) {
        this.esU = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void lI(int i) {
        this.esP = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String eD(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.esP <= 0) {
            return null;
        }
        return context.getResources().getString(this.esP);
    }

    public Drawable eE(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int bbJ() {
        return this.esR;
    }

    public boolean isVisible() {
        return this.esQ;
    }

    public int getTitleColor() {
        return this.esS == -1 ? f.a.aiapp_menu_item_text : this.esS;
    }

    public void a(e eVar) {
        this.esV = eVar;
    }

    public e bbK() {
        return this.esV;
    }

    public com.baidu.swan.menu.viewpager.b bbL() {
        return this.esJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h e(h hVar) {
        if (hVar == null) {
            return null;
        }
        return new h(hVar.mId, hVar.esP, hVar.mIconResId, hVar.mEnable);
    }
}
