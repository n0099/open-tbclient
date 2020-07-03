package com.baidu.swan.apps.p.c;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.p.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.w.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int ckD = ag.D(38.0f);
    private String bNv;
    @Nullable
    private com.baidu.swan.apps.core.d.d bUS;
    private int bUU;
    private ShowConfirmBarLayout bVh;
    private a ckE;
    @Nullable
    private String ckf;

    /* loaded from: classes11.dex */
    public interface a {
        void afA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.ckf = (String) invoker.get("id");
        }
        this.bNv = str;
        this.bUS = afz();
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull d.a aVar) {
        if (e.apM() == null) {
            aVar.dX(false);
        } else {
            aVar.dX(true);
        }
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String afs() {
        return this.ckf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.ckE = aVar;
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.bUS != null) {
            com.baidu.swan.apps.adaptation.b.d aiM = f.ajb().aiM();
            if (this.bUU != i3 && aiM != null) {
                this.bUU = i3;
                int i5 = this.bVh == null ? 0 : ckD;
                int webViewScrollY = aiM.getWebViewScrollY() + ((this.bUS.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.bUS.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.bUS.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void afw() {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.afx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afx() {
        if (this.bUS != null && this.bUU != 0) {
            this.bUU = 0;
            if (this.bUS.getWebViewContainer().getScrollY() > 0) {
                this.bUS.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void fE(final int i) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.fF(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(int i) {
        Activity afy = afy();
        if (afy != null) {
            View decorView = afy.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bVh == null) {
                this.bVh = new ShowConfirmBarLayout(afy);
                this.bVh.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.p.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bi("onConfirmBtnClick", null);
                        if (c.this.ckE != null) {
                            c.this.ckE.afA();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - ckD;
                frameLayout.addView(this.bVh, layoutParams);
            }
        }
    }

    public void afB() {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.afC();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afC() {
        Activity afy = afy();
        if (afy != null) {
            View decorView = afy.getWindow().getDecorView();
            if (this.bVh != null && this.bVh.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bVh);
                this.bVh = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d afz() {
        com.baidu.swan.apps.core.d.e RN = f.ajb().RN();
        if (RN == null) {
            return null;
        }
        int ZY = RN.ZY();
        for (int i = 0; i < ZY; i++) {
            com.baidu.swan.apps.core.d.b eX = RN.eX(i);
            if (eX instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eX;
                if (TextUtils.equals(dVar.ZH(), this.bNv)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity afy() {
        e apM = e.apM();
        if (apM == null) {
            return null;
        }
        return apM.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + afs() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
