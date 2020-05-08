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
    private static final int bVz = af.C(38.0f);
    private String bAP;
    private ShowConfirmBarLayout bHB;
    @Nullable
    private com.baidu.swan.apps.core.d.d bHm;
    private int bHo;
    private a bVA;
    @Nullable
    private String bVb;

    /* loaded from: classes11.dex */
    public interface a {
        void abt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bVb = (String) invoker.get("id");
        }
        this.bAP = str;
        this.bHm = abs();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.akM() == null) {
            aVar.dC(false);
        } else {
            aVar.dC(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String abl() {
        return this.bVb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bVA = aVar;
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
        if (this.bHm != null) {
            com.baidu.swan.apps.adaptation.b.d aev = f.aeJ().aev();
            if (this.bHo != i3 && aev != null) {
                this.bHo = i3;
                int i5 = this.bHB == null ? 0 : bVz;
                int webViewScrollY = aev.getWebViewScrollY() + ((this.bHm.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.bHm.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.bHm.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void abp() {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.abq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abq() {
        if (this.bHm != null && this.bHo != 0) {
            this.bHo = 0;
            if (this.bHm.getWebViewContainer().getScrollY() > 0) {
                this.bHm.getWebViewContainer().setScrollY(0);
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
        Activity abr = abr();
        if (abr != null) {
            View decorView = abr.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bHB == null) {
                this.bHB = new ShowConfirmBarLayout(abr);
                this.bHB.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.aP("onConfirmBtnClick", null);
                        if (c.this.bVA != null) {
                            c.this.bVA.abt();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bVz) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.bHB, layoutParams);
            }
        }
    }

    public void abu() {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.abv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abv() {
        Activity abr = abr();
        if (abr != null) {
            View decorView = abr.getWindow().getDecorView();
            if (this.bHB != null && this.bHB.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bHB);
                this.bHB = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d abs() {
        com.baidu.swan.apps.core.d.e Ot = f.aeJ().Ot();
        if (Ot == null) {
            return null;
        }
        int Wg = Ot.Wg();
        for (int i = 0; i < Wg; i++) {
            com.baidu.swan.apps.core.d.b eB = Ot.eB(i);
            if (eB instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eB;
                if (TextUtils.equals(dVar.VP(), this.bAP)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity abr() {
        e akM = e.akM();
        if (akM == null) {
            return null;
        }
        return akM.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + abl() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
