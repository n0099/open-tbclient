package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class BackgroundSwitchMessage extends CustomResponsedMessage<Boolean> {
    public BackgroundSwitchMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_BACKGROUND_SWTICH, bool);
    }
}
