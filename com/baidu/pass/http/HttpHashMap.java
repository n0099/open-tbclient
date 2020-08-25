package com.baidu.pass.http;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class HttpHashMap implements com.baidu.pass.a {
    private Map<String, String> a = new HashMap();

    public void doSign(String str) {
    }

    public String get(String str) {
        return this.a.get(str);
    }

    public Map getMap() {
        return this.a;
    }

    public void put(String str, String str2) {
        this.a.put(str, str2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.a.putAll(map);
    }
}
