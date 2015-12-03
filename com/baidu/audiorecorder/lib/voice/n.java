package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class n implements CustomMessageTask.CustomRunnable<Context> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.editortools.y> run(CustomMessage<Context> customMessage) {
        if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, new com.baidu.audiorecorder.a.b(customMessage.getData()));
    }
}
