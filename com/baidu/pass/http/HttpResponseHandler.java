package com.baidu.pass.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class HttpResponseHandler extends Handler implements com.baidu.pass.a {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final int FAILURE_MESSAGE = 1;
    public static final int FINISH_MESSAGE = 3;
    public static final int START_MESSAGE = 2;
    public static final int SUCCESS_MESSAGE = 0;
    public boolean executCallbackInChildThread;
    public String mDefaultCharset;

    public HttpResponseHandler() {
        this("UTF-8");
    }

    public void a() {
        if (this.executCallbackInChildThread) {
            onFinish();
        } else {
            sendMessage(obtainMessage(3));
        }
    }

    public void b() {
        if (this.executCallbackInChildThread) {
            onStart();
        } else {
            sendMessage(obtainMessage(2));
        }
    }

    public void c(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            onSuccess(i, bArr == null ? null : new String(bArr), hashMap);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            Object[] objArr = (Object[]) message.obj;
            a(((Integer) objArr[0]).intValue(), (HashMap) objArr[1], (byte[]) objArr[2]);
        } else if (i == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            a((Throwable) objArr2[0], (String) objArr2[1]);
        } else if (i == 2) {
            onStart();
        } else if (i != 3) {
        } else {
            onFinish();
        }
    }

    public void onFailure(Throwable th, String str) {
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(int i, String str) {
    }

    public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
        onSuccess(i, str);
    }

    public HttpResponseHandler(String str) {
        this.mDefaultCharset = str;
    }

    public HttpResponseHandler(Looper looper) {
        this(looper, false);
    }

    public void a(int i, HashMap<String, String> hashMap, byte[] bArr) {
        onSuccess(i, bArr == null ? null : new String(bArr), hashMap);
    }

    public void b(Throwable th, String str) {
        if (this.executCallbackInChildThread) {
            onFailure(th, str);
        } else {
            sendMessage(obtainMessage(1, new Object[]{th, str}));
        }
    }

    public HttpResponseHandler(Looper looper, boolean z) {
        super(looper);
        this.executCallbackInChildThread = z;
        this.mDefaultCharset = "UTF-8";
    }

    public void a(Throwable th, String str) {
        onFailure(th, str);
    }

    public void b(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (i == 200) {
            c(i, hashMap, bArr);
            return;
        }
        String str = bArr == null ? null : new String(bArr);
        b(new HttpErrorException(i, str), str);
    }
}
