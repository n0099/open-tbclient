package com.baidu.pano.platform.a.a;

import com.baidu.pano.platform.a.q;
import java.io.UnsupportedEncodingException;
/* loaded from: classes2.dex */
public class m extends com.baidu.pano.platform.a.n<String> {

    /* renamed from: a  reason: collision with root package name */
    public final q.b<String> f9345a;

    public m(int i, String str, q.b<String> bVar, q.a aVar) {
        super(i, str, aVar);
        this.f9345a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pano.platform.a.n
    /* renamed from: d */
    public void a(String str) {
        this.f9345a.a(str);
    }

    @Override // com.baidu.pano.platform.a.n
    public q<String> a(com.baidu.pano.platform.a.l lVar) {
        String str;
        try {
            str = new String(lVar.f9379b, h.a(lVar.f9380c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(lVar.f9379b);
        }
        return q.a(str, h.a(lVar));
    }

    public m(String str, q.b<String> bVar, q.a aVar) {
        this(0, str, bVar, aVar);
    }
}
