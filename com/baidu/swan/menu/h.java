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
/* loaded from: classes11.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j djm;
    private List<i> djn;
    private f djq;
    private com.baidu.swan.menu.viewpager.b djr;
    private View.OnKeyListener djs;
    private a djt;
    private b dju;
    private Context mContext;
    private int mStyle;
    private boolean djk = false;
    private int djl = 0;
    private List<i> djo = new ArrayList();
    private List<List<i>> djp = new ArrayList();
    private int djv = -1;

    /* loaded from: classes11.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.djn = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.dju = bVar;
            this.djn = k.iU(this.mStyle);
            this.dju.g(this.mStyle, this.djn);
            this.dju.h(this.mStyle, this.djn);
            this.djm = new j(this.mContext, view, aVar);
            this.djm.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.djt != null) {
                        h.this.djt.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aET() {
        this.djp.clear();
        int size = this.djo.size();
        if (size > 0 && size <= 5) {
            this.djp.add(this.djo);
        } else if (size > 5 && size <= 10) {
            int i = this.djk ? 5 : this.djv;
            this.djp.add(this.djo.subList(0, i));
            this.djp.add(this.djo.subList(i, size));
        } else if (size > 10) {
            int ceil = this.djk ? (int) Math.ceil(size / 2.0f) : this.djv;
            this.djp.add(this.djo.subList(0, ceil));
            this.djp.add(this.djo.subList(ceil, size));
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
            gd(true);
            return;
        }
        if (this.dju != null) {
            this.dju.f(this.mStyle, this.djn);
        }
        o(z, i);
        aET();
        this.djm.b(this.djp, view, z2, this.djl);
        if (this.djt != null) {
            this.djt.a(this, true);
        }
    }

    public void a(f fVar) {
        this.djq = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.djr = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                gd(true);
            }
            if (this.djq == null) {
                return false;
            }
            return this.djq.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean d(i iVar) {
        if (e(iVar) && !this.djk) {
            gd(true);
        }
        if (this.djr == null) {
            return false;
        }
        return this.djr.d(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.djs != null) {
            return this.djs.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void gc(boolean z) {
        a(iQ(5), z);
        aET();
        this.djm.aEZ();
        aES();
    }

    public void gd(boolean z) {
        this.djm.gf(z);
        if (this.djt != null) {
            this.djt.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.djm != null && this.djm.isShowing();
    }

    public void aES() {
        if (this.djm != null) {
            this.djm.aES();
        }
    }

    public void as(int i, int i2) {
        i iV;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.djn) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (iV = k.iV(i)) != null) {
            int size = this.djn.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.djn.add(i3, iV);
        }
    }

    public void iN(int i) {
        if (this.djn != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.djn.size(); i3++) {
                if (this.djn.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.djn.remove(i2);
            }
        }
    }

    public void iO(int i) {
        this.djm.iO(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void ge(boolean z) {
        this.djk = z;
    }

    public void iP(int i) {
        this.djl = i;
    }

    private void o(boolean z, int i) {
        if (this.djn != null) {
            this.djo.clear();
            iR(41);
            i a2 = a(iQ(38), i);
            if (a2 != null && a2.isVisible()) {
                this.djo.add(a2);
            }
            iR(48);
            iR(45);
            iR(4);
            iR(101);
            iR(9);
            iR(39);
            iR(42);
            i iQ = iQ(35);
            if (iQ != null && iQ.isVisible()) {
                this.djo.add(iQ);
                if (!this.djk) {
                    this.djv = this.djo.size() - 1;
                }
            }
            iR(37);
            iR(100);
            i a3 = a(iQ(5), z);
            if (a3 != null && a3.isVisible()) {
                this.djo.add(a3);
            }
            iR(40);
            iR(46);
            iR(47);
            i iQ2 = iQ(36);
            if (iQ2 != null && iQ2.isVisible()) {
                iQ2.b(this);
                this.djo.add(iQ2);
            }
        }
    }

    public void bW(JSONObject jSONObject) {
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
            for (i iVar : this.djo) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aEV());
                    iVar.iS(l.longValue() > 0 ? 1 : 0);
                    iVar.bI(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.iT(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.iT(g.f.aiapp_menu_text_favorite);
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
        iVar.iT(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i iQ(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.djn.size()) {
                return null;
            }
            i iVar = this.djn.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.bI(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void iR(int i) {
        i iQ = iQ(i);
        if (iQ != null && iQ.isVisible()) {
            this.djo.add(iQ);
        }
    }
}
