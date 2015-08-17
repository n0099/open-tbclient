package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class UninstallInquirerBySyncMessage extends CustomResponsedMessage<Boolean> {
    public UninstallInquirerBySyncMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_UNINSTALL_BY_SYNC, bool);
    }
}
