package com.baidu.swan.c.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes11.dex */
public class a extends HttpCommonRequest<C0414a> {
    public a(C0414a c0414a) {
        super(c0414a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: aFK */
    public C0414a newBuilder() {
        return new C0414a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0414a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0414a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0414a extends HttpCommonRequestBuilder<C0414a> {
        public C0414a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0414a(a aVar) {
            this(aVar, null);
        }

        public C0414a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: aFu */
        public a build() {
            return new a(this);
        }
    }
}
