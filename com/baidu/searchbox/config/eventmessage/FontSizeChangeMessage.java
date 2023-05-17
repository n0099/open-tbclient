package com.baidu.searchbox.config.eventmessage;
/* loaded from: classes3.dex */
public class FontSizeChangeMessage {
    public static final int MSG_ON_FONT_SIZE_CHANGED = 1;
    public Object messageContent;
    public int messageId;

    public FontSizeChangeMessage(int i, Object obj) {
        this.messageId = i;
        this.messageContent = obj;
    }

    public String toString() {
        return "messageId=" + this.messageId + " messageContent=" + this.messageContent.toString();
    }
}
