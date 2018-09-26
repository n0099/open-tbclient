package com.baidu.mobstat;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class de implements da {
    private byte[] a;
    private TreeMap<String, String> b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.baidu.mobstat.dd
    public Iterator<String> b() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    @Override // com.baidu.mobstat.dd
    public String b(String str) {
        String str2 = this.b.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // com.baidu.mobstat.dd
    public byte[] c() {
        return this.a;
    }

    @Override // com.baidu.mobstat.da
    public void a(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // com.baidu.mobstat.dd
    public boolean c(String str) {
        return this.b.containsKey(str);
    }
}
