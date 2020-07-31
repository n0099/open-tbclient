package com.baidu.swan.b.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes10.dex */
public class a extends HttpCommonRequest<C0419a> {
    public a(C0419a c0419a) {
        super(c0419a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: aKH */
    public C0419a newBuilder() {
        return new C0419a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0419a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0419a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0419a extends HttpCommonRequestBuilder<C0419a> {
        public C0419a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0419a(a aVar) {
            this(aVar, null);
        }

        public C0419a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: aKr */
        public a build() {
            return new a(this);
        }
    }
}
