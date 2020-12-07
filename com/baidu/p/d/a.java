package com.baidu.p.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class a {
    private Map<String, com.baidu.p.a> euV;

    private a() {
        this.euV = new HashMap();
    }

    /* renamed from: com.baidu.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private static class C0278a {
        private static final a euW = new a();
    }

    public static a bhV() {
        return C0278a.euW;
    }

    public boolean a(com.baidu.p.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.p.a> entry : this.euV.entrySet()) {
            entry.getValue().stop();
        }
        this.euV.clear();
        this.euV.put(str, aVar);
        return true;
    }

    public void zR(String str) {
        com.baidu.p.a aVar;
        if (str != null && (aVar = this.euV.get(str)) != null) {
            aVar.stop();
            this.euV.remove(str);
        }
    }

    public com.baidu.p.a zS(String str) {
        com.baidu.p.a aVar;
        if (str == null || (aVar = this.euV.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean cp(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
