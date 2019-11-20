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
    private c.f bkl;
    private View bqQ;
    private LinearLayout bqR;
    private int bqS = 0;
    private d bqT;
    private ArrayList<SwanAppBottomTabIconView> bqU;
    private ArrayList<c.g> bqV;
    private String bqW;
    private String bqX;

    public a(d dVar) {
        this.bqT = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.bqT.Ew()) {
            c Lm = e.LE().Lm();
            if (Lm == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bkl = Lm.bkl;
            this.bqV = this.bkl.bkA;
            int size = this.bqV.size();
            this.bqU = new ArrayList<>(size);
            this.bqQ = view.findViewById(a.f.bottom_bar_shadow);
            fo(this.bkl.bkz);
            this.bqR = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.bqR.setVisibility(0);
            this.bqR.setBackgroundColor(this.bkl.mBackgroundColor);
            int displayWidth = z.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.bqV.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.bkB, !TextUtils.isEmpty(str) ? str : e.LE().Lp()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.bqS = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.fp(i);
                    }
                });
                this.bqU.add(swanAppBottomTabIconView);
                this.bqR.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void fo(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.bqQ.setVisibility(0);
                this.bqQ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.bqQ.setVisibility(0);
                this.bqQ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.bqQ.setVisibility(0);
                this.bqQ.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void iz(String str) {
        this.bqR.setBackgroundColor(c.bR(str));
    }

    private boolean a(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b AK = AK();
        if (AK == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(AK);
        if (TextUtils.isEmpty(m)) {
            m = e.d.am(AK.getAppId(), AK.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.bkC;
        if (com.baidu.swan.c.a.lJ(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.bqW == null) {
                swanAppBottomTabIconView.setTextColor(this.bkl.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(c.bR(this.bqW));
            }
            return true;
        }
        return false;
    }

    private boolean b(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b AK = AK();
        if (AK == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(AK);
        if (TextUtils.isEmpty(m)) {
            m = e.d.am(AK.getAppId(), AK.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.bkD;
        if (com.baidu.swan.c.a.lJ(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.bqX == null) {
                swanAppBottomTabIconView.setTextColor(this.bkl.bky);
            } else {
                swanAppBottomTabIconView.setTextColor(c.bR(this.bqX));
            }
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b AK() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            return Ra.AK();
        }
        return null;
    }

    public boolean cS(boolean z) {
        if (this.bqQ == null || this.bqR == null) {
            return false;
        }
        this.bqQ.setVisibility(8);
        if (z) {
            TC();
        } else {
            this.bqR.setVisibility(8);
        }
        return true;
    }

    public boolean cT(boolean z) {
        if (this.bqQ == null || this.bqR == null) {
            return false;
        }
        this.bqQ.setVisibility(0);
        this.bqR.setVisibility(0);
        cU(z);
        return true;
    }

    private void TC() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bqR, "translationY", 0.0f, com.baidu.swan.apps.u.a.Jj().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.bqR.setVisibility(8);
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

    private void cU(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bqR, "translationY", com.baidu.swan.apps.u.a.Jj().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(int i) {
        fr(i);
        fq(i);
        if (this.bqS != i) {
            this.bqS = i;
            this.bqT.pause();
            this.bqT.c(com.baidu.swan.apps.model.b.ay(this.bqV.get(i).bkB, com.baidu.swan.apps.w.e.LE().Ln()));
            d dVar = this.bqT;
            d.ew("switchTab");
            this.bqT.resume();
        }
    }

    private void fq(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.bqV.get(i);
        String ey = this.bqT.ey(com.baidu.swan.apps.model.b.ay(gVar.bkB, com.baidu.swan.apps.w.e.LE().Ln()).aSM);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.bkB);
        hashMap.put("text", gVar.mText);
        hashMap.put("wvID", ey);
        com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void fr(int i) {
        a(this.bqU.get(this.bqS), this.bqV.get(this.bqS));
        b(this.bqU.get(i), this.bqV.get(i));
    }

    public void iA(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bqV.size()) {
                if (!this.bqV.get(i2).bkB.equals(str)) {
                    i = i2 + 1;
                } else {
                    fr(i2);
                    this.bqS = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean n(String str, String str2, String str3, String str4) {
        if (this.bqQ == null || this.bqR == null) {
            return false;
        }
        fo(c.bR(str4));
        iz(str3);
        iB(str);
        iC(str2);
        Iterator<SwanAppBottomTabIconView> it = this.bqU.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.TD()) {
                next.setTextColor(c.bR(str2));
            } else {
                next.setTextColor(c.bR(str));
            }
        }
        return true;
    }

    private void iB(String str) {
        this.bqW = str;
    }

    private void iC(String str) {
        this.bqX = str;
    }

    public boolean c(int i, String str, String str2, String str3) {
        if (!fv(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bqU.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.bqV.get(i).bkC = str2;
        this.bqV.get(i).bkD = str3;
        if (swanAppBottomTabIconView.TD()) {
            return b(swanAppBottomTabIconView, this.bqV.get(i));
        }
        return a(swanAppBottomTabIconView, this.bqV.get(i));
    }

    public boolean fs(int i) {
        if (!fv(i)) {
            return false;
        }
        this.bqU.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean ft(int i) {
        if (fv(i)) {
            this.bqU.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean v(int i, String str) {
        if (!fv(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.bqU.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean fu(int i) {
        if (fv(i)) {
            this.bqU.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean fv(int i) {
        return this.bqU != null && i < this.bqU.size() && i >= 0;
    }

    public int iD(String str) {
        if (TextUtils.isEmpty(str) || this.bqV == null || this.bqV.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bqV.size()) {
                return -1;
            }
            c.g gVar = this.bqV.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.bkB, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
