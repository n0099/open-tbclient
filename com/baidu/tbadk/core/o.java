package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.data.n> {
    final /* synthetic */ TbadkCoreApplication Ty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbadkCoreApplication tbadkCoreApplication) {
        this.Ty = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.data.n> customMessage) {
        UtilHelper.showYYNotification(this.Ty.getContext(), customMessage.getData(), 13);
        return null;
    }
}
