package com.baidu.tbadk.core.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateMaskInfo.DataReq;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReqIdl;
/* loaded from: classes3.dex */
public class RequestUpdateMaskInfoMessage extends TbSocketMessage {
    public static final int FALSE = 0;
    public static final int SWITCH_PRIVATE_CHAT_SINGLE = 9;
    public static final int TBR_RECEVIER_MSG_CALL_FROM_MESSAGE = 1;
    public static final int TBR_RECEVIER_MSG_CALL_FROM_PERSONAL = 2;
    public static final int TBR_RECEVIER_MSG_CALL_FROM_SETTING = 5;
    public static final int TRUE = 1;
    public int call_from;
    public long g_id;
    public int isMask;
    public String list;
    public int maskType;

    public RequestUpdateMaskInfoMessage() {
        super(104102);
        this.call_from = 1;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = Integer.valueOf(this.maskType);
        builder.isMask = Integer.valueOf(this.isMask);
        builder.list = this.list;
        builder.g_id = Long.valueOf(this.g_id);
        builder.call_from = Integer.valueOf(this.call_from);
        UpdateMaskInfoReqIdl.Builder builder2 = new UpdateMaskInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getCallFrom() {
        return this.call_from;
    }

    public long getG_id() {
        return this.g_id;
    }

    public int getIsMask() {
        return this.isMask;
    }

    public String getList() {
        return this.list;
    }

    public int getMaskType() {
        return this.maskType;
    }

    public boolean isMask() {
        return this.isMask == 1;
    }

    public boolean isSettingMask() {
        return this.isMask != 1;
    }

    public void setCallFrom(int i) {
        this.call_from = i;
    }

    public void setG_id(long j) {
        this.g_id = j;
    }

    public void setIsMask(int i) {
        this.isMask = i;
    }

    public void setList(String str) {
        this.list = str;
    }

    public void setMask(boolean z) {
        this.isMask = z ? 1 : 0;
    }

    public void setMaskType(int i) {
        this.maskType = i;
    }

    public void setSettingMask(boolean z) {
        this.isMask = !z ? 1 : 0;
    }
}
