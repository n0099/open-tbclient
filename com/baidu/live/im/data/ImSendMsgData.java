package com.baidu.live.im.data;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class ImSendMsgData implements Serializable {
    public b barrageCardInfo;
    public String barrageId;
    public int barrageType;
    public boolean isQuick;
    public short msgType;
    public long price;
    public String text;

    public ImSendMsgData(String str) {
        this(str, (short) 1);
    }

    public ImSendMsgData(String str, short s) {
        this.isQuick = false;
        this.text = str;
        this.msgType = s;
    }
}
