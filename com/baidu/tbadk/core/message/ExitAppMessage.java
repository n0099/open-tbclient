package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class ExitAppMessage extends CustomResponsedMessage<Integer> {
    public ExitAppMessage() {
        super(MessageTypes.CMD_EXIT_APP);
    }
}
