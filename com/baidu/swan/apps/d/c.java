package com.baidu.swan.apps.d;

import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.d.g;
/* loaded from: classes2.dex */
public class c extends g {
    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        this.aqK.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected f xo() {
        return com.baidu.swan.apps.core.j.c.BQ().BR().aK(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected com.baidu.swan.apps.core.f.c xC() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void goBack() {
                c.this.aS(c.this.arO.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void de(final String str) {
                c.this.aS(c.this.arO.canGoBack());
                c.this.aqK.post(new Runnable() { // from class: com.baidu.swan.apps.d.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.aqK.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.g, com.baidu.swan.apps.core.d.b
    public void O(View view) {
        super.O(view);
        this.aqK.setRightZoneVisibility(false);
        this.aqK.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.aqK.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.arO.canGoBack()) {
                    c.this.arO.goBack();
                } else {
                    c.this.zE();
                }
            }
        });
        this.aqK.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.AI();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
        return true;
    }
}
