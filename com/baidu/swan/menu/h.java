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
    private j cyV;
    private List<i> cyW;
    private f cyZ;
    private com.baidu.swan.menu.viewpager.b cza;
    private View.OnKeyListener czb;
    private a czc;
    private b czd;
    private Context mContext;
    private int mStyle;
    private boolean cyT = false;
    private int cyU = 0;
    private List<i> cyX = new ArrayList();
    private List<List<i>> cyY = new ArrayList();
    private int cze = -1;

    /* loaded from: classes11.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.cyW = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.czd = bVar;
            this.cyW = k.iw(this.mStyle);
            this.czd.g(this.mStyle, this.cyW);
            this.czd.h(this.mStyle, this.cyW);
            this.cyV = new j(this.mContext, view, aVar);
            this.cyV.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.czc != null) {
                        h.this.czc.a(h.this, false);
                    }
                }
            });
        }
    }

    private void asO() {
        this.cyY.clear();
        int size = this.cyX.size();
        if (size > 0 && size <= 5) {
            this.cyY.add(this.cyX);
        } else if (size > 5 && size <= 10) {
            int i = this.cyT ? 5 : this.cze;
            this.cyY.add(this.cyX.subList(0, i));
            this.cyY.add(this.cyX.subList(i, size));
        } else if (size > 10) {
            int ceil = this.cyT ? (int) Math.ceil(size / 2.0f) : this.cze;
            this.cyY.add(this.cyX.subList(0, ceil));
            this.cyY.add(this.cyX.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        i(z, 0);
    }

    public void i(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            eU(true);
            return;
        }
        if (this.czd != null) {
            this.czd.f(this.mStyle, this.cyW);
        }
        j(z, i);
        asO();
        this.cyV.b(this.cyY, view, z2, this.cyU);
        if (this.czc != null) {
            this.czc.a(this, true);
        }
    }

    public void a(f fVar) {
        this.cyZ = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.cza = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                eU(true);
            }
            if (this.cyZ == null) {
                return false;
            }
            return this.cyZ.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (e(iVar) && !this.cyT) {
            eU(true);
        }
        if (this.cza == null) {
            return false;
        }
        return this.cza.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.czb != null) {
            return this.czb.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void eT(boolean z) {
        a(is(5), z);
        asO();
        this.cyV.asU();
        asN();
    }

    public void eU(boolean z) {
        this.cyV.eW(z);
        if (this.czc != null) {
            this.czc.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.cyV != null && this.cyV.isShowing();
    }

    public void asN() {
        if (this.cyV != null) {
            this.cyV.asN();
        }
    }

    public void ap(int i, int i2) {
        i ix;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.cyW) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (ix = k.ix(i)) != null) {
            int size = this.cyW.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.cyW.add(i3, ix);
        }
    }

    public void ip(int i) {
        if (this.cyW != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.cyW.size(); i3++) {
                if (this.cyW.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.cyW.remove(i2);
            }
        }
    }

    public void iq(int i) {
        this.cyV.iq(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void eV(boolean z) {
        this.cyT = z;
    }

    public void ir(int i) {
        this.cyU = i;
    }

    private void j(boolean z, int i) {
        if (this.cyW != null) {
            this.cyX.clear();
            it(41);
            i a2 = a(is(38), i);
            if (a2 != null && a2.isVisible()) {
                this.cyX.add(a2);
            }
            it(48);
            it(45);
            it(4);
            it(101);
            it(9);
            it(39);
            it(42);
            i is = is(35);
            if (is != null && is.isVisible()) {
                this.cyX.add(is);
                if (!this.cyT) {
                    this.cze = this.cyX.size() - 1;
                }
            }
            it(37);
            it(100);
            i a3 = a(is(5), z);
            if (a3 != null && a3.isVisible()) {
                this.cyX.add(a3);
            }
            it(40);
            it(46);
            it(47);
            i is2 = is(36);
            if (is2 != null && is2.isVisible()) {
                is2.b(this);
                this.cyX.add(is2);
            }
        }
    }

    public void bK(JSONObject jSONObject) {
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
            for (i iVar : this.cyX) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.asQ());
                    iVar.iu(l.longValue() > 0 ? 1 : 0);
                    iVar.bf(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.iv(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.iv(g.f.aiapp_menu_text_favorite);
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
        iVar.iv(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i is(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.cyW.size()) {
                return null;
            }
            i iVar = this.cyW.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.bf(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void it(int i) {
        i is = is(i);
        if (is != null && is.isVisible()) {
            this.cyX.add(is);
        }
    }
}
