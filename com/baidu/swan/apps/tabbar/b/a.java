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
    private c.f bkD;
    private View brH;
    private LinearLayout brI;
    private int brJ = 0;
    private d brK;
    private ArrayList<SwanAppBottomTabIconView> brL;
    private ArrayList<c.g> brM;
    private String brN;
    private String brO;

    public a(d dVar) {
        this.brK = dVar;
    }

    public void a(View view, Context context, String str) {
        boolean z;
        if (this.brK.Ev()) {
            c Ll = e.LD().Ll();
            if (Ll == null) {
                if (DEBUG) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            this.bkD = Ll.bkD;
            this.brM = this.bkD.bkS;
            int size = this.brM.size();
            this.brL = new ArrayList<>(size);
            this.brH = view.findViewById(a.f.bottom_bar_shadow);
            fp(this.bkD.bkR);
            this.brI = (LinearLayout) view.findViewById(a.f.ai_apps_bottom_tab);
            this.brI.setVisibility(0);
            this.brI.setBackgroundColor(this.bkD.mBackgroundColor);
            int displayWidth = z.getDisplayWidth(AppRuntime.getAppContext());
            final int i = 0;
            boolean z2 = false;
            while (i < size) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                c.g gVar = this.brM.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(gVar.bkT, !TextUtils.isEmpty(str) ? str : e.LD().Lo()) && !z2) {
                    b(swanAppBottomTabIconView, gVar);
                    this.brJ = i;
                    z = true;
                } else {
                    a(swanAppBottomTabIconView, gVar);
                    z = z2;
                }
                swanAppBottomTabIconView.setTextView(gVar.mText);
                swanAppBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.tabbar.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.fq(i);
                    }
                });
                this.brL.add(swanAppBottomTabIconView);
                this.brI.addView(swanAppBottomTabIconView, layoutParams);
                i++;
                z2 = z;
            }
        }
    }

    private void fp(int i) {
        if (AppRuntime.getAppContext() != null) {
            if (-1 == i) {
                this.brH.setVisibility(0);
                this.brH.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            } else if (-16777216 == i) {
                this.brH.setVisibility(0);
                this.brH.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_setting_aiapps_item_divider_color));
            } else {
                this.brH.setVisibility(0);
                this.brH.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_white));
            }
        }
    }

    private void iz(String str) {
        this.brI.setBackgroundColor(c.bR(str));
    }

    private boolean a(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b AJ = AJ();
        if (AJ == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(AJ);
        if (TextUtils.isEmpty(m)) {
            m = e.d.am(AJ.getAppId(), AJ.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.bkU;
        if (com.baidu.swan.c.a.lJ(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.brN == null) {
                swanAppBottomTabIconView.setTextColor(this.bkD.mColor);
            } else {
                swanAppBottomTabIconView.setTextColor(c.bR(this.brN));
            }
            return true;
        }
        return false;
    }

    private boolean b(SwanAppBottomTabIconView swanAppBottomTabIconView, c.g gVar) {
        com.baidu.swan.apps.v.b.b AJ = AJ();
        if (AJ == null) {
            return false;
        }
        String m = com.baidu.swan.apps.ac.a.a.m(AJ);
        if (TextUtils.isEmpty(m)) {
            m = e.d.am(AJ.getAppId(), AJ.getVersion()).getPath();
        }
        String str = m + File.separator + gVar.bkV;
        if (com.baidu.swan.c.a.lJ(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            swanAppBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.brO == null) {
                swanAppBottomTabIconView.setTextColor(this.bkD.bkQ);
            } else {
                swanAppBottomTabIconView.setTextColor(c.bR(this.brO));
            }
            return true;
        }
        return false;
    }

    private com.baidu.swan.apps.v.b.b AJ() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            return QZ.AJ();
        }
        return null;
    }

    public boolean cS(boolean z) {
        if (this.brH == null || this.brI == null) {
            return false;
        }
        this.brH.setVisibility(8);
        if (z) {
            TE();
        } else {
            this.brI.setVisibility(8);
        }
        return true;
    }

    public boolean cT(boolean z) {
        if (this.brH == null || this.brI == null) {
            return false;
        }
        this.brH.setVisibility(0);
        this.brI.setVisibility(0);
        cU(z);
        return true;
    }

    private void TE() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.brI, "translationY", 0.0f, com.baidu.swan.apps.u.a.Ji().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.tabbar.b.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.brI.setVisibility(8);
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.brI, "translationY", com.baidu.swan.apps.u.a.Ji().getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        fs(i);
        fr(i);
        if (this.brJ != i) {
            this.brJ = i;
            this.brK.pause();
            this.brK.c(com.baidu.swan.apps.model.b.ay(this.brM.get(i).bkT, com.baidu.swan.apps.w.e.LD().Lm()));
            d dVar = this.brK;
            d.ew("switchTab");
            this.brK.resume();
        }
    }

    private void fr(int i) {
        HashMap hashMap = new HashMap();
        c.g gVar = this.brM.get(i);
        String ey = this.brK.ey(com.baidu.swan.apps.model.b.ay(gVar.bkT, com.baidu.swan.apps.w.e.LD().Lm()).aTe);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", gVar.bkT);
        hashMap.put("text", gVar.mText);
        hashMap.put("wvID", ey);
        com.baidu.swan.apps.w.e.LD().a(new com.baidu.swan.apps.m.a.b("onTabItemTap", hashMap));
    }

    private void fs(int i) {
        a(this.brL.get(this.brJ), this.brM.get(this.brJ));
        b(this.brL.get(i), this.brM.get(i));
    }

    public void iA(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.brM.size()) {
                if (!this.brM.get(i2).bkT.equals(str)) {
                    i = i2 + 1;
                } else {
                    fs(i2);
                    this.brJ = i2;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean n(String str, String str2, String str3, String str4) {
        if (this.brH == null || this.brI == null) {
            return false;
        }
        fp(c.bR(str4));
        iz(str3);
        iB(str);
        iC(str2);
        Iterator<SwanAppBottomTabIconView> it = this.brL.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.TF()) {
                next.setTextColor(c.bR(str2));
            } else {
                next.setTextColor(c.bR(str));
            }
        }
        return true;
    }

    private void iB(String str) {
        this.brN = str;
    }

    private void iC(String str) {
        this.brO = str;
    }

    public boolean c(int i, String str, String str2, String str3) {
        if (!fw(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.brL.get(i);
        swanAppBottomTabIconView.setTextView(str);
        this.brM.get(i).bkU = str2;
        this.brM.get(i).bkV = str3;
        if (swanAppBottomTabIconView.TF()) {
            return b(swanAppBottomTabIconView, this.brM.get(i));
        }
        return a(swanAppBottomTabIconView, this.brM.get(i));
    }

    public boolean ft(int i) {
        if (!fw(i)) {
            return false;
        }
        this.brL.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean fu(int i) {
        if (fw(i)) {
            this.brL.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean w(int i, String str) {
        if (!fw(i)) {
            return false;
        }
        SwanAppBottomTabIconView swanAppBottomTabIconView = this.brL.get(i);
        swanAppBottomTabIconView.setBadgeVisibleState(true);
        swanAppBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean fv(int i) {
        if (fw(i)) {
            this.brL.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean fw(int i) {
        return this.brL != null && i < this.brL.size() && i >= 0;
    }

    public int iD(String str) {
        if (TextUtils.isEmpty(str) || this.brM == null || this.brM.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.brM.size()) {
                return -1;
            }
            c.g gVar = this.brM.get(i2);
            if (gVar == null || !TextUtils.equals(gVar.bkT, str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}
