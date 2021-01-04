package com.baidu.pano.platform.a.a;

import com.baidu.pano.platform.a.q;
import java.io.UnsupportedEncodingException;
/* loaded from: classes15.dex */
public class m extends com.baidu.pano.platform.a.n<String> {

    /* renamed from: a  reason: collision with root package name */
    private final q.b<String> f3900a;

    public m(int i, String str, q.b<String> bVar, q.a aVar) {
        super(i, str, aVar);
        this.f3900a = bVar;
    }

    public m(String str, q.b<String> bVar, q.a aVar) {
        this(0, str, bVar, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pano.platform.a.n
    /* renamed from: d */
    public void a(String str) {
        this.f3900a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pano.platform.a.n
    public q<String> a(com.baidu.pano.platform.a.l lVar) {
        String str;
        try {
            str = new String(lVar.f3918b, h.a(lVar.c));
        } catch (UnsupportedEncodingException e) {
            str = new String(lVar.f3918b);
        }
        return q.a(str, h.a(lVar));
    }
}
