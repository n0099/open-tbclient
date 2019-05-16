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
    private o bqG;
    private List<j> bqH;
    private e bqI;
    private View.OnKeyListener bqJ;
    private e bqK;
    private m bqL;
    private String bqM;
    private String bqN;
    private a bqO;
    private SwanAppMenuMode bqP;
    private c bqQ;
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
        this.bqH = new ArrayList();
        this.bqN = "searchbox";
        this.bqP = null;
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.bqN = str;
            this.bqH = n.fw(this.mStyle);
            if (h.bqS != null) {
                this.bqK = h.bqS.UT();
                this.bqL = h.bqS.UU();
            }
            this.bqG = new o(this.mContext, view, this.mStyle, bVar);
            this.bqG.c(this);
            this.bqG.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.g.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (g.this.bqO != null) {
                        g.this.bqO.a(g.this, false);
                    }
                }
            });
        }
    }

    public void setStatisticSource(String str) {
        this.bqM = str;
        this.bqG.setStatisticSource(this.bqM);
    }

    public void setMenuSource(String str) {
        this.bqN = str;
        this.bqG.setMenuSource(str);
    }

    public void a(c cVar) {
        this.bqQ = cVar;
    }

    public void a(e eVar) {
        this.bqI = eVar;
    }

    @Override // com.baidu.swan.menu.e
    public boolean a(View view, j jVar) {
        if (jVar.isEnable()) {
            if (c(jVar)) {
                dd(true);
            }
            boolean z = false;
            if (this.bqI != null) {
                z = this.bqI.a(view, jVar);
            }
            if (!z && this.bqK != null) {
                return this.bqK.a(view, jVar);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.bqJ != null) {
            return this.bqJ.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void i(boolean z, boolean z2) {
        a(z, 0, z2);
    }

    public void a(boolean z, int i, boolean z2) {
        if (isShowing()) {
            dd(true);
            return;
        }
        if (this.bqQ != null) {
            this.bqQ.d(this.mStyle, this.bqH);
        }
        UQ();
        c(z, i, z2);
        this.bqG.G(this.bqH);
        this.bqG.showView();
        if (this.bqO != null) {
            this.bqO.a(this, true);
        }
    }

    public void dd(boolean z) {
        this.bqG.df(z);
        if (this.bqO != null) {
            this.bqO.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.bqG != null && this.bqG.isShowing();
    }

    public void J(int i, int i2) {
        j fx;
        int i3 = 0;
        boolean z = false;
        for (j jVar : this.bqH) {
            z = jVar.getItemId() == i ? true : z;
        }
        if (!z && (fx = n.fx(i)) != null) {
            int size = this.bqH.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.bqH.add(i3, fx);
        }
    }

    public void ft(int i) {
        if (this.bqH != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.bqH.size(); i3++) {
                if (this.bqH.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.bqH.remove(i2);
            }
        }
    }

    public void fu(int i) {
        this.bqG.fu(i);
    }

    private boolean c(j jVar) {
        return true;
    }

    private void b(boolean z, int i, boolean z2) {
        this.bqP = SwanAppMenuMode.NORMAL;
        this.bqG.setMode(this.bqP);
        Iterator<j> it = this.bqH.iterator();
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
                        next.setTitle(z ? f.C0225f.aiapp_menu_text_day_mode : f.C0225f.aiapp_menu_text_night_mode);
                        next.setIcon(z ? f.c.aiapp_menu_item_daymode : f.c.aiapp_menu_item_nightmode);
                        break;
                    case 38:
                        if (i == 2) {
                            next.setTitle(f.C0225f.aiapp_menu_text_cancel_favorite);
                            next.setIcon(f.c.aiapp_menu_item_cancel_fav_selector);
                            break;
                        } else if (i == 1) {
                            next.setTitle(f.C0225f.aiapp_menu_text_favorite);
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
        if (this.bqH != null) {
            b(z, i, z2);
        }
    }

    private void UQ() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.bqM);
        hashMap.put("source", this.bqN);
        hashMap.put("type", "menu_clk");
        if (this.bqL != null) {
            this.bqL.d("260", hashMap);
        }
    }
}
