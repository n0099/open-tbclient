package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.m.a> cGl;

    private a() {
        this.cGl = new HashMap();
    }

    /* renamed from: com.baidu.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0113a {
        private static final a cGm = new a();
    }

    public static a awR() {
        return C0113a.cGm;
    }

    public boolean a(com.baidu.m.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.m.a> entry : this.cGl.entrySet()) {
            entry.getValue().stop();
        }
        this.cGl.clear();
        this.cGl.put(str, aVar);
        return true;
    }

    public void rp(String str) {
        com.baidu.m.a aVar;
        if (str != null && (aVar = this.cGl.get(str)) != null) {
            aVar.stop();
            this.cGl.remove(str);
        }
    }

    public com.baidu.m.a rq(String str) {
        com.baidu.m.a aVar;
        if (str == null || (aVar = this.cGl.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bI(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
