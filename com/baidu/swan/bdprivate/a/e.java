package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.bdprivate.api.b;
/* loaded from: classes25.dex */
public class e extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        a.a(bundle.getString("key_result_client_id"), bundle.getStringArrayList("key_param_tpl_list"), new b.a() { // from class: com.baidu.swan.bdprivate.a.e.1
            @Override // com.baidu.swan.bdprivate.api.b.a
            public void vk(String str) {
                e.this.dqB.putString("result", str);
                e.this.finish();
            }
        });
    }
}
