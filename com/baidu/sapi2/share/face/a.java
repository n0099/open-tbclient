package com.baidu.sapi2.share.face;
/* loaded from: classes2.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f11396a;

    /* renamed from: b  reason: collision with root package name */
    public long f11397b;

    public a(String str, long j) {
        this.f11396a = str;
        this.f11397b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        int i = ((aVar.f11397b - this.f11397b) > 0L ? 1 : ((aVar.f11397b - this.f11397b) == 0L ? 0 : -1));
        if (i > 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }
}
