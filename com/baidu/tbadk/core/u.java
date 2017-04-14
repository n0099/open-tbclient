package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements CustomMessageTask.CustomRunnable<an> {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<an> customMessage) {
        UtilHelper.showYYNotification(this.this$0.getContext(), customMessage.getData(), 13);
        return null;
    }
}
