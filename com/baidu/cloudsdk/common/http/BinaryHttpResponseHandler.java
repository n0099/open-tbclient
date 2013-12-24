package com.baidu.cloudsdk.common.http;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
public class BinaryHttpResponseHandler extends HttpResponseHandler {
    private String[] a;

    public BinaryHttpResponseHandler() {
        this.a = new String[]{"image/jpeg", "image/png"};
    }

    public BinaryHttpResponseHandler(String[] strArr) {
        this.a = new String[]{"image/jpeg", "image/png"};
        this.a = strArr;
    }

    protected void handleFailureMessage(Throwable th, byte[] bArr) {
        onFailure(th, bArr);
    }

    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler, android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                handleFailureMessage((Throwable) objArr2[0], (byte[]) objArr2[1]);
                break;
        }
        super.handleMessage(message);
    }

    protected void handleSuccessMessage(int i, byte[] bArr) {
        onSuccess(i, bArr);
    }

    protected void onFailure(Throwable th, byte[] bArr) {
    }

    protected void onSuccess(int i, byte[] bArr) {
        onSuccess(bArr);
    }

    protected void onSuccess(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void sendResponseMessage(HttpResponse httpResponse) {
        boolean z = true;
        byte[] bArr = null;
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            sendFailureMessage((Throwable) new HttpResponseException(statusLine.getStatusCode(), "None or more than one Content-Type Header found!"), (byte[]) null);
            return;
        }
        Header header = headers[0];
        String[] strArr = this.a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (strArr[i].equalsIgnoreCase(header.getValue())) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            sendFailureMessage((Throwable) new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"), (byte[]) null);
            return;
        }
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            try {
                bArr = EntityUtils.toByteArray(entity);
            } catch (IOException e) {
                sendFailureMessage(e, (byte[]) null);
                return;
            }
        }
        if (statusLine.getStatusCode() >= 300) {
            sendFailureMessage((Throwable) new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), bArr);
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), bArr);
        }
    }

    protected void sendSuccessMessage(int i, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), bArr}));
    }
}
