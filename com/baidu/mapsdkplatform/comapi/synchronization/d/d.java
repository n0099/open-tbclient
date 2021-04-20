package com.baidu.mapsdkplatform.comapi.synchronization.d;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f7788a;

    public d a(String str, String str2) {
        if (this.f7788a == null) {
            this.f7788a = new LinkedHashMap();
        }
        this.f7788a.put(str, str2);
        return this;
    }

    public String a() {
        StringBuilder sb;
        Map<String, String> map = this.f7788a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.f7788a.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f7788a.get(str2));
            if (i == 0) {
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
            i++;
        }
        return str;
    }
}
