package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class a {
    private Map<String, com.baidu.o.a> epD;

    private a() {
        this.epD = new HashMap();
    }

    /* renamed from: com.baidu.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C0269a {
        private static final a epE = new a();
    }

    public static a bfx() {
        return C0269a.epE;
    }

    public boolean a(com.baidu.o.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.o.a> entry : this.epD.entrySet()) {
            entry.getValue().stop();
        }
        this.epD.clear();
        this.epD.put(str, aVar);
        return true;
    }

    public void zp(String str) {
        com.baidu.o.a aVar;
        if (str != null && (aVar = this.epD.get(str)) != null) {
            aVar.stop();
            this.epD.remove(str);
        }
    }

    public com.baidu.o.a zq(String str) {
        com.baidu.o.a aVar;
        if (str == null || (aVar = this.epD.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bJ(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
