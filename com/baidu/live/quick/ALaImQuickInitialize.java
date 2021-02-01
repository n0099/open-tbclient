package com.baidu.live.quick;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class ALaImQuickInitialize {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913163, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.quick.ALaImQuickInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913163, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913217, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.quick.ALaImQuickInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913217, new QuickImInputPanelView(customMessage.getData().getPageActivity()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2913218, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.quick.ALaImQuickInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913218, new QuickImInputHeaderView(customMessage.getData().getPageActivity()));
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }
}
