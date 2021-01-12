package com.baidu.swan.menu;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g implements View.OnKeyListener, e, com.baidu.swan.menu.viewpager.b {
    private e eqB;
    private com.baidu.swan.menu.viewpager.b eqC;
    private View.OnKeyListener eqD;
    private a eqE;
    private b eqF;
    private i eqx;
    private List<h> eqy;
    private Context mContext;
    private int mStyle;
    private boolean eqw = false;
    private int mScreenOrientation = 0;
    private List<h> eqz = new ArrayList();
    private List<List<h>> eqA = new ArrayList();
    private int eqG = -1;

    /* loaded from: classes5.dex */
    public interface a {
        void a(g gVar, boolean z);
    }

    public g(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.eqy = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.eqF = bVar;
            this.eqy = j.lG(this.mStyle);
            this.eqF.g(this.mStyle, this.eqy);
            this.eqF.h(this.mStyle, this.eqy);
            this.eqx = new i(this.mContext, view, aVar);
            this.eqx.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.eqE != null) {
                        g.this.eqE.a(g.this, false);
                    }
                }
            });
        }
    }

    private void bbt() {
        this.eqA.clear();
        int size = this.eqz.size();
        if (size > 0 && size <= 5) {
            this.eqA.add(this.eqz);
        } else if (size > 5 && size <= 10) {
            int i = this.eqw ? 5 : this.eqG;
            this.eqA.add(this.eqz.subList(0, i));
            this.eqA.add(this.eqz.subList(i, size));
        } else if (size > 10) {
            int ceil = this.eqw ? (int) Math.ceil(size / 2.0f) : this.eqG;
            this.eqA.add(this.eqz.subList(0, ceil));
            this.eqA.add(this.eqz.subList(ceil, size));
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
        if (this.eqF != null) {
            this.eqF.f(this.mStyle, this.eqy);
        }
        o(z, i);
        bbt();
        this.eqx.b(this.eqA, view, z2, this.mScreenOrientation);
        if (this.eqE != null) {
            this.eqE.a(this, true);
        }
    }

    public void a(e eVar) {
        this.eqB = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, h hVar) {
        if (hVar.isEnable()) {
            if (d(hVar)) {
                dismiss(true);
            }
            if (this.eqB == null) {
                return false;
            }
            return this.eqB.a(view, hVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(h hVar) {
        if (d(hVar) && !this.eqw) {
            dismiss(true);
        }
        if (this.eqC == null) {
            return false;
        }
        return this.eqC.c(hVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.eqD != null) {
            return this.eqD.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void iy(boolean z) {
        a(lC(5), z);
        bbt();
        this.eqx.aBW();
        bbp();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.eqx.ge(z);
        if (this.eqE != null) {
            this.eqE.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.eqx != null && this.eqx.isShowing();
    }

    public void bbp() {
        if (this.eqx != null) {
            this.eqx.bbp();
        }
    }

    public void aA(int i, int i2) {
        h lH;
        int i3 = 0;
        boolean z = false;
        for (h hVar : this.eqy) {
            z = hVar.getItemId() == i ? true : z;
        }
        if (!z && (lH = j.lH(i)) != null) {
            int size = this.eqy.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.eqy.add(i3, lH);
        }
    }

    public void lA(int i) {
        if (this.eqy != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.eqy.size(); i3++) {
                if (this.eqy.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.eqy.remove(i2);
            }
        }
    }

    public void lB(int i) {
        this.eqx.lB(i);
    }

    private boolean d(h hVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.mScreenOrientation = i;
    }

    private void o(boolean z, int i) {
        if (this.eqy != null) {
            this.eqz.clear();
            lD(41);
            h a2 = a(lC(38), i);
            if (a2 != null && a2.isVisible()) {
                this.eqz.add(a2);
            }
            lD(48);
            lD(45);
            lD(4);
            lD(101);
            h lC = lC(35);
            if (lC != null && lC.isVisible()) {
                this.eqz.add(lC);
            }
            lD(39);
            lD(42);
            lD(9);
            if (!this.eqw) {
                this.eqG = this.eqz.size() - 1;
            }
            lD(37);
            lD(100);
            lD(43);
            h a3 = a(lC(5), z);
            if (a3 != null && a3.isVisible()) {
                this.eqz.add(a3);
            }
            lD(46);
            lD(47);
            lD(49);
            lD(50);
        }
    }

    public void cM(JSONObject jSONObject) {
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
            for (h hVar : this.eqz) {
                if (hVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + hVar.bbv());
                    hVar.lE(l.longValue() > 0 ? 1 : 0);
                    hVar.dk(l.longValue());
                }
            }
        }
    }

    private h a(h hVar, int i) {
        if (hVar == null) {
            return null;
        }
        if (i == 2) {
            hVar.lF(f.C0541f.aiapp_menu_text_cancel_favorite);
            hVar.setIconResId(f.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            hVar.lF(f.C0541f.aiapp_menu_text_favorite);
            hVar.setIconResId(f.c.aiapp_menu_item_add_fav_selector);
        } else if (i == 0) {
            hVar = null;
        }
        return hVar;
    }

    private h a(h hVar, boolean z) {
        if (hVar == null) {
            return null;
        }
        hVar.lF(z ? f.C0541f.aiapp_menu_text_day_mode : f.C0541f.aiapp_menu_text_night_mode);
        hVar.setIconResId(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
        return hVar;
    }

    public h lC(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.eqy.size()) {
                return null;
            }
            h hVar = this.eqy.get(i3);
            if (hVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                hVar.dk(0L);
                hVar.a(this);
                return hVar;
            }
        }
    }

    private void lD(int i) {
        h lC = lC(i);
        if (lC != null && lC.isVisible()) {
            this.eqz.add(lC);
        }
    }
}
