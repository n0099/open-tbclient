package com.baidu.audiorecorder.lib.voice;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<Boolean> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
        return new CustomResponsedMessage<>(2001281, Boolean.TRUE);
    }
}
