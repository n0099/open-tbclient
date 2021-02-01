package com.baidu.live.yuyinbarrage;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinbarrage.a.a;
import com.baidu.live.yuyinbarrage.view.ImBarrageItemView;
import com.baidu.live.yuyinbarrage.view.ImBarrageOptionListView;
/* loaded from: classes11.dex */
public class ALaBarrageInitialize {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501050, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.yuyinbarrage.ALaBarrageInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2501050, new ImBarrageOptionListView(customMessage.getData().getPageActivity()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2501051, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.yuyinbarrage.ALaBarrageInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2501051, new ImBarrageItemView(customMessage.getData().getPageActivity()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2501052, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.yuyinbarrage.ALaBarrageInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2501052, new a(customMessage.getData()));
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }
}
