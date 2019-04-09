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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.c.d;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.w.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private c.f aOo;
    private View aUB;
    private LinearLayout aUC;
    private int aUD = 0;
    private d aUE;
    private ArrayList<SwanAppBottomTabIconView> aUF;
    private ArrayList<c.g> aUG;
    private String aUH;
    private String aUI;

    public a(d dVar) {
        this.aUE = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.aUE.xX()) {
            c DI = e.Ea().DI();
            if (DI == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.aOo = DI.aOo;
            this.aUG = this.aOo.aOD;
            int size = this.aUG.size();
            this.aUF = new ArrayList<>(size);
            this.aUB = view.findViewById(a.f.bottom_bar_shadow);
            ef(this.aOo.aOC);
            this.aUC = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.aUC.setVisibility(0);
            this.aUC.setBackgroundColor(this.aOo.mBackgroundColor);
            int displayWidth = x.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.aUG.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.aOE, !TextUtils.isEmpty(str) ? str : e.Ea().DL()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.aUD = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.alO);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.eg(i);
                    }
                });
                this.aUF.add(swanAppBottomTabIconView);
                this.aUC.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void ef(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.aUB.setVisibility(0);
                this.aUB.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.aUB.setVisibility(0);
                this.aUB.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.aUB.setVisibility(0);
                this.aUB.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void hl(String str) {
        this.aUC.setBackgroundColor(c.parseColor(str));
    }

    private boolean a(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b uA = uA();
        if (uA == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(uA);
        if (TextUtils.isEmpty(m)) {
            m = c.d.ah(uA.mAppId, uA.mVersion).getPath();
        }
        String str = m + File.separator + gVar.aOF;
        if (com.baidu.swan.c.b.jY(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aUH == null) {
                swanAppBottomTabIconView.setTextColor(this.aOo.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(this.aUH));
            }
            return true;
        }
        return false;
    }

    private boolean b(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b uA = uA();
        if (uA == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(uA);
        if (TextUtils.isEmpty(m)) {
            m = c.d.ah(uA.mAppId, uA.mVersion).getPath();
        }
        String str = m + File.separator + gVar.aOG;
        if (com.baidu.swan.c.b.jY(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aUI == null) {
                swanAppBottomTabIconView.setTextColor(this.aOo.aOB);
            } else {
                swanAppBottomTabIconView.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(this.aUI));
            }
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b uA() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            return IV.uA();
        }
        return null;
    }

    public boolean cj(boolean z) {
        if (this.aUB == null || this.aUC == null) {
            return false;
        }
        this.aUB.setVisibility(8);
        if (z) {
            Ls();
        } else {
            this.aUC.setVisibility(8);
        }
        return true;
    }

    public boolean ck(boolean z) {
        if (this.aUB == null || this.aUC == null) {
            return false;
        }
        this.aUB.setVisibility(0);
        this.aUC.setVisibility(0);
        cl(z);
        return true;
    }

    private void Ls() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUC, "translationY", 0.0f, com.baidu.swan.apps.u.a.Cw().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.aUC.setVisibility(8);
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

    private void cl(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUC, "translationY", com.baidu.swan.apps.u.a.Cw().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg(int i) {
        ei(i);
        eh(i);
        if (this.aUD != i) {
            this.aUD = i;
            this.aUE.pause();
            this.aUE.c(com.baidu.swan.apps.model.b.ap(this.aUG.get(i).aOE, e.Ea().DJ()));
            d dVar = this.aUE;
            d.dV("switchTab");
            this.aUE.resume();
        }
    }

    private void eh(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.aUG.get(i);
        String dX = this.aUE.dX(com.baidu.swan.apps.model.b.ap(gVar.aOE, e.Ea().DJ()).axM);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.aOE);
        hashMap.put("text", gVar.alO);
        hashMap.put("wvID", dX);
        e.Ea().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void ei(int i) {
        a(this.aUF.get(this.aUD), this.aUG.get(this.aUD));
        b(this.aUF.get(i), this.aUG.get(i));
    }

    public void hm(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aUG.size()) {
                if (!this.aUG.get(i2).aOE.equals(str)) {
                    i = i2 + 1;
                } else {
                    ei(i2);
                    this.aUD = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean k(String str, String str2, String str3, String str4) {
        if (this.aUB == null || this.aUC == null) {
            return false;
        }
        ef(com.baidu.swan.apps.ae.a.c.parseColor(str4));
        hl(str3);
        hn(str);
        ho(str2);
        Iterator<SwanAppBottomTabIconView> it = this.aUF.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.Lt()) {
                next.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(str2));
            } else {
                next.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(str));
            }
        }
        return true;
    }

    private void hn(String str) {
        this.aUH = str;
    }

    private void ho(String str) {
        this.aUI = str;
    }

    public boolean b(int i, String str, String str2, String str3) {
        if (!em(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aUF.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.aUG.get(i).aOF = str2;
        this.aUG.get(i).aOG = str3;
        if (swanAppBottomTabIconView.Lt()) {
            return b(swanAppBottomTabIconView, this.aUG.get(i));
        }
        return a(swanAppBottomTabIconView, this.aUG.get(i));
    }

    public boolean ej(int i) {
        if (!em(i)) {
            return false;
        }
        this.aUF.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean ek(int i) {
        if (em(i)) {
            this.aUF.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean r(int i, String str) {
        if (!em(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aUF.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean el(int i) {
        if (em(i)) {
            this.aUF.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean em(int i) {
        return this.aUF != null && i < this.aUF.size() && i >= 0;
    }

    public int hp(String str) {
        if (TextUtils.isEmpty(str) || this.aUG == null || this.aUG.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aUG.size()) {
                return -1;
            }
            c.g gVar = this.aUG.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.aOE, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
