package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class BackgroundSwitchMessage extends CustomResponsedMessage<Boolean> {
    public BackgroundSwitchMessage(Boolean bool) {
        super(MessageTypes.CMD_BACKGROUND_SWTICH, bool);
    }
}
