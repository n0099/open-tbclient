package com.baidu.pass.http;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class HttpHashMap implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f4096a = new HashMap();

    public void doSign(String str) {
    }

    public String get(String str) {
        return this.f4096a.get(str);
    }

    public Map getMap() {
        return this.f4096a;
    }

    public void put(String str, String str2) {
        this.f4096a.put(str, str2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f4096a.putAll(map);
    }
}
