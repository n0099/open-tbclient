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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j dCP;
    private View dLk;
    private LinearLayout dLl;
    private int dLm = 0;
    private e dLn;
    private ArrayList<SwanAppBottomTabIconView> dLo;
    private ArrayList<SwanAppConfigData.k> dLp;
    private String dLq;
    private String dLr;

    public a(e eVar) {
        this.dLn = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dLn.anI()) {
            SwanAppConfigData azs = f.azN().azs();
            if (azs == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dCP = azs.dCP;
            this.dLp = this.dCP.dDt;
            int size = this.dLp.size();
            this.dLo = new ArrayList<>(size);
            this.dLk = view.findViewById(a.f.bottom_bar_shadow);
            aq(this.dCP.dDs, this.dCP.mBackgroundColor);
            this.dLl = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dLl.setVisibility(0);
            this.dLl.setBackgroundColor(this.dCP.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dLp.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.dDu, !TextUtils.isEmpty(str) ? str : f.azN().azw()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dLm = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.jY(i);
                    }
                });
                this.dLo.add(swanAppBottomTabIconView);
                this.dLl.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean aoF() {
        return this.dLl != null && this.dLl.getVisibility() == 0;
    }

    private void aq(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dLk.setVisibility(0);
                this.dLk.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dLk.setVisibility(0);
                this.dLk.setBackgroundColor(i2);
            } else {
                this.dLk.setVisibility(0);
                this.dLk.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void th(String str) {
        this.dLl.setBackgroundColor(SwanAppConfigData.rt(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b afN = afN();
        if (afN == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(afN);
        if (TextUtils.isEmpty(k)) {
            k = d.C0449d.bR(afN.getAppId(), afN.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dDv;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dLq == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dCP.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.rt(a.this.dLq));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b afN = afN();
        if (afN == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(afN);
        if (TextUtils.isEmpty(k)) {
            k = d.C0449d.bR(afN.getAppId(), afN.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dDw;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dLr == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dCP.dDr);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.rt(a.this.dLr));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b afN() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null) {
            return aIr.afB();
        }
        return null;
    }

    public boolean ht(boolean z) {
        if (this.dLk == null || this.dLl == null) {
            return false;
        }
        this.dLk.setVisibility(8);
        if (z) {
            aMB();
        } else {
            this.dLl.setVisibility(8);
        }
        return true;
    }

    public boolean hu(boolean z) {
        if (this.dLk == null || this.dLl == null) {
            return false;
        }
        this.dLk.setVisibility(0);
        this.dLl.setVisibility(0);
        hv(z);
        return true;
    }

    private void aMB() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dLl, "translationY", 0.0f, com.baidu.swan.apps.t.a.awy().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dLl.setVisibility(8);
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

    private void hv(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dLl, "translationY", com.baidu.swan.apps.t.a.awy().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(int i) {
        String uuid = UUID.randomUUID().toString();
        j.qg(uuid);
        ka(i);
        jZ(i);
        if (this.dLm != i) {
            this.dLm = i;
            this.dLn.pause();
            this.dLn.b(com.baidu.swan.apps.model.b.cf(this.dLp.get(i).dDu, f.azN().azu()), uuid);
            e.me("switchTab");
            this.dLn.resume();
        }
    }

    private void jZ(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dLp.get(i);
        String mg = this.dLn.mg(com.baidu.swan.apps.model.b.cf(kVar.dDu, f.azN().azu()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.dDu);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", mg);
        f.azN().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void ka(int i) {
        a(this.dLo.get(this.dLm), this.dLp.get(this.dLm));
        b(this.dLo.get(i), this.dLp.get(i));
    }

    public void ti(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dLp.size()) {
                if (!this.dLp.get(i2).dDu.equals(str)) {
                    i = i2 + 1;
                } else {
                    ka(i2);
                    this.dLm = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dLk == null || this.dLl == null) {
            return false;
        }
        aq(SwanAppConfigData.rt(str4), SwanAppConfigData.rt(str3));
        th(str3);
        tj(str);
        tk(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dLo.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aMD()) {
                next.setTextColor(SwanAppConfigData.rt(str2));
            } else {
                next.setTextColor(SwanAppConfigData.rt(str));
            }
        }
        return true;
    }

    private void tj(String str) {
        this.dLq = str;
    }

    private void tk(String str) {
        this.dLr = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!ke(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dLo.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dLp.get(i).dDv = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dLp.get(i).dDw = str3;
        }
        if (swanAppBottomTabIconView.aMD()) {
            return b(swanAppBottomTabIconView, this.dLp.get(i));
        }
        return a(swanAppBottomTabIconView, this.dLp.get(i));
    }

    public boolean kb(int i) {
        if (!ke(i)) {
            return false;
        }
        this.dLo.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kc(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (ke(i) && (swanAppBottomTabIconView = this.dLo.get(i)) != null) {
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

    public boolean ar(int i, String str) {
        if (!ke(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dLo.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean kd(int i) {
        if (ke(i)) {
            this.dLo.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean ke(int i) {
        return this.dLo != null && i < this.dLo.size() && i >= 0;
    }

    public int tl(String str) {
        if (TextUtils.isEmpty(str) || this.dLp == null || this.dLp.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dLp.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dLp.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.dDu, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aMC() {
        return this.dLl;
    }
}
