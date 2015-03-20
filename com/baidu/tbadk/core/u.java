package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ TbadkCoreApplication Ox;
    private final /* synthetic */ boolean Oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbadkCoreApplication tbadkCoreApplication, boolean z) {
        this.Ox = tbadkCoreApplication;
        this.Oz = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(this.Oz)));
    }
}
