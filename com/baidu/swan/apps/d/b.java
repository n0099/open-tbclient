package com.baidu.swan.apps.d;

import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.c.g;
/* loaded from: classes2.dex */
public class b extends g {
    /* JADX INFO: Access modifiers changed from: private */
    public void aN(boolean z) {
        this.aqa.setLeftSecondViewVisibility(z ? 0 : 8);
        this.aqa.setLeftSecondViewText("");
    }

    @Override // com.baidu.swan.apps.core.c.g
    protected f vW() {
        return com.baidu.swan.apps.core.i.c.Aa().Ab().br(getContext());
    }

    @Override // com.baidu.swan.apps.core.c.g
    protected com.baidu.swan.apps.core.e.c wk() {
        return new com.baidu.swan.apps.core.e.a() { // from class: com.baidu.swan.apps.d.b.1
            @Override // com.baidu.swan.apps.core.e.a, com.baidu.swan.apps.core.e.c
            public void goBack() {
                b.this.aN(b.this.arf.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.e.a, com.baidu.swan.apps.core.e.c
            public void dn(final String str) {
                b.this.aN(b.this.arf.canGoBack());
                b.this.aqa.post(new Runnable() { // from class: com.baidu.swan.apps.d.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aqa.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.g, com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        this.aqa.setRightMenuVisibility(false);
        this.aqa.setLeftSecondViewImageSrc(a.e.aiapps_action_bar_close_black_selector);
        this.aqa.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.arf.canGoBack()) {
                    b.this.arf.goBack();
                } else {
                    b.this.yd();
                }
            }
        });
        this.aqa.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.ze();
            }
        });
    }
}
