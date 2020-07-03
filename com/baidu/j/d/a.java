package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.j.a> dyb;

    private a() {
        this.dyb = new HashMap();
    }

    /* renamed from: com.baidu.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0155a {
        private static final a dyc = new a();
    }

    public static a aLG() {
        return C0155a.dyc;
    }

    public boolean a(com.baidu.j.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.j.a> entry : this.dyb.entrySet()) {
            entry.getValue().stop();
        }
        this.dyb.clear();
        this.dyb.put(str, aVar);
        return true;
    }

    public void uo(String str) {
        com.baidu.j.a aVar;
        if (str != null && (aVar = this.dyb.get(str)) != null) {
            aVar.stop();
            this.dyb.remove(str);
        }
    }

    public com.baidu.j.a up(String str) {
        com.baidu.j.a aVar;
        if (str == null || (aVar = this.dyb.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bu(Context context) {
        return !com.baidu.swan.apps.aq.b.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
