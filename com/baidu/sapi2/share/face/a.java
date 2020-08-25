package com.baidu.sapi2.share.face;
/* loaded from: classes12.dex */
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
        long j = aVar.b;
        long j2 = this.b;
        if (j - j2 > 0) {
            return -1;
        }
        return j - j2 == 0 ? 0 : 1;
    }
}
