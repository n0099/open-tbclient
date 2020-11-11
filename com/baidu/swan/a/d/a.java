package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes8.dex */
public class a extends HttpCommonRequest<C0368a> {
    public a(C0368a c0368a) {
        super(c0368a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: baX */
    public C0368a newBuilder() {
        return new C0368a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0368a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0368a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0368a extends HttpCommonRequestBuilder<C0368a> {
        public C0368a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0368a(a aVar) {
            this(aVar, null);
        }

        public C0368a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: baH */
        public a build() {
            return new a(this);
        }
    }
}
