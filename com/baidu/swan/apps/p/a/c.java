package com.baidu.swan.apps.p.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.p.a.b.b;
import com.baidu.swan.apps.p.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.w.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bIH;
    private com.baidu.swan.apps.core.d.d bQe;
    private int bQg;
    private String cfr;
    private Handler cfs;
    private com.baidu.swan.apps.p.a.b.b cft;
    private a cfu;
    private b.a cfv = new b.a() { // from class: com.baidu.swan.apps.p.a.c.5
        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void kw(String str) {
            bg("onInput", "inputText: " + str);
            if (c.this.cfu != null) {
                c.this.cfu.kw(str);
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void aen() {
            bg("onDeletePressed", null);
            if (c.this.cfu != null) {
                c.this.cfu.aen();
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void ew(int i) {
            bg("onKeyboardShow", "height: " + i);
            if (c.this.cfu != null) {
                c.this.cfu.ew(i);
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void Vs() {
            bg("onKeyboardHide", null);
            if (c.this.cfu != null) {
                c.this.cfu.Vs();
            }
        }

        private void bg(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.aem() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void Vs();

        void aen();

        void ew(int i);

        void kw(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cfr = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.u.a.aeR();
        this.bIH = str;
        this.cfs = new Handler(this.mContext.getMainLooper());
        this.bQe = aet();
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull d.a aVar) {
        if (e.aoF() == null) {
            aVar.dS(false);
        } else {
            aVar.dS(true);
        }
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String aem() {
        return this.cfr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cfu = aVar;
    }

    public void fp(final int i) {
        this.cfs.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.fq(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        Activity aes = aes();
        if (aes != null) {
            this.cft = new com.baidu.swan.apps.p.a.b.b(aes, i, this.cfv);
            this.cft.show();
        }
    }

    public void aeo() {
        this.cfs.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.aep();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aep() {
        if (this.cft != null) {
            this.cft.dismiss();
            this.cft = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.cfs.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.bQe != null) {
            com.baidu.swan.apps.adaptation.b.d ahG = f.ahV().ahG();
            if (this.bQg != i3 && ahG != null) {
                this.bQg = i3;
                int webViewScrollY = ahG.getWebViewScrollY() + ((this.bQe.getWebViewContainer().getHeight() - i) - i2) + ag.cw(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.bQe.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.bQe.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void aeq() {
        this.cfs.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.aer();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        if (this.bQe != null && this.bQg != 0) {
            this.bQg = 0;
            if (this.bQe.getWebViewContainer().getScrollY() > 0) {
                this.bQe.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity aes() {
        e aoF = e.aoF();
        if (aoF == null) {
            return null;
        }
        return aoF.getActivity();
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d aet() {
        com.baidu.swan.apps.core.d.e QH = f.ahV().QH();
        if (QH == null) {
            return null;
        }
        int YS = QH.YS();
        for (int i = 0; i < YS; i++) {
            com.baidu.swan.apps.core.d.b eM = QH.eM(i);
            if (eM instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eM;
                if (TextUtils.equals(dVar.YB(), this.bIH)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
