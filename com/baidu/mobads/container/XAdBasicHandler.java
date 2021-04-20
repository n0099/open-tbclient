package com.baidu.mobads.container;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class XAdBasicHandler extends Handler {
    public OnMessageListener mOnMessageListener;

    /* loaded from: classes2.dex */
    public interface OnMessageListener {
        void onMessage(Message message);
    }

    public XAdBasicHandler(Looper looper, OnMessageListener onMessageListener) {
        super(looper);
        this.mOnMessageListener = onMessageListener;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        OnMessageListener onMessageListener = this.mOnMessageListener;
        if (onMessageListener != null) {
            onMessageListener.onMessage(message);
        }
    }
}
