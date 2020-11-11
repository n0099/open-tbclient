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
    private j egk;
    private List<i> egm;
    private f egp;
    private com.baidu.swan.menu.viewpager.b egq;
    private View.OnKeyListener egr;
    private a egs;
    private b egt;
    private Context mContext;
    private int mStyle;
    private boolean egi = false;
    private int egj = 0;
    private List<i> egn = new ArrayList();
    private List<List<i>> ego = new ArrayList();
    private int egu = -1;

    /* loaded from: classes14.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.egm = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.egt = bVar;
            this.egm = k.mJ(this.mStyle);
            this.egt.g(this.mStyle, this.egm);
            this.egt.h(this.mStyle, this.egm);
            this.egk = new j(this.mContext, view, aVar);
            this.egk.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.egs != null) {
                        h.this.egs.a(h.this, false);
                    }
                }
            });
        }
    }

    private void bas() {
        this.ego.clear();
        int size = this.egn.size();
        if (size > 0 && size <= 5) {
            this.ego.add(this.egn);
        } else if (size > 5 && size <= 10) {
            int i = this.egi ? 5 : this.egu;
            this.ego.add(this.egn.subList(0, i));
            this.ego.add(this.egn.subList(i, size));
        } else if (size > 10) {
            int ceil = this.egi ? (int) Math.ceil(size / 2.0f) : this.egu;
            this.ego.add(this.egn.subList(0, ceil));
            this.ego.add(this.egn.subList(ceil, size));
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
        if (this.egt != null) {
            this.egt.f(this.mStyle, this.egm);
        }
        p(z, i);
        bas();
        this.egk.b(this.ego, view, z2, this.egj);
        if (this.egs != null) {
            this.egs.a(this, true);
        }
    }

    public void a(f fVar) {
        this.egp = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (d(iVar)) {
                dismiss(true);
            }
            if (this.egp == null) {
                return false;
            }
            return this.egp.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (d(iVar) && !this.egi) {
            dismiss(true);
        }
        if (this.egq == null) {
            return false;
        }
        return this.egq.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.egr != null) {
            return this.egr.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void hQ(boolean z) {
        a(mF(5), z);
        bas();
        this.egk.aBV();
        bar();
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.egk.fH(z);
        if (this.egs != null) {
            this.egs.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.egk != null && this.egk.isShowing();
    }

    public void bar() {
        if (this.egk != null) {
            this.egk.bar();
        }
    }

    public void aB(int i, int i2) {
        i mK;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.egm) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (mK = k.mK(i)) != null) {
            int size = this.egm.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.egm.add(i3, mK);
        }
    }

    public void mD(int i) {
        if (this.egm != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.egm.size(); i3++) {
                if (this.egm.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.egm.remove(i2);
            }
        }
    }

    public void mE(int i) {
        this.egk.mE(i);
    }

    private boolean d(i iVar) {
        return true;
    }

    public void setScreenOrientation(int i) {
        this.egj = i;
    }

    private void p(boolean z, int i) {
        if (this.egm != null) {
            this.egn.clear();
            mG(41);
            i a2 = a(mF(38), i);
            if (a2 != null && a2.isVisible()) {
                this.egn.add(a2);
            }
            mG(48);
            mG(45);
            mG(4);
            mG(101);
            i mF = mF(35);
            if (mF != null && mF.isVisible()) {
                this.egn.add(mF);
            }
            mG(39);
            mG(42);
            mG(9);
            if (!this.egi) {
                this.egu = this.egn.size() - 1;
            }
            mG(37);
            mG(100);
            mG(43);
            i a3 = a(mF(5), z);
            if (a3 != null && a3.isVisible()) {
                this.egn.add(a3);
            }
            mG(46);
            mG(47);
            mG(49);
            mG(50);
        }
    }

    public void cI(JSONObject jSONObject) {
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
            for (i iVar : this.egn) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.bau());
                    iVar.mH(l.longValue() > 0 ? 1 : 0);
                    iVar.cK(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.mI(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.mI(g.f.aiapp_menu_text_favorite);
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
        iVar.mI(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i mF(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.egm.size()) {
                return null;
            }
            i iVar = this.egm.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.cK(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void mG(int i) {
        i mF = mF(i);
        if (mF != null && mF.isVisible()) {
            this.egn.add(mF);
        }
    }
}
