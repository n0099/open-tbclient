package com.baidu.tbadk.core.voice;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements CustomMessageTask.CustomRunnable<Activity> {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<VoiceManager> run(CustomMessage<Activity> customMessage) {
        if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Activity)) {
            return null;
        }
        this.this$0.stopPlay();
        return new CustomResponsedMessage<>(2001280);
    }
}
