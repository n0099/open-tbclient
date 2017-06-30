package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements CustomMessageTask.CustomRunnable<IntentConfig> {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            IntentConfig data = customMessage.getData();
            if (!data.asynStart()) {
                Class<?> intentClass = this.this$0.getIntentClass(data.getClass());
                if (this.this$0.getIntentClass(AlbumActivityConfig.class) == null) {
                    TiebaStatic.log(new au("inter_config_disappear").r("obj_param1", aq.vs().vt()));
                }
                if (intentClass != null) {
                    data.setComponentClass(intentClass);
                    data.run();
                }
            }
        }
        return null;
    }
}
