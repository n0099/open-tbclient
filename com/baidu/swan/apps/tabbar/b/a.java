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
    private SwanAppConfigData.j dGu;
    private View dOP;
    private LinearLayout dOQ;
    private int dOR = 0;
    private e dOS;
    private ArrayList<SwanAppBottomTabIconView> dOT;
    private ArrayList<SwanAppConfigData.k> dOU;
    private String dOV;
    private String dOW;

    public a(e eVar) {
        this.dOS = eVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.dOS.aoj()) {
            SwanAppConfigData azT = f.aAo().azT();
            if (azT == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.dGu = azT.dGu;
            this.dOU = this.dGu.dGY;
            int size = this.dOU.size();
            this.dOT = new ArrayList<>(size);
            this.dOP = view.findViewById(a.f.bottom_bar_shadow);
            an(this.dGu.dGX, this.dGu.mBackgroundColor);
            this.dOQ = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.dOQ.setVisibility(0);
            this.dOQ.setBackgroundColor(this.dGu.mBackgroundColor);
            int displayWidth = ah.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.dOU.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.dGZ, !TextUtils.isEmpty(str) ? str : f.aAo().azX()) && !z2) {
                    b(swanAppBottomTabIconView, kVar);
                    this.dOR = i;
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
                this.dOT.add(swanAppBottomTabIconView);
                this.dOQ.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    public boolean apg() {
        return this.dOQ != null && this.dOQ.getVisibility() == 0;
    }

    private void an(int i, int i2) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.dOP.setVisibility(0);
                this.dOP.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.dOP.setVisibility(0);
                this.dOP.setBackgroundColor(i2);
            } else {
                this.dOP.setVisibility(0);
                this.dOP.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void tH(String str) {
        this.dOQ.setBackgroundColor(SwanAppConfigData.rT(str));
    }

    private boolean a(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b ago = ago();
        if (ago == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(ago);
        if (TextUtils.isEmpty(k)) {
            k = d.C0452d.bL(ago.getAppId(), ago.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dHa;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dOV == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dGu.mColor);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.rT(a.this.dOV));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private boolean b(final SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        com.baidu.swan.apps.u.c.b ago = ago();
        if (ago == null) {
            return false;
        }
        String k = com.baidu.swan.apps.ad.a.a.k(ago);
        if (TextUtils.isEmpty(k)) {
            k = d.C0452d.bL(ago.getAppId(), ago.getVersion()).getPath();
        }
        String str = k + File.separator + kVar.dHb;
        if (com.baidu.swan.c.d.isExistFile(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    swanAppBottomTabIconView.setIconView(decodeFile);
                    if (a.this.dOW == null) {
                        swanAppBottomTabIconView.setTextColor(a.this.dGu.dGW);
                    } else {
                        swanAppBottomTabIconView.setTextColor(SwanAppConfigData.rT(a.this.dOW));
                    }
                }
            });
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.u.c.b ago() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null) {
            return aIN.agc();
        }
        return null;
    }

    public boolean hv(boolean z) {
        if (this.dOP == null || this.dOQ == null) {
            return false;
        }
        this.dOP.setVisibility(8);
        if (z) {
            aMX();
        } else {
            this.dOQ.setVisibility(8);
        }
        return true;
    }

    public boolean hw(boolean z) {
        if (this.dOP == null || this.dOQ == null) {
            return false;
        }
        this.dOP.setVisibility(0);
        this.dOQ.setVisibility(0);
        hx(z);
        return true;
    }

    private void aMX() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dOQ, "translationY", 0.0f, com.baidu.swan.apps.t.a.awZ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.dOQ.setVisibility(8);
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dOQ, "translationY", com.baidu.swan.apps.t.a.awZ().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc(int i) {
        String uuid = UUID.randomUUID().toString();
        j.qF(uuid);
        ke(i);
        kd(i);
        if (this.dOR != i) {
            this.dOR = i;
            this.dOS.pause();
            this.dOS.b(com.baidu.swan.apps.model.b.bZ(this.dOU.get(i).dGZ, f.aAo().azV()), uuid);
            e.mD("switchTab");
            this.dOS.resume();
        }
    }

    private void kd(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.dOU.get(i);
        String mF = this.dOS.mF(com.baidu.swan.apps.model.b.bZ(kVar.dGZ, f.aAo().azV()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.dGZ);
        hashMap.put("text", kVar.mText);
        hashMap.put("wvID", mF);
        f.aAo().b(new com.baidu.swan.apps.event.a.b("onTabItemTap", hashMap));
    }

    private void ke(int i) {
        a(this.dOT.get(this.dOR), this.dOU.get(this.dOR));
        b(this.dOT.get(i), this.dOU.get(i));
    }

    public void tI(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dOU.size()) {
                if (!this.dOU.get(i2).dGZ.equals(str)) {
                    i = i2 + 1;
                } else {
                    ke(i2);
                    this.dOR = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean s(String str, String str2, String str3, String str4) {
        if (this.dOP == null || this.dOQ == null) {
            return false;
        }
        an(SwanAppConfigData.rT(str4), SwanAppConfigData.rT(str3));
        tH(str3);
        tJ(str);
        tK(str2);
        Iterator<SwanAppBottomTabIconView> it = this.dOT.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.aMZ()) {
                next.setTextColor(SwanAppConfigData.rT(str2));
            } else {
                next.setTextColor(SwanAppConfigData.rT(str));
            }
        }
        return true;
    }

    private void tJ(String str) {
        this.dOV = str;
    }

    private void tK(String str) {
        this.dOW = str;
    }

    public boolean b(int i, final String str, String str2, String str3) {
        if (!ki(i)) {
            return false;
        }
        final SwanAppBottomTabIconView swanAppBottomTabIconView = this.dOT.get(i);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.tabbar.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                swanAppBottomTabIconView.setTextView(str);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            this.dOU.get(i).dHa = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.dOU.get(i).dHb = str3;
        }
        if (swanAppBottomTabIconView.aMZ()) {
            return b(swanAppBottomTabIconView, this.dOU.get(i));
        }
        return a(swanAppBottomTabIconView, this.dOU.get(i));
    }

    public boolean kf(int i) {
        if (!ki(i)) {
            return false;
        }
        this.dOT.get(i).setRedDotVisibleState(true);
        return true;
    }

    @AnyThread
    public boolean kg(int i) {
        final SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (ki(i) && (swanAppBottomTabIconView = this.dOT.get(i)) != null) {
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
        if (!ki(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.dOT.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean kh(int i) {
        if (ki(i)) {
            this.dOT.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean ki(int i) {
        return this.dOT != null && i < this.dOT.size() && i >= 0;
    }

    public int tL(String str) {
        if (TextUtils.isEmpty(str) || this.dOU == null || this.dOU.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dOU.size()) {
                return -1;
            }
            SwanAppConfigData.k kVar = this.dOU.get(i2);
            if (kVar == null || !TextUtils.equals(kVar.dGZ, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public LinearLayout aMY() {
        return this.dOQ;
    }
}
