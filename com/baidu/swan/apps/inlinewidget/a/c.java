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
    private String cFI;
    private e cNr;
    private int cNt;
    private String dfd;
    private Handler dfe;
    private com.baidu.swan.apps.inlinewidget.a.b.b dff;
    private a dfg;
    private b.a dfh = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void ok(String str) {
            bG("onInput", "inputText: " + str);
            if (c.this.dfg != null) {
                c.this.dfg.ok(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void awc() {
            bG("onDeletePressed", null);
            if (c.this.dfg != null) {
                c.this.dfg.awc();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void gu(int i) {
            bG("onKeyboardShow", "height: " + i);
            if (c.this.dfg != null) {
                c.this.dfg.gu(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void als() {
            bG("onKeyboardHide", null);
            if (c.this.dfg != null) {
                c.this.dfg.als();
            }
        }

        private void bG(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.awb() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void als();

        void awc();

        void gu(int i);

        void ok(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dfd = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.awZ();
        this.cFI = str;
        this.dfe = new Handler(this.mContext.getMainLooper());
        this.cNr = awi();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aIN() == null) {
            aVar.fG(false);
        } else {
            aVar.fG(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String awb() {
        return this.dfd;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cFI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.dfg = aVar;
    }

    public void hu(final int i) {
        this.dfe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.hv(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(int i) {
        Activity awh = awh();
        if (awh != null) {
            this.dff = new com.baidu.swan.apps.inlinewidget.a.b.b(awh, i, this.dfh);
            this.dff.show();
        }
    }

    public void awd() {
        this.dfe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.awe();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awe() {
        if (this.dff != null) {
            this.dff.dismiss();
            this.dff = null;
        }
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        this.dfe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cNr != null) {
            com.baidu.swan.apps.adaptation.b.d azZ = f.aAo().azZ();
            if (this.cNt != i3 && azZ != null) {
                this.cNt = i3;
                int webViewScrollY = azZ.getWebViewScrollY() + ((this.cNr.getWebViewContainer().getHeight() - i) - i2) + ah.dJ(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cNr.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cNr.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void awf() {
        this.dfe.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.awg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awg() {
        if (this.cNr != null && this.cNt != 0) {
            this.cNt = 0;
            if (this.cNr.getWebViewContainer().getScrollY() > 0) {
                this.cNr.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity awh() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null) {
            return null;
        }
        return aIN.getActivity();
    }

    @Nullable
    private e awi() {
        com.baidu.swan.apps.core.d.f aga = f.aAo().aga();
        if (aga == null) {
            return null;
        }
        int apD = aga.apD();
        for (int i = 0; i < apD; i++) {
            com.baidu.swan.apps.core.d.c gM = aga.gM(i);
            if (gM instanceof e) {
                e eVar = (e) gM;
                if (TextUtils.equals(eVar.apk(), this.cFI)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
