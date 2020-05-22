package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class f extends HttpMessage {
    private int aWE;
    private int mCommand;

    public f(int i, int i2) {
        super(1021047);
        this.aWE = i;
        this.mCommand = i2;
        addParam("is_audio", i);
        addParam("command", i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean Fn() {
        return this.aWE == 1;
    }

    public boolean isSwitchOpen() {
        return this.mCommand == 1;
    }
}
