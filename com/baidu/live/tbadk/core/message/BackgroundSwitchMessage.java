package com.baidu.live.tbadk.core.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes3.dex */
public class BackgroundSwitchMessage extends CustomResponsedMessage<Boolean> {
    public BackgroundSwitchMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_BACKGROUND_SWTICH, bool);
    }
}
