package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class ExitAppMessage extends CustomResponsedMessage<Integer> {
    public ExitAppMessage() {
        super(CmdConfigCustom.CMD_EXIT_APP);
    }
}
