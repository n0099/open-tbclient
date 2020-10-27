package com.baidu.live.im;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class ALaImInitialize {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913003, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.im.ALaImInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.view.input.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913003, new ALALiveTextView(customMessage.getData().getPageActivity(), customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913039, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.im.ALaImInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913039, new com.baidu.live.im.c.a(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerListener(2913040, new CustomMessageListener(0) { // from class: com.baidu.live.im.ALaImInitialize.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.bmb != null) {
                        aVar.a(new e(aVar.bmb.context, aVar.bmb.bmd));
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(2913084, new CustomMessageListener(0) { // from class: com.baidu.live.im.ALaImInitialize.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.live.view.c.bFL.clear();
            }
        });
    }
}
