package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class f extends HttpMessage {
    private int awK;
    private int awL;

    public f(int i, int i2) {
        super(1021047);
        this.awK = i;
        this.awL = i2;
        addParam("is_audio", i);
        addParam("command", i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean yW() {
        return this.awK == 1;
    }

    public boolean isSwitchOpen() {
        return this.awL == 1;
    }
}
