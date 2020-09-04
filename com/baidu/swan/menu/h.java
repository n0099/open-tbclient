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
/* loaded from: classes14.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j dDV;
    private List<i> dDW;
    private f dDZ;
    private com.baidu.swan.menu.viewpager.b dEa;
    private View.OnKeyListener dEb;
    private a dEc;
    private b dEd;
    private Context mContext;
    private int mStyle;
    private boolean dDT = false;
    private int dDU = 0;
    private List<i> dDX = new ArrayList();
    private List<List<i>> dDY = new ArrayList();
    private int dEe = -1;

    /* loaded from: classes14.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.dDW = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.dEd = bVar;
            this.dDW = k.lG(this.mStyle);
            this.dEd.g(this.mStyle, this.dDW);
            this.dEd.h(this.mStyle, this.dDW);
            this.dDV = new j(this.mContext, view, aVar);
            this.dDV.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.dEc != null) {
                        h.this.dEc.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aSE() {
        this.dDY.clear();
        int size = this.dDX.size();
        if (size > 0 && size <= 5) {
            this.dDY.add(this.dDX);
        } else if (size > 5 && size <= 10) {
            int i = this.dDT ? 5 : this.dEe;
            this.dDY.add(this.dDX.subList(0, i));
            this.dDY.add(this.dDX.subList(i, size));
        } else if (size > 10) {
            int ceil = this.dDT ? (int) Math.ceil(size / 2.0f) : this.dEe;
            this.dDY.add(this.dDX.subList(0, ceil));
            this.dDY.add(this.dDX.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        n(z, 0);
    }

    public void n(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            dismiss(true);
            return;
        }
        if (this.dEd != null) {
            this.dEd.f(this.mStyle, this.dDW);
        }
        o(z, i);
        aSE();
        this.dDV.b(this.dDY, view, z2, this.dDU);
        if (this.dEc != null) {
            this.dEc.a(this, true);
        }
    }

    public void a(f fVar) {
        this.dDZ = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.dDZ == null) {
                return false;
            }
            return this.dDZ.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.dDT) {
            dismiss(true);
        }
        if (this.dEa == null) {
            return false;
        }
        return this.dEa.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.dEb != null) {
            return this.dEb.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void ha(boolean z) {
        a(lC(5), z);
        aSE();
        this.dDV.auh();
        aSD();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.dDV.eR(z);
        if (this.dEc != null) {
            this.dEc.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.dDV != null && this.dDV.isShowing();
    }

    public void aSD() {
        if (this.dDV != null) {
            this.dDV.aSD();
        }
    }

    public void aB(int i, int i2) {
        i lH;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.dDW) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (lH = k.lH(i)) != null) {
            int size = this.dDW.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.dDW.add(i3, lH);
        }
    }

    public void lA(int i) {
        if (this.dDW != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.dDW.size(); i3++) {
                if (this.dDW.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.dDW.remove(i2);
            }
        }
    }

    public void lB(int i) {
        this.dDV.lB(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.dDU = i;
    }

    private void o(boolean z, int i) {
        if (this.dDW != null) {
            this.dDX.clear();
            lD(41);
            i a2 = a(lC(38), i);
            if (a2 != null && a2.isVisible()) {
                this.dDX.add(a2);
            }
            lD(48);
            lD(45);
            lD(4);
            lD(101);
            i lC = lC(35);
            if (lC != null && lC.isVisible()) {
                this.dDX.add(lC);
            }
            lD(39);
            lD(42);
            lD(9);
            if (!this.dDT) {
                this.dEe = this.dDX.size() - 1;
            }
            lD(37);
            lD(100);
            lD(43);
            i a3 = a(lC(5), z);
            if (a3 != null && a3.isVisible()) {
                this.dDX.add(a3);
            }
            lD(46);
            lD(47);
            lD(49);
            lD(50);
        }
    }

    public void cp(JSONObject jSONObject) {
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
            for (i iVar : this.dDX) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aSG());
                    iVar.lE(l.longValue() > 0 ? 1 : 0);
                    iVar.cd(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.lF(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.lF(g.f.aiapp_menu_text_favorite);
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
        iVar.lF(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i lC(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.dDW.size()) {
                return null;
            }
            i iVar = this.dDW.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.cd(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void lD(int i) {
        i lC = lC(i);
        if (lC != null && lC.isVisible()) {
            this.dDX.add(lC);
        }
    }
}
