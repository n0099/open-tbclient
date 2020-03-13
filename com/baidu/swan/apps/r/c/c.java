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
    private static final int bxb = af.S(38.0f);
    private String bcj;
    @Nullable
    private com.baidu.swan.apps.core.d.d biM;
    private int biO;
    private ShowConfirmBarLayout bjb;
    @Nullable
    private String bwD;
    private a bxc;

    /* loaded from: classes11.dex */
    public interface a {
        void TC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bwD = (String) invoker.get("id");
        }
        this.bcj = str;
        this.biM = TB();
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
        return this.bwD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bxc = aVar;
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
        if (this.biM != null) {
            com.baidu.swan.apps.adaptation.b.d WE = f.WS().WE();
            if (this.biO != i3 && WE != null) {
                this.biO = i3;
                int i5 = this.bjb == null ? 0 : bxb;
                int webViewScrollY = WE.getWebViewScrollY() + ((this.biM.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.biM.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.biM.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
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
        if (this.biM != null && this.biO != 0) {
            this.biO = 0;
            if (this.biM.getWebViewContainer().getScrollY() > 0) {
                this.biM.getWebViewContainer().setScrollY(0);
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
            if (this.bjb == null) {
                this.bjb = new ShowConfirmBarLayout(TA);
                this.bjb.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.aH("onConfirmBtnClick", null);
                        if (c.this.bxc != null) {
                            c.this.bxc.TC();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bxb) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.bjb, layoutParams);
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
            if (this.bjb != null && this.bjb.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bjb);
                this.bjb = null;
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
                if (TextUtils.equals(dVar.NZ(), this.bcj)) {
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
