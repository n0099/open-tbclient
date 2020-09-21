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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j cSZ;
    private int dbA = 0;
    private e dbB;
    private ArrayList<SwanAppBottomTabIconView> dbC;
    private ArrayList<SwanAppConfigData.k> dbD;
    private String dbE;
    private String dbF;
    private View dby;
    private LinearLayout dbz;

    public a(e eVar) {
        this.dbB = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dbB.agL()) {
            SwanAppConfigData aso = f.asJ().aso();
            if (aso == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.cSZ = aso.cSZ;
            this.dbD = this.cSZ.cTD;
            int size = this.dbD.size();
            this.dbC = new ArrayList<>(size);
            this.dby = view.findViewById(a.f.bottom_bar_shadow);
            as(this.cSZ.cTC, this.cSZ.mBackgroundColor);
            this.dbz = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dbz.setVisibility(0);
            this.dbz.setBackgroundColor(this.cSZ.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dbD.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.cTE, !TextUtils.isEmpty(str) ? str : f.asJ().ass()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dbA = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.kn(i);
                    }
                });
                this.dbC.add(swanAppBottomTabIconView);
                this.dbz.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean ahD() {
        return this.dbz != null && this.dbz.getVisibility() == 0;
    }

    private void as(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dby.setVisibility(0);
                this.dby.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dby.setVisibility(0);
                this.dby.setBackgroundColor(i2);
            } else {
                this.dby.setVisibility(0);
                this.dby.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void sA(String str) {
        this.dbz.setBackgroundColor(SwanAppConfigData.fq(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b YU = YU();
        if (YU == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(YU);
        if (TextUtils.isEmpty(k)) {
            k = d.C0421d.bB(YU.getAppId(), YU.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.cTF;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dbE == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cSZ.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fq(a.this.dbE));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b YU = YU();
        if (YU == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(YU);
        if (TextUtils.isEmpty(k)) {
            k = d.C0421d.bB(YU.getAppId(), YU.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.cTG;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dbF == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cSZ.cTB);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fq(a.this.dbF));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b YU() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null) {
            return aAr.YI();
        }
        return null;
    }

    public boolean fV(boolean z) {
        if (this.dby == null || this.dbz == null) {
            return false;
        }
        this.dby.setVisibility(8);
        if (z) {
            aEB();
        } else {
            this.dbz.setVisibility(8);
        }
        return true;
    }

    public boolean fW(boolean z) {
        if (this.dby == null || this.dbz == null) {
            return false;
        }
        this.dby.setVisibility(0);
        this.dbz.setVisibility(0);
        fX(z);
        return true;
    }

    private void aEB() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dbz, "translationY", 0.0f, com.baidu.swan.apps.t.a.apu().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dbz.setVisibility(8);
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

    private void fX(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dbz, "translationY", com.baidu.swan.apps.t.a.apu().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(int i) {
        String uuid = UUID.randomUUID().toString();
        j.pE(uuid);
        kp(i);
        ko(i);
        if (this.dbA != i) {
            this.dbA = i;
            this.dbB.pause();
            this.dbB.b(com.baidu.swan.apps.model.b.bP(this.dbD.get(i).cTE, f.asJ().asq()), uuid);
            e.lB("switchTab");
            this.dbB.resume();
        }
    }

    private void ko(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dbD.get(i);
        String lD = this.dbB.lD(com.baidu.swan.apps.model.b.bP(kVar.cTE, f.asJ().asq()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.cTE);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", lD);
        f.asJ().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void kp(int i) {
        a(this.dbC.get(this.dbA), this.dbD.get(this.dbA));
        b(this.dbC.get(i), this.dbD.get(i));
    }

    public void sB(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dbD.size()) {
                if (!this.dbD.get(i2).cTE.equals(str)) {
                    i = i2 + 1;
                } else {
                    kp(i2);
                    this.dbA = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.dby == null || this.dbz == null) {
            return false;
        }
        as(SwanAppConfigData.fq(str4), SwanAppConfigData.fq(str3));
        sA(str3);
        sC(str);
        sD(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dbC.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aED()) {
                next.setTextColor(SwanAppConfigData.fq(str2));
            } else {
                next.setTextColor(SwanAppConfigData.fq(str));
            }
        }
        return true;
    }

    private void sC(String str) {
        this.dbE = str;
    }

    private void sD(String str) {
        this.dbF = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!kt(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dbC.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dbD.get(i).cTF = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dbD.get(i).cTG = str3;
        }
        if (swanAppBottomTabIconView.aED()) {
            return b(swanAppBottomTabIconView, this.dbD.get(i));
        }
        return a(swanAppBottomTabIconView, this.dbD.get(i));
    }

    public boolean kq(int i) {
        if (!kt(i)) {
            return false;
        }
        this.dbC.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kr(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (kt(i) && (swanAppBottomTabIconView = this.dbC.get(i)) != null) {
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

    public boolean X(int i, String str) {
        if (!kt(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dbC.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean ks(int i) {
        if (kt(i)) {
            this.dbC.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean kt(int i) {
        return this.dbC != null && i < this.dbC.size() && i >= 0;
    }

    public int sE(String str) {
        if (TextUtils.isEmpty(str) || this.dbD == null || this.dbD.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dbD.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dbD.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.cTE, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aEC() {
        return this.dbz;
    }
}
