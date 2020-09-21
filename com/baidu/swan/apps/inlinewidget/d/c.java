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
/* loaded from: classes3.dex */
public final class c implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cwg = ah.H(38.0f);
    private String bVN;
    private int cdB;
    private ShowConfirmBarLayout cdO;
    @Nullable
    private e cdz;
    @Nullable
    private String cvA;
    private a cwh;

    /* loaded from: classes3.dex */
    public interface a {
        void aoN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.cvA = (String) invoker.get("id");
        }
        this.bVN = str;
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
        this.cwh = aVar;
    }

    public void j(final int i, final int i2, final int i3, final int i4) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.1
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
                int i5 = this.cdO == null ? 0 : cwg;
                int webViewScrollY = asu.getWebViewScrollY() + ((this.cdz.getWebViewContainer().getHeight() - i) - i2);
                if (webViewScrollY - i4 < i3) {
                    if (i4 > webViewScrollY) {
                        this.cdz.getWebViewContainer().setScrollY(i5 + i3);
                    } else {
                        this.cdz.getWebViewContainer().setScrollY(i5 + (i3 - webViewScrollY) + i4);
                    }
                }
            }
        }
    }

    public void aoz() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.2
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

    public void ib(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.ic(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic(int i) {
        Activity aoB = aoB();
        if (aoB != null) {
            View decorView = aoB.getWindow().getDecorView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.cdO == null) {
                this.cdO = new ShowConfirmBarLayout(aoB);
                this.cdO.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.inlinewidget.d.c.4
                    @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                    public void onClick(View view) {
                        c.this.bw("onConfirmBtnClick", null);
                        if (c.this.cwh != null) {
                            c.this.cwh.aoN();
                        }
                    }
                });
                FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
                layoutParams.topMargin = (frameLayout.getHeight() - i) - cwg;
                frameLayout.addView(this.cdO, layoutParams);
            }
        }
    }

    public void aoO() {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.aoP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoP() {
        Activity aoB = aoB();
        if (aoB != null) {
            View decorView = aoB.getWindow().getDecorView();
            if (this.cdO != null && this.cdO.getVisibility() == 0) {
                ((FrameLayout) decorView.findViewById(16908290)).removeView(this.cdO);
                this.cdO = null;
            }
        }
    }

    public void release() {
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

    @Nullable
    private Activity aoB() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null) {
            return null;
        }
        return aAr.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(String str, @Nullable String str2) {
        if (DEBUG) {
            String str3 = (" <<" + aov() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }
}
