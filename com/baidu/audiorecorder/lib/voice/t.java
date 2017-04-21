package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s LP;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a LQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.LP = sVar;
        this.LQ = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.LP.mt();
        if (this.LP.getVoiceManager() != null && this.LP.mModel != null) {
            if (this.LQ != null) {
                this.LQ.bz(this.LP.mModel.voiceId);
            }
            this.LP.mModel = null;
        }
    }
}
