package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements CustomMessageTask.CustomRunnable<IntentConfig> {
    final /* synthetic */ TbadkCoreApplication Tw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbadkCoreApplication tbadkCoreApplication) {
        this.Tw = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
        HashMap hashMap;
        if (customMessage != null && customMessage.getData() != null) {
            IntentConfig data = customMessage.getData();
            hashMap = this.Tw.mActicyConfig;
            Class<?> cls = (Class) hashMap.get(data.getClass());
            if (cls != null) {
                data.setComponentClass(cls);
                data.run();
            }
        }
        return null;
    }
}
