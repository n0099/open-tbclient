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
/* loaded from: classes11.dex */
public class h implements View.OnKeyListener, f, com.baidu.swan.menu.viewpager.b {
    private j czg;
    private List<i> czh;
    private f czk;
    private com.baidu.swan.menu.viewpager.b czl;
    private View.OnKeyListener czm;
    private a czn;
    private b czo;
    private Context mContext;
    private int mStyle;
    private boolean cze = false;
    private int czf = 0;
    private List<i> czi = new ArrayList();
    private List<List<i>> czj = new ArrayList();
    private int czp = -1;

    /* loaded from: classes11.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.czh = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.czo = bVar;
            this.czh = k.iw(this.mStyle);
            this.czo.g(this.mStyle, this.czh);
            this.czo.h(this.mStyle, this.czh);
            this.czg = new j(this.mContext, view, aVar);
            this.czg.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.czn != null) {
                        h.this.czn.a(h.this, false);
                    }
                }
            });
        }
    }

    private void asR() {
        this.czj.clear();
        int size = this.czi.size();
        if (size > 0 && size <= 5) {
            this.czj.add(this.czi);
        } else if (size > 5 && size <= 10) {
            int i = this.cze ? 5 : this.czp;
            this.czj.add(this.czi.subList(0, i));
            this.czj.add(this.czi.subList(i, size));
        } else if (size > 10) {
            int ceil = this.cze ? (int) Math.ceil(size / 2.0f) : this.czp;
            this.czj.add(this.czi.subList(0, ceil));
            this.czj.add(this.czi.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        i(z, 0);
    }

    public void i(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            eV(true);
            return;
        }
        if (this.czo != null) {
            this.czo.f(this.mStyle, this.czh);
        }
        j(z, i);
        asR();
        this.czg.b(this.czj, view, z2, this.czf);
        if (this.czn != null) {
            this.czn.a(this, true);
        }
    }

    public void a(f fVar) {
        this.czk = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.czl = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                eV(true);
            }
            if (this.czk == null) {
                return false;
            }
            return this.czk.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean c(i iVar) {
        if (e(iVar) && !this.cze) {
            eV(true);
        }
        if (this.czl == null) {
            return false;
        }
        return this.czl.c(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.czm != null) {
            return this.czm.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void eU(boolean z) {
        a(is(5), z);
        asR();
        this.czg.asX();
        asQ();
    }

    public void eV(boolean z) {
        this.czg.eX(z);
        if (this.czn != null) {
            this.czn.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.czg != null && this.czg.isShowing();
    }

    public void asQ() {
        if (this.czg != null) {
            this.czg.asQ();
        }
    }

    public void ap(int i, int i2) {
        i ix;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.czh) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (ix = k.ix(i)) != null) {
            int size = this.czh.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.czh.add(i3, ix);
        }
    }

    public void ip(int i) {
        if (this.czh != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.czh.size(); i3++) {
                if (this.czh.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.czh.remove(i2);
            }
        }
    }

    public void iq(int i) {
        this.czg.iq(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void eW(boolean z) {
        this.cze = z;
    }

    public void ir(int i) {
        this.czf = i;
    }

    private void j(boolean z, int i) {
        if (this.czh != null) {
            this.czi.clear();
            it(41);
            i a2 = a(is(38), i);
            if (a2 != null && a2.isVisible()) {
                this.czi.add(a2);
            }
            it(48);
            it(45);
            it(4);
            it(101);
            it(9);
            it(39);
            it(42);
            i is = is(35);
            if (is != null && is.isVisible()) {
                this.czi.add(is);
                if (!this.cze) {
                    this.czp = this.czi.size() - 1;
                }
            }
            it(37);
            it(100);
            i a3 = a(is(5), z);
            if (a3 != null && a3.isVisible()) {
                this.czi.add(a3);
            }
            it(40);
            it(46);
            it(47);
            i is2 = is(36);
            if (is2 != null && is2.isVisible()) {
                is2.b(this);
                this.czi.add(is2);
            }
        }
    }

    public void bK(JSONObject jSONObject) {
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
            for (i iVar : this.czi) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.asT());
                    iVar.iu(l.longValue() > 0 ? 1 : 0);
                    iVar.bf(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.iv(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.iv(g.f.aiapp_menu_text_favorite);
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
        iVar.iv(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i is(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.czh.size()) {
                return null;
            }
            i iVar = this.czh.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.bf(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void it(int i) {
        i is = is(i);
        if (is != null && is.isVisible()) {
            this.czi.add(is);
        }
    }
}
