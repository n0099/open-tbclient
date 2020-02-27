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
    private String bch;
    private com.baidu.swan.apps.core.d.d biK;
    private int biM;
    private String bwB;
    private Handler bwC;
    private com.baidu.swan.apps.r.a.b.b bwD;
    private a bwE;
    private b.a bwF = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void ib(String str) {
            aH("onInput", "inputText: " + str);
            if (c.this.bwE != null) {
                c.this.bwE.ib(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void Tt() {
            aH("onDeletePressed", null);
            if (c.this.bwE != null) {
                c.this.bwE.Tt();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void eg(int i) {
            aH("onKeyboardShow", "height: " + i);
            if (c.this.bwE != null) {
                c.this.bwE.eg(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void KO() {
            aH("onKeyboardHide", null);
            if (c.this.bwE != null) {
                c.this.bwE.KO();
            }
        }

        private void aH(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.Ts() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void KO();

        void Tt();

        void eg(int i);

        void ib(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bwB = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.TU();
        this.bch = str;
        this.bwC = new Handler(this.mContext.getMainLooper());
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
        this.bwE = aVar;
    }

    public void eX(final int i) {
        this.bwC.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.eY(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(int i) {
        Activity Ty = Ty();
        if (Ty != null) {
            this.bwD = new com.baidu.swan.apps.r.a.b.b(Ty, i, this.bwF);
            this.bwD.show();
        }
    }

    public void Tu() {
        this.bwC.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.Tv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tv() {
        if (this.bwD != null) {
            this.bwD.dismiss();
            this.bwD = null;
        }
    }

    public void k(final int i, final int i2, final int i3, final int i4) {
        this.bwC.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
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
                int webViewScrollY = WC.getWebViewScrollY() + ((this.biK.getWebViewContainer().getHeight() - i) - i2) + af.cJ(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.biK.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.biK.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void Tw() {
        this.bwC.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
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

    public void release() {
    }

    @Nullable
    private Activity Ty() {
        e acD = e.acD();
        if (acD == null) {
            return null;
        }
        return acD.getActivity();
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
}
