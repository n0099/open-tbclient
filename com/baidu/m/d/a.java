package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.m.a> cGx;

    private a() {
        this.cGx = new HashMap();
    }

    /* renamed from: com.baidu.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0113a {
        private static final a cGy = new a();
    }

    public static a awU() {
        return C0113a.cGy;
    }

    public boolean a(com.baidu.m.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.m.a> entry : this.cGx.entrySet()) {
            entry.getValue().stop();
        }
        this.cGx.clear();
        this.cGx.put(str, aVar);
        return true;
    }

    public void ro(String str) {
        com.baidu.m.a aVar;
        if (str != null && (aVar = this.cGx.get(str)) != null) {
            aVar.stop();
            this.cGx.remove(str);
        }
    }

    public com.baidu.m.a rp(String str) {
        com.baidu.m.a aVar;
        if (str == null || (aVar = this.cGx.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bH(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
