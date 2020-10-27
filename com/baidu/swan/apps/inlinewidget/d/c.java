package com.baidu.swan.apps.inlinewidget.d;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cQI = ah.L(38.0f);
    private a cQJ;
    @Nullable
    private String cQd;
    private String cqC;
    private ShowConfirmBarLayout cyF;
    @Nullable
    private e cyq;
    private int cys;

    /* loaded from: classes10.dex */
    public interface a {
        void atu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cQd = (String) invoker.get("id");
        }
        this.cqC = str;
        this.cyq = atj();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aEU() == null) {
            aVar.eY(false);
        } else {
            aVar.eY(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String atc() {
        return this.cQd;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cqC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cQJ = aVar;
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.cyq != null) {
            com.baidu.swan.apps.adaptation.b.d awZ = f.axo().awZ();
            if (this.cys != i3 && awZ != null) {
                this.cys = i3;
                int i5 = this.cyF == null ? 0 : cQI;
                int webViewScrollY = awZ.getWebViewScrollY() + ((this.cyq.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cyq.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cyq.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void atg() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.ath();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ath() {
        if (this.cyq != null && this.cys != 0) {
            this.cys = 0;
            if (this.cyq.getWebViewContainer().getScrollY() > 0) {
                this.cyq.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void iJ(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.iK(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iK(int i) {
        Activity ati = ati();
        if (ati != null) {
            View decorView = ati.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cyF == null) {
                this.cyF = new ShowConfirmBarLayout(ati);
                this.cyF.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bI("onConfirmBtnClick", null);
                        if (c.this.cQJ != null) {
                            c.this.cQJ.atu();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - cQI;
                frameLayout.addView(this.cyF, layoutParams);
            }
        }
    }

    public void atv() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.atw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atw() {
        Activity ati = ati();
        if (ati != null) {
            View decorView = ati.getWindow().getDecorView();
            if (this.cyF != null && this.cyF.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cyF);
                this.cyF = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e atj() {
        com.baidu.swan.apps.core.d.f adm = f.axo().adm();
        if (adm == null) {
            return null;
        }
        int amE = adm.amE();
        for (int i = 0; i < amE; i++) {
            com.baidu.swan.apps.core.d.c hP = adm.hP(i);
            if (hP instanceof e) {
                e eVar = (e) hP;
                if (TextUtils.equals(eVar.aml(), this.cqC)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity ati() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU == null) {
            return null;
        }
        return aEU.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + atc() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
