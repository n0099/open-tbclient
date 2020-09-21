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
/* loaded from: classes3.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bVN;
    private int cdB;
    private e cdz;
    private String cvA;
    private Handler cvB;
    private com.baidu.swan.apps.inlinewidget.a.b.b cvC;
    private a cvD;
    private b.a cvE = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void ni(String str) {
            bw("onInput", "inputText: " + str);
            if (c.this.cvD != null) {
                c.this.cvD.ni(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void aow() {
            bw("onDeletePressed", null);
            if (c.this.cvD != null) {
                c.this.cvD.aow();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void gQ(int i) {
            bw("onKeyboardShow", "height: " + i);
            if (c.this.cvD != null) {
                c.this.cvD.gQ(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void adU() {
            bw("onKeyboardHide", null);
            if (c.this.cvD != null) {
                c.this.cvD.adU();
            }
        }

        private void bw(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.aov() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void adU();

        void aow();

        void gQ(int i);

        void ni(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cvA = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.apu();
        this.bVN = str;
        this.cvB = new Handler(this.mContext.getMainLooper());
        this.cdz = aoC();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aAr() == null) {
            aVar.ep(false);
        } else {
            aVar.ep(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String aov() {
        return this.cvA;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.bVN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cvD = aVar;
    }

    public void hP(final int i) {
        this.cvB.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.hQ(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ(int i) {
        Activity aoB = aoB();
        if (aoB != null) {
            this.cvC = new com.baidu.swan.apps.inlinewidget.a.b.b(aoB, i, this.cvE);
            this.cvC.show();
        }
    }

    public void aox() {
        this.cvB.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.aoy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoy() {
        if (this.cvC != null) {
            this.cvC.dismiss();
            this.cvC = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.cvB.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.cdz != null) {
            com.baidu.swan.apps.adaptation.b.d asu = f.asJ().asu();
            if (this.cdB != i3 && asu != null) {
                this.cdB = i3;
                int webViewScrollY = asu.getWebViewScrollY() + ((this.cdz.getWebViewContainer().getHeight() - i) - i2) + ah.cH(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cdz.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cdz.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void aoz() {
        this.cvB.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.aoA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoA() {
        if (this.cdz != null && this.cdB != 0) {
            this.cdB = 0;
            if (this.cdz.getWebViewContainer().getScrollY() > 0) {
                this.cdz.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity aoB() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null) {
            return null;
        }
        return aAr.getActivity();
    }

    @Nullable
    private e aoC() {
        com.baidu.swan.apps.core.d.f YG = f.asJ().YG();
        if (YG == null) {
            return null;
        }
        int ahZ = YG.ahZ();
        for (int i = 0; i < ahZ; i++) {
            com.baidu.swan.apps.core.d.c hh = YG.hh(i);
            if (hh instanceof e) {
                e eVar = (e) hh;
                if (TextUtils.equals(eVar.ahG(), this.bVN)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
