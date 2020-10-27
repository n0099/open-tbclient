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
    private a eaA;
    private b eaB;
    private j eat;
    private List<i> eau;
    private f eax;
    private com.baidu.swan.menu.viewpager.b eay;
    private View.OnKeyListener eaz;
    private Context mContext;
    private int mStyle;
    private boolean ear = false;
    private int eas = 0;
    private List<i> eav = new ArrayList();
    private List<List<i>> eaw = new ArrayList();
    private int eaC = -1;

    /* loaded from: classes14.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.eau = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.eaB = bVar;
            this.eau = k.mz(this.mStyle);
            this.eaB.g(this.mStyle, this.eau);
            this.eaB.h(this.mStyle, this.eau);
            this.eat = new j(this.mContext, view, aVar);
            this.eat.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.eaA != null) {
                        h.this.eaA.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aXS() {
        this.eaw.clear();
        int size = this.eav.size();
        if (size > 0 && size <= 5) {
            this.eaw.add(this.eav);
        } else if (size > 5 && size <= 10) {
            int i = this.ear ? 5 : this.eaC;
            this.eaw.add(this.eav.subList(0, i));
            this.eaw.add(this.eav.subList(i, size));
        } else if (size > 10) {
            int ceil = this.ear ? (int) Math.ceil(size / 2.0f) : this.eaC;
            this.eaw.add(this.eav.subList(0, ceil));
            this.eaw.add(this.eav.subList(ceil, size));
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
        if (this.eaB != null) {
            this.eaB.f(this.mStyle, this.eau);
        }
        p(z, i);
        aXS();
        this.eat.b(this.eaw, view, z2, this.eas);
        if (this.eaA != null) {
            this.eaA.a(this, true);
        }
    }

    public void a(f fVar) {
        this.eax = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.eax == null) {
                return false;
            }
            return this.eax.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.ear) {
            dismiss(true);
        }
        if (this.eay == null) {
            return false;
        }
        return this.eay.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.eaz != null) {
            return this.eaz.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void hH(boolean z) {
        a(mv(5), z);
        aXS();
        this.eat.azv();
        aXR();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.eat.fy(z);
        if (this.eaA != null) {
            this.eaA.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.eat != null && this.eat.isShowing();
    }

    public void aXR() {
        if (this.eat != null) {
            this.eat.aXR();
        }
    }

    public void aB(int i, int i2) {
        i mA;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.eau) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (mA = k.mA(i)) != null) {
            int size = this.eau.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.eau.add(i3, mA);
        }
    }

    public void mt(int i) {
        if (this.eau != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.eau.size(); i3++) {
                if (this.eau.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.eau.remove(i2);
            }
        }
    }

    public void mu(int i) {
        this.eat.mu(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.eas = i;
    }

    private void p(boolean z, int i) {
        if (this.eau != null) {
            this.eav.clear();
            mw(41);
            i a2 = a(mv(38), i);
            if (a2 != null && a2.isVisible()) {
                this.eav.add(a2);
            }
            mw(48);
            mw(45);
            mw(4);
            mw(101);
            i mv = mv(35);
            if (mv != null && mv.isVisible()) {
                this.eav.add(mv);
            }
            mw(39);
            mw(42);
            mw(9);
            if (!this.ear) {
                this.eaC = this.eav.size() - 1;
            }
            mw(37);
            mw(100);
            mw(43);
            i a3 = a(mv(5), z);
            if (a3 != null && a3.isVisible()) {
                this.eav.add(a3);
            }
            mw(46);
            mw(47);
            mw(49);
            mw(50);
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
            for (i iVar : this.eav) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aXU());
                    iVar.mx(l.longValue() > 0 ? 1 : 0);
                    iVar.co(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.my(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.my(g.f.aiapp_menu_text_favorite);
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
        iVar.my(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i mv(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.eau.size()) {
                return null;
            }
            i iVar = this.eau.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.co(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void mw(int i) {
        i mv = mv(i);
        if (mv != null && mv.isVisible()) {
            this.eav.add(mv);
        }
    }
}
