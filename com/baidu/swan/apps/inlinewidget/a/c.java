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
/* loaded from: classes8.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bTN;
    private e cbw;
    private int cby;
    private b.a ctA = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void mP(String str) {
            bw("onInput", "inputText: " + str);
            if (c.this.ctz != null) {
                c.this.ctz.mP(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void anM() {
            bw("onDeletePressed", null);
            if (c.this.ctz != null) {
                c.this.ctz.anM();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void gH(int i) {
            bw("onKeyboardShow", "height: " + i);
            if (c.this.ctz != null) {
                c.this.ctz.gH(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void adl() {
            bw("onKeyboardHide", null);
            if (c.this.ctz != null) {
                c.this.ctz.adl();
            }
        }

        private void bw(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.anL() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private String ctv;
    private Handler ctw;
    private com.baidu.swan.apps.inlinewidget.a.b.b cty;
    private a ctz;
    private Context mContext;

    /* loaded from: classes8.dex */
    public interface a {
        void adl();

        void anM();

        void gH(int i);

        void mP(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.ctv = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.aoJ();
        this.bTN = str;
        this.ctw = new Handler(this.mContext.getMainLooper());
        this.cbw = anS();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.azI() == null) {
            aVar.er(false);
        } else {
            aVar.er(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String anL() {
        return this.ctv;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.bTN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.ctz = aVar;
    }

    public void hG(final int i) {
        this.ctw.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.hH(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(int i) {
        Activity anR = anR();
        if (anR != null) {
            this.cty = new com.baidu.swan.apps.inlinewidget.a.b.b(anR, i, this.ctA);
            this.cty.show();
        }
    }

    public void anN() {
        this.ctw.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.anO();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anO() {
        if (this.cty != null) {
            this.cty.dismiss();
            this.cty = null;
        }
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        this.ctw.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.k(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2, int i3, int i4) {
        if (this.cbw != null) {
            com.baidu.swan.apps.adaptation.b.d arJ = f.arY().arJ();
            if (this.cby != i3 && arJ != null) {
                this.cby = i3;
                int webViewScrollY = arJ.getWebViewScrollY() + ((this.cbw.getWebViewContainer().getHeight() - i) - i2) + ah.cI(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cbw.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cbw.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void anP() {
        this.ctw.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.anQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anQ() {
        if (this.cbw != null && this.cby != 0) {
            this.cby = 0;
            if (this.cbw.getWebViewContainer().getScrollY() > 0) {
                this.cbw.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity anR() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI == null) {
            return null;
        }
        return azI.getActivity();
    }

    @Nullable
    private e anS() {
        com.baidu.swan.apps.core.d.f XX = f.arY().XX();
        if (XX == null) {
            return null;
        }
        int ahp = XX.ahp();
        for (int i = 0; i < ahp; i++) {
            com.baidu.swan.apps.core.d.c gY = XX.gY(i);
            if (gY instanceof e) {
                e eVar = (e) gY;
                if (TextUtils.equals(eVar.agW(), this.bTN)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
