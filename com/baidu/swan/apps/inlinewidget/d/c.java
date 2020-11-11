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
    private static final int cWB = ah.N(38.0f);
    @Nullable
    private e cEj;
    private int cEl;
    private ShowConfirmBarLayout cEy;
    @Nullable
    private String cVW;
    private a cWC;
    private String cwA;

    /* loaded from: classes10.dex */
    public interface a {
        void avU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cVW = (String) invoker.get("id");
        }
        this.cwA = str;
        this.cEj = avJ();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aHu() == null) {
            aVar.fh(false);
        } else {
            aVar.fh(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avC() {
        return this.cVW;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cwA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cWC = aVar;
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
        if (this.cEj != null) {
            com.baidu.swan.apps.adaptation.b.d azz = f.azO().azz();
            if (this.cEl != i3 && azz != null) {
                this.cEl = i3;
                int i5 = this.cEy == null ? 0 : cWB;
                int webViewScrollY = azz.getWebViewScrollY() + ((this.cEj.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cEj.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cEj.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void avG() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.avH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avH() {
        if (this.cEj != null && this.cEl != 0) {
            this.cEl = 0;
            if (this.cEj.getWebViewContainer().getScrollY() > 0) {
                this.cEj.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void iT(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.iU(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU(int i) {
        Activity avI = avI();
        if (avI != null) {
            View decorView = avI.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cEy == null) {
                this.cEy = new ShowConfirmBarLayout(avI);
                this.cEy.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bI("onConfirmBtnClick", null);
                        if (c.this.cWC != null) {
                            c.this.cWC.avU();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - cWB;
                frameLayout.addView(this.cEy, layoutParams);
            }
        }
    }

    public void avV() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.avW();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avW() {
        Activity avI = avI();
        if (avI != null) {
            View decorView = avI.getWindow().getDecorView();
            if (this.cEy != null && this.cEy.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cEy);
                this.cEy = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e avJ() {
        com.baidu.swan.apps.core.d.f afM = f.azO().afM();
        if (afM == null) {
            return null;
        }
        int ape = afM.ape();
        for (int i = 0; i < ape; i++) {
            com.baidu.swan.apps.core.d.c hZ = afM.hZ(i);
            if (hZ instanceof e) {
                e eVar = (e) hZ;
                if (TextUtils.equals(eVar.aoL(), this.cwA)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity avI() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu == null) {
            return null;
        }
        return aHu.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + avC() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
