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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private View dHr;
    private LinearLayout dHs;
    private int dHt = 0;
    private e dHu;
    private ArrayList<SwanAppBottomTabIconView> dHv;
    private ArrayList<SwanAppConfigData.k> dHw;
    private String dHx;
    private String dHy;
    private SwanAppConfigData.j dyW;

    public a(e eVar) {
        this.dHu = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dHu.aqq()) {
            SwanAppConfigData aBU = f.aCp().aBU();
            if (aBU == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dyW = aBU.dyW;
            this.dHw = this.dyW.dzA;
            int size = this.dHw.size();
            this.dHv = new ArrayList<>(size);
            this.dHr = view.findViewById(a.f.bottom_bar_shadow);
            au(this.dyW.dzz, this.dyW.mBackgroundColor);
            this.dHs = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dHs.setVisibility(0);
            this.dHs.setBackgroundColor(this.dyW.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dHw.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.dzB, !TextUtils.isEmpty(str) ? str : f.aCp().aBY()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dHt = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.lz(i);
                    }
                });
                this.dHv.add(swanAppBottomTabIconView);
                this.dHs.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean ari() {
        return this.dHs != null && this.dHs.getVisibility() == 0;
    }

    private void au(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dHr.setVisibility(0);
                this.dHr.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dHr.setVisibility(0);
                this.dHr.setBackgroundColor(i2);
            } else {
                this.dHr.setVisibility(0);
                this.dHr.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void uv(String str) {
        this.dHs.setBackgroundColor(SwanAppConfigData.sI(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b aiA = aiA();
        if (aiA == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(aiA);
        if (TextUtils.isEmpty(k)) {
            k = d.C0474d.bT(aiA.getAppId(), aiA.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dzC;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dHx == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dyW.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.sI(a.this.dHx));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b aiA = aiA();
        if (aiA == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(aiA);
        if (TextUtils.isEmpty(k)) {
            k = d.C0474d.bT(aiA.getAppId(), aiA.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dzD;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dHy == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dyW.dzy);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.sI(a.this.dHy));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b aiA() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null) {
            return aJU.aio();
        }
        return null;
    }

    public boolean hf(boolean z) {
        if (this.dHr == null || this.dHs == null) {
            return false;
        }
        this.dHr.setVisibility(8);
        if (z) {
            aOd();
        } else {
            this.dHs.setVisibility(8);
        }
        return true;
    }

    public boolean hg(boolean z) {
        if (this.dHr == null || this.dHs == null) {
            return false;
        }
        this.dHr.setVisibility(0);
        this.dHs.setVisibility(0);
        hh(z);
        return true;
    }

    private void aOd() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dHs, "translationY", 0.0f, com.baidu.swan.apps.t.a.aza().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dHs.setVisibility(8);
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

    private void hh(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dHs, "translationY", com.baidu.swan.apps.t.a.aza().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz(int i) {
        String uuid = UUID.randomUUID().toString();
        j.ry(uuid);
        lB(i);
        lA(i);
        if (this.dHt != i) {
            this.dHt = i;
            this.dHu.pause();
            this.dHu.b(com.baidu.swan.apps.model.b.ch(this.dHw.get(i).dzB, f.aCp().aBW()), uuid);
            e.nw("switchTab");
            this.dHu.resume();
        }
    }

    private void lA(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dHw.get(i);
        String ny = this.dHu.ny(com.baidu.swan.apps.model.b.ch(kVar.dzB, f.aCp().aBW()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.dzB);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", ny);
        f.aCp().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void lB(int i) {
        a(this.dHv.get(this.dHt), this.dHw.get(this.dHt));
        b(this.dHv.get(i), this.dHw.get(i));
    }

    public void uw(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dHw.size()) {
                if (!this.dHw.get(i2).dzB.equals(str)) {
                    i = i2 + 1;
                } else {
                    lB(i2);
                    this.dHt = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dHr == null || this.dHs == null) {
            return false;
        }
        au(SwanAppConfigData.sI(str4), SwanAppConfigData.sI(str3));
        uv(str3);
        ux(str);
        uy(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dHv.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aOf()) {
                next.setTextColor(SwanAppConfigData.sI(str2));
            } else {
                next.setTextColor(SwanAppConfigData.sI(str));
            }
        }
        return true;
    }

    private void ux(String str) {
        this.dHx = str;
    }

    private void uy(String str) {
        this.dHy = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!lF(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dHv.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dHw.get(i).dzC = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dHw.get(i).dzD = str3;
        }
        if (swanAppBottomTabIconView.aOf()) {
            return b(swanAppBottomTabIconView, this.dHw.get(i));
        }
        return a(swanAppBottomTabIconView, this.dHw.get(i));
    }

    public boolean lC(int i) {
        if (!lF(i)) {
            return false;
        }
        this.dHv.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean lD(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (lF(i) && (swanAppBottomTabIconView = this.dHv.get(i)) != null) {
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

    public boolean ao(int i, String str) {
        if (!lF(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dHv.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean lE(int i) {
        if (lF(i)) {
            this.dHv.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean lF(int i) {
        return this.dHv != null && i < this.dHv.size() && i >= 0;
    }

    public int uz(String str) {
        if (TextUtils.isEmpty(str) || this.dHw == null || this.dHw.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dHw.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dHw.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.dzB, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aOe() {
        return this.dHs;
    }
}
