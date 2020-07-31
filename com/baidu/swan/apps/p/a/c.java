package com.baidu.swan.apps.p.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.p.a.b.b;
import com.baidu.swan.apps.p.d;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bOl;
    private e bVK;
    private int bVM;
    private String cmj;
    private Handler cmk;
    private com.baidu.swan.apps.p.a.b.b cml;
    private a cmm;
    private b.a cmn = new b.a() { // from class: com.baidu.swan.apps.p.a.c.5
        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void la(String str) {
            bm("onInput", "inputText: " + str);
            if (c.this.cmm != null) {
                c.this.cmm.la(str);
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void agE() {
            bm("onDeletePressed", null);
            if (c.this.cmm != null) {
                c.this.cmm.agE();
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void eJ(int i) {
            bm("onKeyboardShow", "height: " + i);
            if (c.this.cmm != null) {
                c.this.cmm.eJ(i);
            }
        }

        @Override // com.baidu.swan.apps.p.a.b.b.a
        public void Xf() {
            bm("onKeyboardHide", null);
            if (c.this.cmm != null) {
                c.this.cmm.Xf();
            }
        }

        private void bm(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.agD() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void Xf();

        void agE();

        void eJ(int i);

        void la(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cmj = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.ahj();
        this.bOl = str;
        this.cmk = new Handler(this.mContext.getMainLooper());
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
        this.cmm = aVar;
    }

    public void fK(final int i) {
        this.cmk.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.fL(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(int i) {
        Activity agJ = agJ();
        if (agJ != null) {
            this.cml = new com.baidu.swan.apps.p.a.b.b(agJ, i, this.cmn);
            this.cml.show();
        }
    }

    public void agF() {
        this.cmk.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.agG();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agG() {
        if (this.cml != null) {
            this.cml.dismiss();
            this.cml = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.cmk.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.3
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
                int webViewScrollY = akc.getWebViewScrollY() + ((this.bVK.getWebViewContainer().getHeight() - i) - i2) + ai.cB(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.bVK.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.bVK.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void agH() {
        this.cmk.post(new Runnable() { // from class: com.baidu.swan.apps.p.a.c.4
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

    public void release() {
    }

    @Nullable
    private Activity agJ() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv == null) {
            return null;
        }
        return arv.getActivity();
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
}
