package com.baidu.android.imsdk.request;
/* loaded from: classes.dex */
public class AckMessage {
    public static final int RETRY_ACK = 1;

    public static android.os.Message getSendMessage(int i, Object obj) {
        android.os.Message message = new android.os.Message();
        message.what = i;
        message.obj = obj;
        return message;
    }
}
