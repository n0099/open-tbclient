package com.baidu.tbadk.core.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateMaskInfo.DataReq;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReqIdl;
/* loaded from: classes.dex */
public class RequestUpdateMaskInfoMessage extends TbSocketMessage {
    private static final int FALSE = 0;
    public static final int SWITCH_ALL = 14;
    public static final int SWITCH_AT_ME = 2;
    public static final int SWITCH_FANS = 3;
    public static final int SWITCH_GROUP_MSG = 4;
    public static final int SWITCH_PRIVATE_CHAT_SINGLE = 9;
    public static final int SWITCH_PRIVATE_MSG = 5;
    public static final int SWITCH_REPLY_ME = 1;
    public static final int SWITCH_STRANGER_MSG = 23;
    public static final int SWITCH_YY_MSG = 6;
    public static final int SWITCH_ZAN = 13;
    private static final int TRUE = 1;
    private int isMask;
    private String list;
    private int maskType;

    public RequestUpdateMaskInfoMessage() {
        super(104102);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = Integer.valueOf(this.maskType);
        builder.isMask = Integer.valueOf(this.isMask);
        builder.list = this.list;
        UpdateMaskInfoReqIdl.Builder builder2 = new UpdateMaskInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getMaskType() {
        return this.maskType;
    }

    public void setMaskType(int i) {
        this.maskType = i;
    }

    public int getIsMask() {
        return this.isMask;
    }

    public void setIsMask(int i) {
        this.isMask = i;
    }

    public void setMask(boolean z) {
        this.isMask = z ? 1 : 0;
    }

    public void setSettingMask(boolean z) {
        this.isMask = !z ? 1 : 0;
    }

    public boolean isMask() {
        return this.isMask == 1;
    }

    public boolean isSettingMask() {
        return this.isMask != 1;
    }

    public String getList() {
        return this.list;
    }

    public void setList(String str) {
        this.list = str;
    }
}
