package com.baidu.swan.bdprivate.extensions.quicklogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        y(new com.baidu.swan.apps.aq.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: D */
            public void H(Bundle bundle2) {
                if (bundle2 != null) {
                    b.this.cAx.putParcelable("quick_login_info", bundle2.getParcelable("quick_login_info_result"));
                }
                b.this.finish();
            }
        });
    }

    public void y(final com.baidu.swan.apps.aq.e.b<Bundle> bVar) {
        f.b(new c() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.b.2
            @Override // com.baidu.swan.bdprivate.extensions.quicklogin.c
            public void b(QuickLoginInfo quickLoginInfo) {
                if (quickLoginInfo == null) {
                    bVar.H(null);
                    return;
                }
                b.this.cAx.putParcelable("quick_login_info_result", quickLoginInfo);
                bVar.H(b.this.cAx);
            }
        });
    }
}
