package com.baidu.sapi2.share.face;
/* loaded from: classes2.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f11395a;

    /* renamed from: b  reason: collision with root package name */
    public long f11396b;

    public a(String str, long j) {
        this.f11395a = str;
        this.f11396b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        long j = aVar.f11396b - this.f11396b;
        if (j > 0) {
            return -1;
        }
        return j == 0 ? 0 : 1;
    }
}
