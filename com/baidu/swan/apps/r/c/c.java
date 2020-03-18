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
    private static final int bxn = af.S(38.0f);
    private String bcw;
    @Nullable
    private com.baidu.swan.apps.core.d.d biZ;
    private int bjb;
    private ShowConfirmBarLayout bjo;
    @Nullable
    private String bwP;
    private a bxo;

    /* loaded from: classes11.dex */
    public interface a {
        void TF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bwP = (String) invoker.get("id");
        }
        this.bcw = str;
        this.biZ = TE();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.acI() == null) {
            aVar.cG(false);
        } else {
            aVar.cG(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Tx() {
        return this.bwP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bxo = aVar;
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
        if (this.biZ != null) {
            com.baidu.swan.apps.adaptation.b.d WH = f.WV().WH();
            if (this.bjb != i3 && WH != null) {
                this.bjb = i3;
                int i5 = this.bjo == null ? 0 : bxn;
                int webViewScrollY = WH.getWebViewScrollY() + ((this.biZ.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.biZ.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.biZ.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void TB() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.TC();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TC() {
        if (this.biZ != null && this.bjb != 0) {
            this.bjb = 0;
            if (this.biZ.getWebViewContainer().getScrollY() > 0) {
                this.biZ.getWebViewContainer().setScrollY(0);
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
        Activity TD = TD();
        if (TD != null) {
            View decorView = TD.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bjo == null) {
                this.bjo = new ShowConfirmBarLayout(TD);
                this.bjo.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.r.c.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.aG("onConfirmBtnClick", null);
                        if (c.this.bxo != null) {
                            c.this.bxo.TF();
                        }
                    }
                });
                layoutParams.topMargin = ((decorView.getHeight() - i) - bxn) - af.getNavigationBarHeight();
                ((FrameLayout) decorView.findViewById(16908290)).addView(this.bjo, layoutParams);
            }
        }
    }

    public void TG() {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.TH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TH() {
        Activity TD = TD();
        if (TD != null) {
            View decorView = TD.getWindow().getDecorView();
            if (this.bjo != null && this.bjo.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bjo);
                this.bjo = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d TE() {
        com.baidu.swan.apps.core.d.e GH = f.WV().GH();
        if (GH == null) {
            return null;
        }
        int Ot = GH.Ot();
        for (int i = 0; i < Ot; i++) {
            com.baidu.swan.apps.core.d.b ew = GH.ew(i);
            if (ew instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) ew;
                if (TextUtils.equals(dVar.Oc(), this.bcw)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity TD() {
        e acI = e.acI();
        if (acI == null) {
            return null;
        }
        return acI.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + Tx() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
