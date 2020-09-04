package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class f extends HttpMessage {
    private int beI;
    private int mCommand;

    public f(int i, int i2) {
        super(1021047);
        this.beI = i;
        this.mCommand = i2;
        addParam("is_audio", i);
        addParam("command", i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean LG() {
        return this.beI == 1;
    }

    public boolean isSwitchOpen() {
        return this.mCommand == 1;
    }
}
