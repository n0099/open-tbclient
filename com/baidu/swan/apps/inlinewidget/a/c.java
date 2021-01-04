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
/* loaded from: classes9.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cGy;
    private e cOp;
    private int cOr;
    private String dgd;
    private Handler dge;
    private com.baidu.swan.apps.inlinewidget.a.b.b dgf;
    private a dgg;
    private b.a dgh = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void oX(String str) {
            bN("onInput", "inputText: " + str);
            if (c.this.dgg != null) {
                c.this.dgg.oX(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void azu() {
            bN("onDeletePressed", null);
            if (c.this.dgg != null) {
                c.this.dgg.azu();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void hW(int i) {
            bN("onKeyboardShow", "height: " + i);
            if (c.this.dgg != null) {
                c.this.dgg.hW(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void aoK() {
            bN("onKeyboardHide", null);
            if (c.this.dgg != null) {
                c.this.dgg.aoK();
            }
        }

        private void bN(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.azt() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void aoK();

        void azu();

        void hW(int i);

        void oX(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dgd = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.aAr();
        this.cGy = str;
        this.dge = new Handler(this.mContext.getMainLooper());
        this.cOp = azA();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aMk() == null) {
            aVar.fI(false);
        } else {
            aVar.fI(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String azt() {
        return this.dgd;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cGy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.dgg = aVar;
    }

    public void iW(final int i) {
        this.dge.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.iX(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iX(int i) {
        Activity azz = azz();
        if (azz != null) {
            this.dgf = new com.baidu.swan.apps.inlinewidget.a.b.b(azz, i, this.dgh);
            this.dgf.show();
        }
    }

    public void azv() {
        this.dge.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.azw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azw() {
        if (this.dgf != null) {
            this.dgf.dismiss();
            this.dgf = null;
        }
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        this.dge.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cOp != null) {
            com.baidu.swan.apps.adaptation.b.d aDr = f.aDG().aDr();
            if (this.cOr != i3 && aDr != null) {
                this.cOr = i3;
                int webViewScrollY = aDr.getWebViewScrollY() + ((this.cOp.getWebViewContainer().getHeight() - i) - i2) + ah.dM(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cOp.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cOp.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void azx() {
        this.dge.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.azy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azy() {
        if (this.cOp != null && this.cOr != 0) {
            this.cOr = 0;
            if (this.cOp.getWebViewContainer().getScrollY() > 0) {
                this.cOp.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity azz() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk == null) {
            return null;
        }
        return aMk.getActivity();
    }

    @Nullable
    private e azA() {
        com.baidu.swan.apps.core.d.f ajs = f.aDG().ajs();
        if (ajs == null) {
            return null;
        }
        int asW = ajs.asW();
        for (int i = 0; i < asW; i++) {
            com.baidu.swan.apps.core.d.c io2 = ajs.io(i);
            if (io2 instanceof e) {
                e eVar = (e) io2;
                if (TextUtils.equals(eVar.asD(), this.cGy)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
