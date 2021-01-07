package com.baidu.sapi2.share.face;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f5355a;

    /* renamed from: b  reason: collision with root package name */
    public long f5356b;

    public a(String str, long j) {
        this.f5355a = str;
        this.f5356b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        long j = aVar.f5356b;
        long j2 = this.f5356b;
        if (j - j2 > 0) {
            return -1;
        }
        return j - j2 == 0 ? 0 : 1;
    }
}
