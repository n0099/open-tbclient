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
    private static final int cIm = ah.J(38.0f);
    @Nullable
    private String cHH;
    private a cIn;
    private String cib;
    @Nullable
    private e cpP;
    private int cpR;
    private ShowConfirmBarLayout cqe;

    /* loaded from: classes10.dex */
    public interface a {
        void arz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cHH = (String) invoker.get("id");
        }
        this.cib = str;
        this.cpP = aro();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aDa() == null) {
            aVar.eL(false);
        } else {
            aVar.eL(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String arh() {
        return this.cHH;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cib;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cIn = aVar;
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
        if (this.cpP != null) {
            com.baidu.swan.apps.adaptation.b.d avf = f.avu().avf();
            if (this.cpR != i3 && avf != null) {
                this.cpR = i3;
                int i5 = this.cqe == null ? 0 : cIm;
                int webViewScrollY = avf.getWebViewScrollY() + ((this.cpP.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cpP.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cpP.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void arl() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.arm();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arm() {
        if (this.cpP != null && this.cpR != 0) {
            this.cpR = 0;
            if (this.cpP.getWebViewContainer().getScrollY() > 0) {
                this.cpP.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void iy(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.iz(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz(int i) {
        Activity arn = arn();
        if (arn != null) {
            View decorView = arn.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cqe == null) {
                this.cqe = new ShowConfirmBarLayout(arn);
                this.cqe.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bB("onConfirmBtnClick", null);
                        if (c.this.cIn != null) {
                            c.this.cIn.arz();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - cIm;
                frameLayout.addView(this.cqe, layoutParams);
            }
        }
    }

    public void arA() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.arB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arB() {
        Activity arn = arn();
        if (arn != null) {
            View decorView = arn.getWindow().getDecorView();
            if (this.cqe != null && this.cqe.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cqe);
                this.cqe = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e aro() {
        com.baidu.swan.apps.core.d.f abs = f.avu().abs();
        if (abs == null) {
            return null;
        }
        int akK = abs.akK();
        for (int i = 0; i < akK; i++) {
            com.baidu.swan.apps.core.d.c hE = abs.hE(i);
            if (hE instanceof e) {
                e eVar = (e) hE;
                if (TextUtils.equals(eVar.akr(), this.cib)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity arn() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa == null) {
            return null;
        }
        return aDa.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + arh() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
