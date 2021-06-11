package com.baidu.pass.http;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpHashMap implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f9225a = new HashMap();

    public void doSign(String str) {
    }

    public String get(String str) {
        return this.f9225a.get(str);
    }

    public Map getMap() {
        return this.f9225a;
    }

    public void put(String str, String str2) {
        this.f9225a.put(str, str2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f9225a.putAll(map);
    }
}
