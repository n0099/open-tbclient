package com.baidu.k.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.aq.c;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Map<String, com.baidu.k.a> dDX;

    private a() {
        this.dDX = new HashMap();
    }

    /* renamed from: com.baidu.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0154a {
        private static final a dDY = new a();
    }

    public static a aPu() {
        return C0154a.dDY;
    }

    public boolean a(com.baidu.k.a aVar, String str) {
        if (aVar == null || str == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.k.a> entry : this.dDX.entrySet()) {
            entry.getValue().stop();
        }
        this.dDX.clear();
        this.dDX.put(str, aVar);
        return true;
    }

    public void vr(String str) {
        com.baidu.k.a aVar;
        if (str != null && (aVar = this.dDX.get(str)) != null) {
            aVar.stop();
            this.dDX.remove(str);
        }
    }

    public com.baidu.k.a vs(String str) {
        com.baidu.k.a aVar;
        if (str == null || (aVar = this.dDX.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static boolean bx(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }
}
