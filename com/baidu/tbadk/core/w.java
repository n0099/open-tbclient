package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ TbadkCoreApplication TP;
    private final /* synthetic */ boolean TS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbadkCoreApplication tbadkCoreApplication, boolean z) {
        this.TP = tbadkCoreApplication;
        this.TS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_EMOTION, new com.baidu.tbadk.mainTab.a(this.TS)));
    }
}
