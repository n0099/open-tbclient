package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.data.o> {
    final /* synthetic */ TbadkCoreApplication TJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TbadkCoreApplication tbadkCoreApplication) {
        this.TJ = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.data.o> customMessage) {
        UtilHelper.showYYNotification(this.TJ.getContext(), customMessage.getData(), 13);
        return null;
    }
}
