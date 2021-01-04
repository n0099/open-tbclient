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
    private static final int dgI = ah.O(38.0f);
    private String cGy;
    private ShowConfirmBarLayout cOE;
    @Nullable
    private e cOp;
    private int cOr;
    private a dgJ;
    @Nullable
    private String dgd;

    /* loaded from: classes9.dex */
    public interface a {
        void azL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dgd = (String) invoker.get("id");
        }
        this.cGy = str;
        this.cOp = azA();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aMk() == null) {
            aVar.fI(false);
        } else {
            aVar.fI(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String azt() {
        return this.dgd;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cGy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.dgJ = aVar;
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
        if (this.cOp != null) {
            com.baidu.swan.apps.adaptation.b.d aDr = f.aDG().aDr();
            if (this.cOr != i3 && aDr != null) {
                this.cOr = i3;
                int i5 = this.cOE == null ? 0 : dgI;
                int webViewScrollY = aDr.getWebViewScrollY() + ((this.cOp.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cOp.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cOp.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void azx() {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.azy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azy() {
        if (this.cOp != null && this.cOr != 0) {
            this.cOr = 0;
            if (this.cOp.getWebViewContainer().getScrollY() > 0) {
                this.cOp.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void ji(final int i) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.jj(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(int i) {
        Activity azz = azz();
        if (azz != null) {
            View decorView = azz.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cOE == null) {
                this.cOE = new ShowConfirmBarLayout(azz);
                this.cOE.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bN("onConfirmBtnClick", null);
                        if (c.this.dgJ != null) {
                            c.this.dgJ.azL();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - dgI;
                frameLayout.addView(this.cOE, layoutParams);
            }
        }
    }

    public void azM() {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.azN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azN() {
        Activity azz = azz();
        if (azz != null) {
            View decorView = azz.getWindow().getDecorView();
            if (this.cOE != null && this.cOE.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cOE);
                this.cOE = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e azA() {
        com.baidu.swan.apps.core.d.f ajs = f.aDG().ajs();
        if (ajs == null) {
            return null;
        }
        int asW = ajs.asW();
        for (int i = 0; i < asW; i++) {
            com.baidu.swan.apps.core.d.c io2 = ajs.io(i);
            if (io2 instanceof e) {
                e eVar = (e) io2;
                if (TextUtils.equals(eVar.asD(), this.cGy)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity azz() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk == null) {
            return null;
        }
        return aMk.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + azt() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
