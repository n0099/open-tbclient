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
/* loaded from: classes7.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cUR = ah.M(38.0f);
    private int cCB;
    private ShowConfirmBarLayout cCO;
    @Nullable
    private e cCz;
    private a cUS;
    @Nullable
    private String cUm;
    private String cuQ;

    /* loaded from: classes7.dex */
    public interface a {
        void avm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cUm = (String) invoker.get("id");
        }
        this.cuQ = str;
        this.cCz = avb();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aGM() == null) {
            aVar.fk(false);
        } else {
            aVar.fk(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String auU() {
        return this.cUm;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cuQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cUS = aVar;
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
        if (this.cCz != null) {
            com.baidu.swan.apps.adaptation.b.d ayR = f.azg().ayR();
            if (this.cCB != i3 && ayR != null) {
                this.cCB = i3;
                int i5 = this.cCO == null ? 0 : cUR;
                int webViewScrollY = ayR.getWebViewScrollY() + ((this.cCz.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cCz.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cCz.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void auY() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.auZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auZ() {
        if (this.cCz != null && this.cCB != 0) {
            this.cCB = 0;
            if (this.cCz.getWebViewContainer().getScrollY() > 0) {
                this.cCz.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void iP(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.iQ(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ(int i) {
        Activity ava = ava();
        if (ava != null) {
            View decorView = ava.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cCO == null) {
                this.cCO = new ShowConfirmBarLayout(ava);
                this.cCO.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bH("onConfirmBtnClick", null);
                        if (c.this.cUS != null) {
                            c.this.cUS.avm();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - cUR;
                frameLayout.addView(this.cCO, layoutParams);
            }
        }
    }

    public void avn() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.avo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avo() {
        Activity ava = ava();
        if (ava != null) {
            View decorView = ava.getWindow().getDecorView();
            if (this.cCO != null && this.cCO.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cCO);
                this.cCO = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e avb() {
        com.baidu.swan.apps.core.d.f afe = f.azg().afe();
        if (afe == null) {
            return null;
        }
        int aow = afe.aow();
        for (int i = 0; i < aow; i++) {
            com.baidu.swan.apps.core.d.c hV = afe.hV(i);
            if (hV instanceof e) {
                e eVar = (e) hV;
                if (TextUtils.equals(eVar.aod(), this.cuQ)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity ava() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM == null) {
            return null;
        }
        return aGM.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + auU() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
