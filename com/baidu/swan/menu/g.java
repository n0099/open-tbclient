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
    private o brR;
    private List<j> brS;
    private e brT;
    private View.OnKeyListener brU;
    private e brV;
    private m brW;
    private String brX;
    private String brY;
    private a brZ;
    private SwanAppMenuMode bsa;
    private c bsb;
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
        this.brS = new ArrayList();
        this.brY = "searchbox";
        this.bsa = null;
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.brY = str;
            this.brS = n.fB(this.mStyle);
            if (h.bsd != null) {
                this.brV = h.bsd.VQ();
                this.brW = h.bsd.VR();
            }
            this.brR = new o(this.mContext, view, this.mStyle, bVar);
            this.brR.c(this);
            this.brR.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.brZ != null) {
                        g.this.brZ.a(g.this, false);
                    }
                }
            });
        }
    }

    public void setStatisticSource(String str) {
        this.brX = str;
        this.brR.setStatisticSource(this.brX);
    }

    public void setMenuSource(String str) {
        this.brY = str;
        this.brR.setMenuSource(str);
    }

    public void a(c cVar) {
        this.bsb = cVar;
    }

    public void a(e eVar) {
        this.brT = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, j jVar) {
        if (jVar.isEnable()) {
            if (c(jVar)) {
                di(true);
            }
            boolean z = false;
            if (this.brT != null) {
                z = this.brT.a(view, jVar);
            }
            if (!z && this.brV != null) {
                return this.brV.a(view, jVar);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.brU != null) {
            return this.brU.onKey(view, i, keyEvent);
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
        if (this.bsb != null) {
            this.bsb.d(this.mStyle, this.brS);
        }
        VN();
        c(z, i, z2);
        this.brR.G(this.brS);
        this.brR.showView();
        if (this.brZ != null) {
            this.brZ.a(this, true);
        }
    }

    public void di(boolean z) {
        this.brR.dk(z);
        if (this.brZ != null) {
            this.brZ.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.brR != null && this.brR.isShowing();
    }

    public void M(int i, int i2) {
        j fC;
        int i3 = 0;
        boolean z = false;
        for (j jVar : this.brS) {
            z = jVar.getItemId() == i ? true : z;
        }
        if (!z && (fC = n.fC(i)) != null) {
            int size = this.brS.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.brS.add(i3, fC);
        }
    }

    public void fy(int i) {
        if (this.brS != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.brS.size(); i3++) {
                if (this.brS.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.brS.remove(i2);
            }
        }
    }

    public void fz(int i) {
        this.brR.fz(i);
    }

    private boolean c(j jVar) {
        return true;
    }

    private void b(boolean z, int i, boolean z2) {
        this.bsa = SwanAppMenuMode.NORMAL;
        this.brR.setMode(this.bsa);
        Iterator<j> it = this.brS.iterator();
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
                        next.setTitle(z ? f.C0236f.aiapp_menu_text_day_mode : f.C0236f.aiapp_menu_text_night_mode);
                        next.setIcon(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
                        break;
                    case 38:
                        if (i == 2) {
                            next.setTitle(f.C0236f.aiapp_menu_text_cancel_favorite);
                            next.setIcon(f.c.aiapp_menu_item_cancel_fav_selector);
                            break;
                        } else if (i == 1) {
                            next.setTitle(f.C0236f.aiapp_menu_text_favorite);
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
        if (this.brS != null) {
            b(z, i, z2);
        }
    }

    private void VN() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.brX);
        hashMap.put("source", this.brY);
        hashMap.put("type", "menu_clk");
        if (this.brW != null) {
            this.brW.d("260", hashMap);
        }
    }
}
