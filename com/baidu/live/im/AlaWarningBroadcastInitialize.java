package com.baidu.live.im;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes11.dex */
public class AlaWarningBroadcastInitialize {
    static {
        Mk();
    }

    private static void Mk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913269, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.im.AlaWarningBroadcastInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913269, new com.baidu.live.im.c.b(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
