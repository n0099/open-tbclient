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
    private static final int dfI = ah.T(38.0f);
    private String cFI;
    private ShowConfirmBarLayout cNG;
    @Nullable
    private e cNr;
    private int cNt;
    private a dfJ;
    @Nullable
    private String dfd;

    /* loaded from: classes8.dex */
    public interface a {
        void awt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dfd = (String) invoker.get("id");
        }
        this.cFI = str;
        this.cNr = awi();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aIN() == null) {
            aVar.fG(false);
        } else {
            aVar.fG(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String awb() {
        return this.dfd;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cFI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.dfJ = aVar;
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cNr != null) {
            com.baidu.swan.apps.adaptation.b.d azZ = f.aAo().azZ();
            if (this.cNt != i3 && azZ != null) {
                this.cNt = i3;
                int i5 = this.cNG == null ? 0 : dfI;
                int webViewScrollY = azZ.getWebViewScrollY() + ((this.cNr.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cNr.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cNr.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void awf() {
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.awg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awg() {
        if (this.cNr != null && this.cNt != 0) {
            this.cNt = 0;
            if (this.cNr.getWebViewContainer().getScrollY() > 0) {
                this.cNr.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void hG(final int i) {
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.hH(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(int i) {
        Activity awh = awh();
        if (awh != null) {
            View decorView = awh.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cNG == null) {
                this.cNG = new ShowConfirmBarLayout(awh);
                this.cNG.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bG("onConfirmBtnClick", null);
                        if (c.this.dfJ != null) {
                            c.this.dfJ.awt();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - dfI;
                frameLayout.addView(this.cNG, layoutParams);
            }
        }
    }

    public void awu() {
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.awv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awv() {
        Activity awh = awh();
        if (awh != null) {
            View decorView = awh.getWindow().getDecorView();
            if (this.cNG != null && this.cNG.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cNG);
                this.cNG = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e awi() {
        com.baidu.swan.apps.core.d.f aga = f.aAo().aga();
        if (aga == null) {
            return null;
        }
        int apD = aga.apD();
        for (int i = 0; i < apD; i++) {
            com.baidu.swan.apps.core.d.c gM = aga.gM(i);
            if (gM instanceof e) {
                e eVar = (e) gM;
                if (TextUtils.equals(eVar.apk(), this.cFI)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity awh() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null) {
            return null;
        }
        return aIN.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + awb() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
