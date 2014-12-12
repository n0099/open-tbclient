package com.baidu.tbadk.core;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements CustomMessageTask.CustomRunnable<Intent> {
    final /* synthetic */ TbadkCoreApplication CR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbadkCoreApplication tbadkCoreApplication) {
        this.CR = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
        UtilHelper.commenDealIntent(this.CR.getApp(), customMessage.getData());
        return null;
    }
}
