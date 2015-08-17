package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PassV6ExceptionStatic {
    static {
        MessageManager.getInstance().registerListener(new y(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
