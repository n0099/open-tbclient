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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j cHW;
    private View cQq;
    private LinearLayout cQr;
    private int cQs = 0;
    private e cQt;
    private ArrayList<SwanAppBottomTabIconView> cQu;
    private ArrayList<SwanAppConfigData.k> cQv;
    private String cQw;
    private String cQx;

    public a(e eVar) {
        this.cQt = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.cQt.ZR()) {
            SwanAppConfigData ajW = f.akr().ajW();
            if (ajW == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.cHW = ajW.cHW;
            this.cQv = this.cHW.cIA;
            int size = this.cQv.size();
            this.cQu = new ArrayList<>(size);
            this.cQq = view.findViewById(a.f.bottom_bar_shadow);
            hT(this.cHW.cIz);
            this.cQr = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.cQr.setVisibility(0);
            this.cQr.setBackgroundColor(this.cHW.mBackgroundColor);
            int displayWidth = ai.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.cQv.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.cIB, !TextUtils.isEmpty(str) ? str : f.akr().aka()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.cQs = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.hU(i);
                    }
                });
                this.cQu.add(swanAppBottomTabIconView);
                this.cQr.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean aaI() {
        return this.cQr != null && this.cQr.getVisibility() == 0;
    }

    private void hT(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.cQq.setVisibility(0);
                this.cQq.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.cQq.setVisibility(0);
                this.cQq.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.cQq.setVisibility(0);
                this.cQq.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void qf(String str) {
        this.cQr.setBackgroundColor(SwanAppConfigData.dU(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b Sq = Sq();
        if (Sq == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ae.a.a.k(Sq);
        if (TextUtils.isEmpty(k)) {
            k = d.C0380d.bq(Sq.getAppId(), Sq.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.cIC;
        if (com.baidu.swan.d.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cQw == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cHW.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dU(a.this.cQw));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b Sq = Sq();
        if (Sq == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ae.a.a.k(Sq);
        if (TextUtils.isEmpty(k)) {
            k = d.C0380d.bq(Sq.getAppId(), Sq.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.cID;
        if (com.baidu.swan.d.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.cQx == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.cHW.cIy);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.dU(a.this.cQx));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b Sq() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null) {
            return arv.Se();
        }
        return null;
    }

    public boolean fD(boolean z) {
        if (this.cQq == null || this.cQr == null) {
            return false;
        }
        this.cQq.setVisibility(8);
        if (z) {
            avI();
        } else {
            this.cQr.setVisibility(8);
        }
        return true;
    }

    public boolean fE(boolean z) {
        if (this.cQq == null || this.cQr == null) {
            return false;
        }
        this.cQq.setVisibility(0);
        this.cQr.setVisibility(0);
        fF(z);
        return true;
    }

    private void avI() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cQr, "translationY", 0.0f, com.baidu.swan.apps.t.a.ahj().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.cQr.setVisibility(8);
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

    private void fF(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cQr, "translationY", com.baidu.swan.apps.t.a.ahj().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(int i) {
        String uuid = UUID.randomUUID().toString();
        j.nm(uuid);
        hW(i);
        hV(i);
        if (this.cQs != i) {
            this.cQs = i;
            this.cQt.pause();
            this.cQt.b(com.baidu.swan.apps.model.b.bB(this.cQv.get(i).cIB, f.akr().ajY()), uuid);
            e.jI("switchTab");
            this.cQt.resume();
        }
    }

    private void hV(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.cQv.get(i);
        String jK = this.cQt.jK(com.baidu.swan.apps.model.b.bB(kVar.cIB, f.akr().ajY()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.cIB);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", jK);
        f.akr().a(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void hW(int i) {
        a(this.cQu.get(this.cQs), this.cQv.get(this.cQs));
        b(this.cQu.get(i), this.cQv.get(i));
    }

    public void qg(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cQv.size()) {
                if (!this.cQv.get(i2).cIB.equals(str)) {
                    i = i2 + 1;
                } else {
                    hW(i2);
                    this.cQs = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.cQq == null || this.cQr == null) {
            return false;
        }
        hT(SwanAppConfigData.dU(str4));
        qf(str3);
        qh(str);
        qi(str2);
        Iterator<SwanAppBottomTabIconView> it = this.cQu.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.avK()) {
                next.setTextColor(SwanAppConfigData.dU(str2));
            } else {
                next.setTextColor(SwanAppConfigData.dU(str));
            }
        }
        return true;
    }

    private void qh(String str) {
        this.cQw = str;
    }

    private void qi(String str) {
        this.cQx = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!ia(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.cQu.get(i);
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.cQv.get(i).cIC = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.cQv.get(i).cID = str3;
        }
        if (swanAppBottomTabIconView.avK()) {
            return b(swanAppBottomTabIconView, this.cQv.get(i));
        }
        return a(swanAppBottomTabIconView, this.cQv.get(i));
    }

    public boolean hX(int i) {
        if (!ia(i)) {
            return false;
        }
        this.cQu.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean hY(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (ia(i) && (swanAppBottomTabIconView = this.cQu.get(i)) != null) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setRedDotVisibleState(false);
                }
            });
            return true;
        }
        return false;
    }

    public boolean X(int i, String str) {
        if (!ia(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.cQu.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean hZ(int i) {
        if (ia(i)) {
            this.cQu.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean ia(int i) {
        return this.cQu != null && i < this.cQu.size() && i >= 0;
    }

    public int qj(String str) {
        if (TextUtils.isEmpty(str) || this.cQv == null || this.cQv.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cQv.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.cQv.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.cIB, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout avJ() {
        return this.cQr;
    }
}
