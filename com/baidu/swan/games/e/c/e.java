package com.baidu.swan.games.e.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes10.dex */
public class e implements PermissionProxy {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.smallgame.sdk.permission.PermissionProxy
    public void requestPermission(final String str, final PermissionListener permissionListener) {
        if (DEBUG) {
            Log.d("V8PermissionDelegate", "requestPermission : " + str);
        }
        if (permissionListener == null) {
            if (DEBUG) {
                Log.e("V8PermissionDelegate", "PermissionListener can not be null.");
                return;
            }
            return;
        }
        final String ox = ox(str);
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (TextUtils.isEmpty(ox) || aap == null || aap.aal() == null) {
            permissionListener.onPermissionResult(str, 2);
        } else {
            aap.aaz().b(aap.aal(), str, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.games.e.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        e.this.a(str, ox, permissionListener);
                    } else {
                        permissionListener.onPermissionResult(str, 2);
                    }
                }
            });
        }
    }

    private String ox(String str) {
        if (str == null) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1785599184:
                if (str.equals(PermissionProxy.SCOPE_ID_CAMERA)) {
                    c = 0;
                    break;
                }
                break;
            case -1352756132:
                if (str.equals(PermissionProxy.SCOPE_ID_RECORD)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return PermissionRequest.RESOURCE_VIDEO_CAPTURE;
            case 1:
                return PermissionRequest.RESOURCE_AUDIO_CAPTURE;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final String str, @NonNull String str2, @NonNull final PermissionListener permissionListener) {
        com.baidu.swan.apps.af.a.a(str2, new String[]{str2}, 2, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.games.e.c.e.2
            @Override // com.baidu.swan.apps.af.b
            public void fo(String str3) {
                permissionListener.onPermissionResult(str, 0);
            }

            @Override // com.baidu.swan.apps.af.b
            public void t(int i, String str3) {
                permissionListener.onPermissionResult(str, 1);
            }
        });
    }
}
