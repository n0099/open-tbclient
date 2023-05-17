package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.base.AbstractHttpManager;
import com.baidu.searchbox.network.outback.support.request.DeleteRequest;
import com.baidu.searchbox.network.outback.support.request.HeadRequest;
import com.baidu.searchbox.network.outback.support.request.PatchRequest;
import com.baidu.searchbox.network.outback.support.request.PostBodyRequest;
import com.baidu.searchbox.network.outback.support.request.PostFileRequest;
import com.baidu.searchbox.network.outback.support.request.PostMultiPartFormRequest;
import com.baidu.searchbox.network.outback.support.request.PutBodyRequest;
import com.baidu.searchbox.network.outback.support.request.PutFormRequest;
/* loaded from: classes3.dex */
public class HttpRequestCompat {
    public AbstractHttpManager httpManager;

    public HttpRequestCompat(AbstractHttpManager abstractHttpManager) {
        this.httpManager = abstractHttpManager;
    }

    public DeleteRequest.DeleteRequestBuilder deleteRequest() {
        return new DeleteRequest.DeleteRequestBuilder(this.httpManager.getCallFactoryMap());
    }

    public HeadRequest.HeadRequestBuilder headRequest() {
        return new HeadRequest.HeadRequestBuilder(this.httpManager.getCallFactoryMap());
    }

    public PatchRequest.PatchRequestBuilder patchRequest() {
        return new PatchRequest.PatchRequestBuilder(this.httpManager.getCallFactoryMap());
    }

    public PostFileRequest.PostFileRequestBuilder postFileRequest() {
        return new PostFileRequest.PostFileRequestBuilder(this.httpManager.getCallFactoryMap());
    }

    public PostMultiPartFormRequest.PostMultiPartFormRequestBuilder postMultiPartRequest() {
        return new PostMultiPartFormRequest.PostMultiPartFormRequestBuilder(this.httpManager.getCallFactoryMap());
    }

    public PostBodyRequest.PostBodyRequestBuilder postRequest() {
        return new PostBodyRequest.PostBodyRequestBuilder(this.httpManager.getCallFactoryMap());
    }

    public PutFormRequest.PutFormRequestBuilder putFormRequest() {
        return new PutFormRequest.PutFormRequestBuilder(this.httpManager.getCallFactoryMap());
    }

    public PutBodyRequest.PutBodyRequestBuilder putRequest() {
        return new PutBodyRequest.PutBodyRequestBuilder(this.httpManager.getCallFactoryMap());
    }
}
