package com.baidu.cloudsdk.common.http;

import android.os.Handler;
import android.os.Message;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
public class HttpResponseHandler extends Handler {
    protected static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    protected String mDefaultCharset;

    public HttpResponseHandler() {
        this(DEFAULT_CHARSET);
    }

    public HttpResponseHandler(String str) {
        this.mDefaultCharset = str;
    }

    protected void handleFailureMessage(Throwable th, String str) {
        onFailure(th, str);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                handleFailureMessage((Throwable) objArr2[0], (String) objArr2[1]);
                return;
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            default:
                return;
        }
    }

    protected void handleSuccessMessage(int i, String str) {
        onSuccess(i, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFailure(Throwable th, String str) {
    }

    protected void onFinish() {
    }

    protected void onStart() {
    }

    protected void onSuccess(int i, String str) {
        onSuccess(str);
    }

    protected void onSuccess(String str) {
    }

    public void sendFailureMessage(Throwable th, String str) {
        sendMessage(obtainMessage(1, new Object[]{th, str}));
    }

    public void sendFailureMessage(Throwable th, byte[] bArr) {
        sendMessage(obtainMessage(1, new Object[]{th, bArr}));
    }

    public void sendFinishMessage() {
        sendMessage(obtainMessage(3));
    }

    public void sendResponseMessage(HttpResponse httpResponse) {
        String str = null;
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            try {
                str = EntityUtils.toString(entity, this.mDefaultCharset);
            } catch (Exception e) {
                sendFailureMessage(e, (String) null);
                return;
            }
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine.getStatusCode() >= 300) {
            sendFailureMessage((Throwable) new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), str);
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), str);
        }
    }

    public void sendStartMessage() {
        sendMessage(obtainMessage(2));
    }

    protected void sendSuccessMessage(int i, String str) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), str}));
    }
}
