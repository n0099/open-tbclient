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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j cQZ;
    private ArrayList<SwanAppBottomTabIconView> cZA;
    private ArrayList<SwanAppConfigData.k> cZB;
    private String cZC;
    private String cZD;
    private View cZw;
    private LinearLayout cZx;
    private int cZy = 0;
    private e cZz;

    public a(e eVar) {
        this.cZz = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.cZz.agb()) {
            SwanAppConfigData arD = f.arY().arD();
            if (arD == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.cQZ = arD.cQZ;
            this.cZB = this.cQZ.cRD;
            int size = this.cZB.size();
            this.cZA = new ArrayList<>(size);
            this.cZw = view.findViewById(a.f.bottom_bar_shadow);
            as(this.cQZ.cRC, this.cQZ.mBackgroundColor);
            this.cZx = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.cZx.setVisibility(0);
            this.cZx.setBackgroundColor(this.cQZ.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.cZB.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.cRE, !TextUtils.isEmpty(str) ? str : f.arY().arH()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.cZy = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.kc(i);
                    }
                });
                this.cZA.add(swanAppBottomTabIconView);
                this.cZx.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean agT() {
        return this.cZx != null && this.cZx.getVisibility() == 0;
    }

    private void as(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.cZw.setVisibility(0);
                this.cZw.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.cZw.setVisibility(0);
                this.cZw.setBackgroundColor(i2);
            } else {
                this.cZw.setVisibility(0);
                this.cZw.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void sg(String str) {
        this.cZx.setBackgroundColor(SwanAppConfigData.fo(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b Yl = Yl();
        if (Yl == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(Yl);
        if (TextUtils.isEmpty(k)) {
            k = d.C0426d.bB(Yl.getAppId(), Yl.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.cRF;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cZC == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cQZ.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fo(a.this.cZC));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b Yl = Yl();
        if (Yl == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(Yl);
        if (TextUtils.isEmpty(k)) {
            k = d.C0426d.bB(Yl.getAppId(), Yl.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.cRG;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cZD == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cQZ.cRB);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fo(a.this.cZD));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b Yl() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null) {
            return azI.XZ();
        }
        return null;
    }

    public boolean fX(boolean z) {
        if (this.cZw == null || this.cZx == null) {
            return false;
        }
        this.cZw.setVisibility(8);
        if (z) {
            aDR();
        } else {
            this.cZx.setVisibility(8);
        }
        return true;
    }

    public boolean fY(boolean z) {
        if (this.cZw == null || this.cZx == null) {
            return false;
        }
        this.cZw.setVisibility(0);
        this.cZx.setVisibility(0);
        fZ(z);
        return true;
    }

    private void aDR() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cZx, "translationY", 0.0f, com.baidu.swan.apps.t.a.aoJ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.cZx.setVisibility(8);
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

    private void fZ(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cZx, "translationY", com.baidu.swan.apps.t.a.aoJ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc(int i) {
        String uuid = UUID.randomUUID().toString();
        j.pl(uuid);
        ke(i);
        kd(i);
        if (this.cZy != i) {
            this.cZy = i;
            this.cZz.pause();
            this.cZz.b(com.baidu.swan.apps.model.b.bP(this.cZB.get(i).cRE, f.arY().arF()), uuid);
            e.li("switchTab");
            this.cZz.resume();
        }
    }

    private void kd(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.cZB.get(i);
        String lk = this.cZz.lk(com.baidu.swan.apps.model.b.bP(kVar.cRE, f.arY().arF()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.cRE);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", lk);
        f.arY().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void ke(int i) {
        a(this.cZA.get(this.cZy), this.cZB.get(this.cZy));
        b(this.cZA.get(i), this.cZB.get(i));
    }

    public void sh(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cZB.size()) {
                if (!this.cZB.get(i2).cRE.equals(str)) {
                    i = i2 + 1;
                } else {
                    ke(i2);
                    this.cZy = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.cZw == null || this.cZx == null) {
            return false;
        }
        as(SwanAppConfigData.fo(str4), SwanAppConfigData.fo(str3));
        sg(str3);
        si(str);
        sj(str2);
        Iterator<SwanAppBottomTabIconView> it = this.cZA.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aDT()) {
                next.setTextColor(SwanAppConfigData.fo(str2));
            } else {
                next.setTextColor(SwanAppConfigData.fo(str));
            }
        }
        return true;
    }

    private void si(String str) {
        this.cZC = str;
    }

    private void sj(String str) {
        this.cZD = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!ki(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.cZA.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.cZB.get(i).cRF = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.cZB.get(i).cRG = str3;
        }
        if (swanAppBottomTabIconView.aDT()) {
            return b(swanAppBottomTabIconView, this.cZB.get(i));
        }
        return a(swanAppBottomTabIconView, this.cZB.get(i));
    }

    public boolean kf(int i) {
        if (!ki(i)) {
            return false;
        }
        this.cZA.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kg(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (ki(i) && (swanAppBottomTabIconView = this.cZA.get(i)) != null) {
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

    public boolean W(int i, String str) {
        if (!ki(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.cZA.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean kh(int i) {
        if (ki(i)) {
            this.cZA.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean ki(int i) {
        return this.cZA != null && i < this.cZA.size() && i >= 0;
    }

    public int sk(String str) {
        if (TextUtils.isEmpty(str) || this.cZB == null || this.cZB.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cZB.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.cZB.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.cRE, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aDS() {
        return this.cZx;
    }
}
