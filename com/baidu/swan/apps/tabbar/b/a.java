package com.baidu.swan.apps.tabbar.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ae.a.c;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.w.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private c.f aQr;
    private d aXA;
    private ArrayList<SwanAppBottomTabIconView> aXB;
    private ArrayList<c.g> aXC;
    private String aXD;
    private String aXE;
    private View aXx;
    private LinearLayout aXy;
    private int aXz = 0;

    public a(d dVar) {
        this.aXA = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.aXA.yP()) {
            c FD = e.FV().FD();
            if (FD == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.aQr = FD.aQr;
            this.aXC = this.aQr.aQG;
            int size = this.aXC.size();
            this.aXB = new ArrayList<>(size);
            this.aXx = view.findViewById(a.f.bottom_bar_shadow);
            eq(this.aQr.aQF);
            this.aXy = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.aXy.setVisibility(0);
            this.aXy.setBackgroundColor(this.aQr.mBackgroundColor);
            int displayWidth = z.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.aXC.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.aQH, !TextUtils.isEmpty(str) ? str : e.FV().FG()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.aXz = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.ama);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.er(i);
                    }
                });
                this.aXB.add(swanAppBottomTabIconView);
                this.aXy.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void eq(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.aXx.setVisibility(0);
                this.aXx.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.aXx.setVisibility(0);
                this.aXx.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.aXx.setVisibility(0);
                this.aXx.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void hN(String str) {
        this.aXy.setBackgroundColor(c.parseColor(str));
    }

    private boolean a(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b vk = vk();
        if (vk == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(vk);
        if (TextUtils.isEmpty(m)) {
            m = e.d.ae(vk.getAppId(), vk.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.aQI;
        if (com.baidu.swan.c.a.kY(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aXD == null) {
                swanAppBottomTabIconView.setTextColor(this.aQr.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(c.parseColor(this.aXD));
            }
            return true;
        }
        return false;
    }

    private boolean b(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b vk = vk();
        if (vk == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(vk);
        if (TextUtils.isEmpty(m)) {
            m = e.d.ae(vk.getAppId(), vk.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.aQJ;
        if (com.baidu.swan.c.a.kY(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aXE == null) {
                swanAppBottomTabIconView.setTextColor(this.aQr.aQE);
            } else {
                swanAppBottomTabIconView.setTextColor(c.parseColor(this.aXE));
            }
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b vk() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            return Lq.vk();
        }
        return null;
    }

    public boolean cy(boolean z) {
        if (this.aXx == null || this.aXy == null) {
            return false;
        }
        this.aXx.setVisibility(8);
        if (z) {
            NV();
        } else {
            this.aXy.setVisibility(8);
        }
        return true;
    }

    public boolean cz(boolean z) {
        if (this.aXx == null || this.aXy == null) {
            return false;
        }
        this.aXx.setVisibility(0);
        this.aXy.setVisibility(0);
        cA(z);
        return true;
    }

    private void NV() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aXy, "translationY", 0.0f, com.baidu.swan.apps.u.a.DB().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.aXy.setVisibility(8);
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

    private void cA(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aXy, "translationY", com.baidu.swan.apps.u.a.DB().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(int i) {
        et(i);
        es(i);
        if (this.aXz != i) {
            this.aXz = i;
            this.aXA.pause();
            this.aXA.c(com.baidu.swan.apps.model.b.aq(this.aXC.get(i).aQH, com.baidu.swan.apps.w.e.FV().FE()));
            d dVar = this.aXA;
            d.dI("switchTab");
            this.aXA.resume();
        }
    }

    private void es(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.aXC.get(i);
        String dK = this.aXA.dK(com.baidu.swan.apps.model.b.aq(gVar.aQH, com.baidu.swan.apps.w.e.FV().FE()).ayL);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.aQH);
        hashMap.put("text", gVar.ama);
        hashMap.put("wvID", dK);
        com.baidu.swan.apps.w.e.FV().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void et(int i) {
        a(this.aXB.get(this.aXz), this.aXC.get(this.aXz));
        b(this.aXB.get(i), this.aXC.get(i));
    }

    public void hO(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aXC.size()) {
                if (!this.aXC.get(i2).aQH.equals(str)) {
                    i = i2 + 1;
                } else {
                    et(i2);
                    this.aXz = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean k(String str, String str2, String str3, String str4) {
        if (this.aXx == null || this.aXy == null) {
            return false;
        }
        eq(c.parseColor(str4));
        hN(str3);
        hP(str);
        hQ(str2);
        Iterator<SwanAppBottomTabIconView> it = this.aXB.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.NW()) {
                next.setTextColor(c.parseColor(str2));
            } else {
                next.setTextColor(c.parseColor(str));
            }
        }
        return true;
    }

    private void hP(String str) {
        this.aXD = str;
    }

    private void hQ(String str) {
        this.aXE = str;
    }

    public boolean b(int i, String str, String str2, String str3) {
        if (!ex(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aXB.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.aXC.get(i).aQI = str2;
        this.aXC.get(i).aQJ = str3;
        if (swanAppBottomTabIconView.NW()) {
            return b(swanAppBottomTabIconView, this.aXC.get(i));
        }
        return a(swanAppBottomTabIconView, this.aXC.get(i));
    }

    public boolean eu(int i) {
        if (!ex(i)) {
            return false;
        }
        this.aXB.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean ev(int i) {
        if (ex(i)) {
            this.aXB.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean s(int i, String str) {
        if (!ex(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aXB.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean ew(int i) {
        if (ex(i)) {
            this.aXB.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean ex(int i) {
        return this.aXB != null && i < this.aXB.size() && i >= 0;
    }

    public int hR(String str) {
        if (TextUtils.isEmpty(str) || this.aXC == null || this.aXC.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aXC.size()) {
                return -1;
            }
            c.g gVar = this.aXC.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.aQH, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
