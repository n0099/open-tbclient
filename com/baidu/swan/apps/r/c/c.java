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
/* loaded from: classes9.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bsb = af.T(38.0f);
    private String aXf;
    @Nullable
    private com.baidu.swan.apps.core.d.d bdG;
    private int bdI;
    private ShowConfirmBarLayout bdV;
    @Nullable
    private String brD;
    private a bsc;

    /* loaded from: classes9.dex */
    public interface a {
        void QQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.brD = (String) invoker.get("id");
        }
        this.aXf = str;
        this.bdG = QP();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.ZS() == null) {
            aVar.ct(false);
        } else {
            aVar.ct(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String QI() {
        return this.brD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bsc = aVar;
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
        if (this.bdG != null) {
            com.baidu.swan.apps.adaptation.b.d TR = f.Uf().TR();
            if (this.bdI != i3 && TR != null) {
                this.bdI = i3;
                int i5 = this.bdV == null ? 0 : bsb;
                int webViewScrollY = TR.getWebViewScrollY() + ((this.bdG.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.bdG.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.bdG.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void QM() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.QN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QN() {
        if (this.bdG != null && this.bdI != 0) {
            this.bdI = 0;
            if (this.bdG.getWebViewContainer().getScrollY() > 0) {
                this.bdG.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void eK(final int i) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.eL(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(int i) {
        Activity QO = QO();
        if (QO != null) {
            View decorView = QO.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bdV == null) {
                this.bdV = new ShowConfirmBarLayout(QO);
                this.bdV.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.aw("onConfirmBtnClick", null);
                        if (c.this.bsc != null) {
                            c.this.bsc.QQ();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bsb) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.bdV, layoutParams);
            }
        }
    }

    public void QR() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.QS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QS() {
        Activity QO = QO();
        if (QO != null) {
            View decorView = QO.getWindow().getDecorView();
            if (this.bdV != null && this.bdV.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bdV);
                this.bdV = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d QP() {
        com.baidu.swan.apps.core.d.e DP = f.Uf().DP();
        if (DP == null) {
            return null;
        }
        int LE = DP.LE();
        for (int i = 0; i < LE; i++) {
            com.baidu.swan.apps.core.d.b ef = DP.ef(i);
            if (ef instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) ef;
                if (TextUtils.equals(dVar.Ln(), this.aXf)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity QO() {
        e ZS = e.ZS();
        if (ZS == null) {
            return null;
        }
        return ZS.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + QI() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
