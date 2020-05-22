package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.j.a> dtr;

    private a() {
        this.dtr = new HashMap();
    }

    /* renamed from: com.baidu.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0153a {
        private static final a dtt = new a();
    }

    public static a aKA() {
        return C0153a.dtt;
    }

    public boolean a(com.baidu.j.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.j.a> entry : this.dtr.entrySet()) {
            entry.getValue().stop();
        }
        this.dtr.clear();
        this.dtr.put(str, aVar);
        return true;
    }

    public void ug(String str) {
        com.baidu.j.a aVar;
        if (str != null && (aVar = this.dtr.get(str)) != null) {
            aVar.stop();
            this.dtr.remove(str);
        }
    }

    public com.baidu.j.a uh(String str) {
        com.baidu.j.a aVar;
        if (str == null || (aVar = this.dtr.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bt(Context context) {
        return !com.baidu.swan.apps.aq.b.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
