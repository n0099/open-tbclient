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
/* loaded from: classes8.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int dbT = ah.O(38.0f);
    private String cBM;
    @Nullable
    private e cJD;
    private int cJF;
    private ShowConfirmBarLayout cJS;
    private a dbU;
    @Nullable
    private String dbo;

    /* loaded from: classes8.dex */
    public interface a {
        void avS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dbo = (String) invoker.get("id");
        }
        this.cBM = str;
        this.cJD = avH();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aIr() == null) {
            aVar.fE(false);
        } else {
            aVar.fE(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avA() {
        return this.dbo;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cBM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.dbU = aVar;
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cJD != null) {
            com.baidu.swan.apps.adaptation.b.d azy = f.azN().azy();
            if (this.cJF != i3 && azy != null) {
                this.cJF = i3;
                int i5 = this.cJS == null ? 0 : dbT;
                int webViewScrollY = azy.getWebViewScrollY() + ((this.cJD.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cJD.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cJD.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void avE() {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.avF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avF() {
        if (this.cJD != null && this.cJF != 0) {
            this.cJF = 0;
            if (this.cJD.getWebViewContainer().getScrollY() > 0) {
                this.cJD.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void hC(final int i) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.hD(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hD(int i) {
        Activity avG = avG();
        if (avG != null) {
            View decorView = avG.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cJS == null) {
                this.cJS = new ShowConfirmBarLayout(avG);
                this.cJS.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bM("onConfirmBtnClick", null);
                        if (c.this.dbU != null) {
                            c.this.dbU.avS();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - dbT;
                frameLayout.addView(this.cJS, layoutParams);
            }
        }
    }

    public void avT() {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.avU();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avU() {
        Activity avG = avG();
        if (avG != null) {
            View decorView = avG.getWindow().getDecorView();
            if (this.cJS != null && this.cJS.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cJS);
                this.cJS = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e avH() {
        com.baidu.swan.apps.core.d.f afz = f.azN().afz();
        if (afz == null) {
            return null;
        }
        int apb = afz.apb();
        for (int i = 0; i < apb; i++) {
            com.baidu.swan.apps.core.d.c gI = afz.gI(i);
            if (gI instanceof e) {
                e eVar = (e) gI;
                if (TextUtils.equals(eVar.aoI(), this.cBM)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity avG() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr == null) {
            return null;
        }
        return aIr.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + avA() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
