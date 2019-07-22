package com.baidu.swan.apps.tabbar.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ae.a.c;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.w.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private c.f aRb;
    private View aYh;
    private LinearLayout aYi;
    private int aYj = 0;
    private d aYk;
    private ArrayList<SwanAppBottomTabIconView> aYl;
    private ArrayList<c.g> aYm;
    private String aYn;
    private String aYo;

    public a(d dVar) {
        this.aYk = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.aYk.zw()) {
            c Gn = e.GF().Gn();
            if (Gn == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.aRb = Gn.aRb;
            this.aYm = this.aRb.aRq;
            int size = this.aYm.size();
            this.aYl = new ArrayList<>(size);
            this.aYh = view.findViewById(a.f.bottom_bar_shadow);
            et(this.aRb.aRp);
            this.aYi = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.aYi.setVisibility(0);
            this.aYi.setBackgroundColor(this.aRb.mBackgroundColor);
            int displayWidth = z.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.aYm.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.aRr, !TextUtils.isEmpty(str) ? str : e.GF().Gq()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.aYj = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.amD);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.eu(i);
                    }
                });
                this.aYl.add(swanAppBottomTabIconView);
                this.aYi.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void et(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.aYh.setVisibility(0);
                this.aYh.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.aYh.setVisibility(0);
                this.aYh.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.aYh.setVisibility(0);
                this.aYh.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void hT(String str) {
        this.aYi.setBackgroundColor(c.cE(str));
    }

    private boolean a(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b vL = vL();
        if (vL == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(vL);
        if (TextUtils.isEmpty(m)) {
            m = e.d.ae(vL.getAppId(), vL.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.aRs;
        if (com.baidu.swan.c.a.lf(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aYn == null) {
                swanAppBottomTabIconView.setTextColor(this.aRb.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(c.cE(this.aYn));
            }
            return true;
        }
        return false;
    }

    private boolean b(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b vL = vL();
        if (vL == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(vL);
        if (TextUtils.isEmpty(m)) {
            m = e.d.ae(vL.getAppId(), vL.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.aRt;
        if (com.baidu.swan.c.a.lf(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aYo == null) {
                swanAppBottomTabIconView.setTextColor(this.aRb.aRo);
            } else {
                swanAppBottomTabIconView.setTextColor(c.cE(this.aYo));
            }
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b vL() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            return Md.vL();
        }
        return null;
    }

    public boolean cB(boolean z) {
        if (this.aYh == null || this.aYi == null) {
            return false;
        }
        this.aYh.setVisibility(8);
        if (z) {
            OK();
        } else {
            this.aYi.setVisibility(8);
        }
        return true;
    }

    public boolean cC(boolean z) {
        if (this.aYh == null || this.aYi == null) {
            return false;
        }
        this.aYh.setVisibility(0);
        this.aYi.setVisibility(0);
        cD(z);
        return true;
    }

    private void OK() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYi, "translationY", 0.0f, com.baidu.swan.apps.u.a.Ek().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.aYi.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
    }

    private void cD(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYi, "translationY", com.baidu.swan.apps.u.a.Ek().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(int i) {
        ew(i);
        ev(i);
        if (this.aYj != i) {
            this.aYj = i;
            this.aYk.pause();
            this.aYk.c(com.baidu.swan.apps.model.b.aq(this.aYm.get(i).aRr, com.baidu.swan.apps.w.e.GF().Go()));
            d dVar = this.aYk;
            d.dM("switchTab");
            this.aYk.resume();
        }
    }

    private void ev(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.aYm.get(i);
        String dO = this.aYk.dO(com.baidu.swan.apps.model.b.aq(gVar.aRr, com.baidu.swan.apps.w.e.GF().Go()).azs);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.aRr);
        hashMap.put("text", gVar.amD);
        hashMap.put("wvID", dO);
        com.baidu.swan.apps.w.e.GF().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void ew(int i) {
        a(this.aYl.get(this.aYj), this.aYm.get(this.aYj));
        b(this.aYl.get(i), this.aYm.get(i));
    }

    public void hU(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aYm.size()) {
                if (!this.aYm.get(i2).aRr.equals(str)) {
                    i = i2 + 1;
                } else {
                    ew(i2);
                    this.aYj = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean k(String str, String str2, String str3, String str4) {
        if (this.aYh == null || this.aYi == null) {
            return false;
        }
        et(c.cE(str4));
        hT(str3);
        hV(str);
        hW(str2);
        Iterator<SwanAppBottomTabIconView> it = this.aYl.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.OL()) {
                next.setTextColor(c.cE(str2));
            } else {
                next.setTextColor(c.cE(str));
            }
        }
        return true;
    }

    private void hV(String str) {
        this.aYn = str;
    }

    private void hW(String str) {
        this.aYo = str;
    }

    public boolean b(int i, String str, String str2, String str3) {
        if (!eA(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aYl.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.aYm.get(i).aRs = str2;
        this.aYm.get(i).aRt = str3;
        if (swanAppBottomTabIconView.OL()) {
            return b(swanAppBottomTabIconView, this.aYm.get(i));
        }
        return a(swanAppBottomTabIconView, this.aYm.get(i));
    }

    public boolean ex(int i) {
        if (!eA(i)) {
            return false;
        }
        this.aYl.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean ey(int i) {
        if (eA(i)) {
            this.aYl.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean s(int i, String str) {
        if (!eA(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aYl.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean ez(int i) {
        if (eA(i)) {
            this.aYl.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean eA(int i) {
        return this.aYl != null && i < this.aYl.size() && i >= 0;
    }

    public int hX(String str) {
        if (TextUtils.isEmpty(str) || this.aYm == null || this.aYm.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aYm.size()) {
                return -1;
            }
            c.g gVar = this.aYm.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.aRr, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
