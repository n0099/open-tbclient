package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpRequestParasBuilder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class HttpRequestParasBuilder<T extends HttpRequestParasBuilder> extends HttpRequestBuilder<T> {
    protected LinkedHashMap<String, String> params;

    public HttpRequestParasBuilder(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
        this.params = new LinkedHashMap<>();
    }

    public HttpRequestParasBuilder(HttpParaRequest httpParaRequest, AbstractHttpManager abstractHttpManager) {
        super(httpParaRequest, abstractHttpManager);
        if (httpParaRequest.params != null) {
            this.params = new LinkedHashMap<>(httpParaRequest.params);
        } else {
            this.params = new LinkedHashMap<>();
        }
    }

    public T params(Map<String, String> map) {
        this.params = new LinkedHashMap<>(map);
        return this;
    }

    public T addParams(Map<String, String> map) {
        this.params.putAll(map);
        return this;
    }

    public T addParam(String str, String str2) {
        this.params.put(str, str2);
        return this;
    }

    public T removeParam(String str) {
        this.params.remove(str);
        return this;
    }

    public T removeParams(List<String> list) {
        if (list != null && list.size() > 0) {
            for (String str : list) {
                this.params.remove(str);
            }
        }
        return this;
    }
}
