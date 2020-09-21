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
/* loaded from: classes23.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j dFW;
    private List<i> dFX;
    private f dGa;
    private com.baidu.swan.menu.viewpager.b dGb;
    private View.OnKeyListener dGc;
    private a dGd;
    private b dGe;
    private Context mContext;
    private int mStyle;
    private boolean dFU = false;
    private int dFV = 0;
    private List<i> dFY = new ArrayList();
    private List<List<i>> dFZ = new ArrayList();
    private int dGf = -1;

    /* loaded from: classes23.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.dFX = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.dGe = bVar;
            this.dFX = k.lR(this.mStyle);
            this.dGe.g(this.mStyle, this.dFX);
            this.dGe.h(this.mStyle, this.dFX);
            this.dFW = new j(this.mContext, view, aVar);
            this.dFW.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.dGd != null) {
                        h.this.dGd.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aTq() {
        this.dFZ.clear();
        int size = this.dFY.size();
        if (size > 0 && size <= 5) {
            this.dFZ.add(this.dFY);
        } else if (size > 5 && size <= 10) {
            int i = this.dFU ? 5 : this.dGf;
            this.dFZ.add(this.dFY.subList(0, i));
            this.dFZ.add(this.dFY.subList(i, size));
        } else if (size > 10) {
            int ceil = this.dFU ? (int) Math.ceil(size / 2.0f) : this.dGf;
            this.dFZ.add(this.dFY.subList(0, ceil));
            this.dFZ.add(this.dFY.subList(ceil, size));
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
        if (this.dGe != null) {
            this.dGe.f(this.mStyle, this.dFX);
        }
        o(z, i);
        aTq();
        this.dFW.b(this.dFZ, view, z2, this.dFV);
        if (this.dGd != null) {
            this.dGd.a(this, true);
        }
    }

    public void a(f fVar) {
        this.dGa = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.dGa == null) {
                return false;
            }
            return this.dGa.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.dFU) {
            dismiss(true);
        }
        if (this.dGb == null) {
            return false;
        }
        return this.dGb.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.dGc != null) {
            return this.dGc.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void gY(boolean z) {
        a(lN(5), z);
        aTq();
        this.dFW.auQ();
        aTp();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.dFW.eP(z);
        if (this.dGd != null) {
            this.dGd.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.dFW != null && this.dFW.isShowing();
    }

    public void aTp() {
        if (this.dFW != null) {
            this.dFW.aTp();
        }
    }

    public void aB(int i, int i2) {
        i lS;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.dFX) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (lS = k.lS(i)) != null) {
            int size = this.dFX.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.dFX.add(i3, lS);
        }
    }

    public void lL(int i) {
        if (this.dFX != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.dFX.size(); i3++) {
                if (this.dFX.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.dFX.remove(i2);
            }
        }
    }

    public void lM(int i) {
        this.dFW.lM(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.dFV = i;
    }

    private void o(boolean z, int i) {
        if (this.dFX != null) {
            this.dFY.clear();
            lO(41);
            i a2 = a(lN(38), i);
            if (a2 != null && a2.isVisible()) {
                this.dFY.add(a2);
            }
            lO(48);
            lO(45);
            lO(4);
            lO(101);
            i lN = lN(35);
            if (lN != null && lN.isVisible()) {
                this.dFY.add(lN);
            }
            lO(39);
            lO(42);
            lO(9);
            if (!this.dFU) {
                this.dGf = this.dFY.size() - 1;
            }
            lO(37);
            lO(100);
            lO(43);
            i a3 = a(lN(5), z);
            if (a3 != null && a3.isVisible()) {
                this.dFY.add(a3);
            }
            lO(46);
            lO(47);
            lO(49);
            lO(50);
        }
    }

    public void cs(JSONObject jSONObject) {
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
            for (i iVar : this.dFY) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aTs());
                    iVar.lP(l.longValue() > 0 ? 1 : 0);
                    iVar.ce(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.lQ(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.lQ(g.f.aiapp_menu_text_favorite);
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
        iVar.lQ(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i lN(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.dFX.size()) {
                return null;
            }
            i iVar = this.dFX.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.ce(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void lO(int i) {
        i lN = lN(i);
        if (lN != null && lN.isVisible()) {
            this.dFY.add(lN);
        }
    }
}
