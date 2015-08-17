package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements CustomMessageTask.CustomRunnable<IntentConfig> {
    final /* synthetic */ TbadkCoreApplication TJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbadkCoreApplication tbadkCoreApplication) {
        this.TJ = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
        HashMap hashMap;
        if (customMessage != null && customMessage.getData() != null) {
            IntentConfig data = customMessage.getData();
            hashMap = this.TJ.mActicyConfig;
            Class<?> cls = (Class) hashMap.get(data.getClass());
            if (cls != null) {
                data.setComponentClass(cls);
                data.run();
            }
        }
        return null;
    }
}
