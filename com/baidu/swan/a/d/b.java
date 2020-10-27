package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpOptions;
/* loaded from: classes8.dex */
public class b extends HttpCommonRequest<a> {
    public b(a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: aYy */
    public a newBuilder() {
        return new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: b */
    public a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method(HttpOptions.METHOD_NAME, requestBody).build();
    }

    /* loaded from: classes8.dex */
    public static class a extends HttpCommonRequestBuilder<a> {
        public a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public a(b bVar) {
            this(bVar, null);
        }

        public a(b bVar, AbstractHttpManager abstractHttpManager) {
            super(bVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: aYi */
        public b build() {
            return new b(this);
        }
    }
}
