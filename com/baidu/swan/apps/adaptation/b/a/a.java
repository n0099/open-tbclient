package com.baidu.swan.apps.adaptation.b.a;

import android.app.Activity;
import android.content.Intent;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.swan.apps.adaptation.b.h;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.swan.apps.adaptation.b.j;
/* loaded from: classes11.dex */
public class a implements j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private h bHN = new h() { // from class: com.baidu.swan.apps.adaptation.b.a.a.1
        @Override // com.baidu.swan.apps.adaptation.b.h
        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            BdSailor.getInstance().onActivityResult(activity, i, i2, intent);
        }
    };

    @Override // com.baidu.swan.apps.adaptation.b.j
    public i To() {
        return com.baidu.swan.apps.core.container.a.a.XL();
    }

    @Override // com.baidu.swan.apps.adaptation.b.j
    public h Tp() {
        return this.bHN;
    }
}
