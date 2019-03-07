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
import com.baidu.swan.apps.ae.a.c;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.core.c.d;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.swan.apps.w.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    private c.f aOj;
    private ArrayList<SwanAppBottomTabIconView> aUA;
    private ArrayList<c.g> aUB;
    private String aUC;
    private String aUD;
    private View aUw;
    private LinearLayout aUx;
    private int aUy = 0;
    private d aUz;

    public a(d dVar) {
        this.aUz = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.aUz.xY()) {
            com.baidu.swan.apps.ae.a.c DK = e.Ec().DK();
            if (DK == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.aOj = DK.aOj;
            this.aUB = this.aOj.aOy;
            int size = this.aUB.size();
            this.aUA = new ArrayList<>(size);
            this.aUw = view.findViewById(b.f.bottom_bar_shadow);
            eg(this.aOj.aOx);
            this.aUx = (LinearLayout) view.findViewById(b.f.ai_apps_bottom_tab);
            this.aUx.setVisibility(0);
            this.aUx.setBackgroundColor(this.aOj.mBackgroundColor);
            int displayWidth = x.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.aUB.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.aOz, !TextUtils.isEmpty(str) ? str : e.Ec().DN()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.aUy = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.alI);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.eh(i);
                    }
                });
                this.aUA.add(swanAppBottomTabIconView);
                this.aUx.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void eg(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.aUw.setVisibility(0);
                this.aUw.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(b.c.aiapps_white));
            } else if (-16777216 == i) {
                this.aUw.setVisibility(0);
                this.aUw.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(b.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.aUw.setVisibility(0);
                this.aUw.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(b.c.aiapps_white));
            }
        }
    }

    private void hk(String str) {
        this.aUx.setBackgroundColor(com.baidu.swan.apps.ae.a.c.parseColor(str));
    }

    private boolean a(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b uB = uB();
        if (uB == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(uB);
        if (TextUtils.isEmpty(m)) {
            m = c.d.ah(uB.mAppId, uB.mVersion).getPath();
        }
        String str = m + File.separator + gVar.aOA;
        if (com.baidu.swan.c.b.jX(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aUC == null) {
                swanAppBottomTabIconView.setTextColor(this.aOj.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(this.aUC));
            }
            return true;
        }
        return false;
    }

    private boolean b(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b uB = uB();
        if (uB == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(uB);
        if (TextUtils.isEmpty(m)) {
            m = c.d.ah(uB.mAppId, uB.mVersion).getPath();
        }
        String str = m + File.separator + gVar.aOB;
        if (com.baidu.swan.c.b.jX(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aUD == null) {
                swanAppBottomTabIconView.setTextColor(this.aOj.aOw);
            } else {
                swanAppBottomTabIconView.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(this.aUD));
            }
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b uB() {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            return IX.uB();
        }
        return null;
    }

    public boolean cj(boolean z) {
        if (this.aUw == null || this.aUx == null) {
            return false;
        }
        this.aUw.setVisibility(8);
        if (z) {
            Lu();
        } else {
            this.aUx.setVisibility(8);
        }
        return true;
    }

    public boolean ck(boolean z) {
        if (this.aUw == null || this.aUx == null) {
            return false;
        }
        this.aUw.setVisibility(0);
        this.aUx.setVisibility(0);
        cl(z);
        return true;
    }

    private void Lu() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUx, "translationY", 0.0f, com.baidu.swan.apps.u.a.Cy().getResources().getDimensionPixelSize(b.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.aUx.setVisibility(8);
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

    private void cl(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUx, "translationY", com.baidu.swan.apps.u.a.Cy().getResources().getDimensionPixelSize(b.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh(int i) {
        ej(i);
        ei(i);
        if (this.aUy != i) {
            this.aUy = i;
            this.aUz.pause();
            this.aUz.c(com.baidu.swan.apps.model.b.ap(this.aUB.get(i).aOz, e.Ec().DL()));
            d dVar = this.aUz;
            d.dT("switchTab");
            this.aUz.resume();
        }
    }

    private void ei(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.aUB.get(i);
        String dV = this.aUz.dV(com.baidu.swan.apps.model.b.ap(gVar.aOz, e.Ec().DL()).axH);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.aOz);
        hashMap.put("text", gVar.alI);
        hashMap.put("wvID", dV);
        e.Ec().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void ej(int i) {
        a(this.aUA.get(this.aUy), this.aUB.get(this.aUy));
        b(this.aUA.get(i), this.aUB.get(i));
    }

    public void hl(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aUB.size()) {
                if (!this.aUB.get(i2).aOz.equals(str)) {
                    i = i2 + 1;
                } else {
                    ej(i2);
                    this.aUy = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean k(String str, String str2, String str3, String str4) {
        if (this.aUw == null || this.aUx == null) {
            return false;
        }
        eg(com.baidu.swan.apps.ae.a.c.parseColor(str4));
        hk(str3);
        hm(str);
        hn(str2);
        Iterator<SwanAppBottomTabIconView> it = this.aUA.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.Lv()) {
                next.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(str2));
            } else {
                next.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(str));
            }
        }
        return true;
    }

    private void hm(String str) {
        this.aUC = str;
    }

    private void hn(String str) {
        this.aUD = str;
    }

    public boolean b(int i, String str, String str2, String str3) {
        if (!en(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aUA.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.aUB.get(i).aOA = str2;
        this.aUB.get(i).aOB = str3;
        if (swanAppBottomTabIconView.Lv()) {
            return b(swanAppBottomTabIconView, this.aUB.get(i));
        }
        return a(swanAppBottomTabIconView, this.aUB.get(i));
    }

    public boolean ek(int i) {
        if (!en(i)) {
            return false;
        }
        this.aUA.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean el(int i) {
        if (en(i)) {
            this.aUA.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean r(int i, String str) {
        if (!en(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aUA.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean em(int i) {
        if (en(i)) {
            this.aUA.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean en(int i) {
        return this.aUA != null && i < this.aUA.size() && i >= 0;
    }

    public int ho(String str) {
        if (TextUtils.isEmpty(str) || this.aUB == null || this.aUB.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aUB.size()) {
                return -1;
            }
            c.g gVar = this.aUB.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.aOz, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
