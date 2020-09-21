package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.o.a> dPm;

    private a() {
        this.dPm = new HashMap();
    }

    /* renamed from: com.baidu.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0228a {
        private static final a dPn = new a();
    }

    public static a aYw() {
        return C0228a.dPn;
    }

    public boolean a(com.baidu.o.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.o.a> entry : this.dPm.entrySet()) {
            entry.getValue().stop();
        }
        this.dPm.clear();
        this.dPm.put(str, aVar);
        return true;
    }

    public void xW(String str) {
        com.baidu.o.a aVar;
        if (str != null && (aVar = this.dPm.get(str)) != null) {
            aVar.stop();
            this.dPm.remove(str);
        }
    }

    public com.baidu.o.a xX(String str) {
        com.baidu.o.a aVar;
        if (str == null || (aVar = this.dPm.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bD(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
