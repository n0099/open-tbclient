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
/* loaded from: classes10.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bsP = af.S(38.0f);
    private String aXX;
    private ShowConfirmBarLayout beL;
    @Nullable
    private com.baidu.swan.apps.core.d.d bew;
    private int bey;
    private a bsQ;
    @Nullable
    private String bsr;

    /* loaded from: classes10.dex */
    public interface a {
        void Rm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bsr = (String) invoker.get("id");
        }
        this.aXX = str;
        this.bew = Rl();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.aap() == null) {
            aVar.cy(false);
        } else {
            aVar.cy(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Re() {
        return this.bsr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bsQ = aVar;
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
        if (this.bew != null) {
            com.baidu.swan.apps.adaptation.b.d Uo = f.UC().Uo();
            if (this.bey != i3 && Uo != null) {
                this.bey = i3;
                int i5 = this.beL == null ? 0 : bsP;
                int webViewScrollY = Uo.getWebViewScrollY() + ((this.bew.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.bew.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.bew.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void Ri() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.Rj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rj() {
        if (this.bew != null && this.bey != 0) {
            this.bey = 0;
            if (this.bew.getWebViewContainer().getScrollY() > 0) {
                this.bew.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void eL(final int i) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.eM(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(int i) {
        Activity Rk = Rk();
        if (Rk != null) {
            View decorView = Rk.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.beL == null) {
                this.beL = new ShowConfirmBarLayout(Rk);
                this.beL.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.ax("onConfirmBtnClick", null);
                        if (c.this.bsQ != null) {
                            c.this.bsQ.Rm();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bsP) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.beL, layoutParams);
            }
        }
    }

    public void Rn() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.Ro();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ro() {
        Activity Rk = Rk();
        if (Rk != null) {
            View decorView = Rk.getWindow().getDecorView();
            if (this.beL != null && this.beL.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.beL);
                this.beL = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d Rl() {
        com.baidu.swan.apps.core.d.e El = f.UC().El();
        if (El == null) {
            return null;
        }
        int Ma = El.Ma();
        for (int i = 0; i < Ma; i++) {
            com.baidu.swan.apps.core.d.b eg = El.eg(i);
            if (eg instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eg;
                if (TextUtils.equals(dVar.LJ(), this.aXX)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity Rk() {
        e aap = e.aap();
        if (aap == null) {
            return null;
        }
        return aap.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + Re() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
