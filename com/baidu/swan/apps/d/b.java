package com.baidu.swan.apps.d;

import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.c.g;
/* loaded from: classes2.dex */
public class b extends g {
    /* JADX INFO: Access modifiers changed from: private */
    public void aN(boolean z) {
        this.apV.setLeftSecondViewVisibility(z ? 0 : 8);
        this.apV.setLeftSecondViewText("");
    }

    @Override // com.baidu.swan.apps.core.c.g
    protected f vX() {
        return com.baidu.swan.apps.core.i.c.Ab().Ac().br(getContext());
    }

    @Override // com.baidu.swan.apps.core.c.g
    protected com.baidu.swan.apps.core.e.c wl() {
        return new com.baidu.swan.apps.core.e.a() { // from class: com.baidu.swan.apps.d.b.1
            @Override // com.baidu.swan.apps.core.e.a, com.baidu.swan.apps.core.e.c
            public void goBack() {
                b.this.aN(b.this.ara.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.e.a, com.baidu.swan.apps.core.e.c
            public void dl(final String str) {
                b.this.aN(b.this.ara.canGoBack());
                b.this.apV.post(new Runnable() { // from class: com.baidu.swan.apps.d.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.apV.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.g, com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        this.apV.setRightMenuVisibility(false);
        this.apV.setLeftSecondViewImageSrc(b.e.aiapps_action_bar_close_black_selector);
        this.apV.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ara.canGoBack()) {
                    b.this.ara.goBack();
                } else {
                    b.this.ye();
                }
            }
        });
        this.apV.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.d.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.zf();
            }
        });
    }
}
