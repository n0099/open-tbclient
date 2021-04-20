package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements ParamBuilder<a> {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f9985a;

    public a a(String str, String str2) {
        if (this.f9985a == null) {
            this.f9985a = new LinkedHashMap();
        }
        this.f9985a.put(str, str2);
        return this;
    }

    public String a() {
        StringBuilder sb;
        Map<String, String> map = this.f9985a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.f9985a.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f9985a.get(str2));
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
