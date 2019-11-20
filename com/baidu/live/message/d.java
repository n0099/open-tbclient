package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.coloros.mcssdk.mode.CommandMessage;
/* loaded from: classes6.dex */
public class d extends HttpMessage {
    private int ajD;
    private int ajE;

    public d(int i, int i2) {
        super(1021047);
        this.ajD = i;
        this.ajE = i2;
        addParam("is_audio", i);
        addParam(CommandMessage.COMMAND, i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean un() {
        return this.ajD == 1;
    }

    public boolean isSwitchOpen() {
        return this.ajE == 1;
    }
}
