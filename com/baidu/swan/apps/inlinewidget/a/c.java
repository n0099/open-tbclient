package com.baidu.swan.apps.inlinewidget.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.inlinewidget.a.b.b;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cBM;
    private e cJD;
    private int cJF;
    private String dbo;
    private Handler dbp;
    private com.baidu.swan.apps.inlinewidget.a.b.b dbq;
    private a dbr;
    private b.a dbs = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void nK(String str) {
            bM("onInput", "inputText: " + str);
            if (c.this.dbr != null) {
                c.this.dbr.nK(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void avB() {
            bM("onDeletePressed", null);
            if (c.this.dbr != null) {
                c.this.dbr.avB();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void gq(int i) {
            bM("onKeyboardShow", "height: " + i);
            if (c.this.dbr != null) {
                c.this.dbr.gq(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void akR() {
            bM("onKeyboardHide", null);
            if (c.this.dbr != null) {
                c.this.dbr.akR();
            }
        }

        private void bM(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.avA() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes8.dex */
    public interface a {
        void akR();

        void avB();

        void gq(int i);

        void nK(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dbo = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.awy();
        this.cBM = str;
        this.dbp = new Handler(this.mContext.getMainLooper());
        this.cJD = avH();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aIr() == null) {
            aVar.fE(false);
        } else {
            aVar.fE(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avA() {
        return this.dbo;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cBM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.dbr = aVar;
    }

    public void hq(final int i) {
        this.dbp.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.hr(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(int i) {
        Activity avG = avG();
        if (avG != null) {
            this.dbq = new com.baidu.swan.apps.inlinewidget.a.b.b(avG, i, this.dbs);
            this.dbq.show();
        }
    }

    public void avC() {
        this.dbp.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.avD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avD() {
        if (this.dbq != null) {
            this.dbq.dismiss();
            this.dbq = null;
        }
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        this.dbp.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cJD != null) {
            com.baidu.swan.apps.adaptation.b.d azy = f.azN().azy();
            if (this.cJF != i3 && azy != null) {
                this.cJF = i3;
                int webViewScrollY = azy.getWebViewScrollY() + ((this.cJD.getWebViewContainer().getHeight() - i) - i2) + ah.dL(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cJD.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cJD.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void avE() {
        this.dbp.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.avF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avF() {
        if (this.cJD != null && this.cJF != 0) {
            this.cJF = 0;
            if (this.cJD.getWebViewContainer().getScrollY() > 0) {
                this.cJD.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity avG() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr == null) {
            return null;
        }
        return aIr.getActivity();
    }

    @Nullable
    private e avH() {
        com.baidu.swan.apps.core.d.f afz = f.azN().afz();
        if (afz == null) {
            return null;
        }
        int apb = afz.apb();
        for (int i = 0; i < apb; i++) {
            com.baidu.swan.apps.core.d.c gI = afz.gI(i);
            if (gI instanceof e) {
                e eVar = (e) gI;
                if (TextUtils.equals(eVar.aoI(), this.cBM)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
