package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ TbadkCoreApplication OW;
    private final /* synthetic */ boolean OY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbadkCoreApplication tbadkCoreApplication, boolean z) {
        this.OW = tbadkCoreApplication;
        this.OY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(this.OY)));
    }
}
