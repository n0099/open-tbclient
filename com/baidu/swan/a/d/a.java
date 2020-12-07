package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes5.dex */
public class a extends HttpCommonRequest<C0378a> {
    public a(C0378a c0378a) {
        super(c0378a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: bdv */
    public C0378a newBuilder() {
        return new C0378a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0378a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0378a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0378a extends HttpCommonRequestBuilder<C0378a> {
        public C0378a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0378a(a aVar) {
            this(aVar, null);
        }

        public C0378a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: bdf */
        public a build() {
            return new a(this);
        }
    }
}
