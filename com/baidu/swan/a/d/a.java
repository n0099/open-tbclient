package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes14.dex */
public class a extends HttpCommonRequest<C0357a> {
    public a(C0357a c0357a) {
        super(c0357a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: bcn */
    public C0357a newBuilder() {
        return new C0357a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0357a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0357a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0357a extends HttpCommonRequestBuilder<C0357a> {
        public C0357a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0357a(a aVar) {
            this(aVar, null);
        }

        public C0357a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: bbX */
        public a build() {
            return new a(this);
        }
    }
}
