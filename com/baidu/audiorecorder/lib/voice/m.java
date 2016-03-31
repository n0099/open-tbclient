package com.baidu.audiorecorder.lib.voice;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements CustomMessageTask.CustomRunnable<Activity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.tbadkCore.voice.a> run(CustomMessage<Activity> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECORDER_MANAGER_INSTANCE, g.ol());
    }
}
