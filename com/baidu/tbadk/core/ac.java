package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    private final /* synthetic */ boolean SW;
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TbadkCoreApplication tbadkCoreApplication, boolean z) {
        this.this$0 = tbadkCoreApplication;
        this.SW = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_EMOTION, new com.baidu.tbadk.mainTab.a(this.SW)));
    }
}
