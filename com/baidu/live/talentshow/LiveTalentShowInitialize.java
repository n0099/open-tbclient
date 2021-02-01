package com.baidu.live.talentshow;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.am.c;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class LiveTalentShowInitialize {
    static {
        RQ();
    }

    private static void RQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913254, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.talentshow.LiveTalentShowInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.am.b> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913254, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913255, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.talentshow.LiveTalentShowInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913255, new b(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
