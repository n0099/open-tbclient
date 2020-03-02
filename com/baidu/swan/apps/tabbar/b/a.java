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
    private SwanAppConfigData.g bPG;
    private View bXa;
    private LinearLayout bXb;
    private int bXc = 0;
    private d bXd;
    private ArrayList<SwanAppBottomTabIconView> bXe;
    private ArrayList<SwanAppConfigData.h> bXf;
    private String bXg;
    private String bXh;

    public a(d dVar) {
        this.bXd = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.bXd.Nw()) {
            SwanAppConfigData Wy = f.WS().Wy();
            if (Wy == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bPG = Wy.bPG;
            this.bXf = this.bPG.bQe;
            int size = this.bXf.size();
            this.bXe = new ArrayList<>(size);
            this.bXa = view.findViewById(a.f.bottom_bar_shadow);
            gW(this.bPG.bQd);
            this.bXb = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.bXb.setVisibility(0);
            this.bXb.setBackgroundColor(this.bPG.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.bXf.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.bQf, !TextUtils.isEmpty(str) ? str : f.WS().WC()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.bXc = i;
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
                this.bXe.add(swanAppBottomTabIconView);
                this.bXb.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean NW() {
        return this.bXb != null && this.bXb.getVisibility() == 0;
    }

    private void gW(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.bXa.setVisibility(0);
                this.bXa.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.bXa.setVisibility(0);
                this.bXa.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.bXa.setVisibility(0);
                this.bXa.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void mt(String str) {
        this.bXb.setBackgroundColor(SwanAppConfigData.cG(str));
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
        String str = l + File.separator + hVar.bQg;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXg == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPG.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cG(a.this.bXg));
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
        String str = l + File.separator + hVar.bQh;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXh == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPG.bQc);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cG(a.this.bXh));
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
        if (this.bXa == null || this.bXb == null) {
            return false;
        }
        this.bXa.setVisibility(8);
        if (z) {
            agb();
        } else {
            this.bXb.setVisibility(8);
        }
        return true;
    }

    public boolean dZ(boolean z) {
        if (this.bXa == null || this.bXb == null) {
            return false;
        }
        this.bXa.setVisibility(0);
        this.bXb.setVisibility(0);
        ea(z);
        return true;
    }

    private void agb() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXb, "translationY", 0.0f, com.baidu.swan.apps.w.a.TW().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.bXb.setVisibility(8);
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXb, "translationY", com.baidu.swan.apps.w.a.TW().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        String uuid = UUID.randomUUID().toString();
        g.kb(uuid);
        gZ(i);
        gY(i);
        if (this.bXc != i) {
            this.bXc = i;
            this.bXd.pause();
            this.bXd.b(com.baidu.swan.apps.model.b.aX(this.bXf.get(i).bQf, f.WS().WA()), uuid);
            d dVar = this.bXd;
            d.gV("switchTab");
            this.bXd.resume();
        }
    }

    private void gY(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.bXf.get(i);
        String gX = this.bXd.gX(com.baidu.swan.apps.model.b.aX(hVar.bQf, f.WS().WA()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.bQf);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", gX);
        f.WS().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void gZ(int i) {
        a(this.bXe.get(this.bXc), this.bXf.get(this.bXc));
        b(this.bXe.get(i), this.bXf.get(i));
    }

    public void mu(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bXf.size()) {
                if (!this.bXf.get(i2).bQf.equals(str)) {
                    i = i2 + 1;
                } else {
                    gZ(i2);
                    this.bXc = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.bXa == null || this.bXb == null) {
            return false;
        }
        gW(SwanAppConfigData.cG(str4));
        mt(str3);
        mv(str);
        mw(str2);
        Iterator<SwanAppBottomTabIconView> it = this.bXe.iterator();
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
        this.bXg = str;
    }

    private void mw(String str) {
        this.bXh = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hd(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXe.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.bXf.get(i).bQg = str2;
        this.bXf.get(i).bQh = str3;
        if (swanAppBottomTabIconView.agc()) {
            return b(swanAppBottomTabIconView, this.bXf.get(i));
        }
        return a(swanAppBottomTabIconView, this.bXf.get(i));
    }

    public boolean ha(int i) {
        if (!hd(i)) {
            return false;
        }
        this.bXe.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hb(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hd(i) && (swanAppBottomTabIconView = this.bXe.get(i)) != null) {
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
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXe.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hc(int i) {
        if (hd(i)) {
            this.bXe.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hd(int i) {
        return this.bXe != null && i < this.bXe.size() && i >= 0;
    }

    public int mx(String str) {
        if (TextUtils.isEmpty(str) || this.bXf == null || this.bXf.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bXf.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.bXf.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.bQf, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
