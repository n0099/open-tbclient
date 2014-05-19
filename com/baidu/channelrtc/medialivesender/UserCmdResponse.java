package com.baidu.channelrtc.medialivesender;
/* loaded from: classes.dex */
public class UserCmdResponse {
    private int callID;
    private String extraData;
    private String response;

    public int getCallID() {
        return this.callID;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public String getResponse() {
        return this.response;
    }

    public void setCallID(int i) {
        this.callID = i;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public String toString() {
        return "UserCmdResponse [callID=" + this.callID + ", extraData=" + this.extraData + ", response=" + this.response + "]";
    }
}
