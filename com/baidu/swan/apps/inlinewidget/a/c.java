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
/* loaded from: classes25.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cBI;
    private e cJu;
    private int cJw;
    private String dbi;
    private Handler dbj;
    private com.baidu.swan.apps.inlinewidget.a.b.b dbk;
    private a dbl;
    private b.a dbm = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.a.c.5
        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void pe(String str) {
            bO("onInput", "inputText: " + str);
            if (c.this.dbl != null) {
                c.this.dbl.pe(str);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void ayd() {
            bO("onDeletePressed", null);
            if (c.this.dbl != null) {
                c.this.dbl.ayd();
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void ic(int i) {
            bO("onKeyboardShow", "height: " + i);
            if (c.this.dbl != null) {
                c.this.dbl.ic(i);
            }
        }

        @Override // com.baidu.swan.apps.inlinewidget.a.b.b.a
        public void anz() {
            bO("onKeyboardHide", null);
            if (c.this.dbl != null) {
                c.this.dbl.anz();
            }
        }

        private void bO(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.ayc() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface a {
        void anz();

        void ayd();

        void ic(int i);

        void pe(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dbi = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.t.a.aza();
        this.cBI = str;
        this.dbj = new Handler(this.mContext.getMainLooper());
        this.cJu = ayj();
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        if (com.baidu.swan.apps.runtime.e.aJU() == null) {
            aVar.fz(false);
        } else {
            aVar.fz(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String ayc() {
        return this.dbi;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cBI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.dbl = aVar;
    }

    public void jb(final int i) {
        this.dbj.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.jc(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jc(int i) {
        Activity ayi = ayi();
        if (ayi != null) {
            this.dbk = new com.baidu.swan.apps.inlinewidget.a.b.b(ayi, i, this.dbm);
            this.dbk.show();
        }
    }

    public void aye() {
        this.dbj.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.ayf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayf() {
        if (this.dbk != null) {
            this.dbk.dismiss();
            this.dbk = null;
        }
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        this.dbj.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.n(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4) {
        if (this.cJu != null) {
            com.baidu.swan.apps.adaptation.b.d aCa = f.aCp().aCa();
            if (this.cJw != i3 && aCa != null) {
                this.cJw = i3;
                int webViewScrollY = aCa.getWebViewScrollY() + ((this.cJu.getWebViewContainer().getHeight() - i) - i2) + ah.dt(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.cJu.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.cJu.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void ayg() {
        this.dbj.post(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.ayh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayh() {
        if (this.cJu != null && this.cJw != 0) {
            this.cJw = 0;
            if (this.cJu.getWebViewContainer().getScrollY() > 0) {
                this.cJu.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity ayi() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null) {
            return null;
        }
        return aJU.getActivity();
    }

    @Nullable
    private e ayj() {
        com.baidu.swan.apps.core.d.f aim = f.aCp().aim();
        if (aim == null) {
            return null;
        }
        int arE = aim.arE();
        for (int i = 0; i < arE; i++) {
            com.baidu.swan.apps.core.d.c it = aim.it(i);
            if (it instanceof e) {
                e eVar = (e) it;
                if (TextUtils.equals(eVar.arl(), this.cBI)) {
                    return eVar;
                }
            }
        }
        return null;
    }
}
