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
    private j dDR;
    private List<i> dDS;
    private f dDV;
    private com.baidu.swan.menu.viewpager.b dDW;
    private View.OnKeyListener dDX;
    private a dDY;
    private b dDZ;
    private Context mContext;
    private int mStyle;
    private boolean dDP = false;
    private int dDQ = 0;
    private List<i> dDT = new ArrayList();
    private List<List<i>> dDU = new ArrayList();
    private int dEa = -1;

    /* loaded from: classes14.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.dDS = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.dDZ = bVar;
            this.dDS = k.lG(this.mStyle);
            this.dDZ.g(this.mStyle, this.dDS);
            this.dDZ.h(this.mStyle, this.dDS);
            this.dDR = new j(this.mContext, view, aVar);
            this.dDR.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.dDY != null) {
                        h.this.dDY.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aSE() {
        this.dDU.clear();
        int size = this.dDT.size();
        if (size > 0 && size <= 5) {
            this.dDU.add(this.dDT);
        } else if (size > 5 && size <= 10) {
            int i = this.dDP ? 5 : this.dEa;
            this.dDU.add(this.dDT.subList(0, i));
            this.dDU.add(this.dDT.subList(i, size));
        } else if (size > 10) {
            int ceil = this.dDP ? (int) Math.ceil(size / 2.0f) : this.dEa;
            this.dDU.add(this.dDT.subList(0, ceil));
            this.dDU.add(this.dDT.subList(ceil, size));
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
        if (this.dDZ != null) {
            this.dDZ.f(this.mStyle, this.dDS);
        }
        o(z, i);
        aSE();
        this.dDR.b(this.dDU, view, z2, this.dDQ);
        if (this.dDY != null) {
            this.dDY.a(this, true);
        }
    }

    public void a(f fVar) {
        this.dDV = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.dDV == null) {
                return false;
            }
            return this.dDV.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.dDP) {
            dismiss(true);
        }
        if (this.dDW == null) {
            return false;
        }
        return this.dDW.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.dDX != null) {
            return this.dDX.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void gZ(boolean z) {
        a(lC(5), z);
        aSE();
        this.dDR.auh();
        aSD();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.dDR.eQ(z);
        if (this.dDY != null) {
            this.dDY.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.dDR != null && this.dDR.isShowing();
    }

    public void aSD() {
        if (this.dDR != null) {
            this.dDR.aSD();
        }
    }

    public void aB(int i, int i2) {
        i lH;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.dDS) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (lH = k.lH(i)) != null) {
            int size = this.dDS.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.dDS.add(i3, lH);
        }
    }

    public void lA(int i) {
        if (this.dDS != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.dDS.size(); i3++) {
                if (this.dDS.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.dDS.remove(i2);
            }
        }
    }

    public void lB(int i) {
        this.dDR.lB(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.dDQ = i;
    }

    private void o(boolean z, int i) {
        if (this.dDS != null) {
            this.dDT.clear();
            lD(41);
            i a2 = a(lC(38), i);
            if (a2 != null && a2.isVisible()) {
                this.dDT.add(a2);
            }
            lD(48);
            lD(45);
            lD(4);
            lD(101);
            i lC = lC(35);
            if (lC != null && lC.isVisible()) {
                this.dDT.add(lC);
            }
            lD(39);
            lD(42);
            lD(9);
            if (!this.dDP) {
                this.dEa = this.dDT.size() - 1;
            }
            lD(37);
            lD(100);
            lD(43);
            i a3 = a(lC(5), z);
            if (a3 != null && a3.isVisible()) {
                this.dDT.add(a3);
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
            for (i iVar : this.dDT) {
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
            if (i3 >= this.dDS.size()) {
                return null;
            }
            i iVar = this.dDS.get(i3);
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
            this.dDT.add(lC);
        }
    }
}
