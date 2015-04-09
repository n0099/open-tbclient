package com.baidu.tbadk.core;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.frameworkData.a> {
    final /* synthetic */ TbadkCoreApplication Oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbadkCoreApplication tbadkCoreApplication) {
        this.Oz = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.frameworkData.a> run(CustomMessage<com.baidu.tbadk.core.frameworkData.a> customMessage) {
        HashMap hashMap;
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tbadk.core.frameworkData.a data = customMessage.getData();
            hashMap = this.Oz.mActicyConfig;
            Class<?> cls = (Class) hashMap.get(data.getClass());
            if (cls != null) {
                data.getIntent().setClass(customMessage.getData().getContext(), cls);
                data.run();
            }
        }
        return null;
    }
}
