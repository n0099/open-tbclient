package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a extends HttpCommonRequest<C0354a> {
    public a(C0354a c0354a) {
        super(c0354a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: bbY */
    public C0354a newBuilder() {
        return new C0354a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0354a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0354a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0354a extends HttpCommonRequestBuilder<C0354a> {
        public C0354a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0354a(a aVar) {
            this(aVar, null);
        }

        public C0354a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: bbI */
        public a build() {
            return new a(this);
        }
    }
}
