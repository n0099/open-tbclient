package com.baidu.swan.a.d;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes4.dex */
public class a extends HttpCommonRequest<C0330a> {
    public a(C0330a c0330a) {
        super(c0330a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: aTj */
    public C0330a newBuilder() {
        return new C0330a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0330a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0330a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    /* renamed from: com.baidu.swan.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0330a extends HttpCommonRequestBuilder<C0330a> {
        public C0330a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public C0330a(a aVar) {
            this(aVar, null);
        }

        public C0330a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: aST */
        public a build() {
            return new a(this);
        }
    }
}
