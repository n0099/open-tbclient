package com.baidu.searchbox.config.eventmessage;
/* loaded from: classes2.dex */
public class CommonEventMessage {
    public static final int MSG_INVALID = -1;
    public int arg0;
    public int arg1;
    public int messageId;
    public Object obj;

    public CommonEventMessage(int i) {
        this.messageId = i;
    }

    public String toString() {
        return "messageId=" + this.messageId + " arg0=" + this.arg0 + " arg1=" + this.arg1;
    }
}
