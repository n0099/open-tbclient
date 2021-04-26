package com.baidu.ala.liveForum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class LiveBarCheckTaskStatic implements CustomMessageTask.CustomRunnable<Long> {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2911007, new LiveBarCheckTaskStatic());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public CustomResponsedMessage<Boolean> commitResult(int i2, boolean z) {
        return new CustomResponsedMessage<>(i2, Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Long> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return commitResult(customMessage.getCmd(), TbSingleton.getInstance().checkLiveForumByFid(customMessage.getData().longValue()));
    }
}
