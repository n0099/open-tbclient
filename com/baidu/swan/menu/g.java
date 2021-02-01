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
    private i esE;
    private List<h> esF;
    private e esI;
    private com.baidu.swan.menu.viewpager.b esJ;
    private View.OnKeyListener esK;
    private a esL;
    private b esM;
    private Context mContext;
    private int mStyle;
    private boolean esD = false;
    private int mScreenOrientation = 0;
    private List<h> esG = new ArrayList();
    private List<List<h>> esH = new ArrayList();
    private int esN = -1;

    /* loaded from: classes5.dex */
    public interface a {
        void a(g gVar, boolean z);
    }

    public g(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.esF = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.esM = bVar;
            this.esF = j.lJ(this.mStyle);
            this.esM.g(this.mStyle, this.esF);
            this.esM.h(this.mStyle, this.esF);
            this.esE = new i(this.mContext, view, aVar);
            this.esE.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.esL != null) {
                        g.this.esL.a(g.this, false);
                    }
                }
            });
        }
    }

    private void bbG() {
        this.esH.clear();
        int size = this.esG.size();
        if (size > 0 && size <= 5) {
            this.esH.add(this.esG);
        } else if (size > 5 && size <= 10) {
            int i = this.esD ? 5 : this.esN;
            this.esH.add(this.esG.subList(0, i));
            this.esH.add(this.esG.subList(i, size));
        } else if (size > 10) {
            int ceil = this.esD ? (int) Math.ceil(size / 2.0f) : this.esN;
            this.esH.add(this.esG.subList(0, ceil));
            this.esH.add(this.esG.subList(ceil, size));
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
        if (this.esM != null) {
            this.esM.f(this.mStyle, this.esF);
        }
        o(z, i);
        bbG();
        this.esE.b(this.esH, view, z2, this.mScreenOrientation);
        if (this.esL != null) {
            this.esL.a(this, true);
        }
    }

    public void a(e eVar) {
        this.esI = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, h hVar) {
        if (hVar.isEnable()) {
            if (d(hVar)) {
                dismiss(true);
            }
            if (this.esI == null) {
                return false;
            }
            return this.esI.a(view, hVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(h hVar) {
        if (d(hVar) && !this.esD) {
            dismiss(true);
        }
        if (this.esJ == null) {
            return false;
        }
        return this.esJ.c(hVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.esK != null) {
            return this.esK.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void iA(boolean z) {
        a(lF(5), z);
        bbG();
        this.esE.aCt();
        bbC();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.esE.gg(z);
        if (this.esL != null) {
            this.esL.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.esE != null && this.esE.isShowing();
    }

    public void bbC() {
        if (this.esE != null) {
            this.esE.bbC();
        }
    }

    public void ax(int i, int i2) {
        h lK;
        int i3 = 0;
        boolean z = false;
        for (h hVar : this.esF) {
            z = hVar.getItemId() == i ? true : z;
        }
        if (!z && (lK = j.lK(i)) != null) {
            int size = this.esF.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.esF.add(i3, lK);
        }
    }

    public void lD(int i) {
        if (this.esF != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.esF.size(); i3++) {
                if (this.esF.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.esF.remove(i2);
            }
        }
    }

    public void lE(int i) {
        this.esE.lE(i);
    }

    private boolean d(h hVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.mScreenOrientation = i;
    }

    private void o(boolean z, int i) {
        if (this.esF != null) {
            this.esG.clear();
            lG(41);
            h a2 = a(lF(38), i);
            if (a2 != null && a2.isVisible()) {
                this.esG.add(a2);
            }
            lG(48);
            lG(45);
            lG(4);
            lG(101);
            h lF = lF(35);
            if (lF != null && lF.isVisible()) {
                this.esG.add(lF);
            }
            lG(39);
            lG(42);
            lG(9);
            if (!this.esD) {
                this.esN = this.esG.size() - 1;
            }
            lG(37);
            lG(100);
            lG(43);
            h a3 = a(lF(5), z);
            if (a3 != null && a3.isVisible()) {
                this.esG.add(a3);
            }
            lG(46);
            lG(47);
            lG(49);
            lG(50);
        }
    }

    public void cJ(JSONObject jSONObject) {
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
            for (h hVar : this.esG) {
                if (hVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + hVar.bbI());
                    hVar.lH(l.longValue() > 0 ? 1 : 0);
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
            hVar.lI(f.C0538f.aiapp_menu_text_cancel_favorite);
            hVar.setIconResId(f.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            hVar.lI(f.C0538f.aiapp_menu_text_favorite);
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
        hVar.lI(z ? f.C0538f.aiapp_menu_text_day_mode : f.C0538f.aiapp_menu_text_night_mode);
        hVar.setIconResId(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
        return hVar;
    }

    public h lF(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.esF.size()) {
                return null;
            }
            h hVar = this.esF.get(i3);
            if (hVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                hVar.dq(0L);
                hVar.a(this);
                return hVar;
            }
        }
    }

    private void lG(int i) {
        h lF = lF(i);
        if (lF != null && lF.isVisible()) {
            this.esG.add(lF);
        }
    }
}
