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
    private String cHH;
    private Handler cHI;
    private com.baidu.swan.apps.inlinewidget.a.b.b cHJ;
    private a cHK;
    private b.a cHL = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void nU(String str) {
            bB("onInput", "inputText: " + str);
            if (c.this.cHK != null) {
                c.this.cHK.nU(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void ari() {
            bB("onDeletePressed", null);
            if (c.this.cHK != null) {
                c.this.cHK.ari();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void hn(int i) {
            bB("onKeyboardShow", "height: " + i);
            if (c.this.cHK != null) {
                c.this.cHK.hn(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void agF() {
            bB("onKeyboardHide", null);
            if (c.this.cHK != null) {
                c.this.cHK.agF();
            }
        }

        private void bB(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.arh() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private String cib;
    private e cpP;
    private int cpR;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void agF();

        void ari();

        void hn(int i);

        void nU(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cHH = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.asf();
        this.cib = str;
        this.cHI = new Handler(this.mContext.getMainLooper());
        this.cpP = aro();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aDa() == null) {
            aVar.eL(false);
        } else {
            aVar.eL(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String arh() {
        return this.cHH;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cib;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cHK = aVar;
    }

    public void im(final int i) {
        this.cHI.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.in(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(int i) {
        Activity arn = arn();
        if (arn != null) {
            this.cHJ = new com.baidu.swan.apps.inlinewidget.a.b.b(arn, i, this.cHL);
            this.cHJ.show();
        }
    }

    public void arj() {
        this.cHI.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.ark();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ark() {
        if (this.cHJ != null) {
            this.cHJ.dismiss();
            this.cHJ = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.cHI.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.cpP != null) {
            com.baidu.swan.apps.adaptation.b.d avf = f.avu().avf();
            if (this.cpR != i3 && avf != null) {
                this.cpR = i3;
                int webViewScrollY = avf.getWebViewScrollY() + ((this.cpP.getWebViewContainer().getHeight() - i) - i2) + ah.cN(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cpP.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cpP.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void arl() {
        this.cHI.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.arm();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arm() {
        if (this.cpP != null && this.cpR != 0) {
            this.cpR = 0;
            if (this.cpP.getWebViewContainer().getScrollY() > 0) {
                this.cpP.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity arn() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa == null) {
            return null;
        }
        return aDa.getActivity();
    }

    @Nullable
    private e aro() {
        com.baidu.swan.apps.core.d.f abs = f.avu().abs();
        if (abs == null) {
            return null;
        }
        int akK = abs.akK();
        for (int i = 0; i < akK; i++) {
            com.baidu.swan.apps.core.d.c hE = abs.hE(i);
            if (hE instanceof e) {
                e eVar = (e) hE;
                if (TextUtils.equals(eVar.akr(), this.cib)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
