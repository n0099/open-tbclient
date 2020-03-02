package com.baidu.swan.apps.r.c;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.y.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bxa = af.S(38.0f);
    private String bci;
    @Nullable
    private com.baidu.swan.apps.core.d.d biL;
    private int biN;
    private ShowConfirmBarLayout bja;
    @Nullable
    private String bwC;
    private a bxb;

    /* loaded from: classes11.dex */
    public interface a {
        void TC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bwC = (String) invoker.get("id");
        }
        this.bci = str;
        this.biL = TB();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.acF() == null) {
            aVar.cF(false);
        } else {
            aVar.cF(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Tu() {
        return this.bwC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bxb = aVar;
    }

    public void k(final int i, final int i2, final int i3, final int i4) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.l(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, int i2, int i3, int i4) {
        if (this.biL != null) {
            com.baidu.swan.apps.adaptation.b.d WE = f.WS().WE();
            if (this.biN != i3 && WE != null) {
                this.biN = i3;
                int i5 = this.bja == null ? 0 : bxa;
                int webViewScrollY = WE.getWebViewScrollY() + ((this.biL.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.biL.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.biL.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void Ty() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.Tz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tz() {
        if (this.biL != null && this.biN != 0) {
            this.biN = 0;
            if (this.biL.getWebViewContainer().getScrollY() > 0) {
                this.biL.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void fb(final int i) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.fc(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(int i) {
        Activity TA = TA();
        if (TA != null) {
            View decorView = TA.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bja == null) {
                this.bja = new ShowConfirmBarLayout(TA);
                this.bja.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.aH("onConfirmBtnClick", null);
                        if (c.this.bxb != null) {
                            c.this.bxb.TC();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bxa) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.bja, layoutParams);
            }
        }
    }

    public void TD() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.TE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TE() {
        Activity TA = TA();
        if (TA != null) {
            View decorView = TA.getWindow().getDecorView();
            if (this.bja != null && this.bja.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bja);
                this.bja = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d TB() {
        com.baidu.swan.apps.core.d.e GC = f.WS().GC();
        if (GC == null) {
            return null;
        }
        int Oq = GC.Oq();
        for (int i = 0; i < Oq; i++) {
            com.baidu.swan.apps.core.d.b ew = GC.ew(i);
            if (ew instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) ew;
                if (TextUtils.equals(dVar.NZ(), this.bci)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity TA() {
        e acF = e.acF();
        if (acF == null) {
            return null;
        }
        return acF.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + Tu() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
