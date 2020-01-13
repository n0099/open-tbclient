package com.baidu.down.loopj.android.http;

import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes5.dex */
public class AsyncHttpResponseHandler {
    protected static final int DOWNLOAD_MESSAGE = 4;
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FILELENGTH_MESSAGE = 6;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int PAUSED_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public boolean mRunning = true;
    public boolean mSupportRange = true;
    public boolean mTrunked = false;

    public void onStart() {
    }

    public void onFinish() {
    }

    public void onSuccess(String str) {
    }

    public void onSuccess(int i, String str) {
        onSuccess(str);
    }

    public void onFailure(Throwable th, int i) {
    }

    public void onFailure(Throwable th, String str, int i) {
        onFailure(th, i);
    }

    public void onDownload(String str) {
    }

    protected void sendSuccessMessage(int i, String str, long j) {
        sendMessage(obtainMessage(0, new Object[]{new Integer(i), str, Long.valueOf(j)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFailureMessage(Throwable th, String str) {
        sendMessage(obtainMessage(1, new Object[]{th, str}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFailureMessage(Throwable th, byte[] bArr, int i) {
        sendMessage(obtainMessage(1, new Object[]{th, bArr, Integer.valueOf(i)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendPausedMessage() {
        sendMessage(obtainMessage(5, null));
    }

    protected void handleSuccessMessage(int i, String str) {
        onSuccess(i, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleFailureMessage(Throwable th, String str, int i) {
        onFailure(th, str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (String) objArr[2]);
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                if (objArr2[0] != null && objArr2[1] != null) {
                    handleFailureMessage((Throwable) objArr2[0], objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
                    return;
                } else if (objArr2[1] == null) {
                    handleFailureMessage((Throwable) objArr2[0], BdStatsConstant.StatsType.ERROR, ((Integer) objArr2[2]).intValue());
                    return;
                } else if (objArr2[0] == null) {
                    handleFailureMessage(null, objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
                    return;
                } else {
                    handleFailureMessage(null, BdStatsConstant.StatsType.ERROR, ((Integer) objArr2[2]).intValue());
                    return;
                }
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessage(Message message) {
        handleMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message obtainMessage(int i, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }
}
