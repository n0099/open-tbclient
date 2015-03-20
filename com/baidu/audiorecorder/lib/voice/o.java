package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class o implements CustomMessageTask.CustomRunnable<Context> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.tbadkCore.voice.b> run(CustomMessage<Context> customMessage) {
        if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
            return null;
        }
        return new CustomResponsedMessage<>(2001279, u.Q(customMessage.getData()));
    }
}
