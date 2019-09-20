package com.baidu.sapi2.share.a;
/* loaded from: classes.dex */
public class a implements Comparable<a> {
    public String a;
    public long b;

    public a(String str, long j) {
        this.a = str;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (aVar.b - this.b > 0) {
            return -1;
        }
        return aVar.b - this.b == 0 ? 0 : 1;
    }
}
