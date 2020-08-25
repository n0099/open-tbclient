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
/* loaded from: classes8.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int ctZ = ah.H(38.0f);
    private String bTJ;
    private ShowConfirmBarLayout cbH;
    @Nullable
    private e cbs;
    private int cbu;
    @Nullable
    private String ctq;
    private a cua;

    /* loaded from: classes8.dex */
    public interface a {
        void aod();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.ctq = (String) invoker.get("id");
        }
        this.bTJ = str;
        this.cbs = anS();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.azI() == null) {
            aVar.eq(false);
        } else {
            aVar.eq(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String anL() {
        return this.ctq;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.bTJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cua = aVar;
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
        if (this.cbs != null) {
            com.baidu.swan.apps.adaptation.b.d arJ = f.arY().arJ();
            if (this.cbu != i3 && arJ != null) {
                this.cbu = i3;
                int i5 = this.cbH == null ? 0 : ctZ;
                int webViewScrollY = arJ.getWebViewScrollY() + ((this.cbs.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cbs.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cbs.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void anP() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.anQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anQ() {
        if (this.cbs != null && this.cbu != 0) {
            this.cbu = 0;
            if (this.cbs.getWebViewContainer().getScrollY() > 0) {
                this.cbs.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void hS(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.hT(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT(int i) {
        Activity anR = anR();
        if (anR != null) {
            View decorView = anR.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cbH == null) {
                this.cbH = new ShowConfirmBarLayout(anR);
                this.cbH.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bw("onConfirmBtnClick", null);
                        if (c.this.cua != null) {
                            c.this.cua.aod();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - ctZ;
                frameLayout.addView(this.cbH, layoutParams);
            }
        }
    }

    public void aoe() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.aof();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aof() {
        Activity anR = anR();
        if (anR != null) {
            View decorView = anR.getWindow().getDecorView();
            if (this.cbH != null && this.cbH.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cbH);
                this.cbH = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e anS() {
        com.baidu.swan.apps.core.d.f XX = f.arY().XX();
        if (XX == null) {
            return null;
        }
        int ahp = XX.ahp();
        for (int i = 0; i < ahp; i++) {
            com.baidu.swan.apps.core.d.c gY = XX.gY(i);
            if (gY instanceof e) {
                e eVar = (e) gY;
                if (TextUtils.equals(eVar.agW(), this.bTJ)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity anR() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI == null) {
            return null;
        }
        return azI.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + anL() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
