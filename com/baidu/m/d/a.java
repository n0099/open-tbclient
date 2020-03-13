package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.m.a> cGm;

    private a() {
        this.cGm = new HashMap();
    }

    /* renamed from: com.baidu.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0113a {
        private static final a cGn = new a();
    }

    public static a awR() {
        return C0113a.cGn;
    }

    public boolean a(com.baidu.m.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.m.a> entry : this.cGm.entrySet()) {
            entry.getValue().stop();
        }
        this.cGm.clear();
        this.cGm.put(str, aVar);
        return true;
    }

    public void rp(String str) {
        com.baidu.m.a aVar;
        if (str != null && (aVar = this.cGm.get(str)) != null) {
            aVar.stop();
            this.cGm.remove(str);
        }
    }

    public com.baidu.m.a rq(String str) {
        com.baidu.m.a aVar;
        if (str == null || (aVar = this.cGm.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bI(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
