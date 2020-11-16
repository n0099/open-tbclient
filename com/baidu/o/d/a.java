package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private Map<String, com.baidu.o.a> enV;

    private a() {
        this.enV = new HashMap();
    }

    /* renamed from: com.baidu.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0267a {
        private static final a enW = new a();
    }

    public static a beQ() {
        return C0267a.enW;
    }

    public boolean a(com.baidu.o.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.o.a> entry : this.enV.entrySet()) {
            entry.getValue().stop();
        }
        this.enV.clear();
        this.enV.put(str, aVar);
        return true;
    }

    public void zk(String str) {
        com.baidu.o.a aVar;
        if (str != null && (aVar = this.enV.get(str)) != null) {
            aVar.stop();
            this.enV.remove(str);
        }
    }

    public com.baidu.o.a zl(String str) {
        com.baidu.o.a aVar;
        if (str == null || (aVar = this.enV.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bJ(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
