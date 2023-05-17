package com.baidu.searchbox.network.outback.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.FormBody;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import java.util.Map;
/* loaded from: classes3.dex */
public class PostFormRequest extends Request {

    /* loaded from: classes3.dex */
    public static class PostFormRequestBuilder extends Request.Builder<PostFormRequestBuilder> {
        public FormBody.Builder bodyBuilder;

        public PostFormRequestBuilder(PostFormRequest postFormRequest) {
            super(postFormRequest);
            this.bodyBuilder = new FormBody.Builder();
        }

        public PostFormRequestBuilder addParams(Map<String, String> map) {
            for (String str : map.keySet()) {
                addParam(str, map.get(str));
            }
            return this;
        }

        public PostFormRequestBuilder params(Map<String, String> map) {
            this.bodyBuilder = new FormBody.Builder();
            for (String str : map.keySet()) {
                this.bodyBuilder.add(str, map.get(str));
            }
            return this;
        }

        public PostFormRequestBuilder(Map<String, CallFactory> map) {
            super(map);
            this.bodyBuilder = new FormBody.Builder();
        }

        public PostFormRequestBuilder addParam(String str, String str2) {
            this.bodyBuilder.add(str, str2);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PostFormRequest build() {
            RequestBody requestBody = this.body;
            if (requestBody != null) {
                int size = ((FormBody) requestBody).size();
                for (int i = 0; i < size; i++) {
                    this.bodyBuilder.addEncoded(((FormBody) this.body).name(i), ((FormBody) this.body).value(i));
                }
            }
            return new PostFormRequest(post(this.bodyBuilder.build()));
        }
    }

    public PostFormRequest(PostFormRequestBuilder postFormRequestBuilder) {
        super(postFormRequestBuilder);
    }
}
