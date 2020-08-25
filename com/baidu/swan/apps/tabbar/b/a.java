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
    private SwanAppConfigData.j cQV;
    private View cZs;
    private LinearLayout cZt;
    private int cZu = 0;
    private e cZv;
    private ArrayList<SwanAppBottomTabIconView> cZw;
    private ArrayList<SwanAppConfigData.k> cZx;
    private String cZy;
    private String cZz;

    public a(e eVar) {
        this.cZv = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.cZv.agb()) {
            SwanAppConfigData arD = f.arY().arD();
            if (arD == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.cQV = arD.cQV;
            this.cZx = this.cQV.cRz;
            int size = this.cZx.size();
            this.cZw = new ArrayList<>(size);
            this.cZs = view.findViewById(a.f.bottom_bar_shadow);
            as(this.cQV.cRy, this.cQV.mBackgroundColor);
            this.cZt = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.cZt.setVisibility(0);
            this.cZt.setBackgroundColor(this.cQV.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.cZx.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.cRA, !TextUtils.isEmpty(str) ? str : f.arY().arH()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.cZu = i;
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
                this.cZw.add(swanAppBottomTabIconView);
                this.cZt.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean agT() {
        return this.cZt != null && this.cZt.getVisibility() == 0;
    }

    private void as(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.cZs.setVisibility(0);
                this.cZs.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.cZs.setVisibility(0);
                this.cZs.setBackgroundColor(i2);
            } else {
                this.cZs.setVisibility(0);
                this.cZs.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void sf(String str) {
        this.cZt.setBackgroundColor(SwanAppConfigData.fn(str));
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
        String str = k + File.separator + kVar.cRB;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cZy == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cQV.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fn(a.this.cZy));
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
        String str = k + File.separator + kVar.cRC;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cZz == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cQV.cRx);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fn(a.this.cZz));
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

    public boolean fW(boolean z) {
        if (this.cZs == null || this.cZt == null) {
            return false;
        }
        this.cZs.setVisibility(8);
        if (z) {
            aDR();
        } else {
            this.cZt.setVisibility(8);
        }
        return true;
    }

    public boolean fX(boolean z) {
        if (this.cZs == null || this.cZt == null) {
            return false;
        }
        this.cZs.setVisibility(0);
        this.cZt.setVisibility(0);
        fY(z);
        return true;
    }

    private void aDR() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cZt, "translationY", 0.0f, com.baidu.swan.apps.t.a.aoJ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.cZt.setVisibility(8);
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

    private void fY(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cZt, "translationY", com.baidu.swan.apps.t.a.aoJ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc(int i) {
        String uuid = UUID.randomUUID().toString();
        j.pk(uuid);
        ke(i);
        kd(i);
        if (this.cZu != i) {
            this.cZu = i;
            this.cZv.pause();
            this.cZv.b(com.baidu.swan.apps.model.b.bP(this.cZx.get(i).cRA, f.arY().arF()), uuid);
            e.lh("switchTab");
            this.cZv.resume();
        }
    }

    private void kd(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.cZx.get(i);
        String lj = this.cZv.lj(com.baidu.swan.apps.model.b.bP(kVar.cRA, f.arY().arF()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.cRA);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", lj);
        f.arY().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void ke(int i) {
        a(this.cZw.get(this.cZu), this.cZx.get(this.cZu));
        b(this.cZw.get(i), this.cZx.get(i));
    }

    public void sg(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cZx.size()) {
                if (!this.cZx.get(i2).cRA.equals(str)) {
                    i = i2 + 1;
                } else {
                    ke(i2);
                    this.cZu = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.cZs == null || this.cZt == null) {
            return false;
        }
        as(SwanAppConfigData.fn(str4), SwanAppConfigData.fn(str3));
        sf(str3);
        sh(str);
        si(str2);
        Iterator<SwanAppBottomTabIconView> it = this.cZw.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aDT()) {
                next.setTextColor(SwanAppConfigData.fn(str2));
            } else {
                next.setTextColor(SwanAppConfigData.fn(str));
            }
        }
        return true;
    }

    private void sh(String str) {
        this.cZy = str;
    }

    private void si(String str) {
        this.cZz = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!ki(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.cZw.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.cZx.get(i).cRB = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.cZx.get(i).cRC = str3;
        }
        if (swanAppBottomTabIconView.aDT()) {
            return b(swanAppBottomTabIconView, this.cZx.get(i));
        }
        return a(swanAppBottomTabIconView, this.cZx.get(i));
    }

    public boolean kf(int i) {
        if (!ki(i)) {
            return false;
        }
        this.cZw.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kg(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (ki(i) && (swanAppBottomTabIconView = this.cZw.get(i)) != null) {
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
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.cZw.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean kh(int i) {
        if (ki(i)) {
            this.cZw.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean ki(int i) {
        return this.cZw != null && i < this.cZw.size() && i >= 0;
    }

    public int sj(String str) {
        if (TextUtils.isEmpty(str) || this.cZx == null || this.cZx.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cZx.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.cZx.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.cRA, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aDS() {
        return this.cZt;
    }
}
