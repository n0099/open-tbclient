package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.m.a> cGk;

    private a() {
        this.cGk = new HashMap();
    }

    /* renamed from: com.baidu.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0113a {
        private static final a cGl = new a();
    }

    public static a awP() {
        return C0113a.cGl;
    }

    public boolean a(com.baidu.m.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.m.a> entry : this.cGk.entrySet()) {
            entry.getValue().stop();
        }
        this.cGk.clear();
        this.cGk.put(str, aVar);
        return true;
    }

    public void rp(String str) {
        com.baidu.m.a aVar;
        if (str != null && (aVar = this.cGk.get(str)) != null) {
            aVar.stop();
            this.cGk.remove(str);
        }
    }

    public com.baidu.m.a rq(String str) {
        com.baidu.m.a aVar;
        if (str == null || (aVar = this.cGk.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bI(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
