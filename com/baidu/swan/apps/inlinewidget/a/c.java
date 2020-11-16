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
/* loaded from: classes7.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int cCB;
    private e cCz;
    private String cUm;
    private Handler cUn;
    private com.baidu.swan.apps.inlinewidget.a.b.b cUo;
    private a cUp;
    private b.a cUq = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void ox(String str) {
            bH("onInput", "inputText: " + str);
            if (c.this.cUp != null) {
                c.this.cUp.ox(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void auV() {
            bH("onDeletePressed", null);
            if (c.this.cUp != null) {
                c.this.cUp.auV();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void hE(int i) {
            bH("onKeyboardShow", "height: " + i);
            if (c.this.cUp != null) {
                c.this.cUp.hE(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void akr() {
            bH("onKeyboardHide", null);
            if (c.this.cUp != null) {
                c.this.cUp.akr();
            }
        }

        private void bH(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.auU() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private String cuQ;
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void akr();

        void auV();

        void hE(int i);

        void ox(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cUm = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.avS();
        this.cuQ = str;
        this.cUn = new Handler(this.mContext.getMainLooper());
        this.cCz = avb();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aGM() == null) {
            aVar.fk(false);
        } else {
            aVar.fk(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String auU() {
        return this.cUm;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cuQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.cUp = aVar;
    }

    public void iD(final int i) {
        this.cUn.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.iE(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE(int i) {
        Activity ava = ava();
        if (ava != null) {
            this.cUo = new com.baidu.swan.apps.inlinewidget.a.b.b(ava, i, this.cUq);
            this.cUo.show();
        }
    }

    public void auW() {
        this.cUn.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.auX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        if (this.cUo != null) {
            this.cUo.dismiss();
            this.cUo = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.cUn.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.cCz != null) {
            com.baidu.swan.apps.adaptation.b.d ayR = f.azg().ayR();
            if (this.cCB != i3 && ayR != null) {
                this.cCB = i3;
                int webViewScrollY = ayR.getWebViewScrollY() + ((this.cCz.getWebViewContainer().getHeight() - i) - i2) + ah.cN(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cCz.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cCz.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void auY() {
        this.cUn.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.auZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auZ() {
        if (this.cCz != null && this.cCB != 0) {
            this.cCB = 0;
            if (this.cCz.getWebViewContainer().getScrollY() > 0) {
                this.cCz.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity ava() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM == null) {
            return null;
        }
        return aGM.getActivity();
    }

    @Nullable
    private e avb() {
        com.baidu.swan.apps.core.d.f afe = f.azg().afe();
        if (afe == null) {
            return null;
        }
        int aow = afe.aow();
        for (int i = 0; i < aow; i++) {
            com.baidu.swan.apps.core.d.c hV = afe.hV(i);
            if (hV instanceof e) {
                e eVar = (e) hV;
                if (TextUtils.equals(eVar.aod(), this.cuQ)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
