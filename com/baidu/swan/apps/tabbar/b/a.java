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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private String dAA;
    private View dAt;
    private LinearLayout dAu;
    private int dAv = 0;
    private e dAw;
    private ArrayList<SwanAppBottomTabIconView> dAx;
    private ArrayList<SwanAppConfigData.k> dAy;
    private String dAz;
    private SwanAppConfigData.j drV;

    public a(e eVar) {
        this.dAw = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dAw.ani()) {
            SwanAppConfigData ayL = f.azg().ayL();
            if (ayL == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.drV = ayL.drV;
            this.dAy = this.drV.dsA;
            int size = this.dAy.size();
            this.dAx = new ArrayList<>(size);
            this.dAt = view.findViewById(a.f.bottom_bar_shadow);
            as(this.drV.dsz, this.drV.mBackgroundColor);
            this.dAu = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dAu.setVisibility(0);
            this.dAu.setBackgroundColor(this.drV.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dAy.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.dsB, !TextUtils.isEmpty(str) ? str : f.azg().ayP()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dAv = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.lb(i);
                    }
                });
                this.dAx.add(swanAppBottomTabIconView);
                this.dAu.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean aoa() {
        return this.dAu != null && this.dAu.getVisibility() == 0;
    }

    private void as(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dAt.setVisibility(0);
                this.dAt.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dAt.setVisibility(0);
                this.dAt.setBackgroundColor(i2);
            } else {
                this.dAt.setVisibility(0);
                this.dAt.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void tO(String str) {
        this.dAu.setBackgroundColor(SwanAppConfigData.sa(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b afs = afs();
        if (afs == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(afs);
        if (TextUtils.isEmpty(k)) {
            k = d.C0462d.bM(afs.getAppId(), afs.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dsC;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dAz == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.drV.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.sa(a.this.dAz));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b afs = afs();
        if (afs == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(afs);
        if (TextUtils.isEmpty(k)) {
            k = d.C0462d.bM(afs.getAppId(), afs.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dsD;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dAA == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.drV.dsy);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.sa(a.this.dAA));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b afs() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null) {
            return aGM.afg();
        }
        return null;
    }

    public boolean gQ(boolean z) {
        if (this.dAt == null || this.dAu == null) {
            return false;
        }
        this.dAt.setVisibility(8);
        if (z) {
            aKW();
        } else {
            this.dAu.setVisibility(8);
        }
        return true;
    }

    public boolean gR(boolean z) {
        if (this.dAt == null || this.dAu == null) {
            return false;
        }
        this.dAt.setVisibility(0);
        this.dAu.setVisibility(0);
        gS(z);
        return true;
    }

    private void aKW() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dAu, "translationY", 0.0f, com.baidu.swan.apps.t.a.avS().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dAu.setVisibility(8);
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

    private void gS(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dAu, "translationY", com.baidu.swan.apps.t.a.avS().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb(int i) {
        String uuid = UUID.randomUUID().toString();
        j.qR(uuid);
        ld(i);
        lc(i);
        if (this.dAv != i) {
            this.dAv = i;
            this.dAw.pause();
            this.dAw.b(com.baidu.swan.apps.model.b.ca(this.dAy.get(i).dsB, f.azg().ayN()), uuid);
            e.mP("switchTab");
            this.dAw.resume();
        }
    }

    private void lc(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dAy.get(i);
        String mR = this.dAw.mR(com.baidu.swan.apps.model.b.ca(kVar.dsB, f.azg().ayN()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.dsB);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", mR);
        f.azg().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void ld(int i) {
        a(this.dAx.get(this.dAv), this.dAy.get(this.dAv));
        b(this.dAx.get(i), this.dAy.get(i));
    }

    public void tP(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dAy.size()) {
                if (!this.dAy.get(i2).dsB.equals(str)) {
                    i = i2 + 1;
                } else {
                    ld(i2);
                    this.dAv = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dAt == null || this.dAu == null) {
            return false;
        }
        as(SwanAppConfigData.sa(str4), SwanAppConfigData.sa(str3));
        tO(str3);
        tQ(str);
        tR(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dAx.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aKY()) {
                next.setTextColor(SwanAppConfigData.sa(str2));
            } else {
                next.setTextColor(SwanAppConfigData.sa(str));
            }
        }
        return true;
    }

    private void tQ(String str) {
        this.dAz = str;
    }

    private void tR(String str) {
        this.dAA = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!lh(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dAx.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dAy.get(i).dsC = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dAy.get(i).dsD = str3;
        }
        if (swanAppBottomTabIconView.aKY()) {
            return b(swanAppBottomTabIconView, this.dAy.get(i));
        }
        return a(swanAppBottomTabIconView, this.dAy.get(i));
    }

    public boolean le(int i) {
        if (!lh(i)) {
            return false;
        }
        this.dAx.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean lf(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (lh(i) && (swanAppBottomTabIconView = this.dAx.get(i)) != null) {
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
        if (!lh(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dAx.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean lg(int i) {
        if (lh(i)) {
            this.dAx.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean lh(int i) {
        return this.dAx != null && i < this.dAx.size() && i >= 0;
    }

    public int tS(String str) {
        if (TextUtils.isEmpty(str) || this.dAy == null || this.dAy.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dAy.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dAy.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.dsB, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aKX() {
        return this.dAu;
    }
}
