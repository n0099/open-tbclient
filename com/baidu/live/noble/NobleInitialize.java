package com.baidu.live.noble;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.c;
/* loaded from: classes4.dex */
public class NobleInitialize {
    static {
        Ga();
        Gb();
    }

    private static void Ga() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913198, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.noble.NobleInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913198, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Gb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913204, new CustomMessageTask.CustomRunnable<c>() { // from class: com.baidu.live.noble.NobleInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof c)) {
                    return null;
                }
                c data = customMessage.getData();
                com.baidu.live.noble.b.c cVar = new com.baidu.live.noble.b.c();
                cVar.a(data.mTbPageContext, data.mLiveId, data.aYY, data.aBY, data.mTabId, data.mIsHost);
                return new CustomResponsedMessage<>(2913204, cVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
