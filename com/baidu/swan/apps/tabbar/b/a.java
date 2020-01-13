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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.g bLA;
    private View bSV;
    private LinearLayout bSW;
    private int bSX = 0;
    private d bSY;
    private ArrayList<SwanAppBottomTabIconView> bSZ;
    private ArrayList<SwanAppConfigData.h> bTa;
    private String bTb;
    private String bTc;

    public a(d dVar) {
        this.bSY = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.bSY.Lf()) {
            SwanAppConfigData Ui = f.UC().Ui();
            if (Ui == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bLA = Ui.bLA;
            this.bTa = this.bLA.bLY;
            int size = this.bTa.size();
            this.bSZ = new ArrayList<>(size);
            this.bSV = view.findViewById(a.f.bottom_bar_shadow);
            gF(this.bLA.bLX);
            this.bSW = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.bSW.setVisibility(0);
            this.bSW.setBackgroundColor(this.bLA.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.bTa.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.bLZ, !TextUtils.isEmpty(str) ? str : f.UC().Um()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.bSX = i;
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
                this.bSZ.add(swanAppBottomTabIconView);
                this.bSW.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean LG() {
        return this.bSW != null && this.bSW.getVisibility() == 0;
    }

    private void gF(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.bSV.setVisibility(0);
                this.bSV.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.bSV.setVisibility(0);
                this.bSV.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.bSV.setVisibility(0);
                this.bSV.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void me(String str) {
        this.bSW.setBackgroundColor(SwanAppConfigData.cy(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b EB = EB();
        if (EB == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(EB);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aB(EB.getAppId(), EB.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bMa;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bTb == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bLA.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cy(a.this.bTb));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b EB = EB();
        if (EB == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(EB);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aB(EB.getAppId(), EB.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bMb;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bTc == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bLA.bLW);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cy(a.this.bTc));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.x.b.b EB() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null) {
            return aap.En();
        }
        return null;
    }

    public boolean dR(boolean z) {
        if (this.bSV == null || this.bSW == null) {
            return false;
        }
        this.bSV.setVisibility(8);
        if (z) {
            adL();
        } else {
            this.bSW.setVisibility(8);
        }
        return true;
    }

    public boolean dS(boolean z) {
        if (this.bSV == null || this.bSW == null) {
            return false;
        }
        this.bSV.setVisibility(0);
        this.bSW.setVisibility(0);
        dT(z);
        return true;
    }

    private void adL() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bSW, "translationY", 0.0f, com.baidu.swan.apps.w.a.RG().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.bSW.setVisibility(8);
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

    private void dT(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bSW, "translationY", com.baidu.swan.apps.w.a.RG().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(int i) {
        String uuid = UUID.randomUUID().toString();
        g.jM(uuid);
        gI(i);
        gH(i);
        if (this.bSX != i) {
            this.bSX = i;
            this.bSY.pause();
            this.bSY.b(com.baidu.swan.apps.model.b.aO(this.bTa.get(i).bLZ, f.UC().Uk()), uuid);
            d dVar = this.bSY;
            d.gG("switchTab");
            this.bSY.resume();
        }
    }

    private void gH(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.bTa.get(i);
        String gI = this.bSY.gI(com.baidu.swan.apps.model.b.aO(hVar.bLZ, f.UC().Uk()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.bLZ);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", gI);
        f.UC().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void gI(int i) {
        a(this.bSZ.get(this.bSX), this.bTa.get(this.bSX));
        b(this.bSZ.get(i), this.bTa.get(i));
    }

    public void mf(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bTa.size()) {
                if (!this.bTa.get(i2).bLZ.equals(str)) {
                    i = i2 + 1;
                } else {
                    gI(i2);
                    this.bSX = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean o(String str, String str2, String str3, String str4) {
        if (this.bSV == null || this.bSW == null) {
            return false;
        }
        gF(SwanAppConfigData.cy(str4));
        me(str3);
        mg(str);
        mh(str2);
        Iterator<SwanAppBottomTabIconView> it = this.bSZ.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.adM()) {
                next.setTextColor(SwanAppConfigData.cy(str2));
            } else {
                next.setTextColor(SwanAppConfigData.cy(str));
            }
        }
        return true;
    }

    private void mg(String str) {
        this.bTb = str;
    }

    private void mh(String str) {
        this.bTc = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!gM(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.bSZ.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.bTa.get(i).bMa = str2;
        this.bTa.get(i).bMb = str3;
        if (swanAppBottomTabIconView.adM()) {
            return b(swanAppBottomTabIconView, this.bTa.get(i));
        }
        return a(swanAppBottomTabIconView, this.bTa.get(i));
    }

    public boolean gJ(int i) {
        if (!gM(i)) {
            return false;
        }
        this.bSZ.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean gK(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (gM(i) && (swanAppBottomTabIconView = this.bSZ.get(i)) != null) {
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

    public boolean B(int i, String str) {
        if (!gM(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bSZ.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean gL(int i) {
        if (gM(i)) {
            this.bSZ.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean gM(int i) {
        return this.bSZ != null && i < this.bSZ.size() && i >= 0;
    }

    public int mi(String str) {
        if (TextUtils.isEmpty(str) || this.bTa == null || this.bTa.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bTa.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.bTa.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.bLZ, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
