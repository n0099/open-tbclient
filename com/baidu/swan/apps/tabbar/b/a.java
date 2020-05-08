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
    private SwanAppConfigData.g coK;
    private View cwj;
    private LinearLayout cwk;
    private int cwl = 0;
    private d cwm;
    private ArrayList<SwanAppBottomTabIconView> cwn;
    private ArrayList<SwanAppConfigData.h> cwo;
    private String cwp;
    private String cwq;

    public a(d dVar) {
        this.cwm = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.cwm.Vl()) {
            SwanAppConfigData aep = f.aeJ().aep();
            if (aep == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.coK = aep.coK;
            this.cwo = this.coK.cpi;
            int size = this.cwo.size();
            this.cwn = new ArrayList<>(size);
            this.cwj = view.findViewById(a.f.bottom_bar_shadow);
            hd(this.coK.cph);
            this.cwk = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.cwk.setVisibility(0);
            this.cwk.setBackgroundColor(this.coK.mBackgroundColor);
            int displayWidth = af.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.h hVar = this.cwo.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(hVar.cpj, !TextUtils.isEmpty(str) ? str : f.aeJ().aet()) && !z2) {
                    b(swanAppBottomTabIconView, hVar);
                    this.cwl = i;
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
                this.cwn.add(swanAppBottomTabIconView);
                this.cwk.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean VM() {
        return this.cwk != null && this.cwk.getVisibility() == 0;
    }

    private void hd(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.cwj.setVisibility(0);
                this.cwj.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.cwj.setVisibility(0);
                this.cwj.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.cwj.setVisibility(0);
                this.cwj.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void nF(String str) {
        this.cwk.setBackgroundColor(SwanAppConfigData.dA(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b OJ = OJ();
        if (OJ == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(OJ);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aT(OJ.getAppId(), OJ.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.cpk;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cwp == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.coK.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dA(a.this.cwp));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.h hVar) {
        com.baidu.swan.apps.x.b.b OJ = OJ();
        if (OJ == null) {
            return false;
        }
        String l = com.baidu.swan.apps.ah.a.a.l(OJ);
        if (TextUtils.isEmpty(l)) {
            l = e.d.aT(OJ.getAppId(), OJ.getVersion()).getPath();
        }
        String str = l + File.separator + hVar.cpl;
        if (c.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cwq == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.coK.cpg);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dA(a.this.cwq));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.x.b.b OJ() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null) {
            return akM.Ov();
        }
        return null;
    }

    public boolean eV(boolean z) {
        if (this.cwj == null || this.cwk == null) {
            return false;
        }
        this.cwj.setVisibility(8);
        if (z) {
            aoi();
        } else {
            this.cwk.setVisibility(8);
        }
        return true;
    }

    public boolean eW(boolean z) {
        if (this.cwj == null || this.cwk == null) {
            return false;
        }
        this.cwj.setVisibility(0);
        this.cwk.setVisibility(0);
        eX(z);
        return true;
    }

    private void aoi() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwk, "translationY", 0.0f, com.baidu.swan.apps.w.a.abN().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.cwk.setVisibility(8);
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwk, "translationY", com.baidu.swan.apps.w.a.abN().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(int i) {
        String uuid = UUID.randomUUID().toString();
        g.ln(uuid);
        hg(i);
        hf(i);
        if (this.cwl != i) {
            this.cwl = i;
            this.cwm.pause();
            this.cwm.b(com.baidu.swan.apps.model.b.bg(this.cwo.get(i).cpj, f.aeJ().aer()), uuid);
            d dVar = this.cwm;
            d.ii("switchTab");
            this.cwm.resume();
        }
    }

    private void hf(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.h hVar = this.cwo.get(i);
        String ik = this.cwm.ik(com.baidu.swan.apps.model.b.bg(hVar.cpj, f.aeJ().aer()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", hVar.cpj);
        hashMap.put("text", hVar.mText);
        hashMap.put("wvID", ik);
        f.aeJ().a(new com.baidu.swan.apps.n.a.b("onTabItemTap", hashMap));
    }

    private void hg(int i) {
        a(this.cwn.get(this.cwl), this.cwo.get(this.cwl));
        b(this.cwn.get(i), this.cwo.get(i));
    }

    public void nG(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cwo.size()) {
                if (!this.cwo.get(i2).cpj.equals(str)) {
                    i = i2 + 1;
                } else {
                    hg(i2);
                    this.cwl = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.cwj == null || this.cwk == null) {
            return false;
        }
        hd(SwanAppConfigData.dA(str4));
        nF(str3);
        nH(str);
        nI(str2);
        Iterator<SwanAppBottomTabIconView> it = this.cwn.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aoj()) {
                next.setTextColor(SwanAppConfigData.dA(str2));
            } else {
                next.setTextColor(SwanAppConfigData.dA(str));
            }
        }
        return true;
    }

    private void nH(String str) {
        this.cwp = str;
    }

    private void nI(String str) {
        this.cwq = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hk(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.cwn.get(i);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        this.cwo.get(i).cpk = str2;
        this.cwo.get(i).cpl = str3;
        if (swanAppBottomTabIconView.aoj()) {
            return b(swanAppBottomTabIconView, this.cwo.get(i));
        }
        return a(swanAppBottomTabIconView, this.cwo.get(i));
    }

    public boolean hh(int i) {
        if (!hk(i)) {
            return false;
        }
        this.cwn.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hi(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hk(i) && (swanAppBottomTabIconView = this.cwn.get(i)) != null) {
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
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.cwn.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hj(int i) {
        if (hk(i)) {
            this.cwn.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hk(int i) {
        return this.cwn != null && i < this.cwn.size() && i >= 0;
    }

    public int nJ(String str) {
        if (TextUtils.isEmpty(str) || this.cwo == null || this.cwo.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cwo.size()) {
                return -1;
            }
            SwanAppConfigData.h hVar = this.cwo.get(i2);
            if (hVar == null || !TextUtils.equals(hVar.cpj, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
