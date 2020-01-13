package com.baidu.swan.apps.r.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.r.a.b.b;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.y.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aXX;
    private com.baidu.swan.apps.core.d.d bew;
    private int bey;
    private String bsr;
    private Handler bss;
    private com.baidu.swan.apps.r.a.b.b bst;
    private a bsu;
    private b.a bsv = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void hM(String str) {
            ax("onInput", "inputText: " + str);
            if (c.this.bsu != null) {
                c.this.bsu.hM(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void Rf() {
            ax("onDeletePressed", null);
            if (c.this.bsu != null) {
                c.this.bsu.Rf();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void dQ(int i) {
            ax("onKeyboardShow", "height: " + i);
            if (c.this.bsu != null) {
                c.this.bsu.dQ(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void Iz() {
            ax("onKeyboardHide", null);
            if (c.this.bsu != null) {
                c.this.bsu.Iz();
            }
        }

        private void ax(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.Re() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void Iz();

        void Rf();

        void dQ(int i);

        void hM(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bsr = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.RG();
        this.aXX = str;
        this.bss = new Handler(this.mContext.getMainLooper());
        this.bew = Rl();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.aap() == null) {
            aVar.cy(false);
        } else {
            aVar.cy(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Re() {
        return this.bsr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bsu = aVar;
    }

    public void eH(final int i) {
        this.bss.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.eI(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(int i) {
        Activity Rk = Rk();
        if (Rk != null) {
            this.bst = new com.baidu.swan.apps.r.a.b.b(Rk, i, this.bsv);
            this.bst.show();
        }
    }

    public void Rg() {
        this.bss.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.Rh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        if (this.bst != null) {
            this.bst.dismiss();
            this.bst = null;
        }
    }

    public void k(final int i, final int i2, final int i3, final int i4) {
        this.bss.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.l(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, int i2, int i3, int i4) {
        if (this.bew != null) {
            com.baidu.swan.apps.adaptation.b.d Uo = f.UC().Uo();
            if (this.bey != i3 && Uo != null) {
                this.bey = i3;
                int webViewScrollY = Uo.getWebViewScrollY() + ((this.bew.getWebViewContainer().getHeight() - i) - i2) + af.cF(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.bew.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.bew.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void Ri() {
        this.bss.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.Rj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rj() {
        if (this.bew != null && this.bey != 0) {
            this.bey = 0;
            if (this.bew.getWebViewContainer().getScrollY() > 0) {
                this.bew.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity Rk() {
        e aap = e.aap();
        if (aap == null) {
            return null;
        }
        return aap.getActivity();
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d Rl() {
        com.baidu.swan.apps.core.d.e El = f.UC().El();
        if (El == null) {
            return null;
        }
        int Ma = El.Ma();
        for (int i = 0; i < Ma; i++) {
            com.baidu.swan.apps.core.d.b eg = El.eg(i);
            if (eg instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) eg;
                if (TextUtils.equals(dVar.LJ(), this.aXX)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
