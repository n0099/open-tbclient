package com.baidu.live.noble;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.noble.b.c;
import com.baidu.live.noble.b.d;
/* loaded from: classes11.dex */
public class NobleInitialize {
    static {
        OL();
        OM();
    }

    private static void OL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913198, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.noble.NobleInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913198, new c());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void OM() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913204, new CustomMessageTask.CustomRunnable<com.baidu.live.noble.data.c>() { // from class: com.baidu.live.noble.NobleInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.live.noble.data.c> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof com.baidu.live.noble.data.c)) {
                    return null;
                }
                com.baidu.live.noble.data.c data = customMessage.getData();
                d dVar = new d();
                dVar.a(data.mTbPageContext, data.mLiveId, data.buH, data.aNa, data.mTabId, data.mIsHost);
                return new CustomResponsedMessage<>(2913204, dVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
