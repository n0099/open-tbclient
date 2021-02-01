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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppConfigData.j dET;
    private View dNo;
    private LinearLayout dNp;
    private int dNq = 0;
    private e dNr;
    private ArrayList<SwanAppBottomTabIconView> dNs;
    private ArrayList<SwanAppConfigData.k> dNt;
    private String dNu;
    private String dNv;

    public a(e eVar) {
        this.dNr = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dNr.aog()) {
            SwanAppConfigData azQ = f.aAl().azQ();
            if (azQ == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dET = azQ.dET;
            this.dNt = this.dET.dFx;
            int size = this.dNt.size();
            this.dNs = new ArrayList<>(size);
            this.dNo = view.findViewById(a.f.bottom_bar_shadow);
            an(this.dET.dFw, this.dET.mBackgroundColor);
            this.dNp = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dNp.setVisibility(0);
            this.dNp.setBackgroundColor(this.dET.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dNt.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.dFy, !TextUtils.isEmpty(str) ? str : f.aAl().azU()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dNq = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, kVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(kVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.kb(i);
                    }
                });
                this.dNs.add(swanAppBottomTabIconView);
                this.dNp.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean apd() {
        return this.dNp != null && this.dNp.getVisibility() == 0;
    }

    private void an(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dNo.setVisibility(0);
                this.dNo.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dNo.setVisibility(0);
                this.dNo.setBackgroundColor(i2);
            } else {
                this.dNo.setVisibility(0);
                this.dNo.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void tA(String str) {
        this.dNp.setBackgroundColor(SwanAppConfigData.rM(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b agl = agl();
        if (agl == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(agl);
        if (TextUtils.isEmpty(k)) {
            k = d.C0446d.bL(agl.getAppId(), agl.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dFz;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dNu == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dET.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.rM(a.this.dNu));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b agl = agl();
        if (agl == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(agl);
        if (TextUtils.isEmpty(k)) {
            k = d.C0446d.bL(agl.getAppId(), agl.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dFA;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dNv == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dET.dFv);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.rM(a.this.dNv));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b agl() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null) {
            return aIK.afZ();
        }
        return null;
    }

    public boolean hv(boolean z) {
        if (this.dNo == null || this.dNp == null) {
            return false;
        }
        this.dNo.setVisibility(8);
        if (z) {
            aMU();
        } else {
            this.dNp.setVisibility(8);
        }
        return true;
    }

    public boolean hw(boolean z) {
        if (this.dNo == null || this.dNp == null) {
            return false;
        }
        this.dNo.setVisibility(0);
        this.dNp.setVisibility(0);
        hx(z);
        return true;
    }

    private void aMU() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dNp, "translationY", 0.0f, com.baidu.swan.apps.t.a.awW().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dNp.setVisibility(8);
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

    private void hx(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dNp, "translationY", com.baidu.swan.apps.t.a.awW().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(int i) {
        String uuid = UUID.randomUUID().toString();
        j.qy(uuid);
        kd(i);
        kc(i);
        if (this.dNq != i) {
            this.dNq = i;
            this.dNr.pause();
            this.dNr.b(com.baidu.swan.apps.model.b.bZ(this.dNt.get(i).dFy, f.aAl().azS()), uuid);
            e.mw("switchTab");
            this.dNr.resume();
        }
    }

    private void kc(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dNt.get(i);
        String my = this.dNr.my(com.baidu.swan.apps.model.b.bZ(kVar.dFy, f.aAl().azS()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.dFy);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", my);
        f.aAl().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void kd(int i) {
        a(this.dNs.get(this.dNq), this.dNt.get(this.dNq));
        b(this.dNs.get(i), this.dNt.get(i));
    }

    public void tB(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dNt.size()) {
                if (!this.dNt.get(i2).dFy.equals(str)) {
                    i = i2 + 1;
                } else {
                    kd(i2);
                    this.dNq = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dNo == null || this.dNp == null) {
            return false;
        }
        an(SwanAppConfigData.rM(str4), SwanAppConfigData.rM(str3));
        tA(str3);
        tC(str);
        tD(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dNs.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aMW()) {
                next.setTextColor(SwanAppConfigData.rM(str2));
            } else {
                next.setTextColor(SwanAppConfigData.rM(str));
            }
        }
        return true;
    }

    private void tC(String str) {
        this.dNu = str;
    }

    private void tD(String str) {
        this.dNv = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!kh(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dNs.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dNt.get(i).dFz = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dNt.get(i).dFA = str3;
        }
        if (swanAppBottomTabIconView.aMW()) {
            return b(swanAppBottomTabIconView, this.dNt.get(i));
        }
        return a(swanAppBottomTabIconView, this.dNt.get(i));
    }

    public boolean ke(int i) {
        if (!kh(i)) {
            return false;
        }
        this.dNs.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kf(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (kh(i) && (swanAppBottomTabIconView = this.dNs.get(i)) != null) {
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

    public boolean av(int i, String str) {
        if (!kh(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dNs.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean kg(int i) {
        if (kh(i)) {
            this.dNs.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean kh(int i) {
        return this.dNs != null && i < this.dNs.size() && i >= 0;
    }

    public int tE(String str) {
        if (TextUtils.isEmpty(str) || this.dNt == null || this.dNt.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dNt.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dNt.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.dFy, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aMV() {
        return this.dNp;
    }
}
