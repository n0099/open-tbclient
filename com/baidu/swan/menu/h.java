package com.baidu.swan.menu;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j eeD;
    private List<i> eeE;
    private f eeH;
    private com.baidu.swan.menu.viewpager.b eeI;
    private View.OnKeyListener eeJ;
    private a eeK;
    private b eeL;
    private Context mContext;
    private int mStyle;
    private boolean eeB = false;
    private int eeC = 0;
    private List<i> eeF = new ArrayList();
    private List<List<i>> eeG = new ArrayList();
    private int eeM = -1;

    /* loaded from: classes5.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.eeE = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.eeL = bVar;
            this.eeE = k.mF(this.mStyle);
            this.eeL.g(this.mStyle, this.eeE);
            this.eeL.h(this.mStyle, this.eeE);
            this.eeD = new j(this.mContext, view, aVar);
            this.eeD.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.eeK != null) {
                        h.this.eeK.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aZL() {
        this.eeG.clear();
        int size = this.eeF.size();
        if (size > 0 && size <= 5) {
            this.eeG.add(this.eeF);
        } else if (size > 5 && size <= 10) {
            int i = this.eeB ? 5 : this.eeM;
            this.eeG.add(this.eeF.subList(0, i));
            this.eeG.add(this.eeF.subList(i, size));
        } else if (size > 10) {
            int ceil = this.eeB ? (int) Math.ceil(size / 2.0f) : this.eeM;
            this.eeG.add(this.eeF.subList(0, ceil));
            this.eeG.add(this.eeF.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        o(z, 0);
    }

    public void o(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            dismiss(true);
            return;
        }
        if (this.eeL != null) {
            this.eeL.f(this.mStyle, this.eeE);
        }
        p(z, i);
        aZL();
        this.eeD.b(this.eeG, view, z2, this.eeC);
        if (this.eeK != null) {
            this.eeK.a(this, true);
        }
    }

    public void a(f fVar) {
        this.eeH = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.eeH == null) {
                return false;
            }
            return this.eeH.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.eeB) {
            dismiss(true);
        }
        if (this.eeI == null) {
            return false;
        }
        return this.eeI.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.eeJ != null) {
            return this.eeJ.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void hT(boolean z) {
        a(mB(5), z);
        aZL();
        this.eeD.aBn();
        aZK();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.eeD.fK(z);
        if (this.eeK != null) {
            this.eeK.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.eeD != null && this.eeD.isShowing();
    }

    public void aZK() {
        if (this.eeD != null) {
            this.eeD.aZK();
        }
    }

    public void aB(int i, int i2) {
        i mG;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.eeE) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (mG = k.mG(i)) != null) {
            int size = this.eeE.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.eeE.add(i3, mG);
        }
    }

    public void mz(int i) {
        if (this.eeE != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.eeE.size(); i3++) {
                if (this.eeE.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.eeE.remove(i2);
            }
        }
    }

    public void mA(int i) {
        this.eeD.mA(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.eeC = i;
    }

    private void p(boolean z, int i) {
        if (this.eeE != null) {
            this.eeF.clear();
            mC(41);
            i a2 = a(mB(38), i);
            if (a2 != null && a2.isVisible()) {
                this.eeF.add(a2);
            }
            mC(48);
            mC(45);
            mC(4);
            mC(101);
            i mB = mB(35);
            if (mB != null && mB.isVisible()) {
                this.eeF.add(mB);
            }
            mC(39);
            mC(42);
            mC(9);
            if (!this.eeB) {
                this.eeM = this.eeF.size() - 1;
            }
            mC(37);
            mC(100);
            mC(43);
            i a3 = a(mB(5), z);
            if (a3 != null && a3.isVisible()) {
                this.eeF.add(a3);
            }
            mC(46);
            mC(47);
            mC(49);
            mC(50);
        }
    }

    public void cC(JSONObject jSONObject) {
        int i;
        int optInt = jSONObject.optInt("pa_type");
        Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
        switch (optInt) {
            case 7:
                i = 45;
                break;
            case 666:
                i = 46;
                break;
            case 888:
                i = 47;
                break;
            case 999:
                i = 48;
                break;
            default:
                i = -1;
                break;
        }
        if (i >= 0) {
            Long l = valueOf;
            for (i iVar : this.eeF) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aZN());
                    iVar.mD(l.longValue() > 0 ? 1 : 0);
                    iVar.cK(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.mE(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.mE(g.f.aiapp_menu_text_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_add_fav_selector);
        } else if (i == 0) {
            iVar = null;
        }
        return iVar;
    }

    private i a(i iVar, boolean z) {
        if (iVar == null) {
            return null;
        }
        iVar.mE(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i mB(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.eeE.size()) {
                return null;
            }
            i iVar = this.eeE.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.cK(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void mC(int i) {
        i mB = mB(i);
        if (mB != null && mB.isVisible()) {
            this.eeF.add(mB);
        }
    }
}
