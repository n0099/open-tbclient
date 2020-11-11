package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a implements ParamBuilder<a> {

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, String> f3194a;

    public a a(String str, String str2) {
        if (this.f3194a == null) {
            this.f3194a = new LinkedHashMap();
        }
        this.f3194a.put(str, str2);
        return this;
    }

    public String a() {
        if (this.f3194a == null || this.f3194a.isEmpty()) {
            return null;
        }
        String str = new String();
        Iterator<String> it = this.f3194a.keySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String next = it.next();
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f3194a.get(next));
            str = i2 == 0 ? str2 + next + ETAG.EQUAL + encodeUrlParamsValue : str2 + ETAG.ITEM_SEPARATOR + next + ETAG.EQUAL + encodeUrlParamsValue;
            i = i2 + 1;
        }
    }
}
