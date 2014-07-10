package com.baidu.cloudsdk.common.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
class AsyncHttpRequest implements Runnable {
    private AbstractHttpClient mHttpClient;
    private HttpContext mHttpContext;
    private boolean mIsBinaryRequest;
    private HttpUriRequest mRequest;
    private HttpResponseHandler mResponseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, HttpResponseHandler httpResponseHandler) {
        this.mHttpClient = abstractHttpClient;
        this.mHttpContext = httpContext;
        this.mRequest = httpUriRequest;
        this.mResponseHandler = httpResponseHandler;
        if (httpResponseHandler instanceof BinaryHttpResponseHandler) {
            this.mIsBinaryRequest = true;
        } else {
            this.mIsBinaryRequest = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mResponseHandler != null) {
                this.mResponseHandler.sendStartMessage();
            }
            makeRequest();
            if (this.mResponseHandler != null) {
                this.mResponseHandler.sendFinishMessage();
            }
        } catch (InterruptedException e) {
        } catch (Exception e2) {
            if (this.mResponseHandler != null) {
                this.mResponseHandler.sendFinishMessage();
                if (this.mIsBinaryRequest) {
                    this.mResponseHandler.sendFailureMessage(e2, (byte[]) null);
                } else {
                    this.mResponseHandler.sendFailureMessage(e2, (String) null);
                }
            }
        }
    }

    private void makeRequest() {
        if (!Thread.currentThread().isInterrupted()) {
            HttpResponse execute = this.mHttpClient.execute(this.mRequest, this.mHttpContext);
            if (!Thread.currentThread().isInterrupted()) {
                if (this.mResponseHandler != null) {
                    this.mResponseHandler.sendResponseMessage(execute);
                    return;
                }
                return;
            }
            throw new InterruptedException("the request has been cancelled");
        }
    }
}
