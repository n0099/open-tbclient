package com.baidu.live.im.data;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class ImSendMsgData implements Serializable {
    public b barrageCardInfo;
    public String barrageId;
    public short msgType;
    public long price;
    public String text;

    public ImSendMsgData(String str) {
        this(str, (short) 1);
    }

    public ImSendMsgData(String str, short s) {
        this.text = str;
        this.msgType = s;
    }
}
