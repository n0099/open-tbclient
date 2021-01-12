package com.baidu.swan.bdprivate.extensions.quicklogin;

import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        F(new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: B */
            public void L(Bundle bundle2) {
                if (bundle2 != null) {
                    b.this.dqL.putParcelable("quick_login_info", bundle2.getParcelable("quick_login_info_result"));
                }
                b.this.finish();
            }
        });
    }

    public void F(final com.baidu.swan.apps.ao.e.b<Bundle> bVar) {
        f.b(new c() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.b.2
            @Override // com.baidu.swan.bdprivate.extensions.quicklogin.c
            public void a(QuickLoginInfo quickLoginInfo) {
                if (quickLoginInfo == null) {
                    bVar.L(null);
                    return;
                }
                b.this.dqL.putParcelable("quick_login_info_result", quickLoginInfo);
                bVar.L(b.this.dqL);
            }
        });
    }
}
