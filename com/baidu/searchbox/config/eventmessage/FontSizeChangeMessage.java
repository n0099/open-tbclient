package com.baidu.searchbox.config.eventmessage;
/* loaded from: classes12.dex */
public class FontSizeChangeMessage extends CommonEventMessage {
    public static final int MSG_ON_FONT_SIZE_CHANGED = 1;
    public Object messageContent;

    public FontSizeChangeMessage(int i, Object obj) {
        super(i);
        this.messageContent = obj;
    }

    @Override // com.baidu.searchbox.config.eventmessage.CommonEventMessage
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("messageId=").append(this.messageId).append(" messageContent=").append(this.messageContent.toString());
        return sb.toString();
    }
}
