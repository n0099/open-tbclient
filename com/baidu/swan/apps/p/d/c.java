package com.baidu.swan.apps.p.d;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.p.d;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cmI = ai.D(38.0f);
    private String bOl;
    @Nullable
    private e bVK;
    private int bVM;
    private ShowConfirmBarLayout bVZ;
    private a cmJ;
    @Nullable
    private String cmj;

    /* loaded from: classes7.dex */
    public interface a {
        void agL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cmj = (String) invoker.get("id");
        }
        this.bOl = str;
        this.bVK = agK();
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.arv() == null) {
            aVar.ed(false);
        } else {
            aVar.ed(true);
        }
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String agD() {
        return this.cmj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cmJ = aVar;
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        al.p(new Runnable() { // from class: com.baidu.swan.apps.p.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.bVK != null) {
            com.baidu.swan.apps.adaptation.b.d akc = f.akr().akc();
            if (this.bVM != i3 && akc != null) {
                this.bVM = i3;
                int i5 = this.bVZ == null ? 0 : cmI;
                int webViewScrollY = akc.getWebViewScrollY() + ((this.bVK.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.bVK.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.bVK.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void agH() {
        al.p(new Runnable() { // from class: com.baidu.swan.apps.p.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.agI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agI() {
        if (this.bVK != null && this.bVM != 0) {
            this.bVM = 0;
            if (this.bVK.getWebViewContainer().getScrollY() > 0) {
                this.bVK.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void fO(final int i) {
        al.p(new Runnable() { // from class: com.baidu.swan.apps.p.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.fP(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(int i) {
        Activity agJ = agJ();
        if (agJ != null) {
            View decorView = agJ.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.bVZ == null) {
                this.bVZ = new ShowConfirmBarLayout(agJ);
                this.bVZ.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.p.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bm("onConfirmBtnClick", null);
                        if (c.this.cmJ != null) {
                            c.this.cmJ.agL();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - cmI;
                frameLayout.addView(this.bVZ, layoutParams);
            }
        }
    }

    public void agM() {
        al.p(new Runnable() { // from class: com.baidu.swan.apps.p.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.agN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agN() {
        Activity agJ = agJ();
        if (agJ != null) {
            View decorView = agJ.getWindow().getDecorView();
            if (this.bVZ != null && this.bVZ.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.bVZ);
                this.bVZ = null;
            }
        }
    }

    public void release() {
    }

    @Nullable
    private e agK() {
        com.baidu.swan.apps.core.d.f Sc = f.akr().Sc();
        if (Sc == null) {
            return null;
        }
        int abc = Sc.abc();
        for (int i = 0; i < abc; i++) {
            com.baidu.swan.apps.core.d.c fc = Sc.fc(i);
            if (fc instanceof e) {
                e eVar = (e) fc;
                if (TextUtils.equals(eVar.aaL(), this.bOl)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    private Activity agJ() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv == null) {
            return null;
        }
        return arv.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + agD() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
