package com.baidu.swan.apps.x;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Map<String, com.baidu.swan.apps.as.d.b<Bundle>> bH = new com.baidu.swan.support.v4.b.a();
    private int mStatus = -1;
    private String mAppId = "";

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        final String string = bundle.getString("desAppId");
        bH.put(string, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.apps.x.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: z */
            public void D(Bundle bundle2) {
                b.this.mAppId = bundle2.getString("key_launch_app_id");
                b.this.mStatus = bundle2.getInt("key_launch_status");
                if (TextUtils.equals(string, b.this.mAppId)) {
                    b.this.bIU.putInt("ok", b.this.mStatus);
                    b.this.finish();
                }
                b.bH.remove(string);
            }
        });
    }
}
