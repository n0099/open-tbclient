package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements CustomMessageTask.CustomRunnable<IntentConfig> {
    final /* synthetic */ TbadkCoreApplication Tx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbadkCoreApplication tbadkCoreApplication) {
        this.Tx = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
        HashMap hashMap;
        HashMap hashMap2;
        if (customMessage != null && customMessage.getData() != null) {
            IntentConfig data = customMessage.getData();
            Class<?> intentClass = this.Tx.getIntentClass(data.getClass());
            hashMap = this.Tx.mActicyConfig;
            if (hashMap.get(AlbumActivityConfig.class) == null) {
                aq aqVar = new aq("inter_config_disappear");
                hashMap2 = this.Tx.mActicyConfig;
                TiebaStatic.log(aqVar.r("obj_param1", hashMap2.size()));
            }
            if (intentClass != null) {
                data.setComponentClass(intentClass);
                data.run();
            }
        }
        return null;
    }
}
