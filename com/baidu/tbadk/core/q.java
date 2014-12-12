package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ TbadkCoreApplication CR;
    private final /* synthetic */ boolean CS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbadkCoreApplication tbadkCoreApplication, boolean z) {
        this.CR = tbadkCoreApplication;
        this.CS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(this.CS)));
    }
}
