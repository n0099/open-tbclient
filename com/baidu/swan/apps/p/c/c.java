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
    private static final int cfP = ag.B(38.0f);
    private String bIH;
    @Nullable
    private com.baidu.swan.apps.core.d.d bQe;
    private int bQg;
    private ShowConfirmBarLayout bQt;
    private a cfQ;
    @Nullable
    private String cfr;

    /* loaded from: classes11.dex */
    public interface a {
        void aeu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cfr = (String) invoker.get("id");
        }
        this.bIH = str;
        this.bQe = aet();
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull d.a aVar) {
        if (e.aoF() == null) {
            aVar.dS(false);
        } else {
            aVar.dS(true);
        }
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String aem() {
        return this.cfr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cfQ = aVar;
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
        if (this.bQe != null) {
            com.baidu.swan.apps.adaptation.b.d ahG = f.ahV().ahG();
            if (this.bQg != i3 && ahG != null) {
                this.bQg = i3;
                int i5 = this.bQt == null ? 0 : cfP;
                int webViewScrollY = ahG.getWebViewScrollY() + ((this.bQe.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.bQe.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.bQe.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void aeq() {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.aer();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        if (this.bQe != null && this.bQg != 0) {
            this.bQg = 0;
            if (this.bQe.getWebViewContainer().getScrollY() > 0) {
                this.bQe.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void ft(final int i) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.fu(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(int i) {
        Activity aes = aes();
        if (aes != null) {
            View decorView = aes.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bQt == null) {
                this.bQt = new ShowConfirmBarLayout(aes);
                this.bQt.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.p.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bg("onConfirmBtnClick", null);
                        if (c.this.cfQ != null) {
                            c.this.cfQ.aeu();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - cfP;
                frameLayout.addView(this.bQt, layoutParams);
            }
        }
    }

    public void aev() {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.aew();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aew() {
        Activity aes = aes();
        if (aes != null) {
            View decorView = aes.getWindow().getDecorView();
            if (this.bQt != null && this.bQt.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bQt);
                this.bQt = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d aet() {
        com.baidu.swan.apps.core.d.e QH = f.ahV().QH();
        if (QH == null) {
            return null;
        }
        int YS = QH.YS();
        for (int i = 0; i < YS; i++) {
            com.baidu.swan.apps.core.d.b eM = QH.eM(i);
            if (eM instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eM;
                if (TextUtils.equals(dVar.YB(), this.bIH)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity aes() {
        e aoF = e.aoF();
        if (aoF == null) {
            return null;
        }
        return aoF.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + aem() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
