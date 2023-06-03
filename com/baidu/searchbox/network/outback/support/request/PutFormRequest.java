package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.FormBody;
import com.baidu.searchbox.network.outback.core.Request;
import java.util.Map;
/* loaded from: classes4.dex */
public class PutFormRequest extends Request {

    /* loaded from: classes4.dex */
    public static class PutFormRequestBuilder extends Request.Builder<PutFormRequestBuilder> {
        public FormBody.Builder bodyBuilder;

        public PutFormRequestBuilder(PutFormRequest putFormRequest) {
            super(putFormRequest);
            this.bodyBuilder = new FormBody.Builder();
        }

        public PutFormRequestBuilder addParams(Map<String, String> map) {
            for (String str : map.keySet()) {
                addParam(str, map.get(str));
            }
            return this;
        }

        public PutFormRequestBuilder params(Map<String, String> map) {
            this.bodyBuilder = new FormBody.Builder();
            for (String str : map.keySet()) {
                this.bodyBuilder.add(str, map.get(str));
            }
            return this;
        }

        public PutFormRequestBuilder(Map<String, CallFactory> map) {
            super(map);
            this.bodyBuilder = new FormBody.Builder();
        }

        public PutFormRequestBuilder addParam(String str, String str2) {
            this.bodyBuilder.add(str, str2);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PutFormRequest build() {
            return new PutFormRequest(put(this.bodyBuilder.build()));
        }
    }

    public PutFormRequest(PutFormRequestBuilder putFormRequestBuilder) {
        super(putFormRequestBuilder);
    }
}
