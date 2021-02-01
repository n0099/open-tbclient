package com.baidu.live.barrage;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.barrage.a.a;
import com.baidu.live.barrage.a.b;
import com.baidu.live.barrage.view.ImBarrageItemView;
import com.baidu.live.barrage.view.ImBarrageOptionListView;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class ALaBarrageInitialize {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913216, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.barrage.ALaBarrageInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913216, new ImBarrageOptionListView(customMessage.getData().getPageActivity()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913215, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.barrage.ALaBarrageInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913215, new ImBarrageItemView(customMessage.getData().getPageActivity()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2913099, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.barrage.ALaBarrageInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913099, new a(customMessage.getData()));
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2913164, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.barrage.ALaBarrageInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913164, new b(customMessage.getData()));
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }
}
