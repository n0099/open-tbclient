package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class a {
    private Map<String, com.baidu.o.a> ejJ;

    private a() {
        this.ejJ = new HashMap();
    }

    /* renamed from: com.baidu.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C0257a {
        private static final a ejK = new a();
    }

    public static a bcX() {
        return C0257a.ejK;
    }

    public boolean a(com.baidu.o.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.o.a> entry : this.ejJ.entrySet()) {
            entry.getValue().stop();
        }
        this.ejJ.clear();
        this.ejJ.put(str, aVar);
        return true;
    }

    public void zb(String str) {
        com.baidu.o.a aVar;
        if (str != null && (aVar = this.ejJ.get(str)) != null) {
            aVar.stop();
            this.ejJ.remove(str);
        }
    }

    public com.baidu.o.a zc(String str) {
        com.baidu.o.a aVar;
        if (str == null || (aVar = this.ejJ.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bJ(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
