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
    private c.f aOn;
    private View aUA;
    private LinearLayout aUB;
    private int aUC = 0;
    private d aUD;
    private ArrayList<SwanAppBottomTabIconView> aUE;
    private ArrayList<c.g> aUF;
    private String aUG;
    private String aUH;

    public a(d dVar) {
        this.aUD = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.aUD.xX()) {
            c DI = e.Ea().DI();
            if (DI == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.aOn = DI.aOn;
            this.aUF = this.aOn.aOC;
            int size = this.aUF.size();
            this.aUE = new ArrayList<>(size);
            this.aUA = view.findViewById(a.f.bottom_bar_shadow);
            ef(this.aOn.aOB);
            this.aUB = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.aUB.setVisibility(0);
            this.aUB.setBackgroundColor(this.aOn.mBackgroundColor);
            int displayWidth = x.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.aUF.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.aOD, !TextUtils.isEmpty(str) ? str : e.Ea().DL()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.aUC = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.alN);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.eg(i);
                    }
                });
                this.aUE.add(swanAppBottomTabIconView);
                this.aUB.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void ef(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.aUA.setVisibility(0);
                this.aUA.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.aUA.setVisibility(0);
                this.aUA.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.aUA.setVisibility(0);
                this.aUA.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void hl(String str) {
        this.aUB.setBackgroundColor(c.parseColor(str));
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
        String str = m + File.separator + gVar.aOE;
        if (com.baidu.swan.c.b.jY(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aUG == null) {
                swanAppBottomTabIconView.setTextColor(this.aOn.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(this.aUG));
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
        String str = m + File.separator + gVar.aOF;
        if (com.baidu.swan.c.b.jY(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aUH == null) {
                swanAppBottomTabIconView.setTextColor(this.aOn.aOA);
            } else {
                swanAppBottomTabIconView.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(this.aUH));
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
        if (this.aUA == null || this.aUB == null) {
            return false;
        }
        this.aUA.setVisibility(8);
        if (z) {
            Ls();
        } else {
            this.aUB.setVisibility(8);
        }
        return true;
    }

    public boolean ck(boolean z) {
        if (this.aUA == null || this.aUB == null) {
            return false;
        }
        this.aUA.setVisibility(0);
        this.aUB.setVisibility(0);
        cl(z);
        return true;
    }

    private void Ls() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUB, "translationY", 0.0f, com.baidu.swan.apps.u.a.Cw().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.aUB.setVisibility(8);
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUB, "translationY", com.baidu.swan.apps.u.a.Cw().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg(int i) {
        ei(i);
        eh(i);
        if (this.aUC != i) {
            this.aUC = i;
            this.aUD.pause();
            this.aUD.c(com.baidu.swan.apps.model.b.ap(this.aUF.get(i).aOD, e.Ea().DJ()));
            d dVar = this.aUD;
            d.dV("switchTab");
            this.aUD.resume();
        }
    }

    private void eh(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.aUF.get(i);
        String dX = this.aUD.dX(com.baidu.swan.apps.model.b.ap(gVar.aOD, e.Ea().DJ()).axL);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.aOD);
        hashMap.put("text", gVar.alN);
        hashMap.put("wvID", dX);
        e.Ea().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void ei(int i) {
        a(this.aUE.get(this.aUC), this.aUF.get(this.aUC));
        b(this.aUE.get(i), this.aUF.get(i));
    }

    public void hm(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aUF.size()) {
                if (!this.aUF.get(i2).aOD.equals(str)) {
                    i = i2 + 1;
                } else {
                    ei(i2);
                    this.aUC = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean k(String str, String str2, String str3, String str4) {
        if (this.aUA == null || this.aUB == null) {
            return false;
        }
        ef(com.baidu.swan.apps.ae.a.c.parseColor(str4));
        hl(str3);
        hn(str);
        ho(str2);
        Iterator<SwanAppBottomTabIconView> it = this.aUE.iterator();
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
        this.aUG = str;
    }

    private void ho(String str) {
        this.aUH = str;
    }

    public boolean b(int i, String str, String str2, String str3) {
        if (!em(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aUE.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.aUF.get(i).aOE = str2;
        this.aUF.get(i).aOF = str3;
        if (swanAppBottomTabIconView.Lt()) {
            return b(swanAppBottomTabIconView, this.aUF.get(i));
        }
        return a(swanAppBottomTabIconView, this.aUF.get(i));
    }

    public boolean ej(int i) {
        if (!em(i)) {
            return false;
        }
        this.aUE.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean ek(int i) {
        if (em(i)) {
            this.aUE.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean r(int i, String str) {
        if (!em(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aUE.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean el(int i) {
        if (em(i)) {
            this.aUE.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean em(int i) {
        return this.aUE != null && i < this.aUE.size() && i >= 0;
    }

    public int hp(String str) {
        if (TextUtils.isEmpty(str) || this.aUF == null || this.aUF.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aUF.size()) {
                return -1;
            }
            c.g gVar = this.aUF.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.aOD, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
