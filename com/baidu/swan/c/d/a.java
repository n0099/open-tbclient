package com.baidu.swan.c.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes11.dex */
public class a extends HttpCommonRequest<C0420a> {
    public a(C0420a c0420a) {
        super(c0420a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: aGQ */
    public C0420a newBuilder() {
        return new C0420a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0420a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0420a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0420a extends HttpCommonRequestBuilder<C0420a> {
        public C0420a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0420a(a aVar) {
            this(aVar, null);
        }

        public C0420a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: aGA */
        public a build() {
            return new a(this);
        }
    }
}
