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
    private String bci;
    private com.baidu.swan.apps.core.d.d biL;
    private int biN;
    private String bwC;
    private Handler bwD;
    private com.baidu.swan.apps.r.a.b.b bwE;
    private a bwF;
    private b.a bwG = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void ib(String str) {
            aH("onInput", "inputText: " + str);
            if (c.this.bwF != null) {
                c.this.bwF.ib(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void Tv() {
            aH("onDeletePressed", null);
            if (c.this.bwF != null) {
                c.this.bwF.Tv();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void eg(int i) {
            aH("onKeyboardShow", "height: " + i);
            if (c.this.bwF != null) {
                c.this.bwF.eg(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void KQ() {
            aH("onKeyboardHide", null);
            if (c.this.bwF != null) {
                c.this.bwF.KQ();
            }
        }

        private void aH(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.Tu() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void KQ();

        void Tv();

        void eg(int i);

        void ib(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bwC = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.TW();
        this.bci = str;
        this.bwD = new Handler(this.mContext.getMainLooper());
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
        this.bwF = aVar;
    }

    public void eX(final int i) {
        this.bwD.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.eY(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(int i) {
        Activity TA = TA();
        if (TA != null) {
            this.bwE = new com.baidu.swan.apps.r.a.b.b(TA, i, this.bwG);
            this.bwE.show();
        }
    }

    public void Tw() {
        this.bwD.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.Tx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tx() {
        if (this.bwE != null) {
            this.bwE.dismiss();
            this.bwE = null;
        }
    }

    public void k(final int i, final int i2, final int i3, final int i4) {
        this.bwD.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
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
                int webViewScrollY = WE.getWebViewScrollY() + ((this.biL.getWebViewContainer().getHeight() - i) - i2) + af.cJ(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.biL.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.biL.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void Ty() {
        this.bwD.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
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

    public void release() {
    }

    @Nullable
    private Activity TA() {
        e acF = e.acF();
        if (acF == null) {
            return null;
        }
        return acF.getActivity();
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
}
