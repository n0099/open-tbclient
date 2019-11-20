package com.baidu.swan.apps.d;

import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.d.g;
/* loaded from: classes2.dex */
public class c extends g {
    /* JADX INFO: Access modifiers changed from: private */
    public void bk(boolean z) {
        this.aKg.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected f Cn() {
        return com.baidu.swan.apps.core.j.c.GP().GQ().aM(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected com.baidu.swan.apps.core.f.c CB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void goBack() {
                c.this.bk(c.this.aLl.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void dc(final String str) {
                c.this.bk(c.this.aLl.canGoBack());
                c.this.aKg.post(new Runnable() { // from class: com.baidu.swan.apps.d.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.aKg.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.g, com.baidu.swan.apps.core.d.b
    public void U(View view) {
        super.U(view);
        this.aKg.setRightZoneVisibility(false);
        this.aKg.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.aKg.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aLl.canGoBack()) {
                    c.this.aLl.goBack();
                } else {
                    c.this.EE();
                }
            }
        });
        this.aKg.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.FI();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return true;
    }
}
