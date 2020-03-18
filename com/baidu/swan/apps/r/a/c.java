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
/* loaded from: classes11.dex */
public class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bcw;
    private com.baidu.swan.apps.core.d.d biZ;
    private int bjb;
    private String bwP;
    private Handler bwQ;
    private com.baidu.swan.apps.r.a.b.b bwR;
    private a bwS;
    private b.a bwT = new b.a() { // from class: com.baidu.swan.apps.r.a.c.5
        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void ia(String str) {
            aG("onInput", "inputText: " + str);
            if (c.this.bwS != null) {
                c.this.bwS.ia(str);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void Ty() {
            aG("onDeletePressed", null);
            if (c.this.bwS != null) {
                c.this.bwS.Ty();
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void eg(int i) {
            aG("onKeyboardShow", "height: " + i);
            if (c.this.bwS != null) {
                c.this.bwS.eg(i);
            }
        }

        @Override // com.baidu.swan.apps.r.a.b.b.a
        public void KT() {
            aG("onKeyboardHide", null);
            if (c.this.bwS != null) {
                c.this.bwS.KT();
            }
        }

        private void aG(String str, @Nullable String str2) {
            if (c.DEBUG) {
                String str3 = ("【" + c.this.Tx() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void KT();

        void Ty();

        void eg(int i);

        void ia(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.bwP = (String) invoker.get("id");
        }
        this.mContext = com.baidu.swan.apps.w.a.TZ();
        this.bcw = str;
        this.bwQ = new Handler(this.mContext.getMainLooper());
        this.biZ = TE();
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull d.a aVar) {
        if (e.acI() == null) {
            aVar.cG(false);
        } else {
            aVar.cG(true);
        }
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Tx() {
        return this.bwP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull a aVar) {
        this.bwS = aVar;
    }

    public void eX(final int i) {
        this.bwQ.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.eY(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(int i) {
        Activity TD = TD();
        if (TD != null) {
            this.bwR = new com.baidu.swan.apps.r.a.b.b(TD, i, this.bwT);
            this.bwR.show();
        }
    }

    public void Tz() {
        this.bwQ.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.TA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TA() {
        if (this.bwR != null) {
            this.bwR.dismiss();
            this.bwR = null;
        }
    }

    public void k(final int i, final int i2, final int i3, final int i4) {
        this.bwQ.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.l(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, int i2, int i3, int i4) {
        if (this.biZ != null) {
            com.baidu.swan.apps.adaptation.b.d WH = f.WV().WH();
            if (this.bjb != i3 && WH != null) {
                this.bjb = i3;
                int webViewScrollY = WH.getWebViewScrollY() + ((this.biZ.getWebViewContainer().getHeight() - i) - i2) + af.cI(this.mContext);
                if (i4 > webViewScrollY) {
                    i4 = webViewScrollY;
                }
                int i5 = webViewScrollY - i3;
                int scrollY = this.biZ.getWebViewContainer().getScrollY();
                if (i5 < 0) {
                    scrollY = i4 - i5;
                } else if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                this.biZ.getWebViewContainer().setScrollY(scrollY);
            }
        }
    }

    public void TB() {
        this.bwQ.post(new Runnable() { // from class: com.baidu.swan.apps.r.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.TC();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TC() {
        if (this.biZ != null && this.bjb != 0) {
            this.bjb = 0;
            if (this.biZ.getWebViewContainer().getScrollY() > 0) {
                this.biZ.getWebViewContainer().setScrollY(0);
            }
        }
    }

    public void release() {
    }

    @Nullable
    private Activity TD() {
        e acI = e.acI();
        if (acI == null) {
            return null;
        }
        return acI.getActivity();
    }

    @Nullable
    private com.baidu.swan.apps.core.d.d TE() {
        com.baidu.swan.apps.core.d.e GH = f.WV().GH();
        if (GH == null) {
            return null;
        }
        int Ot = GH.Ot();
        for (int i = 0; i < Ot; i++) {
            com.baidu.swan.apps.core.d.b ew = GH.ew(i);
            if (ew instanceof com.baidu.swan.apps.core.d.d) {
                com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) ew;
                if (TextUtils.equals(dVar.Oc(), this.bcw)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
