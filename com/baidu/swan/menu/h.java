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
    private p bkE;
    private List<k> bkF;
    private f bkG;
    private View.OnKeyListener bkH;
    private f bkI;
    private n bkJ;
    private String bkK;
    private String bkL;
    private a bkM;
    private SwanAppMenuMode bkN;
    private d bkO;
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
        this.bkF = new ArrayList();
        this.bkL = "searchbox";
        this.bkN = null;
        if (i < 0) {
            if (DEBUG) {
                Log.e("SwanAppMenu", "menu style < 0");
                return;
            }
            return;
        }
        this.mContext = context;
        this.mStyle = i;
        this.bkL = str;
        this.bkF = o.eX(this.mStyle);
        if (i.bkQ != null) {
            this.bkI = i.bkQ.Rh();
            this.bkJ = i.bkQ.Ri();
        }
        this.bkE = new p(this.mContext, view, this.mStyle, cVar);
        this.bkE.c(this);
        this.bkE.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                if (h.this.bkM != null) {
                    h.this.bkM.a(h.this, false);
                }
            }
        });
    }

    public void setStatisticSource(String str) {
        this.bkK = str;
        this.bkE.setStatisticSource(this.bkK);
    }

    public void setMenuSource(String str) {
        this.bkL = str;
        this.bkE.setMenuSource(str);
    }

    public void a(d dVar) {
        this.bkO = dVar;
    }

    public void a(f fVar) {
        this.bkG = fVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, k kVar) {
        if (kVar.isEnable()) {
            if (c(kVar)) {
                cM(true);
            }
            boolean z = false;
            if (this.bkG != null) {
                z = this.bkG.a(view, kVar);
            }
            if (!z && this.bkI != null) {
                return this.bkI.a(view, kVar);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.bkH != null) {
            return this.bkH.onKey(view, i, keyEvent);
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
        if (this.bkO != null) {
            this.bkO.d(this.mStyle, this.bkF);
        }
        Re();
        c(z, i, z2);
        this.bkE.F(this.bkF);
        this.bkE.showView();
        if (this.bkM != null) {
            this.bkM.a(this, true);
        }
    }

    public void cM(boolean z) {
        this.bkE.cO(z);
        if (this.bkM != null) {
            this.bkM.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.bkE != null && this.bkE.isShowing();
    }

    public void L(int i, int i2) {
        boolean z;
        int i3 = 0;
        boolean z2 = false;
        for (k kVar : this.bkF) {
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
            k eY = o.eY(i);
            if (eY == null) {
                if (DEBUG) {
                    Log.d("SwanAppMenu", "No such Menu: id=" + i);
                    return;
                }
                return;
            }
            int size = this.bkF.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.bkF.add(i3, eY);
            if (DEBUG) {
                Log.d("SwanAppMenu", "Add Menu: id=" + i + ", insert pos=" + i3);
            }
        }
    }

    public void eU(int i) {
        if (this.bkF != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.bkF.size(); i3++) {
                if (this.bkF.get(i3).getItemId() == i) {
                    if (DEBUG) {
                        Log.d("SwanAppMenu", "Hide Menu: id=" + i);
                    }
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.bkF.remove(i2);
            }
        }
    }

    public void eV(int i) {
        this.bkE.eV(i);
    }

    private boolean c(k kVar) {
        return true;
    }

    private void b(boolean z, int i, boolean z2) {
        this.bkN = SwanAppMenuMode.NORMAL;
        this.bkE.setMode(this.bkN);
        Iterator<k> it = this.bkF.iterator();
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
        if (this.bkF != null) {
            b(z, i, z2);
        }
    }

    private void Re() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.bkK);
        hashMap.put("source", this.bkL);
        hashMap.put("type", "menu_clk");
        if (this.bkJ != null) {
            this.bkJ.c("260", hashMap);
        }
    }
}
