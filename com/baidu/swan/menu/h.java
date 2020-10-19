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
    private j dRX;
    private List<i> dRY;
    private f dSb;
    private com.baidu.swan.menu.viewpager.b dSc;
    private View.OnKeyListener dSd;
    private a dSe;
    private b dSf;
    private Context mContext;
    private int mStyle;
    private boolean dRV = false;
    private int dRW = 0;
    private List<i> dRZ = new ArrayList();
    private List<List<i>> dSa = new ArrayList();
    private int dSg = -1;

    /* loaded from: classes14.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.dRY = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.dSf = bVar;
            this.dRY = k.mo(this.mStyle);
            this.dSf.g(this.mStyle, this.dRY);
            this.dSf.h(this.mStyle, this.dRY);
            this.dRX = new j(this.mContext, view, aVar);
            this.dRX.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.dSe != null) {
                        h.this.dSe.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aVZ() {
        this.dSa.clear();
        int size = this.dRZ.size();
        if (size > 0 && size <= 5) {
            this.dSa.add(this.dRZ);
        } else if (size > 5 && size <= 10) {
            int i = this.dRV ? 5 : this.dSg;
            this.dSa.add(this.dRZ.subList(0, i));
            this.dSa.add(this.dRZ.subList(i, size));
        } else if (size > 10) {
            int ceil = this.dRV ? (int) Math.ceil(size / 2.0f) : this.dSg;
            this.dSa.add(this.dRZ.subList(0, ceil));
            this.dSa.add(this.dRZ.subList(ceil, size));
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
        if (this.dSf != null) {
            this.dSf.f(this.mStyle, this.dRY);
        }
        p(z, i);
        aVZ();
        this.dRX.b(this.dSa, view, z2, this.dRW);
        if (this.dSe != null) {
            this.dSe.a(this, true);
        }
    }

    public void a(f fVar) {
        this.dSb = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.dSb == null) {
                return false;
            }
            return this.dSb.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.dRV) {
            dismiss(true);
        }
        if (this.dSc == null) {
            return false;
        }
        return this.dSc.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.dSd != null) {
            return this.dSd.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void hu(boolean z) {
        a(mk(5), z);
        aVZ();
        this.dRX.axB();
        aVY();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.dRX.fl(z);
        if (this.dSe != null) {
            this.dSe.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.dRX != null && this.dRX.isShowing();
    }

    public void aVY() {
        if (this.dRX != null) {
            this.dRX.aVY();
        }
    }

    public void aA(int i, int i2) {
        i mp;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.dRY) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (mp = k.mp(i)) != null) {
            int size = this.dRY.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.dRY.add(i3, mp);
        }
    }

    public void mi(int i) {
        if (this.dRY != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.dRY.size(); i3++) {
                if (this.dRY.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.dRY.remove(i2);
            }
        }
    }

    public void mj(int i) {
        this.dRX.mj(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.dRW = i;
    }

    private void p(boolean z, int i) {
        if (this.dRY != null) {
            this.dRZ.clear();
            ml(41);
            i a2 = a(mk(38), i);
            if (a2 != null && a2.isVisible()) {
                this.dRZ.add(a2);
            }
            ml(48);
            ml(45);
            ml(4);
            ml(101);
            i mk = mk(35);
            if (mk != null && mk.isVisible()) {
                this.dRZ.add(mk);
            }
            ml(39);
            ml(42);
            ml(9);
            if (!this.dRV) {
                this.dSg = this.dRZ.size() - 1;
            }
            ml(37);
            ml(100);
            ml(43);
            i a3 = a(mk(5), z);
            if (a3 != null && a3.isVisible()) {
                this.dRZ.add(a3);
            }
            ml(46);
            ml(47);
            ml(49);
            ml(50);
        }
    }

    public void cz(JSONObject jSONObject) {
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
            for (i iVar : this.dRZ) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aWb());
                    iVar.mm(l.longValue() > 0 ? 1 : 0);
                    iVar.cm(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.mn(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.mn(g.f.aiapp_menu_text_favorite);
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
        iVar.mn(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i mk(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.dRY.size()) {
                return null;
            }
            i iVar = this.dRY.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.cm(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void ml(int i) {
        i mk = mk(i);
        if (mk != null && mk.isVisible()) {
            this.dRZ.add(mk);
        }
    }
}
