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
    private e cEj;
    private int cEl;
    private String cVW;
    private Handler cVX;
    private com.baidu.swan.apps.inlinewidget.a.b.b cVY;
    private a cVZ;
    private b.a cWa = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void oD(String str) {
            bI("onInput", "inputText: " + str);
            if (c.this.cVZ != null) {
                c.this.cVZ.oD(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void avD() {
            bI("onDeletePressed", null);
            if (c.this.cVZ != null) {
                c.this.cVZ.avD();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void hI(int i) {
            bI("onKeyboardShow", "height: " + i);
            if (c.this.cVZ != null) {
                c.this.cVZ.hI(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void akZ() {
            bI("onKeyboardHide", null);
            if (c.this.cVZ != null) {
                c.this.cVZ.akZ();
            }
        }

        private void bI(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.avC() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private String cwA;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void akZ();

        void avD();

        void hI(int i);

        void oD(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cVW = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.awA();
        this.cwA = str;
        this.cVX = new Handler(this.mContext.getMainLooper());
        this.cEj = avJ();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aHu() == null) {
            aVar.fh(false);
        } else {
            aVar.fh(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avC() {
        return this.cVW;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cwA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cVZ = aVar;
    }

    public void iH(final int i) {
        this.cVX.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.iI(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI(int i) {
        Activity avI = avI();
        if (avI != null) {
            this.cVY = new com.baidu.swan.apps.inlinewidget.a.b.b(avI, i, this.cWa);
            this.cVY.show();
        }
    }

    public void avE() {
        this.cVX.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.avF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avF() {
        if (this.cVY != null) {
            this.cVY.dismiss();
            this.cVY = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.cVX.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.cEj != null) {
            com.baidu.swan.apps.adaptation.b.d azz = f.azO().azz();
            if (this.cEl != i3 && azz != null) {
                this.cEl = i3;
                int webViewScrollY = azz.getWebViewScrollY() + ((this.cEj.getWebViewContainer().getHeight() - i) - i2) + ah.cN(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cEj.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cEj.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void avG() {
        this.cVX.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.avH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avH() {
        if (this.cEj != null && this.cEl != 0) {
            this.cEl = 0;
            if (this.cEj.getWebViewContainer().getScrollY() > 0) {
                this.cEj.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity avI() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu == null) {
            return null;
        }
        return aHu.getActivity();
    }

    @Nullable
    private e avJ() {
        com.baidu.swan.apps.core.d.f afM = f.azO().afM();
        if (afM == null) {
            return null;
        }
        int ape = afM.ape();
        for (int i = 0; i < ape; i++) {
            com.baidu.swan.apps.core.d.c hZ = afM.hZ(i);
            if (hZ instanceof e) {
                e eVar = (e) hZ;
                if (TextUtils.equals(eVar.aoL(), this.cwA)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
