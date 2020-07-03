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
    private j dnW;
    private List<i> dnX;
    private f doa;
    private com.baidu.swan.menu.viewpager.b dob;
    private View.OnKeyListener dod;
    private a doe;
    private b dof;
    private Context mContext;
    private int mStyle;
    private boolean dnU = false;
    private int dnV = 0;
    private List<i> dnY = new ArrayList();
    private List<List<i>> dnZ = new ArrayList();
    private int dog = -1;

    /* loaded from: classes11.dex */
    public interface a {
        void a(h hVar, boolean z);
    }

    public h(Context context, View view, int i, b bVar, @Nullable com.baidu.swan.menu.a aVar) {
        this.dnX = new ArrayList();
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.dof = bVar;
            this.dnX = k.jh(this.mStyle);
            this.dof.g(this.mStyle, this.dnX);
            this.dof.h(this.mStyle, this.dnX);
            this.dnW = new j(this.mContext, view, aVar);
            this.dnW.a(new PopupWindow.a() { // from class: com.baidu.swan.menu.h.1
                @Override // com.baidu.swan.menu.PopupWindow.a
                public void onDismiss() {
                    if (h.this.doe != null) {
                        h.this.doe.a(h.this, false);
                    }
                }
            });
        }
    }

    private void aFZ() {
        this.dnZ.clear();
        int size = this.dnY.size();
        if (size > 0 && size <= 5) {
            this.dnZ.add(this.dnY);
        } else if (size > 5 && size <= 10) {
            int i = this.dnU ? 5 : this.dog;
            this.dnZ.add(this.dnY.subList(0, i));
            this.dnZ.add(this.dnY.subList(i, size));
        } else if (size > 10) {
            int ceil = this.dnU ? (int) Math.ceil(size / 2.0f) : this.dog;
            this.dnZ.add(this.dnY.subList(0, ceil));
            this.dnZ.add(this.dnY.subList(ceil, size));
        }
    }

    public void show(boolean z) {
        n(z, 0);
    }

    public void n(boolean z, int i) {
        a(z, i, null, false);
    }

    public void a(boolean z, int i, View view, boolean z2) {
        if (isShowing()) {
            gi(true);
            return;
        }
        if (this.dof != null) {
            this.dof.f(this.mStyle, this.dnX);
        }
        o(z, i);
        aFZ();
        this.dnW.b(this.dnZ, view, z2, this.dnV);
        if (this.doe != null) {
            this.doe.a(this, true);
        }
    }

    public void a(f fVar) {
        this.doa = fVar;
    }

    public void a(com.baidu.swan.menu.viewpager.b bVar) {
        this.dob = bVar;
    }

    @Override // com.baidu.swan.menu.f
    public boolean a(View view, i iVar) {
        if (iVar.isEnable()) {
            if (e(iVar)) {
                gi(true);
            }
            if (this.doa == null) {
                return false;
            }
            return this.doa.a(view, iVar);
        }
        return true;
    }

    @Override // com.baidu.swan.menu.viewpager.b
    public boolean d(i iVar) {
        if (e(iVar) && !this.dnU) {
            gi(true);
        }
        if (this.dob == null) {
            return false;
        }
        return this.dob.d(iVar);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.dod != null) {
            return this.dod.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void gh(boolean z) {
        a(jd(5), z);
        aFZ();
        this.dnW.aGf();
        aFY();
    }

    public void gi(boolean z) {
        this.dnW.gk(z);
        if (this.doe != null) {
            this.doe.a(this, false);
        }
    }

    public boolean isShowing() {
        return this.dnW != null && this.dnW.isShowing();
    }

    public void aFY() {
        if (this.dnW != null) {
            this.dnW.aFY();
        }
    }

    public void au(int i, int i2) {
        i ji;
        int i3 = 0;
        boolean z = false;
        for (i iVar : this.dnX) {
            z = iVar.getItemId() == i ? true : z;
        }
        if (!z && (ji = k.ji(i)) != null) {
            int size = this.dnX.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.dnX.add(i3, ji);
        }
    }

    public void ja(int i) {
        if (this.dnX != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.dnX.size(); i3++) {
                if (this.dnX.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.dnX.remove(i2);
            }
        }
    }

    public void jb(int i) {
        this.dnW.jb(i);
    }

    private boolean e(i iVar) {
        return true;
    }

    public void gj(boolean z) {
        this.dnU = z;
    }

    public void jc(int i) {
        this.dnV = i;
    }

    private void o(boolean z, int i) {
        if (this.dnX != null) {
            this.dnY.clear();
            je(41);
            i a2 = a(jd(38), i);
            if (a2 != null && a2.isVisible()) {
                this.dnY.add(a2);
            }
            je(48);
            je(45);
            je(4);
            je(101);
            je(9);
            je(39);
            je(42);
            i jd = jd(35);
            if (jd != null && jd.isVisible()) {
                this.dnY.add(jd);
                if (!this.dnU) {
                    this.dog = this.dnY.size() - 1;
                }
            }
            je(37);
            je(100);
            i a3 = a(jd(5), z);
            if (a3 != null && a3.isVisible()) {
                this.dnY.add(a3);
            }
            je(40);
            je(46);
            je(47);
            i jd2 = jd(36);
            if (jd2 != null && jd2.isVisible()) {
                jd2.b(this);
                this.dnY.add(jd2);
            }
        }
    }

    public void cd(JSONObject jSONObject) {
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
            for (i iVar : this.dnY) {
                if (iVar.getItemId() == i) {
                    l = Long.valueOf(l.longValue() + iVar.aGb());
                    iVar.jf(l.longValue() > 0 ? 1 : 0);
                    iVar.bI(l.longValue());
                }
            }
        }
    }

    private i a(i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        if (i == 2) {
            iVar.jg(g.f.aiapp_menu_text_cancel_favorite);
            iVar.setIconResId(g.c.aiapp_menu_item_cancel_fav_selector);
        } else if (i == 1) {
            iVar.jg(g.f.aiapp_menu_text_favorite);
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
        iVar.jg(z ? g.f.aiapp_menu_text_day_mode : g.f.aiapp_menu_text_night_mode);
        iVar.setIconResId(z ? g.c.aiapp_menu_item_daymode : g.c.aiapp_menu_item_nightmode);
        return iVar;
    }

    public i jd(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.dnX.size()) {
                return null;
            }
            i iVar = this.dnX.get(i3);
            if (iVar.getItemId() != i) {
                i2 = i3 + 1;
            } else {
                iVar.bI(0L);
                iVar.a(this);
                return iVar;
            }
        }
    }

    private void je(int i) {
        i jd = jd(i);
        if (jd != null && jd.isVisible()) {
            this.dnY.add(jd);
        }
    }
}
