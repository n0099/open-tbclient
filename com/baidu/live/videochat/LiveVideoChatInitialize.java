package com.baidu.live.videochat;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes3.dex */
public class LiveVideoChatInitialize {
    static {
        Ij();
    }

    private static void Ij() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913144, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.live.videochat.LiveVideoChatInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2913144, new d(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913145, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.live.videochat.LiveVideoChatInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2913145, new c(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
