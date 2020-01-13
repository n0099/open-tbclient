package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class f extends HttpMessage {
    private int aso;
    private int asp;

    public f(int i, int i2) {
        super(1021047);
        this.aso = i;
        this.asp = i2;
        addParam("is_audio", i);
        addParam("command", i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean wz() {
        return this.aso == 1;
    }

    public boolean isSwitchOpen() {
        return this.asp == 1;
    }
}
