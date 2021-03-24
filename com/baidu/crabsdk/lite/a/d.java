package com.baidu.crabsdk.lite.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    public static String a(String str) {
        Object obj;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4714a.get(str);
        return (hashMap == null || (obj = hashMap.get("sdk_channel")) == null) ? "N/A" : (String) obj;
    }
}
