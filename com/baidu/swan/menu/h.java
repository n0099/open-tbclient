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
    private j cyT;
    private List<i> cyU;
    private f cyX;
    private com.baidu.swan.menu.viewpager.b cyY;
    private View.OnKeyListener cyZ;
    private a cza;
    private b czb;
    private Context mContext;
    private int mStyle;
    private boolean cyR = false;
    private int cyS = 0;
    private List<i> cyV = new ArrayList();
    private List<List<i>> cyW = new ArrayList();
    private int czc = -1;

    /* loaded from: classes11.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.cyU = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.czb = bVar;
            this.cyU = k.iw(this.mStyle);
            this.czb.g(this.mStyle, this.cyU);
            this.czb.h(this.mStyle, this.cyU);
            this.cyT = new j(this.mContext, view, aVar);
            this.cyT.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.cza != null) {
                        h.this.cza.a(h.this, false);
                    }
                }
            });
        }
    }

    private void asM() {
        this.cyW.clear();
        int size = this.cyV.size();
        if (size > 0 && size <= 5) {
            this.cyW.add(this.cyV);
        } else if (size > 5 && size <= 10) {
            int i = this.cyR ? 5 : this.czc;
            this.cyW.add(this.cyV.subList(0, i));
            this.cyW.add(this.cyV.subList(i, size));
        } else if (size > 10) {
            int ceil = this.cyR ? (int) Math.ceil(size / 2.0f) : this.czc;
            this.cyW.add(this.cyV.subList(0, ceil));
            this.cyW.add(this.cyV.subList(ceil, size));
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
        if (this.czb != null) {
            this.czb.f(this.mStyle, this.cyU);
        }
        j(z, i);
        asM();
        this.cyT.b(this.cyW, view, z2, this.cyS);
        if (this.cza != null) {
            this.cza.a(this, true);
        }
    }

    public void a(f fVar) {
        this.cyX = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.cyY = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                eU(true);
            }
            if (this.cyX == null) {
                return false;
            }
            return this.cyX.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (e(iVar) && !this.cyR) {
            eU(true);
        }
        if (this.cyY == null) {
            return false;
        }
        return this.cyY.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.cyZ != null) {
            return this.cyZ.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void eT(boolean z) {
        a(is(5), z);
        asM();
        this.cyT.asS();
        asL();
    }

    public void eU(boolean z) {
        this.cyT.eW(z);
        if (this.cza != null) {
            this.cza.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.cyT != null && this.cyT.isShowing();
    }

    public void asL() {
        if (this.cyT != null) {
            this.cyT.asL();
        }
    }

    public void ap(int i, int i2) {
        i ix;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.cyU) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (ix = k.ix(i)) != null) {
            int size = this.cyU.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.cyU.add(i3, ix);
        }
    }

    public void ip(int i) {
        if (this.cyU != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.cyU.size(); i3++) {
                if (this.cyU.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.cyU.remove(i2);
            }
        }
    }

    public void iq(int i) {
        this.cyT.iq(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void eV(boolean z) {
        this.cyR = z;
    }

    public void ir(int i) {
        this.cyS = i;
    }

    private void j(boolean z, int i) {
        if (this.cyU != null) {
            this.cyV.clear();
            it(41);
            i a2 = a(is(38), i);
            if (a2 != null && a2.isVisible()) {
                this.cyV.add(a2);
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
                this.cyV.add(is);
                if (!this.cyR) {
                    this.czc = this.cyV.size() - 1;
                }
            }
            it(37);
            it(100);
            i a3 = a(is(5), z);
            if (a3 != null && a3.isVisible()) {
                this.cyV.add(a3);
            }
            it(40);
            it(46);
            it(47);
            i is2 = is(36);
            if (is2 != null && is2.isVisible()) {
                is2.b(this);
                this.cyV.add(is2);
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
            for (i iVar : this.cyV) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.asO());
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
            if (i3 >= this.cyU.size()) {
                return null;
            }
            i iVar = this.cyU.get(i3);
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
            this.cyV.add(is);
        }
    }
}
