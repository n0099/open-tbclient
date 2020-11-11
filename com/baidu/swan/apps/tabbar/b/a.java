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
    private View dCa;
    private LinearLayout dCb;
    private int dCc = 0;
    private e dCd;
    private ArrayList<SwanAppBottomTabIconView> dCe;
    private ArrayList<SwanAppConfigData.k> dCf;
    private String dCg;
    private String dCh;
    private SwanAppConfigData.j dtE;

    public a(e eVar) {
        this.dCd = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dCd.anQ()) {
            SwanAppConfigData azt = f.azO().azt();
            if (azt == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dtE = azt.dtE;
            this.dCf = this.dtE.dui;
            int size = this.dCf.size();
            this.dCe = new ArrayList<>(size);
            this.dCa = view.findViewById(a.f.bottom_bar_shadow);
            as(this.dtE.duh, this.dtE.mBackgroundColor);
            this.dCb = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dCb.setVisibility(0);
            this.dCb.setBackgroundColor(this.dtE.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dCf.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.duj, !TextUtils.isEmpty(str) ? str : f.azO().azx()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dCc = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.lf(i);
                    }
                });
                this.dCe.add(swanAppBottomTabIconView);
                this.dCb.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean aoI() {
        return this.dCb != null && this.dCb.getVisibility() == 0;
    }

    private void as(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dCa.setVisibility(0);
                this.dCa.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dCa.setVisibility(0);
                this.dCa.setBackgroundColor(i2);
            } else {
                this.dCa.setVisibility(0);
                this.dCa.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void tT(String str) {
        this.dCb.setBackgroundColor(SwanAppConfigData.fv(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b aga = aga();
        if (aga == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(aga);
        if (TextUtils.isEmpty(k)) {
            k = d.C0464d.bN(aga.getAppId(), aga.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.duk;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dCg == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dtE.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fv(a.this.dCg));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b aga = aga();
        if (aga == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(aga);
        if (TextUtils.isEmpty(k)) {
            k = d.C0464d.bN(aga.getAppId(), aga.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dul;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dCh == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dtE.dug);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fv(a.this.dCh));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b aga() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null) {
            return aHu.afO();
        }
        return null;
    }

    public boolean gN(boolean z) {
        if (this.dCa == null || this.dCb == null) {
            return false;
        }
        this.dCa.setVisibility(8);
        if (z) {
            aLE();
        } else {
            this.dCb.setVisibility(8);
        }
        return true;
    }

    public boolean gO(boolean z) {
        if (this.dCa == null || this.dCb == null) {
            return false;
        }
        this.dCa.setVisibility(0);
        this.dCb.setVisibility(0);
        gP(z);
        return true;
    }

    private void aLE() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dCb, "translationY", 0.0f, com.baidu.swan.apps.t.a.awA().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dCb.setVisibility(8);
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

    private void gP(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dCb, "translationY", com.baidu.swan.apps.t.a.awA().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf(int i) {
        String uuid = UUID.randomUUID().toString();
        j.qX(uuid);
        lh(i);
        lg(i);
        if (this.dCc != i) {
            this.dCc = i;
            this.dCd.pause();
            this.dCd.b(com.baidu.swan.apps.model.b.cb(this.dCf.get(i).duj, f.azO().azv()), uuid);
            e.mV("switchTab");
            this.dCd.resume();
        }
    }

    private void lg(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dCf.get(i);
        String mX = this.dCd.mX(com.baidu.swan.apps.model.b.cb(kVar.duj, f.azO().azv()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.duj);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", mX);
        f.azO().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void lh(int i) {
        a(this.dCe.get(this.dCc), this.dCf.get(this.dCc));
        b(this.dCe.get(i), this.dCf.get(i));
    }

    public void tU(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dCf.size()) {
                if (!this.dCf.get(i2).duj.equals(str)) {
                    i = i2 + 1;
                } else {
                    lh(i2);
                    this.dCc = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dCa == null || this.dCb == null) {
            return false;
        }
        as(SwanAppConfigData.fv(str4), SwanAppConfigData.fv(str3));
        tT(str3);
        tV(str);
        tW(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dCe.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aLG()) {
                next.setTextColor(SwanAppConfigData.fv(str2));
            } else {
                next.setTextColor(SwanAppConfigData.fv(str));
            }
        }
        return true;
    }

    private void tV(String str) {
        this.dCg = str;
    }

    private void tW(String str) {
        this.dCh = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!ll(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dCe.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dCf.get(i).duk = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dCf.get(i).dul = str3;
        }
        if (swanAppBottomTabIconView.aLG()) {
            return b(swanAppBottomTabIconView, this.dCf.get(i));
        }
        return a(swanAppBottomTabIconView, this.dCf.get(i));
    }

    public boolean li(int i) {
        if (!ll(i)) {
            return false;
        }
        this.dCe.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean lj(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (ll(i) && (swanAppBottomTabIconView = this.dCe.get(i)) != null) {
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
        if (!ll(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dCe.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean lk(int i) {
        if (ll(i)) {
            this.dCe.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean ll(int i) {
        return this.dCe != null && i < this.dCe.size() && i >= 0;
    }

    public int tX(String str) {
        if (TextUtils.isEmpty(str) || this.dCf == null || this.dCf.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dCf.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dCf.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.duj, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aLF() {
        return this.dCb;
    }
}
