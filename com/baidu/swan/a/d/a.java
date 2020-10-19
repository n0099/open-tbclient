package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes8.dex */
public class a extends HttpCommonRequest<C0342a> {
    public a(C0342a c0342a) {
        super(c0342a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: aWE */
    public C0342a newBuilder() {
        return new C0342a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0342a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0342a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0342a extends HttpCommonRequestBuilder<C0342a> {
        public C0342a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0342a(a aVar) {
            this(aVar, null);
        }

        public C0342a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: aWo */
        public a build() {
            return new a(this);
        }
    }
}
