package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class Static {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001275, new w());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
