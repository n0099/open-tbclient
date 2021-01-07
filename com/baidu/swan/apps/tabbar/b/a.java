package com.baidu.swan.apps.tabbar.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j dHB;
    private View dPW;
    private LinearLayout dPX;
    private int dPY = 0;
    private e dPZ;
    private ArrayList<SwanAppBottomTabIconView> dQa;
    private ArrayList<SwanAppConfigData.k> dQb;
    private String dQc;
    private String dQd;

    public a(e eVar) {
        this.dPZ = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dPZ.arD()) {
            SwanAppConfigData aDm = f.aDH().aDm();
            if (aDm == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dHB = aDm.dHB;
            this.dQb = this.dHB.dIf;
            int size = this.dQb.size();
            this.dQa = new ArrayList<>(size);
            this.dPW = view.findViewById(a.f.bottom_bar_shadow);
            aq(this.dHB.dIe, this.dHB.mBackgroundColor);
            this.dPX = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dPX.setVisibility(0);
            this.dPX.setBackgroundColor(this.dHB.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dQb.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.dIg, !TextUtils.isEmpty(str) ? str : f.aDH().aDq()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dPY = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.lE(i);
                    }
                });
                this.dQa.add(swanAppBottomTabIconView);
                this.dPX.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean asB() {
        return this.dPX != null && this.dPX.getVisibility() == 0;
    }

    private void aq(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dPW.setVisibility(0);
                this.dPW.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dPW.setVisibility(0);
                this.dPW.setBackgroundColor(i2);
            } else {
                this.dPW.setVisibility(0);
                this.dPW.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void us(String str) {
        this.dPX.setBackgroundColor(SwanAppConfigData.sF(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b ajH = ajH();
        if (ajH == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(ajH);
        if (TextUtils.isEmpty(k)) {
            k = d.C0466d.bS(ajH.getAppId(), ajH.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dIh;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dQc == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dHB.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.sF(a.this.dQc));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b ajH = ajH();
        if (ajH == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(ajH);
        if (TextUtils.isEmpty(k)) {
            k = d.C0466d.bS(ajH.getAppId(), ajH.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dIi;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dQd == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dHB.dId);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.sF(a.this.dQd));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b ajH() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl != null) {
            return aMl.ajv();
        }
        return null;
    }

    public boolean hx(boolean z) {
        if (this.dPW == null || this.dPX == null) {
            return false;
        }
        this.dPW.setVisibility(8);
        if (z) {
            aQv();
        } else {
            this.dPX.setVisibility(8);
        }
        return true;
    }

    public boolean hy(boolean z) {
        if (this.dPW == null || this.dPX == null) {
            return false;
        }
        this.dPW.setVisibility(0);
        this.dPX.setVisibility(0);
        hz(z);
        return true;
    }

    private void aQv() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dPX, "translationY", 0.0f, com.baidu.swan.apps.t.a.aAs().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dPX.setVisibility(8);
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

    private void hz(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dPX, "translationY", com.baidu.swan.apps.t.a.aAs().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(int i) {
        String uuid = UUID.randomUUID().toString();
        j.rr(uuid);
        lG(i);
        lF(i);
        if (this.dPY != i) {
            this.dPY = i;
            this.dPZ.pause();
            this.dPZ.b(com.baidu.swan.apps.model.b.cg(this.dQb.get(i).dIg, f.aDH().aDo()), uuid);
            e.np("switchTab");
            this.dPZ.resume();
        }
    }

    private void lF(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dQb.get(i);
        String nr = this.dPZ.nr(com.baidu.swan.apps.model.b.cg(kVar.dIg, f.aDH().aDo()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.dIg);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", nr);
        f.aDH().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void lG(int i) {
        a(this.dQa.get(this.dPY), this.dQb.get(this.dPY));
        b(this.dQa.get(i), this.dQb.get(i));
    }

    public void ut(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dQb.size()) {
                if (!this.dQb.get(i2).dIg.equals(str)) {
                    i = i2 + 1;
                } else {
                    lG(i2);
                    this.dPY = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dPW == null || this.dPX == null) {
            return false;
        }
        aq(SwanAppConfigData.sF(str4), SwanAppConfigData.sF(str3));
        us(str3);
        uu(str);
        uv(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dQa.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aQx()) {
                next.setTextColor(SwanAppConfigData.sF(str2));
            } else {
                next.setTextColor(SwanAppConfigData.sF(str));
            }
        }
        return true;
    }

    private void uu(String str) {
        this.dQc = str;
    }

    private void uv(String str) {
        this.dQd = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!lK(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dQa.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dQb.get(i).dIh = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dQb.get(i).dIi = str3;
        }
        if (swanAppBottomTabIconView.aQx()) {
            return b(swanAppBottomTabIconView, this.dQb.get(i));
        }
        return a(swanAppBottomTabIconView, this.dQb.get(i));
    }

    public boolean lH(int i) {
        if (!lK(i)) {
            return false;
        }
        this.dQa.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean lI(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (lK(i) && (swanAppBottomTabIconView = this.dQa.get(i)) != null) {
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

    public boolean aq(int i, String str) {
        if (!lK(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dQa.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean lJ(int i) {
        if (lK(i)) {
            this.dQa.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean lK(int i) {
        return this.dQa != null && i < this.dQa.size() && i >= 0;
    }

    public int uw(String str) {
        if (TextUtils.isEmpty(str) || this.dQb == null || this.dQb.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dQb.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dQb.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.dIg, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aQw() {
        return this.dPX;
    }
}
