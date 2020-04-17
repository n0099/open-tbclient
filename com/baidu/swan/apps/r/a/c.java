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
    private String bAK;
    private com.baidu.swan.apps.core.d.d bHh;
    private int bHj;
    private String bUV;
    private Handler bUW;
    private com.baidu.swan.apps.r.a.b.b bUX;
    private a bUY;
    private b.a bUZ = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void jo(String str) {
            aP("onInput", "inputText: " + str);
            if (c.this.bUY != null) {
                c.this.bUY.jo(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void abn() {
            aP("onDeletePressed", null);
            if (c.this.bUY != null) {
                c.this.bUY.abn();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void el(int i) {
            aP("onKeyboardShow", "height: " + i);
            if (c.this.bUY != null) {
                c.this.bUY.el(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void SI() {
            aP("onKeyboardHide", null);
            if (c.this.bUY != null) {
                c.this.bUY.SI();
            }
        }

        private void aP(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.abm() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void SI();

        void abn();

        void el(int i);

        void jo(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bUV = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.abO();
        this.bAK = str;
        this.bUW = new Handler(this.mContext.getMainLooper());
        this.bHh = abt();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.akN() == null) {
            aVar.dC(false);
        } else {
            aVar.dC(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String abm() {
        return this.bUV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bUY = aVar;
    }

    public void fc(final int i) {
        this.bUW.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.fd(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        Activity abs = abs();
        if (abs != null) {
            this.bUX = new com.baidu.swan.apps.r.a.b.b(abs, i, this.bUZ);
            this.bUX.show();
        }
    }

    public void abo() {
        this.bUW.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.abp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abp() {
        if (this.bUX != null) {
            this.bUX.dismiss();
            this.bUX = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.bUW.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.bHh != null) {
            com.baidu.swan.apps.adaptation.b.d aew = f.aeK().aew();
            if (this.bHj != i3 && aew != null) {
                this.bHj = i3;
                int webViewScrollY = aew.getWebViewScrollY() + ((this.bHh.getWebViewContainer().getHeight() - i) - i2) + af.cw(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.bHh.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.bHh.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void abq() {
        this.bUW.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.abr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abr() {
        if (this.bHh != null && this.bHj != 0) {
            this.bHj = 0;
            if (this.bHh.getWebViewContainer().getScrollY() > 0) {
                this.bHh.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity abs() {
        e akN = e.akN();
        if (akN == null) {
            return null;
        }
        return akN.getActivity();
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d abt() {
        com.baidu.swan.apps.core.d.e Ou = f.aeK().Ou();
        if (Ou == null) {
            return null;
        }
        int Wh = Ou.Wh();
        for (int i = 0; i < Wh; i++) {
            com.baidu.swan.apps.core.d.b eB = Ou.eB(i);
            if (eB instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eB;
                if (TextUtils.equals(dVar.VQ(), this.bAK)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
