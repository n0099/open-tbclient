package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes6.dex */
public class AlaSetPrivateResponseMessage extends JsonHttpResponsedMessage {
    public AlaSetPrivateResponseMessage() {
        super(1021047);
    }

    public boolean um() {
        if (getOrginalMessage() instanceof d) {
            return ((d) getOrginalMessage()).um();
        }
        return false;
    }

    public boolean isSwitchOpen() {
        if (getOrginalMessage() instanceof d) {
            return ((d) getOrginalMessage()).isSwitchOpen();
        }
        return false;
    }
}
