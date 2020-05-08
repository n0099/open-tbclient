package com.baidu.swan.apps.r.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.r.a.b.b;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.y.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bAP;
    private com.baidu.swan.apps.core.d.d bHm;
    private int bHo;
    private String bVb;
    private Handler bVc;
    private com.baidu.swan.apps.r.a.b.b bVd;
    private a bVe;
    private b.a bVf = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void jo(String str) {
            aP("onInput", "inputText: " + str);
            if (c.this.bVe != null) {
                c.this.bVe.jo(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void abm() {
            aP("onDeletePressed", null);
            if (c.this.bVe != null) {
                c.this.bVe.abm();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void el(int i) {
            aP("onKeyboardShow", "height: " + i);
            if (c.this.bVe != null) {
                c.this.bVe.el(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void SH() {
            aP("onKeyboardHide", null);
            if (c.this.bVe != null) {
                c.this.bVe.SH();
            }
        }

        private void aP(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.abl() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void SH();

        void abm();

        void el(int i);

        void jo(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bVb = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.abN();
        this.bAP = str;
        this.bVc = new Handler(this.mContext.getMainLooper());
        this.bHm = abs();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.akM() == null) {
            aVar.dC(false);
        } else {
            aVar.dC(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String abl() {
        return this.bVb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bVe = aVar;
    }

    public void fc(final int i) {
        this.bVc.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.fd(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        Activity abr = abr();
        if (abr != null) {
            this.bVd = new com.baidu.swan.apps.r.a.b.b(abr, i, this.bVf);
            this.bVd.show();
        }
    }

    public void abn() {
        this.bVc.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.abo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abo() {
        if (this.bVd != null) {
            this.bVd.dismiss();
            this.bVd = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.bVc.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.bHm != null) {
            com.baidu.swan.apps.adaptation.b.d aev = f.aeJ().aev();
            if (this.bHo != i3 && aev != null) {
                this.bHo = i3;
                int webViewScrollY = aev.getWebViewScrollY() + ((this.bHm.getWebViewContainer().getHeight() - i) - i2) + af.ck(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.bHm.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.bHm.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void abp() {
        this.bVc.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.abq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abq() {
        if (this.bHm != null && this.bHo != 0) {
            this.bHo = 0;
            if (this.bHm.getWebViewContainer().getScrollY() > 0) {
                this.bHm.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity abr() {
        e akM = e.akM();
        if (akM == null) {
            return null;
        }
        return akM.getActivity();
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d abs() {
        com.baidu.swan.apps.core.d.e Ot = f.aeJ().Ot();
        if (Ot == null) {
            return null;
        }
        int Wg = Ot.Wg();
        for (int i = 0; i < Wg; i++) {
            com.baidu.swan.apps.core.d.b eB = Ot.eB(i);
            if (eB instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eB;
                if (TextUtils.equals(dVar.VP(), this.bAP)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
