package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.g;
/* loaded from: classes5.dex */
public class i {
    private com.baidu.swan.menu.viewpager.b eeI;
    private int eeO;
    private boolean eeP = true;
    private int eeQ = 0;
    private int eeR = -1;
    public int eeS = 0;
    private long eeT = 0;
    private f eeU;
    private boolean mEnable;
    private Drawable mIcon;
    private int mIconResId;
    private int mId;
    private String mTitle;

    public i(int i, int i2, int i3, boolean z) {
        this.eeO = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.eeO = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int aZM() {
        return this.eeS;
    }

    public void mD(int i) {
        this.eeS = i;
    }

    public long aZN() {
        return this.eeT;
    }

    public void cK(long j) {
        this.eeT = j;
    }

    public int getItemId() {
        return this.mId;
    }

    public void mE(int i) {
        this.eeO = i;
    }

    public void setIconResId(int i) {
        this.mIconResId = i;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String dG(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        if (this.eeO <= 0) {
            return null;
        }
        return context.getResources().getString(this.eeO);
    }

    public Drawable dH(Context context) {
        if (this.mIcon != null) {
            return this.mIcon;
        }
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    public int aZO() {
        return this.eeQ;
    }

    public boolean isVisible() {
        return this.eeP;
    }

    public int getTitleColor() {
        return this.eeR == -1 ? g.a.aiapp_menu_item_text : this.eeR;
    }

    public void a(f fVar) {
        this.eeU = fVar;
    }

    public f aZP() {
        return this.eeU;
    }

    public com.baidu.swan.menu.viewpager.b aZQ() {
        return this.eeI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i e(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new i(iVar.mId, iVar.eeO, iVar.mIconResId, iVar.mEnable);
    }
}
