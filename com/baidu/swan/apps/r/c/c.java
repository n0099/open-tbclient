package com.baidu.swan.apps.r.c;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.y.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bVt = af.C(38.0f);
    private String bAK;
    @Nullable
    private com.baidu.swan.apps.core.d.d bHh;
    private int bHj;
    private ShowConfirmBarLayout bHw;
    @Nullable
    private String bUV;
    private a bVu;

    /* loaded from: classes11.dex */
    public interface a {
        void abu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bUV = (String) invoker.get("id");
        }
        this.bAK = str;
        this.bHh = abt();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.akN() == null) {
            aVar.dC(false);
        } else {
            aVar.dC(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String abm() {
        return this.bUV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bVu = aVar;
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.bHh != null) {
            com.baidu.swan.apps.adaptation.b.d aew = f.aeK().aew();
            if (this.bHj != i3 && aew != null) {
                this.bHj = i3;
                int i5 = this.bHw == null ? 0 : bVt;
                int webViewScrollY = aew.getWebViewScrollY() + ((this.bHh.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.bHh.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.bHh.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void abq() {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.abr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abr() {
        if (this.bHh != null && this.bHj != 0) {
            this.bHj = 0;
            if (this.bHh.getWebViewContainer().getScrollY() > 0) {
                this.bHh.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void fg(final int i) {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.fh(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        Activity abs = abs();
        if (abs != null) {
            View decorView = abs.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bHw == null) {
                this.bHw = new ShowConfirmBarLayout(abs);
                this.bHw.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.aP("onConfirmBtnClick", null);
                        if (c.this.bVu != null) {
                            c.this.bVu.abu();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bVt) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.bHw, layoutParams);
            }
        }
    }

    public void abv() {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.abw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abw() {
        Activity abs = abs();
        if (abs != null) {
            View decorView = abs.getWindow().getDecorView();
            if (this.bHw != null && this.bHw.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bHw);
                this.bHw = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d abt() {
        com.baidu.swan.apps.core.d.e Ou = f.aeK().Ou();
        if (Ou == null) {
            return null;
        }
        int Wh = Ou.Wh();
        for (int i = 0; i < Wh; i++) {
            com.baidu.swan.apps.core.d.b eB = Ou.eB(i);
            if (eB instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eB;
                if (TextUtils.equals(dVar.VQ(), this.bAK)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity abs() {
        e akN = e.akN();
        if (akN == null) {
            return null;
        }
        return akN.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + abm() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
