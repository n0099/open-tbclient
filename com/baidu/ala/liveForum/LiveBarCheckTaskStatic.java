package com.baidu.ala.liveForum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes9.dex */
public class LiveBarCheckTaskStatic implements CustomMessageTask.CustomRunnable<Long> {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, new LiveBarCheckTaskStatic());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Long> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return commitResult(customMessage.getCmd(), TbSingleton.getInstance().checkLiveForumByFid(customMessage.getData().longValue()));
    }

    CustomResponsedMessage<Boolean> commitResult(int i, boolean z) {
        return new CustomResponsedMessage<>(i, Boolean.valueOf(z));
    }
}
