package com.baidu.tbadk;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.HashMap;
/* loaded from: classes.dex */
class c implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.frameworkData.a> {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.frameworkData.a> run(CustomMessage<com.baidu.tbadk.core.frameworkData.a> customMessage) {
        HashMap hashMap;
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tbadk.core.frameworkData.a data = customMessage.getData();
            hashMap = this.a.mActicyConfig;
            Class<?> cls = (Class) hashMap.get(data.getClass());
            if (cls != null) {
                data.getIntent().setClass(customMessage.getData().getContext(), cls);
                data.run();
            }
        }
        return null;
    }
}
