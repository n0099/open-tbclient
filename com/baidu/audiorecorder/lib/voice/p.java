package com.baidu.audiorecorder.lib.voice;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.audiorecorder.lib.voice.RecorderManagerStatic;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<Void> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_VOICE_RECORDER_RES_TOOL, new RecorderManagerStatic.a());
    }
}
