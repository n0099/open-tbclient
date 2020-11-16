package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class g extends HttpMessage {
    private int mCommand;
    private int mIsAudio;

    public g(int i, int i2) {
        super(1021047);
        this.mIsAudio = i;
        this.mCommand = i2;
        addParam("is_audio", i);
        addParam("command", i2);
        addParam("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public boolean Nx() {
        return this.mIsAudio == 1;
    }

    public boolean isSwitchOpen() {
        return this.mCommand == 1;
    }
}
