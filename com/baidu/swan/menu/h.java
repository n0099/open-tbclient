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
/* loaded from: classes10.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j cuV;
    private List<i> cuW;
    private f cuZ;
    private com.baidu.swan.menu.viewpager.b cva;
    private View.OnKeyListener cvb;
    private a cvc;
    private b cvd;
    private Context mContext;
    private int mStyle;
    private boolean cuT = false;
    private int cuU = 0;
    private List<i> cuX = new ArrayList();
    private List<List<i>> cuY = new ArrayList();
    private int cve = -1;

    /* loaded from: classes10.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.cuW = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.cvd = bVar;
            this.cuW = k.m25if(this.mStyle);
            this.cvd.g(this.mStyle, this.cuW);
            this.cvd.h(this.mStyle, this.cuW);
            this.cuV = new j(this.mContext, view, aVar);
            this.cuV.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.cvc != null) {
                        h.this.cvc.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aqy() {
        this.cuY.clear();
        int size = this.cuX.size();
        if (size > 0 && size <= 5) {
            this.cuY.add(this.cuX);
        } else if (size > 5 && size <= 10) {
            int i = this.cuT ? 5 : this.cve;
            this.cuY.add(this.cuX.subList(0, i));
            this.cuY.add(this.cuX.subList(i, size));
        } else if (size > 10) {
            int ceil = this.cuT ? (int) Math.ceil(size / 2.0f) : this.cve;
            this.cuY.add(this.cuX.subList(0, ceil));
            this.cuY.add(this.cuX.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        h(z, 0);
    }

    public void h(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            eN(true);
            return;
        }
        if (this.cvd != null) {
            this.cvd.f(this.mStyle, this.cuW);
        }
        i(z, i);
        aqy();
        this.cuV.b(this.cuY, view, z2, this.cuU);
        if (this.cvc != null) {
            this.cvc.a(this, true);
        }
    }

    public void a(f fVar) {
        this.cuZ = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.cva = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                eN(true);
            }
            if (this.cuZ == null) {
                return false;
            }
            return this.cuZ.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (e(iVar) && !this.cuT) {
            eN(true);
        }
        if (this.cva == null) {
            return false;
        }
        return this.cva.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.cvb != null) {
            return this.cvb.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void eM(boolean z) {
        a(ib(5), z);
        aqy();
        this.cuV.aqE();
        aqx();
    }

    public void eN(boolean z) {
        this.cuV.eP(z);
        if (this.cvc != null) {
            this.cvc.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.cuV != null && this.cuV.isShowing();
    }

    public void aqx() {
        if (this.cuV != null) {
            this.cuV.aqx();
        }
    }

    public void ap(int i, int i2) {
        i ig;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.cuW) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (ig = k.ig(i)) != null) {
            int size = this.cuW.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.cuW.add(i3, ig);
        }
    }

    public void hY(int i) {
        if (this.cuW != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.cuW.size(); i3++) {
                if (this.cuW.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.cuW.remove(i2);
            }
        }
    }

    public void hZ(int i) {
        this.cuV.hZ(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void eO(boolean z) {
        this.cuT = z;
    }

    public void ia(int i) {
        this.cuU = i;
    }

    private void i(boolean z, int i) {
        if (this.cuW != null) {
            this.cuX.clear();
            ic(41);
            i a2 = a(ib(38), i);
            if (a2 != null && a2.isVisible()) {
                this.cuX.add(a2);
            }
            ic(48);
            ic(45);
            ic(4);
            ic(101);
            ic(9);
            ic(39);
            ic(42);
            i ib = ib(35);
            if (ib != null && ib.isVisible()) {
                this.cuX.add(ib);
                if (!this.cuT) {
                    this.cve = this.cuX.size() - 1;
                }
            }
            ic(37);
            ic(100);
            i a3 = a(ib(5), z);
            if (a3 != null && a3.isVisible()) {
                this.cuX.add(a3);
            }
            ic(40);
            ic(46);
            ic(47);
            i ib2 = ib(36);
            if (ib2 != null && ib2.isVisible()) {
                ib2.b(this);
                this.cuX.add(ib2);
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
            for (i iVar : this.cuX) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aqA());
                    iVar.id(l.longValue() > 0 ? 1 : 0);
                    iVar.bb(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.ie(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.ie(g.f.aiapp_menu_text_favorite);
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
        iVar.ie(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i ib(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.cuW.size()) {
                return null;
            }
            i iVar = this.cuW.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.bb(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void ic(int i) {
        i ib = ib(i);
        if (ib != null && ib.isVisible()) {
            this.cuX.add(ib);
        }
    }
}
