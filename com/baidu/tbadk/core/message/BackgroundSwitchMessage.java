package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class BackgroundSwitchMessage extends CustomResponsedMessage<Boolean> {
    public BackgroundSwitchMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_BACKGROUND_SWTICH, bool);
    }
}
