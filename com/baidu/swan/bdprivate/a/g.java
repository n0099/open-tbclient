package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        String[] stringArray = bundle.getStringArray("key_param_tpl_list");
        if (stringArray == null || stringArray.length < 1) {
            finish();
        } else {
            a.b(AppRuntime.getAppContext(), new com.baidu.swan.apps.aq.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: D */
                public void H(Bundle bundle2) {
                    g.this.cAx.putBundle("key_result_stokent", bundle2);
                    g.this.finish();
                }
            }, stringArray);
        }
    }
}
