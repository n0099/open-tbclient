package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes4.dex */
public class AlaSetPrivateResponseMessage extends JsonHttpResponsedMessage {
    public AlaSetPrivateResponseMessage() {
        super(1021047);
    }

    public boolean Nm() {
        if (getOrginalMessage() instanceof f) {
            return ((f) getOrginalMessage()).Nm();
        }
        return false;
    }

    public boolean isSwitchOpen() {
        if (getOrginalMessage() instanceof f) {
            return ((f) getOrginalMessage()).isSwitchOpen();
        }
        return false;
    }
}
