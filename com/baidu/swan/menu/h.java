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
    private j cuK;
    private List<i> cuL;
    private f cuO;
    private com.baidu.swan.menu.viewpager.b cuP;
    private View.OnKeyListener cuQ;
    private a cuR;
    private b cuS;
    private Context mContext;
    private int mStyle;
    private boolean cuI = false;
    private int cuJ = 0;
    private List<i> cuM = new ArrayList();
    private List<List<i>> cuN = new ArrayList();
    private int cuT = -1;

    /* loaded from: classes9.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.cuL = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.cuS = bVar;
            this.cuL = k.m22if(this.mStyle);
            this.cuS.g(this.mStyle, this.cuL);
            this.cuS.h(this.mStyle, this.cuL);
            this.cuK = new j(this.mContext, view, aVar);
            this.cuK.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.cuR != null) {
                        h.this.cuR.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aqf() {
        this.cuN.clear();
        int size = this.cuM.size();
        if (size > 0 && size <= 5) {
            this.cuN.add(this.cuM);
        } else if (size > 5 && size <= 10) {
            int i = this.cuI ? 5 : this.cuT;
            this.cuN.add(this.cuM.subList(0, i));
            this.cuN.add(this.cuM.subList(i, size));
        } else if (size > 10) {
            int ceil = this.cuI ? (int) Math.ceil(size / 2.0f) : this.cuT;
            this.cuN.add(this.cuM.subList(0, ceil));
            this.cuN.add(this.cuM.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        g(z, 0);
    }

    public void g(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            eI(true);
            return;
        }
        if (this.cuS != null) {
            this.cuS.f(this.mStyle, this.cuL);
        }
        h(z, i);
        aqf();
        this.cuK.b(this.cuN, view, z2, this.cuJ);
        if (this.cuR != null) {
            this.cuR.a(this, true);
        }
    }

    public void a(f fVar) {
        this.cuO = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.cuP = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                eI(true);
            }
            if (this.cuO == null) {
                return false;
            }
            return this.cuO.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (e(iVar) && !this.cuI) {
            eI(true);
        }
        if (this.cuP == null) {
            return false;
        }
        return this.cuP.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.cuQ != null) {
            return this.cuQ.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void eH(boolean z) {
        a(ib(5), z);
        aqf();
        this.cuK.aql();
        aqe();
    }

    public void eI(boolean z) {
        this.cuK.eK(z);
        if (this.cuR != null) {
            this.cuR.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.cuK != null && this.cuK.isShowing();
    }

    public void aqe() {
        if (this.cuK != null) {
            this.cuK.aqe();
        }
    }

    public void al(int i, int i2) {
        i ig;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.cuL) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (ig = k.ig(i)) != null) {
            int size = this.cuL.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.cuL.add(i3, ig);
        }
    }

    public void hY(int i) {
        if (this.cuL != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.cuL.size(); i3++) {
                if (this.cuL.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.cuL.remove(i2);
            }
        }
    }

    public void hZ(int i) {
        this.cuK.hZ(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void eJ(boolean z) {
        this.cuI = z;
    }

    public void ia(int i) {
        this.cuJ = i;
    }

    private void h(boolean z, int i) {
        if (this.cuL != null) {
            this.cuM.clear();
            ic(41);
            i a2 = a(ib(38), i);
            if (a2 != null && a2.isVisible()) {
                this.cuM.add(a2);
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
                this.cuM.add(ib);
                if (!this.cuI) {
                    this.cuT = this.cuM.size() - 1;
                }
            }
            ic(37);
            ic(100);
            i a3 = a(ib(5), z);
            if (a3 != null && a3.isVisible()) {
                this.cuM.add(a3);
            }
            ic(40);
            ic(46);
            ic(47);
            i ib2 = ib(36);
            if (ib2 != null && ib2.isVisible()) {
                ib2.b(this);
                this.cuM.add(ib2);
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
            for (i iVar : this.cuM) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aqh());
                    iVar.id(l.longValue() > 0 ? 1 : 0);
                    iVar.aY(l.longValue());
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
            if (i3 >= this.cuL.size()) {
                return null;
            }
            i iVar = this.cuL.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.aY(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void ic(int i) {
        i ib = ib(i);
        if (ib != null && ib.isVisible()) {
            this.cuM.add(ib);
        }
    }
}
