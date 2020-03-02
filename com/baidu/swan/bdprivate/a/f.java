package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes11.dex */
public class f extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        String[] stringArray = bundle.getStringArray("key_param_tpl_list");
        if (stringArray == null || stringArray.length < 1) {
            finish();
        } else {
            a.b(AppRuntime.getAppContext(), new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void D(Bundle bundle2) {
                    f.this.bIT.putBundle("key_result_stokent", bundle2);
                    f.this.finish();
                }
            }, stringArray);
        }
    }
}
