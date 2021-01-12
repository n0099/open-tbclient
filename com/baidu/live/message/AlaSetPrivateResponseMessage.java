package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes10.dex */
public class AlaSetPrivateResponseMessage extends JsonHttpResponsedMessage {
    public AlaSetPrivateResponseMessage() {
        super(1021047);
    }

    public boolean MU() {
        if (getOrginalMessage() instanceof g) {
            return ((g) getOrginalMessage()).MU();
        }
        return false;
    }

    public boolean isSwitchOpen() {
        if (getOrginalMessage() instanceof g) {
            return ((g) getOrginalMessage()).isSwitchOpen();
        }
        return false;
    }
}
