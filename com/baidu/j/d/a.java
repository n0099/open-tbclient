package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.j.a> dfy;

    private a() {
        this.dfy = new HashMap();
    }

    /* renamed from: com.baidu.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0101a {
        private static final a dfz = new a();
    }

    public static a aFf() {
        return C0101a.dfz;
    }

    public boolean a(com.baidu.j.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.j.a> entry : this.dfy.entrySet()) {
            entry.getValue().stop();
        }
        this.dfy.clear();
        this.dfy.put(str, aVar);
        return true;
    }

    public void sC(String str) {
        com.baidu.j.a aVar;
        if (str != null && (aVar = this.dfy.get(str)) != null) {
            aVar.stop();
            this.dfy.remove(str);
        }
    }

    public com.baidu.j.a sD(String str) {
        com.baidu.j.a aVar;
        if (str == null || (aVar = this.dfy.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bv(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
