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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.performance.h;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.w.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.i cAw;
    private View cIl;
    private LinearLayout cIm;
    private int cIn = 0;
    private d cIo;
    private ArrayList<SwanAppBottomTabIconView> cIp;
    private ArrayList<SwanAppConfigData.j> cIq;
    private String cIr;
    private String cIs;

    public a(d dVar) {
        this.cIo = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.cIo.XQ()) {
            SwanAppConfigData ahA = f.ahV().ahA();
            if (ahA == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.cAw = ahA.cAw;
            this.cIq = this.cAw.cAY;
            int size = this.cIq.size();
            this.cIp = new ArrayList<>(size);
            this.cIl = view.findViewById(a.f.bottom_bar_shadow);
            hx(this.cAw.cAX);
            this.cIm = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.cIm.setVisibility(0);
            this.cIm.setBackgroundColor(this.cAw.mBackgroundColor);
            int displayWidth = ag.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.j jVar = this.cIq.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(jVar.cAZ, !TextUtils.isEmpty(str) ? str : f.ahV().ahE()) && !z2) {
                    b(swanAppBottomTabIconView, jVar);
                    this.cIn = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, jVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(jVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.hy(i);
                    }
                });
                this.cIp.add(swanAppBottomTabIconView);
                this.cIm.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean Yy() {
        return this.cIm != null && this.cIm.getVisibility() == 0;
    }

    private void hx(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.cIl.setVisibility(0);
                this.cIl.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.cIl.setVisibility(0);
                this.cIl.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.cIl.setVisibility(0);
                this.cIl.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void pm(String str) {
        this.cIm.setBackgroundColor(SwanAppConfigData.dT(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.j jVar) {
        com.baidu.swan.apps.v.b.b QV = QV();
        if (QV == null) {
            return false;
        }
        String n = com.baidu.swan.apps.af.a.a.n(QV);
        if (TextUtils.isEmpty(n)) {
            n = e.d.bk(QV.getAppId(), QV.getVersion()).getPath();
        }
        String str = n + File.separator + jVar.cBa;
        if (com.baidu.swan.e.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cIr == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cAw.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dT(a.this.cIr));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.j jVar) {
        com.baidu.swan.apps.v.b.b QV = QV();
        if (QV == null) {
            return false;
        }
        String n = com.baidu.swan.apps.af.a.a.n(QV);
        if (TextUtils.isEmpty(n)) {
            n = e.d.bk(QV.getAppId(), QV.getVersion()).getPath();
        }
        String str = n + File.separator + jVar.cBb;
        if (com.baidu.swan.e.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cIs == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cAw.cAW);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dT(a.this.cIs));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b QV() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null) {
            return aoF.QJ();
        }
        return null;
    }

    public boolean fp(boolean z) {
        if (this.cIl == null || this.cIm == null) {
            return false;
        }
        this.cIl.setVisibility(8);
        if (z) {
            asB();
        } else {
            this.cIm.setVisibility(8);
        }
        return true;
    }

    public boolean fq(boolean z) {
        if (this.cIl == null || this.cIm == null) {
            return false;
        }
        this.cIl.setVisibility(0);
        this.cIm.setVisibility(0);
        fr(z);
        return true;
    }

    private void asB() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cIm, "translationY", 0.0f, com.baidu.swan.apps.u.a.aeR().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.cIm.setVisibility(8);
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

    private void fr(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cIm, "translationY", com.baidu.swan.apps.u.a.aeR().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(int i) {
        String uuid = UUID.randomUUID().toString();
        h.mC(uuid);
        hA(i);
        hz(i);
        if (this.cIn != i) {
            this.cIn = i;
            this.cIo.pause();
            this.cIo.b(com.baidu.swan.apps.model.b.bx(this.cIq.get(i).cAZ, f.ahV().ahC()), uuid);
            d.jj("switchTab");
            this.cIo.resume();
        }
    }

    private void hz(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.j jVar = this.cIq.get(i);
        String jl = this.cIo.jl(com.baidu.swan.apps.model.b.bx(jVar.cAZ, f.ahV().ahC()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", jVar.cAZ);
        hashMap.put("text", jVar.mText);
        hashMap.put("wvID", jl);
        f.ahV().a(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void hA(int i) {
        a(this.cIp.get(this.cIn), this.cIq.get(this.cIn));
        b(this.cIp.get(i), this.cIq.get(i));
    }

    public void pn(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cIq.size()) {
                if (!this.cIq.get(i2).cAZ.equals(str)) {
                    i = i2 + 1;
                } else {
                    hA(i2);
                    this.cIn = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.cIl == null || this.cIm == null) {
            return false;
        }
        hx(SwanAppConfigData.dT(str4));
        pm(str3);
        po(str);
        pp(str2);
        Iterator<SwanAppBottomTabIconView> it = this.cIp.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.asD()) {
                next.setTextColor(SwanAppConfigData.dT(str2));
            } else {
                next.setTextColor(SwanAppConfigData.dT(str));
            }
        }
        return true;
    }

    private void po(String str) {
        this.cIr = str;
    }

    private void pp(String str) {
        this.cIs = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!hE(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.cIp.get(i);
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.cIq.get(i).cBa = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.cIq.get(i).cBb = str3;
        }
        if (swanAppBottomTabIconView.asD()) {
            return b(swanAppBottomTabIconView, this.cIq.get(i));
        }
        return a(swanAppBottomTabIconView, this.cIq.get(i));
    }

    public boolean hB(int i) {
        if (!hE(i)) {
            return false;
        }
        this.cIp.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hC(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (hE(i) && (swanAppBottomTabIconView = this.cIp.get(i)) != null) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setRedDotVisibleState(false);
                }
            });
            return true;
        }
        return false;
    }

    public boolean V(int i, String str) {
        if (!hE(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.cIp.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hD(int i) {
        if (hE(i)) {
            this.cIp.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean hE(int i) {
        return this.cIp != null && i < this.cIp.size() && i >= 0;
    }

    public int pq(String str) {
        if (TextUtils.isEmpty(str) || this.cIq == null || this.cIq.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cIq.size()) {
                return -1;
            }
            SwanAppConfigData.j jVar = this.cIq.get(i2);
            if (jVar == null || !TextUtils.equals(jVar.cAZ, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout asC() {
        return this.cIm;
    }
}
