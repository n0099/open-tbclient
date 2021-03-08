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
/* loaded from: classes4.dex */
public class g implements View.OnKeyListener, e, com.baidu.swan.menu.viewpager.b {
    private i eug;
    private List<h> euh;
    private e euk;
    private com.baidu.swan.menu.viewpager.b eul;
    private View.OnKeyListener eum;
    private a eun;
    private b euo;
    private Context mContext;
    private int mStyle;
    private boolean euf = false;
    private int mScreenOrientation = 0;
    private List<h> eui = new ArrayList();
    private List<List<h>> euj = new ArrayList();
    private int eup = -1;

    /* loaded from: classes4.dex */
    public interface a {
        void a(g gVar, boolean z);
    }

    public g(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.euh = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.euo = bVar;
            this.euh = j.lK(this.mStyle);
            this.euo.g(this.mStyle, this.euh);
            this.euo.h(this.mStyle, this.euh);
            this.eug = new i(this.mContext, view, aVar);
            this.eug.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.eun != null) {
                        g.this.eun.a(g.this, false);
                    }
                }
            });
        }
    }

    private void bbI() {
        this.euj.clear();
        int size = this.eui.size();
        if (size > 0 && size <= 5) {
            this.euj.add(this.eui);
        } else if (size > 5 && size <= 10) {
            int i = this.euf ? 5 : this.eup;
            this.euj.add(this.eui.subList(0, i));
            this.euj.add(this.eui.subList(i, size));
        } else if (size > 10) {
            int ceil = this.euf ? (int) Math.ceil(size / 2.0f) : this.eup;
            this.euj.add(this.eui.subList(0, ceil));
            this.euj.add(this.eui.subList(ceil, size));
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
        if (this.euo != null) {
            this.euo.f(this.mStyle, this.euh);
        }
        o(z, i);
        bbI();
        this.eug.b(this.euj, view, z2, this.mScreenOrientation);
        if (this.eun != null) {
            this.eun.a(this, true);
        }
    }

    public void a(e eVar) {
        this.euk = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, h hVar) {
        if (hVar.isEnable()) {
            if (d(hVar)) {
                dismiss(true);
            }
            if (this.euk == null) {
                return false;
            }
            return this.euk.a(view, hVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(h hVar) {
        if (d(hVar) && !this.euf) {
            dismiss(true);
        }
        if (this.eul == null) {
            return false;
        }
        return this.eul.c(hVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.eum != null) {
            return this.eum.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void iA(boolean z) {
        a(lG(5), z);
        bbI();
        this.eug.aCw();
        bbE();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.eug.gg(z);
        if (this.eun != null) {
            this.eun.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.eug != null && this.eug.isShowing();
    }

    public void bbE() {
        if (this.eug != null) {
            this.eug.bbE();
        }
    }

    public void ax(int i, int i2) {
        h lL;
        int i3 = 0;
        boolean z = false;
        for (h hVar : this.euh) {
            z = hVar.getItemId() == i ? true : z;
        }
        if (!z && (lL = j.lL(i)) != null) {
            int size = this.euh.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.euh.add(i3, lL);
        }
    }

    public void lE(int i) {
        if (this.euh != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.euh.size(); i3++) {
                if (this.euh.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.euh.remove(i2);
            }
        }
    }

    public void lF(int i) {
        this.eug.lF(i);
    }

    private boolean d(h hVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.mScreenOrientation = i;
    }

    private void o(boolean z, int i) {
        if (this.euh != null) {
            this.eui.clear();
            lH(41);
            h a2 = a(lG(38), i);
            if (a2 != null && a2.isVisible()) {
                this.eui.add(a2);
            }
            lH(48);
            lH(45);
            lH(4);
            lH(101);
            h lG = lG(35);
            if (lG != null && lG.isVisible()) {
                this.eui.add(lG);
            }
            lH(39);
            lH(42);
            lH(9);
            if (!this.euf) {
                this.eup = this.eui.size() - 1;
            }
            lH(37);
            lH(100);
            lH(43);
            h a3 = a(lG(5), z);
            if (a3 != null && a3.isVisible()) {
                this.eui.add(a3);
            }
            lH(46);
            lH(47);
            lH(49);
            lH(50);
        }
    }

    public void cL(JSONObject jSONObject) {
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
            for (h hVar : this.eui) {
                if (hVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + hVar.bbK());
                    hVar.lI(l.longValue() > 0 ? 1 : 0);
                    hVar.dq(l.longValue());
                }
            }
        }
    }

    private h a(h hVar, int i) {
        if (hVar == null) {
            return null;
        }
        if (i == 2) {
            hVar.lJ(f.C0544f.aiapp_menu_text_cancel_favorite);
            hVar.setIconResId(f.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            hVar.lJ(f.C0544f.aiapp_menu_text_favorite);
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
        hVar.lJ(z ? f.C0544f.aiapp_menu_text_day_mode : f.C0544f.aiapp_menu_text_night_mode);
        hVar.setIconResId(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
        return hVar;
    }

    public h lG(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.euh.size()) {
                return null;
            }
            h hVar = this.euh.get(i3);
            if (hVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                hVar.dq(0L);
                hVar.a(this);
                return hVar;
            }
        }
    }

    private void lH(int i) {
        h lG = lG(i);
        if (lG != null && lG.isVisible()) {
            this.eui.add(lG);
        }
    }
}
