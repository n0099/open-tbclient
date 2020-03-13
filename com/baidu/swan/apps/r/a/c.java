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
    private String bcj;
    private com.baidu.swan.apps.core.d.d biM;
    private int biO;
    private String bwD;
    private Handler bwE;
    private com.baidu.swan.apps.r.a.b.b bwF;
    private a bwG;
    private b.a bwH = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void ib(String str) {
            aH("onInput", "inputText: " + str);
            if (c.this.bwG != null) {
                c.this.bwG.ib(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void Tv() {
            aH("onDeletePressed", null);
            if (c.this.bwG != null) {
                c.this.bwG.Tv();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void eg(int i) {
            aH("onKeyboardShow", "height: " + i);
            if (c.this.bwG != null) {
                c.this.bwG.eg(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void KQ() {
            aH("onKeyboardHide", null);
            if (c.this.bwG != null) {
                c.this.bwG.KQ();
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
            this.bwD = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.TW();
        this.bcj = str;
        this.bwE = new Handler(this.mContext.getMainLooper());
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
        this.bwG = aVar;
    }

    public void eX(final int i) {
        this.bwE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
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
            this.bwF = new com.baidu.swan.apps.r.a.b.b(TA, i, this.bwH);
            this.bwF.show();
        }
    }

    public void Tw() {
        this.bwE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.Tx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tx() {
        if (this.bwF != null) {
            this.bwF.dismiss();
            this.bwF = null;
        }
    }

    public void k(final int i, final int i2, final int i3, final int i4) {
        this.bwE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
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
                int webViewScrollY = WE.getWebViewScrollY() + ((this.biM.getWebViewContainer().getHeight() - i) - i2) + af.cJ(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.biM.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.biM.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void Ty() {
        this.bwE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
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
                if (TextUtils.equals(dVar.NZ(), this.bcj)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
