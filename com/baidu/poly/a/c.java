package com.baidu.poly.a;

import com.baidu.poly.a.c;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class c<T extends c> {
    private Map<String, String> map = com.baidu.poly.util.c.uU();

    public T P(String str, String str2) {
        this.map.put(str, str2);
        return this;
    }

    public String get(String str) {
        return this.map.get(str);
    }

    public Map<String, String> uJ() {
        return this.map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"map\":").append(this.map);
        sb.append('}');
        return sb.toString();
    }
}
