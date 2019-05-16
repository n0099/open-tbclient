package com.baidu.swan.apps.d;

import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.d.g;
/* loaded from: classes2.dex */
public class b extends g {
    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        this.aqh.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected f wN() {
        return com.baidu.swan.apps.core.j.c.Bi().Bj().aK(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected com.baidu.swan.apps.core.f.c xb() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.b.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void goBack() {
                b.this.aP(b.this.arl.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void da(final String str) {
                b.this.aP(b.this.arl.canGoBack());
                b.this.aqh.post(new Runnable() { // from class: com.baidu.swan.apps.d.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aqh.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.g, com.baidu.swan.apps.core.d.b
    public void M(View view) {
        super.M(view);
        this.aqh.setRightZoneVisibility(false);
        this.aqh.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.aqh.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.arl.canGoBack()) {
                    b.this.arl.goBack();
                } else {
                    b.this.yX();
                }
            }
        });
        this.aqh.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.Ab();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xc() {
        return true;
    }
}
