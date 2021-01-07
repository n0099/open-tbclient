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
        public void azv() {
            bN("onDeletePressed", null);
            if (c.this.dgg != null) {
                c.this.dgg.azv();
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
        public void aoL() {
            bN("onKeyboardHide", null);
            if (c.this.dgg != null) {
                c.this.dgg.aoL();
            }
        }

        private void bN(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.azu() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void aoL();

        void azv();

        void hW(int i);

        void oX(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dgd = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.aAs();
        this.cGy = str;
        this.dge = new Handler(this.mContext.getMainLooper());
        this.cOp = azB();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aMl() == null) {
            aVar.fI(false);
        } else {
            aVar.fI(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String azu() {
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
        Activity azA = azA();
        if (azA != null) {
            this.dgf = new com.baidu.swan.apps.inlinewidget.a.b.b(azA, i, this.dgh);
            this.dgf.show();
        }
    }

    public void azw() {
        this.dge.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.azx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azx() {
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
            com.baidu.swan.apps.adaptation.b.d aDs = f.aDH().aDs();
            if (this.cOr != i3 && aDs != null) {
                this.cOr = i3;
                int webViewScrollY = aDs.getWebViewScrollY() + ((this.cOp.getWebViewContainer().getHeight() - i) - i2) + ah.dM(this.mContext);
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

    public void azy() {
        this.dge.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.azz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azz() {
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
    private Activity azA() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null) {
            return null;
        }
        return aMl.getActivity();
    }

    @Nullable
    private e azB() {
        com.baidu.swan.apps.core.d.f ajt = f.aDH().ajt();
        if (ajt == null) {
            return null;
        }
        int asX = ajt.asX();
        for (int i = 0; i < asX; i++) {
            com.baidu.swan.apps.core.d.c io2 = ajt.io(i);
            if (io2 instanceof e) {
                e eVar = (e) io2;
                if (TextUtils.equals(eVar.asE(), this.cGy)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
