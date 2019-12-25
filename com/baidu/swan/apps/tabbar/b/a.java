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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.d.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.g bKQ;
    private View bSJ;
    private LinearLayout bSK;
    private int bSL = 0;
    private d bSM;
    private ArrayList<SwanAppBottomTabIconView> bSN;
    private ArrayList<SwanAppConfigData.h> bSO;
    private String bSP;
    private String bSQ;

    public a(d dVar) {
        this.bSM = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.bSM.KJ()) {
            SwanAppConfigData TL = f.Uf().TL();
            if (TL == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bKQ = TL.bKQ;
            this.bSO = this.bKQ.bLo;
            int size = this.bSO.size();
            this.bSN = new ArrayList<>(size);
            this.bSJ = view.findViewById(a.f.bottom_bar_shadow);
            gF(this.bKQ.bLn);
            this.bSK = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.bSK.setVisibility(0);
            this.bSK.setBackgroundColor(this.bKQ.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.bSO.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.bLp, !TextUtils.isEmpty(str) ? str : f.Uf().TP()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.bSL = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, hVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(hVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.gG(i);
                    }
                });
                this.bSN.add(swanAppBottomTabIconView);
                this.bSK.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean Lk() {
        return this.bSK != null && this.bSK.getVisibility() == 0;
    }

    private void gF(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.bSJ.setVisibility(0);
                this.bSJ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.bSJ.setVisibility(0);
                this.bSJ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.bSJ.setVisibility(0);
                this.bSJ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void mb(String str) {
        this.bSK.setBackgroundColor(SwanAppConfigData.cy(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b Ef = Ef();
        if (Ef == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(Ef);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aA(Ef.getAppId(), Ef.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bLq;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bSP == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bKQ.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cy(a.this.bSP));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b Ef = Ef();
        if (Ef == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(Ef);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aA(Ef.getAppId(), Ef.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bLr;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bSQ == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bKQ.bLm);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cy(a.this.bSQ));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.x.b.b Ef() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null) {
            return ZS.DR();
        }
        return null;
    }

    public boolean dM(boolean z) {
        if (this.bSJ == null || this.bSK == null) {
            return false;
        }
        this.bSJ.setVisibility(8);
        if (z) {
            ads();
        } else {
            this.bSK.setVisibility(8);
        }
        return true;
    }

    public boolean dN(boolean z) {
        if (this.bSJ == null || this.bSK == null) {
            return false;
        }
        this.bSJ.setVisibility(0);
        this.bSK.setVisibility(0);
        dO(z);
        return true;
    }

    private void ads() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bSK, "translationY", 0.0f, com.baidu.swan.apps.w.a.Rk().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.bSK.setVisibility(8);
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

    private void dO(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bSK, "translationY", com.baidu.swan.apps.w.a.Rk().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(int i) {
        String uuid = UUID.randomUUID().toString();
        g.jJ(uuid);
        gI(i);
        gH(i);
        if (this.bSL != i) {
            this.bSL = i;
            this.bSM.pause();
            this.bSM.b(com.baidu.swan.apps.model.b.aN(this.bSO.get(i).bLp, f.Uf().TN()), uuid);
            d dVar = this.bSM;
            d.gD("switchTab");
            this.bSM.resume();
        }
    }

    private void gH(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.bSO.get(i);
        String gF = this.bSM.gF(com.baidu.swan.apps.model.b.aN(hVar.bLp, f.Uf().TN()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.bLp);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", gF);
        f.Uf().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void gI(int i) {
        a(this.bSN.get(this.bSL), this.bSO.get(this.bSL));
        b(this.bSN.get(i), this.bSO.get(i));
    }

    public void mc(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bSO.size()) {
                if (!this.bSO.get(i2).bLp.equals(str)) {
                    i = i2 + 1;
                } else {
                    gI(i2);
                    this.bSL = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean o(String str, String str2, String str3, String str4) {
        if (this.bSJ == null || this.bSK == null) {
            return false;
        }
        gF(SwanAppConfigData.cy(str4));
        mb(str3);
        md(str);
        me(str2);
        Iterator<SwanAppBottomTabIconView> it = this.bSN.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.adt()) {
                next.setTextColor(SwanAppConfigData.cy(str2));
            } else {
                next.setTextColor(SwanAppConfigData.cy(str));
            }
        }
        return true;
    }

    private void md(String str) {
        this.bSP = str;
    }

    private void me(String str) {
        this.bSQ = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!gM(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.bSN.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.bSO.get(i).bLq = str2;
        this.bSO.get(i).bLr = str3;
        if (swanAppBottomTabIconView.adt()) {
            return b(swanAppBottomTabIconView, this.bSO.get(i));
        }
        return a(swanAppBottomTabIconView, this.bSO.get(i));
    }

    public boolean gJ(int i) {
        if (!gM(i)) {
            return false;
        }
        this.bSN.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean gK(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (gM(i) && (swanAppBottomTabIconView = this.bSN.get(i)) != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setRedDotVisibleState(false);
                }
            });
            return true;
        }
        return false;
    }

    public boolean z(int i, String str) {
        if (!gM(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bSN.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean gL(int i) {
        if (gM(i)) {
            this.bSN.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean gM(int i) {
        return this.bSN != null && i < this.bSN.size() && i >= 0;
    }

    public int mf(String str) {
        if (TextUtils.isEmpty(str) || this.bSO == null || this.bSO.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bSO.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.bSO.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.bLp, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
