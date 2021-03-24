package com.baidu.pano.platform.a.a;

import com.baidu.pano.platform.a.q;
/* loaded from: classes2.dex */
public class d extends com.baidu.pano.platform.a.n<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final q.b<byte[]> f9323a;

    public d(int i, String str, q.b<byte[]> bVar, q.a aVar) {
        super(i, str, aVar);
        this.f9323a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pano.platform.a.n
    public void a(byte[] bArr) {
        this.f9323a.a(bArr);
    }

    public d(String str, q.b<byte[]> bVar, q.a aVar) {
        this(0, str, bVar, aVar);
    }

    @Override // com.baidu.pano.platform.a.n
    public q<byte[]> a(com.baidu.pano.platform.a.l lVar) {
        return q.a(lVar.f9379b, h.a(lVar));
    }
}
