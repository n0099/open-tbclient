package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.coloros.mcssdk.mode.CommandMessage;
/* loaded from: classes6.dex */
public class d extends HttpMessage {
    private int ajV;
    private int ajW;

    public d(int i, int i2) {
        super(1021047);
        this.ajV = i;
        this.ajW = i2;
        addParam("is_audio", i);
        addParam(CommandMessage.COMMAND, i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean um() {
        return this.ajV == 1;
    }

    public boolean isSwitchOpen() {
        return this.ajW == 1;
    }
}
