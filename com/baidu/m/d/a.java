package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    private Map<String, com.baidu.m.a> cCb;

    private a() {
        this.cCb = new HashMap();
    }

    /* renamed from: com.baidu.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0103a {
        private static final a cCc = new a();
    }

    public static a aui() {
        return C0103a.cCc;
    }

    public boolean a(com.baidu.m.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.m.a> entry : this.cCb.entrySet()) {
            entry.getValue().stop();
        }
        this.cCb.clear();
        this.cCb.put(str, aVar);
        return true;
    }

    public void qX(String str) {
        com.baidu.m.a aVar;
        if (str != null && (aVar = this.cCb.get(str)) != null) {
            aVar.stop();
            this.cCb.remove(str);
        }
    }

    public com.baidu.m.a qY(String str) {
        com.baidu.m.a aVar;
        if (str == null || (aVar = this.cCb.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bE(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
