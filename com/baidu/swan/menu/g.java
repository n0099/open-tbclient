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
    private i evl;
    private List<h> evm;
    private e evp;
    private com.baidu.swan.menu.viewpager.b evq;
    private View.OnKeyListener evr;
    private a evs;
    private b evt;
    private Context mContext;
    private int mStyle;
    private boolean evk = false;
    private int mScreenOrientation = 0;
    private List<h> evn = new ArrayList();
    private List<List<h>> evo = new ArrayList();
    private int evu = -1;

    /* loaded from: classes5.dex */
    public interface a {
        void a(g gVar, boolean z);
    }

    public g(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.evm = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.evt = bVar;
            this.evm = j.nm(this.mStyle);
            this.evt.g(this.mStyle, this.evm);
            this.evt.h(this.mStyle, this.evm);
            this.evl = new i(this.mContext, view, aVar);
            this.evl.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.evs != null) {
                        g.this.evs.a(g.this, false);
                    }
                }
            });
        }
    }

    private void bfm() {
        this.evo.clear();
        int size = this.evn.size();
        if (size > 0 && size <= 5) {
            this.evo.add(this.evn);
        } else if (size > 5 && size <= 10) {
            int i = this.evk ? 5 : this.evu;
            this.evo.add(this.evn.subList(0, i));
            this.evo.add(this.evn.subList(i, size));
        } else if (size > 10) {
            int ceil = this.evk ? (int) Math.ceil(size / 2.0f) : this.evu;
            this.evo.add(this.evn.subList(0, ceil));
            this.evo.add(this.evn.subList(ceil, size));
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
        if (this.evt != null) {
            this.evt.f(this.mStyle, this.evm);
        }
        o(z, i);
        bfm();
        this.evl.b(this.evo, view, z2, this.mScreenOrientation);
        if (this.evs != null) {
            this.evs.a(this, true);
        }
    }

    public void a(e eVar) {
        this.evp = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, h hVar) {
        if (hVar.isEnable()) {
            if (d(hVar)) {
                dismiss(true);
            }
            if (this.evp == null) {
                return false;
            }
            return this.evp.a(view, hVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(h hVar) {
        if (d(hVar) && !this.evk) {
            dismiss(true);
        }
        if (this.evq == null) {
            return false;
        }
        return this.evq.c(hVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.evr != null) {
            return this.evr.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void iC(boolean z) {
        a(ni(5), z);
        bfm();
        this.evl.aFP();
        bfi();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.evl.gi(z);
        if (this.evs != null) {
            this.evs.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.evl != null && this.evl.isShowing();
    }

    public void bfi() {
        if (this.evl != null) {
            this.evl.bfi();
        }
    }

    public void aA(int i, int i2) {
        h nn;
        int i3 = 0;
        boolean z = false;
        for (h hVar : this.evm) {
            z = hVar.getItemId() == i ? true : z;
        }
        if (!z && (nn = j.nn(i)) != null) {
            int size = this.evm.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.evm.add(i3, nn);
        }
    }

    public void ng(int i) {
        if (this.evm != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.evm.size(); i3++) {
                if (this.evm.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.evm.remove(i2);
            }
        }
    }

    public void nh(int i) {
        this.evl.nh(i);
    }

    private boolean d(h hVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.mScreenOrientation = i;
    }

    private void o(boolean z, int i) {
        if (this.evm != null) {
            this.evn.clear();
            nj(41);
            h a2 = a(ni(38), i);
            if (a2 != null && a2.isVisible()) {
                this.evn.add(a2);
            }
            nj(48);
            nj(45);
            nj(4);
            nj(101);
            h ni = ni(35);
            if (ni != null && ni.isVisible()) {
                this.evn.add(ni);
            }
            nj(39);
            nj(42);
            nj(9);
            if (!this.evk) {
                this.evu = this.evn.size() - 1;
            }
            nj(37);
            nj(100);
            nj(43);
            h a3 = a(ni(5), z);
            if (a3 != null && a3.isVisible()) {
                this.evn.add(a3);
            }
            nj(46);
            nj(47);
            nj(49);
            nj(50);
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
            for (h hVar : this.evn) {
                if (hVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + hVar.bfo());
                    hVar.nk(l.longValue() > 0 ? 1 : 0);
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
            hVar.nl(f.C0558f.aiapp_menu_text_cancel_favorite);
            hVar.setIconResId(f.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            hVar.nl(f.C0558f.aiapp_menu_text_favorite);
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
        hVar.nl(z ? f.C0558f.aiapp_menu_text_day_mode : f.C0558f.aiapp_menu_text_night_mode);
        hVar.setIconResId(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
        return hVar;
    }

    public h ni(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.evm.size()) {
                return null;
            }
            h hVar = this.evm.get(i3);
            if (hVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                hVar.dk(0L);
                hVar.a(this);
                return hVar;
            }
        }
    }

    private void nj(int i) {
        h ni = ni(i);
        if (ni != null && ni.isVisible()) {
            this.evn.add(ni);
        }
    }
}
