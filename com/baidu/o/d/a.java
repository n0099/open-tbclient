package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    private Map<String, com.baidu.o.a> dNj;

    private a() {
        this.dNj = new HashMap();
    }

    /* renamed from: com.baidu.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0230a {
        private static final a dNk = new a();
    }

    public static a aXK() {
        return C0230a.dNk;
    }

    public boolean a(com.baidu.o.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.o.a> entry : this.dNj.entrySet()) {
            entry.getValue().stop();
        }
        this.dNj.clear();
        this.dNj.put(str, aVar);
        return true;
    }

    public void xD(String str) {
        com.baidu.o.a aVar;
        if (str != null && (aVar = this.dNj.get(str)) != null) {
            aVar.stop();
            this.dNj.remove(str);
        }
    }

    public com.baidu.o.a xE(String str) {
        com.baidu.o.a aVar;
        if (str == null || (aVar = this.dNj.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bE(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
