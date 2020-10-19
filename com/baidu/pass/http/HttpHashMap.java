package com.baidu.pass.http;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class HttpHashMap implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f2784a = new HashMap();

    public void doSign(String str) {
    }

    public String get(String str) {
        return this.f2784a.get(str);
    }

    public Map getMap() {
        return this.f2784a;
    }

    public void put(String str, String str2) {
        this.f2784a.put(str, str2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f2784a.putAll(map);
    }
}
