package com.baidu.mobstat;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class cy implements cu {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f2663a;
    private TreeMap<String, String> b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.baidu.mobstat.cx
    public Iterator<String> b() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    @Override // com.baidu.mobstat.cx
    public String b(String str) {
        String str2 = this.b.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // com.baidu.mobstat.cx
    public byte[] c() {
        return this.f2663a;
    }

    @Override // com.baidu.mobstat.cu
    public void a(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // com.baidu.mobstat.cx
    public boolean c(String str) {
        return this.b.containsKey(str);
    }
}
