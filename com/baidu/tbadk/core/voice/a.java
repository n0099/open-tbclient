package com.baidu.tbadk.core.voice;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(VoiceManager voiceManager, int i) {
        super(i);
        this.this$0 = voiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Boolean bool;
        Boolean isSpeakerphone;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001273) {
            this.this$0.stopPlay();
            if ((customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                VoiceManager voiceManager = this.this$0;
                isSpeakerphone = this.this$0.isSpeakerphone();
                voiceManager.bSpeaker = isSpeakerphone;
                this.this$0.setSpeakerphone(false);
            }
        }
    }
}
