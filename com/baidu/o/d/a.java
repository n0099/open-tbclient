package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    private Map<String, com.baidu.o.a> dNf;

    private a() {
        this.dNf = new HashMap();
    }

    /* renamed from: com.baidu.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0230a {
        private static final a dNg = new a();
    }

    public static a aXK() {
        return C0230a.dNg;
    }

    public boolean a(com.baidu.o.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.o.a> entry : this.dNf.entrySet()) {
            entry.getValue().stop();
        }
        this.dNf.clear();
        this.dNf.put(str, aVar);
        return true;
    }

    public void xC(String str) {
        com.baidu.o.a aVar;
        if (str != null && (aVar = this.dNf.get(str)) != null) {
            aVar.stop();
            this.dNf.remove(str);
        }
    }

    public com.baidu.o.a xD(String str) {
        com.baidu.o.a aVar;
        if (str == null || (aVar = this.dNf.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bE(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
