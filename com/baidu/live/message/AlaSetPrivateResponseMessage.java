package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes4.dex */
public class AlaSetPrivateResponseMessage extends JsonHttpResponsedMessage {
    public AlaSetPrivateResponseMessage() {
        super(1021047);
    }

    public boolean NG() {
        if (getOrginalMessage() instanceof g) {
            return ((g) getOrginalMessage()).NG();
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
