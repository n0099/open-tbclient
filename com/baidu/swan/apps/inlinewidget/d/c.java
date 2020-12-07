package com.baidu.swan.apps.inlinewidget.d;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes25.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int dbN = ah.M(38.0f);
    private String cBI;
    private ShowConfirmBarLayout cJJ;
    @Nullable
    private e cJu;
    private int cJw;
    private a dbO;
    @Nullable
    private String dbi;

    /* loaded from: classes25.dex */
    public interface a {
        void ayu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.dbi = (String) invoker.get("id");
        }
        this.cBI = str;
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
        this.dbO = aVar;
    }

    public void m(final int i, final int i2, final int i3, final int i4) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.1
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
                int i5 = this.cJJ == null ? 0 : dbN;
                int webViewScrollY = aCa.getWebViewScrollY() + ((this.cJu.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cJu.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cJu.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void ayg() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
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

    public void jn(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.jo(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(int i) {
        Activity ayi = ayi();
        if (ayi != null) {
            View decorView = ayi.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cJJ == null) {
                this.cJJ = new ShowConfirmBarLayout(ayi);
                this.cJJ.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bO("onConfirmBtnClick", null);
                        if (c.this.dbO != null) {
                            c.this.dbO.ayu();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - dbN;
                frameLayout.addView(this.cJJ, layoutParams);
            }
        }
    }

    public void ayv() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ayw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayw() {
        Activity ayi = ayi();
        if (ayi != null) {
            View decorView = ayi.getWindow().getDecorView();
            if (this.cJJ != null && this.cJJ.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cJJ);
                this.cJJ = null;
            }
        }
    }

    public void release() {
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

    @Nullable
    private Activity ayi() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null) {
            return null;
        }
        return aJU.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + ayc() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
