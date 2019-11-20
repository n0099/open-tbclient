package com.baidu.swan.menu;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements View.OnKeyListener, e {
    private o bJL;
    private List<j> bJM;
    private e bJN;
    private View.OnKeyListener bJO;
    private e bJP;
    private m bJQ;
    private String bJR;
    private String bJS;
    private a bJT;
    private SwanAppMenuMode bJU;
    private c bJV;
    private Context mContext;
    private int mStyle;

    /* loaded from: classes2.dex */
    public interface a {
        void a(g gVar, boolean z);
    }

    public g(Context context, View view, int i, @Nullable b bVar) {
        this(context, view, i, "searchbox", bVar);
    }

    public g(Context context, View view, int i, String str, @Nullable b bVar) {
        this.bJM = new ArrayList();
        this.bJS = "searchbox";
        this.bJU = null;
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.bJS = str;
            this.bJM = n.gv(this.mStyle);
            if (h.bJX != null) {
                this.bJP = h.bJX.aaD();
                this.bJQ = h.bJX.aaE();
            }
            this.bJL = new o(this.mContext, view, this.mStyle, bVar);
            this.bJL.c(this);
            this.bJL.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.bJT != null) {
                        g.this.bJT.a(g.this, false);
                    }
                }
            });
        }
    }

    public void setStatisticSource(String str) {
        this.bJR = str;
        this.bJL.setStatisticSource(this.bJR);
    }

    public void setMenuSource(String str) {
        this.bJS = str;
        this.bJL.setMenuSource(str);
    }

    public void a(c cVar) {
        this.bJV = cVar;
    }

    public void a(e eVar) {
        this.bJN = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, j jVar) {
        if (jVar.isEnable()) {
            if (c(jVar)) {
                dz(true);
            }
            boolean z = false;
            if (this.bJN != null) {
                z = this.bJN.a(view, jVar);
            }
            if (!z && this.bJP != null) {
                return this.bJP.a(view, jVar);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.bJO != null) {
            return this.bJO.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void m(boolean z, boolean z2) {
        a(z, 0, z2);
    }

    public void a(boolean z, int i, boolean z2) {
        if (isShowing()) {
            dz(true);
            return;
        }
        if (this.bJV != null) {
            this.bJV.e(this.mStyle, this.bJM);
        }
        aaA();
        c(z, i, z2);
        this.bJL.af(this.bJM);
        this.bJL.showView();
        if (this.bJT != null) {
            this.bJT.a(this, true);
        }
    }

    public void dz(boolean z) {
        this.bJL.dB(z);
        if (this.bJT != null) {
            this.bJT.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.bJL != null && this.bJL.isShowing();
    }

    public void Q(int i, int i2) {
        j gw;
        int i3 = 0;
        boolean z = false;
        for (j jVar : this.bJM) {
            z = jVar.getItemId() == i ? true : z;
        }
        if (!z && (gw = n.gw(i)) != null) {
            int size = this.bJM.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.bJM.add(i3, gw);
        }
    }

    public void gs(int i) {
        if (this.bJM != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.bJM.size(); i3++) {
                if (this.bJM.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.bJM.remove(i2);
            }
        }
    }

    public void gt(int i) {
        this.bJL.gt(i);
    }

    private boolean c(j jVar) {
        return true;
    }

    private void b(boolean z, int i, boolean z2) {
        this.bJU = SwanAppMenuMode.NORMAL;
        this.bJL.setMode(this.bJU);
        Iterator<j> it = this.bJM.iterator();
        while (it.hasNext()) {
            j next = it.next();
            int itemId = next.getItemId();
            if (itemId == 38 && i == 0) {
                it.remove();
            } else {
                if (z2 && itemId == 34) {
                    it.remove();
                }
                switch (itemId) {
                    case 5:
                        next.setTitle(z ? f.C0268f.aiapp_menu_text_day_mode : f.C0268f.aiapp_menu_text_night_mode);
                        next.setIcon(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
                        break;
                    case 38:
                        if (i == 2) {
                            next.setTitle(f.C0268f.aiapp_menu_text_cancel_favorite);
                            next.setIcon(f.c.aiapp_menu_item_cancel_fav_selector);
                            break;
                        } else if (i == 1) {
                            next.setTitle(f.C0268f.aiapp_menu_text_favorite);
                            next.setIcon(f.c.aiapp_menu_item_add_fav_selector);
                            break;
                        }
                        break;
                }
                next.a(this);
            }
        }
    }

    private void c(boolean z, int i, boolean z2) {
        if (this.bJM != null) {
            b(z, i, z2);
        }
    }

    private void aaA() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.bJR);
        hashMap.put("source", this.bJS);
        hashMap.put("type", "menu_clk");
        if (this.bJQ != null) {
            this.bJQ.d("260", hashMap);
        }
    }
}
