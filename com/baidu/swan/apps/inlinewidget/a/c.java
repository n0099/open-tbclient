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
    private String cEi;
    private e cLR;
    private int cLT;
    private String ddB;
    private Handler ddC;
    private com.baidu.swan.apps.inlinewidget.a.b.b ddD;
    private a ddE;
    private b.a ddF = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void oc(String str) {
            bG("onInput", "inputText: " + str);
            if (c.this.ddE != null) {
                c.this.ddE.oc(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void avZ() {
            bG("onDeletePressed", null);
            if (c.this.ddE != null) {
                c.this.ddE.avZ();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void gt(int i) {
            bG("onKeyboardShow", "height: " + i);
            if (c.this.ddE != null) {
                c.this.ddE.gt(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void alp() {
            bG("onKeyboardHide", null);
            if (c.this.ddE != null) {
                c.this.ddE.alp();
            }
        }

        private void bG(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.avY() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void alp();

        void avZ();

        void gt(int i);

        void oc(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.ddB = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.awW();
        this.cEi = str;
        this.ddC = new Handler(this.mContext.getMainLooper());
        this.cLR = awf();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aIK() == null) {
            aVar.fG(false);
        } else {
            aVar.fG(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avY() {
        return this.ddB;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cEi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.ddE = aVar;
    }

    public void ht(final int i) {
        this.ddC.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.hu(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        Activity awe = awe();
        if (awe != null) {
            this.ddD = new com.baidu.swan.apps.inlinewidget.a.b.b(awe, i, this.ddF);
            this.ddD.show();
        }
    }

    public void awa() {
        this.ddC.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.awb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awb() {
        if (this.ddD != null) {
            this.ddD.dismiss();
            this.ddD = null;
        }
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        this.ddC.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cLR != null) {
            com.baidu.swan.apps.adaptation.b.d azW = f.aAl().azW();
            if (this.cLT != i3 && azW != null) {
                this.cLT = i3;
                int webViewScrollY = azW.getWebViewScrollY() + ((this.cLR.getWebViewContainer().getHeight() - i) - i2) + ah.dK(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cLR.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cLR.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void awc() {
        this.ddC.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.awd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awd() {
        if (this.cLR != null && this.cLT != 0) {
            this.cLT = 0;
            if (this.cLR.getWebViewContainer().getScrollY() > 0) {
                this.cLR.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity awe() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK == null) {
            return null;
        }
        return aIK.getActivity();
    }

    @Nullable
    private e awf() {
        com.baidu.swan.apps.core.d.f afX = f.aAl().afX();
        if (afX == null) {
            return null;
        }
        int apA = afX.apA();
        for (int i = 0; i < apA; i++) {
            com.baidu.swan.apps.core.d.c gL = afX.gL(i);
            if (gL instanceof e) {
                e eVar = (e) gL;
                if (TextUtils.equals(eVar.apg(), this.cEi)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
