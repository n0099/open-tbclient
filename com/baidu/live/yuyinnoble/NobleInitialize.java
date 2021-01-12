package com.baidu.live.yuyinnoble;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.noble.data.e;
import com.baidu.live.yuyinnoble.b.a;
import com.baidu.live.yuyinnoble.b.b;
/* loaded from: classes10.dex */
public class NobleInitialize {
    static {
        Nm();
        Nn();
    }

    private static void Nm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501035, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.yuyinnoble.NobleInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2501035, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Nn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501013, new CustomMessageTask.CustomRunnable<e>() { // from class: com.baidu.live.yuyinnoble.NobleInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<e> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof e)) {
                    return null;
                }
                e data = customMessage.getData();
                b bVar = new b();
                bVar.bY(data.bsO);
                bVar.a(data.mTbPageContext, data.mLiveId, data.bre, data.aKn, data.mTabId, data.mIsHost);
                return new CustomResponsedMessage<>(2501013, bVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
