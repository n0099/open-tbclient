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
/* loaded from: classes9.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aXf;
    private com.baidu.swan.apps.core.d.d bdG;
    private int bdI;
    private String brD;
    private Handler brE;
    private com.baidu.swan.apps.r.a.b.b brF;
    private a brG;
    private b.a brH = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void hJ(String str) {
            aw("onInput", "inputText: " + str);
            if (c.this.brG != null) {
                c.this.brG.hJ(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void QJ() {
            aw("onDeletePressed", null);
            if (c.this.brG != null) {
                c.this.brG.QJ();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void dP(int i) {
            aw("onKeyboardShow", "height: " + i);
            if (c.this.brG != null) {
                c.this.brG.dP(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void Id() {
            aw("onKeyboardHide", null);
            if (c.this.brG != null) {
                c.this.brG.Id();
            }
        }

        private void aw(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.QI() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
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
        void Id();

        void QJ();

        void dP(int i);

        void hJ(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.brD = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.Rk();
        this.aXf = str;
        this.brE = new Handler(this.mContext.getMainLooper());
        this.bdG = QP();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.ZS() == null) {
            aVar.ct(false);
        } else {
            aVar.ct(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String QI() {
        return this.brD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.brG = aVar;
    }

    public void eG(final int i) {
        this.brE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.eH(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(int i) {
        Activity QO = QO();
        if (QO != null) {
            this.brF = new com.baidu.swan.apps.r.a.b.b(QO, i, this.brH);
            this.brF.show();
        }
    }

    public void QK() {
        this.brE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.QL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QL() {
        if (this.brF != null) {
            this.brF.dismiss();
            this.brF = null;
        }
    }

    public void k(final int i, final int i2, final int i3, final int i4) {
        this.brE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.l(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, int i2, int i3, int i4) {
        if (this.bdG != null) {
            com.baidu.swan.apps.adaptation.b.d TR = f.Uf().TR();
            if (this.bdI != i3 && TR != null) {
                this.bdI = i3;
                int webViewScrollY = TR.getWebViewScrollY() + ((this.bdG.getWebViewContainer().getHeight() - i) - i2) + af.cF(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.bdG.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.bdG.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void QM() {
        this.brE.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.QN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QN() {
        if (this.bdG != null && this.bdI != 0) {
            this.bdI = 0;
            if (this.bdG.getWebViewContainer().getScrollY() > 0) {
                this.bdG.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity QO() {
        e ZS = e.ZS();
        if (ZS == null) {
            return null;
        }
        return ZS.getActivity();
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d QP() {
        com.baidu.swan.apps.core.d.e DP = f.Uf().DP();
        if (DP == null) {
            return null;
        }
        int LE = DP.LE();
        for (int i = 0; i < LE; i++) {
            com.baidu.swan.apps.core.d.b ef = DP.ef(i);
            if (ef instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) ef;
                if (TextUtils.equals(dVar.Ln(), this.aXf)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
