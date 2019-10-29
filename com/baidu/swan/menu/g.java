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
    private o bKC;
    private List<j> bKD;
    private e bKE;
    private View.OnKeyListener bKF;
    private e bKG;
    private m bKH;
    private String bKI;
    private String bKJ;
    private a bKK;
    private SwanAppMenuMode bKL;
    private c bKM;
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
        this.bKD = new ArrayList();
        this.bKJ = "searchbox";
        this.bKL = null;
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.bKJ = str;
            this.bKD = n.gw(this.mStyle);
            if (h.bKO != null) {
                this.bKG = h.bKO.aaF();
                this.bKH = h.bKO.aaG();
            }
            this.bKC = new o(this.mContext, view, this.mStyle, bVar);
            this.bKC.c(this);
            this.bKC.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.bKK != null) {
                        g.this.bKK.a(g.this, false);
                    }
                }
            });
        }
    }

    public void setStatisticSource(String str) {
        this.bKI = str;
        this.bKC.setStatisticSource(this.bKI);
    }

    public void setMenuSource(String str) {
        this.bKJ = str;
        this.bKC.setMenuSource(str);
    }

    public void a(c cVar) {
        this.bKM = cVar;
    }

    public void a(e eVar) {
        this.bKE = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, j jVar) {
        if (jVar.isEnable()) {
            if (c(jVar)) {
                dz(true);
            }
            boolean z = false;
            if (this.bKE != null) {
                z = this.bKE.a(view, jVar);
            }
            if (!z && this.bKG != null) {
                return this.bKG.a(view, jVar);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.bKF != null) {
            return this.bKF.onKey(view, i, keyEvent);
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
        if (this.bKM != null) {
            this.bKM.e(this.mStyle, this.bKD);
        }
        aaC();
        c(z, i, z2);
        this.bKC.af(this.bKD);
        this.bKC.showView();
        if (this.bKK != null) {
            this.bKK.a(this, true);
        }
    }

    public void dz(boolean z) {
        this.bKC.dB(z);
        if (this.bKK != null) {
            this.bKK.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.bKC != null && this.bKC.isShowing();
    }

    public void S(int i, int i2) {
        j gx;
        int i3 = 0;
        boolean z = false;
        for (j jVar : this.bKD) {
            z = jVar.getItemId() == i ? true : z;
        }
        if (!z && (gx = n.gx(i)) != null) {
            int size = this.bKD.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.bKD.add(i3, gx);
        }
    }

    public void gt(int i) {
        if (this.bKD != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.bKD.size(); i3++) {
                if (this.bKD.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.bKD.remove(i2);
            }
        }
    }

    public void gu(int i) {
        this.bKC.gu(i);
    }

    private boolean c(j jVar) {
        return true;
    }

    private void b(boolean z, int i, boolean z2) {
        this.bKL = SwanAppMenuMode.NORMAL;
        this.bKC.setMode(this.bKL);
        Iterator<j> it = this.bKD.iterator();
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
        if (this.bKD != null) {
            b(z, i, z2);
        }
    }

    private void aaC() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.bKI);
        hashMap.put("source", this.bKJ);
        hashMap.put("type", "menu_clk");
        if (this.bKH != null) {
            this.bKH.d("260", hashMap);
        }
    }
}
