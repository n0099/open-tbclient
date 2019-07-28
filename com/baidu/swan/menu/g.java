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
    private String brA;
    private a brB;
    private SwanAppMenuMode brC;
    private c brD;
    private o brt;
    private List<j> bru;
    private e brv;
    private View.OnKeyListener brw;
    private e brx;
    private m bry;
    private String brz;
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
        this.bru = new ArrayList();
        this.brA = "searchbox";
        this.brC = null;
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.brA = str;
            this.bru = n.fA(this.mStyle);
            if (h.brF != null) {
                this.brx = h.brF.VM();
                this.bry = h.brF.VN();
            }
            this.brt = new o(this.mContext, view, this.mStyle, bVar);
            this.brt.c(this);
            this.brt.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.brB != null) {
                        g.this.brB.a(g.this, false);
                    }
                }
            });
        }
    }

    public void setStatisticSource(String str) {
        this.brz = str;
        this.brt.setStatisticSource(this.brz);
    }

    public void setMenuSource(String str) {
        this.brA = str;
        this.brt.setMenuSource(str);
    }

    public void a(c cVar) {
        this.brD = cVar;
    }

    public void a(e eVar) {
        this.brv = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, j jVar) {
        if (jVar.isEnable()) {
            if (c(jVar)) {
                di(true);
            }
            boolean z = false;
            if (this.brv != null) {
                z = this.brv.a(view, jVar);
            }
            if (!z && this.brx != null) {
                return this.brx.a(view, jVar);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.brw != null) {
            return this.brw.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void i(boolean z, boolean z2) {
        a(z, 0, z2);
    }

    public void a(boolean z, int i, boolean z2) {
        if (isShowing()) {
            di(true);
            return;
        }
        if (this.brD != null) {
            this.brD.d(this.mStyle, this.bru);
        }
        VJ();
        c(z, i, z2);
        this.brt.G(this.bru);
        this.brt.showView();
        if (this.brB != null) {
            this.brB.a(this, true);
        }
    }

    public void di(boolean z) {
        this.brt.dk(z);
        if (this.brB != null) {
            this.brB.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.brt != null && this.brt.isShowing();
    }

    public void M(int i, int i2) {
        j fB;
        int i3 = 0;
        boolean z = false;
        for (j jVar : this.bru) {
            z = jVar.getItemId() == i ? true : z;
        }
        if (!z && (fB = n.fB(i)) != null) {
            int size = this.bru.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.bru.add(i3, fB);
        }
    }

    public void fx(int i) {
        if (this.bru != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.bru.size(); i3++) {
                if (this.bru.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.bru.remove(i2);
            }
        }
    }

    public void fy(int i) {
        this.brt.fy(i);
    }

    private boolean c(j jVar) {
        return true;
    }

    private void b(boolean z, int i, boolean z2) {
        this.brC = SwanAppMenuMode.NORMAL;
        this.brt.setMode(this.brC);
        Iterator<j> it = this.bru.iterator();
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
                        next.setTitle(z ? f.C0227f.aiapp_menu_text_day_mode : f.C0227f.aiapp_menu_text_night_mode);
                        next.setIcon(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
                        break;
                    case 38:
                        if (i == 2) {
                            next.setTitle(f.C0227f.aiapp_menu_text_cancel_favorite);
                            next.setIcon(f.c.aiapp_menu_item_cancel_fav_selector);
                            break;
                        } else if (i == 1) {
                            next.setTitle(f.C0227f.aiapp_menu_text_favorite);
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
        if (this.bru != null) {
            b(z, i, z2);
        }
    }

    private void VJ() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.brz);
        hashMap.put("source", this.brA);
        hashMap.put("type", "menu_clk");
        if (this.bry != null) {
            this.bry.d("260", hashMap);
        }
    }
}
