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
    private String bNv;
    private com.baidu.swan.apps.core.d.d bUS;
    private int bUU;
    private String ckf;
    private Handler ckg;
    private com.baidu.swan.apps.p.a.b.b ckh;
    private a cki;
    private b.a ckj = new b.a() { // from class: com.baidu.swan.apps.p.a.c.5
        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void kE(String str) {
            bi("onInput", "inputText: " + str);
            if (c.this.cki != null) {
                c.this.cki.kE(str);
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void aft() {
            bi("onDeletePressed", null);
            if (c.this.cki != null) {
                c.this.cki.aft();
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void eH(int i) {
            bi("onKeyboardShow", "height: " + i);
            if (c.this.cki != null) {
                c.this.cki.eH(i);
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void Wy() {
            bi("onKeyboardHide", null);
            if (c.this.cki != null) {
                c.this.cki.Wy();
            }
        }

        private void bi(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.afs() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void Wy();

        void aft();

        void eH(int i);

        void kE(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.ckf = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.u.a.afX();
        this.bNv = str;
        this.ckg = new Handler(this.mContext.getMainLooper());
        this.bUS = afz();
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull d.a aVar) {
        if (e.apM() == null) {
            aVar.dX(false);
        } else {
            aVar.dX(true);
        }
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String afs() {
        return this.ckf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cki = aVar;
    }

    public void fA(final int i) {
        this.ckg.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.fB(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(int i) {
        Activity afy = afy();
        if (afy != null) {
            this.ckh = new com.baidu.swan.apps.p.a.b.b(afy, i, this.ckj);
            this.ckh.show();
        }
    }

    public void afu() {
        this.ckg.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.afv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afv() {
        if (this.ckh != null) {
            this.ckh.dismiss();
            this.ckh = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.ckg.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.bUS != null) {
            com.baidu.swan.apps.adaptation.b.d aiM = f.ajb().aiM();
            if (this.bUU != i3 && aiM != null) {
                this.bUU = i3;
                int webViewScrollY = aiM.getWebViewScrollY() + ((this.bUS.getWebViewContainer().getHeight() - i) - i2) + ag.cx(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.bUS.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.bUS.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void afw() {
        this.ckg.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.afx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afx() {
        if (this.bUS != null && this.bUU != 0) {
            this.bUU = 0;
            if (this.bUS.getWebViewContainer().getScrollY() > 0) {
                this.bUS.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity afy() {
        e apM = e.apM();
        if (apM == null) {
            return null;
        }
        return apM.getActivity();
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d afz() {
        com.baidu.swan.apps.core.d.e RN = f.ajb().RN();
        if (RN == null) {
            return null;
        }
        int ZY = RN.ZY();
        for (int i = 0; i < ZY; i++) {
            com.baidu.swan.apps.core.d.b eX = RN.eX(i);
            if (eX instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eX;
                if (TextUtils.equals(dVar.ZH(), this.bNv)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
