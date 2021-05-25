package com.baidu.mapsdkplatform.comapi.synchronization.d;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f7766a;

    public d a(String str, String str2) {
        if (this.f7766a == null) {
            this.f7766a = new LinkedHashMap();
        }
        this.f7766a.put(str, str2);
        return this;
    }

    public String a() {
        StringBuilder sb;
        Map<String, String> map = this.f7766a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i2 = 0;
        for (String str2 : this.f7766a.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f7766a.get(str2));
            if (i2 == 0) {
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str = "&";
            }
            sb.append(str);
            sb.append(str2);
            sb.append("=");
            sb.append(encodeUrlParamsValue);
            str = sb.toString();
            i2++;
        }
        return str;
    }
}
