package com.baidu.sofire.utility;

import android.content.Context;
import android.util.Base64;
import com.baidu.searchbox.track.ui.TrackUI;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class v {
    public static void a(Context context, String str, int i2, Throwable th) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", str);
            hashMap.put("1", Integer.valueOf(i2));
            hashMap.put("2", Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            c.a(context, "1090102", (Map<String, Object>) hashMap, true);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static void a(Context context, String str, int i2, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", str);
            hashMap.put("1", Integer.valueOf(i2));
            if (i2 == 2) {
                hashMap.put("2", Integer.valueOf(i3));
            }
            c.a(context, "1090101", hashMap);
        } catch (Throwable unused) {
            c.a();
        }
    }
}
