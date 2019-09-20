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
    private c.f aRz;
    private View aYF;
    private LinearLayout aYG;
    private int aYH = 0;
    private d aYI;
    private ArrayList<SwanAppBottomTabIconView> aYJ;
    private ArrayList<c.g> aYK;
    private String aYL;
    private String aYM;

    public a(d dVar) {
        this.aYI = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.aYI.zA()) {
            c Gr = e.GJ().Gr();
            if (Gr == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.aRz = Gr.aRz;
            this.aYK = this.aRz.aRO;
            int size = this.aYK.size();
            this.aYJ = new ArrayList<>(size);
            this.aYF = view.findViewById(a.f.bottom_bar_shadow);
            eu(this.aRz.aRN);
            this.aYG = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.aYG.setVisibility(0);
            this.aYG.setBackgroundColor(this.aRz.mBackgroundColor);
            int displayWidth = z.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.aYK.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.aRP, !TextUtils.isEmpty(str) ? str : e.GJ().Gu()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.aYH = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.anb);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.ev(i);
                    }
                });
                this.aYJ.add(swanAppBottomTabIconView);
                this.aYG.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void eu(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.aYF.setVisibility(0);
                this.aYF.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.aYF.setVisibility(0);
                this.aYF.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.aYF.setVisibility(0);
                this.aYF.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void hV(String str) {
        this.aYG.setBackgroundColor(c.cE(str));
    }

    private boolean a(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b vP = vP();
        if (vP == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(vP);
        if (TextUtils.isEmpty(m)) {
            m = e.d.ae(vP.getAppId(), vP.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.aRQ;
        if (com.baidu.swan.c.a.lh(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aYL == null) {
                swanAppBottomTabIconView.setTextColor(this.aRz.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(c.cE(this.aYL));
            }
            return true;
        }
        return false;
    }

    private boolean b(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b vP = vP();
        if (vP == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(vP);
        if (TextUtils.isEmpty(m)) {
            m = e.d.ae(vP.getAppId(), vP.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.aRR;
        if (com.baidu.swan.c.a.lh(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.aYM == null) {
                swanAppBottomTabIconView.setTextColor(this.aRz.aRM);
            } else {
                swanAppBottomTabIconView.setTextColor(c.cE(this.aYM));
            }
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b vP() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            return Mh.vP();
        }
        return null;
    }

    public boolean cB(boolean z) {
        if (this.aYF == null || this.aYG == null) {
            return false;
        }
        this.aYF.setVisibility(8);
        if (z) {
            OO();
        } else {
            this.aYG.setVisibility(8);
        }
        return true;
    }

    public boolean cC(boolean z) {
        if (this.aYF == null || this.aYG == null) {
            return false;
        }
        this.aYF.setVisibility(0);
        this.aYG.setVisibility(0);
        cD(z);
        return true;
    }

    private void OO() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYG, "translationY", 0.0f, com.baidu.swan.apps.u.a.Eo().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.aYG.setVisibility(8);
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

    private void cD(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYG, "translationY", com.baidu.swan.apps.u.a.Eo().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        ex(i);
        ew(i);
        if (this.aYH != i) {
            this.aYH = i;
            this.aYI.pause();
            this.aYI.c(com.baidu.swan.apps.model.b.aq(this.aYK.get(i).aRP, com.baidu.swan.apps.w.e.GJ().Gs()));
            d dVar = this.aYI;
            d.dO("switchTab");
            this.aYI.resume();
        }
    }

    private void ew(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.aYK.get(i);
        String dQ = this.aYI.dQ(com.baidu.swan.apps.model.b.aq(gVar.aRP, com.baidu.swan.apps.w.e.GJ().Gs()).azQ);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.aRP);
        hashMap.put("text", gVar.anb);
        hashMap.put("wvID", dQ);
        com.baidu.swan.apps.w.e.GJ().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void ex(int i) {
        a(this.aYJ.get(this.aYH), this.aYK.get(this.aYH));
        b(this.aYJ.get(i), this.aYK.get(i));
    }

    public void hW(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aYK.size()) {
                if (!this.aYK.get(i2).aRP.equals(str)) {
                    i = i2 + 1;
                } else {
                    ex(i2);
                    this.aYH = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean k(String str, String str2, String str3, String str4) {
        if (this.aYF == null || this.aYG == null) {
            return false;
        }
        eu(c.cE(str4));
        hV(str3);
        hX(str);
        hY(str2);
        Iterator<SwanAppBottomTabIconView> it = this.aYJ.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.OP()) {
                next.setTextColor(c.cE(str2));
            } else {
                next.setTextColor(c.cE(str));
            }
        }
        return true;
    }

    private void hX(String str) {
        this.aYL = str;
    }

    private void hY(String str) {
        this.aYM = str;
    }

    public boolean c(int i, String str, String str2, String str3) {
        if (!eB(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aYJ.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.aYK.get(i).aRQ = str2;
        this.aYK.get(i).aRR = str3;
        if (swanAppBottomTabIconView.OP()) {
            return b(swanAppBottomTabIconView, this.aYK.get(i));
        }
        return a(swanAppBottomTabIconView, this.aYK.get(i));
    }

    public boolean ey(int i) {
        if (!eB(i)) {
            return false;
        }
        this.aYJ.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean ez(int i) {
        if (eB(i)) {
            this.aYJ.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean s(int i, String str) {
        if (!eB(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.aYJ.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean eA(int i) {
        if (eB(i)) {
            this.aYJ.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean eB(int i) {
        return this.aYJ != null && i < this.aYJ.size() && i >= 0;
    }

    public int hZ(String str) {
        if (TextUtils.isEmpty(str) || this.aYK == null || this.aYK.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aYK.size()) {
                return -1;
            }
            c.g gVar = this.aYK.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.aRP, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
