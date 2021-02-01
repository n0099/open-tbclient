package com.baidu.mapsdkplatform.comapi.synchronization.d;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f3103a;

    public d a(String str, String str2) {
        if (this.f3103a == null) {
            this.f3103a = new LinkedHashMap();
        }
        this.f3103a.put(str, str2);
        return this;
    }

    public String a() {
        if (this.f3103a == null || this.f3103a.isEmpty()) {
            return null;
        }
        String str = new String();
        Iterator<String> it = this.f3103a.keySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String next = it.next();
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f3103a.get(next));
            str = i2 == 0 ? str2 + next + "=" + encodeUrlParamsValue : str2 + ETAG.ITEM_SEPARATOR + next + "=" + encodeUrlParamsValue;
            i = i2 + 1;
        }
    }
}
