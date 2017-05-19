package com.baidu.audiorecorder.lib.voice;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
class o implements CustomMessageTask.CustomRunnable<Boolean> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_VOICE_RECORDER_AVAILABLE, Boolean.TRUE);
    }
}
