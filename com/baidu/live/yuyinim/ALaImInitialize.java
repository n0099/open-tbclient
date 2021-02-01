package com.baidu.live.yuyinim;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.im.k;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.view.b;
import com.baidu.live.yuyinim.view.ALALiveTextView;
/* loaded from: classes11.dex */
public class ALaImInitialize {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501044, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.yuyinim.ALaImInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.view.input.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2501044, new ALALiveTextView(customMessage.getData().getPageActivity(), customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2501045, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.yuyinim.ALaImInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2501045, new com.baidu.live.yuyinim.controller.a(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerListener(2501049, new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.ALaImInitialize.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.bSV.clear();
            }
        });
    }
}
