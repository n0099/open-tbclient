package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class a {
    private Map<String, com.baidu.o.a> ebn;

    private a() {
        this.ebn = new HashMap();
    }

    /* renamed from: com.baidu.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C0243a {
        private static final a ebo = new a();
    }

    public static a bbe() {
        return C0243a.ebo;
    }

    public boolean a(com.baidu.o.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.o.a> entry : this.ebn.entrySet()) {
            entry.getValue().stop();
        }
        this.ebn.clear();
        this.ebn.put(str, aVar);
        return true;
    }

    public void yI(String str) {
        com.baidu.o.a aVar;
        if (str != null && (aVar = this.ebn.get(str)) != null) {
            aVar.stop();
            this.ebn.remove(str);
        }
    }

    public com.baidu.o.a yJ(String str) {
        com.baidu.o.a aVar;
        if (str == null || (aVar = this.ebn.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bJ(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
