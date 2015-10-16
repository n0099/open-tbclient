package com.baidu.tbadk.core;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements CustomMessageTask.CustomRunnable<Intent> {
    final /* synthetic */ TbadkCoreApplication Tx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TbadkCoreApplication tbadkCoreApplication) {
        this.Tx = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
        UtilHelper.commenDealIntent(this.Tx.getApp(), customMessage.getData());
        return null;
    }
}
