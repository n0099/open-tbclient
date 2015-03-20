package com.baidu.audiorecorder.lib.voice;

import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.chat.aw;
/* loaded from: classes.dex */
class s implements CustomMessageTask.CustomRunnable<ViewGroup> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<aw> run(CustomMessage<ViewGroup> customMessage) {
        if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof ViewGroup)) {
            return null;
        }
        return new CustomResponsedMessage<>(2001308, new SendVoiceView(customMessage.getData()));
    }
}
