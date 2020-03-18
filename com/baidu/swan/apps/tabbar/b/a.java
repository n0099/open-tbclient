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
    private SwanAppConfigData.g bPS;
    private View bXm;
    private LinearLayout bXn;
    private int bXo = 0;
    private d bXp;
    private ArrayList<SwanAppBottomTabIconView> bXq;
    private ArrayList<SwanAppConfigData.h> bXr;
    private String bXs;
    private String bXt;

    public a(d dVar) {
        this.bXp = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.bXp.Nz()) {
            SwanAppConfigData WB = f.WV().WB();
            if (WB == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bPS = WB.bPS;
            this.bXr = this.bPS.bQq;
            int size = this.bXr.size();
            this.bXq = new ArrayList<>(size);
            this.bXm = view.findViewById(a.f.bottom_bar_shadow);
            gW(this.bPS.bQp);
            this.bXn = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.bXn.setVisibility(0);
            this.bXn.setBackgroundColor(this.bPS.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.bXr.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.bQr, !TextUtils.isEmpty(str) ? str : f.WV().WF()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.bXo = i;
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
                this.bXq.add(swanAppBottomTabIconView);
                this.bXn.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean NZ() {
        return this.bXn != null && this.bXn.getVisibility() == 0;
    }

    private void gW(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.bXm.setVisibility(0);
                this.bXm.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.bXm.setVisibility(0);
                this.bXm.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.bXm.setVisibility(0);
                this.bXm.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void ms(String str) {
        this.bXn.setBackgroundColor(SwanAppConfigData.cF(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b GX = GX();
        if (GX == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(GX);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aK(GX.getAppId(), GX.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bQs;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXs == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPS.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cF(a.this.bXs));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b GX = GX();
        if (GX == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(GX);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aK(GX.getAppId(), GX.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.bQt;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.bXt == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.bPS.bQo);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.cF(a.this.bXt));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.x.b.b GX() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null) {
            return acI.GJ();
        }
        return null;
    }

    public boolean dZ(boolean z) {
        if (this.bXm == null || this.bXn == null) {
            return false;
        }
        this.bXm.setVisibility(8);
        if (z) {
            age();
        } else {
            this.bXn.setVisibility(8);
        }
        return true;
    }

    public boolean ea(boolean z) {
        if (this.bXm == null || this.bXn == null) {
            return false;
        }
        this.bXm.setVisibility(0);
        this.bXn.setVisibility(0);
        eb(z);
        return true;
    }

    private void age() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXn, "translationY", 0.0f, com.baidu.swan.apps.w.a.TZ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.bXn.setVisibility(8);
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

    private void eb(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bXn, "translationY", com.baidu.swan.apps.w.a.TZ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        String uuid = UUID.randomUUID().toString();
        g.ka(uuid);
        gZ(i);
        gY(i);
        if (this.bXo != i) {
            this.bXo = i;
            this.bXp.pause();
            this.bXp.b(com.baidu.swan.apps.model.b.aW(this.bXr.get(i).bQr, f.WV().WD()), uuid);
            d dVar = this.bXp;
            d.gU("switchTab");
            this.bXp.resume();
        }
    }

    private void gY(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.bXr.get(i);
        String gW = this.bXp.gW(com.baidu.swan.apps.model.b.aW(hVar.bQr, f.WV().WD()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.bQr);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", gW);
        f.WV().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void gZ(int i) {
        a(this.bXq.get(this.bXo), this.bXr.get(this.bXo));
        b(this.bXq.get(i), this.bXr.get(i));
    }

    public void mt(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bXr.size()) {
                if (!this.bXr.get(i2).bQr.equals(str)) {
                    i = i2 + 1;
                } else {
                    gZ(i2);
                    this.bXo = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.bXm == null || this.bXn == null) {
            return false;
        }
        gW(SwanAppConfigData.cF(str4));
        ms(str3);
        mu(str);
        mv(str2);
        Iterator<SwanAppBottomTabIconView> it = this.bXq.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.agf()) {
                next.setTextColor(SwanAppConfigData.cF(str2));
            } else {
                next.setTextColor(SwanAppConfigData.cF(str));
            }
        }
        return true;
    }

    private void mu(String str) {
        this.bXs = str;
    }

    private void mv(String str) {
        this.bXt = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hd(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXq.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.bXr.get(i).bQs = str2;
        this.bXr.get(i).bQt = str3;
        if (swanAppBottomTabIconView.agf()) {
            return b(swanAppBottomTabIconView, this.bXr.get(i));
        }
        return a(swanAppBottomTabIconView, this.bXr.get(i));
    }

    public boolean ha(int i) {
        if (!hd(i)) {
            return false;
        }
        this.bXq.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hb(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hd(i) && (swanAppBottomTabIconView = this.bXq.get(i)) != null) {
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
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bXq.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hc(int i) {
        if (hd(i)) {
            this.bXq.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hd(int i) {
        return this.bXq != null && i < this.bXq.size() && i >= 0;
    }

    public int mw(String str) {
        if (TextUtils.isEmpty(str) || this.bXr == null || this.bXr.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bXr.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.bXr.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.bQr, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
