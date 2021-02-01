package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes15.dex */
public class c extends HttpCommonRequest<a> {
    public c(a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: bcn */
    public a newBuilder() {
        return new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: c */
    public a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method(HttpTrace.METHOD_NAME, requestBody).build();
    }

    /* loaded from: classes15.dex */
    public static class a extends HttpCommonRequestBuilder<a> {
        public a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public a(c cVar) {
            this(cVar, null);
        }

        public a(c cVar, AbstractHttpManager abstractHttpManager) {
            super(cVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: bbX */
        public c build() {
            return new c(this);
        }
    }
}
