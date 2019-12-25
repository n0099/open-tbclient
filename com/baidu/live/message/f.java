package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class f extends HttpMessage {
    private int arC;
    private int arD;

    public f(int i, int i2) {
        super(1021047);
        this.arC = i;
        this.arD = i2;
        addParam("is_audio", i);
        addParam("command", i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean wi() {
        return this.arC == 1;
    }

    public boolean isSwitchOpen() {
        return this.arD == 1;
    }
}
