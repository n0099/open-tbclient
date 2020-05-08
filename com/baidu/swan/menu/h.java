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
    private j cYi;
    private List<i> cYj;
    private f cYm;
    private com.baidu.swan.menu.viewpager.b cYn;
    private View.OnKeyListener cYo;
    private a cYp;
    private b cYq;
    private Context mContext;
    private int mStyle;
    private boolean cYg = false;
    private int cYh = 0;
    private List<i> cYk = new ArrayList();
    private List<List<i>> cYl = new ArrayList();
    private int cYr = -1;

    /* loaded from: classes11.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.cYj = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.cYq = bVar;
            this.cYj = k.iD(this.mStyle);
            this.cYq.h(this.mStyle, this.cYj);
            this.cYq.i(this.mStyle, this.cYj);
            this.cYi = new j(this.mContext, view, aVar);
            this.cYi.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.cYp != null) {
                        h.this.cYp.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aBb() {
        this.cYl.clear();
        int size = this.cYk.size();
        if (size > 0 && size <= 5) {
            this.cYl.add(this.cYk);
        } else if (size > 5 && size <= 10) {
            int i = this.cYg ? 5 : this.cYr;
            this.cYl.add(this.cYk.subList(0, i));
            this.cYl.add(this.cYk.subList(i, size));
        } else if (size > 10) {
            int ceil = this.cYg ? (int) Math.ceil(size / 2.0f) : this.cYr;
            this.cYl.add(this.cYk.subList(0, ceil));
            this.cYl.add(this.cYk.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        j(z, 0);
    }

    public void j(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            fS(true);
            return;
        }
        if (this.cYq != null) {
            this.cYq.g(this.mStyle, this.cYj);
        }
        k(z, i);
        aBb();
        this.cYi.b(this.cYl, view, z2, this.cYh);
        if (this.cYp != null) {
            this.cYp.a(this, true);
        }
    }

    public void a(f fVar) {
        this.cYm = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.cYn = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                fS(true);
            }
            if (this.cYm == null) {
                return false;
            }
            return this.cYm.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (e(iVar) && !this.cYg) {
            fS(true);
        }
        if (this.cYn == null) {
            return false;
        }
        return this.cYn.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.cYo != null) {
            return this.cYo.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void fR(boolean z) {
        a(iz(5), z);
        aBb();
        this.cYi.aBh();
        aBa();
    }

    public void fS(boolean z) {
        this.cYi.fU(z);
        if (this.cYp != null) {
            this.cYp.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.cYi != null && this.cYi.isShowing();
    }

    public void aBa() {
        if (this.cYi != null) {
            this.cYi.aBa();
        }
    }

    public void as(int i, int i2) {
        i iE;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.cYj) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (iE = k.iE(i)) != null) {
            int size = this.cYj.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.cYj.add(i3, iE);
        }
    }

    public void iw(int i) {
        if (this.cYj != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.cYj.size(); i3++) {
                if (this.cYj.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.cYj.remove(i2);
            }
        }
    }

    public void ix(int i) {
        this.cYi.ix(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void fT(boolean z) {
        this.cYg = z;
    }

    public void iy(int i) {
        this.cYh = i;
    }

    private void k(boolean z, int i) {
        if (this.cYj != null) {
            this.cYk.clear();
            iA(41);
            i a2 = a(iz(38), i);
            if (a2 != null && a2.isVisible()) {
                this.cYk.add(a2);
            }
            iA(48);
            iA(45);
            iA(4);
            iA(101);
            iA(9);
            iA(39);
            iA(42);
            i iz = iz(35);
            if (iz != null && iz.isVisible()) {
                this.cYk.add(iz);
                if (!this.cYg) {
                    this.cYr = this.cYk.size() - 1;
                }
            }
            iA(37);
            iA(100);
            i a3 = a(iz(5), z);
            if (a3 != null && a3.isVisible()) {
                this.cYk.add(a3);
            }
            iA(40);
            iA(46);
            iA(47);
            i iz2 = iz(36);
            if (iz2 != null && iz2.isVisible()) {
                iz2.b(this);
                this.cYk.add(iz2);
            }
        }
    }

    public void bV(JSONObject jSONObject) {
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
            for (i iVar : this.cYk) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aBd());
                    iVar.iB(l.longValue() > 0 ? 1 : 0);
                    iVar.bK(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.iC(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.iC(g.f.aiapp_menu_text_favorite);
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
        iVar.iC(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i iz(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.cYj.size()) {
                return null;
            }
            i iVar = this.cYj.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.bK(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void iA(int i) {
        i iz = iz(i);
        if (iz != null && iz.isVisible()) {
            this.cYk.add(iz);
        }
    }
}
