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
    private SwanAppConfigData.g bPF;
    private View bWZ;
    private LinearLayout bXa;
    private int bXb = 0;
    private d bXc;
    private ArrayList<SwanAppBottomTabIconView> bXd;
    private ArrayList<SwanAppConfigData.h> bXe;
    private String bXf;
    private String bXg;

    public a(d dVar) {
        this.bXc = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.bXc.Nu()) {
            SwanAppConfigData Ww = f.WQ().Ww();
            if (Ww == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bPF = Ww.bPF;
            this.bXe = this.bPF.bQd;
            int size = this.bXe.size();
            this.bXd = new ArrayList<>(size);
            this.bWZ = view.findViewById(a.f.bottom_bar_shadow);
            gW(this.bPF.bQc);
            this.bXa = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.bXa.setVisibility(0);
            this.bXa.setBackgroundColor(this.bPF.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.bXe.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.bQe, !TextUtils.isEmpty(str) ? str : f.WQ().WA()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.bXb = i;
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
                this.bXd.add(swanAppBottomTabIconView);
                this.bXa.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean NU() {
        return this.bXa != null && this.bXa.getVisibility() == 0;
    }

    private void gW(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.bWZ.setVisibility(0);
                this.bWZ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.bWZ.setVisibility(0);
                this.bWZ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.bWZ.setVisibility(0);
                this.bWZ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void mt(String str) {
        this.bXa.setBackgroundColor(SwanAppConfigData.cG(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b GQ = GQ();
        if (GQ == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(GQ);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aL(GQ.getAppId(), GQ.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bQf;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXf == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPF.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cG(a.this.bXf));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b GQ = GQ();
        if (GQ == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(GQ);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aL(GQ.getAppId(), GQ.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bQg;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXg == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPF.bQb);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cG(a.this.bXg));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.x.b.b GQ() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null) {
            return acD.GC();
        }
        return null;
    }

    public boolean dY(boolean z) {
        if (this.bWZ == null || this.bXa == null) {
            return false;
        }
        this.bWZ.setVisibility(8);
        if (z) {
            afZ();
        } else {
            this.bXa.setVisibility(8);
        }
        return true;
    }

    public boolean dZ(boolean z) {
        if (this.bWZ == null || this.bXa == null) {
            return false;
        }
        this.bWZ.setVisibility(0);
        this.bXa.setVisibility(0);
        ea(z);
        return true;
    }

    private void afZ() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXa, "translationY", 0.0f, com.baidu.swan.apps.w.a.TU().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.bXa.setVisibility(8);
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXa, "translationY", com.baidu.swan.apps.w.a.TU().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        String uuid = UUID.randomUUID().toString();
        g.kb(uuid);
        gZ(i);
        gY(i);
        if (this.bXb != i) {
            this.bXb = i;
            this.bXc.pause();
            this.bXc.b(com.baidu.swan.apps.model.b.aX(this.bXe.get(i).bQe, f.WQ().Wy()), uuid);
            d dVar = this.bXc;
            d.gV("switchTab");
            this.bXc.resume();
        }
    }

    private void gY(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.bXe.get(i);
        String gX = this.bXc.gX(com.baidu.swan.apps.model.b.aX(hVar.bQe, f.WQ().Wy()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.bQe);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", gX);
        f.WQ().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void gZ(int i) {
        a(this.bXd.get(this.bXb), this.bXe.get(this.bXb));
        b(this.bXd.get(i), this.bXe.get(i));
    }

    public void mu(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bXe.size()) {
                if (!this.bXe.get(i2).bQe.equals(str)) {
                    i = i2 + 1;
                } else {
                    gZ(i2);
                    this.bXb = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.bWZ == null || this.bXa == null) {
            return false;
        }
        gW(SwanAppConfigData.cG(str4));
        mt(str3);
        mv(str);
        mw(str2);
        Iterator<SwanAppBottomTabIconView> it = this.bXd.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aga()) {
                next.setTextColor(SwanAppConfigData.cG(str2));
            } else {
                next.setTextColor(SwanAppConfigData.cG(str));
            }
        }
        return true;
    }

    private void mv(String str) {
        this.bXf = str;
    }

    private void mw(String str) {
        this.bXg = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hd(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXd.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.bXe.get(i).bQf = str2;
        this.bXe.get(i).bQg = str3;
        if (swanAppBottomTabIconView.aga()) {
            return b(swanAppBottomTabIconView, this.bXe.get(i));
        }
        return a(swanAppBottomTabIconView, this.bXe.get(i));
    }

    public boolean ha(int i) {
        if (!hd(i)) {
            return false;
        }
        this.bXd.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hb(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hd(i) && (swanAppBottomTabIconView = this.bXd.get(i)) != null) {
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
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXd.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hc(int i) {
        if (hd(i)) {
            this.bXd.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hd(int i) {
        return this.bXd != null && i < this.bXd.size() && i >= 0;
    }

    public int mx(String str) {
        if (TextUtils.isEmpty(str) || this.bXe == null || this.bXe.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bXe.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.bXe.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.bQe, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
