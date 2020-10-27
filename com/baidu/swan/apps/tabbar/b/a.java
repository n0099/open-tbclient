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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.performance.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.v.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j dnH;
    private View dwi;
    private LinearLayout dwj;
    private int dwk = 0;
    private e dwl;
    private ArrayList<SwanAppBottomTabIconView> dwm;
    private ArrayList<SwanAppConfigData.k> dwn;
    private String dwo;
    private String dwp;

    public a(e eVar) {
        this.dwl = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dwl.alq()) {
            SwanAppConfigData awT = f.axo().awT();
            if (awT == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dnH = awT.dnH;
            this.dwn = this.dnH.dom;
            int size = this.dwn.size();
            this.dwm = new ArrayList<>(size);
            this.dwi = view.findViewById(a.f.bottom_bar_shadow);
            as(this.dnH.dol, this.dnH.mBackgroundColor);
            this.dwj = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dwj.setVisibility(0);
            this.dwj.setBackgroundColor(this.dnH.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dwn.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.don, !TextUtils.isEmpty(str) ? str : f.axo().awX()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dwk = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.kV(i);
                    }
                });
                this.dwm.add(swanAppBottomTabIconView);
                this.dwj.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean ami() {
        return this.dwj != null && this.dwj.getVisibility() == 0;
    }

    private void as(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dwi.setVisibility(0);
                this.dwi.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dwi.setVisibility(0);
                this.dwi.setBackgroundColor(i2);
            } else {
                this.dwi.setVisibility(0);
                this.dwi.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void tF(String str) {
        this.dwj.setBackgroundColor(SwanAppConfigData.fv(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b adA = adA();
        if (adA == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(adA);
        if (TextUtils.isEmpty(k)) {
            k = d.C0452d.bN(adA.getAppId(), adA.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.doo;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dwo == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dnH.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fv(a.this.dwo));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b adA = adA();
        if (adA == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(adA);
        if (TextUtils.isEmpty(k)) {
            k = d.C0452d.bN(adA.getAppId(), adA.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dop;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dwp == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dnH.dok);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fv(a.this.dwp));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b adA() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null) {
            return aEU.ado();
        }
        return null;
    }

    public boolean gE(boolean z) {
        if (this.dwi == null || this.dwj == null) {
            return false;
        }
        this.dwi.setVisibility(8);
        if (z) {
            aJe();
        } else {
            this.dwj.setVisibility(8);
        }
        return true;
    }

    public boolean gF(boolean z) {
        if (this.dwi == null || this.dwj == null) {
            return false;
        }
        this.dwi.setVisibility(0);
        this.dwj.setVisibility(0);
        gG(z);
        return true;
    }

    private void aJe() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dwj, "translationY", 0.0f, com.baidu.swan.apps.t.a.aua().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dwj.setVisibility(8);
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

    private void gG(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dwj, "translationY", com.baidu.swan.apps.t.a.aua().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV(int i) {
        String uuid = UUID.randomUUID().toString();
        j.qJ(uuid);
        kX(i);
        kW(i);
        if (this.dwk != i) {
            this.dwk = i;
            this.dwl.pause();
            this.dwl.b(com.baidu.swan.apps.model.b.cb(this.dwn.get(i).don, f.axo().awV()), uuid);
            e.mG("switchTab");
            this.dwl.resume();
        }
    }

    private void kW(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dwn.get(i);
        String mI = this.dwl.mI(com.baidu.swan.apps.model.b.cb(kVar.don, f.axo().awV()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.don);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", mI);
        f.axo().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void kX(int i) {
        a(this.dwm.get(this.dwk), this.dwn.get(this.dwk));
        b(this.dwm.get(i), this.dwn.get(i));
    }

    public void tG(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dwn.size()) {
                if (!this.dwn.get(i2).don.equals(str)) {
                    i = i2 + 1;
                } else {
                    kX(i2);
                    this.dwk = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dwi == null || this.dwj == null) {
            return false;
        }
        as(SwanAppConfigData.fv(str4), SwanAppConfigData.fv(str3));
        tF(str3);
        tH(str);
        tI(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dwm.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aJg()) {
                next.setTextColor(SwanAppConfigData.fv(str2));
            } else {
                next.setTextColor(SwanAppConfigData.fv(str));
            }
        }
        return true;
    }

    private void tH(String str) {
        this.dwo = str;
    }

    private void tI(String str) {
        this.dwp = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!lb(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dwm.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dwn.get(i).doo = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dwn.get(i).dop = str3;
        }
        if (swanAppBottomTabIconView.aJg()) {
            return b(swanAppBottomTabIconView, this.dwn.get(i));
        }
        return a(swanAppBottomTabIconView, this.dwn.get(i));
    }

    public boolean kY(int i) {
        if (!lb(i)) {
            return false;
        }
        this.dwm.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kZ(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (lb(i) && (swanAppBottomTabIconView = this.dwm.get(i)) != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setRedDotVisibleState(false);
                }
            });
            return true;
        }
        return false;
    }

    public boolean ak(int i, String str) {
        if (!lb(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dwm.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean la(int i) {
        if (lb(i)) {
            this.dwm.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean lb(int i) {
        return this.dwm != null && i < this.dwm.size() && i >= 0;
    }

    public int tJ(String str) {
        if (TextUtils.isEmpty(str) || this.dwn == null || this.dwn.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dwn.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dwn.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.don, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aJf() {
        return this.dwj;
    }
}
