package com.baidu.cloudsdk.social.core.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class RequestCodeManager {

    /* renamed from: a  reason: collision with root package name */
    private static Map f851a = new HashMap();
    private static int b = 5655;

    public static synchronized int getLatestRequestCode(String str) {
        int intValue;
        synchronized (RequestCodeManager.class) {
            Integer num = (Integer) f851a.get(str);
            intValue = num != null ? num.intValue() : 0;
        }
        return intValue;
    }

    public static synchronized int nextCode(String str) {
        int i;
        synchronized (RequestCodeManager.class) {
            b++;
            if (b == 6656) {
                b = 5656;
            }
            f851a.put(str, Integer.valueOf(b));
            i = b;
        }
        return i;
    }
}
