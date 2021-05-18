package com.baidu.mobstat;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class cy implements cu {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8894a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<String, String> f8895b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.baidu.mobstat.cu
    public void a(String str, String str2) {
        this.f8895b.put(str, str2);
    }

    @Override // com.baidu.mobstat.cx
    public Iterator<String> b() {
        return Collections.unmodifiableSet(this.f8895b.keySet()).iterator();
    }

    @Override // com.baidu.mobstat.cx
    public byte[] c() {
        return this.f8894a;
    }

    @Override // com.baidu.mobstat.cx
    public String b(String str) {
        String str2 = this.f8895b.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // com.baidu.mobstat.cx
    public boolean c(String str) {
        return this.f8895b.containsKey(str);
    }
}
