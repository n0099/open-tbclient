package com.baidu.live.im.data;

import java.io.Serializable;
/* loaded from: classes10.dex */
public class ImSendMsgData implements Serializable {
    public d barrageCardInfo;
    public String barrageId;
    public int barrageType;
    public boolean isOut;
    public boolean isQuick;
    public boolean isQuickBarrage;
    public short msgType;
    public long price;
    public String text;

    public ImSendMsgData(String str) {
        this(str, (short) 1);
    }

    public ImSendMsgData(String str, short s) {
        this.isQuick = false;
        this.isOut = false;
        this.isQuickBarrage = false;
        this.text = str;
        this.msgType = s;
    }
}
