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
    private SwanAppConfigData.g coE;
    private View cwd;
    private LinearLayout cwe;
    private int cwf = 0;
    private d cwg;
    private ArrayList<SwanAppBottomTabIconView> cwh;
    private ArrayList<SwanAppConfigData.h> cwi;
    private String cwj;
    private String cwk;

    public a(d dVar) {
        this.cwg = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.cwg.Vm()) {
            SwanAppConfigData aeq = f.aeK().aeq();
            if (aeq == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.coE = aeq.coE;
            this.cwi = this.coE.cpc;
            int size = this.cwi.size();
            this.cwh = new ArrayList<>(size);
            this.cwd = view.findViewById(a.f.bottom_bar_shadow);
            hd(this.coE.cpb);
            this.cwe = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.cwe.setVisibility(0);
            this.cwe.setBackgroundColor(this.coE.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.cwi.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.cpd, !TextUtils.isEmpty(str) ? str : f.aeK().aeu()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.cwf = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, hVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(hVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.he(i);
                    }
                });
                this.cwh.add(swanAppBottomTabIconView);
                this.cwe.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean VN() {
        return this.cwe != null && this.cwe.getVisibility() == 0;
    }

    private void hd(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.cwd.setVisibility(0);
                this.cwd.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.cwd.setVisibility(0);
                this.cwd.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.cwd.setVisibility(0);
                this.cwd.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void nF(String str) {
        this.cwe.setBackgroundColor(SwanAppConfigData.dA(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b OK = OK();
        if (OK == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(OK);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aT(OK.getAppId(), OK.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.cpe;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cwj == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.coE.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dA(a.this.cwj));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b OK = OK();
        if (OK == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(OK);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aT(OK.getAppId(), OK.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.cpf;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cwk == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.coE.cpa);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dA(a.this.cwk));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.x.b.b OK() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null) {
            return akN.Ow();
        }
        return null;
    }

    public boolean eV(boolean z) {
        if (this.cwd == null || this.cwe == null) {
            return false;
        }
        this.cwd.setVisibility(8);
        if (z) {
            aoj();
        } else {
            this.cwe.setVisibility(8);
        }
        return true;
    }

    public boolean eW(boolean z) {
        if (this.cwd == null || this.cwe == null) {
            return false;
        }
        this.cwd.setVisibility(0);
        this.cwe.setVisibility(0);
        eX(z);
        return true;
    }

    private void aoj() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwe, "translationY", 0.0f, com.baidu.swan.apps.w.a.abO().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.cwe.setVisibility(8);
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

    private void eX(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwe, "translationY", com.baidu.swan.apps.w.a.abO().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(int i) {
        String uuid = UUID.randomUUID().toString();
        g.ln(uuid);
        hg(i);
        hf(i);
        if (this.cwf != i) {
            this.cwf = i;
            this.cwg.pause();
            this.cwg.b(com.baidu.swan.apps.model.b.bg(this.cwi.get(i).cpd, f.aeK().aes()), uuid);
            d dVar = this.cwg;
            d.ii("switchTab");
            this.cwg.resume();
        }
    }

    private void hf(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.cwi.get(i);
        String ik = this.cwg.ik(com.baidu.swan.apps.model.b.bg(hVar.cpd, f.aeK().aes()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.cpd);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", ik);
        f.aeK().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void hg(int i) {
        a(this.cwh.get(this.cwf), this.cwi.get(this.cwf));
        b(this.cwh.get(i), this.cwi.get(i));
    }

    public void nG(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cwi.size()) {
                if (!this.cwi.get(i2).cpd.equals(str)) {
                    i = i2 + 1;
                } else {
                    hg(i2);
                    this.cwf = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.cwd == null || this.cwe == null) {
            return false;
        }
        hd(SwanAppConfigData.dA(str4));
        nF(str3);
        nH(str);
        nI(str2);
        Iterator<SwanAppBottomTabIconView> it = this.cwh.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aok()) {
                next.setTextColor(SwanAppConfigData.dA(str2));
            } else {
                next.setTextColor(SwanAppConfigData.dA(str));
            }
        }
        return true;
    }

    private void nH(String str) {
        this.cwj = str;
    }

    private void nI(String str) {
        this.cwk = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hk(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.cwh.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.cwi.get(i).cpe = str2;
        this.cwi.get(i).cpf = str3;
        if (swanAppBottomTabIconView.aok()) {
            return b(swanAppBottomTabIconView, this.cwi.get(i));
        }
        return a(swanAppBottomTabIconView, this.cwi.get(i));
    }

    public boolean hh(int i) {
        if (!hk(i)) {
            return false;
        }
        this.cwh.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hi(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hk(i) && (swanAppBottomTabIconView = this.cwh.get(i)) != null) {
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

    public boolean U(int i, String str) {
        if (!hk(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.cwh.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hj(int i) {
        if (hk(i)) {
            this.cwh.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hk(int i) {
        return this.cwh != null && i < this.cwh.size() && i >= 0;
    }

    public int nJ(String str) {
        if (TextUtils.isEmpty(str) || this.cwi == null || this.cwi.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cwi.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.cwi.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.cpd, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
