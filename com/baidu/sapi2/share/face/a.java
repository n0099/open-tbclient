package com.baidu.sapi2.share.face;
/* loaded from: classes6.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f3525a;
    public long b;

    public a(String str, long j) {
        this.f3525a = str;
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
