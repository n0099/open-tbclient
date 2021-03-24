package com.baidu.down.loopj.android.http;

import android.os.Message;
/* loaded from: classes2.dex */
public class AsyncHttpResponseHandler {
    public static final int DOWNLOAD_MESSAGE = 4;
    public static final int FAILURE_MESSAGE = 1;
    public static final int FILELENGTH_MESSAGE = 6;
    public static final int FINISH_MESSAGE = 3;
    public static final int PAUSED_MESSAGE = 5;
    public static final int START_MESSAGE = 2;
    public static final int SUCCESS_MESSAGE = 0;
    public boolean mRunning = true;
    public boolean mSupportRange = true;
    public boolean mTrunked = false;

    public void handleFailureMessage(Throwable th, String str, int i) {
        onFailure(th, str, i);
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            Object[] objArr = (Object[]) message.obj;
            handleSuccessMessage(((Integer) objArr[0]).intValue(), (String) objArr[2]);
        } else if (i != 1) {
            if (i == 2) {
                onStart();
            } else if (i != 3) {
            } else {
                onFinish();
            }
        } else {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2[0] != null && objArr2[1] != null) {
                handleFailureMessage((Throwable) objArr2[0], objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
            } else if (objArr2[1] == null) {
                handleFailureMessage((Throwable) objArr2[0], "error", ((Integer) objArr2[2]).intValue());
            } else if (objArr2[0] == null) {
                handleFailureMessage(null, objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
            } else {
                handleFailureMessage(null, "error", ((Integer) objArr2[2]).intValue());
            }
        }
    }

    public void handleSuccessMessage(int i, String str) {
        onSuccess(i, str);
    }

    public Message obtainMessage(int i, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    public void onDownload(String str) {
    }

    public void onFailure(Throwable th, int i) {
    }

    public void onFailure(Throwable th, String str, int i) {
        onFailure(th, i);
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(int i, String str) {
        onSuccess(str);
    }

    public void onSuccess(String str) {
    }

    public void sendFailureMessage(Throwable th, String str) {
        sendMessage(obtainMessage(1, new Object[]{th, str}));
    }

    public void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    public void sendMessage(Message message) {
        handleMessage(message);
    }

    public void sendPausedMessage() {
        sendMessage(obtainMessage(5, null));
    }

    public void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    public void sendSuccessMessage(int i, String str, long j) {
        sendMessage(obtainMessage(0, new Object[]{new Integer(i), str, Long.valueOf(j)}));
    }

    public void sendFailureMessage(Throwable th, byte[] bArr, int i) {
        sendMessage(obtainMessage(1, new Object[]{th, bArr, Integer.valueOf(i)}));
    }
}
