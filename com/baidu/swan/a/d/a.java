package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes15.dex */
public class a extends HttpCommonRequest<C0351a> {
    public a(C0351a c0351a) {
        super(c0351a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: bcl */
    public C0351a newBuilder() {
        return new C0351a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0351a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0351a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0351a extends HttpCommonRequestBuilder<C0351a> {
        public C0351a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0351a(a aVar) {
            this(aVar, null);
        }

        public C0351a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: bbV */
        public a build() {
            return new a(this);
        }
    }
}
