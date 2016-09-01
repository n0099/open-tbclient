package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s FK;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a FL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.FK = sVar;
        this.FL = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.FK.lA();
        if (this.FK.getVoiceManager() != null && this.FK.mModel != null) {
            if (this.FL != null) {
                this.FL.bM(this.FK.mModel.voiceId);
            }
            this.FK.mModel = null;
        }
    }
}
