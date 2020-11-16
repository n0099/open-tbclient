package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes5.dex */
public class a extends HttpCommonRequest<C0366a> {
    public a(C0366a c0366a) {
        super(c0366a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: baq */
    public C0366a newBuilder() {
        return new C0366a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0366a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0366a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0366a extends HttpCommonRequestBuilder<C0366a> {
        public C0366a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0366a(a aVar) {
            this(aVar, null);
        }

        public C0366a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: baa */
        public a build() {
            return new a(this);
        }
    }
}
