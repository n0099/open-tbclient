package com.baidu.swan.apps.tabbar.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.AnyThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.performance.h;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.w.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.i cFg;
    private View cMV;
    private LinearLayout cMW;
    private int cMX = 0;
    private d cMY;
    private ArrayList<SwanAppBottomTabIconView> cMZ;
    private ArrayList<SwanAppConfigData.j> cNa;
    private String cNb;
    private String cNc;

    public a(d dVar) {
        this.cMY = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.cMY.YW()) {
            SwanAppConfigData aiG = f.ajb().aiG();
            if (aiG == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.cFg = aiG.cFg;
            this.cNa = this.cFg.cFI;
            int size = this.cNa.size();
            this.cMZ = new ArrayList<>(size);
            this.cMV = view.findViewById(a.f.bottom_bar_shadow);
            hK(this.cFg.cFH);
            this.cMW = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.cMW.setVisibility(0);
            this.cMW.setBackgroundColor(this.cFg.mBackgroundColor);
            int displayWidth = ag.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.j jVar = this.cNa.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(jVar.cFJ, !TextUtils.isEmpty(str) ? str : f.ajb().aiK()) && !z2) {
                    b(swanAppBottomTabIconView, jVar);
                    this.cMX = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, jVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(jVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.hL(i);
                    }
                });
                this.cMZ.add(swanAppBottomTabIconView);
                this.cMW.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean ZE() {
        return this.cMW != null && this.cMW.getVisibility() == 0;
    }

    private void hK(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.cMV.setVisibility(0);
                this.cMV.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.cMV.setVisibility(0);
                this.cMV.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.cMV.setVisibility(0);
                this.cMV.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void pu(String str) {
        this.cMW.setBackgroundColor(SwanAppConfigData.dV(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.j jVar) {
        com.baidu.swan.apps.v.b.b Sb = Sb();
        if (Sb == null) {
            return false;
        }
        String n = com.baidu.swan.apps.af.a.a.n(Sb);
        if (TextUtils.isEmpty(n)) {
            n = e.d.bm(Sb.getAppId(), Sb.getVersion()).getPath();
        }
        String str = n + File.separator + jVar.cFK;
        if (com.baidu.swan.e.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cNb == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cFg.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dV(a.this.cNb));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.j jVar) {
        com.baidu.swan.apps.v.b.b Sb = Sb();
        if (Sb == null) {
            return false;
        }
        String n = com.baidu.swan.apps.af.a.a.n(Sb);
        if (TextUtils.isEmpty(n)) {
            n = e.d.bm(Sb.getAppId(), Sb.getVersion()).getPath();
        }
        String str = n + File.separator + jVar.cFL;
        if (com.baidu.swan.e.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cNc == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cFg.cFG);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dV(a.this.cNc));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b Sb() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null) {
            return apM.RP();
        }
        return null;
    }

    public boolean fu(boolean z) {
        if (this.cMV == null || this.cMW == null) {
            return false;
        }
        this.cMV.setVisibility(8);
        if (z) {
            atH();
        } else {
            this.cMW.setVisibility(8);
        }
        return true;
    }

    public boolean fv(boolean z) {
        if (this.cMV == null || this.cMW == null) {
            return false;
        }
        this.cMV.setVisibility(0);
        this.cMW.setVisibility(0);
        fw(z);
        return true;
    }

    private void atH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cMW, "translationY", 0.0f, com.baidu.swan.apps.u.a.afX().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.cMW.setVisibility(8);
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

    private void fw(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cMW, "translationY", com.baidu.swan.apps.u.a.afX().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(int i) {
        String uuid = UUID.randomUUID().toString();
        h.mK(uuid);
        hN(i);
        hM(i);
        if (this.cMX != i) {
            this.cMX = i;
            this.cMY.pause();
            this.cMY.b(com.baidu.swan.apps.model.b.bz(this.cNa.get(i).cFJ, f.ajb().aiI()), uuid);
            d.jr("switchTab");
            this.cMY.resume();
        }
    }

    private void hM(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.j jVar = this.cNa.get(i);
        String jt = this.cMY.jt(com.baidu.swan.apps.model.b.bz(jVar.cFJ, f.ajb().aiI()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", jVar.cFJ);
        hashMap.put("text", jVar.mText);
        hashMap.put("wvID", jt);
        f.ajb().a(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void hN(int i) {
        a(this.cMZ.get(this.cMX), this.cNa.get(this.cMX));
        b(this.cMZ.get(i), this.cNa.get(i));
    }

    public void pv(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cNa.size()) {
                if (!this.cNa.get(i2).cFJ.equals(str)) {
                    i = i2 + 1;
                } else {
                    hN(i2);
                    this.cMX = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.cMV == null || this.cMW == null) {
            return false;
        }
        hK(SwanAppConfigData.dV(str4));
        pu(str3);
        pw(str);
        px(str2);
        Iterator<SwanAppBottomTabIconView> it = this.cMZ.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.atJ()) {
                next.setTextColor(SwanAppConfigData.dV(str2));
            } else {
                next.setTextColor(SwanAppConfigData.dV(str));
            }
        }
        return true;
    }

    private void pw(String str) {
        this.cNb = str;
    }

    private void px(String str) {
        this.cNc = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hR(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.cMZ.get(i);
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.cNa.get(i).cFK = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.cNa.get(i).cFL = str3;
        }
        if (swanAppBottomTabIconView.atJ()) {
            return b(swanAppBottomTabIconView, this.cNa.get(i));
        }
        return a(swanAppBottomTabIconView, this.cNa.get(i));
    }

    public boolean hO(int i) {
        if (!hR(i)) {
            return false;
        }
        this.cMZ.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hP(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hR(i) && (swanAppBottomTabIconView = this.cMZ.get(i)) != null) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setRedDotVisibleState(false);
                }
            });
            return true;
        }
        return false;
    }

    public boolean X(int i, String str) {
        if (!hR(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.cMZ.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hQ(int i) {
        if (hR(i)) {
            this.cMZ.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hR(int i) {
        return this.cMZ != null && i < this.cMZ.size() && i >= 0;
    }

    public int py(String str) {
        if (TextUtils.isEmpty(str) || this.cNa == null || this.cNa.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cNa.size()) {
                return -1;
            }
            SwanAppConfigData.j jVar = this.cNa.get(i2);
            if (jVar == null || !TextUtils.equals(jVar.cFJ, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout atI() {
        return this.cMW;
    }
}
