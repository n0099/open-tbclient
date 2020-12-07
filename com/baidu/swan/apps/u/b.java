package com.baidu.swan.apps.u;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.u.a;
import java.util.Map;
/* loaded from: classes25.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Map<String, com.baidu.swan.apps.ap.e.b<Bundle>> zR = new com.baidu.swan.support.v4.b.a();
    private int mStatus = -1;
    private String mAppId = "";

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        final String string = bundle.getString("desAppId");
        zR.put(string, new com.baidu.swan.apps.ap.e.b<Bundle>() { // from class: com.baidu.swan.apps.u.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: B */
            public void M(Bundle bundle2) {
                b.this.mAppId = bundle2.getString("key_launch_app_id");
                b.this.mStatus = bundle2.getInt("key_launch_status");
                if (TextUtils.equals(string, b.this.mAppId)) {
                    b.this.dqB.putInt("ok", b.this.mStatus);
                    b.this.finish();
                }
                b.zR.remove(string);
            }
        });
    }

    public static void b(final String str, final a.InterfaceC0500a interfaceC0500a) {
        if (!TextUtils.isEmpty(str) && interfaceC0500a != null) {
            zR.put(str, new com.baidu.swan.apps.ap.e.b<Bundle>() { // from class: com.baidu.swan.apps.u.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: B */
                public void M(Bundle bundle) {
                    String string = bundle.getString("key_launch_app_id");
                    int i = bundle.getInt("key_launch_status");
                    if (TextUtils.equals(str, string)) {
                        if (i == 0) {
                            interfaceC0500a.aAI();
                        } else {
                            interfaceC0500a.aAJ();
                        }
                    }
                    b.zR.remove(str);
                }
            });
        }
    }

    public static void pz(String str) {
        com.baidu.swan.apps.ap.e.b<Bundle> bVar = zR.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.M(bundle);
        }
    }

    public static void pA(String str) {
        com.baidu.swan.apps.ap.e.b<Bundle> bVar = zR.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.M(bundle);
        }
    }
}
