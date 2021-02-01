package com.baidu.swan.apps.inlinewidget.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int deg = ah.P(38.0f);
    private String cEi;
    @Nullable
    private e cLR;
    private int cLT;
    private ShowConfirmBarLayout cMg;
    @Nullable
    private String ddB;
    private a deh;

    /* loaded from: classes9.dex */
    public interface a {
        void awq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.ddB = (String) invoker.get("id");
        }
        this.cEi = str;
        this.cLR = awf();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aIK() == null) {
            aVar.fG(false);
        } else {
            aVar.fG(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avY() {
        return this.ddB;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cEi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.deh = aVar;
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cLR != null) {
            com.baidu.swan.apps.adaptation.b.d azW = f.aAl().azW();
            if (this.cLT != i3 && azW != null) {
                this.cLT = i3;
                int i5 = this.cMg == null ? 0 : deg;
                int webViewScrollY = azW.getWebViewScrollY() + ((this.cLR.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cLR.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cLR.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void awc() {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.awd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awd() {
        if (this.cLR != null && this.cLT != 0) {
            this.cLT = 0;
            if (this.cLR.getWebViewContainer().getScrollY() > 0) {
                this.cLR.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void hF(final int i) {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.hG(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG(int i) {
        Activity awe = awe();
        if (awe != null) {
            View decorView = awe.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cMg == null) {
                this.cMg = new ShowConfirmBarLayout(awe);
                this.cMg.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bG("onConfirmBtnClick", null);
                        if (c.this.deh != null) {
                            c.this.deh.awq();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - deg;
                frameLayout.addView(this.cMg, layoutParams);
            }
        }
    }

    public void awr() {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.aws();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aws() {
        Activity awe = awe();
        if (awe != null) {
            View decorView = awe.getWindow().getDecorView();
            if (this.cMg != null && this.cMg.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cMg);
                this.cMg = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e awf() {
        com.baidu.swan.apps.core.d.f afX = f.aAl().afX();
        if (afX == null) {
            return null;
        }
        int apA = afX.apA();
        for (int i = 0; i < apA; i++) {
            com.baidu.swan.apps.core.d.c gL = afX.gL(i);
            if (gL instanceof e) {
                e eVar = (e) gL;
                if (TextUtils.equals(eVar.apg(), this.cEi)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity awe() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK == null) {
            return null;
        }
        return aIK.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + avY() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
