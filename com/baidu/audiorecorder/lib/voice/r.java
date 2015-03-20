package com.baidu.audiorecorder.lib.voice;

import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.chat.av;
/* loaded from: classes.dex */
class r implements CustomMessageTask.CustomRunnable<ViewGroup> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<av> run(CustomMessage<ViewGroup> customMessage) {
        if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof ViewGroup)) {
            return null;
        }
        return new CustomResponsedMessage<>(2001307, new FloatRecordView(customMessage.getData()));
    }
}
