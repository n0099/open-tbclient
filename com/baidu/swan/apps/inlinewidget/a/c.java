package com.baidu.swan.apps.inlinewidget.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.inlinewidget.a.b.b;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cQd;
    private Handler cQe;
    private com.baidu.swan.apps.inlinewidget.a.b.b cQf;
    private a cQg;
    private b.a cQh = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void op(String str) {
            bI("onInput", "inputText: " + str);
            if (c.this.cQg != null) {
                c.this.cQg.op(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void atd() {
            bI("onDeletePressed", null);
            if (c.this.cQg != null) {
                c.this.cQg.atd();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void hy(int i) {
            bI("onKeyboardShow", "height: " + i);
            if (c.this.cQg != null) {
                c.this.cQg.hy(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void aiz() {
            bI("onKeyboardHide", null);
            if (c.this.cQg != null) {
                c.this.cQg.aiz();
            }
        }

        private void bI(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.atc() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private String cqC;
    private e cyq;
    private int cys;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void aiz();

        void atd();

        void hy(int i);

        void op(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cQd = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.aua();
        this.cqC = str;
        this.cQe = new Handler(this.mContext.getMainLooper());
        this.cyq = atj();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aEU() == null) {
            aVar.eY(false);
        } else {
            aVar.eY(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String atc() {
        return this.cQd;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cqC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cQg = aVar;
    }

    public void ix(final int i) {
        this.cQe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.iy(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iy(int i) {
        Activity ati = ati();
        if (ati != null) {
            this.cQf = new com.baidu.swan.apps.inlinewidget.a.b.b(ati, i, this.cQh);
            this.cQf.show();
        }
    }

    public void ate() {
        this.cQe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.atf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atf() {
        if (this.cQf != null) {
            this.cQf.dismiss();
            this.cQf = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.cQe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.cyq != null) {
            com.baidu.swan.apps.adaptation.b.d awZ = f.axo().awZ();
            if (this.cys != i3 && awZ != null) {
                this.cys = i3;
                int webViewScrollY = awZ.getWebViewScrollY() + ((this.cyq.getWebViewContainer().getHeight() - i) - i2) + ah.cN(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cyq.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cyq.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void atg() {
        this.cQe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.ath();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ath() {
        if (this.cyq != null && this.cys != 0) {
            this.cys = 0;
            if (this.cyq.getWebViewContainer().getScrollY() > 0) {
                this.cyq.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity ati() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU == null) {
            return null;
        }
        return aEU.getActivity();
    }

    @Nullable
    private e atj() {
        com.baidu.swan.apps.core.d.f adm = f.axo().adm();
        if (adm == null) {
            return null;
        }
        int amE = adm.amE();
        for (int i = 0; i < amE; i++) {
            com.baidu.swan.apps.core.d.c hP = adm.hP(i);
            if (hP instanceof e) {
                e eVar = (e) hP;
                if (TextUtils.equals(eVar.aml(), this.cqC)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
