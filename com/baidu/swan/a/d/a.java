package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes8.dex */
public class a extends HttpCommonRequest<C0356a> {
    public a(C0356a c0356a) {
        super(c0356a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: aYx */
    public C0356a newBuilder() {
        return new C0356a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0356a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0356a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0356a extends HttpCommonRequestBuilder<C0356a> {
        public C0356a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0356a(a aVar) {
            this(aVar, null);
        }

        public C0356a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: aYh */
        public a build() {
            return new a(this);
        }
    }
}
