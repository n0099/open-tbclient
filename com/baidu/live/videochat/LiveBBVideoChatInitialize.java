package com.baidu.live.videochat;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class LiveBBVideoChatInitialize {
    static {
        Wa();
    }

    private static void Wa() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913249, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.videochat.LiveBBVideoChatInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.al.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913249, new c(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
