package com.baidu.pass.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class HttpResponseHandler extends Handler {
    protected static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    protected boolean executCallbackInChildThread;
    protected String mDefaultCharset;

    public HttpResponseHandler() {
        this("UTF-8");
    }

    public HttpResponseHandler(String str) {
        this.mDefaultCharset = str;
    }

    public HttpResponseHandler(Looper looper) {
        this(looper, false);
    }

    public HttpResponseHandler(Looper looper, boolean z) {
        super(looper);
        this.executCallbackInChildThread = z;
        this.mDefaultCharset = "UTF-8";
    }

    protected void onStart() {
    }

    protected void onFinish() {
    }

    protected void onFailure(Throwable th, String str) {
    }

    protected void onSuccess(int i, String str) {
    }

    protected void onSuccess(int i, String str, HashMap<String, String> hashMap) {
        onSuccess(i, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.executCallbackInChildThread) {
            onStart();
        } else {
            sendMessage(obtainMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.executCallbackInChildThread) {
            onFinish();
        } else {
            sendMessage(obtainMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Throwable th, String str) {
        if (this.executCallbackInChildThread) {
            onFailure(th, str);
        } else {
            sendMessage(obtainMessage(1, new Object[]{th, str}));
        }
    }

    void a(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            onSuccess(i, bArr == null ? null : new String(bArr), hashMap);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (i == 200) {
            a(i, hashMap, bArr);
            return;
        }
        String str = bArr == null ? null : new String(bArr);
        a(new HttpErrorException(i, str), str);
    }

    void b(int i, HashMap<String, String> hashMap, byte[] bArr) {
        onSuccess(i, bArr == null ? null : new String(bArr), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Throwable th, String str) {
        onFailure(th, str);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                b(((Integer) objArr[0]).intValue(), (HashMap) objArr[1], (byte[]) objArr[2]);
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                b((Throwable) objArr2[0], (String) objArr2[1]);
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
}
