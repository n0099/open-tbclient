package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private Map<String, com.baidu.m.a> cCm;

    private a() {
        this.cCm = new HashMap();
    }

    /* renamed from: com.baidu.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0105a {
        private static final a cCn = new a();
    }

    public static a auB() {
        return C0105a.cCn;
    }

    public boolean a(com.baidu.m.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.m.a> entry : this.cCm.entrySet()) {
            entry.getValue().stop();
        }
        this.cCm.clear();
        this.cCm.put(str, aVar);
        return true;
    }

    public void ra(String str) {
        com.baidu.m.a aVar;
        if (str != null && (aVar = this.cCm.get(str)) != null) {
            aVar.stop();
            this.cCm.remove(str);
        }
    }

    public com.baidu.m.a rb(String str) {
        com.baidu.m.a aVar;
        if (str == null || (aVar = this.cCm.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bE(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
