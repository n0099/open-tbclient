package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class f extends HttpMessage {
    private int awA;
    private int awz;

    public f(int i, int i2) {
        super(1021047);
        this.awz = i;
        this.awA = i2;
        addParam("is_audio", i);
        addParam("command", i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean yR() {
        return this.awz == 1;
    }

    public boolean isSwitchOpen() {
        return this.awA == 1;
    }
}
