package com.baidu.swan.apps.u;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.u.a;
import java.util.Map;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Map<String, com.baidu.swan.apps.ao.e.b<Bundle>> mCallbackMap = new com.baidu.swan.support.v4.b.a();
    private int mStatus = -1;
    private String mAppId = "";

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        final String string = bundle.getString("desAppId");
        mCallbackMap.put(string, new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.apps.u.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: B */
            public void L(Bundle bundle2) {
                b.this.mAppId = bundle2.getString("key_launch_app_id");
                b.this.mStatus = bundle2.getInt("key_launch_status");
                if (TextUtils.equals(string, b.this.mAppId)) {
                    b.this.dvA.putInt("ok", b.this.mStatus);
                    b.this.finish();
                }
                b.mCallbackMap.remove(string);
            }
        });
    }

    public static void b(final String str, final a.InterfaceC0493a interfaceC0493a) {
        if (!TextUtils.isEmpty(str) && interfaceC0493a != null) {
            mCallbackMap.put(str, new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.apps.u.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: B */
                public void L(Bundle bundle) {
                    String string = bundle.getString("key_launch_app_id");
                    int i = bundle.getInt("key_launch_status");
                    if (TextUtils.equals(str, string)) {
                        if (i == 0) {
                            interfaceC0493a.aBZ();
                        } else {
                            interfaceC0493a.aCa();
                        }
                    }
                    b.mCallbackMap.remove(str);
                }
            });
        }
    }

    public static void ps(String str) {
        com.baidu.swan.apps.ao.e.b<Bundle> bVar = mCallbackMap.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.L(bundle);
        }
    }

    public static void pt(String str) {
        com.baidu.swan.apps.ao.e.b<Bundle> bVar = mCallbackMap.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.L(bundle);
        }
    }
}
