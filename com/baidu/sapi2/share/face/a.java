package com.baidu.sapi2.share.face;
/* loaded from: classes2.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f10980a;

    /* renamed from: b  reason: collision with root package name */
    public long f10981b;

    public a(String str, long j) {
        this.f10980a = str;
        this.f10981b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        int i = ((aVar.f10981b - this.f10981b) > 0L ? 1 : ((aVar.f10981b - this.f10981b) == 0L ? 0 : -1));
        if (i > 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }
}
