package com.baidu.searchbox.config.eventmessage;
/* loaded from: classes13.dex */
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
        StringBuilder sb = new StringBuilder();
        sb.append("messageId=").append(this.messageId).append(" arg0=").append(this.arg0).append(" arg1=").append(this.arg1);
        return sb.toString();
    }
}
