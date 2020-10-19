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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j dfh;
    private View dnH;
    private LinearLayout dnI;
    private int dnJ = 0;
    private e dnK;
    private ArrayList<SwanAppBottomTabIconView> dnL;
    private ArrayList<SwanAppConfigData.k> dnM;
    private String dnN;
    private String dnO;

    public a(e eVar) {
        this.dnK = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dnK.ajw()) {
            SwanAppConfigData auZ = f.avu().auZ();
            if (auZ == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dfh = auZ.dfh;
            this.dnM = this.dfh.dfL;
            int size = this.dnM.size();
            this.dnL = new ArrayList<>(size);
            this.dnH = view.findViewById(a.f.bottom_bar_shadow);
            ar(this.dfh.dfK, this.dfh.mBackgroundColor);
            this.dnI = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dnI.setVisibility(0);
            this.dnI.setBackgroundColor(this.dfh.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dnM.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.dfM, !TextUtils.isEmpty(str) ? str : f.avu().avd()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dnJ = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.kK(i);
                    }
                });
                this.dnL.add(swanAppBottomTabIconView);
                this.dnI.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean ako() {
        return this.dnI != null && this.dnI.getVisibility() == 0;
    }

    private void ar(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dnH.setVisibility(0);
                this.dnH.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dnH.setVisibility(0);
                this.dnH.setBackgroundColor(i2);
            } else {
                this.dnH.setVisibility(0);
                this.dnH.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void tm(String str) {
        this.dnI.setBackgroundColor(SwanAppConfigData.fv(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b abG = abG();
        if (abG == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(abG);
        if (TextUtils.isEmpty(k)) {
            k = d.C0438d.bG(abG.getAppId(), abG.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dfN;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dnN == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dfh.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fv(a.this.dnN));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b abG = abG();
        if (abG == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(abG);
        if (TextUtils.isEmpty(k)) {
            k = d.C0438d.bG(abG.getAppId(), abG.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dfO;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dnO == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dfh.dfJ);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.fv(a.this.dnO));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b abG() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null) {
            return aDa.abu();
        }
        return null;
    }

    public boolean gr(boolean z) {
        if (this.dnH == null || this.dnI == null) {
            return false;
        }
        this.dnH.setVisibility(8);
        if (z) {
            aHk();
        } else {
            this.dnI.setVisibility(8);
        }
        return true;
    }

    public boolean gs(boolean z) {
        if (this.dnH == null || this.dnI == null) {
            return false;
        }
        this.dnH.setVisibility(0);
        this.dnI.setVisibility(0);
        gt(z);
        return true;
    }

    private void aHk() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dnI, "translationY", 0.0f, com.baidu.swan.apps.t.a.asf().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dnI.setVisibility(8);
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

    private void gt(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dnI, "translationY", com.baidu.swan.apps.t.a.asf().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(int i) {
        String uuid = UUID.randomUUID().toString();
        j.qq(uuid);
        kM(i);
        kL(i);
        if (this.dnJ != i) {
            this.dnJ = i;
            this.dnK.pause();
            this.dnK.b(com.baidu.swan.apps.model.b.bU(this.dnM.get(i).dfM, f.avu().avb()), uuid);
            e.mn("switchTab");
            this.dnK.resume();
        }
    }

    private void kL(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dnM.get(i);
        String mp = this.dnK.mp(com.baidu.swan.apps.model.b.bU(kVar.dfM, f.avu().avb()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.dfM);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", mp);
        f.avu().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void kM(int i) {
        a(this.dnL.get(this.dnJ), this.dnM.get(this.dnJ));
        b(this.dnL.get(i), this.dnM.get(i));
    }

    public void tn(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dnM.size()) {
                if (!this.dnM.get(i2).dfM.equals(str)) {
                    i = i2 + 1;
                } else {
                    kM(i2);
                    this.dnJ = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean r(String str, String str2, String str3, String str4) {
        if (this.dnH == null || this.dnI == null) {
            return false;
        }
        ar(SwanAppConfigData.fv(str4), SwanAppConfigData.fv(str3));
        tm(str3);
        to(str);
        tp(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dnL.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aHm()) {
                next.setTextColor(SwanAppConfigData.fv(str2));
            } else {
                next.setTextColor(SwanAppConfigData.fv(str));
            }
        }
        return true;
    }

    private void to(String str) {
        this.dnN = str;
    }

    private void tp(String str) {
        this.dnO = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!kQ(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dnL.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dnM.get(i).dfN = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dnM.get(i).dfO = str3;
        }
        if (swanAppBottomTabIconView.aHm()) {
            return b(swanAppBottomTabIconView, this.dnM.get(i));
        }
        return a(swanAppBottomTabIconView, this.dnM.get(i));
    }

    public boolean kN(int i) {
        if (!kQ(i)) {
            return false;
        }
        this.dnL.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kO(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (kQ(i) && (swanAppBottomTabIconView = this.dnL.get(i)) != null) {
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

    public boolean ai(int i, String str) {
        if (!kQ(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dnL.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean kP(int i) {
        if (kQ(i)) {
            this.dnL.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean kQ(int i) {
        return this.dnL != null && i < this.dnL.size() && i >= 0;
    }

    public int tq(String str) {
        if (TextUtils.isEmpty(str) || this.dnM == null || this.dnM.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dnM.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dnM.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.dfM, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aHl() {
        return this.dnI;
    }
}
