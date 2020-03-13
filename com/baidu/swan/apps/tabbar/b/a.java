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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.g bPH;
    private View bXb;
    private LinearLayout bXc;
    private int bXd = 0;
    private d bXe;
    private ArrayList<SwanAppBottomTabIconView> bXf;
    private ArrayList<SwanAppConfigData.h> bXg;
    private String bXh;
    private String bXi;

    public a(d dVar) {
        this.bXe = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.bXe.Nw()) {
            SwanAppConfigData Wy = f.WS().Wy();
            if (Wy == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bPH = Wy.bPH;
            this.bXg = this.bPH.bQf;
            int size = this.bXg.size();
            this.bXf = new ArrayList<>(size);
            this.bXb = view.findViewById(a.f.bottom_bar_shadow);
            gW(this.bPH.bQe);
            this.bXc = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.bXc.setVisibility(0);
            this.bXc.setBackgroundColor(this.bPH.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.bXg.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.bQg, !TextUtils.isEmpty(str) ? str : f.WS().WC()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.bXd = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, hVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(hVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.gX(i);
                    }
                });
                this.bXf.add(swanAppBottomTabIconView);
                this.bXc.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean NW() {
        return this.bXc != null && this.bXc.getVisibility() == 0;
    }

    private void gW(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.bXb.setVisibility(0);
                this.bXb.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.bXb.setVisibility(0);
                this.bXb.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.bXb.setVisibility(0);
                this.bXb.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void mt(String str) {
        this.bXc.setBackgroundColor(SwanAppConfigData.cG(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b GS = GS();
        if (GS == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(GS);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aL(GS.getAppId(), GS.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bQh;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXh == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPH.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cG(a.this.bXh));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b GS = GS();
        if (GS == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(GS);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aL(GS.getAppId(), GS.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bQi;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXi == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPH.bQd);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cG(a.this.bXi));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.x.b.b GS() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null) {
            return acF.GE();
        }
        return null;
    }

    public boolean dY(boolean z) {
        if (this.bXb == null || this.bXc == null) {
            return false;
        }
        this.bXb.setVisibility(8);
        if (z) {
            agb();
        } else {
            this.bXc.setVisibility(8);
        }
        return true;
    }

    public boolean dZ(boolean z) {
        if (this.bXb == null || this.bXc == null) {
            return false;
        }
        this.bXb.setVisibility(0);
        this.bXc.setVisibility(0);
        ea(z);
        return true;
    }

    private void agb() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXc, "translationY", 0.0f, com.baidu.swan.apps.w.a.TW().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.bXc.setVisibility(8);
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

    private void ea(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXc, "translationY", com.baidu.swan.apps.w.a.TW().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        String uuid = UUID.randomUUID().toString();
        g.kb(uuid);
        gZ(i);
        gY(i);
        if (this.bXd != i) {
            this.bXd = i;
            this.bXe.pause();
            this.bXe.b(com.baidu.swan.apps.model.b.aX(this.bXg.get(i).bQg, f.WS().WA()), uuid);
            d dVar = this.bXe;
            d.gV("switchTab");
            this.bXe.resume();
        }
    }

    private void gY(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.bXg.get(i);
        String gX = this.bXe.gX(com.baidu.swan.apps.model.b.aX(hVar.bQg, f.WS().WA()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.bQg);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", gX);
        f.WS().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void gZ(int i) {
        a(this.bXf.get(this.bXd), this.bXg.get(this.bXd));
        b(this.bXf.get(i), this.bXg.get(i));
    }

    public void mu(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bXg.size()) {
                if (!this.bXg.get(i2).bQg.equals(str)) {
                    i = i2 + 1;
                } else {
                    gZ(i2);
                    this.bXd = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.bXb == null || this.bXc == null) {
            return false;
        }
        gW(SwanAppConfigData.cG(str4));
        mt(str3);
        mv(str);
        mw(str2);
        Iterator<SwanAppBottomTabIconView> it = this.bXf.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.agc()) {
                next.setTextColor(SwanAppConfigData.cG(str2));
            } else {
                next.setTextColor(SwanAppConfigData.cG(str));
            }
        }
        return true;
    }

    private void mv(String str) {
        this.bXh = str;
    }

    private void mw(String str) {
        this.bXi = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hd(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXf.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.bXg.get(i).bQh = str2;
        this.bXg.get(i).bQi = str3;
        if (swanAppBottomTabIconView.agc()) {
            return b(swanAppBottomTabIconView, this.bXg.get(i));
        }
        return a(swanAppBottomTabIconView, this.bXg.get(i));
    }

    public boolean ha(int i) {
        if (!hd(i)) {
            return false;
        }
        this.bXf.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hb(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hd(i) && (swanAppBottomTabIconView = this.bXf.get(i)) != null) {
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

    public boolean D(int i, String str) {
        if (!hd(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXf.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hc(int i) {
        if (hd(i)) {
            this.bXf.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hd(int i) {
        return this.bXf != null && i < this.bXf.size() && i >= 0;
    }

    public int mx(String str) {
        if (TextUtils.isEmpty(str) || this.bXg == null || this.bXg.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bXg.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.bXg.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.bQg, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
