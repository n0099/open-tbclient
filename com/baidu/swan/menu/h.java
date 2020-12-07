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
/* loaded from: classes14.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j elE;
    private List<i> elF;
    private f elI;
    private com.baidu.swan.menu.viewpager.b elJ;
    private View.OnKeyListener elK;
    private a elL;
    private b elM;
    private Context mContext;
    private int mStyle;
    private boolean elC = false;
    private int elD = 0;
    private List<i> elG = new ArrayList();
    private List<List<i>> elH = new ArrayList();
    private int elN = -1;

    /* loaded from: classes14.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.elF = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.elM = bVar;
            this.elF = k.nd(this.mStyle);
            this.elM.g(this.mStyle, this.elF);
            this.elM.h(this.mStyle, this.elF);
            this.elE = new j(this.mContext, view, aVar);
            this.elE.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.elL != null) {
                        h.this.elL.a(h.this, false);
                    }
                }
            });
        }
    }

    private void bcQ() {
        this.elH.clear();
        int size = this.elG.size();
        if (size > 0 && size <= 5) {
            this.elH.add(this.elG);
        } else if (size > 5 && size <= 10) {
            int i = this.elC ? 5 : this.elN;
            this.elH.add(this.elG.subList(0, i));
            this.elH.add(this.elG.subList(i, size));
        } else if (size > 10) {
            int ceil = this.elC ? (int) Math.ceil(size / 2.0f) : this.elN;
            this.elH.add(this.elG.subList(0, ceil));
            this.elH.add(this.elG.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        o(z, 0);
    }

    public void o(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            dismiss(true);
            return;
        }
        if (this.elM != null) {
            this.elM.f(this.mStyle, this.elF);
        }
        p(z, i);
        bcQ();
        this.elE.b(this.elH, view, z2, this.elD);
        if (this.elL != null) {
            this.elL.a(this, true);
        }
    }

    public void a(f fVar) {
        this.elI = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.elI == null) {
                return false;
            }
            return this.elI.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.elC) {
            dismiss(true);
        }
        if (this.elJ == null) {
            return false;
        }
        return this.elJ.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.elK != null) {
            return this.elK.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void ii(boolean z) {
        a(mZ(5), z);
        bcQ();
        this.elE.aEw();
        bcP();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.elE.fZ(z);
        if (this.elL != null) {
            this.elL.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.elE != null && this.elE.isShowing();
    }

    public void bcP() {
        if (this.elE != null) {
            this.elE.bcP();
        }
    }

    public void aD(int i, int i2) {
        i ne;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.elF) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (ne = k.ne(i)) != null) {
            int size = this.elF.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.elF.add(i3, ne);
        }
    }

    public void mX(int i) {
        if (this.elF != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.elF.size(); i3++) {
                if (this.elF.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.elF.remove(i2);
            }
        }
    }

    public void mY(int i) {
        this.elE.mY(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.elD = i;
    }

    private void p(boolean z, int i) {
        if (this.elF != null) {
            this.elG.clear();
            na(41);
            i a2 = a(mZ(38), i);
            if (a2 != null && a2.isVisible()) {
                this.elG.add(a2);
            }
            na(48);
            na(45);
            na(4);
            na(101);
            i mZ = mZ(35);
            if (mZ != null && mZ.isVisible()) {
                this.elG.add(mZ);
            }
            na(39);
            na(42);
            na(9);
            if (!this.elC) {
                this.elN = this.elG.size() - 1;
            }
            na(37);
            na(100);
            na(43);
            i a3 = a(mZ(5), z);
            if (a3 != null && a3.isVisible()) {
                this.elG.add(a3);
            }
            na(46);
            na(47);
            na(49);
            na(50);
        }
    }

    public void cE(JSONObject jSONObject) {
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
            for (i iVar : this.elG) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.bcS());
                    iVar.nb(l.longValue() > 0 ? 1 : 0);
                    iVar.dj(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.nc(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.nc(g.f.aiapp_menu_text_favorite);
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
        iVar.nc(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i mZ(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.elF.size()) {
                return null;
            }
            i iVar = this.elF.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.dj(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void na(int i) {
        i mZ = mZ(i);
        if (mZ != null && mZ.isVisible()) {
            this.elG.add(mZ);
        }
    }
}
