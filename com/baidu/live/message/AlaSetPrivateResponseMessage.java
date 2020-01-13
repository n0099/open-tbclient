package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes2.dex */
public class AlaSetPrivateResponseMessage extends JsonHttpResponsedMessage {
    public AlaSetPrivateResponseMessage() {
        super(1021047);
    }

    public boolean wz() {
        if (getOrginalMessage() instanceof f) {
            return ((f) getOrginalMessage()).wz();
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
