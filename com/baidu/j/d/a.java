package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.j.a> dfD;

    private a() {
        this.dfD = new HashMap();
    }

    /* renamed from: com.baidu.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0122a {
        private static final a dfE = new a();
    }

    public static a aFf() {
        return C0122a.dfE;
    }

    public boolean a(com.baidu.j.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.j.a> entry : this.dfD.entrySet()) {
            entry.getValue().stop();
        }
        this.dfD.clear();
        this.dfD.put(str, aVar);
        return true;
    }

    public void sC(String str) {
        com.baidu.j.a aVar;
        if (str != null && (aVar = this.dfD.get(str)) != null) {
            aVar.stop();
            this.dfD.remove(str);
        }
    }

    public com.baidu.j.a sD(String str) {
        com.baidu.j.a aVar;
        if (str == null || (aVar = this.dfD.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bj(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
