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
    private static final int bwZ = af.S(38.0f);
    private String bch;
    @Nullable
    private com.baidu.swan.apps.core.d.d biK;
    private int biM;
    private ShowConfirmBarLayout biZ;
    @Nullable
    private String bwB;
    private a bxa;

    /* loaded from: classes11.dex */
    public interface a {
        void TA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bwB = (String) invoker.get("id");
        }
        this.bch = str;
        this.biK = Tz();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.acD() == null) {
            aVar.cF(false);
        } else {
            aVar.cF(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Ts() {
        return this.bwB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bxa = aVar;
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
        if (this.biK != null) {
            com.baidu.swan.apps.adaptation.b.d WC = f.WQ().WC();
            if (this.biM != i3 && WC != null) {
                this.biM = i3;
                int i5 = this.biZ == null ? 0 : bwZ;
                int webViewScrollY = WC.getWebViewScrollY() + ((this.biK.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.biK.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.biK.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void Tw() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.Tx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tx() {
        if (this.biK != null && this.biM != 0) {
            this.biM = 0;
            if (this.biK.getWebViewContainer().getScrollY() > 0) {
                this.biK.getWebViewContainer().setScrollY(0);
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
        Activity Ty = Ty();
        if (Ty != null) {
            View decorView = Ty.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.biZ == null) {
                this.biZ = new ShowConfirmBarLayout(Ty);
                this.biZ.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.aH("onConfirmBtnClick", null);
                        if (c.this.bxa != null) {
                            c.this.bxa.TA();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bwZ) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.biZ, layoutParams);
            }
        }
    }

    public void TB() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.TC();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TC() {
        Activity Ty = Ty();
        if (Ty != null) {
            View decorView = Ty.getWindow().getDecorView();
            if (this.biZ != null && this.biZ.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.biZ);
                this.biZ = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d Tz() {
        com.baidu.swan.apps.core.d.e GA = f.WQ().GA();
        if (GA == null) {
            return null;
        }
        int Oo = GA.Oo();
        for (int i = 0; i < Oo; i++) {
            com.baidu.swan.apps.core.d.b ew = GA.ew(i);
            if (ew instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) ew;
                if (TextUtils.equals(dVar.NX(), this.bch)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity Ty() {
        e acD = e.acD();
        if (acD == null) {
            return null;
        }
        return acD.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + Ts() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
