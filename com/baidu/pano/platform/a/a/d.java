package com.baidu.pano.platform.a.a;

import com.baidu.pano.platform.a.q;
/* loaded from: classes6.dex */
public class d extends com.baidu.pano.platform.a.n<byte[]> {
    private final q.b<byte[]> a;

    public d(int i, String str, q.b<byte[]> bVar, q.a aVar) {
        super(i, str, aVar);
        this.a = bVar;
    }

    public d(String str, q.b<byte[]> bVar, q.a aVar) {
        this(0, str, bVar, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pano.platform.a.n
    public void a(byte[] bArr) {
        this.a.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pano.platform.a.n
    public q<byte[]> a(com.baidu.pano.platform.a.l lVar) {
        return q.a(lVar.b, h.a(lVar));
    }
}
