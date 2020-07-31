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
/* loaded from: classes9.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j dtS;
    private List<i> dtT;
    private f dtW;
    private com.baidu.swan.menu.viewpager.b dtX;
    private View.OnKeyListener dtY;
    private a dtZ;
    private b dua;
    private Context mContext;
    private int mStyle;
    private boolean dtQ = false;
    private int dtR = 0;
    private List<i> dtU = new ArrayList();
    private List<List<i>> dtV = new ArrayList();
    private int dub = -1;

    /* loaded from: classes9.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.dtT = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.dua = bVar;
            this.dtT = k.jy(this.mStyle);
            this.dua.g(this.mStyle, this.dtT);
            this.dua.h(this.mStyle, this.dtT);
            this.dtS = new j(this.mContext, view, aVar);
            this.dtS.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.dtZ != null) {
                        h.this.dtZ.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aJQ() {
        this.dtV.clear();
        int size = this.dtU.size();
        if (size > 0 && size <= 5) {
            this.dtV.add(this.dtU);
        } else if (size > 5 && size <= 10) {
            int i = this.dtQ ? 5 : this.dub;
            this.dtV.add(this.dtU.subList(0, i));
            this.dtV.add(this.dtU.subList(i, size));
        } else if (size > 10) {
            int ceil = this.dtQ ? (int) Math.ceil(size / 2.0f) : this.dub;
            this.dtV.add(this.dtU.subList(0, ceil));
            this.dtV.add(this.dtU.subList(ceil, size));
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
            gE(true);
            return;
        }
        if (this.dua != null) {
            this.dua.f(this.mStyle, this.dtT);
        }
        o(z, i);
        aJQ();
        this.dtS.b(this.dtV, view, z2, this.dtR);
        if (this.dtZ != null) {
            this.dtZ.a(this, true);
        }
    }

    public void a(f fVar) {
        this.dtW = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                gE(true);
            }
            if (this.dtW == null) {
                return false;
            }
            return this.dtW.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.dtQ) {
            gE(true);
        }
        if (this.dtX == null) {
            return false;
        }
        return this.dtX.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.dtY != null) {
            return this.dtY.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void gD(boolean z) {
        a(ju(5), z);
        aJQ();
        this.dtS.aJW();
        aJP();
    }

    public void dismiss() {
        gE(true);
    }

    public void gE(boolean z) {
        this.dtS.gF(z);
        if (this.dtZ != null) {
            this.dtZ.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.dtS != null && this.dtS.isShowing();
    }

    public void aJP() {
        if (this.dtS != null) {
            this.dtS.aJP();
        }
    }

    public void au(int i, int i2) {
        i jz;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.dtT) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (jz = k.jz(i)) != null) {
            int size = this.dtT.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.dtT.add(i3, jz);
        }
    }

    public void jr(int i) {
        if (this.dtT != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.dtT.size(); i3++) {
                if (this.dtT.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.dtT.remove(i2);
            }
        }
    }

    public void js(int i) {
        this.dtS.js(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void jt(int i) {
        this.dtR = i;
    }

    private void o(boolean z, int i) {
        if (this.dtT != null) {
            this.dtU.clear();
            jv(41);
            i a2 = a(ju(38), i);
            if (a2 != null && a2.isVisible()) {
                this.dtU.add(a2);
            }
            jv(48);
            jv(45);
            jv(4);
            jv(101);
            i ju = ju(35);
            if (ju != null && ju.isVisible()) {
                this.dtU.add(ju);
            }
            jv(39);
            jv(42);
            jv(9);
            if (!this.dtQ) {
                this.dub = this.dtU.size() - 1;
            }
            jv(37);
            jv(100);
            jv(43);
            i a3 = a(ju(5), z);
            if (a3 != null && a3.isVisible()) {
                this.dtU.add(a3);
            }
            jv(46);
            jv(47);
            jv(49);
        }
    }

    public void cj(JSONObject jSONObject) {
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
            for (i iVar : this.dtU) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aJS());
                    iVar.jw(l.longValue() > 0 ? 1 : 0);
                    iVar.bW(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.jx(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.jx(g.f.aiapp_menu_text_favorite);
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
        iVar.jx(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i ju(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.dtT.size()) {
                return null;
            }
            i iVar = this.dtT.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.bW(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void jv(int i) {
        i ju = ju(i);
        if (ju != null && ju.isVisible()) {
            this.dtU.add(ju);
        }
    }
}
