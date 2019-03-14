package com.baidu.swan.menu;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements View.OnKeyListener, f {
    private static final boolean DEBUG = com.baidu.swan.menu.a.DEBUG;
    private p bkA;
    private List<k> bkB;
    private f bkC;
    private View.OnKeyListener bkD;
    private f bkE;
    private n bkF;
    private String bkG;
    private String bkH;
    private a bkI;
    private SwanAppMenuMode bkJ;
    private d bkK;
    private Context mContext;
    private int mStyle;

    /* loaded from: classes2.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, @Nullable c cVar) {
        this(context, view, i, "searchbox", cVar);
    }

    public h(Context context, View view, int i, String str, @Nullable c cVar) {
        this.bkB = new ArrayList();
        this.bkH = "searchbox";
        this.bkJ = null;
        if (i < 0) {
            if (DEBUG) {
                Log.e("SwanAppMenu", "menu style < 0");
                return;
            }
            return;
        }
        this.mContext = context;
        this.mStyle = i;
        this.bkH = str;
        this.bkB = o.eY(this.mStyle);
        if (i.bkM != null) {
            this.bkE = i.bkM.Rj();
            this.bkF = i.bkM.Rk();
        }
        this.bkA = new p(this.mContext, view, this.mStyle, cVar);
        this.bkA.c(this);
        this.bkA.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                if (h.this.bkI != null) {
                    h.this.bkI.a(h.this, false);
                }
            }
        });
    }

    public void setStatisticSource(String str) {
        this.bkG = str;
        this.bkA.setStatisticSource(this.bkG);
    }

    public void setMenuSource(String str) {
        this.bkH = str;
        this.bkA.setMenuSource(str);
    }

    public void a(d dVar) {
        this.bkK = dVar;
    }

    public void a(f fVar) {
        this.bkC = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, k kVar) {
        if (kVar.isEnable()) {
            if (c(kVar)) {
                cM(true);
            }
            boolean z = false;
            if (this.bkC != null) {
                z = this.bkC.a(view, kVar);
            }
            if (!z && this.bkE != null) {
                return this.bkE.a(view, kVar);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.bkD != null) {
            return this.bkD.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void i(boolean z, boolean z2) {
        a(z, 0, z2);
    }

    public void a(boolean z, int i, boolean z2) {
        if (isShowing()) {
            cM(true);
            return;
        }
        if (this.bkK != null) {
            this.bkK.d(this.mStyle, this.bkB);
        }
        Rg();
        c(z, i, z2);
        this.bkA.F(this.bkB);
        this.bkA.showView();
        if (this.bkI != null) {
            this.bkI.a(this, true);
        }
    }

    public void cM(boolean z) {
        this.bkA.cO(z);
        if (this.bkI != null) {
            this.bkI.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.bkA != null && this.bkA.isShowing();
    }

    public void L(int i, int i2) {
        boolean z;
        int i3 = 0;
        boolean z2 = false;
        for (k kVar : this.bkB) {
            if (kVar.getItemId() == i) {
                z = true;
                if (DEBUG) {
                    Log.d("SwanAppMenu", "Already Exist Menu: id=" + i);
                }
            } else {
                z = z2;
            }
            z2 = z;
        }
        if (!z2) {
            k eZ = o.eZ(i);
            if (eZ == null) {
                if (DEBUG) {
                    Log.d("SwanAppMenu", "No such Menu: id=" + i);
                    return;
                }
                return;
            }
            int size = this.bkB.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.bkB.add(i3, eZ);
            if (DEBUG) {
                Log.d("SwanAppMenu", "Add Menu: id=" + i + ", insert pos=" + i3);
            }
        }
    }

    public void eV(int i) {
        if (this.bkB != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.bkB.size(); i3++) {
                if (this.bkB.get(i3).getItemId() == i) {
                    if (DEBUG) {
                        Log.d("SwanAppMenu", "Hide Menu: id=" + i);
                    }
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.bkB.remove(i2);
            }
        }
    }

    public void eW(int i) {
        this.bkA.eW(i);
    }

    private boolean c(k kVar) {
        return true;
    }

    private void b(boolean z, int i, boolean z2) {
        this.bkJ = SwanAppMenuMode.NORMAL;
        this.bkA.setMode(this.bkJ);
        Iterator<k> it = this.bkB.iterator();
        while (it.hasNext()) {
            k next = it.next();
            int itemId = next.getItemId();
            if (itemId == 38 && i == 0) {
                it.remove();
            } else {
                if (z2 && itemId == 34) {
                    it.remove();
                }
                switch (itemId) {
                    case 5:
                        next.setTitle(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
                        next.setIcon(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
                        break;
                    case 38:
                        if (i == 2) {
                            next.setTitle(g.f.aiapp_menu_text_cancel_favorite);
                            next.setIcon(g.c.aiapp_menu_item_cancel_fav_selector);
                            break;
                        } else if (i == 1) {
                            next.setTitle(g.f.aiapp_menu_text_favorite);
                            next.setIcon(g.c.aiapp_menu_item_add_fav_selector);
                            break;
                        }
                        break;
                }
                next.a(this);
            }
        }
    }

    private void c(boolean z, int i, boolean z2) {
        if (this.bkB != null) {
            b(z, i, z2);
        }
    }

    private void Rg() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.bkG);
        hashMap.put("source", this.bkH);
        hashMap.put("type", "menu_clk");
        if (this.bkF != null) {
            this.bkF.c("260", hashMap);
        }
    }
}
